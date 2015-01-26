package com.melip.webservices.service.layout;

import java.util.List;

import com.melip.common.dto.screen.ScreenDto;
import com.melip.webservices.dto.LayoutScreenDto;
import com.melip.webservices.service.common.AbstractService;

/**
 * レイアウトのサービスクラスです。
 */
public class LayoutService extends AbstractService implements ILayoutService {

  /** レイアウト・スクリーン情報取得SQL_ID */
  private String selectLayoutScreenSqlId;

  /**
   * @see com.melip.webservices.service.layout.ILayoutService#getScreenDto(java.lang.String,
   *      java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer)
   */
  @Override
  public ScreenDto getScreenDto(String langdiv, Integer screenObjId, Integer regionId,
      Integer facilityId, Integer facilityGrpId) {

    System.out.println("#######################");

    LayoutSearchCondition condition = new LayoutSearchCondition();
    condition.setScreenObjId(screenObjId);
    List<LayoutScreenDto> layoutScreenDtoList =
        getSession().selectList(getSelectLayoutScreenSqlId(), condition);

    System.out.println(layoutScreenDtoList.size());


    return null;
  }

  /**
   * レイアウト・スクリーン情報を元にスクリーンDTOを生成します。
   * 
   * @param layoutScreenDtoList レイアウト・スクリーン情報リスト
   * @return スクリーンDTO
   */
  private ScreenDto createScreenDto(List<LayoutScreenDto> layoutScreenDtoList) {



    return null;
  }

  /**
   * レイアウト・スクリーン情報取得SQL_IDを取得します。
   * 
   * @return レイアウト・スクリーン情報取得SQL_ID
   */
  public String getSelectLayoutScreenSqlId() {
    return selectLayoutScreenSqlId;
  }

  /**
   * レイアウト・スクリーン情報取得SQL_IDを設定します。
   * 
   * @param selectLayoutScreenSqlId レイアウト・スクリーン情報取得SQL_ID
   */
  public void setSelectLayoutScreenSqlId(String selectLayoutScreenSqlId) {
    this.selectLayoutScreenSqlId = selectLayoutScreenSqlId;
  }

}
