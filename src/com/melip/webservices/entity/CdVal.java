package com.melip.webservices.entity;

/**
 * コード値のエンティティクラスです。
 */
public class CdVal extends com.melip.webservices.entity.common.AbstractEntity {

  /** コード値IDのフィールド名 */
  public static final String FIELD_CD_VAL_ID = "cdValId";
  /** コードグループIDのフィールド名 */
  public static final String FIELD_CD_GRP_ID = "cdGrpId";
  /** コードのフィールド名 */
  public static final String FIELD_CD = "cd";
  /** エイリアスのフィールド名 */
  public static final String FIELD_ALIAS = "alias";
  /** 表示順のフィールド名 */
  public static final String FIELD_DISPLAY_NUM = "displayNum";

  /** コード値ID */
  private Integer cdValId;
  /** コードグループID */
  private Integer cdGrpId;
  /** コード */
  private String cd;
  /** エイリアス */
  private String alias;
  /** 表示順 */
  private Integer displayNum;

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
   * コードを取得します。
   * 
   * @return コード
   */
  public String getCd() {
    return cd;
  }

  /**
   * コードを設定します。
   * 
   * @param cd コード
   */
  public void setCd(String cd) {
    this.cd = cd;
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
   * 表示順を取得します。
   * 
   * @return 表示順
   */
  public Integer getDisplayNum() {
    return displayNum;
  }

  /**
   * 表示順を設定します。
   * 
   * @param displayNum 表示順
   */
  public void setDisplayNum(Integer displayNum) {
    this.displayNum = displayNum;
  }


}
