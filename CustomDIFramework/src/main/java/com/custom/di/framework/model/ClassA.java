/**
 * 
 */
package com.custom.di.framework.model;

import com.custom.di.framework.annotation.CustomDiInject;
import com.custom.di.framework.constant.CustomBeanScope;

/**
 * @author mahesh
 *
 */
public class ClassA {
	
	@CustomDiInject(scope = CustomBeanScope.SINGLETON)
	private ClassB classB;
	
	@CustomDiInject(scope = CustomBeanScope.PROTOTYPE)
	private ClassC classC;

	public ClassB getClassB() {
		return classB;
	}

	public void setClassB(ClassB classB) {
		this.classB = classB;
	}

	public ClassC getClassC() {
		return classC;
	}

	public void setClassC(ClassC classC) {
		this.classC = classC;
	}

}
