package javaweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//Tomcat启动和关闭时会调用
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("销毁ServletContext对象");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("创建ServletContext对象");
	}

}
