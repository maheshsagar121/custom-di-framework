/**
 * 
 */
package com.custom.di.framework.model;

/**
 * @author mahesh
 *
 */
public class BeanHolder<T> {
	private boolean isInitComplete = false;
	private T bean = null;

	public boolean isInitComplete() {
		return isInitComplete;
	}

	public void setInitComplete(boolean isInitComplete) {
		this.isInitComplete = isInitComplete;
	}

	public T getBean() {
		return bean;
	}

	public void setBean(T bean) {
		this.bean = bean;
	}

}
