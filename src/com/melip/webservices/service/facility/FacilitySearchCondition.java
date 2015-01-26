package com.melip.webservices.service.facility;

import com.melip.webservices.service.common.SearchCondition;

/**
 * 施設関連の検索条件クラスです。
 */
public class FacilitySearchCondition extends SearchCondition {

  /** 地域ID */
  private Integer regionId;
  /** 施設ID */
  private Integer facilityId;
  /** 施設属性グループID */
  private Integer facilityAttrGrpId;

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
   * @param facilityId the facilityId to set
   */
  public void setFacilityId(Integer facilityId) {
    this.facilityId = facilityId;
  }

  /**
   * 施設属性グループIDを取得します。
   * 
   * @return 施設属性グループID
   */
  public Integer getFacilityAttrGrpId() {
    return facilityAttrGrpId;
  }

  /**
   * 施設属性グループIDを設定します。
   * 
   * @param facilityAttrGrpId 施設属性グループID
   */
  public void setFacilityAttrGrpId(Integer facilityAttrGrpId) {
    this.facilityAttrGrpId = facilityAttrGrpId;
  }

}
