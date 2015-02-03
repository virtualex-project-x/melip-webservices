package com.melip.webservices.service.facility;

import java.util.List;

import com.melip.webservices.dto.facility.FacilityDto;
import com.melip.webservices.service.common.AbstractDataService;
import com.melip.webservices.service.common.QueryCondition;

/**
 * 施設のサービスクラスです。
 */
public class FacilityService extends AbstractDataService implements IFacilityService {

  /** 施設情報取得SQL_ID */
  private String selectFacilitySqlId;

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityList(java.lang.String)
   */
  @Override
  public List<FacilityDto> getFacilityList(String langDiv) {
    return getFacilityListByRegion(langDiv, null, null);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityList(java.lang.String,
   *      java.lang.Integer)
   */
  @Override
  public List<FacilityDto> getFacilityList(String langDiv, Integer facilityAttrGrpId) {
    return getFacilityListByRegion(langDiv, null, facilityAttrGrpId);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityListByRegion(java.lang.String,
   *      java.lang.Integer)
   */
  @Override
  public List<FacilityDto> getFacilityListByRegion(String langDiv, Integer regionId) {
    return getFacilityListByRegion(langDiv, regionId, null);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityListByRegion(java.lang.String,
   *      java.lang.Integer, java.lang.Integer)
   */
  @Override
  public List<FacilityDto> getFacilityListByRegion(String langDiv, Integer regionId,
      Integer facilityAttrGrpId) {

    QueryCondition condition = new QueryCondition(langDiv);
    // TODO:ベタ書き
    condition.setValue("regionId", regionId);
    condition.setValue("facilityAttrGrpId", facilityAttrGrpId);
    List<FacilityDto> facilityDtoList = selectList(getSelectFacilitySqlId(), condition);

    return facilityDtoList;
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

    QueryCondition condition = new QueryCondition(langDiv);
    // TODO:ベタ書き
    condition.setValue("facilityId", facilityId);
    condition.setValue("facilityAttrGrpId", facilityAttrGrpId);
    FacilityDto facilityDto = selectOne(getSelectFacilitySqlId(), condition);

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
