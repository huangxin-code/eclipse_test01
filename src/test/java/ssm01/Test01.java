package ssm01;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.config.AopConfig;
import com.atguigu.config.MyConfig01;
import com.atguigu.pojo.Cat;
import com.atguigu.pojo.User;

public class Test01 {
	
	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
		print(applicationContext);
		System.out.println("####################################SSS");
		Cat bean = applicationContext.getBean(Cat.class);
		bean.call(1, 1);
	}
	
	@Test
	public void test02() {
		//创建IOC容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		//这是需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("dev");
		//注册主配置类
		applicationContext.register(MyConfig01.class);
		//启动刷新容器
		applicationContext.refresh();
		print(applicationContext);
		User bean = applicationContext.getBean(User.class);
	}
	
	public void print(AnnotationConfigApplicationContext applicationContext) {
		System.out.println("================================");
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

}
