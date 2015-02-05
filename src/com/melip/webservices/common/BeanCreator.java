package com.melip.webservices.common;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Bean生成用のクラスです。
 */
public class BeanCreator {

  /** アプリケーションコンテキスト */
  private static ApplicationContext _applicationContext;

  /**
   * プライベートコンストラクタ<br>
   * インスタンス化はしない想定です。
   */
  private BeanCreator() {}

  /**
   * ServletContextに設定されているApplicationContextでBeanCreatorを初期化します。
   */
  public static void init(ServletContext servletContext) {

    _applicationContext =
        WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
  }

  /**
   * クラスパスのApplicationContextでBeanCreatorを初期化します。
   * 
   * @param applicationContextClassPath ApplicationContextのクラスパス
   */
  public static void init(String applicationContextClassPath) {
    _applicationContext = new ClassPathXmlApplicationContext(applicationContextClassPath);
  }

  /**
   * Beanオブジェクトを生成します。
   * 
   * @param beanId 生成するBeanのID
   * @param clazz 生成するBeanのクラス
   * @return Beanオブジェクト
   */
  public static <T> T getBean(String beanId, Class<T> clazz) {

    if (_applicationContext == null) {
      throw new IllegalStateException("BeanCreatorが初期化されていないため、ApplicationContextを取得できません。");
    }

    return (T) _applicationContext.getBean(beanId, clazz);
  }
}
