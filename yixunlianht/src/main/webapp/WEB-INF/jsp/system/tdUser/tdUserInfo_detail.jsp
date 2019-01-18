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
						<div class="col-xs-12" style="margin-top:20px;">
								<form action="#" name="userForm" id="userForm" method="post">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										<c:if test="${tdUser.closedUserStatus ==1}">
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">冻结:</td>
											<td><span> 发布的活动信息涉嫌违法 </span></td>
										</tr>										
										</c:if>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">头像:</td>
											<td><span><img alt="头像" src="${tdUser.headUrl }" width="40px;" height="40px;">  </span></td>
										</tr>
										 <tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">信用值:</td>
											<td><span> 
												<c:if test="${tdUser.creditrdNumArray[0]>0}">
										    <c:forEach  var="arr" begin="0" end="${tdUser.creditrdNumArray[0] }">
										   <img alt="" src="http://ht.yxl58.com:8080/uploadFiles/remarkImage/remark1.png">
										    </c:forEach>
											</c:if>
											<c:if test="${tdUser.creditrdNumArray[1]>0}">
										    <c:forEach  var="arr" begin="0" end="${tdUser.creditrdNumArray[1] }">
										   <img alt="" src="http://ht.yxl58.com:8080/uploadFiles/remarkImage/remark2.png">
										    </c:forEach>
											</c:if>
											<c:if test="${tdUser.creditrdNumArray[2]>0}">
										    <c:forEach  var="arr" begin="0" end="${tdUser.creditrdNumArray[2] }">
										   <img alt="" src="http://ht.yxl58.com:8080/uploadFiles/remarkImage/remark4.png">
										    </c:forEach>
											</c:if>
											
											<c:if test="${tdUser.creditrdNumArray[3]>0}">
										    +${tdUser.creditrdNumArray[3]}
											</c:if>
											
											 </span></td>
										</tr>
									    <tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">名字:</td>
											<td><span>${tdUser.uNickname }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">生日:</td>
											<td><span>${tdUser.ubirthday }
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">联系方式:</td>
											<td><span>${tdUser.uPhone }</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">会员等级:</td>
											<td><span> ${memberType.userType } 
											</span></td>
										</tr>
											<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">资源库人数:</td>
										
											<td><span>${countResouseP }
											</span></td>
											
											</td>
										<tr>
									<%-- 	<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">性别:</td>
											<td><span>
											<c:if test="${tdUser.uSex ==1 }">男</c:if>
											<c:if test="${tdUser.uSex ==0 }">女</c:if>
											<c:if test="${tdUser.uSex ==''|| tdUser.uSex==null}">暂无</c:if>
											</span></td>
										</tr> --%>
								
									
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">兴趣爱好:</td>
										
											<td><span>
											  <c:forEach items="${listTdUserandhobby}" var="ts" varStatus="vs">
												
												<!-- <span class="badge" style="background-color: #D15B47;"> -->
												<a class="label label-info arrowed" style="margin-left:10px;margin-top:10px;" >
												${ts.hobbyName}</button></a>
											   </c:forEach>
											</span></td>
											
											</td>
										<tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">个人需求:</td>
										
											<td><span>
											<c:forEach items="${listTdUserandpersonalneeds}" var="ts" varStatus="vs">
												
												<!-- <span class="badge" style="background-color: #D15B47;"> -->
												<a class="label label-danger arrowed" style="margin-left:10px;margin-top:10px;" >
												${ts.activityType}&nbsp;&nbsp;${ts.needCount }</a>
											   </c:forEach>
											</span></td>
											
											</td>
										<tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">曾经参与:</td>
										
											<td><span>
							  <span style="font-weight: bold;margin-top:40px;">
							
							  <c:forEach items="${tdOverJoinActivityTempList}" var="activityType" varStatus="vs">							
							  <a class="label label-success arrowed" style="margin-left:10px;margin-top:10px;" >${activityType.activityCategoryName }&nbsp;&nbsp;${activityType.joinCount }</a>
							  </c:forEach>
											</span></td>
											
											</td>
										<%-- <tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">会员天数:</td>
										
											<td><span>${tdUser.memberDays }
											</span></td>
											
											</td>
											
										</tr> --%>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">从事行业:</td>
											<td><span>${tdEngagendustry.egidName }</span></td>
										</tr>
									
										<%-- <tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">推荐人:</td>
											<td><span>${tdUser.userrefereeName }
											</span></td>
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">归属人(客户经理):</td>
											
											<td><span>${tdUser.usermanagerName }
											</span></td>
											
											</td>
										
										</tr> --%>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">专业职称:</td>
											
											<td><span>${tdUser.professionalTitle }
											</span></td>
											
											</td>
										
										</tr>
											<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">我能提供:</td>
											
											<td><span>${tdUser.canProvide }
											</span></td>
											
											</td>
										
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">我需要什么:</td>
											
											<td><span>${tdUser.need }
											</span></td>
											
											</td>
										
										</tr>
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">人生信念:</td>
											
											<td><span>${tdUser.beliefInLife }
											</span></td>
											
											</td>
										
										</tr>
										
										<tr>
											<td style="width:100px;text-align: center;font-weight:bold;padding-top: 13px;">个人IP展示:</td>
											<td><span>
											
											
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