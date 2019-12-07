package com.it.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class UserCountListener
 *
 */
@WebListener
public class UserCountListener implements ServletContextListener, HttpSessionListener {

    /**
     * Default constructor. 
     */
    public UserCountListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	//获取servletcontext对象
    	ServletContext sc = se.getSession().getServletContext();
    	 //获取在线统计人数的变量
    	int count = (int) sc.getAttribute("count");
    	//存储
    	sc.setAttribute("count", ++count);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	//获取servletcontext对象
    	ServletContext sc = se.getSession().getServletContext();
    	 //获取在线统计人数的变量
    	int count = (int) sc.getAttribute("count");
    	//存储
    	sc.setAttribute("count", --count);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ServletContext sc = arg0.getServletContext();
    	sc.setAttribute("count", 0);
    }
	
}
