package com.melip.webservices.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.collections.CollectionUtils;

import com.melip.common.dto.common.IDto;
import com.melip.webservices.service.common.QueryCondition;

/**
 * DTOの検索結果を格納するリストクラスです。
 */
public class DtoList<E extends IDto> implements List<E> {

  /** DTOのリスト */
  private List<E> dtoList = new ArrayList<E>();
  /** 全件数 */
  private Integer allCount;
  /** 開始位置 */
  private Integer index;
  /** 取得件数 */
  private Integer count;
  /** 検索条件 */
  private QueryCondition condition;

  /**
   * コンストラクタ
   */
  public DtoList() {}

  /**
   * コンストラクタ
   * 
   * @param list DTOのリスト
   */
  public DtoList(List<E> list) {

    if (CollectionUtils.isNotEmpty(list)) {
      setDtoList(list);
    }
  }

  /**
   * @see java.util.List#add(java.lang.Object)
   */
  @Override
  public boolean add(E e) {
    return getDtoList().add(e);
  }

  /**
   * @see java.util.List#add(int, java.lang.Object)
   */
  @Override
  public void add(int index, E element) {
    getDtoList().add(index, element);
  }

  /**
   * @see java.util.List#addAll(java.util.Collection)
   */
  @Override
  public boolean addAll(Collection<? extends E> c) {
    return getDtoList().addAll(c);
  }

  /**
   * @see java.util.List#addAll(int, java.util.Collection)
   */
  @Override
  public boolean addAll(int index, Collection<? extends E> c) {
    return getDtoList().addAll(index, c);
  }

  /**
   * @see java.util.List#clear()
   */
  @Override
  public void clear() {
    getDtoList().clear();
  }

  /**
   * @see java.util.List#contains(java.lang.Object)
   */
  @Override
  public boolean contains(Object o) {
    return getDtoList().contains(o);
  }

  /**
   * @see java.util.List#containsAll(java.util.Collection)
   */
  @Override
  public boolean containsAll(Collection<?> c) {
    return getDtoList().containsAll(c);
  }

  /**
   * @see java.util.List#get(int)
   */
  @Override
  public E get(int index) {
    return getDtoList().get(index);
  }

  /**
   * @see java.util.List#indexOf(java.lang.Object)
   */
  @Override
  public int indexOf(Object o) {
    return getDtoList().indexOf(o);
  }

  /**
   * @see java.util.List#isEmpty()
   */
  @Override
  public boolean isEmpty() {
    return getDtoList().isEmpty();
  }

  /**
   * @see java.util.List#iterator()
   */
  @Override
  public Iterator<E> iterator() {
    return getDtoList().iterator();
  }

  /**
   * @see java.util.List#lastIndexOf(java.lang.Object)
   */
  @Override
  public int lastIndexOf(Object o) {
    return getDtoList().lastIndexOf(o);
  }

  /**
   * @see java.util.List#listIterator()
   */
  @Override
  public ListIterator<E> listIterator() {
    return getDtoList().listIterator();
  }

  /**
   * @see java.util.List#listIterator(int)
   */
  @Override
  public ListIterator<E> listIterator(int index) {
    return getDtoList().listIterator(index);
  }

  /**
   * @see java.util.List#remove(java.lang.Object)
   */
  @Override
  public boolean remove(Object o) {
    return getDtoList().remove(o);
  }

  /**
   * @see java.util.List#remove(int)
   */
  @Override
  public E remove(int index) {
    return getDtoList().remove(index);
  }

  /**
   * @see java.util.List#removeAll(java.util.Collection)
   */
  @Override
  public boolean removeAll(Collection<?> c) {
    return getDtoList().removeAll(c);
  }

  /**
   * @see java.util.List#retainAll(java.util.Collection)
   */
  @Override
  public boolean retainAll(Collection<?> c) {
    return getDtoList().retainAll(c);
  }

  /**
   * @see java.util.List#set(int, java.lang.Object)
   */
  @Override
  public E set(int index, E element) {
    return getDtoList().set(index, element);
  }

  /**
   * @see java.util.List#size()
   */
  @Override
  public int size() {
    return getDtoList().size();
  }

  /**
   * @see java.util.List#subList(int, int)
   */
  @Override
  public List<E> subList(int fromIndex, int toIndex) {
    return getDtoList().subList(fromIndex, toIndex);
  }

  /**
   * @see java.util.List#toArray()
   */
  @Override
  public Object[] toArray() {
    return getDtoList().toArray();
  }

  /**
   * @see java.util.List#toArray(java.lang.Object[])
   */
  @Override
  public <T> T[] toArray(T[] a) {
    return getDtoList().toArray(a);
  }

  /**
   * DTOのリストを取得します。
   * 
   * @return DTOのリスト
   */
  public List<E> getDtoList() {
    return dtoList;
  }

  /**
   * DTOのリストを設定します。
   * 
   * @param dtoList DTOのリスト
   */
  public void setDtoList(List<E> dtoList) {
    this.dtoList = dtoList;
  }

  /**
   * 全件数を取得します。
   * 
   * @return 全件数
   */
  public Integer getAllCount() {
    return allCount;
  }

  /**
   * 全件数を設定します。
   * 
   * @param allCount 全件数
   */
  public void setAllCount(Integer allCount) {
    this.allCount = allCount;
  }

  /**
   * 開始位置を取得します。
   * 
   * @return 開始位置
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * 開始位置を設定します。
   * 
   * @param index 開始位置
   */
  public void setIndex(Integer index) {
    this.index = index;
  }

  /**
   * 取得件数を取得します。
   * 
   * @return 取得件数
   */
  public Integer getCount() {
    return count;
  }

  /**
   * 取得件数を設定します。
   * 
   * @param count 取得件数
   */
  public void setCount(Integer count) {
    this.count = count;
  }

  /**
   * 検索条件を取得します。
   * 
   * @return 検索条件
   */
  public QueryCondition getCondition() {
    return condition;
  }

  /**
   * 検索条件を設定します。
   * 
   * @param condition 検索条件
   */
  public void setCondition(QueryCondition condition) {
    this.condition = condition;
  }

}
