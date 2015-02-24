package com.melip.webservices.entity;

/**
 * 施設グループのエンティティクラスです。
 */
public class FacilityGrp extends com.melip.webservices.entity.common.AbstractEntity {

  /** 施設グループIDのフィールド名 */
  public static final String FIELD_FACILITY_GRP_ID = "facilityGrpId";
  /** 地域IDのフィールド名 */
  public static final String FIELD_REGION_I = "regionI";
  /** 公開ステータスのフィールド名 */
  public static final String FIELD_PUBLISH_STS = "publishSts";

  /** 施設グループID */
  private Integer facilityGrpId;
  /** 地域ID */
  private Integer regionI;
  /** 公開ステータス */
  private String publishSts;

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
   * 地域IDを取得します。
   * 
   * @return 地域ID
   */
  public Integer getRegionI() {
    return regionI;
  }

  /**
   * 地域IDを設定します。
   * 
   * @param regionI 地域ID
   */
  public void setRegionI(Integer regionI) {
    this.regionI = regionI;
  }

  /**
   * 公開ステータスを取得します。
   * 
   * @return 公開ステータス
   */
  public String getPublishSts() {
    return publishSts;
  }

  /**
   * 公開ステータスを設定します。
   * 
   * @param publishSts 公開ステータス
   */
  public void setPublishSts(String publishSts) {
    this.publishSts = publishSts;
  }


}
