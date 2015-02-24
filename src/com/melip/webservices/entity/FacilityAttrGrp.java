package com.melip.webservices.entity;

/**
 * 施設属性グループのエンティティクラスです。
 */
public class FacilityAttrGrp extends com.melip.webservices.entity.common.AbstractEntity {

  /** 施設属性グループIDのフィールド名 */
  public static final String FIELD_FACILITY_ATTR_GRP_ID = "facilityAttrGrpId";
  /** エイリアスのフィールド名 */
  public static final String FIELD_ALIAS = "alias";
  /** 種別のフィールド名 */
  public static final String FIELD_TYPE = "type";
  /** コードグループIDのフィールド名 */
  public static final String FIELD_CD_GRP_ID = "cdGrpId";

  /** 施設属性グループID */
  private Integer facilityAttrGrpId;
  /** エイリアス */
  private String alias;
  /** 種別 */
  private String type;
  /** コードグループID */
  private Integer cdGrpId;

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

  /**
   * エイリアスを取得します。
   * 
   * @return エイリアス
   */
  public String getAlias() {
    return alias;
  }

  /**
   * エイリアスを設定します。
   * 
   * @param alias エイリアス
   */
  public void setAlias(String alias) {
    this.alias = alias;
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
