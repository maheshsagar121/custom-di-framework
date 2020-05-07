/**
 * 
 */
package com.custom.di.framework.model;

/**
 * @author mahesh
 *
 */
public class BeanHolder {
	private boolean isInitComplete = false;
	private Object bean = null;

	public boolean isInitComplete() {
		return isInitComplete;
	}

	public void setInitComplete(boolean isInitComplete) {
		this.isInitComplete = isInitComplete;
	}

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

}
