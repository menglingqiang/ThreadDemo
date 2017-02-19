package test.java;

import static org.junit.Assert.fail;

import java.util.List;

import main.java.com.seckill.dto.Exposer;
import main.java.com.seckill.dto.SeckillExecution;
import main.java.com.seckill.entity.Seckill;
import main.java.com.seckill.entity.SuccessKilled;
import main.java.com.seckill.exception.CloseException;
import main.java.com.seckill.exception.RepeatException;
import main.java.com.seckill.exception.SeckillException;
import main.java.com.seckill.service.SeckillService;
import main.java.com.seckill.service.serviceimpl.SeckillServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//配置spring和junit的整合
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit的配置文件
@ContextConfiguration({"classpath:main/resources/spring/spring-dao.xml",
	"classpath:main/resources/spring/spring-service.xml"})
public class SeckillServiceImplTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	//这里不要忘了注入，不然spring也不知道你想干什么
	@Autowired
	public SeckillService seckillService;
	@Test
	public void testQueryAll() {
		List<Seckill> list = seckillService.queryAll();
		logger.info("list={}",list);
	}

	@Test
	public void testQueryById() {
		long id = 1002;
		Seckill seckill = seckillService.queryById(id);
		logger.info("seckill{}",seckill);
	}

	
	@Test
	public void testExposeUrl() {
		Exposer exposer = seckillService.exposeUrl(1002);
		logger.info("exposer{}",exposer.toString());
	}

	@Test
	public void testExecuteSeckill() {
//		logger.info("-------begin-----");
//		long id =1002;
//		long userPhone=13456897453L;
//		String md5="edf33f21d827ddf1695e194dfbf26046";
//		SeckillExecution seckillExecution = seckillService.executeSeckill(id, userPhone, md5);
//		logger.info("seckillExcution{}",seckillExecution.toString());
//		logger.info("---end----");
	}
	//抛出异常后数据没有回滚
	@Test
	public void testLogic()
	{
		logger.info("-------logic begin-----");
		long seckillId = 1002;
		Exposer exposer = seckillService.exposeUrl(seckillId);
		try {
			if(exposer.isFlag())
			{
				long userPhone = 13578945681L;
				String md5 = exposer.getMd5();
				SeckillExecution seckillExecution =seckillService.executeSeckill(seckillId, userPhone, md5);
				logger.info("seckillExcution{}",seckillExecution.toString());
			}
		} catch (RepeatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CloseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SeckillException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("---logic end----");
	}
	
}
