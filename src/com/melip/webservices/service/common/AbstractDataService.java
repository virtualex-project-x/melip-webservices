package com.melip.webservices.service.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.melip.webservices.common.IDao;
import com.melip.webservices.constants.MessageConstants;

/**
 * サービスの基底クラスです。<br>
 * すべてのサービスはこのクラスを継承して作成します。
 */
public abstract class AbstractDataService extends AbstractService implements IDataService {

  // TODO:ユーザーの仕組みができたら新規登録、更新時に登録者・更新者を設定する必要がある。

  /** DAO */
  private IDao dao;

  /**
   * @see com.melip.webservices.service.common.IDataService#selectOne(java.lang.String)
   */
  @Override
  public <T extends Object> T selectOne(String sqlId) {
    return selectOne(sqlId, null);
  }

  /**
   * @see com.melip.webservices.service.common.IDataService#selectOne(java.lang.String,
   *      java.lang.Object)
   */
  @Override
  public <T extends Object> T selectOne(String sqlId, Object param) {
    // TODO:getSessionするたびに新たなセッションが作られるため、クローズできてない
    T result = null;
    try {
      result = getSession().selectOne(sqlId, param);
    } catch (Exception e) {
      throw new ServiceRuntimeException(MessageConstants.SVC_0003, e);
    } finally {
      getSession().close();
    }

    return result;
  }

  /**
   * @see com.melip.webservices.service.common.IDataService#selectList(java.lang.String)
   */
  @Override
  public <E extends Object> List<E> selectList(String sqlId) {
    return selectList(sqlId, null);
  }

  /**
   * @see com.melip.webservices.service.common.IDataService#selectList(java.lang.String,
   *      java.lang.Object)
   */
  @Override
  public <E extends Object> List<E> selectList(String sqlId, Object param) {
    // TODO:getSessionするたびに新たなセッションが作られるため、クローズできてない
    List<E> resultList = new ArrayList<E>();
    try {
      resultList = getSession().selectList(sqlId, param);
    } catch (Exception e) {
      throw new ServiceRuntimeException(MessageConstants.SVC_0003, e);
    } finally {
      getSession().close();
    }

    return resultList;
  }

  /**
   * @see com.melip.webservices.service.common.IDataService#update(java.lang.String)
   */
  @Override
  public int update(String sqlId) {
    return update(sqlId, null);
  }

  /**
   * @see com.melip.webservices.service.common.IDataService#update(java.lang.String,
   *      java.lang.Object)
   */
  @Override
  public int update(String sqlId, Object param) {
    // TODO:getSessionするたびに新たなセッションが作られるため、クローズできてない
    int updateCount = 0;
    try {
      updateCount = getSession().update(sqlId, param);
    } catch (Exception e) {
      throw new ServiceRuntimeException(MessageConstants.SVC_0003, e);
    } finally {
      getSession().close();
    }

    return updateCount;
  }

  /**
   * SQLセッションを取得します。
   * 
   * @return SQLセッション
   */
  protected SqlSession getSession() {
    return getDao().getSqlSessionFactory().openSession();
  }

  /**
   * DAOを取得します。
   * 
   * @return DAO
   */
  private IDao getDao() {
    return dao;
  }

  /**
   * DAOを設定します。
   * 
   * @param DAO
   */
  public void setDao(IDao dao) {
    this.dao = dao;
  }

}
