package com.melip.webservices.resource.common;

import com.melip.webservices.constants.MessageConstants;
import com.melip.webservices.system.MelipException;

/**
 * サービスの業務例外クラスです。
 */
public class ResourceException extends MelipException {

  private static final long serialVersionUID = 1L;

  /** デフォルトのメッセージキー */
  public static final String DEFAULT_MESSAGE_KEY = MessageConstants.RSC_0001;

  /**
   * コンストラクタ
   */
  public ResourceException() {
    super(DEFAULT_MESSAGE_KEY);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   */
  public ResourceException(String messageKey) {
    super(messageKey);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param params メッセージパラメータ
   */
  public ResourceException(String messageKey, Object[] params) {
    super(messageKey, params);
  }

  /**
   * コンストラクタ
   * 
   * @param cause 例外
   */
  public ResourceException(Throwable cause) {
    super(DEFAULT_MESSAGE_KEY, cause);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param cause 例外
   */
  public ResourceException(String messageKey, Throwable cause) {
    super(messageKey, cause);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param params メッセージパラメータ
   * @param cause 例外
   */
  public ResourceException(String messageKey, Object[] params, Throwable cause) {
    super(messageKey, params, cause);
  }

}
