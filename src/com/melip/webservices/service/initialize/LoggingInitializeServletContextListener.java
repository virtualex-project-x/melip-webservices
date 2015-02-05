package com.melip.webservices.service.initialize;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Log4jConfigurer;

/**
 * Log4Jの初期化を行うクラスです。
 */
public class LoggingInitializeServletContextListener implements ServletContextListener {

  /** システムプロパティのMELIP設定ファイルのキー */
  private static final String SYSTEM_PROP_KEY_MELIP_PROPERTIES = "melip.props";
  /** MELIP設定のLog4J設定ファイルのキー */
  private static final String PROP_KEY_LOG4J_CONFIG = "melip.log.config";
  /** MELIP設定のLog4Jログ出力ディレクトリのキー */
  private static final String PROP_KEY_LOG4J_DIR = "melip.log.dir";
  /** デフォルトのLog4J設定 */
  private static final String DEFAULT_LOG4J_CONFIG =
      "classpath:com/melip/webservices/config/log4j-default.xml";

  private static final Logger log = LoggerFactory
      .getLogger(LoggingInitializeServletContextListener.class);

  /**
   * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
   */
  @Override
  public void contextInitialized(ServletContextEvent arg0) {

    try {
      String logConfigFilePath = null;

      SystemConfiguration sysConfig = new SystemConfiguration();
      String melipPropertiesPath = sysConfig.getString(SYSTEM_PROP_KEY_MELIP_PROPERTIES);
      if (StringUtils.isEmpty(melipPropertiesPath) || !new File(melipPropertiesPath).exists()) {
        logConfigFilePath = DEFAULT_LOG4J_CONFIG;
      } else {
        PropertiesConfiguration propConfig = new PropertiesConfiguration(melipPropertiesPath);
        logConfigFilePath = propConfig.getString(PROP_KEY_LOG4J_CONFIG);
        if (StringUtils.isEmpty(logConfigFilePath) || !new File(logConfigFilePath).exists()) {
          logConfigFilePath = DEFAULT_LOG4J_CONFIG;
        }

        // ログ出力先ディレクトリをシステムプロパティに設定
        String logDirPath = propConfig.getString(PROP_KEY_LOG4J_DIR);
        if (StringUtils.isNotEmpty(logDirPath)) {
          System.setProperty(PROP_KEY_LOG4J_DIR, logDirPath);
        }
      }

      Log4jConfigurer.initLogging(logConfigFilePath);

      if (DEFAULT_LOG4J_CONFIG.equals(logConfigFilePath)) {
        log.warn("Log4Jの設定ファイルが指定されていないため、デフォルト設定を使用します。");
      }

      log.info("Log4Jの初期化処理が終了しました。");
    } catch (Exception e) {
      log.error("Log4Jの初期化に失敗しました。", e);
    }
  }

  /**
   * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
   */
  @Override
  public void contextDestroyed(ServletContextEvent arg0) {}

}
