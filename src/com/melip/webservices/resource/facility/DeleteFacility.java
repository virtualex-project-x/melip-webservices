package com.melip.webservices.resource.facility;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.melip.common.constants.CommonConstants;
import com.melip.common.dto.common.FacilityDto;
import com.melip.webservices.common.BeanCreator;
import com.melip.webservices.resource.common.AbstractResource;
import com.melip.webservices.service.facility.IFacilityService;
import com.melip.webservices.system.MelipRuntimeException;

/**
 * 施設情報を削除するクラスです。
 */
public class DeleteFacility extends AbstractResource {

  private static final Logger log = LoggerFactory.getLogger(DeleteFacility.class);

  /**
   * 施設情報を削除します。
   * 
   * @param facilityId 施設ID
   * @return 空、もしくはリソースエラーDTO
   */
  public Response deleteFacility(int facilityId) {

    int status = HttpServletResponse.SC_OK;
    Object responseEntity = null;

    try {
      if (log.isDebugEnabled()) {
        log.debug("【パラメータ情報】");
        log.debug("  施設ID -> " + facilityId);
      }
      // 施設情報削除
      IFacilityService service =
          BeanCreator.getBean(IFacilityService.SERVICE_NAME, IFacilityService.class);
      service.logicalDeleteFacility(facilityId);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
      responseEntity = createResourceErrorDto(FacilityDto.ENTITY, new MelipRuntimeException(e));
    }

    return Response.status(status).entity(responseEntity).type(CommonConstants.MEDIA_TYPE_JSON)
        .build();
  }

}
