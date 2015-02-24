package com.melip.webservices.entity;

/**
 * 施設_施設グループ_リンク属性グループ_多言語のエンティティクラスです。
 */
public class FacilityFacilityGrpLinkAttrGrpLang extends com.melip.webservices.entity.common.AbstractEntity {

  /** 施設_施設グループ_リンク属性グループ_多言語IDのフィールド名 */
  public static final String FIELD_FACILITY_FACILITY_GRP_LINK_ATTR_GRP_LANG_ID = "facilityFacilityGrpLinkAttrGrpLangId";
  /** 施設_施設グループ_リンク属性グループIDのフィールド名 */
  public static final String FIELD_FACILITY_FACILITY_GRP_LINK_ATTR_GRP_ID = "facilityFacilityGrpLinkAttrGrpId";
  /** 言語区分のフィールド名 */
  public static final String FIELD_LANG_DIV = "langDiv";
  /** 名称のフィールド名 */
  public static final String FIELD_NM = "nm";

  /** 施設_施設グループ_リンク属性グループ_多言語ID */
  private Integer facilityFacilityGrpLinkAttrGrpLangId;
  /** 施設_施設グループ_リンク属性グループID */
  private Integer facilityFacilityGrpLinkAttrGrpId;
  /** 言語区分 */
  private String langDiv;
  /** 名称 */
  private String nm;

  /**
   * 施設_施設グループ_リンク属性グループ_多言語IDを取得します。
   * 
   * @return 施設_施設グループ_リンク属性グループ_多言語ID
   */
  public Integer getFacilityFacilityGrpLinkAttrGrpLangId() {
    return facilityFacilityGrpLinkAttrGrpLangId;
  }

  /**
   * 施設_施設グループ_リンク属性グループ_多言語IDを設定します。
   * 
   * @param facilityFacilityGrpLinkAttrGrpLangId 施設_施設グループ_リンク属性グループ_多言語ID
   */
  public void setFacilityFacilityGrpLinkAttrGrpLangId(Integer facilityFacilityGrpLinkAttrGrpLangId) {
    this.facilityFacilityGrpLinkAttrGrpLangId = facilityFacilityGrpLinkAttrGrpLangId;
  }

  /**
   * 施設_施設グループ_リンク属性グループIDを取得します。
   * 
   * @return 施設_施設グループ_リンク属性グループID
   */
  public Integer getFacilityFacilityGrpLinkAttrGrpId() {
    return facilityFacilityGrpLinkAttrGrpId;
  }

  /**
   * 施設_施設グループ_リンク属性グループIDを設定します。
   * 
   * @param facilityFacilityGrpLinkAttrGrpId 施設_施設グループ_リンク属性グループID
   */
  public void setFacilityFacilityGrpLinkAttrGrpId(Integer facilityFacilityGrpLinkAttrGrpId) {
    this.facilityFacilityGrpLinkAttrGrpId = facilityFacilityGrpLinkAttrGrpId;
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
