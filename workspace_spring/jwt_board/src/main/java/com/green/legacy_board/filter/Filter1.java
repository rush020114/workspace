package com.green.legacy_board.filter;


import jakarta.servlet.*;

import java.io.IOException;

public class Filter1 implements Filter {

  // 검문소에서 실행할 내용
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    System.out.println("Filter1 검문소 실행~");
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
