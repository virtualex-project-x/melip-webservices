package com.melip.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.melip.dto.common.AbstractDto;
import com.melip.entity.Facility;

/**
 * テスト用のDTOです。
 */
@XmlRootElement
public class TestOutDto extends AbstractDto {

  private List<Facility> facilityList = null;

  /**
   * @return the facilityList
   */
  public List<Facility> getFacilityList() {
    return facilityList;
  }

  /**
   * @param facilityList the facilityList to set
   */
  public void setFacilityList(List<Facility> facilityList) {
    this.facilityList = facilityList;
  }
}
