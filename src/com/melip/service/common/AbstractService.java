package com.melip.service.common;

import com.melip.common.IDao;

/**
 * サービスの基底クラスです。<br>
 * すべてのサービスはこのクラスを継承して作成します。
 */
public abstract class AbstractService implements IService {

  /** DAO */
  private IDao dao = null;

  /**
   * DAOを取得します。
   * 
   * @return DAO。
   */
  public IDao getDao() {
    return dao;
  }

  /**
   * DAOを設定します。
   * 
   * @param DAO。
   */
  public void setDao(IDao dao) {
    this.dao = dao;
  }

}
