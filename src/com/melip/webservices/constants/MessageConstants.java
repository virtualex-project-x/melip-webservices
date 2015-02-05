package com.melip.webservices.constants;

/**
 * メッセージの定数定義用クラスです。
 */
public class MessageConstants {

  /**
   * コンストラクタ<br>
   * インスタンス化できません。
   */
  private MessageConstants() {}

  /** 業務エラーが発生しました。 {@value} */
  public static final String SYS_0001 = "SYS-0001";
  /** システムエラーが発生しました。 {@value} */
  public static final String SYS_0002 = "SYS-0002";
  /** サービスで業務エラーが発生しました。 {@value} */
  public static final String SVC_0001 = "SVC-0001";
  /** サービスでシステムエラーが発生しました。 {@value} */
  public static final String SVC_0002 = "SVC-0002";

}
