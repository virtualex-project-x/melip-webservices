package com.melip.webservices.entity.common;

import java.util.Date;

/**
 * エンティティの基底クラスです。<br>
 * すべてのエンティティはこのクラスを継承して作成します。
 */
public abstract class AbstractEntity implements IEntity {

  /** 登録日時のフィールド名 */
  public static final String FIELD_CREATE_DATETIME = "createDatetime";
  /** 登録者のフィールド名 */
  public static final String FIELD_CREATE_USER = "createUser";
  /** 更新日時のフィールド名 */
  public static final String FIELD_UPDATE_DATETIME = "updateDatetime";
  /** 更新者のフィールド名 */
  public static final String FIELD_UPDATE_USER = "updateUser";
  /** ステータスのフィールド名 */
  public static final String FIELD_STS = "sts";

  /** 登録日時 */
  private Date createDatetime;
  /** 登録者 */
  private Integer createUser;
  /** 更新日時 */
  private Date updateDatetime;
  /** 更新者 */
  private Integer updateUser;
  /** ステータス */
  private String sts;

  /**
   * 登録日時を取得します。
   * 
   * @return 登録日時
   */
  public Date getCreateDatetime() {
    return createDatetime;
  }

  /**
   * 登録日時を設定します。
   * 
   * @param createDatetime 登録日時
   */
  public void setCreateDatetime(Date createDatetime) {
    this.createDatetime = createDatetime;
  }

  /**
   * 登録者を取得します。
   * 
   * @return 登録者
   */
  public Integer getCreateUser() {
    return createUser;
  }

  /**
   * 登録者を設定します。
   * 
   * @param createUser 登録者
   */
  public void setCreateUser(Integer createUser) {
    this.createUser = createUser;
  }

  /**
   * 更新日時を取得します。
   * 
   * @return 更新日時
   */
  public Date getUpdateDatetime() {
    return updateDatetime;
  }

  /**
   * 更新日時を設定します。
   * 
   * @param updateDatetime 更新日時
   */
  public void setUpdateDatetime(Date updateDatetime) {
    this.updateDatetime = updateDatetime;
  }

  /**
   * 更新者を取得します。
   * 
   * @return 更新者
   */
  public Integer getUpdateUser() {
    return updateUser;
  }

  /**
   * 更新者を設定します。
   * 
   * @param updateUser 更新者
   */
  public void setUpdateUser(Integer updateUser) {
    this.updateUser = updateUser;
  }

  /**
   * ステータスを取得します。
   * 
   * @return ステータス
   */
  public String getSts() {
    return sts;
  }

  /**
   * ステータスを設定します。
   * 
   * @param sts ステータス
   */
  public void setSts(String sts) {
    this.sts = sts;
  }

}
