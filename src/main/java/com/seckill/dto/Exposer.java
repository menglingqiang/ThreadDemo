package main.java.com.seckill.dto;

import java.util.Date;

public class Exposer {

	
	private long seckillId;
	private boolean flag; //是否秒杀成功
	private String md5;//秒杀的地址
	private Date currentTime;
	private Date startTime;
	private Date endTime;
	
	public Exposer(long seckillId, String md5, Date currentTime,
			Date startTime, Date endTime) {
		
		this.seckillId = seckillId;
		this.md5 = md5;
		this.currentTime = currentTime;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/*
	 * 查无此秒杀记录
	 */
	public Exposer(long seckillId, boolean flag) {
		this.seckillId = seckillId;
		this.flag = flag;
	}
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	/*
	 * 秒杀成功
	 */
	public Exposer(long seckillId, boolean flag, String md5, Date currentTime,
			Date startTime, Date endTime) {
		this.seckillId = seckillId;
		this.flag = flag;
		this.md5 = md5;
		this.currentTime = currentTime;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/*
	 * 秒杀的时间不对
	 */
	public Exposer(long seckillId, boolean flag,Date currentTime, Date startTime,
			Date endTime) {
		this.flag = flag;
		this.seckillId = seckillId;
		this.currentTime = currentTime;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public Date getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	@Override
	public String toString() {
		return "Exposer [seckillId=" + seckillId + ", flag=" + flag + ", md5="
				+ md5 + ", currentTime=" + currentTime + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}
	
}
