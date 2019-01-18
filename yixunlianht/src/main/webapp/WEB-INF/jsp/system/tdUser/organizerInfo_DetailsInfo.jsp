<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>
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
						<form action="#" name="form1" id="form1"  method="post">
					
							<div id="zhongxin" style="padding-top:13px;">
							<table id="table_report" class="table table-striped table-bordered table-hover">
										
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">头像:</td>
											<td><img alt="" src="http://ht.yxl58.com:8080${tdUserOrganizerInfo.headUrl }" width="60px;" height="60px;"></td>
										</tr>
										 <tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">主办方名称:</td>
											<td>${tdUserOrganizerInfo.name }</td>
										</tr> 
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">联系方式:</td>
											<td>${tdUserOrganizerInfo.phone }</td>
										</tr> 
										 <tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">绑定会员号:</td>
											<td>${tdUser.memberid }</td>
										</tr> 
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">会员姓名</td>
											<td>${tdUser.uNickname }</td>
										</tr> 
										 <tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">会员手机:</td>
											<td>${tdUser.uPhone }</td>
										</tr> 
										
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">会员等级:</td>
											<td>
											<c:if test="${tdUser.utypeId==1 }">普通用户</c:if>
											<c:if test="${tdUser.utypeId==2 }">普通客户经理</c:if>
											<c:if test="${tdUser.utypeId==3 }">VIP客户经理</c:if>
											<c:if test="${tdUser.utypeId==4 }">VIP体验客户经理</c:if>
											<c:if test="${tdUser.utypeId==5 }">VIP试用客户经理</c:if>
											<c:if test="${tdUser.utypeId==6 }">钻石客户经理</c:if>
											</td>
										</tr>
										<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">信用等级:</td>
											<td><%-- ${tdUser.creditrdNum } --%>
											
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
											
											</td>
										</tr>
									<tr>
											<td style="width:200px;text-align: center;font-weight:bold;padding-top: 13px;">主办方简介:</td>
											<td>${tdUserOrganizerInfo.detailInfo }</td>
										</tr>
									
							</table>
							
							</div>
						</form>
					
					<div id="zhongxin2" class="center" style="display:none"><img src="static/images/jzx.gif" style="width: 50px;" /><br/><h4 class="lighter block green"></h4></div>
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


	<!-- 页面底部js¨ -->
	<%@ include file="../index/foot.jsp"%>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script type="text/javascript">
	top.hangge();

	
	
	</script>
</body>
</html>

