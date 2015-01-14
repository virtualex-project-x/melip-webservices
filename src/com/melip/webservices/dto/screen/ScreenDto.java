package com.melip.webservices.dto.screen;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.melip.webservices.dto.common.AbstractDto;

/**
 * スクリーンのメインとなるDTOです。<br>
 */
@XmlRootElement
public class ScreenDto extends AbstractDto {

  /** 対象のレイアウトのID */
  private Integer targetLayoutId;
  /** 対象のスクリーンのID */
  private Integer targetScreenId;
  /** ScreenObjDtoのリスト */
  private List<ScreenObjDto> screenObjDtoList;
  /** ScreenObjGrpDtoのリスト */
  private List<ScreenObjGrpDto> screenObjGrpDtoList;

  /**
   * 対象のレイアウトのIDを取得します。
   * 
   * @return 対象のレイアウトのID
   */
  public Integer getTargetLayoutId() {
    return targetLayoutId;
  }

  /**
   * 対象のレイアウトのIDを設定します。
   * 
   * @param targetLayoutId 対象のレイアウトのID
   */
  public void setTargetLayoutId(Integer targetLayoutId) {
    this.targetLayoutId = targetLayoutId;
  }

  /**
   * 対象のスクリーンのIDを取得します。
   * 
   * @return 対象のスクリーンのID
   */
  public Integer getTargetScreenId() {
    return targetScreenId;
  }

  /**
   * 対象のスクリーンのIDを設定します。
   * 
   * @param targetScreenId 対象のスクリーンのID
   */
  public void setTargetScreenId(Integer targetScreenId) {
    this.targetScreenId = targetScreenId;
  }

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
   * @param screenObjDtoList ScreenObjDtoのリスト
   */
  public void setScreenObjDtoList(List<ScreenObjDto> screenObjDtoList) {
    this.screenObjDtoList = screenObjDtoList;
  }

  /**
   * ScreenObjGrpDtoのリストを取得します。
   * 
   * @return ScreenObjGrpDtoのリスト
   */
  public List<ScreenObjGrpDto> getScreenObjGrpDtoList() {
    return screenObjGrpDtoList;
  }

  /**
   * ScreenObjGrpDtoのリストを設定します。
   * 
   * @param screenObjGrpDtoList ScreenObjGrpDtoのリスト
   */
  public void setScreenObjGrpDtoList(List<ScreenObjGrpDto> screenObjGrpDtoList) {
    this.screenObjGrpDtoList = screenObjGrpDtoList;
  }
}
