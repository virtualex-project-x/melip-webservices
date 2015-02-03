package com.melip.webservices.service.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.melip.common.constants.CodeConstants;

/**
 * 検索条件を表すクラスです。
 */
public class QueryCondition implements IQueryCondition {

  /** パラメータのキー */
  private static final String KEY_PARAM = "p";

  /** 検索条件マップ */
  private Map<Object, Object> value = new HashMap<Object, Object>();
  /** ステータス配列（デフォルトは「有効」） */
  private String[] stsArray = {CodeConstants.CODE_STS_VALID};
  /** 言語区分配列 */
  private String[] langDivArray;

  /**
   * コンストラクタ
   */
  public QueryCondition() {}

  /**
   * コンストラクタ
   * 
   * @param langDiv 言語区分
   */
  public QueryCondition(String langDiv) {
    setLangDiv(langDiv);
  }

  /**
   * コンストラクタ
   * 
   * @param param パラメータ
   */
  public QueryCondition(Object param) {
    setParam(param);
  }

  /**
   * コンストラクタ
   * 
   * @param langDiv 言語区分
   * @param param パラメータ
   */
  public QueryCondition(String langDiv, Object param) {
    setLangDiv(langDiv);
    setParam(param);
  }

  /**
   * @see com.melip.webservices.service.common.IQueryCondition#getV()
   */
  @Override
  public Map<Object, Object> getV() {
    return getValue();
  }

  /**
   * @see com.melip.webservices.service.common.IQueryCondition#getValue()
   */
  @Override
  public Map<Object, Object> getValue() {
    return this.value;
  }

  /**
   * @see com.melip.webservices.service.common.IQueryCondition#getValue(java.lang.Object)
   */
  @Override
  public Object getValue(Object key) {
    return this.value.get(key);
  }

  /**
   * @see com.melip.webservices.service.common.IQueryCondition#setValue(java.lang.Object,
   *      java.lang.Object)
   */
  @Override
  public void setValue(Object key, Object value) {
    this.value.put(key, value);
  }

  /**
   * @see com.melip.webservices.service.common.IQueryCondition#getP()
   */
  @Override
  public Object getP() {
    return getParam();
  }

  /**
   * @see com.melip.webservices.service.common.IQueryCondition#getParam()
   */
  @Override
  public Object getParam() {
    return null == this.value.get(KEY_PARAM) ? Collections.EMPTY_MAP : this.value.get(KEY_PARAM);
  }

  /**
   * @see com.melip.webservices.service.common.IQueryCondition#setParam(java.lang.Object)
   */
  @Override
  public void setParam(Object param) {
    this.value.put(KEY_PARAM, param);
  }

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
