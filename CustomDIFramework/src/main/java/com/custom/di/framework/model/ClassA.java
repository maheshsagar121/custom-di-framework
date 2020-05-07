/**
 * 
 */
package com.custom.di.framework.model;

import com.custom.di.framework.annotation.CustomDiInject;

/**
 * @author mahesh
 *
 */
public class ClassA {

	@CustomDiInject
	private ClassB classB;

	@CustomDiInject
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

	@Override
	public String toString() {
		return "ClassA [classB=" + classB + ", classC=" + classC + "]";
	}

}
