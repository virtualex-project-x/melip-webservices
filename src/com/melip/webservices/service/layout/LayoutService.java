package com.melip.webservices.service.layout;

import java.util.ArrayList;
import java.util.List;

import com.melip.common.constants.CodeConstants;
import com.melip.common.dto.common.AttrDto;
import com.melip.common.dto.screen.ScreenDto;
import com.melip.common.dto.screen.ScreenObjBunchDto;
import com.melip.common.dto.screen.ScreenObjDto;
import com.melip.common.dto.screen.ScreenObjGrpDto;
import com.melip.webservices.common.BeanCreator;
import com.melip.webservices.dto.facility.FacilityDto;
import com.melip.webservices.dto.layout.LayoutScreenDto;
import com.melip.webservices.dto.layout.LayoutScreenObjDto;
import com.melip.webservices.dto.layout.LayoutScreenObjGrpDto;
import com.melip.webservices.dto.layout.ScreenObjAttrDto;
import com.melip.webservices.dto.region.RegionDto;
import com.melip.webservices.service.common.AbstractService;
import com.melip.webservices.service.facility.IFacilityService;
import com.melip.webservices.service.region.IRegionService;

/**
 * レイアウトのサービスクラスです。
 */
public class LayoutService extends AbstractService implements ILayoutService {

  /** レイアウト・スクリーン情報取得SQL_ID */
  private String selectLayoutScreenSqlId;

  /** 言語区分 */
  private String langDiv;
  /** 対象スクリーンID */
  private Integer targetScreenId;
  /** 地域ID */
  private Integer regionId;
  /** 施設ID */
  private Integer facilityId;
  /** 施設グループID */
  private Integer facilityGrpId;

  /** 地域DTO */
  private RegionDto regionDto;
  /** 施設DTOリスト */
  private List<FacilityDto> facilityDtoList;

  // TODO:地域DTOと施設DTOを分けなくてもいいのでは。（IDとAttrDtoのリストを持つ）

  /**
   * @see com.melip.webservices.service.layout.ILayoutService#getScreenDto(java.lang.String,
   *      java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer)
   */
  @Override
  public ScreenDto getScreenDto(String langDiv, Integer targetScreenId, Integer regionId,
      Integer facilityId, Integer facilityGrpId) {

    // パラメータ設定
    setParameters(langDiv, targetScreenId, regionId, facilityId, facilityGrpId);

    LayoutSearchCondition condition = new LayoutSearchCondition();
    condition.setLangDiv(langDiv);
    condition.setTargetScreenId(targetScreenId);
    LayoutScreenDto layoutScreenDto =
        getSession().selectOne(getSelectLayoutScreenSqlId(), condition);
    return createScreenDto(layoutScreenDto);
  }

  /**
   * パラメータを設定します。
   * 
   * @param langDiv 言語区分
   * @param targetScreenId 対象スクリーンID
   * @param regionId 地域ID
   * @param facilityId 施設ID
   * @param facilityGrpId 施設グループID
   */
  private void setParameters(String langDiv, Integer targetScreenId, Integer regionId,
      Integer facilityId, Integer facilityGrpId) {

    setLangDiv(langDiv);
    setTargetScreenId(targetScreenId);
    setRegionId(regionId);
    setFacilityId(facilityId);
    setFacilityGrpId(facilityGrpId);
  }

  /**
   * レイアウト・スクリーン情報を元にスクリーンDTOを生成します。
   * 
   * @param langDiv 言語区分
   * @param regionId 地域ID
   * @param facilityId 施設ID
   * @param facilityGrpId 施設グループID
   * @param layoutScreenDto レイアウト・スクリーン情報
   * @return スクリーンDTO
   */
  private ScreenDto createScreenDto(LayoutScreenDto layoutScreenDto) {

    ScreenDto screenDto = new ScreenDto();
    screenDto.setLayoutId(layoutScreenDto.getLayoutId());
    screenDto.setLayoutAlias(layoutScreenDto.getLayoutAlias());
    screenDto.setLayoutTypeCdAlias(layoutScreenDto.getLayoutTypeCdAlias());
    screenDto.setScreenId(layoutScreenDto.getScreenId());
    screenDto.setScreenObjGrpDtoList(createScreenObjGrpDtoList(layoutScreenDto
        .getLayoutScreenObjGrpDtoList()));
    return screenDto;
  }

  private List<ScreenObjGrpDto> createScreenObjGrpDtoList(
      List<LayoutScreenObjGrpDto> layoutScreenObjGrpDtoList) {

    List<ScreenObjGrpDto> screenObjGrpDtoList = new ArrayList<ScreenObjGrpDto>();

    for (LayoutScreenObjGrpDto layoutScreenObjGrpDto : layoutScreenObjGrpDtoList) {
      ScreenObjGrpDto screenObjGrpDto = new ScreenObjGrpDto();
      screenObjGrpDto.setLayoutObjGrpId(layoutScreenObjGrpDto.getLayoutObjGrpId());
      screenObjGrpDto.setLayoutObjGrpAlias(layoutScreenObjGrpDto.getLayoutObjGrpAlias());
      screenObjGrpDto.setMultiplicity(layoutScreenObjGrpDto.getMultiplicity());
      screenObjGrpDto.setScreenObjGrpId(layoutScreenObjGrpDto.getScreenObjGrpId());
      screenObjGrpDto.setTargetScreenId(layoutScreenObjGrpDto.getTargetScreenId());

      String screenObjGrpEntity = layoutScreenObjGrpDto.getScreenObjGrpEntity();
      // 地域の場合
      if (CodeConstants.CODE_ENTITY_REGION.equals(screenObjGrpEntity)) {
        screenObjGrpDto
            .setScreenObjBunchDtoList(createRegionScreenObjBunchDtoList(layoutScreenObjGrpDto
                .getLayoutScreenObjDtoList()));
      }
      // 施設の場合
      else if (CodeConstants.CODE_ENTITY_FACILITY.equals(screenObjGrpEntity)) {
        screenObjGrpDto
            .setScreenObjBunchDtoList(createFacilityScreenObjBunchDtoList(layoutScreenObjGrpDto
                .getLayoutScreenObjDtoList()));
      }
      // 施設グループの場合
      else if (CodeConstants.CODE_ENTITY_FACILITY_GROUP.equals(screenObjGrpEntity)) {

      }
      // 施設_施設グループ_リンクの場合
      else if (CodeConstants.CODE_ENTITY_FACILITY_FACILITY_GROUP_LINK.equals(screenObjGrpEntity)) {

      }

      screenObjGrpDtoList.add(screenObjGrpDto);
    }

    return screenObjGrpDtoList;
  }

  private List<ScreenObjBunchDto> createRegionScreenObjBunchDtoList(
      List<LayoutScreenObjDto> layoutScreenObjDtoList) {

    List<ScreenObjBunchDto> screenObjBunchDtoList = new ArrayList<ScreenObjBunchDto>();
    ScreenObjBunchDto screenObjBunchDto = new ScreenObjBunchDto();
    screenObjBunchDto.setRegionId(getRegionId());
    screenObjBunchDto.setScreenObjDtoList(createRegionScreenObjDtoList(layoutScreenObjDtoList));
    screenObjBunchDtoList.add(screenObjBunchDto);

    return screenObjBunchDtoList;
  }

  private List<ScreenObjBunchDto> createFacilityScreenObjBunchDtoList(
      List<LayoutScreenObjDto> layoutScreenObjDtoList) {

    List<ScreenObjBunchDto> screenObjBunchDtoList = new ArrayList<ScreenObjBunchDto>();

    List<FacilityDto> facilityDtoList = getFacilityDtoList();
    for (FacilityDto facilityDto : facilityDtoList) {
      ScreenObjBunchDto screenObjBunchDto = new ScreenObjBunchDto();
      screenObjBunchDto.setRegionId(getRegionId());
      screenObjBunchDto.setFacilityId(facilityDto.getFacilityId());
      screenObjBunchDto.setScreenObjDtoList(createFacilityScreenObjDtoList(
          facilityDto.getFacilityId(), layoutScreenObjDtoList));
      screenObjBunchDtoList.add(screenObjBunchDto);
    }

    return screenObjBunchDtoList;
  }

  private List<ScreenObjDto> createRegionScreenObjDtoList(
      List<LayoutScreenObjDto> layoutScreenObjDtoList) {

    List<ScreenObjDto> screenObjDtoList = new ArrayList<ScreenObjDto>();

    for (LayoutScreenObjDto layoutScreenObjDto : layoutScreenObjDtoList) {
      ScreenObjDto screenObjDto = new ScreenObjDto();
      screenObjDto.setLayoutObjId(layoutScreenObjDto.getLayoutObjId());
      screenObjDto.setLayoutObjAlias(layoutScreenObjDto.getLayoutObjAlias());
      screenObjDto.setLayoutObjType(layoutScreenObjDto.getLayoutObjType());
      screenObjDto.setScreenObjId(layoutScreenObjDto.getScreenObjId());
      screenObjDto.setAttrDtoList(createRegionAttrDtoList(layoutScreenObjDto
          .getScreenObjAttrDtoList()));
      screenObjDtoList.add(screenObjDto);
    }

    return screenObjDtoList;
  }

  private List<ScreenObjDto> createFacilityScreenObjDtoList(Integer facilityId,
      List<LayoutScreenObjDto> layoutScreenObjDtoList) {

    List<ScreenObjDto> screenObjDtoList = new ArrayList<ScreenObjDto>();

    for (LayoutScreenObjDto layoutScreenObjDto : layoutScreenObjDtoList) {
      ScreenObjDto screenObjDto = new ScreenObjDto();
      screenObjDto.setLayoutObjId(layoutScreenObjDto.getLayoutObjId());
      screenObjDto.setLayoutObjAlias(layoutScreenObjDto.getLayoutObjAlias());
      screenObjDto.setLayoutObjType(layoutScreenObjDto.getLayoutObjType());
      screenObjDto.setScreenObjId(layoutScreenObjDto.getScreenObjId());
      screenObjDto.setAttrDtoList(createFacilityAttrDtoList(facilityId,
          layoutScreenObjDto.getScreenObjAttrDtoList()));
      screenObjDtoList.add(screenObjDto);
    }

    return screenObjDtoList;
  }

  private List<AttrDto> createRegionAttrDtoList(List<ScreenObjAttrDto> screenObjAttrDtoList) {

    List<AttrDto> attrDtoList = new ArrayList<AttrDto>();

    for (ScreenObjAttrDto screenObjAttrDto : screenObjAttrDtoList) {
      attrDtoList.add(createRegionAttrDto(screenObjAttrDto.getAttrGrpId(),
          screenObjAttrDto.getTargetScreenId()));
    }

    return attrDtoList;
  }

  private List<AttrDto> createFacilityAttrDtoList(Integer facilityId,
      List<ScreenObjAttrDto> screenObjAttrDtoList) {

    List<AttrDto> attrDtoList = new ArrayList<AttrDto>();

    for (ScreenObjAttrDto screenObjAttrDto : screenObjAttrDtoList) {
      String screenObjAttrEntity = screenObjAttrDto.getScreenObjAttrEntity();
      // 地域の場合
      if (CodeConstants.CODE_ENTITY_REGION.equals(screenObjAttrEntity)) {
        attrDtoList.add(createRegionAttrDto(screenObjAttrDto.getAttrGrpId(),
            screenObjAttrDto.getTargetScreenId()));
      }
      // 施設の場合
      else if (CodeConstants.CODE_ENTITY_FACILITY.equals(screenObjAttrEntity)) {
        attrDtoList.add(createFacilityAttrDto(facilityId, screenObjAttrDto.getAttrGrpId(),
            screenObjAttrDto.getTargetScreenId()));
      }
    }

    return attrDtoList;
  }

  private AttrDto createFacilityAttrDto(Integer facilityId, Integer attrGrpId,
      Integer targetScreenId) {

    List<FacilityDto> facilityDtoList = getFacilityDtoList();
    for (FacilityDto facilityDto : facilityDtoList) {
      if (facilityId.equals(facilityDto.getFacilityId())) {
        List<AttrDto> attrDtoList = facilityDto.getAttrDtoList();
        for (AttrDto attrDto : attrDtoList) {
          if (attrGrpId.equals(attrDto.getAttrGrpId())) {
            attrDto.setTargetScreenId(targetScreenId);
            return attrDto;
          }
        }
      }
    }

    return null;
  }

  private AttrDto createRegionAttrDto(Integer attrGrpId, Integer targetScreenId) {

    List<AttrDto> attrDtoList = getRegionDto().getAttrDtoList();
    for (AttrDto attrDto : attrDtoList) {
      if (attrGrpId.equals(attrDto.getAttrGrpId())) {
        attrDto.setTargetScreenId(targetScreenId);
        return attrDto;
      }
    }

    return null;
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

  /**
   * 言語区分を取得します。
   * 
   * @return 言語区分
   */
  public String getLangDiv() {
    return langDiv;
  }

  /**
   * 言語区分を設定します。
   * 
   * @param langDiv 言語区分
   */
  public void setLangDiv(String langDiv) {
    this.langDiv = langDiv;
  }

  /**
   * 対象スクリーンIDを取得します。
   * 
   * @return 対象スクリーンID
   */
  public Integer getTargetScreenId() {
    return targetScreenId;
  }

  /**
   * 対象スクリーンIDを設定します。
   * 
   * @param targetScreenId 対象スクリーンID
   */
  public void setTargetScreenId(Integer targetScreenId) {
    this.targetScreenId = targetScreenId;
  }

  /**
   * 地域IDを取得します。
   * 
   * @return 地域ID
   */
  public Integer getRegionId() {
    return regionId;
  }

  /**
   * 地域IDを設定します。
   * 
   * @param regionId 地域ID
   */
  public void setRegionId(Integer regionId) {
    this.regionId = regionId;
  }

  /**
   * 施設IDを取得します。
   * 
   * @return 施設ID
   */
  public Integer getFacilityId() {
    return facilityId;
  }

  /**
   * 施設IDを設定します。
   * 
   * @param facilityId 施設ID
   */
  public void setFacilityId(Integer facilityId) {
    this.facilityId = facilityId;
  }

  /**
   * 施設グループIDを取得します。
   * 
   * @return 施設グループID
   */
  public Integer getFacilityGrpId() {
    return facilityGrpId;
  }

  /**
   * 施設グループIDを設定します。
   * 
   * @param facilityGrpId 施設グループID
   */
  public void setFacilityGrpId(Integer facilityGrpId) {
    this.facilityGrpId = facilityGrpId;
  }

  /**
   * 地域DTOを取得します。
   * 
   * @return 地域DTO
   */
  public RegionDto getRegionDto() {

    if (null == regionDto) {
      IRegionService service =
          BeanCreator.getBean(IRegionService.SERVICE_NAME, IRegionService.class);
      regionDto = service.getRegion(getLangDiv(), getRegionId());
    }

    return regionDto;
  }

  /**
   * 地域DTOを設定します。
   * 
   * @param regionDto 地域DTO
   */
  public void setRegionDto(RegionDto regionDto) {
    this.regionDto = regionDto;
  }

  /**
   * 施設DTOリストを取得します。
   * 
   * @return 施設DTOリスト
   */
  public List<FacilityDto> getFacilityDtoList() {

    if (null == facilityDtoList) {
      IFacilityService service =
          BeanCreator.getBean(IFacilityService.SERVICE_NAME, IFacilityService.class);
      if (null == getFacilityId()) {
        facilityDtoList = service.getFacilityListByRegion(getLangDiv(), getRegionId());
      } else {
        facilityDtoList = new ArrayList<FacilityDto>();
        facilityDtoList.add(service.getFacility(getLangDiv(), getFacilityId()));
      }
    }

    return facilityDtoList;
  }

  /**
   * 施設DTOリストを設定します。
   * 
   * @param facilityDtoList 施設DTOリスト
   */
  public void setFacilityDtoList(List<FacilityDto> facilityDtoList) {
    this.facilityDtoList = facilityDtoList;
  }

}
