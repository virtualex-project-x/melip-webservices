package com.melip.webservices.entity;

/**
 * 施設_施設グループ_リンク属性値_多言語のエンティティクラスです。
 */
public class FacilityFacilityGrpLinkAttrValLang extends com.melip.webservices.entity.common.AbstractEntity {

  /** 施設_施設グループ_リンク属性値_多言語IDのフィールド名 */
  public static final String FIELD_FACILITY_FACILITY_GRP_LINK_ATTR_VAL_LANG_ID = "facilityFacilityGrpLinkAttrValLangId";
  /** 施設_施設グループ_リンク属性値IDのフィールド名 */
  public static final String FIELD_FACILITY_FACILITY_GRP_LINK_ATTR_VAL_ID = "facilityFacilityGrpLinkAttrValId";
  /** 言語区分のフィールド名 */
  public static final String FIELD_LANG_DIV = "langDiv";
  /** 値のフィールド名 */
  public static final String FIELD_VAL = "val";

  /** 施設_施設グループ_リンク属性値_多言語ID */
  private Integer facilityFacilityGrpLinkAttrValLangId;
  /** 施設_施設グループ_リンク属性値ID */
  private Integer facilityFacilityGrpLinkAttrValId;
  /** 言語区分 */
  private String langDiv;
  /** 値 */
  private String val;

  /**
   * 施設_施設グループ_リンク属性値_多言語IDを取得します。
   * 
   * @return 施設_施設グループ_リンク属性値_多言語ID
   */
  public Integer getFacilityFacilityGrpLinkAttrValLangId() {
    return facilityFacilityGrpLinkAttrValLangId;
  }

  /**
   * 施設_施設グループ_リンク属性値_多言語IDを設定します。
   * 
   * @param facilityFacilityGrpLinkAttrValLangId 施設_施設グループ_リンク属性値_多言語ID
   */
  public void setFacilityFacilityGrpLinkAttrValLangId(Integer facilityFacilityGrpLinkAttrValLangId) {
    this.facilityFacilityGrpLinkAttrValLangId = facilityFacilityGrpLinkAttrValLangId;
  }

  /**
   * 施設_施設グループ_リンク属性値IDを取得します。
   * 
   * @return 施設_施設グループ_リンク属性値ID
   */
  public Integer getFacilityFacilityGrpLinkAttrValId() {
    return facilityFacilityGrpLinkAttrValId;
  }

  /**
   * 施設_施設グループ_リンク属性値IDを設定します。
   * 
   * @param facilityFacilityGrpLinkAttrValId 施設_施設グループ_リンク属性値ID
   */
  public void setFacilityFacilityGrpLinkAttrValId(Integer facilityFacilityGrpLinkAttrValId) {
    this.facilityFacilityGrpLinkAttrValId = facilityFacilityGrpLinkAttrValId;
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
