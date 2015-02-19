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
  /** SQLの実行時にエラーが発生しました。 {@value} */
  public static final String SVC_0003 = "SVC-0003";

  /** リソースで業務エラーが発生しました。 {@value} */
  public static final String RSC_0001 = "RSC-0001";
  /** リソースでシステムエラーが発生しました。 {@value} */
  public static final String RSC_0002 = "RSC-0002";
  /** パラメータチェックでエラーが発生しました。 {@value} */
  public static final String RSC_0003 = "RSC-0003";

  /** ${0}は必須です。 {@value} */
  public static final String CMN_0001 = "CMN-0001";
  /** ${0} は ${1} 以上 ${2} 以下にしてください。入力値 [${3}] {@value} */
  public static final String CMN_0002 = "CMN-0002";
  /** ${0} は ${1} 以上にしてください。入力値 [${2}] {@value} */
  public static final String CMN_0003 = "CMN-0003";
  /** ${0} は ${1} 以下にしてください。入力値 [${2}] {@value} */
  public static final String CMN_0004 = "CMN-0004";
  /** ${0} は 数値を入力してください。入力値 [${1}] */
  public static final String CMN_0005 = "CMN-0005";
  /** ${0} の値が不正です。入力値 [${1}] {@value} */
  public static final String CMN_0006 = "CMN-0006";
  /** ${0} は ${1} の形式で入力してください。入力値 [${2}] {@value} */
  public static final String CMN_0007 = "CMN-0007";

}
