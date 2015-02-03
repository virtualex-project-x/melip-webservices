package com.melip.webservices.system;

/**
 * MELIP業務例外の基底クラスです。
 */
public class MelipException extends Exception {

  /** デフォルトのメッセージキー */
  public static final String DEFAULT_MESSAGE_KEY = "SYS-0001";
  /** 空のメッセージパラメータ */
  public static final Object[] BLANK_PARAMS = new Object[] {};

  // シリアルバージョンUID
  private static final long serialVersionUID = 1L;

  /** メッセージキー */
  private String messageKey;
  /** メッセージパラメータ */
  private Object[] messageParams;

  /**
   * コンストラクタ
   */
  public MelipException() {
    this(DEFAULT_MESSAGE_KEY, BLANK_PARAMS);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   */
  public MelipException(String messageKey) {
    this(messageKey, BLANK_PARAMS);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param params メッセージパラメータ
   */
  public MelipException(String messageKey, Object[] params) {
    super();
    setMessageKey(messageKey);
    setMessageParams(params);
  }

  /**
   * コンストラクタ
   * 
   * @param cause 例外
   */
  public MelipException(Throwable cause) {
    this(DEFAULT_MESSAGE_KEY, BLANK_PARAMS, cause);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param cause 例外
   */
  public MelipException(String messageKey, Throwable cause) {
    this(messageKey, BLANK_PARAMS, cause);
  }

  /**
   * コンストラクタ
   * 
   * @param messageKey メッセージキー
   * @param params メッセージパラメータ
   * @param cause 例外
   */
  public MelipException(String messageKey, Object[] params, Throwable cause) {
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
