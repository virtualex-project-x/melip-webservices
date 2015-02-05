package com.melip.webservices.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.melip.common.constants.CommonConstants;
import com.melip.common.dto.common.ResourceDto;
import com.melip.webservices.common.BeanCreator;
import com.melip.webservices.common.DtoList;
import com.melip.webservices.dto.AttrGrpSearchConditionDto;
import com.melip.webservices.dto.FacilityDto;
import com.melip.webservices.dto.FacilitySearchConditionDto;
import com.melip.webservices.resource.common.AbstractResource;
import com.melip.webservices.service.common.QueryCondition;
import com.melip.webservices.service.facility.IFacilityService;

/**
 * 施設情報を取得するクラスです。
 */
@Path("/facility")
public class FacilityResource extends AbstractResource {

  private static final Logger log = LoggerFactory.getLogger(FacilityResource.class);

  /** エンティティ名 */
  private static final String ENTITY_NAME = "Facility";
  /** 項目のセパレータ */
  private static final String SEPARATOR_ITEM = ",";
  /** KEY、VALUEのセパレータ */
  private static final String SEPARATOR_KEY_VALUE = ":";
  /** 昇順を表す文字列 */
  private static final String STR_ASC = "asc";

  /** 言語区分 */
  private String langDiv;
  /** 属性グループリスト */
  private List<String> attrGrpList;
  /** 地域ID */
  private Integer regionId;
  /** 検索条件マップ */
  private Map<String, String> conditionMap;
  /** 開始位置 */
  private Integer index;
  /** 件数 */
  private Integer count;
  /** ソートキーマップ */
  private Map<String, Boolean> orderMap;

  /**
   * 施設情報をJSON形式で取得します。
   * 
   * @param langDiv 言語区分
   * @param attrGrp 属性グループ
   * @param regionId 地域ID
   * @param condition 検索条件
   * @param index 開始位置
   * @param count 件数
   * @param order ソートキー
   * @return 施設情報を保持したリソースDTO
   */
  @GET
  @Produces(CommonConstants.MEDIA_TYPE_JSON)
  public ResourceDto getFacility(@QueryParam("langDiv") String langDiv,
      @QueryParam("attrGrp") String attrGrp, @QueryParam("regionId") String regionId,
      @QueryParam("condition") String condition, @QueryParam("index") String index,
      @QueryParam("count") String count, @QueryParam("order") String order) {

    // TODO:エラー処理
    // HTTPエラーコードを返す方法
    // エラー用JSONオブジェクトを定義してメッセージを登録する

    checkParameters(langDiv, attrGrp, regionId, condition, index, count, order);

    FacilitySearchConditionDto facilityCondition = createFacilitySearchCondition();
    QueryCondition queryCondition = new QueryCondition(getLangDiv(), facilityCondition);
    if (null != getIndex()) {
      queryCondition.setIndex(getIndex());
    }
    if (null != getCount()) {
      queryCondition.setCount(getCount());
    }

    IFacilityService service =
        BeanCreator.getBean(IFacilityService.SERVICE_NAME, IFacilityService.class);
    DtoList<FacilityDto> list = service.getFacilityDtoList(queryCondition);

    ResourceDto dto = new ResourceDto();
    dto.setAllCount(list.getAllCount());
    dto.setIndex(list.getIndex());
    dto.setCount(list.getCount());
    dto.setDtoList(list.getDtoList());
    dto.setEntity(ENTITY_NAME);

    return dto;
  }

  // TODO:Javadoc
  private void checkParameters(String langDiv, String attrGrp, String regionId, String condition,
      String index, String count, String order) {

    if (log.isDebugEnabled()) {
      log.debug("【パラメータ情報】");
      log.debug("  言語区分     -> " + langDiv);
      log.debug("  属性グループ -> " + attrGrp);
      log.debug("  地域ID       -> " + regionId);
      log.debug("  検索条件     -> " + condition);
      log.debug("  開始位置     -> " + index);
      log.debug("  件数         -> " + count);
      log.debug("  ソートキー   -> " + order);
    }

    // TODO:必須チェックなど

    // 言語区分
    setLangDiv(langDiv);
    // 属性グループリスト
    if (StringUtils.isNotEmpty(attrGrp)) {
      setAttrGrpList(Arrays.asList(attrGrp.split(SEPARATOR_ITEM)));
    }
    // 地域ID
    if (StringUtils.isNotEmpty(regionId)) {
      setRegionId(Integer.valueOf(regionId));
    }
    // 検索条件マップ
    if (StringUtils.isNotEmpty(condition)) {
      Map<String, String> conditionMap = new HashMap<String, String>();
      String[] conditions = condition.split(SEPARATOR_ITEM);
      for (String conditionPair : conditions) {
        String[] values = conditionPair.split(SEPARATOR_KEY_VALUE);
        conditionMap.put(values[0], values[1]);
      }
      setConditionMap(conditionMap);
    }
    // 開始位置
    if (StringUtils.isNotEmpty(index)) {
      setIndex(Integer.valueOf(index));
    }
    // 件数
    if (StringUtils.isNotEmpty(count)) {
      setCount(Integer.valueOf(count));
    }
    // ソートキーマップ
    if (StringUtils.isNotEmpty(order)) {
      Map<String, Boolean> orderMap = new LinkedHashMap<String, Boolean>();
      String[] orderKeys = order.split(SEPARATOR_ITEM);
      for (String orderPair : orderKeys) {
        String[] values = orderPair.split(SEPARATOR_KEY_VALUE);
        Boolean isAsc = STR_ASC.equals(values[1]) ? true : false;
        orderMap.put(values[0], isAsc);
      }
      setOrderMap(orderMap);
    }
  }

  /**
   * 施設検索条件DTOを生成します。
   * 
   * @return 施設検索条件DTO
   */
  private FacilitySearchConditionDto createFacilitySearchCondition() {

    FacilitySearchConditionDto dto = new FacilitySearchConditionDto();
    dto.setTargetAttrGrpAliasList(getAttrGrpList());
    dto.setRegionId(getRegionId());
    if (null != getConditionMap()) {
      List<AttrGrpSearchConditionDto> attrGrpConditionList =
          new ArrayList<AttrGrpSearchConditionDto>();
      for (Map.Entry<String, String> entiry : getConditionMap().entrySet()) {
        AttrGrpSearchConditionDto attrGrpCondition = new AttrGrpSearchConditionDto();
        attrGrpCondition.setAttrGrpAlias(entiry.getKey());
        attrGrpCondition.setVal(entiry.getValue());
        attrGrpConditionList.add(attrGrpCondition);
      }
      dto.setAttrGrpSearchConditionDtoList(attrGrpConditionList);
      dto.setNumOfSearchCondition(attrGrpConditionList.size());
    }

    return dto;
  }

  /**
   * 言語区分を取得します。
   * 
   * @return 言語区分
   */
  public String getLangDiv() {
    return langDiv;
  }

  /**
   * 言語区分を設定します。
   * 
   * @param langDiv 言語区分
   */
  public void setLangDiv(String langDiv) {
    this.langDiv = langDiv;
  }

  /**
   * 属性グループリストを取得します。
   * 
   * @return 属性グループリスト
   */
  public List<String> getAttrGrpList() {
    return attrGrpList;
  }

  /**
   * 属性グループリストを設定します。
   * 
   * @param attrGrpList 属性グループリスト
   */
  public void setAttrGrpList(List<String> attrGrpList) {
    this.attrGrpList = attrGrpList;
  }

  /**
   * 地域IDを取得します。
   * 
   * @return 地域ID
   */
  public Integer getRegionId() {
    return regionId;
  }

  /**
   * 地域IDを設定します。
   * 
   * @param regionId 地域ID
   */
  public void setRegionId(Integer regionId) {
    this.regionId = regionId;
  }

  /**
   * 検索条件マップを取得します。
   * 
   * @return 検索条件マップ
   */
  public Map<String, String> getConditionMap() {
    return conditionMap;
  }

  /**
   * 検索条件マップを設定します。
   * 
   * @param conditionMap 検索条件マップ
   */
  public void setConditionMap(Map<String, String> conditionMap) {
    this.conditionMap = conditionMap;
  }

  /**
   * 開始位置を取得します。
   * 
   * @return 開始位置
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * 開始位置を設定します。
   * 
   * @param index 開始位置
   */
  public void setIndex(Integer index) {
    this.index = index;
  }

  /**
   * 件数を取得します。
   * 
   * @return 件数
   */
  public Integer getCount() {
    return count;
  }

  /**
   * 件数を設定します。
   * 
   * @param count 件数
   */
  public void setCount(Integer count) {
    this.count = count;
  }

  /**
   * ソートキーマップを取得します。
   * 
   * @return ソートキーマップ
   */
  public Map<String, Boolean> getOrderMap() {
    return orderMap;
  }

  /**
   * ソートキーマップを設定します。
   * 
   * @param orderMap ソートキーマップ
   */
  public void setOrderMap(Map<String, Boolean> orderMap) {
    this.orderMap = orderMap;
  }

}
