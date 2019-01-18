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
											<td style="width:100px;text-align: right;padding-top: 13px;">公司名称:</td>
											<td><span>${pd.company_name }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: right;padding-top: 13px;">公司规模:</td>
											<td><span>${pd.company_scale }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: right;padding-top: 13px;">公司性质:</td>
											<td><span>${pd.company_nature }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: right;padding-top: 13px;">福利待遇:</td>
											<td><span>${pd.company_welfare }
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: right;padding-top: 13px;">公司电话:</td>
											<td><span>${pd.company_phone }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: right;padding-top: 13px;">招聘状态：</td>
											<td><span><c:if test="${pd.is_recruit ==0}">
									        <a class="label label-success arrowed" >待上线招聘</a>											
											</c:if>
											<c:if test="${pd.is_recruit ==1}">
											<a class="label label-danger arrowed" >正在招聘中</a>
											</c:if>
											<c:if test="${pd.is_recruit ==2}">
											<a class="label label-error arrowed" >招聘已完成</a>
											</c:if>
											</span></td>
										</tr>
										
										<tr>
											<td style="width:100px;text-align: right;padding-top: 13px;">详细地址:</td>
											<td><span>${pd.company_adress }</span></td>
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