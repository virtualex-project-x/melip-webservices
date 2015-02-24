package com.melip.webservices.entity;

/**
 * 施設グループ属性グループのエンティティクラスです。
 */
public class FacilityGrpAttrGrp extends com.melip.webservices.entity.common.AbstractEntity {

  /** 施設グループ属性グループIDのフィールド名 */
  public static final String FIELD_FACILITY_GRP_ATTR_GRP_ID = "facilityGrpAttrGrpId";
  /** 種別のフィールド名 */
  public static final String FIELD_TYPE = "type";
  /** コードグループIDのフィールド名 */
  public static final String FIELD_CD_GRP_ID = "cdGrpId";

  /** 施設グループ属性グループID */
  private Integer facilityGrpAttrGrpId;
  /** 種別 */
  private String type;
  /** コードグループID */
  private Integer cdGrpId;

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
