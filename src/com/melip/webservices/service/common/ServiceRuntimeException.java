package com.melip.webservices.service.common;

import com.melip.webservices.constants.MessageConstants;
import com.melip.webservices.system.MelipRuntimeException;

/**
 * サービスのシステム例外クラスです。
 */
public class ServiceRuntimeException extends MelipRuntimeException {

  /** デフォルトのメッセージキー */
  public static final String DEFAULT_MESSAGE_KEY = MessageConstants.SVC_0002;

  /**
   * コンストラクタ
   */
  public ServiceRuntimeException() {
    super(DEFAULT_MESSAGE_KEY);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   */
  public ServiceRuntimeException(String messageKey) {
    super(messageKey);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param params メッセージパラメータ
   */
  public ServiceRuntimeException(String messageKey, Object[] params) {
    super(messageKey, params);
  }

  /**
   * コンストラクタ
   * 
   * @param cause 例外
   */
  public ServiceRuntimeException(Throwable cause) {
    super(DEFAULT_MESSAGE_KEY, cause);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param cause 例外
   */
  public ServiceRuntimeException(String messageKey, Throwable cause) {
    super(messageKey, cause);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param params メッセージパラメータ
   * @param cause 例外
   */
  public ServiceRuntimeException(String messageKey, Object[] params, Throwable cause) {
    super(messageKey, params, cause);
  }

}
