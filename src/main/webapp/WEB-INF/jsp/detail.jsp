
<!DOCTYPE html>
<%@ include file="common/tag.jsp" %>
<html>
   <head>
      <title>秒杀详情页</title>
   	  <%@ include file="common/head.jsp" %> <!-- 静态包含 -->
   	  <!-- 静态包含和动态包含的区别   静态->一个servlet  动态->多个servlet -->
   </head>
   <body>
		 
		<div class="container">
			<div class="panel-default">
				<div class="panel-head text-center">
					<h2>${seckill.seckillId} </h2>
					<h2>${seckill.name} </h2>
					<div class="panel-body">
					
					</div>
				</div>	
			</div>
		</div>
   </body>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	 
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
