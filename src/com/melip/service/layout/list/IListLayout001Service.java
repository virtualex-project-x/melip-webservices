package com.melip.service.layout.list;

import com.melip.dto.screen.ScreenDto;

/**
 * ListLayout001のサービスインタフェースです。
 */
public interface IListLayout001Service {

  /** DIコンテナ登録用の名称 */
  public static final String SERVICE_NAME = "listLayout001Service";

  /**
   * 一覧の情報を取得します。
   * 
   * @param screenId スクリーンのID
   * @param targetId 対象の情報のID（施設IDなど）
   * @param langDiv 言語区分
   * @return ScreenDto
   */
  public ScreenDto getList(Integer screenId, Integer targetId, String langDiv);

}
