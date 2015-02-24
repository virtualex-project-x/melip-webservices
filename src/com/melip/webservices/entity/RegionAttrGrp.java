package com.melip.webservices.entity;

/**
 * 地域属性グループのエンティティクラスです。
 */
public class RegionAttrGrp extends com.melip.webservices.entity.common.AbstractEntity {

  /** 地域属性グループIDのフィールド名 */
  public static final String FIELD_REGION_ATTR_GRP_ID = "regionAttrGrpId";
  /** 種別のフィールド名 */
  public static final String FIELD_TYPE = "type";
  /** コードグループIDのフィールド名 */
  public static final String FIELD_CD_GRP_ID = "cdGrpId";

  /** 地域属性グループID */
  private Integer regionAttrGrpId;
  /** 種別 */
  private String type;
  /** コードグループID */
  private Integer cdGrpId;

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

  /**
   * 種別を取得します。
   * 
   * @return 種別
   */
  public String getType() {
    return type;
  }

  /**
   * 種別を設定します。
   * 
   * @param type 種別
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * コードグループIDを取得します。
   * 
   * @return コードグループID
   */
  public Integer getCdGrpId() {
    return cdGrpId;
  }

  /**
   * コードグループIDを設定します。
   * 
   * @param cdGrpId コードグループID
   */
  public void setCdGrpId(Integer cdGrpId) {
    this.cdGrpId = cdGrpId;
  }


}
