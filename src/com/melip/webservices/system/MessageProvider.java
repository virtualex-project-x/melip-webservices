package com.melip.webservices.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.melip.common.constants.CommonConstants;
import com.melip.webservices.common.BeanCreator;

/**
 * アプリケーションで利用するメッセージ文字列を提供するクラスです。<br>
 * メッセージファイルは、プロパティファイル（.properties)として作成し、本クラスに設定します。<br>
 * Springによりシングルトンとして生成されます。
 */
public class MessageProvider {

  /** DIコンテナ登録用の名称 */
  private static final String BEAN_ID = "messageProvider";
  /** 読み込むメッセージプロパティファイルのパターン */
  private static final String PATTERN_MESSAGE_PROPERTY_FILE = "classpath*:/**/message*.properties";
  /** キーとメッセージのセパレータ */
  private static final String SEPARATOR = " : ";
  /** メッセージパラメータの開始カッコ */
  private static final String BRACE_PARAM_START = "${";
  /** メッセージパラメータの終了カッコ */
  private static final String BRACE_PARAM_END = "}";

  private static final Logger log = LoggerFactory.getLogger(MessageProvider.class);

  /** メッセージプロパティファイルのクラスパスリスト */
  private List<String> propertyFileClassPathList;
  /** プロパティのマップ */
  private Map<String, String> propertyMap;

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
   * クラスパスリストに指定されているプロパティファイルを読み込みます。<br>
   * 指定されていない場合は、クラスパス上の「message*.properties」ファイルを読み込みます。
   * 
   * @throws IOException
   */
  public static void registerProperty() throws IOException {

    ClassLoader loader = getMessageProvider().getClass().getClassLoader();
    // Springのリソース取得クラスを利用
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(loader);
    List<Resource> resourceList = new ArrayList<Resource>();

    List<String> pathlList = getMessageProvider().getPropertyFileClassPathList();
    if (CollectionUtils.isEmpty(pathlList)) {
      Resource[] resources = resolver.getResources(PATTERN_MESSAGE_PROPERTY_FILE);
      resourceList = Arrays.asList(resources);
    } else {
      for (String path : pathlList) {
        Resource resource = resolver.getResource(path);
        resourceList.add(resource);
      }
    }

    if (CollectionUtils.isNotEmpty(resourceList)) {
      for (Resource resource : resourceList) {
        registerProperty(resource.getURL());
      }
    } else {
      log.info("読み込むメッセージプロパティファイルはありません。");
    }
  }

  /**
   * メッセージプロパティファイルを設定します。
   * 
   * @param propertyFileClassPath メッセージプロパティファイルのクラスパス
   * @throws IOException
   */
  public static void registerProperty(String propertyFileClassPath) throws IOException {

    registerProperty(getMessageProvider().getClass().getClassLoader()
        .getResource(propertyFileClassPath));
  }

  /**
   * メッセージプロパティファイルを設定します。
   * 
   * @param propertyFileUrl メッセージプロパティファイルのURL
   * @throws IOException
   */
  public static void registerProperty(URL propertyFileUrl) throws IOException {

    File propertyFile = new File(propertyFileUrl.getPath());
    log.info("メッセージプロパティファイル[" + propertyFile.getName() + "]を読み込みます。");
    registerProperty(new InputStreamReader(new FileInputStream(propertyFile),
        CommonConstants.SYSTEM_CHARSET));
  }

  /**
   * メッセージプロパティファイルを設定します。
   * 
   * @param reader メッセージプロパティファイルのリーダ
   * @throws IOException
   */
  public static void registerProperty(Reader reader) throws IOException {

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
   * メッセージプロパティファイルのクラスパスリストを取得します。
   * 
   * @return メッセージプロパティファイルのクラスパスリスト
   */
  public List<String> getPropertyFileClassPathList() {
    return propertyFileClassPathList;
  }

  /**
   * メッセージプロパティファイルのクラスパスリストを設定します。
   * 
   * @param propertyFileClassPathList メッセージプロパティファイルのクラスパスリスト
   */
  public void setPropertyFileClassPathList(List<String> propertyFileClassPathList) {
    this.propertyFileClassPathList = propertyFileClassPathList;
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
