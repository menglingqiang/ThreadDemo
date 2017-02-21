
<!DOCTYPE html>
<%@ include file="common/tag.jsp" %>
<html>
   <head>
      <title>测试</title>
   	  <%@ include file="common/head.jsp" %> <!-- 静态包含 -->
   	  <!-- 静态包含和动态包含的区别   静态->一个servlet  动态->多个servlet -->
   </head>
   <body>
		 
		<div class="container">
			<div class="panel-default">
				<div class="panel-head text-center">
					<h2>秒杀列表</h2>
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>名称</th>
									<th>库存</th>
									<th>开始时间</th>
									<th>结束时间</th>
									<th>创建时间</th>
									<th>详情页</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="sk" items="${list}">
									<tr>
										<td>${sk.name}</td>
										<td>${sk.number}</td>
										<td>
											<fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
											<fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
											<fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td> 
										<td>
											<a class="btn btn-info" href="/seckillOfSpring/seckill/${sk.seckillId}/detail" target="_blank">
											link
											</a>
											<td>
											</td>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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

<!-- 默认前缀多一个seckill? 解决-->
<!-- 乱码问题 -- 数据库的解决，但是页面字符仍然是乱码-->
<!-- 日期格式化 -- 解决-->
<!-- 跳页连项目名称也要加上，最前面如果不加/会默认在后面叠加出现-->
