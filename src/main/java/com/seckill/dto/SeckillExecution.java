package main.java.com.seckill.dto;

import main.java.com.seckill.entity.SuccessKilled;
import main.java.com.seckill.secenum.SeckillEnum;

//秒杀执行类，主要是秒杀的商品ID，秒杀状态，秒杀成功对应的的返回实体类
public class SeckillExecution {

	
	private long seckillId;
	private int state;//0失败，1成功
	private String stateInfo;
	private SuccessKilled successKilled;
	
	//秒杀成功构造器
	public SeckillExecution(long seckillId,SeckillEnum stateEnum,
			SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.state = stateEnum.getIndex();
		this.stateInfo = stateEnum.getStateInfo();
		this.successKilled = successKilled;
	}
	//秒杀失败构造类
	public SeckillExecution(long seckillId, SeckillEnum stateEnum) {
		this.seckillId = seckillId;
		this.state = stateEnum.getIndex();
		this.stateInfo = stateEnum.getStateInfo();
	}


	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}
	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}
	
	@Override
	public String toString() {
		return "SeckillExecution [seckillId=" + seckillId + ", state=" + state
				+ ", stateInfo=" + stateInfo + ", successKilled="
				+ successKilled + "]";
	}
}
