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
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">用户名字:</td>
											<td><span>${tdUser.uName }</span></td>
										</tr>
										 <tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">用户头像:</td>
											<td><span><img alt="" src="${tdUser.headUrl }" width="30px;" height="30px;">    </span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">用户电话:</td>
											<td><span>${tdUser.uPhone }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">用户性别:</td>
											<td><span>${tdUser.uSex }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">用户生日:</td>
											<td><span>${tdUser.ubirthday }
											</span></td>
										</tr>
										
										
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">用户类型:</td>
											<td><span>${tdUser.utypeId }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">会员天数:</td>
										
											<td><span>${tdUser.memberDays }
											</span></td>
											
											</td>
											
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">用户行业:</td>
											<td><span>${tdUser.egidId }</span></td>
										</tr>
										
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">会员号:</td>
											<td><span>${tdUser.memberid }
											</span></td>
										</tr>
									
										
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">信用值:</td>
											<td><span>${tdUser.creditrdNum }
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">推荐人:</td>
											<td><span>${tdUser.userrefereeName }
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">归属人(客户经理):</td>
											
											<td><span>${tdUser.usermanagerName }
											</span></td>
											
											</td>
										
										</tr>
										
										
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">体验VIP是否体验:</td>
											<c:if test="${tdUser.resourceStrategyIsexperience==1 } ">
											<td><span>体验中
											</span>
											</c:if>
											<c:if test="${tdUser.resourceStrategyIsexperience==2 } ">
											<td><span>已体验
											</span>
											</c:if>
											<c:if test="${tdUser.resourceStrategyIsexperience!=2&&tdUser.resourceStrategyIsexperience!=1 } ">
											<td><span>未体验
											</span>
											</c:if>
											</td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">备注:</td>
											<td><span>${tdUser.remark }
											</span></td>
										</tr>
										<%-- <tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">详细地址:</td>
											<td><span><img src="">
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动封面图:</td>
											<td><span><img src="">${tdUser.activityCoverimgurl }
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">分享摘要:</td>
											<td><span>${tdUser.shareAbstract }
											</span></td>
										</tr>
										<c:if test="${tdUser.activityIsextract ==0 }">
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">是否设置分享提成:</td>
											<td><span>否
											</span></td>
										</tr>
										</c:if>
										<c:if test="${tdUser.activityIsextract!=0 }">
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">是否设置分享提成:</td>
											<td><span>是
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">提成项目:</td>
											<td><span>
											</span></td>
										</tr>
										</c:if>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">设置音乐:</td>
											<td><span>${tdUser.activitymusicId }
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动详情:</td>
											<td><span>${tdUser.activityDetailsurl }
											</span></td>
										</tr> --%>
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