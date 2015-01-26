package com.melip.webservices.service.layout;

import com.melip.common.dto.screen.ScreenDto;

/**
 * レイアウトのサービスインタフェースです。
 */
public interface ILayoutService {

  /** DIコンテナ登録用の名称 */
  public static final String SERVICE_NAME = "layoutService";

  /**
   * 受け取ったスクリーンオブジェクトの遷移先画面のスクリーンDTOを取得します。
   * 
   * @param langdiv 言語区分
   * @param screenObjId スクリーンオブジェクトID
   * @param regionId 地域ID
   * @param facilityId 施設ID
   * @param facilityGrpId 施設グループID
   * @return スクリーンDTO
   */
  public ScreenDto getScreenDto(String langdiv, Integer screenObjId, Integer regionId,
      Integer facilityId, Integer facilityGrpId);
}
