package main.java.com.seckill.service;
import java.util.List;

import main.java.com.seckill.dto.Exposer;
import main.java.com.seckill.dto.SeckillExecution;
import main.java.com.seckill.entity.Seckill;
import main.java.com.seckill.exception.CloseException;
import main.java.com.seckill.exception.RepeatException;
import main.java.com.seckill.exception.SeckillException;

public interface SeckillService {

	/*
	 * 查询所有的秒杀任务
	 */
	List<Seckill> queryAll();
	
	/*
	 * 查询相关的秒杀业务
	 */
	Seckill queryById(long seckillId);
	
	/*
	 * 如果时间已经到秒杀期间，那么返回秒杀的URL
	 * 如果时间没在秒杀期间，那么返回秒杀的时间和当前的时间
	 */
	Exposer exposeUrl(long seckillId);
	
	/*
	 * 秒杀结果
	 */
	SeckillExecution executeSeckill(long seckillId,long userPhone,String md5)
	throws SeckillException,RepeatException,CloseException;
	
}
