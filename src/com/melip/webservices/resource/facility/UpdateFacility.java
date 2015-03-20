package com.melip.webservices.resource.facility;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.melip.common.constants.CommonConstants;
import com.melip.common.dto.common.FacilityDto;
import com.melip.common.dto.common.FacilityStoreDto;
import com.melip.webservices.common.BeanCreator;
import com.melip.webservices.constants.MessageConstants;
import com.melip.webservices.resource.common.AbstractResource;
import com.melip.webservices.service.facility.IFacilityService;
import com.melip.webservices.system.MelipRuntimeException;
import com.melip.webservices.system.MessageProvider;

/**
 * 施設情報を更新するクラスです。
 */
public class UpdateFacility extends AbstractResource {

  private static final Logger log = LoggerFactory.getLogger(UpdateFacility.class);

  /**
   * 施設情報を更新します。
   * 
   * @param facilityId 施設ID
   * @param facilityStoreDto 施設登録更新DTO
   * @return 施設情報を保持したリソースシングルDTO、もしくはリソースエラーDTO
   */
  public Response updateFacility(Integer facilityId, FacilityStoreDto facilityStoreDto) {

    int status = HttpServletResponse.SC_OK;
    Object responseEntity = null;

    try {
      // パラメータチェック
      List<String> errMsgList = checkParameters(facilityId, facilityStoreDto);
      // パラメータエラー
      if (CollectionUtils.isNotEmpty(errMsgList)) {
        log.error(MessageProvider.formatMessage(MessageConstants.RSC_0003));
        for (String errMsg : errMsgList) {
          log.error(errMsg);
        }
        status = HttpServletResponse.SC_BAD_REQUEST;
        responseEntity = createResourceErrorDto(FacilityDto.ENTITY, errMsgList);
      } else {
        // 更新処理
        IFacilityService service =
            BeanCreator.getBean(IFacilityService.SERVICE_NAME, IFacilityService.class);
        service.updateFacilityValues(facilityId, facilityStoreDto);
        return new GetFacility().getFacility(facilityId, null, null);
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
   * @param facilityStoreDto 施設登録更新DTO
   * @return エラーメッセージリスト
   */
  private List<String> checkParameters(Integer facilityId, FacilityStoreDto facilityStoreDto) {

    List<String> errMsgList = new ArrayList<String>();

    // TODO:どこまでやるか？
    // DBアクセスが増えるため、存在チェックはしない？

    return errMsgList;
  }

}
