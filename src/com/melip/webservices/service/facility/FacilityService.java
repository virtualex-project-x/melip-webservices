package com.melip.webservices.service.facility;

import java.util.List;

import com.melip.webservices.dto.FacilityDto;
import com.melip.webservices.service.common.AbstractService;

/**
 * 施設のサービスクラスです。
 */
public class FacilityService extends AbstractService implements IFacilityService {

  /** 施設情報取得SQL_ID */
  private String selectFacilitySqlId;

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityList(java.lang.String)
   */
  @Override
  public List<FacilityDto> getFacilityList(String langDiv) {
    return getFacilityList(langDiv, null, null);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityList(java.lang.String,
   *      java.lang.Integer, java.lang.Integer)
   */
  @Override
  public List<FacilityDto> getFacilityList(String langDiv, Integer regionId,
      Integer facilityAttrGrpId) {

    FacilitySearchCondition condition = new FacilitySearchCondition();
    condition.setLangDiv(langDiv);
    condition.setRegionId(regionId);
    condition.setFacilityAttrGrpId(facilityAttrGrpId);
    List<FacilityDto> facilityDtoList =
        getSession().selectList(getSelectFacilitySqlId(), condition);
    return facilityDtoList;
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityListByRegionId(java.lang.String,
   *      java.lang.Integer)
   */
  @Override
  public List<FacilityDto> getFacilityListByRegionId(String langDiv, Integer regionId) {
    return getFacilityList(langDiv, regionId, null);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityListByFacilityAttrGrpId(java.lang.String,
   *      java.lang.Integer)
   */
  @Override
  public List<FacilityDto> getFacilityListByFacilityAttrGrpId(String langDiv,
      Integer facilityAttrGrpId) {
    return getFacilityList(langDiv, null, facilityAttrGrpId);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacility(java.lang.String,
   *      java.lang.Integer)
   */
  @Override
  public FacilityDto getFacility(String langDiv, Integer facilityId) {
    return getFacility(langDiv, facilityId, null);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacility(java.lang.String,
   *      java.lang.Integer, java.lang.Integer)
   */
  @Override
  public FacilityDto getFacility(String langDiv, Integer facilityId, Integer facilityAttrGrpId) {

    FacilitySearchCondition condition = new FacilitySearchCondition();
    condition.setLangDiv(langDiv);
    condition.setFacilityId(facilityId);
    condition.setFacilityAttrGrpId(facilityAttrGrpId);
    FacilityDto facilityDto = getSession().selectOne(getSelectFacilitySqlId(), condition);
    return facilityDto;
  }

  /**
   * 施設情報取得SQL_IDを取得します。
   * 
   * @return 施設情報取得SQL_ID
   */
  public String getSelectFacilitySqlId() {
    return selectFacilitySqlId;
  }

  /**
   * 施設情報取得SQL_IDを設定します。
   * 
   * @param selectFacilitySqlId 施設情報取得SQL_ID
   */
  public void setSelectFacilitySqlId(String selectFacilitySqlId) {
    this.selectFacilitySqlId = selectFacilitySqlId;
  }

}
