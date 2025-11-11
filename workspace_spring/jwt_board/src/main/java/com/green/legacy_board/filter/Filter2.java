package com.green.legacy_board.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class Filter2 implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    System.out.println("Filter2 검문소 실행~");

    filterChain.doFilter(servletRequest, servletResponse);
  }
}
