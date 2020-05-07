/**
 * 
 */
package com.custom.di.framework.model;

import java.util.Map;

/**
 * @author mahesh
 *
 */
public class BeanContext<T> {

	private Class<T> beanType;

	private BeanHolder<T> singletonBeanHolder;

	private Map<String, BeanHolder<T>> prototypeBeanHolderMap;

	public Class<T> getBeanType() {
		return beanType;
	}

	public void setBeanType(Class<T> beanType) {
		this.beanType = beanType;
	}

	public BeanHolder<T> getSingletonBeanHolder() {
		return singletonBeanHolder;
	}

	public void setSingletonBeanHolder(BeanHolder<T> singletonBeanHolder) {
		this.singletonBeanHolder = singletonBeanHolder;
	}

	public Map<String, BeanHolder<T>> getPrototypeBeanHolderMap() {
		return prototypeBeanHolderMap;
	}

	public void setPrototypeBeanHolderMap(Map<String, BeanHolder<T>> prototypeBeanHolderMap) {
		this.prototypeBeanHolderMap = prototypeBeanHolderMap;
	}

}
