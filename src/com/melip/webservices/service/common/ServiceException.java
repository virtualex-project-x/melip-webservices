package com.melip.webservices.service.common;

import com.melip.webservices.system.MelipException;

/**
 * サービスの業務例外クラスです。
 */
public class ServiceException extends MelipException {

  /** デフォルトのメッセージキー */
  public static final String DEFAULT_MESSAGE_KEY = "SVC-0001";

  // シリアルバージョンUID
  private static final long serialVersionUID = 1L;

  /**
   * コンストラクタ
   */
  public ServiceException() {
    super(DEFAULT_MESSAGE_KEY);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   */
  public ServiceException(String messageKey) {
    super(messageKey);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param params メッセージパラメータ
   */
  public ServiceException(String messageKey, Object[] params) {
    super(messageKey, params);
  }

  /**
   * コンストラクタ
   * 
   * @param cause 例外
   */
  public ServiceException(Throwable cause) {
    super(DEFAULT_MESSAGE_KEY, cause);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param cause 例外
   */
  public ServiceException(String messageKey, Throwable cause) {
    super(messageKey, cause);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param params メッセージパラメータ
   * @param cause 例外
   */
  public ServiceException(String messageKey, Object[] params, Throwable cause) {
    super(messageKey, params, cause);
  }

}
