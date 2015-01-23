package com.melip.webservices.entity.common;

import java.util.Date;

/**
 * エンティティの基底クラスです。<br>
 * すべてのエンティティはこのクラスを継承して作成します。
 */
public abstract class AbstractEntity implements IEntity {

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_cd_grp.CREATE_DATETIME
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  private Date createDatetime;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_cd_grp.CREATE_USER
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  private Integer createUser;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_cd_grp.UPDATE_DATETIME
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  private Date updateDatetime;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_cd_grp.UPDATE_USER
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  private Integer updateUser;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * m_cd_grp.STS
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  private String sts;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_cd_grp.CREATE_DATETIME
   *
   * @return the value of m_cd_grp.CREATE_DATETIME
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  public Date getCreateDatetime() {
    return createDatetime;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_cd_grp.CREATE_DATETIME
   *
   * @param createDatetime the value for m_cd_grp.CREATE_DATETIME
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  public void setCreateDatetime(Date createDatetime) {
    this.createDatetime = createDatetime;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_cd_grp.CREATE_USER
   *
   * @return the value of m_cd_grp.CREATE_USER
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  public Integer getCreateUser() {
    return createUser;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_cd_grp.CREATE_USER
   *
   * @param createUser the value for m_cd_grp.CREATE_USER
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  public void setCreateUser(Integer createUser) {
    this.createUser = createUser;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_cd_grp.UPDATE_DATETIME
   *
   * @return the value of m_cd_grp.UPDATE_DATETIME
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  public Date getUpdateDatetime() {
    return updateDatetime;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_cd_grp.UPDATE_DATETIME
   *
   * @param updateDatetime the value for m_cd_grp.UPDATE_DATETIME
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  public void setUpdateDatetime(Date updateDatetime) {
    this.updateDatetime = updateDatetime;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_cd_grp.UPDATE_USER
   *
   * @return the value of m_cd_grp.UPDATE_USER
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  public Integer getUpdateUser() {
    return updateUser;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_cd_grp.UPDATE_USER
   *
   * @param updateUser the value for m_cd_grp.UPDATE_USER
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  public void setUpdateUser(Integer updateUser) {
    this.updateUser = updateUser;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column m_cd_grp.STS
   *
   * @return the value of m_cd_grp.STS
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  public String getSts() {
    return sts;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column m_cd_grp.STS
   *
   * @param sts the value for m_cd_grp.STS
   *
   * @mbggenerated Tue Jan 06 15:03:49 JST 2015
   */
  public void setSts(String sts) {
    this.sts = sts;
  }

}