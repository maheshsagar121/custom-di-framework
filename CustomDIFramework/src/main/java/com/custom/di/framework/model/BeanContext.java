/**
 * 
 */
package com.custom.di.framework.model;

/**
 * @author mahesh
 *
 */
public class BeanContext {

	private Class<?> classToInject;

	private BeanHolder singletonBeanHolder;

	public BeanHolder getSingletonBeanHolder() {
		return singletonBeanHolder;
	}

	public void setSingletonBeanHolder(BeanHolder singletonBeanHolder) {
		this.singletonBeanHolder = singletonBeanHolder;
	}

	public Class<?> getClassToInject() {
		return classToInject;
	}

	public void setClassToInject(Class<?> classToInject) {
		this.classToInject = classToInject;
	}

}
