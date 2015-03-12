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
import com.melip.common.dto.common.FacilityDto;
import com.melip.webservices.common.BeanCreator;
import com.melip.webservices.constants.MessageConstants;
import com.melip.webservices.dto.FacilitySearchConditionDto;
import com.melip.webservices.resource.common.AbstractResource;
import com.melip.webservices.service.common.QueryCondition;
import com.melip.webservices.service.facility.IFacilityService;
import com.melip.webservices.system.MelipRuntimeException;
import com.melip.webservices.system.MessageProvider;

/**
 * 施設情報を取得するクラスです。
 */
public class GetFacility extends AbstractResource {

  private static final Logger log = LoggerFactory.getLogger(GetFacility.class);

  /**
   * 単体の施設情報をJSON形式で取得します。
   * 
   * @param facilityId 施設ID
   * @param langDiv 言語区分
   * @param attrGrpAlias 属性グループエイリアス
   * @return 施設情報を保持したリソースシングルDTO、もしくはリソースエラーDTO
   */
  public Response getFacility(int facilityId, String langDiv, String attrGrpAlias) {

    int status = HttpServletResponse.SC_OK;
    Object responseEntity = null;

    try {
      // パラメータチェック
      List<String> errMsgList = checkParameters(facilityId, langDiv, attrGrpAlias);
      // パラメータエラー
      if (CollectionUtils.isNotEmpty(errMsgList)) {
        log.error(MessageProvider.formatMessage(MessageConstants.RSC_0003));
        for (String errMsg : errMsgList) {
          log.error(errMsg);
        }
        status = HttpServletResponse.SC_BAD_REQUEST;
        responseEntity = createResourceErrorDto(FacilityDto.ENTITY, errMsgList);
      } else {
        // 検索条件生成
        FacilitySearchConditionDto facilityConditionDto = new FacilitySearchConditionDto();
        if (StringUtils.isNotEmpty(attrGrpAlias)) {
          facilityConditionDto.setTargetAttrGrpAliasList(Arrays.asList(attrGrpAlias
              .split(SEPARATOR_ITEM)));
        }
        QueryCondition queryCondition = new QueryCondition();
        if (StringUtils.isNotEmpty(langDiv)) {
          queryCondition.setLangDiv(langDiv);
        }
        queryCondition.setParam(facilityConditionDto);
        queryCondition.setValue(FacilityDto.FIELD_FACILITY_ID, facilityId);

        // 施設DTOリスト取得
        IFacilityService service =
            BeanCreator.getBean(IFacilityService.SERVICE_NAME, IFacilityService.class);
        FacilityDto facilityDto = service.getFacilityDto(queryCondition);
        // 取得できなかった場合
        if (null == facilityDto) {
          status = HttpServletResponse.SC_NOT_FOUND;
          responseEntity =
              createResourceErrorDto(FacilityDto.ENTITY,
                  Arrays.asList(MessageProvider.formatMessage(MessageConstants.RSC_0004)));
        } else {
          responseEntity = createResourceSingleDto(FacilityDto.ENTITY, facilityDto);
        }
      }
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
      responseEntity = createResourceErrorDto(FacilityDto.ENTITY, new MelipRuntimeException(e));
    }

    return Response.status(status).entity(responseEntity).type(CommonConstants.MEDIA_TYPE_JSON)
        .build();
  }

  /**
   * パラメータチェックを行います。
   * 
   * @param facilityId 施設ID
   * @param langDiv 言語区分
   * @param attrGrpAlias 属性グループエイリアス
   * @return エラーメッセージリスト
   */
  private List<String> checkParameters(int facilityId, String langDiv, String attrGrpAlias) {

    if (log.isDebugEnabled()) {
      log.debug("【パラメータ情報】");
      log.debug("  施設ID                 -> " + facilityId);
      log.debug("  言語区分               -> " + langDiv);
      log.debug("  属性グループエイリアス -> " + attrGrpAlias);
    }

    List<String> errMsgList = new ArrayList<String>();
    // 属性グループエイリアスの形式チェック
    checkAttrGrpAlias(errMsgList, PARAM_ATTR_GRP_ALIAS, attrGrpAlias);

    return errMsgList;
  }

}
