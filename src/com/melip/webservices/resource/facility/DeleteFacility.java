package com.melip.webservices.resource.facility;

import javax.ws.rs.core.Response;

import com.melip.webservices.common.BeanCreator;
import com.melip.webservices.resource.common.AbstractResource;
import com.melip.webservices.service.facility.IFacilityService;

/**
 * 施設情報を削除するクラスです。
 */
public class DeleteFacility extends AbstractResource {

  public Response deleteFacility(int facilityId) {
    IFacilityService service =
        BeanCreator.getBean(IFacilityService.SERVICE_NAME, IFacilityService.class);
    service.logicalDeleteFacility(facilityId);
    return null;
  }

  // TODO:
  // パラメータ：削除対象施設ID
  // TODO:トランザクション制御
}
