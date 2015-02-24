package com.melip.webservices.entity;

/**
 * 施設属性値_多言語のエンティティクラスです。
 */
public class FacilityAttrValLang extends com.melip.webservices.entity.common.AbstractEntity {

  /** 施設属性値_多言語IDのフィールド名 */
  public static final String FIELD_FACILITY_ATTR_VAL_LANG_ID = "facilityAttrValLangId";
  /** 施設属性値IDのフィールド名 */
  public static final String FIELD_FACILITY_ATTR_VAL_ID = "facilityAttrValId";
  /** 言語区分のフィールド名 */
  public static final String FIELD_LANG_DIV = "langDiv";
  /** 値のフィールド名 */
  public static final String FIELD_VAL = "val";

  /** 施設属性値_多言語ID */
  private Integer facilityAttrValLangId;
  /** 施設属性値ID */
  private Integer facilityAttrValId;
  /** 言語区分 */
  private String langDiv;
  /** 値 */
  private String val;

  /**
   * 施設属性値_多言語IDを取得します。
   * 
   * @return 施設属性値_多言語ID
   */
  public Integer getFacilityAttrValLangId() {
    return facilityAttrValLangId;
  }

  /**
   * 施設属性値_多言語IDを設定します。
   * 
   * @param facilityAttrValLangId 施設属性値_多言語ID
   */
  public void setFacilityAttrValLangId(Integer facilityAttrValLangId) {
    this.facilityAttrValLangId = facilityAttrValLangId;
  }

  /**
   * 施設属性値IDを取得します。
   * 
   * @return 施設属性値ID
   */
  public Integer getFacilityAttrValId() {
    return facilityAttrValId;
  }

  /**
   * 施設属性値IDを設定します。
   * 
   * @param facilityAttrValId 施設属性値ID
   */
  public void setFacilityAttrValId(Integer facilityAttrValId) {
    this.facilityAttrValId = facilityAttrValId;
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
