package com.melip.dto.screen;

import java.util.List;

import com.melip.dto.common.AbstractDto;

/**
 * スクリーンの繰り返し対象の情報を格納したDTOです。
 */
public class ScreenObjGrpDto extends AbstractDto {

  /** ScreenObjDtoのリスト */
  private List<ScreenObjDto> screenObjDtoList;

  /**
   * ScreenObjDtoのリストを取得します。
   * 
   * @return ScreenObjDtoのリスト
   */
  public List<ScreenObjDto> getScreenObjDtoList() {
    return screenObjDtoList;
  }

  /**
   * ScreenObjDtoのリストを設定します。
   * 
   * @param ScreenObjDto ScreenObjDtoのリスト
   */
  public void setScreenObjDtoList(List<ScreenObjDto> screenObjDtoList) {
    this.screenObjDtoList = screenObjDtoList;
  }

}
