package edu.kh.goodWave.common.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, 
						ServletResponse response, 
						FilterChain chain)
			throws IOException, ServletException {
		
		
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		HttpServletResponse resp = (HttpServletResponse)response;
		
		// Session 얻어오기
		
		HttpSession session = req.getSession();
		
		// 세션에서 로그인한 회원 정보를 얻어옴
		// 얻어왔으나, 없을 때 -> 로그인이 되어있지 않은 상태
		
		if(session.getAttribute("loginMember") == null) {
			
			// loginError 재요청
			// resp를 이용해서 원하는 곳으로 리다이렉트
			
			resp.sendRedirect("/loginError");
			
		}else {
				// 로그인이 되어있는 경우
			
				// FIlterChain
				// - 다음 필터 또는 Dispatcher Servlet 과 연결된 객체
			
				// 다음 필터로 요청/응답 객체 전달
				//(만약 없으면 Dispatcher Servlet 전달)
			
				chain.doFilter(request, response);
				
				
		}
	}
 
	 
	 
}
