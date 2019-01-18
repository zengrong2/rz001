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
						<div class="col-xs-12" style="margin-top:30px;">
								<form action="#" name="userForm" id="userForm" method="post">
									<table id="table_report" class="table table-striped table-bordered table-hover" border="0px;">
									  <c:choose>
									  <c:when test="${not empty tdSysuserAndFeedbackadvice}">
									  
									   	<c:forEach items="${tdSysuserAndFeedbackadvice}" var="ts" varStatus="vs">
									    <tr>
											<td style="width:100px; text-align: center;font-weight:bold;padding-top: 13px;">系统管理员:</td>
											<td><span>${ts.sysuserId }</span></td>
										</tr>
										 <tr>
											<td style="width:100px; height:100px;line-height:100px; text-align: center;font-weight:bold;padding-top: 13px;">回复信息:</td>
											<td style="height:100px;line-height:100px; text-align: center"><span>${ts.replyContext }</span></td>
										</tr>
										</c:forEach>
										</c:when>
											<c:otherwise>
									<tr class="main_info">
										<td colspan="11" class="center">没有相关数据</td>
									</tr>
								</c:otherwise>
									
										</c:choose>
									
									
										
										
										
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