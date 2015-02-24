package com.melip.webservices.entity;

/**
 * 施設_施設グループ_リンクのエンティティクラスです。
 */
public class FacilityFacilityGrpLink extends com.melip.webservices.entity.common.AbstractEntity {

  /** 施設_施設グループ_リンクIDのフィールド名 */
  public static final String FIELD_FACILITY_FACILITY_GRP_LINK_ID = "facilityFacilityGrpLinkId";
  /** 施設IDのフィールド名 */
  public static final String FIELD_FACILITY_ID = "facilityId";
  /** 施設グループIDのフィールド名 */
  public static final String FIELD_FACILITY_GRP_ID = "facilityGrpId";

  /** 施設_施設グループ_リンクID */
  private Integer facilityFacilityGrpLinkId;
  /** 施設ID */
  private Integer facilityId;
  /** 施設グループID */
  private Integer facilityGrpId;

  /**
   * 施設_施設グループ_リンクIDを取得します。
   * 
   * @return 施設_施設グループ_リンクID
   */
  public Integer getFacilityFacilityGrpLinkId() {
    return facilityFacilityGrpLinkId;
  }

  /**
   * 施設_施設グループ_リンクIDを設定します。
   * 
   * @param facilityFacilityGrpLinkId 施設_施設グループ_リンクID
   */
  public void setFacilityFacilityGrpLinkId(Integer facilityFacilityGrpLinkId) {
    this.facilityFacilityGrpLinkId = facilityFacilityGrpLinkId;
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


}
