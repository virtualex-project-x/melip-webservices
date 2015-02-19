package com.melip.webservices.service.facility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.comparators.ComparatorChain;

import com.melip.webservices.common.DtoList;
import com.melip.webservices.dto.FacilityDto;
import com.melip.webservices.dto.FacilityDtoComparator;
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
    facilityDtoList.setCount(cutFacilityList.size());
    facilityDtoList.setCondition(condition);

    return facilityDtoList;
  }

  /**
   * 施設DTOリストを検索条件のソートキーにもとづいてソートします。
   * 
   * @param facilityList 施設DTOリスト
   * @param condition 検索条件
   */
  @SuppressWarnings("unchecked")
  private void sortFacilityList(List<FacilityDto> facilityList, QueryCondition condition) {

    Map<String, Boolean> orderMap = condition.getOrderBy();
    if (null != orderMap && !orderMap.isEmpty()) {
      ComparatorChain comparator = new ComparatorChain();
      for (Map.Entry<String, Boolean> entry : orderMap.entrySet()) {
        comparator.addComparator(new FacilityDtoComparator(entry.getKey(), entry.getValue(), true));
      }
      Collections.sort(facilityList, comparator);
    }
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
    List<FacilityDto> cutFacilityList = new ArrayList<FacilityDto>();

    if (index > facilityList.size()) {
      return cutFacilityList;
    }

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

    QueryCondition condition = new QueryCondition(langDiv);
    condition.setValue(FacilityDto.FIELD_FACILITY_ID, facilityId);
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
