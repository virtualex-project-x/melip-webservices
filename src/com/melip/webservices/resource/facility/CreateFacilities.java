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
 * 施設情報を新規作成するクラスです。
 */
public class CreateFacilities extends AbstractResource {

  private static final Logger log = LoggerFactory.getLogger(CreateFacilities.class);

  /**
   * 施設情報を新規作成します。
   * 
   * @param facilityStoreDtoList 施設登録更新DTOリスト
   * @return 登録された施設のIDリスト、もしくはリソースエラーDTO
   */
  public Response createFacilities(List<FacilityStoreDto> facilityStoreDtoList) {
    // TODO:一度に登録できる施設の件数制限を設けるか？（100件等）
    int status = HttpServletResponse.SC_OK;
    Object responseEntity = null;

    try {
      // パラメータチェック
      List<String> errMsgList = checkParameters(facilityStoreDtoList);
      // パラメータエラー
      if (CollectionUtils.isNotEmpty(errMsgList)) {
        log.error(MessageProvider.formatMessage(MessageConstants.RSC_0003));
        for (String errMsg : errMsgList) {
          log.error(errMsg);
        }
        status = HttpServletResponse.SC_BAD_REQUEST;
        responseEntity = createResourceErrorDto(FacilityDto.ENTITY, errMsgList);
      } else {
        // 登録処理
        IFacilityService service =
            BeanCreator.getBean(IFacilityService.SERVICE_NAME, IFacilityService.class);
        List<Integer> facilityIdList = service.insertFacilityValues(facilityStoreDtoList);
        responseEntity = facilityIdList;
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
   * @param facilityStoreDtoList 施設登録更新DTOリスト
   */
  /**
   * @param facilityStoreDtoList
   * @return
   */
  private List<String> checkParameters(List<FacilityStoreDto> facilityStoreDtoList) {

    // TODO:どこまでやるか？
    // DBアクセスが増えるため、存在チェックはしない？

    List<String> errMsgList = new ArrayList<String>();

    if (CollectionUtils.isNotEmpty(facilityStoreDtoList)) {
      for (FacilityStoreDto facilityStoreDto : facilityStoreDtoList) {
      }
    }

    return errMsgList;
  }

}
