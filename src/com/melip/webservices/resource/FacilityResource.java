package com.melip.webservices.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    // パラメータチェック
    checkParameters(langDiv, attrGrp, regionId, condition, index, count, order);

    // 検索条件生成
    FacilitySearchConditionDto facilityCondition =
        createFacilitySearchCondition(attrGrp, regionId, condition);
    QueryCondition queryCondition = createQueryCondition(langDiv, index, count, order);
    queryCondition.setParam(facilityCondition);

    // 施設DTOリスト取得
    IFacilityService service =
        BeanCreator.getBean(IFacilityService.SERVICE_NAME, IFacilityService.class);
    DtoList<FacilityDto> list = service.getFacilityDtoList(queryCondition);

    return createResourceDto(list);
  }

  /**
   * パラメータチェックを行います。
   * 
   * @param langDiv 言語区分
   * @param attrGrp 属性グループ
   * @param regionId 地域ID
   * @param condition 検索条件
   * @param index 開始位置
   * @param count 件数
   * @param order ソートキー
   */
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

    // TODO:必須チェック、数値チェックなど
  }

  /**
   * 施設検索条件DTOを生成します。
   * 
   * @param attrGrp 属性グループ
   * @param regionId 地域ID
   * @param condition 検索条件
   * @return
   */
  private FacilitySearchConditionDto createFacilitySearchCondition(String attrGrp, String regionId,
      String condition) {

    FacilitySearchConditionDto facilityConditionDto = new FacilitySearchConditionDto();

    // 取得対象属性グループエイリアスリスト
    if (StringUtils.isNotEmpty(attrGrp)) {
      facilityConditionDto.setTargetAttrGrpAliasList(Arrays.asList(attrGrp.split(SEPARATOR_ITEM)));
    }

    // 地域ID
    if (StringUtils.isNotEmpty(regionId)) {
      facilityConditionDto.setRegionId(Integer.valueOf(regionId));
    }

    // 属性グループ検索条件DTOリスト
    // 属性グループ検索条件の個数
    if (StringUtils.isNotEmpty(condition)) {
      List<AttrGrpSearchConditionDto> attrGrpConditionList =
          new ArrayList<AttrGrpSearchConditionDto>();
      String[] conditions = condition.split(SEPARATOR_ITEM);
      for (String conditionPair : conditions) {
        String[] values = conditionPair.split(SEPARATOR_KEY_VALUE);
        AttrGrpSearchConditionDto attrGrpCondition = new AttrGrpSearchConditionDto();
        attrGrpCondition.setAttrGrpAlias(values[0]);
        attrGrpCondition.setVal(values[1]);
        attrGrpConditionList.add(attrGrpCondition);
      }
      facilityConditionDto.setAttrGrpSearchConditionDtoList(attrGrpConditionList);
      facilityConditionDto.setNumOfSearchCondition(attrGrpConditionList.size());
    }

    return facilityConditionDto;
  }

  /**
   * 検索条件を生成します。
   * 
   * @param langDiv 言語区分
   * @param index 開始位置
   * @param count 件数
   * @param order ソートキー
   * @return 検索条件
   */
  private QueryCondition createQueryCondition(String langDiv, String index, String count,
      String order) {

    QueryCondition queryCondition = new QueryCondition(langDiv);

    // 開始位置
    if (StringUtils.isNotEmpty(index)) {
      queryCondition.setIndex(Integer.valueOf(index));
    }

    // 取得件数
    if (StringUtils.isNotEmpty(count)) {
      queryCondition.setCount(Integer.valueOf(count));
    }

    // ソートキー
    if (StringUtils.isNotEmpty(order)) {
      String[] orderKeys = order.split(SEPARATOR_ITEM);
      for (String orderPair : orderKeys) {
        String[] values = orderPair.split(SEPARATOR_KEY_VALUE);
        Boolean isAsc = STR_ASC.equals(values[1]);
        queryCondition.addOrderBy(values[0], isAsc);
      }
    }

    return queryCondition;
  }

  /**
   * リソースDTOを生成します。
   * 
   * @param list DTOリスト
   * @return リソースDTO
   */
  private ResourceDto createResourceDto(DtoList<FacilityDto> list) {

    ResourceDto resourceDto = new ResourceDto();
    resourceDto.setAllCount(list.getAllCount());
    resourceDto.setIndex(list.getIndex());
    resourceDto.setCount(list.getCount());
    resourceDto.setDtoList(list.getDtoList());
    resourceDto.setEntity(ENTITY_NAME);

    return resourceDto;
  }

}
