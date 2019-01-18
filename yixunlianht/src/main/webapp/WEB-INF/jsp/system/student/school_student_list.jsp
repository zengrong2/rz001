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
						<!-- 检索  -->
						<form action="school/goListStudent.do" method="post" name="userForm" id="userForm">
						<table style="margin-top:5px;">
							<tr>
							   <td style="vertical-align:top;padding-left:2px;">
								 	<select class="chosen-select form-control" name="state" id="state" data-placeholder="请选择状态" style="vertical-align:top;width: 120px;" onchange="searchs();">
									<option value="" <c:if test=" ${pd.state == '' }">selected</c:if>>全部</option>
									<option value="0" <c:if test="${pd.state == '0' }">selected</c:if>>未报名</option>
									<option value="1" <c:if test="${pd.state == '1' }">selected</c:if>>已报名</option>
									<option value="3" <c:if test="${pd.state == '2' }">selected</c:if>>已退学</option>
									<option value="3" <c:if test="${pd.state == '3' }">selected</c:if>>已确认就读</option>
									</select>
								</td>
								<c:if test="${QX.toExcel == 1 }">
								<td style="vertical-align:top;padding-left:2px;">
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="tphone" type="text" name="tphone" value="${pd.tphone }" placeholder="这里输入招生老师电话" />
										<i class="ace-icon fa fa-search nav-search-icon"></i>
									</span>
									</div>
								</td>
								</c:if>
								<td style="vertical-align:top;padding-left:2px;">
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="keywords" value="${pd.keywords }" placeholder="这里输入关键字" />
										<i class="ace-icon fa fa-search nav-search-icon"></i>
									</span>
									</div>
								</td>
								
								<td style="vertical-align:top;padding-left:2px;">
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="start" type="date" name="start"  placeholder="这里输入开始时间" value="${pd.start}" />
									</span>
									</div>
								</td>
								<td>——</td>
								<td style="vertical-align:top;padding-left:2px;">
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="end" type="date" name="end"  value="${pd.end}" placeholder="这里输入结束时间" />
									</span>
									</div>
								</td>
								
								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
							<c:if test="${QX.toExcel == 1 }"><td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="toExcel();" title="导出到EXCEL"><i id="nav-search-icon" class="ace-icon fa fa-download bigger-110 nav-search-icon blue"></i></a></td></c:if>
							</tr>
						</table>
							<table id="dynamic-table" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center" style="width: 50px;">序号</th>
										<th class='center'>姓名</th>
										<th class='center'>电话</th>
										<th class='center'>学校名称</th>
										<th class='center'>状态</th>
										<c:if test="${QX.toExcel == 1 }">
										<th class="center">一级招生老师</th>
										<th class="center">二级招生老师</th>
										<th class="center">业务员</th>
										</c:if>
										<th class='center'>注册时间</th>
										<th class='center'>操作</th>
									</tr>
								</thead>
								<tbody style="line:30px">
								<c:choose>
									<c:when test="${not empty sList}">
									<c:forEach items="${sList}" var="t" varStatus="vs">
									<tr>
										<td class='center' >${vs.index+1 }</td>
										<td class='center'>${t.name}</td>
										<td class='center'>${t.phone }</td>
										<td class='center'>${t.school_name }</td>
										 <c:if test="${t.state=='0'}"><td class="center">待报名</td></c:if>
										<c:if test="${t.state=='1'||t.state=='3'}"><td class="center">已报名</td></c:if>
										<c:if test="${t.state=='2'}"><td class="center">已退学</td></c:if>
									
										<c:if test="${QX.toExcel == 1 }">
										<td class='center'>${t.tyname}</td>
										<td class='center'>${t.tename}</td>
										<td class='center'>${t.ywyname}</td>
										</c:if>
										<td class='center'>${t.created}</td>
										<td class='center'><div class="hidden-sm hidden-xs btn-group">
													
													<a class="btn btn-xs btn-danger" onclick="delStuden('${t.user_id}');">
														<i class="ace-icon fa fa-trash-o bigger-120" title="删除"></i>
													</a>
												<c:if test="${user_roleId== '4a525a16517a46a8831406bef482327e' }">
													<c:if test="${t.state!='3'}">
													<a class="btn btn-xs btn-info" onclick="comfirmStuden('${t.user_id}','${t.state}');">
													未确认就读</a>
													</c:if>
													<c:if test="${t.state=='3'}">
													<a class="btn btn-xs btn-error" >
													已确认就读</a>
													</c:if>
													</c:if>
													
												</div>	</td>
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
							 <div class="page-header position-relative">
					  <table style="width:100%;">
						<tr>
							<td style="vertical-align:top;"><div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">${page.pageStr}</div></td>
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
	//检索
	function searchs(){
		top.jzts();
		$("#userForm").submit();
	}
	
	//导出excel
	function toExcel(){
		var options=$("#state option:selected");
		var keywords = $("#nav-search-input").val();
		var start = $("#start").val();
		var end = $("#end").val();
		var state=options.val();
        var tphone=$("#tphone").val();
		window.location.href='<%=basePath%>school/excel.do?keywords='+keywords+'&start='+start+'&end='+end+'&state='+state+'&tphone='+tphone;
	}
	
	function toRecharge(sId){
		   top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="充值记录";
			 diag.URL = '<%=basePath%>student/listStudentRecharge?student_id='+sId;
			 diag.Width = 750;
			 diag.Height=436;
			 diag.CancelEvent = function(){ //关闭事件
				diag.close();
			 };
			 diag.show();
		 }
	
	function delStuden(id){
		bootbox.confirm("确定要进行此操作吗?", function(result) {
			
		    if(result){
		    	top.jzts();
	          $.ajax({
                  type:'POST',
                  url:'<%=basePath%>school/deleteStuden.do',
                  data:{
                	  user_id:id
                       },
                 success:function(data){
		                window.location.reload();
                 },
                 error:function(){
                	 window.location.reload();
                 }
			})
		    }
	});
	}

<!--确认学生就读-->
function comfirmStuden(id,state){
		bootbox.confirm("确定要进行此操作吗?", function(result) {
			
		    if(result){
		    	top.jzts();
	          $.ajax({
                  type:'POST',
                  url:'<%=basePath%>school/comfirmStuden.do',
                  data:{
                	  user_id:id,
                      state:state
                       },
                 success:function(data){
		                window.location.reload();
                 },
                 error:function(){
                	 window.location.reload();
                 }
			})
		    }
	});
	}
	</script>


</body>
</html>