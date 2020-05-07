/**
 * 
 */
package com.custom.di.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.custom.di.framework.constant.CustomBeanScope;

/**
 * @author mahesh
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CustomDiInject {
	public CustomBeanScope scope() default CustomBeanScope.SINGLETON;
}
