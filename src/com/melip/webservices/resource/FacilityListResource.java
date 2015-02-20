package com.melip.webservices.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.melip.common.constants.CommonConstants;
import com.melip.common.dto.common.AbstractResourceDto;
import com.melip.webservices.common.BeanCreator;
import com.melip.webservices.common.DtoList;
import com.melip.webservices.constants.MessageConstants;
import com.melip.webservices.dto.AttrGrpSearchConditionDto;
import com.melip.webservices.dto.FacilityDto;
import com.melip.webservices.dto.FacilitySearchConditionDto;
import com.melip.webservices.resource.common.AbstractResource;
import com.melip.webservices.resource.common.ResourceException;
import com.melip.webservices.service.common.QueryCondition;
import com.melip.webservices.service.facility.IFacilityService;
import com.melip.webservices.system.MelipRuntimeException;
import com.melip.webservices.system.MessageProvider;

/**
 * 複数の施設情報を取得するクラスです。
 */
@Path("/facilityList")
public class FacilityListResource extends AbstractResource {

  private static final Logger log = LoggerFactory.getLogger(FacilityListResource.class);

  /** パラメータ 地域ID */
  private static final String PARAM_REGION_ID = "regionId";
  /** パラメータ 検索条件 */
  private static final String PARAM_CONDITION = "condition";
  /** パラメータ 開始位置 */
  private static final String PARAM_INDEX = "index";
  /** パラメータ 件数 */
  private static final String PARAM_COUNT = "count";
  /** パラメータ ソートキー */
  private static final String PARAM_ORDER = "order";

  /**
   * 複数の施設情報をJSON形式で取得します。
   * 
   * @param langDiv 言語区分
   * @param attrGrpAlias 属性グループエイリアス
   * @param regionId 地域ID
   * @param condition 検索条件
   * @param index 開始位置
   * @param count 件数
   * @param order ソートキー
   * @return 施設情報を保持したリソースマルチDTO、もしくはリソースエラーDTO
   */
  @GET
  @Produces(CommonConstants.MEDIA_TYPE_JSON)
  public AbstractResourceDto getFacilityList(@QueryParam(PARAM_LANG_DIV) String langDiv,
      @QueryParam(PARAM_ATTR_GRP_ALIAS) String attrGrpAlias,
      @QueryParam(PARAM_REGION_ID) String regionId, @QueryParam(PARAM_CONDITION) String condition,
      @QueryParam(PARAM_INDEX) String index, @QueryParam(PARAM_COUNT) String count,
      @QueryParam(PARAM_ORDER) String order) {

    DtoList<FacilityDto> facilityDtolist = null;

    try {
      // パラメータチェック
      List<String> errMsgList =
          checkParameters(langDiv, attrGrpAlias, regionId, condition, index, count, order);
      // パラメータエラー
      if (CollectionUtils.isNotEmpty(errMsgList)) {
        log.error(MessageProvider.formatMessage(MessageConstants.RSC_0003));
        for (String errMsg : errMsgList) {
          log.error(errMsg);
        }
        return createResourceErrorDto(FacilityDto.ENTITY, errMsgList);
      }

      // 検索条件生成
      FacilitySearchConditionDto facilityCondition =
          createFacilitySearchCondition(attrGrpAlias, regionId, condition);
      QueryCondition queryCondition = createQueryCondition(langDiv, index, count, order);
      queryCondition.setParam(facilityCondition);

      // 施設DTOリスト取得
      IFacilityService service =
          BeanCreator.getBean(IFacilityService.SERVICE_NAME, IFacilityService.class);
      facilityDtolist = service.getFacilityDtoList(queryCondition);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return createResourceErrorDto(FacilityDto.ENTITY, new MelipRuntimeException(e));
    }

    return createResourceMultiDto(FacilityDto.ENTITY, facilityDtolist);
  }

  /**
   * パラメータチェックを行います。
   * 
   * @param langDiv 言語区分
   * @param attrGrpAlias 属性グループエイリアス
   * @param regionId 地域ID
   * @param condition 検索条件
   * @param index 開始位置
   * @param count 件数
   * @param order ソートキー
   * @return エラーメッセージリスト
   * @throws ResourceException
   */
  private List<String> checkParameters(String langDiv, String attrGrpAlias, String regionId,
      String condition, String index, String count, String order) throws ResourceException {

    if (log.isDebugEnabled()) {
      log.debug("【パラメータ情報】");
      log.debug("  言語区分               -> " + langDiv);
      log.debug("  属性グループエイリアス -> " + attrGrpAlias);
      log.debug("  地域ID                 -> " + regionId);
      log.debug("  検索条件               -> " + condition);
      log.debug("  開始位置               -> " + index);
      log.debug("  件数                   -> " + count);
      log.debug("  ソートキー             -> " + order);
    }

    List<String> errMsgList = new ArrayList<String>();
    // 言語区分必須チェック
    checkRequired(errMsgList, PARAM_LANG_DIV, langDiv);
    // 属性グループエイリアスの形式チェック
    checkAttrGrpAlias(errMsgList, PARAM_ATTR_GRP_ALIAS, attrGrpAlias);
    // 地域ID数値チェック
    checkNumeric(errMsgList, PARAM_REGION_ID, regionId);
    // 地域ID範囲チェック
    checkRange(errMsgList, PARAM_REGION_ID, regionId, 1, null);
    // 検索条件の形式チェック
    checkCondition(errMsgList, PARAM_CONDITION, condition);
    // 開始位置数値チェック
    checkNumeric(errMsgList, PARAM_INDEX, index);
    // 開始位置範囲チェック
    checkRange(errMsgList, PARAM_INDEX, index, 1, QueryCondition.DEFAULT_COUNT);
    // 件数数値チェック
    checkNumeric(errMsgList, PARAM_COUNT, count);
    // 件数範囲チェック
    checkRange(errMsgList, PARAM_COUNT, count, 1, QueryCondition.DEFAULT_COUNT);
    // ソートキーの形式チェック
    checkOrder(errMsgList, PARAM_ORDER, order);

    return errMsgList;
  }

  /**
   * 施設検索条件DTOを生成します。
   * 
   * @param attrGrpAlias 属性グループエイリアス
   * @param regionId 地域ID
   * @param condition 検索条件
   * @return
   */
  private FacilitySearchConditionDto createFacilitySearchCondition(String attrGrpAlias,
      String regionId, String condition) {

    FacilitySearchConditionDto facilityConditionDto = new FacilitySearchConditionDto();

    // 取得対象属性グループエイリアスリスト
    if (StringUtils.isNotEmpty(attrGrpAlias)) {
      facilityConditionDto.setTargetAttrGrpAliasList(Arrays.asList(attrGrpAlias
          .split(SEPARATOR_ITEM)));
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

}
