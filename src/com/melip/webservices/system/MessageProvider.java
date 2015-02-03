package com.melip.webservices.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.melip.webservices.common.BeanCreator;

/**
 * アプリケーションで利用するメッセージを文字列を提供するクラスです。<br>
 * メッセージファイルは、プロパティファイル（.properties)として作成し、本クラスに設定します。<br>
 * Springによりシングルトンとして生成されます。
 */
public class MessageProvider {

  /** キーとメッセージのセパレータ */
  public static final String SEPARATOR = " : ";
  /** メッセージパラメータの開始カッコ */
  public static final String BRACE_PARAM_START = "${";
  /** メッセージパラメータの終了カッコ */
  public static final String BRACE_PARAM_END = "}";

  /** DIコンテナ登録用の名称 */
  private static final String BEAN_ID = "messageProvider";
  /** プロパティファイルの文字コード */
  private static final String CHARSET_PROPERTY = "UTF-8";

  private static final Logger log = LoggerFactory.getLogger(MessageProvider.class);

  /** メッセージプロパティファイルのクラスパス */
  private String propertyFileClassPath;
  /** メッセージプロパティファイルのパス */
  private String propertyFilePath;
  /** プロパティのマップ */
  private Map<String, String> propertyMap;

  // TODO:プライベートコンストラクタにも関わらずなぜSpringはインスタンス化できるのか？
  /**
   * コンストラクタ<br>
   * シングルトンのためプライベートとします。
   */
  private MessageProvider() {}

  /**
   * メッセージプロバイダを取得します。
   * 
   * @return メッセージプロバイダ
   */
  private static MessageProvider getMessageProvider() {
    return BeanCreator.getBean(BEAN_ID, MessageProvider.class);
  }

  /**
   * メッセージプロパティファイルを設定します。<br>
   * 本クラスのインスタンスに設定されたメッセージプロパティファイルのクラスパスを使用します。<br>
   * クラスパスが設定されていない場合はパスを使用します。<br>
   * どちらも設定されていない場合はエラーとします。
   * 
   * @throws IOException
   */
  public static void registerProperty() throws IOException {

    MessageProvider provider = getMessageProvider();
    String classPath = provider.getPropertyFileClassPath();
    String path = provider.getPropertyFilePath();

    if (StringUtils.isNotEmpty(classPath)) {
      log.info("メッセージプロパティファイル[" + classPath + "]を読み込みます。");
      registerPropertyByClassPath(classPath);
    } else if (StringUtils.isNotEmpty(path)) {
      log.info("メッセージプロパティファイル[" + path + "]を読み込みます。");
      registerPropertyByPath(provider.getPropertyFilePath());
    } else {
      throw new RuntimeException("メッセージプロパティファイルが設定されていません。");
    }
  }

  /**
   * メッセージプロパティファイルを設定します。
   * 
   * @param propertyFileClassPath メッセージプロパティファイルのクラスパス
   * @throws IOException
   */
  public static void registerPropertyByClassPath(String propertyFileClassPath) throws IOException {

    URL propertyFileUrl =
        getMessageProvider().getClass().getClassLoader().getResource(propertyFileClassPath);
    File propertyFile = new File(propertyFileUrl.getPath());
    registerPropertyByReader(new InputStreamReader(new FileInputStream(propertyFile),
        CHARSET_PROPERTY));
  }

  /**
   * メッセージプロパティファイルを設定します。
   * 
   * @param propertyFilePath メッセージプロパティファイルのパス
   * @throws IOException
   */
  public static void registerPropertyByPath(String propertyFilePath) throws IOException {

    File propertyFile = new File(propertyFilePath);
    registerPropertyByReader(new InputStreamReader(new FileInputStream(propertyFile),
        CHARSET_PROPERTY));
  }

  /**
   * メッセージプロパティファイルを設定します。
   * 
   * @param reader メッセージプロパティファイルのリーダ
   * @throws IOException
   */
  public static void registerPropertyByReader(Reader reader) throws IOException {

    Properties property = new Properties();
    property.load(reader);
    registerProperty(property);
  }

  /**
   * メッセージプロパティを設定します。
   * 
   * @param property プロパティ
   */
  public static void registerProperty(Properties property) {

    for (Iterator<String> messageKeys = property.stringPropertyNames().iterator(); messageKeys
        .hasNext();) {
      String messageKey = messageKeys.next();
      String messageValue = property.getProperty(messageKey);
      registerProperty(messageKey, messageValue);
    }
  }

  /**
   * メッセージプロパティを設定します。
   * 
   * @param messageKey メッセージキー
   * @param messageValue メッセージ
   */
  public static void registerProperty(String messageKey, String messageValue) {
    getMessageProvider().getPropertyMap().put(messageKey, messageValue);
  }

  /**
   * メッセージを構築します。<br>
   * メッセージキーも出力します。
   * 
   * @param messageKey メッセージキー
   * @return メッセージ
   */
  public static String formatMessage(String messageKey) {
    return formatMessage(messageKey, null, true);
  }

  /**
   * メッセージを構築します。<br>
   * メッセージキーは出力しません。
   * 
   * @param messageKey メッセージキー
   * @return メッセージ
   */
  public static String formatMessageWithoutMessageKey(String messageKey) {
    return formatMessage(messageKey, null, false);
  }

  /**
   * メッセージを構築します。<br>
   * メッセージキーも出力します。
   * 
   * @param messageKey メッセージキー
   * @param param パラメータ
   * @return メッセージ
   */
  public static String formatMessage(String messageKey, Object param) {
    return formatMessage(messageKey, new Object[] {param}, true);
  }

  /**
   * メッセージを構築します。<br>
   * メッセージキーは出力しません。
   * 
   * @param messageKey メッセージキー
   * @param param パラメータ
   * @return メッセージ
   */
  public static String formatMessageWithoutMessageKey(String messageKey, Object param) {
    return formatMessage(messageKey, new Object[] {param}, false);
  }

  /**
   * メッセージを構築します。<br>
   * メッセージキーも出力します。
   * 
   * @param messageKey メッセージキー
   * @param params パラメータ
   * @return メッセージ
   */
  public static String formatMessage(String messageKey, Object[] params) {
    return formatMessage(messageKey, params, true);
  }

  /**
   * メッセージを構築します。<br>
   * メッセージキーは出力しません。
   * 
   * @param messageKey メッセージキー
   * @param params パラメータ
   * @return メッセージ
   */
  public static String formatMessageWithoutMessageKey(String messageKey, Object[] params) {
    return formatMessage(messageKey, params, false);
  }

  /**
   * メッセージを構築します。
   * 
   * @param key キー
   * @param params パラメータ
   * @param isPrintKey trueの場合、メッセージのキーを出力します
   * @return メッセージ
   */
  public static String formatMessage(String key, Object[] params, boolean isPrintKey) {

    String messageTemplate = getMessageProvider().getPropertyMap().get(key);
    if (StringUtils.isEmpty(messageTemplate)) {
      return isPrintKey ? key + SEPARATOR : StringUtils.EMPTY;
    } else if (isPrintKey) {
      messageTemplate = key + SEPARATOR + messageTemplate;
    }

    // パラメータの展開
    if (null != params && params.length > 0) {
      for (int i = 0; i < params.length; i++) {
        if (null == params[i]) {
          continue;
        }
        messageTemplate =
            StringUtils.replace(messageTemplate, BRACE_PARAM_START + i + BRACE_PARAM_END,
                params[i].toString());
      }
    }

    return messageTemplate;
  }

  /**
   * メッセージプロパティファイルのクラスパスを取得します。
   * 
   * @return メッセージプロパティファイルのクラスパス
   */
  public String getPropertyFileClassPath() {
    return propertyFileClassPath;
  }

  /**
   * メッセージプロパティファイルのクラスパスを設定します。
   * 
   * @param propertyFileClassPath メッセージプロパティファイルのクラスパス
   */
  public void setPropertyFileClassPath(String propertyFileClassPath) {
    this.propertyFileClassPath = propertyFileClassPath;
  }

  /**
   * メッセージプロパティファイルのパスを取得します。
   * 
   * @return メッセージプロパティファイルのパス
   */
  public String getPropertyFilePath() {
    return propertyFilePath;
  }

  /**
   * メッセージプロパティファイルのパスを設定します。
   * 
   * @param propertyFilePath メッセージプロパティファイルのパス
   */
  public void setPropertyFilePath(String propertyFilePath) {
    this.propertyFilePath = propertyFilePath;
  }

  /**
   * プロパティのマップを取得します。
   * 
   * @return プロパティのマップ
   */
  public Map<String, String> getPropertyMap() {

    if (null == propertyMap) {
      propertyMap = new HashMap<String, String>();
    }

    return propertyMap;
  }

}
