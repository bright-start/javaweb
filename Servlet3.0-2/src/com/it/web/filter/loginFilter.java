package com.it.web.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.it.dao.domain.User;
import com.it.util.JDBCUtil;

/**
 * Servlet Filter implementation class loginFilter
 */
@WebFilter("/login")
public class loginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("*******************");
		HttpServletRequest req = (HttpServletRequest) request;
		Cookie[] cookies = req.getCookies();
		String autologin = null;
		for(int i = 0; cookies != null && i < cookies.length; i++) {
			if("autologin".equals(cookies[i].getName())){
				autologin = cookies[i].getValue();
				System.out.println(autologin);
				break;
			}
		}
		System.out.println("*******************");
		if(autologin != null) {
			String[] parts = autologin.split("-");
			String userName = parts[0];
			String password = parts[1];
			QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
			String sql = "select *from user where username = ? and password = ?";
			User user = null;
			try {
				user = qr.query(sql, new BeanHandler<User>(User.class),userName,password);
				System.out.println(user);
				req.getSession().setAttribute("user", user);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
