package main.java.com.seckill.exception;

//秒杀异常
public class SeckillException extends RuntimeException{

	
	public SeckillException(String arg0, Throwable arg1
			) {
		super(arg0, arg1);
	}

	public SeckillException(String arg0) {
		super(arg0);
	}

	
}
