/**
 * 
 */
package com.custom.di.framework.context.Impl;

import com.custom.di.framework.constant.CustomBeanScope;
import com.custom.di.framework.context.CustomDiApplicationContext;

/**
 * @author mahesh
 *
 */
public class CustomDiApplicationContextImpl implements CustomDiApplicationContext {
	

	@Override
	public <T> void registerBean(String beanId, Class<T> genericClassType, CustomBeanScope customBeanScope) {

	}

	@Override
	public <T> void getBean(String beanId, Class<T> genericClassType) {

	}

}
