package com.melip.webservices.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.melip.common.constants.CommonConstants;
import com.melip.common.dto.common.AbstractResourceDto;
import com.melip.common.dto.common.FacilityDto;
import com.melip.webservices.common.BeanCreator;
import com.melip.webservices.constants.MessageConstants;
import com.melip.webservices.resource.common.AbstractResource;
import com.melip.webservices.resource.common.ResourceException;
import com.melip.webservices.service.facility.IFacilityService;
import com.melip.webservices.system.MelipRuntimeException;
import com.melip.webservices.system.MessageProvider;

/**
 * 単体の施設情報を取得するクラスです。
 */
@Path("/facility")
public class FacilityResource extends AbstractResource {

  private static final Logger log = LoggerFactory.getLogger(FacilityResource.class);

  /** パラメータ 施設ID */
  private static final String PARAM_FACILITY_ID = "facilityId";

  /**
   * 単体の施設情報をJSON形式で取得します。
   * 
   * @param langDiv 言語区分
   * @param attrGrpAlias 属性グループエイリアス
   * @param facilityId 施設ID
   * @return 施設情報を保持したリソースシングルDTO、もしくはリソースエラーDTO
   */
  @GET
  @Produces(CommonConstants.MEDIA_TYPE_JSON)
  public AbstractResourceDto getFacility(@QueryParam(PARAM_LANG_DIV) String langDiv,
      @QueryParam(PARAM_ATTR_GRP_ALIAS) String attrGrpAlias,
      @QueryParam(PARAM_FACILITY_ID) String facilityId) {

    FacilityDto facilityDto = null;

    try {
      // パラメータチェック
      List<String> errMsgList = checkParameters(langDiv, attrGrpAlias, facilityId);
      // パラメータエラー
      if (CollectionUtils.isNotEmpty(errMsgList)) {
        log.error(MessageProvider.formatMessage(MessageConstants.RSC_0003));
        for (String errMsg : errMsgList) {
          log.error(errMsg);
        }
        return createResourceErrorDto(FacilityDto.ENTITY, errMsgList);
      }

      // 施設DTOリスト取得
      IFacilityService service =
          BeanCreator.getBean(IFacilityService.SERVICE_NAME, IFacilityService.class);
      facilityDto = service.getFacilityDto(langDiv, Integer.valueOf(facilityId));
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return createResourceErrorDto(FacilityDto.ENTITY, new MelipRuntimeException(e));
    }

    return createResourceSingleDto(FacilityDto.ENTITY, facilityDto);
  }

  /**
   * パラメータチェックを行います。
   * 
   * @param langDiv 言語区分
   * @param attrGrpAlias 属性グループエイリアス
   * @param facilityId 施設ID
   * @return エラーメッセージリスト
   * @throws ResourceException
   */
  private List<String> checkParameters(String langDiv, String attrGrpAlias, String facilityId)
      throws ResourceException {

    if (log.isDebugEnabled()) {
      log.debug("【パラメータ情報】");
      log.debug("  言語区分               -> " + langDiv);
      log.debug("  属性グループエイリアス -> " + attrGrpAlias);
      log.debug("  施設ID                 -> " + facilityId);
    }

    List<String> errMsgList = new ArrayList<String>();
    // 言語区分必須チェック
    checkRequired(errMsgList, PARAM_LANG_DIV, langDiv);
    // 属性グループエイリアスの形式チェック
    checkAttrGrpAlias(errMsgList, PARAM_ATTR_GRP_ALIAS, attrGrpAlias);
    // 施設ID必須チェック
    checkRequired(errMsgList, PARAM_FACILITY_ID, facilityId);

    return errMsgList;
  }

}
