package com.melip.webservices.entity;

/**
 * 施設グループ属性値のエンティティクラスです。
 */
public class FacilityGrpAttrVal extends com.melip.webservices.entity.common.AbstractEntity {

  /** 施設グループ属性値IDのフィールド名 */
  public static final String FIELD_FACILITY_GRP_ATTR_VAL_ID = "facilityGrpAttrValId";
  /** 施設グループIDのフィールド名 */
  public static final String FIELD_FACILITY_GRP_ID = "facilityGrpId";
  /** 施設グループ属性グループIDのフィールド名 */
  public static final String FIELD_FACILITY_GRP_ATTR_GRP_ID = "facilityGrpAttrGrpId";

  /** 施設グループ属性値ID */
  private Integer facilityGrpAttrValId;
  /** 施設グループID */
  private Integer facilityGrpId;
  /** 施設グループ属性グループID */
  private Integer facilityGrpAttrGrpId;

  /**
   * 施設グループ属性値IDを取得します。
   * 
   * @return 施設グループ属性値ID
   */
  public Integer getFacilityGrpAttrValId() {
    return facilityGrpAttrValId;
  }

  /**
   * 施設グループ属性値IDを設定します。
   * 
   * @param facilityGrpAttrValId 施設グループ属性値ID
   */
  public void setFacilityGrpAttrValId(Integer facilityGrpAttrValId) {
    this.facilityGrpAttrValId = facilityGrpAttrValId;
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
   * 施設グループ属性グループIDを取得します。
   * 
   * @return 施設グループ属性グループID
   */
  public Integer getFacilityGrpAttrGrpId() {
    return facilityGrpAttrGrpId;
  }

  /**
   * 施設グループ属性グループIDを設定します。
   * 
   * @param facilityGrpAttrGrpId 施設グループ属性グループID
   */
  public void setFacilityGrpAttrGrpId(Integer facilityGrpAttrGrpId) {
    this.facilityGrpAttrGrpId = facilityGrpAttrGrpId;
  }


}
