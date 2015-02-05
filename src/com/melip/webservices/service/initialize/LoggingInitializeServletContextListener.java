package com.melip.webservices.service.initialize;

import java.io.File;
import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Log4jConfigurer;

import com.melip.webservices.constants.MelipPropertiesConstants;

/**
 * Log4Jの初期化を行うクラスです。
 */
public class LoggingInitializeServletContextListener implements ServletContextListener {

  /** デフォルトのLog4J設定 */
  private static final String DEFAULT_LOG4J_CONFIG_FILE =
      "classpath:com/melip/webservices/config/log4j-default.xml";

  private static final Logger log = LoggerFactory
      .getLogger(LoggingInitializeServletContextListener.class);

  /**
   * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
   */
  @Override
  public void contextInitialized(ServletContextEvent arg0) {

    try {
      // プロパティ設定を取得
      Configuration config = getPropertiesConfiguration();

      String logConfigFilePath = config.getString(MelipPropertiesConstants.PROP_KEY_LOG_CONF_FILE);
      if (StringUtils.isEmpty(logConfigFilePath) || !new File(logConfigFilePath).exists()) {
        logConfigFilePath = DEFAULT_LOG4J_CONFIG_FILE;
      }

      Log4jConfigurer.initLogging(logConfigFilePath);

      if (DEFAULT_LOG4J_CONFIG_FILE.equals(logConfigFilePath)) {
        log.warn("Log4Jの設定ファイルが指定されていないため、デフォルト設定を使用します。");
      }

      log.info("Log4Jの初期化処理が終了しました。[" + logConfigFilePath + "]");
    } catch (Exception e) {
      log.error("Log4Jの初期化に失敗しました。", e);
    }
  }

  /**
   * プロパティ設定を取得します。<br>
   * システムプロパティ、拡張MELIP設定、デフォルトのMELIP設定をマージして返します。<br>
   * また、ログ出力先ディレクトリをシステムプロパティに設定します。
   * 
   * @return プロパティ設定
   * @throws ConfigurationException
   */
  private Configuration getPropertiesConfiguration() throws ConfigurationException {

    CompositeConfiguration config = new CompositeConfiguration();

    // システムプロパティ
    config.addConfiguration(new SystemConfiguration());

    // 拡張MELIP設定
    // 同一キーはマージされないため、デフォルト設定より先に拡張設定を読み込む
    String extProp = System.getProperty(MelipPropertiesConstants.SYS_PROP_KEY_MELIP_PROPERTIES);
    if (StringUtils.isNotEmpty(extProp) && new File(extProp).exists()) {
      config.addConfiguration(new PropertiesConfiguration(extProp));
    }

    // デフォルトのMELIP設定
    URL defaultPropUrl =
        this.getClass().getClassLoader()
            .getResource(MelipPropertiesConstants.CLASS_PATH_DEFAULT_MELIP_PROPERTIES);
    if (null != defaultPropUrl) {
      config.addConfiguration(new PropertiesConfiguration(defaultPropUrl));
    }

    // ログ出力先ディレクトリをシステムプロパティに設定
    String logDirPath = config.getString(MelipPropertiesConstants.PROP_KEY_MELIP_LOG_DIR);
    if (StringUtils.isNotEmpty(logDirPath)) {
      System.setProperty(MelipPropertiesConstants.PROP_KEY_MELIP_LOG_DIR, logDirPath);
    }

    return config;
  }

  /**
   * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
   */
  @Override
  public void contextDestroyed(ServletContextEvent arg0) {}

}
