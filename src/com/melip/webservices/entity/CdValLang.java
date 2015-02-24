package com.melip.webservices.entity;

/**
 * コード値_多言語のエンティティクラスです。
 */
public class CdValLang extends com.melip.webservices.entity.common.AbstractEntity {

  /** コード値_多言語IDのフィールド名 */
  public static final String FIELD_CD_VAL_LANG_ID = "cdValLangId";
  /** コード値IDのフィールド名 */
  public static final String FIELD_CD_VAL_ID = "cdValId";
  /** 言語区分のフィールド名 */
  public static final String FIELD_LANG_DIV = "langDiv";
  /** 名称のフィールド名 */
  public static final String FIELD_NM = "nm";

  /** コード値_多言語ID */
  private Integer cdValLangId;
  /** コード値ID */
  private Integer cdValId;
  /** 言語区分 */
  private String langDiv;
  /** 名称 */
  private String nm;

  /**
   * コード値_多言語IDを取得します。
   * 
   * @return コード値_多言語ID
   */
  public Integer getCdValLangId() {
    return cdValLangId;
  }

  /**
   * コード値_多言語IDを設定します。
   * 
   * @param cdValLangId コード値_多言語ID
   */
  public void setCdValLangId(Integer cdValLangId) {
    this.cdValLangId = cdValLangId;
  }

  /**
   * コード値IDを取得します。
   * 
   * @return コード値ID
   */
  public Integer getCdValId() {
    return cdValId;
  }

  /**
   * コード値IDを設定します。
   * 
   * @param cdValId コード値ID
   */
  public void setCdValId(Integer cdValId) {
    this.cdValId = cdValId;
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
