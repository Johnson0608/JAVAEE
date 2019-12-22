package javaweb.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyListener implements ServletContextAttributeListener,ServletRequestAttributeListener, HttpSessionAttributeListener
 {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("向request中添加属性：" + evt.getName() + "=" + evt.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("从request中移除属性：" + evt.getName() + "=" + evt.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("修改request中的属性：" + evt.getName() + "=" + evt.getValue());
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("向context中添加属性：" + evt.getName() + "=" + evt.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("从context中移除属性：" + evt.getName() + "=" + evt.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("修改context中的属性：" + evt.getName() + "=" + evt.getValue());
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("向session中添加属性：" + evt.getName() + "=" + evt.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("从session中移除属性：" + evt.getName() + "=" + evt.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("修改session中的属性：" + evt.getName() + "=" + evt.getValue());
	}

}
