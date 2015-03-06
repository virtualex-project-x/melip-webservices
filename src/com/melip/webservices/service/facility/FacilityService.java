package com.melip.webservices.service.facility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.comparators.ComparatorChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.melip.common.constants.CodeConstants;
import com.melip.common.dto.common.FacilityDto;
import com.melip.webservices.common.DtoList;
import com.melip.webservices.dto.FacilityDtoComparator;
import com.melip.webservices.entity.Facility;
import com.melip.webservices.entity.FacilityAttrVal;
import com.melip.webservices.entity.FacilityAttrValLang;
import com.melip.webservices.mapper.FacilityMapper;
import com.melip.webservices.service.common.AbstractService;
import com.melip.webservices.service.common.QueryCondition;

/**
 * 施設のサービスクラスです。
 */
public class FacilityService extends AbstractService implements IFacilityService {

  @Autowired
  private FacilityMapper facilityMapper;

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityDtoList(java.lang.String)
   */
  @Override
  @Transactional(readOnly = true)
  public DtoList<FacilityDto> getFacilityDtoList(String langDiv) {
    return getFacilityDtoList(new QueryCondition(langDiv));
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityDtoList(java.lang.String,
   *      java.lang.Integer, java.lang.Integer)
   */
  @Override
  @Transactional(readOnly = true)
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
  @Transactional(readOnly = true)
  public DtoList<FacilityDto> getFacilityDtoList(QueryCondition condition) {

    List<FacilityDto> facilityList = facilityMapper.getFacilityDto(condition);
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
  @Transactional(readOnly = true)
  public FacilityDto getFacilityDto(String langDiv, Integer facilityId) {

    QueryCondition condition = new QueryCondition(langDiv);
    condition.setValue(FacilityDto.FIELD_FACILITY_ID, facilityId);
    return getFacilityDto(condition);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#getFacilityDto(com.melip.webservices.service.common.QueryCondition)
   */
  @Override
  @Transactional(readOnly = true)
  public FacilityDto getFacilityDto(QueryCondition condition) {

    List<FacilityDto> facilityList = facilityMapper.getFacilityDto(condition);
    return facilityList.get(0);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#updateFacility(com.melip.webservices.entity.Facility)
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public int updateFacility(Facility facility) {

    QueryCondition condition = new QueryCondition();
    condition.setParam(facility);
    return facilityMapper.updateFacility(condition);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#updateChildFacilityByParentFacilityId(java.lang.Integer,
   *      com.melip.webservices.entity.Facility)
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public int updateChildFacilityByParentFacilityId(Integer parentFacilityId, Facility facility) {

    QueryCondition condition = new QueryCondition();
    condition.setValue(Facility.FIELD_PARENT_FACILITY_ID, parentFacilityId);
    condition.setParam(facility);
    return facilityMapper.updateChildFacilityByParentFacilityId(condition);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#updateFacilityAttrValByFacilityId(java.lang.Integer,
   *      com.melip.webservices.entity.FacilityAttrVal)
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public int updateFacilityAttrValByFacilityId(Integer facilityId, FacilityAttrVal facilityAttrVal) {

    QueryCondition condition = new QueryCondition();
    condition.setValue(FacilityAttrVal.FIELD_FACILITY_ID, facilityId);
    condition.setParam(facilityAttrVal);
    return facilityMapper.updateFacilityAttrValByFacilityId(condition);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#updateFacilityAttrValLangByFacilityId(java.lang.Integer,
   *      java.lang.String, com.melip.webservices.entity.FacilityAttrValLang)
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public int updateFacilityAttrValLangByFacilityId(Integer facilityId, String langDiv,
      FacilityAttrValLang facilityAttrValLang) {

    QueryCondition condition = new QueryCondition();
    condition.setValue(FacilityAttrVal.FIELD_FACILITY_ID, facilityId);
    condition.setValue(FacilityAttrValLang.FIELD_LANG_DIV, langDiv);
    condition.setParam(facilityAttrValLang);
    return facilityMapper.updateFacilityAttrValLangByFacilityId(condition);
  }

  /**
   * @see com.melip.webservices.service.facility.IFacilityService#logicalDeleteFacility(java.lang.Integer)
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public void logicalDeleteFacility(Integer facilityId) {

    // TODO:施設_施設グループ_リンク属性値_多言語
    // TODO:施設_施設グループ_リンク属性値
    // TODO:施設_施設グループ_リンク
    // 施設属性値_多言語
    FacilityAttrValLang favl = new FacilityAttrValLang();
    favl.setSts(CodeConstants.CODE_STS_DELETED);
    updateFacilityAttrValLangByFacilityId(facilityId, null, favl);
    // 施設属性値
    FacilityAttrVal fav = new FacilityAttrVal();
    fav.setSts(CodeConstants.CODE_STS_DELETED);
    updateFacilityAttrValByFacilityId(facilityId, fav);
    // 子施設
    Facility f = new Facility();
    f.setSts(CodeConstants.CODE_STS_DELETED);
    updateChildFacilityByParentFacilityId(facilityId, f);
    // 施設
    f.setFacilityId(facilityId);
    updateFacility(f);
  }

}
