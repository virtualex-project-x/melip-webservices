package com.melip.webservices.service.layout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.melip.common.constants.CodeConstants;
import com.melip.common.dto.screen.ScreenDto;
import com.melip.common.dto.screen.ScreenObjBunchDto;
import com.melip.common.dto.screen.ScreenObjDto;
import com.melip.common.dto.screen.ScreenObjGrpDto;
import com.melip.webservices.common.BeanCreator;
import com.melip.webservices.dto.FacilityDto;
import com.melip.webservices.dto.LayoutScreenDto;
import com.melip.webservices.dto.RegionDto;
import com.melip.webservices.service.common.AbstractService;
import com.melip.webservices.service.facility.IFacilityService;
import com.melip.webservices.service.region.IRegionService;

/**
 * レイアウトのサービスクラスです。
 */
public class LayoutService extends AbstractService implements ILayoutService {

  /** レイアウト・スクリーン情報取得SQL_ID */
  private String selectLayoutScreenSqlId;

  /**
   * @see com.melip.webservices.service.layout.ILayoutService#getScreenDto(java.lang.String,
   *      java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer)
   */
  @Override
  public ScreenDto getScreenDto(String langDiv, Integer screenObjId, Integer regionId,
      Integer facilityId, Integer facilityGrpId) {

    LayoutSearchCondition condition = new LayoutSearchCondition();
    condition.setLangDiv(langDiv);
    condition.setScreenObjId(screenObjId);
    List<LayoutScreenDto> layoutScreenDtoList =
        getSession().selectList(getSelectLayoutScreenSqlId(), condition);
    return createScreenDto(langDiv, regionId, facilityId, facilityGrpId, layoutScreenDtoList);
  }

  /**
   * レイアウト・スクリーン情報を元にスクリーンDTOを生成します。
   * 
   * @param langDiv 言語区分
   * @param regionId 地域ID
   * @param facilityId 施設ID
   * @param facilityGrpId 施設グループID
   * @param layoutScreenDtoList レイアウト・スクリーン情報リスト
   * @return スクリーンDTO
   */
  private ScreenDto createScreenDto(String langDiv, Integer regionId, Integer facilityId,
      Integer facilityGrpId, List<LayoutScreenDto> layoutScreenDtoList) {

    ScreenDto screenDto = new ScreenDto();
    LayoutScreenDto commonLayoutScreenDto = layoutScreenDtoList.get(0);
    screenDto.setLayoutId(commonLayoutScreenDto.getLayout().getLayoutId());
    screenDto.setLayoutAlias(commonLayoutScreenDto.getLayout().getAlias());
    screenDto.setScreenId(commonLayoutScreenDto.getScreen().getScreenId());
    screenDto.setScreenObjGrpDtoList(new ArrayList<ScreenObjGrpDto>());

    // 作業用マップ
    Map<Integer, ScreenObjGrpDto> screenObjGrpDtoMap = new HashMap<Integer, ScreenObjGrpDto>();
    Map<String, ScreenObjBunchDto> facilityScreenObjBunchDtoMap =
        new HashMap<String, ScreenObjBunchDto>();

    for (LayoutScreenDto layoutScreenDto : layoutScreenDtoList) {
      Integer layoutObjGrpId = layoutScreenDto.getLayoutObjGrp().getLayoutObjGrpId();
      String layoutObjGrpAlias = layoutScreenDto.getLayoutObjGrp().getAlias();
      ScreenObjGrpDto screenObjGrpDto = null;
      if (screenObjGrpDtoMap.containsKey(layoutObjGrpId)) {
        screenObjGrpDto = screenObjGrpDtoMap.get(layoutObjGrpId);
      } else {
        screenObjGrpDto = new ScreenObjGrpDto();
        screenObjGrpDto.setLayoutObjGrpId(layoutObjGrpId);
        screenObjGrpDto.setLayoutObjGrpAlias(layoutObjGrpAlias);
        screenObjGrpDto.setMultiplicity(layoutScreenDto.getLayoutObjGrp().getMultiplicity());
        screenObjGrpDto.setScreenObjBunchDtoList(new ArrayList<ScreenObjBunchDto>());
        screenObjGrpDtoMap.put(layoutObjGrpId, screenObjGrpDto);
        screenDto.getScreenObjGrpDtoList().add(screenObjGrpDto);
      }

      Integer layoutObjId = layoutScreenDto.getLayoutObj().getLayoutObjId();
      String layoutObjAlias = layoutScreenDto.getLayoutObj().getAlias();
      String layoutObjType = layoutScreenDto.getLayoutObj().getType();
      Integer screenObjId = layoutScreenDto.getScreenObj().getScreenObjId();
      Integer attrGrpId = layoutScreenDto.getScreenObj().getAttrGrpId();

      String entity = layoutScreenDto.getScreenObj().getEntity();
      // 地域エンティティの場合
      if (CodeConstants.CODE_ENTITY_REGION.equals(entity)) {
        RegionDto regionDto = getRegionDtoList(langDiv, regionId, attrGrpId);
        ScreenObjBunchDto screenObjBunchDto = new ScreenObjBunchDto();
        screenObjBunchDto.setDisplayNum(1);
        List<ScreenObjDto> screenObjDtoList = new ArrayList<ScreenObjDto>();
        ScreenObjDto screenObjDto = new ScreenObjDto();
        screenObjDto.setLayoutObjId(layoutObjId);
        screenObjDto.setLayoutObjAlias(layoutObjAlias);
        screenObjDto.setLayoutObjType(layoutObjType);
        screenObjDto.setScreenObjId(screenObjId);
        screenObjDto.setAttrDtoList(regionDto.getAttrDtoList());
        screenObjDtoList.add(screenObjDto);
        screenObjBunchDto.setScreenObjDtoList(screenObjDtoList);
        screenObjGrpDto.getScreenObjBunchDtoList().add(screenObjBunchDto);
      }
      // 施設エンティティの場合
      else if (CodeConstants.CODE_ENTITY_FACILITY.equals(entity)) {
        List<FacilityDto> facilityDtoList =
            getFacilityDtoList(langDiv, regionId, facilityId, attrGrpId);
        for (int i = 0; i < facilityDtoList.size(); i++) {
          FacilityDto facilityDto = facilityDtoList.get(i);
          // パラメータのfacilityIdはnullの可能性があるため、施設DTOから取得
          Integer currentFacilityId = facilityDto.getFacilityId();
          ScreenObjBunchDto screenObjBunchDto = null;
          // マップのキーは「layoutObjGrpId＋"-"＋facilityId」とする
          String facilityMapKey = layoutObjGrpId + "-" + currentFacilityId;
          if (facilityScreenObjBunchDtoMap.containsKey(facilityMapKey)) {
            screenObjBunchDto = facilityScreenObjBunchDtoMap.get(facilityMapKey);
          } else {
            screenObjBunchDto = new ScreenObjBunchDto();
            screenObjBunchDto.setDisplayNum(i + 1);
            screenObjBunchDto.setScreenObjDtoList(new ArrayList<ScreenObjDto>());
            facilityScreenObjBunchDtoMap.put(facilityMapKey, screenObjBunchDto);
            screenObjGrpDto.getScreenObjBunchDtoList().add(screenObjBunchDto);
          }
          ScreenObjDto screenObjDto = new ScreenObjDto();
          screenObjDto.setLayoutObjId(layoutObjId);
          screenObjDto.setLayoutObjAlias(layoutObjAlias);
          screenObjDto.setLayoutObjType(layoutObjType);
          screenObjDto.setScreenObjId(screenObjId);
          screenObjDto.setAttrDtoList(facilityDto.getAttrDtoList());
          screenObjBunchDto.getScreenObjDtoList().add(screenObjDto);
        }
      }
      // 施設グループエンティティの場合
      else if (CodeConstants.CODE_ENTITY_FACILITY_GROUP.equals(entity)) {
        // TODO
      }
      // 施設_施設グループ_リンクエンティティの場合
      else if (CodeConstants.CODE_ENTITY_FACILITY_FACILITY_GROUP_LINK.equals(entity)) {
        // TODO
      }
    }

    return screenDto;
  }

  /**
   * 地域DTOを取得します。
   * 
   * @param langDiv 言語区分
   * @param regionId 地域ID
   * @param regionAttrGrpId 地域属性グループID
   * @return 地域DTO
   */
  private RegionDto getRegionDtoList(String langDiv, Integer regionId, Integer regionAttrGrpId) {

    IRegionService service = BeanCreator.getBean(IRegionService.SERVICE_NAME, IRegionService.class);
    return service.getRegion(langDiv, regionId, regionAttrGrpId);
  }

  /**
   * 施設DTOリストを取得します。
   * 
   * @param langDiv 言語区分
   * @param regionId 地域ID
   * @param facilityId 施設ID
   * @param facilityAttrGrpId 施設属性グループID
   * @return 施設DTOリスト
   */
  private List<FacilityDto> getFacilityDtoList(String langDiv, Integer regionId,
      Integer facilityId, Integer facilityAttrGrpId) {

    IFacilityService service =
        BeanCreator.getBean(IFacilityService.SERVICE_NAME, IFacilityService.class);
    if (null == facilityId) {
      return service.getFacilityListByRegion(langDiv, regionId, facilityAttrGrpId);
    } else {
      List<FacilityDto> facilityDtoList = new ArrayList<FacilityDto>();
      facilityDtoList.add(service.getFacility(langDiv, facilityId, facilityAttrGrpId));
      return facilityDtoList;
    }
  }

  /**
   * レイアウト・スクリーン情報取得SQL_IDを取得します。
   * 
   * @return レイアウト・スクリーン情報取得SQL_ID
   */
  public String getSelectLayoutScreenSqlId() {
    return selectLayoutScreenSqlId;
  }

  /**
   * レイアウト・スクリーン情報取得SQL_IDを設定します。
   * 
   * @param selectLayoutScreenSqlId レイアウト・スクリーン情報取得SQL_ID
   */
  public void setSelectLayoutScreenSqlId(String selectLayoutScreenSqlId) {
    this.selectLayoutScreenSqlId = selectLayoutScreenSqlId;
  }

}
