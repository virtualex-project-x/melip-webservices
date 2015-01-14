package com.melip.webservices.common;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * DAOの基底インタフェースです。
 */
public interface IDao {

  /**
   * SQL実行用のSQLSessionFactoryを取得します。
   * 
   * @return SQL実行用のSQLSessionFactory
   */
  public SqlSessionFactory getSqlSessionFactory();
}
