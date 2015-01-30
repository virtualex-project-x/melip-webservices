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

  /** 言語区分（パラメータ） */
  private String prmLangDiv;
  /** 対象スクリーンID（パラメータ） */
  private Integer prmTargetScreenId;
  /** 地域ID（パラメータ） */
  private Integer prmRegionId;
  /** 施設ID（パラメータ） */
  private Integer prmFacilityId;
  /** 施設グループID（パラメータ） */
  private Integer prmFacilityGrpId;

  /** 地域DTO */
  private RegionDto regionDto;
  /** 施設DTOリスト */
  private List<FacilityDto> facilityDtoList;

  /**
   * @see com.melip.webservices.service.layout.ILayoutService#getScreenDto(java.lang.String,
   *      java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer)
   */
  @Override
  public ScreenDto getScreenDto(String langDiv, Integer targetScreenId, Integer regionId,
      Integer facilityId, Integer facilityGrpId) {

    // パラメータ設定
    setParameters(langDiv, targetScreenId, regionId, facilityId, facilityGrpId);

    // レイアウト・スクリーン情報取得
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

    setPrmLangDiv(langDiv);
    setPrmTargetScreenId(targetScreenId);
    setPrmRegionId(regionId);
    setPrmFacilityId(facilityId);
    setFacilityGrpId(facilityGrpId);
  }

  /**
   * スクリーンDTOを生成します。
   * 
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

  /**
   * スクリーンオブジェクトグループDTOリストを生成します。
   * 
   * @param layoutScreenObjGrpDtoList レイアウト・スクリーンオブジェクトグループDTOリスト
   * @return スクリーンオブジェクトグループDTOリスト
   */
  private List<ScreenObjGrpDto> createScreenObjGrpDtoList(
      List<LayoutScreenObjGrpDto> layoutScreenObjGrpDtoList) {

    List<ScreenObjGrpDto> screenObjGrpDtoList = new ArrayList<ScreenObjGrpDto>();

    for (LayoutScreenObjGrpDto layoutScreenObjGrpDto : layoutScreenObjGrpDtoList) {
      ScreenObjGrpDto screenObjGrpDto = createScreenObjGrpDto(layoutScreenObjGrpDto);

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

  /**
   * スクリーンオブジェクトグループDTOを生成します。
   * 
   * @param layoutScreenObjGrpDto レイアウト・オブジェクトグループDTO
   * @return スクリーンオブジェクトグループDTO
   */
  private ScreenObjGrpDto createScreenObjGrpDto(LayoutScreenObjGrpDto layoutScreenObjGrpDto) {

    ScreenObjGrpDto screenObjGrpDto = new ScreenObjGrpDto();
    screenObjGrpDto.setLayoutObjGrpId(layoutScreenObjGrpDto.getLayoutObjGrpId());
    screenObjGrpDto.setLayoutObjGrpAlias(layoutScreenObjGrpDto.getLayoutObjGrpAlias());
    screenObjGrpDto.setMultiplicity(layoutScreenObjGrpDto.getMultiplicity());
    screenObjGrpDto.setScreenObjGrpId(layoutScreenObjGrpDto.getScreenObjGrpId());
    screenObjGrpDto.setTargetScreenId(layoutScreenObjGrpDto.getTargetScreenId());
    screenObjGrpDto.setScreenObjBunchDtoList(new ArrayList<ScreenObjBunchDto>());

    return screenObjGrpDto;
  }

  /**
   * 地域用のスクリーンオブジェクトバンチDTOリストを生成します。
   * 
   * @param layoutScreenObjDtoList レイアウト・スクリーンオブジェクトDTOリスト
   * @return スクリーンオブジェクトバンチDTOリスト
   */
  private List<ScreenObjBunchDto> createRegionScreenObjBunchDtoList(
      List<LayoutScreenObjDto> layoutScreenObjDtoList) {

    List<ScreenObjBunchDto> screenObjBunchDtoList = new ArrayList<ScreenObjBunchDto>();
    ScreenObjBunchDto screenObjBunchDto = createScreenObjBunchDto(getPrmRegionId(), null, null);
    screenObjBunchDto.setScreenObjDtoList(createScreenObjDtoList(layoutScreenObjDtoList,
        getPrmRegionId()));
    screenObjBunchDtoList.add(screenObjBunchDto);

    return screenObjBunchDtoList;
  }

  /**
   * 施設用のスクリーンオブジェクトバンチDTOリストを生成します。
   * 
   * @param layoutScreenObjDtoList レイアウト・スクリーンオブジェクトDTOリスト
   * @return スクリーンオブジェクトバンチDTOリスト
   */
  private List<ScreenObjBunchDto> createFacilityScreenObjBunchDtoList(
      List<LayoutScreenObjDto> layoutScreenObjDtoList) {

    List<ScreenObjBunchDto> screenObjBunchDtoList = new ArrayList<ScreenObjBunchDto>();

    List<FacilityDto> facilityDtoList = getFacilityDtoList();
    for (FacilityDto facilityDto : facilityDtoList) {
      ScreenObjBunchDto screenObjBunchDto =
          createScreenObjBunchDto(getPrmRegionId(), null, facilityDto.getFacilityId());
      screenObjBunchDto.setScreenObjDtoList(createScreenObjDtoList(layoutScreenObjDtoList,
          facilityDto.getFacilityId()));
      screenObjBunchDtoList.add(screenObjBunchDto);
    }

    return screenObjBunchDtoList;
  }

  /**
   * スクリーンオブジェクトバンチDTOを生成します。
   * 
   * @param regionId 地域ID
   * @param facilityGrpId 施設グループID
   * @param facilityId 施設ID
   * @return スクリーンオブジェクトバンチDTO
   */
  private ScreenObjBunchDto createScreenObjBunchDto(Integer regionId, Integer facilityGrpId,
      Integer facilityId) {

    ScreenObjBunchDto screenObjBunchDto = new ScreenObjBunchDto();
    screenObjBunchDto.setRegionId(regionId);
    screenObjBunchDto.setFacilityGrpId(facilityGrpId);
    screenObjBunchDto.setFacilityId(facilityId);
    screenObjBunchDto.setScreenObjDtoList(new ArrayList<ScreenObjDto>());

    return screenObjBunchDto;
  }

  /**
   * スクリーンオブジェクトDTOリストを生成します。
   * 
   * @param layoutScreenObjDtoList レイアウト・スクリーンオブジェクトDTOリスト
   * @param targetId 対象のID
   * @return スクリーンオブジェクトDTOリスト
   */
  private List<ScreenObjDto> createScreenObjDtoList(
      List<LayoutScreenObjDto> layoutScreenObjDtoList, Integer targetId) {

    List<ScreenObjDto> screenObjDtoList = new ArrayList<ScreenObjDto>();

    for (LayoutScreenObjDto layoutScreenObjDto : layoutScreenObjDtoList) {
      ScreenObjDto screenObjDto = createScreenObjDto(layoutScreenObjDto);
      screenObjDto.setAttrDtoList(createAttrDtoList(layoutScreenObjDto.getScreenObjAttrDtoList(),
          targetId));
      screenObjDtoList.add(screenObjDto);
    }

    return screenObjDtoList;
  }

  /**
   * スクリーンオブジェクトDTOを生成します。
   * 
   * @param layoutScreenObjDto レイアウト・スクリーンオブジェクトDTO
   * @return スクリーンオブジェクトDTO
   */
  private ScreenObjDto createScreenObjDto(LayoutScreenObjDto layoutScreenObjDto) {

    ScreenObjDto screenObjDto = new ScreenObjDto();
    screenObjDto.setLayoutObjId(layoutScreenObjDto.getLayoutObjId());
    screenObjDto.setLayoutObjAlias(layoutScreenObjDto.getLayoutObjAlias());
    screenObjDto.setLayoutObjType(layoutScreenObjDto.getLayoutObjType());
    screenObjDto.setScreenObjId(layoutScreenObjDto.getScreenObjId());
    screenObjDto.setAttrDtoList(new ArrayList<AttrDto>());

    return screenObjDto;
  }

  /**
   * 属性DTOリストを生成します。
   * 
   * @param screenObjAttrDtoList スクリーンオブジェクト属性DTOリスト
   * @param targetId 対象のID<br>
   *        （地域ID、施設ID、施設グループID）
   * @return 属性DTOリスト
   */
  private List<AttrDto> createAttrDtoList(List<ScreenObjAttrDto> screenObjAttrDtoList,
      Integer targetId) {

    List<AttrDto> attrDtoList = new ArrayList<AttrDto>();

    for (ScreenObjAttrDto screenObjAttrDto : screenObjAttrDtoList) {
      String screenObjAttrEntity = screenObjAttrDto.getScreenObjAttrEntity();
      // 地域の場合
      if (CodeConstants.CODE_ENTITY_REGION.equals(screenObjAttrEntity)) {
        attrDtoList.add(createRegionAttrDto(screenObjAttrDto, screenObjAttrDto.getAttrGrpId()));
      }
      // 施設の場合
      else if (CodeConstants.CODE_ENTITY_FACILITY.equals(screenObjAttrEntity)) {
        attrDtoList.add(createFacilityAttrDto(screenObjAttrDto, screenObjAttrDto.getAttrGrpId(),
            targetId));
      }
      // TODO:施設グループ、施設_施設グループ_リンクの場合
    }

    return attrDtoList;
  }

  /**
   * 地域用の属性DTOを生成します。
   * 
   * @param screenObjAttrDto スクリーンオブジェクト属性DTO
   * @param attrGrpId 属性グループID
   * @return 属性DTO
   */
  private AttrDto createRegionAttrDto(ScreenObjAttrDto screenObjAttrDto, Integer attrGrpId) {

    List<AttrDto> attrDtoList = getRegionDto().getAttrDtoList();
    return createAttrDto(screenObjAttrDto, attrGrpId, attrDtoList);
  }

  /**
   * 施設用の属性DTOを生成します。
   * 
   * @param screenObjAttrDto スクリーンオブジェクト属性DTO
   * @param attrGrpId 属性グループID
   * @param facilityId 施設ID
   * @return 属性DTO
   */
  private AttrDto createFacilityAttrDto(ScreenObjAttrDto screenObjAttrDto, Integer attrGrpId,
      Integer facilityId) {

    AttrDto attrDto = null;

    List<FacilityDto> facilityDtoList = getFacilityDtoList();
    for (FacilityDto facilityDto : facilityDtoList) {
      if (facilityId.equals(facilityDto.getFacilityId())) {
        List<AttrDto> attrDtoList = facilityDto.getAttrDtoList();
        attrDto = createAttrDto(screenObjAttrDto, attrGrpId, attrDtoList);
      }
    }

    return attrDto;
  }

  /**
   * 属性DTOを生成します。
   * 
   * @param screenObjAttrDto スクリーンオブジェクト属性DTO
   * @param attrGrpId 属性グループID
   * @param attrDtoList 属性DTOリスト
   * @return 属性DTO
   */
  private AttrDto createAttrDto(ScreenObjAttrDto screenObjAttrDto, Integer attrGrpId,
      List<AttrDto> attrDtoList) {

    for (AttrDto attrDto : attrDtoList) {
      if (attrGrpId.equals(attrDto.getAttrGrpId())) {
        attrDto.setTargetScreenId(screenObjAttrDto.getTargetScreenId());
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
   * 言語区分（パラメータ）を取得します。
   * 
   * @return 言語区分（パラメータ）
   */
  public String getPrmLangDiv() {
    return prmLangDiv;
  }

  /**
   * 言語区分（パラメータ）を設定します。
   * 
   * @param prmLangDiv 言語区分（パラメータ）
   */
  public void setPrmLangDiv(String prmLangDiv) {
    this.prmLangDiv = prmLangDiv;
  }

  /**
   * 対象スクリーンID（パラメータ）を取得します。
   * 
   * @return 対象スクリーンID（パラメータ）
   */
  public Integer getPrmTargetScreenId() {
    return prmTargetScreenId;
  }

  /**
   * 対象スクリーンID（パラメータ）を設定します。
   * 
   * @param prmTargetScreenId 対象スクリーンID（パラメータ）
   */
  public void setPrmTargetScreenId(Integer prmTargetScreenId) {
    this.prmTargetScreenId = prmTargetScreenId;
  }

  /**
   * 地域ID（パラメータ）を取得します。
   * 
   * @return 地域ID（パラメータ）
   */
  public Integer getPrmRegionId() {
    return prmRegionId;
  }

  /**
   * 地域ID（パラメータ）を設定します。
   * 
   * @param prmRegionId 地域ID（パラメータ）
   */
  public void setPrmRegionId(Integer prmRegionId) {
    this.prmRegionId = prmRegionId;
  }

  /**
   * 施設ID（パラメータ）を取得します。
   * 
   * @return 施設ID（パラメータ）
   */
  public Integer getPrmFacilityId() {
    return prmFacilityId;
  }

  /**
   * 施設ID（パラメータ）を設定します。
   * 
   * @param prmFacilityId 施設ID（パラメータ）
   */
  public void setPrmFacilityId(Integer prmFacilityId) {
    this.prmFacilityId = prmFacilityId;
  }

  /**
   * 施設グループID（パラメータ）を取得します。
   * 
   * @return 施設グループID（パラメータ）
   */
  public Integer getPrmFacilityGrpId() {
    return prmFacilityGrpId;
  }

  /**
   * 施設グループID（パラメータ）を設定します。
   * 
   * @param prmFacilityGrpId 施設グループID（パラメータ）
   */
  public void setFacilityGrpId(Integer prmFacilityGrpId) {
    this.prmFacilityGrpId = prmFacilityGrpId;
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
      regionDto = service.getRegion(getPrmLangDiv(), getPrmRegionId());
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
      if (null == getPrmFacilityId()) {
        facilityDtoList = service.getFacilityListByRegion(getPrmLangDiv(), getPrmRegionId());
      } else {
        facilityDtoList = new ArrayList<FacilityDto>();
        facilityDtoList.add(service.getFacility(getPrmLangDiv(), getPrmFacilityId()));
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
