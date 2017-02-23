package main.java.com.seckill.secenum;

//秒杀枚举类
public enum SeckillEnum {

	SUCCESS(1,"秒杀成功"),
	END(0,"秒杀结束"),
	REPEAT(-1,"重复秒杀"),
	ERROR_INNER(-2,"内部错误"),
	DATE_REWRITE(-3,"数据篡改");
	private int index;
	private String stateInfo;
	SeckillEnum(int index,String stateInfo)
	{
		this.index = index;
		this.stateInfo = stateInfo;
	}
	public static SeckillEnum getState(int index)
	{
		for(SeckillEnum s:values())
		{
			if(s.getIndex()==index)
				return s;
		}
		return null;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
}
