/**
 * 
 */
package com.custom.di.framework.context;

import java.util.List;

import com.custom.di.framework.constant.CustomBeanScope;
import com.custom.di.framework.exception.CustomDiFrameworkException;
import com.custom.di.framework.model.BeanContext;

/**
 * @author mahesh
 *
 */
public interface CustomDiApplicationContext {

	/**
	 * @param genericClassType
	 * @return
	 * @throws CustomDiFrameworkException
	 */
	public abstract BeanContext registerBean(Class<?> genericClassType) throws CustomDiFrameworkException;

	/**
	 * @param genericClassTypes
	 * @throws CustomDiFrameworkException
	 */
	public abstract void registerBean(List<Class<?>> genericClassTypes) throws CustomDiFrameworkException;

	/**
	 * @param genericClassType
	 * @param customBeanScope
	 * @return
	 * @throws CustomDiFrameworkException
	 */
	public abstract Object getBean(Class<?> genericClassType, CustomBeanScope customBeanScope)
			throws CustomDiFrameworkException;

}
