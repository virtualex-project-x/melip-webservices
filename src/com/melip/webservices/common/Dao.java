/**
 * 
 */
package com.melip.webservices.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.melip.common.constants.CommonConstants;
import com.melip.webservices.constants.MelipPropertiesConstants;

/**
 * DAOクラスです。<br>
 * Springによりシングルトンとして生成されます。
 */
public class Dao implements IDao {

  /** SQL実行用のSQLSession */
  private SqlSessionFactory sessionFactory;
  /** MyBatis設定ファイル名 */
  private String resourceFileName;
  /** MELIP設定ファイルパス */
  private String melipPropertiesPath;

  /**
   * コンストラクタ<br>
   * シングルトンのためプライベートとします。
   */
  private Dao() {}

  /**
   * 初期化処理を実施します。<br>
   * MyBatis設定情報を読み込みます。
   * 
   * @throws IOException
   */
  public void init() throws IOException {

    String propFilePath = getMelipPropertiesPath();
    if (StringUtils.isEmpty(propFilePath) || !new File(propFilePath).exists()) {
      propFilePath =
          this.getClass().getClassLoader()
              .getResource(MelipPropertiesConstants.CLASS_PATH_DEFAULT_MELIP_PROPERTIES).getPath();
    }

    Properties props = new Properties();
    props.load(new InputStreamReader(new FileInputStream(propFilePath),
        CommonConstants.SYSTEM_CHARSET));

    InputStream in = Resources.getResourceAsStream(getResourceFileName());
    sessionFactory = new SqlSessionFactoryBuilder().build(in, props);
  }

  /**
   * @see com.melip.webservices.common.IDao#getDaoFactory()
   */
  @Override
  public SqlSessionFactory getSqlSessionFactory() {
    return this.sessionFactory;
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

  /**
   * MELIP設定ファイルパスを取得します。
   * 
   * @return MELIP設定ファイルパス
   */
  public String getMelipPropertiesPath() {
    return melipPropertiesPath;
  }

  /**
   * MELIP設定ファイルパスを設定します。
   * 
   * @param melipPropertiesPath MELIP設定ファイルパス
   */
  public void setMelipPropertiesPath(String melipPropertiesPath) {
    this.melipPropertiesPath = melipPropertiesPath;
  }

}
