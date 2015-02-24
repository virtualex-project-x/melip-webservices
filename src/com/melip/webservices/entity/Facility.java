package com.melip.webservices.entity;

/**
 * 施設のエンティティクラスです。
 */
public class Facility extends com.melip.webservices.entity.common.AbstractEntity {

  /** 施設IDのフィールド名 */
  public static final String FIELD_FACILITY_ID = "facilityId";
  /** 地域IDのフィールド名 */
  public static final String FIELD_REGION_ID = "regionId";
  /** 公開ステータスのフィールド名 */
  public static final String FIELD_PUBLISH_STS = "publishSts";
  /** 緯度のフィールド名 */
  public static final String FIELD_LATITUDE = "latitude";
  /** 経度のフィールド名 */
  public static final String FIELD_LONGITUDE = "longitude";
  /** 親施設IDのフィールド名 */
  public static final String FIELD_PARENT_FACILITY_ID = "parentFacilityId";

  /** 施設ID */
  private Integer facilityId;
  /** 地域ID */
  private Integer regionId;
  /** 公開ステータス */
  private String publishSts;
  /** 緯度 */
  private Float latitude;
  /** 経度 */
  private Float longitude;
  /** 親施設ID */
  private Integer parentFacilityId;

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

  /**
   * 緯度を取得します。
   * 
   * @return 緯度
   */
  public Float getLatitude() {
    return latitude;
  }

  /**
   * 緯度を設定します。
   * 
   * @param latitude 緯度
   */
  public void setLatitude(Float latitude) {
    this.latitude = latitude;
  }

  /**
   * 経度を取得します。
   * 
   * @return 経度
   */
  public Float getLongitude() {
    return longitude;
  }

  /**
   * 経度を設定します。
   * 
   * @param longitude 経度
   */
  public void setLongitude(Float longitude) {
    this.longitude = longitude;
  }

  /**
   * 親施設IDを取得します。
   * 
   * @return 親施設ID
   */
  public Integer getParentFacilityId() {
    return parentFacilityId;
  }

  /**
   * 親施設IDを設定します。
   * 
   * @param parentFacilityId 親施設ID
   */
  public void setParentFacilityId(Integer parentFacilityId) {
    this.parentFacilityId = parentFacilityId;
  }


}
