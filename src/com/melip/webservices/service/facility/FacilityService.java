package com.melip.webservices.service.facility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.melip.webservices.common.DtoList;
import com.melip.webservices.dto.FacilityDto;
import com.melip.webservices.service.common.AbstractDataService;
import com.melip.webservices.service.common.QueryCondition;

/**
 * 施設のサービスクラスです。
 */
public class FacilityService extends AbstractDataService implements IFacilityService {

  /** 施設情報取得SQL_ID */
  private String selectFacilitySqlId;

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityDtoList(java.lang.String)
   */
  @Override
  public DtoList<FacilityDto> getFacilityDtoList(String langDiv) {
    return getFacilityDtoList(new QueryCondition(langDiv));
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityDtoList(java.lang.String,
   *      java.lang.Integer, java.lang.Integer)
   */
  @Override
  public DtoList<FacilityDto> getFacilityDtoList(String langDiv, Integer index, Integer count) {

    QueryCondition condition = new QueryCondition(langDiv);
    condition.setIndex(index);
    condition.setCount(count);
    return getFacilityDtoList(condition);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityDtoList(com.melip.webservices.service.common.QueryCondition)
   */
  @Override
  public DtoList<FacilityDto> getFacilityDtoList(QueryCondition condition) {

    List<FacilityDto> facilityList = selectList(getSelectFacilitySqlId(), condition);
    Integer allCount = facilityList.size();

    // ソート
    sortFacilityList(facilityList, condition);
    // 指定件数を切り出す
    List<FacilityDto> cutFacilityList = cutFacilityList(facilityList, condition);

    DtoList<FacilityDto> facilityDtoList = new DtoList<FacilityDto>(cutFacilityList);
    facilityDtoList.setAllCount(allCount);
    facilityDtoList.setIndex(condition.getIndex());
    facilityDtoList.setCount(condition.getCount());
    facilityDtoList.setCondition(condition);

    return facilityDtoList;
  }

  /**
   * 施設DTOリストを検索条件のソートキーにもとづいてソートします。
   * 
   * @param facilityList 施設DTOリスト
   * @param condition 検索条件
   */
  private void sortFacilityList(List<FacilityDto> facilityList, QueryCondition condition) {

    Collections.sort(facilityList, (FacilityDto1, FacilityDto2) -> {

      // TODO:実装
      // [参考]http://www.ne.jp/asahi/hishidama/home/tech/java/comparator.html#thenComparing



        return 0;

      }

    );
  }

  /**
   * 施設DTOリストを検索条件の開始位置、取得件数にもとづいて切り出します。
   * 
   * @param facilityList 施設DTOリスト
   * @param condition 検索条件
   * @return 切り出した施設DTOリスト
   */
  private List<FacilityDto> cutFacilityList(List<FacilityDto> facilityList, QueryCondition condition) {

    int index = condition.getIndex();
    int count = condition.getCount();

    if (index > facilityList.size()) {
      // TODO:
      // facilityListの件数よりも大きいインデックスを指定された場合エラーとするか
      // nullを返してリストが空となるかどちらがよいか？
      return null;
    }

    List<FacilityDto> cutFacilityList = new ArrayList<FacilityDto>();
    for (int i = index; i < index + count; i++) {
      cutFacilityList.add(facilityList.get(i - 1));
      // リストの末尾に達した場合は終了
      if (i == facilityList.size()) {
        break;
      }
    }

    return cutFacilityList;
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityDto(java.lang.String,
   *      java.lang.Integer)
   */
  @Override
  public FacilityDto getFacilityDto(String langDiv, Integer facilityId) {
    // TODO:ベタ書き
    QueryCondition condition = new QueryCondition(langDiv);
    condition.setValue("facilityId", facilityId);
    return getFacilityDto(condition);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityDto(com.melip.webservices.service.common.QueryCondition)
   */
  @Override
  public FacilityDto getFacilityDto(QueryCondition condition) {
    return selectOne(getSelectFacilitySqlId(), condition);
  }

  /**
   * 施設情報取得SQL_IDを取得します。
   * 
   * @return 施設情報取得SQL_ID
   */
  public String getSelectFacilitySqlId() {
    return selectFacilitySqlId;
  }

  /**
   * 施設情報取得SQL_IDを設定します。
   * 
   * @param selectFacilitySqlId 施設情報取得SQL_ID
   */
  public void setSelectFacilitySqlId(String selectFacilitySqlId) {
    this.selectFacilitySqlId = selectFacilitySqlId;
  }

}
