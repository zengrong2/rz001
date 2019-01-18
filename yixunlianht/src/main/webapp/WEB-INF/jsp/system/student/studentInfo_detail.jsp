<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<!-- 下拉框 -->
<link rel="stylesheet" href="static/ace/css/chosen.css" />
<!-- jsp文件头和头部 -->
<%@ include file="../../system/index/top.jsp"%>
</head>
<body class="no-skin">
	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
								<form action="#" name="userForm" id="userForm" method="post">
									<table id="table_report" class="table table-striped table-bordered table-hover">
									    <tr>
											<td style="width:100px;text-align: right;padding-top: 13px;">学生注册姓名:</td>
											<td><span>${pd.name }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: right;padding-top: 13px;">注册电话:</td>
											<td><span>${pd.phone }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: right;padding-top: 13px;">学生证号:</td>
											<td><span>${pd.student_card }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: right;padding-top: 13px;">学校名称:</td>
											<td><span>${pd.school_name }
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: right;padding-top: 13px;">监护人:</td>
											<td><span>${pd.jhr_name }</span></td>
										</tr>
										
										
										<tr>
											<td style="width:100px;text-align: right;padding-top: 13px;">注册时间:</td>
											<td><span>${pd.create_time }</span></td>
										</tr>
									</table>
									</div>
								</form>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->
	</div>
	<!-- /.main-container -->
	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- inline scripts related to this page -->
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
</body>
<script type="text/javascript">
	$(top.hangge());
	$(document).ready(function(){
		if($("#user_id").val()!=""){
			$("#loginname").attr("readonly","readonly");
			$("#loginname").css("color","gray");
		}
	});

	
	
	
</script>
</html>