package com.melip.webservices.service.initialize;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.melip.webservices.common.BeanCreator;

/**
 * SystemInitializeServiceを利用してシステムの初期化処理を実行するクラスです。
 */
public class InitializeServletContextListener implements ServletContextListener {

  private Logger log = LoggerFactory.getLogger(InitializeServletContextListener.class);

  /**
   * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
   */
  @Override
  public void contextInitialized(ServletContextEvent arg0) {

    try {
      log.info("システムの初期化処理を開始します。");
      initSystem(arg0.getServletContext());
      log.info("システムの初期化処理が終了しました。");
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      log.info("システムの初期化処理が失敗しました。");
      throw new RuntimeException(e);
    }
  }

  /**
   * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
   */
  @Override
  public void contextDestroyed(ServletContextEvent arg0) {}

  /**
   * システムの初期化処理を実行します。
   */
  private void initSystem(ServletContext servletContext) {

    // BeanCreatorの初期化
    log.info("BeanCreatorの初期化を開始します。");
    BeanCreator.init(servletContext);
    log.info("BeanCreatorの初期化が終了しました。");

    // システム初期化
    ISystemInitializeService initService =
        BeanCreator.getBean(ISystemInitializeService.SERVICE_NAME, ISystemInitializeService.class);
    initService.initializeSystem();
  }
}
