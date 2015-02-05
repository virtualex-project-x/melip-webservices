package com.melip.webservices.system;

import com.melip.webservices.constants.MessageConstants;

/**
 * MELIPシステム例外の基底クラスです。
 */
public class MelipRuntimeException extends RuntimeException {

  /** デフォルトのメッセージキー */
  public static final String DEFAULT_MESSAGE_KEY = MessageConstants.SYS_0002;
  /** 空のメッセージパラメータ */
  public static final Object[] BLANK_PARAMS = new Object[] {};

  /** メッセージキー */
  private String messageKey;
  /** メッセージパラメータ */
  private Object[] messageParams;

  /**
   * コンストラクタ
   */
  public MelipRuntimeException() {
    this(DEFAULT_MESSAGE_KEY, BLANK_PARAMS);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   */
  public MelipRuntimeException(String messageKey) {
    this(messageKey, BLANK_PARAMS);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param params メッセージパラメータ
   */
  public MelipRuntimeException(String messageKey, Object[] params) {
    super();
    setMessageKey(messageKey);
    setMessageParams(params);
  }

  /**
   * コンストラクタ
   * 
   * @param cause 例外
   */
  public MelipRuntimeException(Throwable cause) {
    this(DEFAULT_MESSAGE_KEY, BLANK_PARAMS, cause);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param cause 例外
   */
  public MelipRuntimeException(String messageKey, Throwable cause) {
    this(messageKey, BLANK_PARAMS, cause);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param params メッセージパラメータ
   * @param cause 例外
   */
  public MelipRuntimeException(String messageKey, Object[] params, Throwable cause) {
    super(cause);
    setMessageKey(messageKey);
    setMessageParams(params);
  }

  /**
   * @see java.lang.Throwable#getMessage()
   */
  @Override
  public String getMessage() {
    return MessageProvider.formatMessage(getMessageKey(), getMessageParams(), true);
  }

  /**
   * メッセージキーを取得します。
   * 
   * @return メッセージキー
   */
  public String getMessageKey() {
    return messageKey;
  }

  /**
   * メッセージキーを設定します。
   * 
   * @param messageKey メッセージキー
   */
  public void setMessageKey(String messageKey) {
    this.messageKey = messageKey;
  }

  /**
   * メッセージパラメータを取得します。
   * 
   * @return メッセージパラメータ
   */
  public Object[] getMessageParams() {
    return messageParams;
  }

  /**
   * メッセージパラメータを設定します。
   * 
   * @param messageParams メッセージパラメータ
   */
  public void setMessageParams(Object[] messageParams) {
    this.messageParams = messageParams;
  }

}
