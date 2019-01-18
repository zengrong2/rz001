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
								
									<div id="zhongxin" style="padding-top: 13px;">
									
									<table id="table_report" class="table table-striped table-bordered table-hover">
									<thead>
								<tr>
									<th class="center" style="width:35px;">
									<label class="pos-rel"><input type="checkbox" class="ace" id="zcheckbox" /><span class="lbl"></span></label>
									</th>
									
									    <th class='center'>职位名称</th>									
										<th class='center'>薪资</th>
									    <th class='center'>工作内容</th>
									    <th class='center'>职位需求</th>			
										<th class='center'>更新时间</th>									   
									    <th class="center">职位状态</th>
								</tr>
							</thead>	
									<tbody>
							<!-- 开始循环 -->	
							<c:choose>
								<c:when test="${not empty listWork}">
									<c:forEach items="${listWork}" var="work" varStatus="vs">
										<tr>
										<td class='center' style="width: 30px;">
												<label><input type='checkbox' name='ids' value="${work.p_id }" id="${work.p_id }"  class="ace"/><span class="lbl"></span></label>
											</td>
											
											<td class="center">${work.p_name }</td>
											<td class="center">${work.p_salary}</td>
											<td class="center">${work.p_content }</td>
											<td class="center">${work.p_requirement}</td>
											<td class="center">${work.created}</td>
													
											<td class="center">
										<c:if test="${work.is_state==1 }">&nbsp;&nbsp;
										<a class="label label-error arrowed" onclick="changeState('${work.company_id}','${work.p_id}',0);">待上线招聘</a></c:if>
										<c:if test="${work.is_state==0 }">
										&nbsp;&nbsp;<a class="label label-danger arrowed" onclick="changeState('${work.company_id}','${work.p_id}',1);">正在招聘中</a>
											</c:if>
										</td>									
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
									</div>
									<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- main-content -->
	</div>
	<!-- main-container -->
	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../index/foot.jsp"%>
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
$(function (){  
    $("div").tooltip();  //初始化      
});  
	
	$(document).ready(function(){
		if($("#user_id").val()!=""){
			$("#loginname").attr("readonly","readonly");
			$("#loginname").css("color","gray");
		}
	});
	function changeState(company_id,cid,state){	
		bootbox.confirm("确定要进行此操作吗?", function(result) {
			    if(result){
			    	top.jzts();
		          $.ajax({
	                  type:'POST',
	                  url:'<%=basePath%>work/updatePositionState.do',
	                  data:{
	                	  company_id:company_id,
	                	  is_state:state,
	                	  p_id:cid,
	                       },
	                 success:function(data){
			         window.location.reload();
	                 },
	                 error:function(data){
	                	 bootbox.confirm("公司未开始上线招聘,请修改公司招聘状态");
	          		  
	                 }      
				})
			    }
		});
	}
</script>
</html>