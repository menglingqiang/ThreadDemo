package main.java.com.seckill.web;

import java.util.Date;
import java.util.List;

import main.java.com.seckill.dto.Exposer;
import main.java.com.seckill.dto.SeckillExecution;
import main.java.com.seckill.dto.SeckillResult;
import main.java.com.seckill.entity.Seckill;
import main.java.com.seckill.exception.CloseException;
import main.java.com.seckill.exception.RepeatException;
import main.java.com.seckill.exception.SeckillException;
import main.java.com.seckill.secenum.SeckillEnum;
import main.java.com.seckill.service.SeckillService;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//name 和value的区别
@RequestMapping("/seckill")//默认是value
@Controller
public class SeckillController {

	@Autowired
	private SeckillService seckillService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model)
	{
		List<Seckill> list = seckillService.queryAll();
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping(value="/{seckillId}/detail",method=RequestMethod.GET)
	public String detail(@PathVariable("seckillId")Long seckillId,Model model)
	{
		if(seckillId==null)//当seckillId的类型是long的时候  ==会报错误
			return "redirect:/seckill/list";
		
		Seckill seckill = seckillService.queryById(seckillId);
		
		if(seckill==null)
			return "forward:/seckill/list";
		model.addAttribute("seckill", seckill);
		return "detail";
	}
	@RequestMapping(value="/{seckillId}/exposer",method=RequestMethod.POST
			,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<Exposer> exposer(@PathVariable("seckillId")Long seckillId)
	{
		try {
			Exposer exposer = seckillService.exposeUrl(seckillId);
			return new SeckillResult<Exposer>(true, exposer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new SeckillResult<Exposer>(false, e.getMessage());
		}
	}
	@RequestMapping(value="/{seckillId}/execute",method=RequestMethod.POST
			,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId")Long seckillId,
			@PathVariable("md5")String md5,
			@CookieValue(value="userPhone",required=false) Long userPhone)
	{
		SeckillResult<SeckillExecution> result;
		SeckillExecution seckillExecution ;
		try {
			seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
			result = new SeckillResult<SeckillExecution>(true, seckillExecution);
		} catch (RepeatException e) {
			seckillExecution = new SeckillExecution(seckillId, SeckillEnum.REPEAT);
			result = new SeckillResult<SeckillExecution>(false, seckillExecution);
		} catch (CloseException e) {
			seckillExecution = new SeckillExecution(seckillId, SeckillEnum.END);
			result = new SeckillResult<SeckillExecution>(false, seckillExecution);
			
		} catch (SeckillException e) {
			seckillExecution = new SeckillExecution(seckillId, SeckillEnum.ERROR_INNER);
			result = new SeckillResult<SeckillExecution>(false, seckillExecution);
		}
		return result;
	}
	@RequestMapping(value ="/time/now",method=RequestMethod.GET)
	@ResponseBody
	public SeckillResult<Long> getCurrentTime()
	{
		Date date = new Date();
		return new SeckillResult<Long>(true,date.getTime());
	}
}




