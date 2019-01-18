<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<%@ include file="../index/top.jsp"%>
<!-- 日期框 -->
<link rel="stylesheet" href="static/ace/css/datepicker.css" />
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
						
						<!-- 检索  -->
						<table id="simple-table" class="table table-striped table-bordered table-hover"  style="margin-top:5px;">
							<thead>
								<tr>
									<th class="center" style="width:35px;">
									<label class="pos-rel"><input type="checkbox" class="ace" id="zcheckbox" /><span class="lbl"></span></label>
									</th>
									<th class="center" style="width:60px;">编号</th>
									<th class="center">教师姓名</th>
									<th class="center">头像</th>
									<th class="center">是否名师</th>
									<th class="center">简介</th>
									<th class="center">更新时间</th>
								</tr>
							</thead>
													
							<tbody>
								
							<!-- 开始循环 -->	
							<c:choose>
								<c:when test="${not empty qList}">
									<c:forEach items="${qList}" var="st" varStatus="vs">
										<tr>
										<td class='center' style="width: 30px;">
												<label><input type='checkbox' name='ids' value="${st.teacher_id }" id="${st.teacher_id}"  class="ace"/><span class="lbl"></span></label>
											</td>
											<td class="center">${vs.index+1}</td>
											<td class="center">${st.name }</td>
											<td class="center" style="cursor:pointer;color:blue;" onClick="toPhoto('${st.head_portrait}')">查看</td>
											<td class="center"><c:if test="${st.type ==1}">是</c:if>
											<c:if test="${st.type == 0}">否</c:if>
											</td>
											<td class="center" style="cursor:pointer;color:blue;" onClick="toProfile('${st.profile}')">查看</td>
											<td class="center">${st.update_time }</td>
																		
										</tr>							
									</c:forEach>
									<c:if test="${QX.cha == 0 }">
										<tr>
											<td colspan="10" class="center">您无权查看</td>
										</tr>
									</c:if>
								</c:when>
								<c:otherwise>
									<tr class="main_info">
										<td colspan="10" class="center">没有相关数据</td>
									</tr>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table>
					
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

		<!-- 返回顶部 -->
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
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
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	</body>

<script type="text/javascript">
$(top.hangge());
$(function (){  
    $("div").tooltip();  //初始化      
});  
	 
function toProfile(profile){
	localStorage.setItem("profile",profile);
	 top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="查看";
	 diag.URL = '<%=basePath%>page/system/school/teacher_profile';
	 diag.Width = 450;
	 diag.Height = 350;
	 diag.Modal = true;				//有无遮罩窗口
	 diag. ShowMaxButton = true;	//最大化按钮
    diag.ShowMinButton = true;		//最小化按钮 
	 diag.CancelEvent = function(){ //关闭事件
   	 window.location.reload();
		diag.close();
	 };
	 diag.show();
	 }
	 
function toPhoto(photo){
	localStorage.setItem("photo",photo);
	 top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="查看";
	 diag.URL = '<%=basePath%>page/system/school/photo';
	 diag.Width =401;
	 diag.Height =401;
	 diag.Modal = true;				//有无遮罩窗口
	 diag. ShowMaxButton = true;	//最大化按钮
    diag.ShowMinButton = true;		//最小化按钮 
	 diag.CancelEvent = function(){ //关闭事件
   	 window.location.reload();
		diag.close();
	 };
	 diag.show();
	 }
</script>
</html>
