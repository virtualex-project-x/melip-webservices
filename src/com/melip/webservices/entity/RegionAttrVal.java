package com.melip.webservices.entity;

/**
 * 地域属性値のエンティティクラスです。
 */
public class RegionAttrVal extends com.melip.webservices.entity.common.AbstractEntity {

  /** 地域属性値IDのフィールド名 */
  public static final String FIELD_REGION_ATTR_VAL_ID = "regionAttrValId";
  /** 地域IDのフィールド名 */
  public static final String FIELD_REGION_ID = "regionId";
  /** 地域属性グループIDのフィールド名 */
  public static final String FIELD_REGION_ATTR_GRP_ID = "regionAttrGrpId";

  /** 地域属性値ID */
  private Integer regionAttrValId;
  /** 地域ID */
  private Integer regionId;
  /** 地域属性グループID */
  private Integer regionAttrGrpId;

  /**
   * 地域属性値IDを取得します。
   * 
   * @return 地域属性値ID
   */
  public Integer getRegionAttrValId() {
    return regionAttrValId;
  }

  /**
   * 地域属性値IDを設定します。
   * 
   * @param regionAttrValId 地域属性値ID
   */
  public void setRegionAttrValId(Integer regionAttrValId) {
    this.regionAttrValId = regionAttrValId;
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
   * 地域属性グループIDを取得します。
   * 
   * @return 地域属性グループID
   */
  public Integer getRegionAttrGrpId() {
    return regionAttrGrpId;
  }

  /**
   * 地域属性グループIDを設定します。
   * 
   * @param regionAttrGrpId 地域属性グループID
   */
  public void setRegionAttrGrpId(Integer regionAttrGrpId) {
    this.regionAttrGrpId = regionAttrGrpId;
  }


}
