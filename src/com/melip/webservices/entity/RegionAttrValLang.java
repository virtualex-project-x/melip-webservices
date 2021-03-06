package com.melip.webservices.entity;

/**
 * 地域属性値_多言語のエンティティクラスです。
 */
public class RegionAttrValLang extends com.melip.webservices.entity.common.AbstractEntity {

  /** 地域属性値_多言語IDのフィールド名 */
  public static final String FIELD_REGION_ATTR_VAL_LANG_ID = "regionAttrValLangId";
  /** 地域属性値IDのフィールド名 */
  public static final String FIELD_REGION_ATTR_VAL_ID = "regionAttrValId";
  /** 言語区分のフィールド名 */
  public static final String FIELD_LANG_DIV = "langDiv";
  /** 値のフィールド名 */
  public static final String FIELD_VAL = "val";

  /** 地域属性値_多言語ID */
  private Integer regionAttrValLangId;
  /** 地域属性値ID */
  private Integer regionAttrValId;
  /** 言語区分 */
  private String langDiv;
  /** 値 */
  private String val;

  /**
   * 地域属性値_多言語IDを取得します。
   * 
   * @return 地域属性値_多言語ID
   */
  public Integer getRegionAttrValLangId() {
    return regionAttrValLangId;
  }

  /**
   * 地域属性値_多言語IDを設定します。
   * 
   * @param regionAttrValLangId 地域属性値_多言語ID
   */
  public void setRegionAttrValLangId(Integer regionAttrValLangId) {
    this.regionAttrValLangId = regionAttrValLangId;
  }

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
