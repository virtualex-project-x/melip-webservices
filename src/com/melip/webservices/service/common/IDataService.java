package com.melip.webservices.service.common;

import java.util.List;

import com.melip.common.dto.common.IDto;

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
  public <T extends IDto> T selectOne(String sqlId);

  /**
   * 検索条件を元にデータを1件取得します。
   * 
   * @param sqlId SQL_ID
   * @param condition 検索条件
   * @return 検索結果
   */
  public <T extends IDto> T selectOne(String sqlId, QueryCondition condition);

  /**
   * データを複数件取得します。
   * 
   * @param sqlId SQL_ID
   * @return 検索結果
   */
  public <E extends IDto> List<E> selectList(String sqlId);

  /**
   * 検索条件を元にデータを複数件取得します。
   * 
   * @param sqlId SQL_ID
   * @param condition 検索条件
   * @return 検索結果
   */
  public <E extends IDto> List<E> selectList(String sqlId, QueryCondition condition);
}
