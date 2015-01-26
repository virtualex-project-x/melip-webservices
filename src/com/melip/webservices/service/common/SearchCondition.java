package com.melip.webservices.service.common;

import com.melip.common.constants.CodeConstants;

/**
 * 検索条件を表すクラスです。<br>
 * 各サービス独自の検索条件はこのクラスを拡張して作成します。
 */
public class SearchCondition {

  /** ステータス配列（デフォルトは「有効」） */
  private String[] stsArray = {CodeConstants.CODE_STS_VALID};
  /** 言語区分配列 */
  private String[] langDivArray;

  /**
   * ステータス配列を取得します。
   * 
   * @return ステータス配列
   */
  public String[] getStsArray() {
    return stsArray;
  }

  /**
   * ステータス配列を設定します。
   * 
   * @param stsArray ステータス配列
   */
  public void setStsArray(String[] stsArray) {
    this.stsArray = stsArray;
  }

  /**
   * 言語区分配列を取得します。
   * 
   * @return 言語区分配列
   */
  public String[] getLangDivArray() {
    return langDivArray;
  }

  /**
   * 言語区分配列を設定します。
   * 
   * @param langDivArray 言語区分配列
   */
  public void setLangDivArray(String[] langDivArray) {
    this.langDivArray = langDivArray;
  }

  /**
   * 言語区分を設定します。<br>
   * 言語区分「共通（common）」は自動的に付与されます。
   * 
   * @param langDiv 言語区分
   */
  public void setLangDiv(String langDiv) {
    setLangDivArray(new String[] {langDiv, CodeConstants.CODE_LANG_DIV_COMMON});
  }

}
