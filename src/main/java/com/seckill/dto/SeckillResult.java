package main.java.com.seckill.dto;

//控制器返回类，控制器返回josh串的包装类
public class SeckillResult<T> {

	@Override
	public String toString() {
		return "SeckillResult [data=" + data + ", success=" + success + "]";
	}
	private T data;//返回成功数据
	private String error;// 失败信息
	private boolean success;// 状态标识
	
	//成功返回数据
	public SeckillResult(boolean success,T data ) {
		this.data = data;
		this.success = success;
	}
	//失败返回失败原因
	public SeckillResult( boolean success,String error) {
		this.error = error;
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
