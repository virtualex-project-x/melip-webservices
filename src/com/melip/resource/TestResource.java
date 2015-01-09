/**
 * 
 */
package com.melip.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.melip.common.BeanCreator;
import com.melip.dto.TestOutDto;
import com.melip.entity.Facility;
import com.melip.resource.common.AbstractResource;
import com.melip.service.ITestService;

@Path("/json")
public class TestResource extends AbstractResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public TestOutDto hello() {

    ITestService service = BeanCreator.getBean(ITestService.SERVICE_NAME, ITestService.class);
    List<Facility> facilityList = service.getFacilityList();
    TestOutDto dto = new TestOutDto();
    dto.setFacilityList(facilityList);
    return dto;
  }

}
