package com.melip.webservices.common;

import java.io.IOException;
import java.util.StringJoiner;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * アクセスログのフィルタークラスです。<br>
 * リクエスト・レスポンス時に以下の情報をログに出力します。<br>
 * <ul>
 * <li>開始/終了区分</li>
 * <li>IPアドレス</li>
 * <li>HTTPメソッド名</li>
 * <li>リクエストパス</li>
 * <li>クエリ文字列（存在する場合）</li>
 * </ul>
 * <br>
 * 本Filterに設定可能な項目は以下の通りです。<br>
 * <ul>
 * <li>開始ログ出力要否</li>
 * <ul>
 * <li>パラメータ名：outputStartLog</li>
 * <li>パラメータ値：「true」の場合は出力し（デフォルト）、「false」の場合は出力しません。</li>
 * </ul>
 * <li>終了ログ出力要否</li>
 * <ul>
 * <li>パラメータ名：outputEndLog</li>
 * <li>パラメータ値：「true」の場合は出力し（デフォルト）、「false」の場合は出力しません。</li>
 * </ul>
 * </ul>
 */
public class AccessLogFilter implements Filter {

  /** パラメータ名：開始ログ出力要否 */
  private static final String PARAM_OUTPUT_START_LOG = "outputStartLog";
  /** パラメータ名：終了ログ出力要否 */
  private static final String PARAM_OUTPUT_END_LOG = "outputEndLog";

  /** セパレータ */
  private static final String SEPARATOR = ",";
  /** 開始ログを表す文字列 */
  private static final String STR_START = "I";
  /** 終了ログを表す文字列 */
  private static final String STR_END = "O";
  /** 値が取得できない場合の代替文字列 */
  private static final String STR_NOTHING = "-";

  /** 開始ログ出力要否 */
  private boolean outputStartLog = true;
  /** 開始ログ出力要否 */
  private boolean outputEndLog = true;

  private static final Logger log = LoggerFactory.getLogger(AccessLogFilter.class);

  /**
   * フィルタ処理を実行します。
   *
   * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
   *      javax.servlet.FilterChain)
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {

    if (isOutputStartLog()) {
      // 開始ログ出力
      outputStartLog(request);
    }
    try {
      filterChain.doFilter(request, response);
    } finally {
      if (isOutputEndLog()) {
        // 終了ログ出力
        outputEndLog(request);
      }
    }
  }

  /**
   * 開始ログを出力します。
   *
   * @param request Requestインスタンス
   */
  protected void outputStartLog(ServletRequest request) {

    if (log.isInfoEnabled()) {
      outputAccessLog(request, Boolean.TRUE);
    }
  }

  /**
   * 終了ログを出力します。
   *
   * @param request Requestインスタンス
   */
  protected void outputEndLog(ServletRequest request) {

    if (log.isInfoEnabled()) {
      outputAccessLog(request, Boolean.FALSE);
    }
  }

  /**
   * アクセスログを出力します。
   * 
   * @param request Requestインスタンス
   * @param isStartLog 開始ログの場合true、終了ログの場合false
   */
  private void outputAccessLog(ServletRequest request, boolean isStartLog) {

    StringJoiner sj = new StringJoiner(SEPARATOR);
    sj.add(isStartLog ? STR_START : STR_END).add(request.getRemoteAddr());
    try {
      HttpServletRequest httpRequest = (HttpServletRequest) request;
      sj.add(httpRequest.getMethod()).add(httpRequest.getRequestURI());
      String query = httpRequest.getQueryString();
      sj.add(StringUtils.isEmpty(query) ? STR_NOTHING : query);
    } catch (ClassCastException e) {
      sj.add(STR_NOTHING).add(STR_NOTHING).add(STR_NOTHING);
    }
    log.info(sj.toString());
  }

  /**
   * フィルターを初期化します。<br>
   *
   * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
   */
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

    // 開始ログの出力設定
    String outputStartLog = filterConfig.getInitParameter(PARAM_OUTPUT_START_LOG);
    if (StringUtils.isNotEmpty(outputStartLog)) {
      setOutputStartLog(Boolean.valueOf(outputStartLog).booleanValue());
    }

    // 終了ログの出力設定
    String outputEndLog = filterConfig.getInitParameter(PARAM_OUTPUT_END_LOG);
    if (StringUtils.isNotEmpty(outputEndLog)) {
      setOutputEndLog(Boolean.valueOf(outputEndLog).booleanValue());
    }
  }

  /**
   * @see javax.servlet.Filter#destroy()
   */
  @Override
  public void destroy() {}

  /**
   * 開始ログ出力要否を取得します。
   *
   * @return 開始ログを出力する場合true、しない場合false
   */
  public boolean isOutputStartLog() {
    return outputStartLog;
  }

  /**
   * 開始ログ出力要否を設定します。
   *
   * @param isOutput 開始ログを出力する場合true、しない場合false
   */
  public void setOutputStartLog(boolean isOutput) {
    this.outputStartLog = isOutput;
  }

  /**
   * 終了ログ出力要否を取得します。
   *
   * @return 終了ログを出力する場合true、しない場合false
   */
  public boolean isOutputEndLog() {
    return outputEndLog;
  }

  /**
   * 終了ログ出力要否を設定します。
   *
   * @param isOutput 終了ログを出力する場合true、しない場合false
   */
  public void setOutputEndLog(boolean isOutput) {
    this.outputEndLog = isOutput;
  }

}
