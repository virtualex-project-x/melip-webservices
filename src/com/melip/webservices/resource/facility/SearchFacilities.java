package com.melip.webservices.resource.facility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.melip.common.constants.CommonConstants;
import com.melip.common.dto.common.AbstractResourceDto;
import com.melip.common.dto.common.FacilityDto;
import com.melip.webservices.common.BeanCreator;
import com.melip.webservices.common.DtoList;
import com.melip.webservices.constants.MessageConstants;
import com.melip.webservices.dto.AttrGrpSearchConditionDto;
import com.melip.webservices.dto.FacilitySearchConditionDto;
import com.melip.webservices.resource.common.AbstractResource;
import com.melip.webservices.service.common.QueryCondition;
import com.melip.webservices.service.facility.IFacilityService;
import com.melip.webservices.system.MelipRuntimeException;
import com.melip.webservices.system.MessageProvider;

/**
 * 施設情報を検索するクラスです。
 */
public class SearchFacilities extends AbstractResource {

  private static final Logger log = LoggerFactory.getLogger(SearchFacilities.class);

  /** デフォルトの半径（m） */
  private static final Integer RADIUS_DEFAULT = Integer.MAX_VALUE;

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
   * @param latitude 緯度
   * @param longitude 経度
   * @param radius 半径
   * @return 施設情報を保持したリソースマルチDTO、もしくはリソースエラーDTO
   */
  public Response searchFacilities(String langDiv, String attrGrpAlias, String regionId,
      String condition, String index, String count, String order, String latitude,
      String longitude, String radius) {

    int status = HttpServletResponse.SC_OK;
    AbstractResourceDto resourceDto = null;

    try {
      // パラメータチェック
      List<String> errMsgList =
          checkParameters(langDiv, attrGrpAlias, regionId, condition, index, count, order,
              latitude, longitude, radius);
      // パラメータエラー
      if (CollectionUtils.isNotEmpty(errMsgList)) {
        log.error(MessageProvider.formatMessage(MessageConstants.RSC_0003));
        for (String errMsg : errMsgList) {
          log.error(errMsg);
        }
        status = HttpServletResponse.SC_BAD_REQUEST;
        resourceDto = createResourceErrorDto(FacilityDto.ENTITY, errMsgList);
      } else {
        // 検索条件生成
        FacilitySearchConditionDto facilityCondition =
            createFacilitySearchCondition(attrGrpAlias, regionId, condition, latitude, longitude,
                radius);
        QueryCondition queryCondition = createQueryCondition(langDiv, index, count, order);
        queryCondition.setParam(facilityCondition);

        // 施設DTOリスト取得
        IFacilityService service =
            BeanCreator.getBean(IFacilityService.SERVICE_NAME, IFacilityService.class);
        DtoList<FacilityDto> facilityDtolist = service.getFacilityDtoList(queryCondition);
        resourceDto = createResourceMultiDto(FacilityDto.ENTITY, facilityDtolist);
      }
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
      resourceDto = createResourceErrorDto(FacilityDto.ENTITY, new MelipRuntimeException(e));
    }

    return Response.status(status).entity(resourceDto).type(CommonConstants.MEDIA_TYPE_JSON)
        .build();
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
   * @param latitude 緯度
   * @param longitude 経度
   * @param radius 半径
   * @return エラーメッセージリスト
   */
  private List<String> checkParameters(String langDiv, String attrGrpAlias, String regionId,
      String condition, String index, String count, String order, String latitude,
      String longitude, String radius) {

    if (log.isDebugEnabled()) {
      log.debug("【パラメータ情報】");
      log.debug("  言語区分               -> " + langDiv);
      log.debug("  属性グループエイリアス -> " + attrGrpAlias);
      log.debug("  地域ID                 -> " + regionId);
      log.debug("  検索条件               -> " + condition);
      log.debug("  開始位置               -> " + index);
      log.debug("  件数                   -> " + count);
      log.debug("  ソートキー             -> " + order);
      log.debug("  緯度                   -> " + latitude);
      log.debug("  経度                   -> " + longitude);
      log.debug("  半径                   -> " + radius);
    }

    List<String> errMsgList = new ArrayList<String>();
    // 言語区分必須チェック
    checkRequired(errMsgList, PARAM_LANG_DIV, langDiv);
    // 属性グループエイリアスの形式チェック
    checkAttrGrpAlias(errMsgList, PARAM_ATTR_GRP_ALIAS, attrGrpAlias);
    // 地域ID整数チェック
    checkInteger(errMsgList, PARAM_REGION_ID, regionId);
    // 地域ID範囲チェック
    checkRange(errMsgList, PARAM_REGION_ID, regionId, 1, null);
    // 検索条件の形式チェック
    checkCondition(errMsgList, PARAM_CONDITION, condition);
    // 開始位置整数チェック
    checkInteger(errMsgList, PARAM_INDEX, index);
    // 開始位置範囲チェック
    checkRange(errMsgList, PARAM_INDEX, index, 1, QueryCondition.DEFAULT_COUNT);
    // 件数整数チェック
    checkInteger(errMsgList, PARAM_COUNT, count);
    // 件数範囲チェック
    checkRange(errMsgList, PARAM_COUNT, count, 1, QueryCondition.DEFAULT_COUNT);
    // ソートキーの形式チェック
    checkOrder(errMsgList, PARAM_ORDER, order);
    // 緯度の数値チェック
    checkDecimal(errMsgList, PARAM_LATITUDE, latitude);
    // 緯度の範囲チェック
    checkRange(errMsgList, PARAM_LATITUDE, latitude, 0, 90);
    // 経度の数値チェック
    checkDecimal(errMsgList, PARAM_LONGITUDE, longitude);
    // 経度の範囲チェック
    checkRange(errMsgList, PARAM_LONGITUDE, longitude, -180, 180);
    // 半径の数値チェック
    checkInteger(errMsgList, PARAM_RADIUS, radius);
    // 半径の範囲チェック
    checkRange(errMsgList, PARAM_RADIUS, radius, 0, null);

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
      String regionId, String condition, String latitude, String longitude, String radius) {

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

    // 緯度・経度・半径
    if (StringUtils.isNotEmpty(latitude) && StringUtils.isNotEmpty(longitude)) {
      facilityConditionDto.setlatitude(Float.valueOf(latitude));
      facilityConditionDto.setlongitude(Float.valueOf(longitude));
      if (StringUtils.isEmpty(radius)) {
        facilityConditionDto.setradius(RADIUS_DEFAULT);
      } else {
        facilityConditionDto.setradius(Integer.valueOf(radius));
      }
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
