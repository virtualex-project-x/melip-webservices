package com.melip.webservices.service.initialize;

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

    log.info("システムの初期化処理を開始します。");
    initSystem();
    log.info("システムの初期化処理が終了しました。");
  }

  /**
   * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
   */
  @Override
  public void contextDestroyed(ServletContextEvent arg0) {}

  /**
   * システムの初期化処理を実行します。
   */
  private void initSystem() {

    ISystemInitializeService initService =
        BeanCreator.getBean(ISystemInitializeService.SERVICE_NAME, ISystemInitializeService.class);
    initService.initializeSystem();
  }
}
