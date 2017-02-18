package test.java;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import main.java.com.seckill.dao.SeckillDao;
import main.java.com.seckill.entity.Seckill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//配置spring和junit的整合
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit的配置文件
@ContextConfiguration({"classpath:main/resources/spring/spring-dao.xml"})

//三个方法测试成功
public class SeckillDaoTest {

	//注入到实现类依赖
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testQueryAll() throws Exception
	{
		List<Seckill> seckills = seckillDao.queryAll(1, 3);
		for(int i=0;i<seckills.size();i++)
		{
			System.out.println(seckills.get(i).toString());
		}
	}
	
	@Test
	public void testReduceNumber() throws Exception
	{
		int i = seckillDao.reduceNumber(1000,new Date() );
		System.out.println(i);
	}
	@Test
	public void testQueryById() throws Exception
	{
		long id =1000;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill.toString());
	}
	
	
}
