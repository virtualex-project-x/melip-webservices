package com.melip.webservices.service.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.melip.common.dto.common.IDto;
import com.melip.webservices.common.IDao;
import com.melip.webservices.constants.MessageConstants;

/**
 * サービスの基底クラスです。<br>
 * すべてのサービスはこのクラスを継承して作成します。
 */
public abstract class AbstractDataService extends AbstractService implements IDataService {

  /** DAO */
  private IDao dao;

  /**
   * @see com.melip.webservices.service.common.IDataService#selectOne(java.lang.String)
   */
  @Override
  public <T extends IDto> T selectOne(String sqlId) {
    return selectOne(sqlId, null);
  }

  /**
   * @see com.melip.webservices.service.common.IDataService#selectOne(java.lang.String,
   *      com.melip.webservices.service.common.QueryCondition)
   */
  @Override
  public <T extends IDto> T selectOne(String sqlId, QueryCondition condition) {

    T result = null;
    try {
      result = getSession().selectOne(sqlId, condition);
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
  public <E extends IDto> List<E> selectList(String sqlId) {
    return selectList(sqlId, null);
  }

  /**
   * @see com.melip.webservices.service.common.IDataService#selectList(java.lang.String,
   *      com.melip.webservices.service.common.QueryCondition)
   */
  @Override
  public <E extends IDto> List<E> selectList(String sqlId, QueryCondition condition) {

    List<E> resultList = new ArrayList<E>();
    try {
      resultList = getSession().selectList(sqlId, condition);
    } catch (Exception e) {
      throw new ServiceRuntimeException(MessageConstants.SVC_0003, e);
    } finally {
      getSession().close();
    }

    return resultList;
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
