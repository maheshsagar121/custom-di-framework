/**
 * 
 */
package com.custom.di.framework.context.Impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.util.CollectionUtils;

import com.custom.di.framework.annotation.CustomDiInject;
import com.custom.di.framework.constant.CustomBeanScope;
import com.custom.di.framework.constant.ErrorConstants;
import com.custom.di.framework.context.CustomDiApplicationContext;
import com.custom.di.framework.exception.CustomDiFrameworkException;
import com.custom.di.framework.model.BeanContext;
import com.custom.di.framework.model.BeanHolder;

/**
 * @author mahesh
 *
 */
public class CustomDiApplicationContextImpl implements CustomDiApplicationContext {

	// key = class type , value = beanContext
	private static final Map<String, BeanContext> contextMap = new ConcurrentHashMap<String, BeanContext>();

	/**
	 *
	 */
	@Override
	public BeanContext registerBean(Class<?> genericClassType) throws CustomDiFrameworkException {

		if (null == genericClassType) {
			throw new CustomDiFrameworkException(ErrorConstants.INPUT_PARAMETER_IS_NULL);
		}

		BeanContext beanContext = new BeanContext();
		beanContext.setClassToInject(genericClassType);
		return contextMap.put(genericClassType.getName(), beanContext);

	}

	/**
	 *
	 */
	@Override
	public Object getBean(Class<?> genericClassType, CustomBeanScope customBeanScope)
			throws CustomDiFrameworkException {

		if (null == genericClassType) {
			throw new CustomDiFrameworkException(ErrorConstants.INPUT_PARAMETER_IS_NULL);
		}

		if (!isBeanRegistered(genericClassType)) {
			registerBean(genericClassType);
			System.out.println("not reg ----------");
		}

		BeanContext beanContext = getBeanContext(genericClassType);

		if (CustomBeanScope.SINGLETON.equals(customBeanScope)) {
			if (null == beanContext.getSingletonBeanHolder()) {
				initBean(beanContext);
				System.out.println("1----------");
			}
			System.out.println("2----------");
			return beanContext.getSingletonBeanHolder().getBean();
		} else if (CustomBeanScope.PROTOTYPE.equals(customBeanScope)) {
			// prepare and return prototype bean.
			System.out.println("3----------");
			return initBean(beanContext);
		}
		return null;
	}

	/**
	 * @param genericClassType
	 * @return
	 */
	private BeanContext getBeanContext(Class<?> genericClassType) {
		BeanContext beanContext = CustomDiApplicationContextImpl.contextMap.get(genericClassType.getName());
		return beanContext;
	}

	/**
	 * @param beanContext
	 * @return
	 * @throws CustomDiFrameworkException
	 */
	private Object initBean(BeanContext beanContext) throws CustomDiFrameworkException {
		BeanHolder singletonBeanHolder = new BeanHolder();
		Object object = null;
		object = injectFields(beanContext.getClassToInject());
		singletonBeanHolder.setBean(object);
		singletonBeanHolder.setInitComplete(true);
		beanContext.setSingletonBeanHolder(singletonBeanHolder);
		return object;
	}

	/**
	 * @param classToInject
	 * @return
	 * @throws CustomDiFrameworkException
	 */
	private Object injectFields(Class<?> classToInject) throws CustomDiFrameworkException {
		try {
			Object o = classToInject.newInstance();
			for (Field field : classToInject.getDeclaredFields()) {
				if (field.isAnnotationPresent(CustomDiInject.class)) {
					final Class<?> dependency = field.getType();
					field.setAccessible(true);
					field.set(o, dependency.getConstructor().newInstance());
				}
			}
			return o;
		} catch (Exception e) {
			throw new CustomDiFrameworkException(ErrorConstants.BEAN_INIT_ERROR, e);
		}
	}

	/**
	 *
	 */
	@Override
	public void registerBean(List<Class<?>> genericClassTypes) throws CustomDiFrameworkException {

		if (CollectionUtils.isEmpty(genericClassTypes)) {
			throw new CustomDiFrameworkException(ErrorConstants.BEANS_LIST_EMPTY);
		}

		for (Class<?> genericClassType : genericClassTypes) {
			registerBean(genericClassType);
		}

	}

	/**
	 * @param genericClassType
	 * @return
	 * @throws CustomDiFrameworkException
	 */
	private boolean isBeanRegistered(Class<?> genericClassType) throws CustomDiFrameworkException {

		if (null == contextMap.get(genericClassType.getName())) {
			return false;
		} else {
			return true;
		}

	}
}
