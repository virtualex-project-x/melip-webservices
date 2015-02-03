package com.melip.webservices.service.common;

import java.util.Map;

/**
 * 検索条件のインタフェースです。
 */
public interface IQueryCondition {

  /**
   * 検索条件のマップを取得します。<br>
   * {@link#getValue()}へのエイリアスです。<br>
   * 
   * <pre>
   * マッパーXMLファイルでのコーディングは、「v.」から始まり、指定したキーで属性の値が取得できます。
   * 取得例を以下に示します。
   *    ・単一データ（StringやIntegerなど）の場合：#{v.キー名}
   *    ・Mapタイプの場合：#{v.マップキー名}
   *    ・Beanタイプの場合：#{v.プロパティ名}
   *    ・コンポジットすることによりドットでつなげて取得することが可能です。：#{v.キー名.キー名・・・}
   * </pre>
   * 
   * @return 検索条件マップ
   */
  public Map<Object, Object> getV();

  /**
   * 検索条件のマップを取得します。
   * 
   * @return 検索条件マップ
   */
  public Map<Object, Object> getValue();

  /**
   * 検索条件の属性値を取得します。
   * 
   * @param key 属性のキー
   * @return 検索条件の属性値
   */
  public Object getValue(Object key);

  /**
   * 検索条件の属性値を設定します。
   * 
   * @param key 属性のキー
   * @param value 属性の値
   */
  public void setValue(Object key, Object value);

  /**
   * パラメータを取得します。<br>
   * {@link#getParam()}へのエイリアスです。<br>
   * 
   * <pre>
   * マッパーXMLファイルでのコーディングは、「p.」から始まり、指定したキーでパラメータの値が取得できます。
   * 取得例を以下に示します。
   *    ・単一データ（StringやIntegerなど）の場合：#{p.キー名}
   *    ・Mapタイプの場合：#{p.マップキー名}
   *    ・Beanタイプの場合：#{p.プロパティ名}
   *    ・コンポジットすることによりドットでつなげて取得することが可能です。：#{p.キー名.キー名・・・}
   * </pre>
   * 
   * @return パラメータ
   */
  public Object getP();

  /**
   * パラメータを取得します。
   * 
   * @return パラメータ
   */
  public Object getParam();

  /**
   * パラメータを設定します。
   * 
   * @param param パラメータ
   */
  public void setParam(Object param);
}
