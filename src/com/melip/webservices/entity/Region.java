package com.melip.webservices.entity;

/**
 * 地域のエンティティクラスです。
 */
public class Region extends com.melip.webservices.entity.common.AbstractEntity {

  /** 地域IDのフィールド名 */
  public static final String FIELD_REGION_ID = "regionId";
  /** 公開ステータスのフィールド名 */
  public static final String FIELD_PUBLISH_STS = "publishSts";

  /** 地域ID */
  private Integer regionId;
  /** 公開ステータス */
  private String publishSts;

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


}
