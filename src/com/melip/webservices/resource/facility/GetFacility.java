package com.melip.webservices.resource.facility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.melip.common.constants.CommonConstants;
import com.melip.common.dto.common.AbstractResourceDto;
import com.melip.common.dto.common.FacilityDto;
import com.melip.webservices.common.BeanCreator;
import com.melip.webservices.constants.MessageConstants;
import com.melip.webservices.resource.common.AbstractResource;
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
    AbstractResourceDto resourceDto = null;

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
        resourceDto = createResourceErrorDto(FacilityDto.ENTITY, errMsgList);
      } else {
        // 施設DTOリスト取得
        IFacilityService service =
            BeanCreator.getBean(IFacilityService.SERVICE_NAME, IFacilityService.class);
        FacilityDto facilityDto = service.getFacilityDto(langDiv, facilityId);
        // 取得できなかった場合
        if (null == facilityDto) {
          status = HttpServletResponse.SC_NOT_FOUND;
          resourceDto =
              createResourceErrorDto(FacilityDto.ENTITY,
                  Arrays.asList(MessageProvider.formatMessage(MessageConstants.RSC_0004)));
        } else {
          resourceDto = createResourceSingleDto(FacilityDto.ENTITY, facilityDto);
        }
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
    // 言語区分必須チェック
    checkRequired(errMsgList, PARAM_LANG_DIV, langDiv);
    // 属性グループエイリアスの形式チェック
    checkAttrGrpAlias(errMsgList, PARAM_ATTR_GRP_ALIAS, attrGrpAlias);

    return errMsgList;
  }

}
