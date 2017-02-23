package main.java.com.seckill.dto;

//控制器返回类，控制器返回josh串的包装类
public class SeckillResult<T> {

	private T data;//返回成功数据
	private String error;// 失败信息
	private boolean flag;// 状态标识
	
	//成功返回数据
	public SeckillResult(boolean flag,T data ) {
		this.data = data;
		this.flag = flag;
	}
	//失败返回失败原因
	public SeckillResult( boolean flag,String error) {
		this.error = error;
		this.flag = flag;
	}
	
}
