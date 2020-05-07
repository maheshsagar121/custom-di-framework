package com.custom.di.framework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.custom.di.framework.constant.CustomBeanScope;
import com.custom.di.framework.context.CustomDiApplicationContext;
import com.custom.di.framework.context.Impl.CustomDiApplicationContextImpl;
import com.custom.di.framework.exception.CustomDiFrameworkException;
import com.custom.di.framework.model.ClassA;

@SpringBootTest
class CustomDiFrameworkApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testSingletonScope() throws CustomDiFrameworkException {

		// STEP 1: Init Custom Application Context
		CustomDiApplicationContext applicationContext = new CustomDiApplicationContextImpl();

		// STEP 2: Register Beans to the context (Optional)
		applicationContext.registerBean(ClassA.class);
		
		// STEP 3: Get bean from the context

		ClassA classASingletonOne = (ClassA) applicationContext.getBean(ClassA.class, CustomBeanScope.SINGLETON);
		classASingletonOne.getClassB().setField("testB");
		classASingletonOne.getClassC().setField("testC");

		ClassA classATwo = (ClassA) applicationContext.getBean(ClassA.class, CustomBeanScope.SINGLETON);

		assertEquals("testB", classATwo.getClassB().getField());
		assertEquals("testC", classATwo.getClassC().getField());

		ClassA classAPrototype = (ClassA) applicationContext.getBean(ClassA.class, CustomBeanScope.PROTOTYPE);

		// Test Singleton Scope
		assertNull(classAPrototype.getClassB().getField());
		assertNull(classAPrototype.getClassC().getField());
	}

	@Test
	void testPrototypeScope() throws CustomDiFrameworkException {

		// STEP 1: Init Custom Application Context
		CustomDiApplicationContext applicationContext = new CustomDiApplicationContextImpl();

		// STEP 2: Register Beans to the context (Optional)
		applicationContext.registerBean(ClassA.class);

		// STEP 3: Get bean from the context
		ClassA classASingletonOne = (ClassA) applicationContext.getBean(ClassA.class, CustomBeanScope.SINGLETON);
		classASingletonOne.getClassB().setField("testB");
		classASingletonOne.getClassC().setField("testC");

		ClassA classAPrototype = (ClassA) applicationContext.getBean(ClassA.class, CustomBeanScope.PROTOTYPE);

		// Test Prototype Scope
		assertNull(classAPrototype.getClassB().getField());
		assertNull(classAPrototype.getClassC().getField());
	}

}
