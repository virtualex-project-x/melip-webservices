package com.melip.webservices.entity;

/**
 * コードグループのエンティティクラスです。
 */
public class CdGrp extends com.melip.webservices.entity.common.AbstractEntity {

  /** コードグループIDのフィールド名 */
  public static final String FIELD_CD_GRP_ID = "cdGrpId";
  /** エイリアスのフィールド名 */
  public static final String FIELD_ALIAS = "alias";
  /** 名称のフィールド名 */
  public static final String FIELD_NM = "nm";
  /** 概要のフィールド名 */
  public static final String FIELD_SUMMARY = "summary";

  /** コードグループID */
  private Integer cdGrpId;
  /** エイリアス */
  private String alias;
  /** 名称 */
  private String nm;
  /** 概要 */
  private String summary;

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

  /**
   * 概要を取得します。
   * 
   * @return 概要
   */
  public String getSummary() {
    return summary;
  }

  /**
   * 概要を設定します。
   * 
   * @param summary 概要
   */
  public void setSummary(String summary) {
    this.summary = summary;
  }


}
