package com.custom.di.framework;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.custom.di.framework.context.CustomDiApplicationContext;
import com.custom.di.framework.context.Impl.CustomDiApplicationContextImpl;
import com.custom.di.framework.model.BeanContext;
import com.custom.di.framework.model.BeanHolder;
import com.custom.di.framework.model.ClassA;

@SpringBootTest
class CustomDiFrameworkApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testCustomDiFramework() {
		CustomDiApplicationContext applicationContext = new CustomDiApplicationContextImpl();

		BeanContext<ClassA> beanContext = new BeanContext<ClassA>();
		Class<ClassA> beanType = ClassA.class;
		beanContext.setBeanType(beanType);

		BeanHolder<ClassA> singletonBeanHolder = new BeanHolder<ClassA>();
		singletonBeanHolder.setBean(new ClassA());
		singletonBeanHolder.setInitComplete(true);
		beanContext.setSingletonBeanHolder(singletonBeanHolder);

		applicationContext.contextMap.put("test", beanContext);
	}

}
