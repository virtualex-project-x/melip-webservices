package com.melip.webservices.resource.common;

import com.melip.webservices.constants.MessageConstants;
import com.melip.webservices.system.MelipRuntimeException;

/**
 * サービスのシステム例外クラスです。
 */
public class ResourceRuntimeException extends MelipRuntimeException {

  private static final long serialVersionUID = 1L;

  /** デフォルトのメッセージキー */
  public static final String DEFAULT_MESSAGE_KEY = MessageConstants.RSC_0002;

  /**
   * コンストラクタ
   */
  public ResourceRuntimeException() {
    super(DEFAULT_MESSAGE_KEY);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   */
  public ResourceRuntimeException(String messageKey) {
    super(messageKey);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param params メッセージパラメータ
   */
  public ResourceRuntimeException(String messageKey, Object[] params) {
    super(messageKey, params);
  }

  /**
   * コンストラクタ
   * 
   * @param cause 例外
   */
  public ResourceRuntimeException(Throwable cause) {
    super(DEFAULT_MESSAGE_KEY, cause);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param cause 例外
   */
  public ResourceRuntimeException(String messageKey, Throwable cause) {
    super(messageKey, cause);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param params メッセージパラメータ
   * @param cause 例外
   */
  public ResourceRuntimeException(String messageKey, Object[] params, Throwable cause) {
    super(messageKey, params, cause);
  }

}
