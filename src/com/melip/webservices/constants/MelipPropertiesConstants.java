package com.melip.webservices.constants;

/**
 * MELIPのプロパティ関連の定数定義用クラスです。
 */
public class MelipPropertiesConstants {

  /**
   * コンストラクタ<br>
   * インスタンス化できません。
   */
  private MelipPropertiesConstants() {}

  /** システムプロパティのMELIP設定ファイルのキー {@value} */
  public static final String SYS_PROP_KEY_MELIP_PROPERTIES = "melip.props";
  /** MELIPのホームディレクトリのキー {@value} */
  public static final String PROP_KEY_MELIP_HOME_DIR = "melip.home";
  /** MELIPの設定ディレクトリのキー {@value} */
  public static final String PROP_KEY_MELIP_CONF_DIR = "melip.config.dir";
  /** MELIPのログディレクトリのキー {@value} */
  public static final String PROP_KEY_MELIP_LOG_DIR = "melip.log.dir";
  /** MELIPのLog4J設定ファイルのキー {@value} */
  public static final String PROP_KEY_LOG_CONF_FILE = "melip.log.config";

  /** データベースドライバのキー {@value} */
  public static final String PROP_KEY_DB_DRIVER = "db.driver.class";
  /** データベースURLのキー {@value} */
  public static final String PROP_KEY_DB_URL = "db.url";
  /** データベースユーザ名のキー {@value} */
  public static final String PROP_KEY_DB_USER = "db.username";
  /** データベースパスワードのキー {@value} */
  public static final String PROP_KEY_DB_PASS = "db.password";

  /** デフォルトのMELIP設定ファイルのクラスパス {@value} */
  public static final String CLASS_PATH_DEFAULT_MELIP_PROPERTIES =
      "com/melip/webservices/config/melip-default.properties";

}
