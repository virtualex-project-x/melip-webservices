package com.melip.webservices.service.initialize;

/**
 * システム初期化処理のインタフェースです。
 */
public interface ISystemInitializeService {

  /** DIコンテナ登録用の名称 */
  public static final String SERVICE_NAME = "systemInitializeService";

  /**
   * 初期化処理を実行します。
   */
  public void initializeSystem();

}
