package com.melip.webservices.service.common;

import java.util.List;

import com.melip.common.dto.common.AbstractDto;

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
  public <T extends AbstractDto> T selectOne(String sqlId);

  /**
   * 検索条件を元にデータを1件取得します。
   * 
   * @param sqlId SQL_ID
   * @param condition 検索条件
   * @return 検索結果
   */
  public <To extends AbstractDto, Ti extends SearchCondition> To selectOne(String sqlId,
      Ti condition);

  /**
   * データを複数件取得します。
   * 
   * @param sqlId SQL_ID
   * @return 検索結果
   */
  public <E extends AbstractDto> List<E> selectList(String sqlId);

  /**
   * 検索条件を元にデータを複数件取得します。
   * 
   * @param sqlId SQL_ID
   * @param condition 検索条件
   * @return 検索結果
   */
  public <E extends AbstractDto, T extends SearchCondition> List<E> selectList(String sqlId,
      T condition);
}
