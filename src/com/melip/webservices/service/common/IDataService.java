package com.melip.webservices.service.common;

import java.util.List;

/**
 * データ管理用サービスのインタフェースです。
 */
public interface IDataService {

  /**
   * データを1件取得します。
   * 
   * @param sqlId SQL_ID
   * @return 検索結果
   */
  public <T extends Object> T selectOne(String sqlId);

  /**
   * データを1件取得します。
   * 
   * @param sqlId SQL_ID
   * @param param パラメータ
   * @return 検索結果
   */
  public <T extends Object> T selectOne(String sqlId, Object param);

  /**
   * データを複数件取得します。
   * 
   * @param sqlId SQL_ID
   * @return 検索結果
   */
  public <E extends Object> List<E> selectList(String sqlId);

  /**
   * データを複数件取得します。
   * 
   * @param sqlId SQL_ID
   * @param param パラメータ
   * @return 検索結果
   */
  public <E extends Object> List<E> selectList(String sqlId, Object param);

  /**
   * データを更新します。
   * 
   * @param sqlId SQL_ID
   * @return 更新件数
   */
  public int update(String sqlId);

  /**
   * データを更新します。
   * 
   * @param sqlId SQL_ID
   * @param param パラメータ
   * @return 更新件数
   */
  public int update(String sqlId, Object param);

}
