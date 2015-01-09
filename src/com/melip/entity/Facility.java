package com.melip.entity;

import com.melip.entity.common.AbstractEntity;


public class Facility extends AbstractEntity {
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_facility.FACILITY_ID
   *
   * @mbggenerated Thu Jan 08 18:12:08 JST 2015
   */
  private Integer facilityId;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_facility.REGION_ID
   *
   * @mbggenerated Thu Jan 08 18:12:08 JST 2015
   */
  private Integer regionId;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_facility.PUBLISH_STS
   *
   * @mbggenerated Thu Jan 08 18:12:08 JST 2015
   */
  private String publishSts;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_facility.FACILITY_ID
   *
   * @return the value of m_facility.FACILITY_ID
   *
   * @mbggenerated Thu Jan 08 18:12:08 JST 2015
   */
  public Integer getFacilityId() {
    return facilityId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_facility.FACILITY_ID
   *
   * @param facilityId the value for m_facility.FACILITY_ID
   *
   * @mbggenerated Thu Jan 08 18:12:08 JST 2015
   */
  public void setFacilityId(Integer facilityId) {
    this.facilityId = facilityId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_facility.REGION_ID
   *
   * @return the value of m_facility.REGION_ID
   *
   * @mbggenerated Thu Jan 08 18:12:08 JST 2015
   */
  public Integer getRegionId() {
    return regionId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_facility.REGION_ID
   *
   * @param regionId the value for m_facility.REGION_ID
   *
   * @mbggenerated Thu Jan 08 18:12:08 JST 2015
   */
  public void setRegionId(Integer regionId) {
    this.regionId = regionId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_facility.PUBLISH_STS
   *
   * @return the value of m_facility.PUBLISH_STS
   *
   * @mbggenerated Thu Jan 08 18:12:08 JST 2015
   */
  public String getPublishSts() {
    return publishSts;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_facility.PUBLISH_STS
   *
   * @param publishSts the value for m_facility.PUBLISH_STS
   *
   * @mbggenerated Thu Jan 08 18:12:08 JST 2015
   */
  public void setPublishSts(String publishSts) {
    this.publishSts = publishSts;
  }
}
