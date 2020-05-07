/**
 * 
 */
package com.custom.di.framework.context;

import java.util.HashMap;
import java.util.Map;

import com.custom.di.framework.constant.CustomBeanScope;
import com.custom.di.framework.model.BeanContext;

/**
 * @author mahesh
 *
 */
public interface CustomDiApplicationContext {
	
	public static final Map<String,BeanContext> contextMap = new HashMap<String,BeanContext>();
	
	public abstract <T> void registerBean(String beanId, Class<T> genericClassType, CustomBeanScope customBeanScope);
	
	public abstract<T> void getBean(String beanId, Class<T> genericClassType);

}
