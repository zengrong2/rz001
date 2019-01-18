﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
										<th class='center'>专业名称</th>
										<th class='center'>更新时间</th>
										<th class='center' style="width: 120px;">操作</th>
									</tr>
								</thead>
								<tbody style="line:30px">
								<c:choose>
									<c:when test="${not empty serList}">
									<c:forEach items="${serList}" var="ser" varStatus="vs">
									<tr>
										<td class='center' >${vs.index+1 }</td>
										<td class='center'>
											<a href="javascript:goSonmenu('${ser.type_id }')">${ser.type_name }</a>
											<c:if test="${ser.pid == 0 }">
											<span class="label label-success arrowed">系统</span>
											</c:if>
										</td>
										<td class='center'>${ser.update_time }</td>
										<td class='center'>
											<div class="hidden-sm hidden-xs action-buttons">
												<a class="green" href="javascript:editmenu('${ser.type_id }');">
													<i class="ace-icon fa fa-pencil-square-o bigger-130" title="修改"></i>
												</a>
												<c:if test="${QX.del == 1 }">
												<a class="red" href="javascript:delmenu('${ser.type_id }');">
													<i class="ace-icon fa fa-trash-o bigger-130" title="删除"></i>
												</a>
												</c:if>
											</div>
											<div class="hidden-md hidden-lg">
												<div class="inline pos-rel">
													<button
														class="btn btn-minier btn-yellow dropdown-toggle"
														data-toggle="dropdown" data-position="auto">
														<i
															class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
													</button>
													<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
														<c:if test="${QX.edit == 1 }">
														<li><a href="javascript:editTb('${ser.type_id }');" class="tooltip-info" data-rel="tooltip" title="View">
															<span class="blue">
																<i class="ace-icon glyphicon glyphicon-picture bigger-120" title="编辑图标"></i>
															</span>
														</a></li>
														<li><a href="javascript:editmenu('${ser.type_id }');" class="tooltip-success" data-rel="tooltip" title="Edit">
															<span class="green">
																<i class="ace-icon fa fa-pencil-square-o bigger-120" title="修改"></i>
															</span>
														</a></li>
														</c:if>
														<c:if test="${QX.del == 1 }">
														<li><a href="javascript:delmenu('${ser.type_id }');" class="tooltip-error" data-rel="tooltip" title="Delete">
															<span class="red"> <i class="ace-icon fa fa-trash-o bigger-120"  title="删除"></i>
															</span>
														</a></li>
														</c:if>
													</ul>
												</div>
											</div>
										</td>
									</tr>
									</c:forEach>
									</c:when>
										<c:otherwise>
											<tr>
											<td colspan="100" class='center'>没有相关数据</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
							
							<div>
								<c:if test="${pd.type<3 || pd.type==null}">
								<a class="btn btn-sm btn-success" onclick="addtype('${type_id}');">新增</a>
								</c:if>
								<c:if test="${null != pd.type_id && pd.type_id != '0'}">
									<a class="btn btn-sm btn-success" onclick="goSonmenu('${pd.pid}');">返回</a>
								</c:if>
							</div>
							
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
	/* 	$(document).ready(function(){
			top.hangge();
		});	
		 */
		//去此ID下子菜单列表
		$(top.hangge());
		function goSonmenu(SERVE_ID){
			
			window.location.href="<%=basePath%>major/type/list.do?type_id="+SERVE_ID;
		};
		
		//新增菜单
		function addtype(id){
		
			console.log(id)
			window.location.href="<%=basePath%>major/type/toAdd.do?type_id="+id;
		};
		
		//编辑菜单
		function editmenu(id){
			window.location.href="<%=basePath%>major/type/toEdit.do?type_id="+id;
		};
		
		//删除
		function delmenu(id){
			bootbox.confirm("确定要删除此菜单吗?", function(result) {
				if(result) {
					var url = "<%=basePath%>major/type/delete.do?type_id="+id+"&guid="+new Date().getTime();
					
					$.get(url,function(data){
						if("success" == data.result){
							window.location.reload();
							//parent.location.href="<%=basePath%>major/type/list.do?type_id="+${type_id};
						}else if("false" == data.result){
							//top.hangge();
							bootbox.dialog({
								message: "<span class='bigger-110'>删除失败,请先删除子菜单!</span>",
								buttons: 			
								{
									"button" :
									{
										"label" : "确定",
										"className" : "btn-sm btn-success"
									}
								}
							});
						}
					});
				}
			});
		}
		
		
	</script>


</body>
</html>