package test.java;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import main.java.com.seckill.dao.SuccessKilledDao;
import main.java.com.seckill.entity.Seckill;
import main.java.com.seckill.entity.SuccessKilled;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//配置spring和junit的整合
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit的配置文件
@ContextConfiguration({"classpath:main/resources/spring/spring-dao.xml"})

//三个方法测试成功
public class SuccessSeckilledDaoTest {

	//注入到实现类依赖
	@Resource
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsertSuccessKilled()
	{
		int i = successKilledDao.insertSuccessKilled(1001,Long.parseLong("13429888888"));
		System.out.println("----"+i);
	}

    @Test
    public void testQueryByIdWithSeckill()
    {
    	SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(1001, Long.parseLong("13429888888"));
    	
    	System.out.println("++++"+successKilled.toString());
    	System.out.println("===="+successKilled.getSeckill());
    }
	
}
