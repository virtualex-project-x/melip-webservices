package com.melip.webservices.entity;

/**
 * 施設属性値のエンティティクラスです。
 */
public class FacilityAttrVal extends com.melip.webservices.entity.common.AbstractEntity {

  /** 施設属性値IDのフィールド名 */
  public static final String FIELD_FACILITY_ATTR_VAL_ID = "facilityAttrValId";
  /** 施設IDのフィールド名 */
  public static final String FIELD_FACILITY_ID = "facilityId";
  /** 施設属性グループIDのフィールド名 */
  public static final String FIELD_FACILITY_ATTR_GRP_ID = "facilityAttrGrpId";

  /** 施設属性値ID */
  private Integer facilityAttrValId;
  /** 施設ID */
  private Integer facilityId;
  /** 施設属性グループID */
  private Integer facilityAttrGrpId;

  /**
   * 施設属性値IDを取得します。
   * 
   * @return 施設属性値ID
   */
  public Integer getFacilityAttrValId() {
    return facilityAttrValId;
  }

  /**
   * 施設属性値IDを設定します。
   * 
   * @param facilityAttrValId 施設属性値ID
   */
  public void setFacilityAttrValId(Integer facilityAttrValId) {
    this.facilityAttrValId = facilityAttrValId;
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
