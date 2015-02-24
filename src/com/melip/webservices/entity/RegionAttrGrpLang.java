package com.melip.webservices.entity;

/**
 * 地域属性グループ_多言語のエンティティクラスです。
 */
public class RegionAttrGrpLang extends com.melip.webservices.entity.common.AbstractEntity {

  /** 地域属性グループ_多言語IDのフィールド名 */
  public static final String FIELD_REGION_ATTR_GRP_LANG_ID = "regionAttrGrpLangId";
  /** 地域属性グループIDのフィールド名 */
  public static final String FIELD_REGION_ATTR_GRP_ID = "regionAttrGrpId";
  /** 言語区分のフィールド名 */
  public static final String FIELD_LANG_DIV = "langDiv";
  /** 名称のフィールド名 */
  public static final String FIELD_NM = "nm";

  /** 地域属性グループ_多言語ID */
  private Integer regionAttrGrpLangId;
  /** 地域属性グループID */
  private Integer regionAttrGrpId;
  /** 言語区分 */
  private String langDiv;
  /** 名称 */
  private String nm;

  /**
   * 地域属性グループ_多言語IDを取得します。
   * 
   * @return 地域属性グループ_多言語ID
   */
  public Integer getRegionAttrGrpLangId() {
    return regionAttrGrpLangId;
  }

  /**
   * 地域属性グループ_多言語IDを設定します。
   * 
   * @param regionAttrGrpLangId 地域属性グループ_多言語ID
   */
  public void setRegionAttrGrpLangId(Integer regionAttrGrpLangId) {
    this.regionAttrGrpLangId = regionAttrGrpLangId;
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
   * 名称を取得します。
   * 
   * @return 名称
   */
  public String getNm() {
    return nm;
  }

  /**
   * 名称を設定します。
   * 
   * @param nm 名称
   */
  public void setNm(String nm) {
    this.nm = nm;
  }


}
