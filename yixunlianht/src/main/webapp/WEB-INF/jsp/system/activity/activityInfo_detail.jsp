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
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动名称:</td>
											<td><span>${tdActivity.activityName }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动类别:</td>
											<td><span>${tdActivity.activitycategoryName }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动开始时间:</td>
											<td><span>${tdActivity.activitystartTime }----${tdActivity.activityendTime }</span></td>
										</tr>
										<%-- <tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动结束时间:</td>
											<td><span>${tdActivity.activityendTime }</span></td>
										</tr> --%>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动报名开始时间:</td>
											<td><span>${tdActivity.activitysignStarttime }----${tdActivity.activitysignEndtime }</span></td>
										</tr>
										<%-- <tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动报名结束时间:</td>
											<td><span>${tdActivity.activitysignEndtime }
											</span></td>
										</tr> --%>
										
										 
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动人数:</td>
											<td><span>${tdActivity.activityCountpersons }</span></td>
										</tr>
										<c:if test="${tdActivity.activityChargestatus ==0 }">
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动费用:</td>
											<td><span>免费
											</span></td>
										</tr>
										</c:if>
										<c:if test="${tdActivity.activityChargestatus !=0 }">
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动费用:</td>
											<td><span>收费
											<c:forEach items="${tdActivity.listTdActivityChargeItem }" var="u">
											/${u.activityChargeItemName }
											</c:forEach>
											</span>
											
											</td>
										</tr>
										</c:if>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;"><!-- 精准客户匹配区域 -->活动地址:</td>
											<td><span>
											<%--  <c:if test="${tdActivity.address1!=null&&tdActivity.address1!=''}"> 
										   ${tdActivity.address1}<br/>
										   </c:if>
										    <c:if test="${tdActivity.address2!=null&&tdActivity.address2!=''}"> 
										   ${tdActivity.address2}<br/>
										   </c:if>
										    <c:if test="${tdActivity.address3!=null&&tdActivity.address3!=''}"> 
										   ${tdActivity.address3}
										   </c:if> --%>
											${tdActivity.addressName}
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">提成比例:</td>
											<td><span>${tdActivity.royaltyRatio}
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">设置音乐:</td>
											<td><span>
											<c:if test="${tdActivity.activitymusicId ==''||tdActivity.activitymusicId==null}">
											无
											</c:if>
											<c:if test="${tdActivity.activitymusicId !=null}">
											${tdActivity.activitymusicId }
											</c:if>
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">报名选项:</td>
											<td><span>
											<c:forEach items="${tdActivity.addListTdActivitysign }" var="u">
											${u.fillInItemName }/
											</c:forEach>
											</span></td>
										</tr>
										<!-- <tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">收费项目:</td>
											<td><span>aa
											</span></td>
										</tr> -->
										<%-- <tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">付费方式:</td>
											<c:if test="${tdActivity.activityChargemethod==0 }">
											<td><span>平台代收
											</span></td>
											</c:if>
											<c:if test="${tdActivity.activityChargemethod!=0 }">
											<td><span>直接付款
											</span></td>
											</c:if>
										</c:if>
										</tr> --%>
										<%-- <tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动类型:</td>
											<c:if test="${tdActivity.activityType==0 }">
											<td><span>线下
											</span></td>
											</c:if>
											<c:if test="${tdActivity.activityType!=0 }">
											<td><span>线上
											</span></td>
											</c:if>
										</tr> --%>
										
										<%-- <tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">详细地址:</td>
											<td><span>${tdActivity.addressName}
											</span></td>
										</tr> --%>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动封面图:</td>
											<td><span>
											<img alt="" src="${tdActivity.activityCoverimgurl }" width="200px;" height="200px;">
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">分享摘要:</td>
											<td><span>${tdActivity.shareAbstract }
											</span></td>
										</tr>
										<%-- <c:if test="${tdActivity.activityIsextract ==0 }">
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">是否设置分享提成:</td>
											<td><span>否
											</span></td>
										</tr>
										</c:if>
										<c:if test="${tdActivity.activityIsextract!=0 }">
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">是否设置分享提成:</td>
											<td><span>是
											</span></td>
										</tr> --%>
										<!-- <tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">提成项目:</td>
											<td><span>
											</span></td>
										</tr> -->
										
										
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">活动内容:</td>
											<td><span>${tdActivity.activityDetailsurl }
											</span></td>
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