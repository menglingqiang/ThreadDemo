//存放js方法
var seckill=
{
	URL:{
		//获取当前时间
		now:function()
		{
			return 'seckill/time/now';
		},
		//暴露秒杀接口->秒杀的地址(里面含有秒杀的地址)
		exposer:function(seckillId)
		{
			return 'seckill/'+seckillId+'/exposer';
		},
		//执行秒杀函数的URL
		execute:function(seckillId,md5)
		{
			return 'seckill/'+seckillId+'/'+md5+'/execute';
		}
	},
	//执行秒杀函数，
	execute:function(seckillId,node)
	{
		//秒杀信息节点，添加秒杀按钮
		node.hide().html('<button class="btn btn-primay btn-lg" id="killBtn">开始秒杀</button>');
		//执行秒杀暴露接口，获得秒杀的开始,结束时间
		$.post(seckill.URL.exposer(seckillId),{},function(result)
		{
			if(result && result['flag'])
			{
				var exposer = result['data'];
				//秒杀暴露接口成功
				if(exposer['flag'])
				{
					var md5 = exposer['md5'];
					//获得秒杀地址
					var killUrl = seckill.URL.execute(seckillId,md5);
					console.log('killURL'+killUrl);
					//给秒杀按钮添加事件
					$['#killBtn'].one('click',function()
					{
						$(this).addClass('disabled');
						//执行秒杀
						$.post(killUrl,{},function(result)
						{
							if(result&&result['success'])
							{
								var killResult = result['data'];
								var state = result['state'];
								var stateInfo = killResult['stateInfo'];
								//将秒杀的信息写入秒杀信息展示栏节点
								node.html('<span class="label label-success">'+stateInfo+'</span>');
							}
						});
					});
					//展示节点
					node.show();
				}else
				{
					//虽然前面已经判断过，时间在秒杀时间段内，但是，又有pc本地时间可能出现误差
					var now = exposer['currentTime'];
					var start = exposer['startTime'];
					var end = exposer['endTime'];
					seckill.countDown(seckillId,now,start,end);
				}
			}
			else
			{
				console.log('result',result);
			}
		});
	},
	//倒计时函数，主要判断时间是否在秒杀时间段内，如果再的话，执行秒杀准备(添加秒杀按钮，并为秒杀按钮添加事件)
	countDown:function(seckillId,nowTime,startTime,endTime)
	{
		var seckillBox = ${'#seckill-box'};
		if(nowTime>endTime)
		{
			seckillBox.html('秒杀结束');
		}else if(nowTime<startTime)//秒杀还没有开始倒计时
		{
			var killTime = new Date(startTime+1000);
			seckillBox.countdown(killTime,function(event)
			{
				var format = event.strftime('秒杀倒计时 %D天 %H小时 %S秒');
				seckilBox.html(format);
			}).on('finish.countdown',function()//倒计时结束，秒杀开始
			{
				seckill.execute(seckillId,seckillBox);
			});
		}else//秒杀已经开始
		{
			seckill.execute(seckillId,seckillBox);
		}
	},
	//验证电话号码
	validatePhone:function(phone)
	{
		if(phone && phone.length==11 && !isNaN(phone))
			return true;
		else
			return false;
	},
	//判断cookie中是否有电话号码，没有让用户添加电话号码
	detail:{
		init:function(params)
		{
			alert("sdfdf");
			var userPhone = $.cookie('userPhone');
			var seckillId = params['seckillId'];
			var startTime = params['startTime'];
			var endTime = params['endTime'];
			//cookie中没有userPhone
			if(!seckill.validatePhone(userPhone))
			{
				//用户电话号码弹出层
				var killModal = ${'#userPhoneModal'};
				killModal.modal(
				{
					show : true,
					backdrop : 'static',//点击屏幕其他区域不消失
					keyboard : false//键盘点击事件也不消失
				});
				
				$('#userPhoneBtn').click(function()
				{
					var inputPhone = $('#userPhoneKey').val();
					if(seckill.validatePhone(inputPhone))
					{
						$.cookie("userPhone",inputPhone,{expires:7,path:'/seckill'});
						window.location.reload();
					}
					else
					{
						$('#userPhoneMessage').hide().html('<label class="label label-danger">手机号错误！</label>').show(300);
					}
				});
			}
			var seckillId = params['seckillId'];
			var startTime = params['startTime'];
			var endTime = params['endTime'];
			//添加完电话号码，获取当期的时间，执行倒计时函数
			$.get(seckill.URL.now,{},function(result)
			{
				if(result&&result['success'])
				{
					var nowTime = result['data'];
					seckill.countDown(seckllId,nowTime,startTime,endTime);
					
				}else
				{
					console.log('result'+result);
				}
			});
		}
	}
}









