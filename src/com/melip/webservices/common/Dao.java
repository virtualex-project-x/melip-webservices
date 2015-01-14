/**
 * 
 */
package com.melip.webservices.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * DAOクラスです。<br>
 * Springによりシングルトンとして生成されます。
 */
public class Dao implements IDao {

  /** SQL実行用のSQLSession */
  private SqlSessionFactory _sessionFactory = null;
  /** MyBatis設定ファイル名 */
  private String resourceFileName = null;

  /**
   * 初期化処理を実施します。<br>
   * MyBatis設定情報を読み込みます。
   * 
   * @throws IOException
   */
  public void init() throws IOException {

    InputStream in = Resources.getResourceAsStream(getResourceFileName());
    _sessionFactory = new SqlSessionFactoryBuilder().build(in);
  }

  /**
   * @see com.melip.webservices.common.IDao#getDaoFactory()
   */
  @Override
  public SqlSessionFactory getSqlSessionFactory() {
    return this._sessionFactory;
  }

  /**
   * MyBatis設定ファイル名を取得します。
   * 
   * @return MyBatis設定ファイルのパス
   */
  public String getResourceFileName() {
    return resourceFileName;
  }

  /**
   * MyBatis設定ファイル名を設定します。
   * 
   * @param resourceFileName MyBatis設定ファイルのパス
   */
  public void setResourceFileName(String resourceFileName) {
    this.resourceFileName = resourceFileName;
  }

}
