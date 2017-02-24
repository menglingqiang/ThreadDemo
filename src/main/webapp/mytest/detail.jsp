<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ include file="common/tag.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
   <head>
      <title>秒杀详情页</title>
   	  <%@ include file="common/head.jsp" %> <!-- 静态包含 -->
   	  <!-- 静态包含和动态包含的区别   静态->一个servlet  动态->多个servlet -->
   </head>
   <body>
		<div class="container">
			<div class="panel-default text-center">
				<div class="pannel-heading">
					<h1>${seckill.name}</h1>
				</div>
				<div class="pannel-body">
					<h2 class="text-danger">
						<!-- 展示时间的图标 -->
						<span class="glyphicon glyphicon-time"></span>
						<!-- 展示倒计时 -->
						<span class="glyphicon" id="seckill-box"></span>
						<!-- 秒杀时间没有到，展示倒计时，秒杀时间到了添加秒杀按钮，秒杀时间超了，请等待下次秒杀 -->
					</h2>
				</div>				
			</div>
		</div>
		
		<!-- 登录弹出层，输入电话 -->
		<div id="userPhoneModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title text-center">
							<span class="glyphicon glyphicon-phone">
							</span>
						</h3>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-8 col-xs-offset-2">
								<input type="text" name="userPhone" id="userPhoneKey"
								placeholder="请填写手机号" class="form-control">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<!--  验证信息-->
						<span id="userPhoneMessage" class="glyphicon"></span>
						<button type="button" id="userPhoneBtn" class="btn btn-sucess">
							<span class="glyphicon glyphicon-phone">
							</span>
							Submit
						</button>
					</div>
				</div>
			</div>
		</div>
   </body>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	 
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- jquery cookie 操作插件 -->
	<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
	<!-- jquery 倒计时插件 -->
	<script src="http://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js"></script>
	<script src="<%= basePath %>resources/script/seckill.js" type="text/javascript"></script>
	<!-- 改个名字就可以，缓存？ -->
	<script type="text/javascript">
		$(function()
		{
			seckill.detail.init({
				seckillId : ${seckill.seckillId},
				startTime : ${seckill.startTime.time},
				endTime　: ${seckill.endTime.time}
			});
		});
	</script>
</html>
<!-- cdn? -->
<!--  www.bootcdn.cn-->
<!-- script 标签一定要写全了 不然那不会加载如  <script/>不对  <script></script>正确 -->


