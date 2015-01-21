package com.melip.webservices.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean生成用のクラスです。
 */
public class BeanCreator {

  /** アプリケーションコンテキスト */
  private static ApplicationContext _applicationContext;
  /** コンテキストパス */
  private static final String CONTEXT_PATH = "com/melip/webservices/config/applicationContext.xml";

  /**
   * プライベートコンストラクタ<br>
   * インスタンス化はしない想定です。
   */
  private BeanCreator() {}

  static {
    init();
  }

  /**
   * 初期化処理を実施します。
   */
  private static void init() {
    _applicationContext = new ClassPathXmlApplicationContext(new String[] {CONTEXT_PATH});
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
      init();
    }

    return (T) _applicationContext.getBean(beanId, clazz);
  }
}
