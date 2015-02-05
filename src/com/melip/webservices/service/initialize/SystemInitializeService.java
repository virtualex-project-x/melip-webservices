package com.melip.webservices.service.initialize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.melip.webservices.system.MessageProvider;

/**
 * システムの初期化処理を実行するクラスです。
 */
public class SystemInitializeService implements ISystemInitializeService {

  private static final Logger log = LoggerFactory.getLogger(SystemInitializeService.class);

  /**
   * @see com.melip.webservices.service.initialize.ISystemInitializeService#initializeSystem()
   */
  @Override
  public void initializeSystem() {

    // メッセージの初期化
    initMessage();
  }

  /**
   * メッセージの初期化処理を実行します。
   */
  private void initMessage() {

    log.info("メッセージの初期化処理を開始します。");

    try {
      MessageProvider.registerProperty();
    } catch (Exception e) {
      throw new RuntimeException("メッセージの初期化処理でエラーが発生しました。", e);
    }

    log.info("メッセージの初期化処理が終了しました。");

  }
}
