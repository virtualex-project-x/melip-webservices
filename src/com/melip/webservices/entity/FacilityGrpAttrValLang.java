package com.melip.webservices.entity;

/**
 * 施設グループ属性値_多言語のエンティティクラスです。
 */
public class FacilityGrpAttrValLang extends com.melip.webservices.entity.common.AbstractEntity {

  /** 施設グループ属性値_多言語IDのフィールド名 */
  public static final String FIELD_FACILITY_GRP_ATTR_VAL_LANG_ID = "facilityGrpAttrValLangId";
  /** 施設グループ属性値IDのフィールド名 */
  public static final String FIELD_FACILITY_GRP_ATTR_VAL_ID = "facilityGrpAttrValId";
  /** 言語区分のフィールド名 */
  public static final String FIELD_LANG_DIV = "langDiv";
  /** 値のフィールド名 */
  public static final String FIELD_VAL = "val";

  /** 施設グループ属性値_多言語ID */
  private Integer facilityGrpAttrValLangId;
  /** 施設グループ属性値ID */
  private Integer facilityGrpAttrValId;
  /** 言語区分 */
  private String langDiv;
  /** 値 */
  private String val;

  /**
   * 施設グループ属性値_多言語IDを取得します。
   * 
   * @return 施設グループ属性値_多言語ID
   */
  public Integer getFacilityGrpAttrValLangId() {
    return facilityGrpAttrValLangId;
  }

  /**
   * 施設グループ属性値_多言語IDを設定します。
   * 
   * @param facilityGrpAttrValLangId 施設グループ属性値_多言語ID
   */
  public void setFacilityGrpAttrValLangId(Integer facilityGrpAttrValLangId) {
    this.facilityGrpAttrValLangId = facilityGrpAttrValLangId;
  }

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
   * 言語区分を取得します。
   * 
   * @return 言語区分
   */
  public String getLangDiv() {
    return langDiv;
  }

  /**
   * 言語区分を設定します。
   * 
   * @param langDiv 言語区分
   */
  public void setLangDiv(String langDiv) {
    this.langDiv = langDiv;
  }

  /**
   * 値を取得します。
   * 
   * @return 値
   */
  public String getVal() {
    return val;
  }

  /**
   * 値を設定します。
   * 
   * @param val 値
   */
  public void setVal(String val) {
    this.val = val;
  }


}
