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

<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>
<script type="text/javascript" src="static/js/myjs/commonUrl.js"></script>
	
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
							<table id="dynamic-table" class="table table-striped table-bordered table-hover">
								<thead>
										
									<tr>
										<th class="center" style="width: 50px;">序号</th>
										<th class='center'>姓名</th>
										<th class='center'>电话</th>
										<c:if test="${ type=='toIntegralMoney' }">
										<th class='center'>学校名称</th>
										<th class='center'>就读专业</th>
										</c:if>
										<th class='center'>状态</th>
										<th class='center'>注册时间</th>
										<th class='center'>操作</th>
									</tr>
									
								</thead>
								<tbody style="line:30px">
								<c:choose>
									<c:when test="${not empty sList}">
									
									<c:forEach items="${sList}" var="t" varStatus="vs">
									<tr>
									<c:if test="${ type=='toIntegralMoney'}">
									<c:if test="${t.state=='3'}">
										<td class='center' >${vs.index+1 }</td>
										<td class='center'>${t.name}</td>
										<td class='center'>${t.phone }</td>
										<td class='center'>${t.school_name }</td>
										<td class='center'>${t.mojar }</td>
										<td class="center">已就读</td>
										<td class='center'>${t.created}</td>
										<td class='center'>   删除   </td>
										</c:if>
										</c:if>
										<c:if test="${ type!='toIntegralMoney'}">
										<td class='center' >${vs.index+1 }</td>
										<td class='center'>${t.name}</td>
										<td class='center'>${t.phone }</td>
										
										<c:if test="${t.state=='0'}"><td class="center">未报名</td></c:if>
										<c:if test="${t.state=='1'}"><td class="center">已报名</td></c:if>
										<c:if test="${t.state=='2'}"><td class="center">已退学</td></c:if>
										<c:if test="${t.state=='3'}"><td class="center">已就读</td></c:if>
										<td class='center'>${t.created}</td>
										<td class='center'>   删除   </td>
										</c:if>
									</tr>
									
									</c:forEach>
									
									<c:if test="${ type=='toIntegralMoney'}">
									<tr>
									<td colspan="8" >
								<button type="button" class="btn btn-lg btn-primary" disabled="disabled" style="width: 100%;">
							         <span style="color:red;">提成总和：${TeacherCommissMoney}</span> </button> 
									
									</td>
									</tr>
									</c:if>
									</c:when>
									<c:when test="${not empty sList2}">
									<c:if test="${ type=='toIntegralMoney'}">
									<c:forEach items="${sList2}" var="t2" varStatus="vs2">
									<tr>
									<c:if test="${t2.state=='3'}">
										<td class='center' >${vs2.index+1 }</td>
										<td class='center'>${t2.name}</td>
										<td class='center'>${t2.phone }</td>
										<td class='center'>${t2.school_name }</td>
										<td class='center'>${t2.mojar }</td>
										<td class="center">已就读</td>
										<td class='center'>${t2.created}</td>
										<td class='center'>   删除   </td>
										</c:if>
										
										
									</tr>
									
									</c:forEach>
									</c:if>
									</c:when>
										<c:otherwise>
											<tr>
											<td colspan="100" class='center'>没有相关数据</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
							
							
						</div>
						<!-- /.col -->
					</div>
					
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->

		<!-- 返回顶部 -->
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../index/foot.jsp"%>
	<!-- 删除时确认窗口 -->
	<script src="static/ace/js/bootbox.js"></script>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	
	<!-- 删除时确认窗口 -->
	<script src="static/vue.js"></script>
	<script src="static/vue-resource.js"></script>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
	$(top.hangge());
		
	</script>


</body>
</html>