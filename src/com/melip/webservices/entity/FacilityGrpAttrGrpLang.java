package com.melip.webservices.entity;

/**
 * 施設グループ属性グループ_多言語のエンティティクラスです。
 */
public class FacilityGrpAttrGrpLang extends com.melip.webservices.entity.common.AbstractEntity {

  /** 施設グループ属性グループ_多言語IDのフィールド名 */
  public static final String FIELD_FACILITY_GRP_ATTR_GRP_LANG_ID = "facilityGrpAttrGrpLangId";
  /** 施設グループ属性グループIDのフィールド名 */
  public static final String FIELD_FACILITY_GRP_ATTR_GRP_ID = "facilityGrpAttrGrpId";
  /** 言語区分のフィールド名 */
  public static final String FIELD_LANG_DIV = "langDiv";
  /** 名称のフィールド名 */
  public static final String FIELD_NM = "nm";

  /** 施設グループ属性グループ_多言語ID */
  private Integer facilityGrpAttrGrpLangId;
  /** 施設グループ属性グループID */
  private Integer facilityGrpAttrGrpId;
  /** 言語区分 */
  private String langDiv;
  /** 名称 */
  private String nm;

  /**
   * 施設グループ属性グループ_多言語IDを取得します。
   * 
   * @return 施設グループ属性グループ_多言語ID
   */
  public Integer getFacilityGrpAttrGrpLangId() {
    return facilityGrpAttrGrpLangId;
  }

  /**
   * 施設グループ属性グループ_多言語IDを設定します。
   * 
   * @param facilityGrpAttrGrpLangId 施設グループ属性グループ_多言語ID
   */
  public void setFacilityGrpAttrGrpLangId(Integer facilityGrpAttrGrpLangId) {
    this.facilityGrpAttrGrpLangId = facilityGrpAttrGrpLangId;
  }

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
