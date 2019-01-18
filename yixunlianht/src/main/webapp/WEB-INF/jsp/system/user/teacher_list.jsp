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
						<form action="teacher/list.do" method="post" name="userForm" id="userForm">
						<table style="margin-top:5px;">
							<tr>
								<td>
									<div class="nav-search">
									<span class="input-icon">
									<input type="hidden" value="${tid}" name="tid">
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="keywords" value="${pd.keywords }" placeholder="输入姓名或者电话" />
										<i class="ace-icon fa fa-search nav-search-icon"></i>
									</span>
									</div>
								</td>
								<c:if test="${pd.type==null }">
								<td>
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="ywyphone" type="text" name="ywyphone" value="${yphone }" placeholder="输入业务员电话" />
										<i class="ace-icon fa fa-search nav-search-icon"></i>
									</span>
									</div>
								</td>
								</c:if>
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
										<th class='center'>等级</th>
										<th class='center'>提成</th>
										<th class="center">积分</th>
										<th class="center">学生</th>
										<th class="center">居住地址</th>
										<th class='center'>更新时间</th>
										<th class='center' style="width: 120px;">操作</th>
									</tr>
								</thead>
								<tbody style="line:30px">
								<c:choose>
									<c:when test="${not empty tList}">
									<c:forEach items="${tList}" var="t" varStatus="vs">
									<tr>
										<td class='center' >${vs.index+1 }</td>
										<td class='center'>
										${t.name}
										<c:if test="${null == pd.tid || pd.tid == '0'}">
											<a href="javascript:goSonmenu('${t.tid }')">--二级</a>
											</c:if>
										</td>
										<td class='center'>${t.phone }</td>
										<td class='center'>${t.type }</td>
										<td class='center'>${t.commission }%</td>
										<td class='center'>${t.integral }</td>
										<td class="center" style="cursor:pointer;color:blue;" onClick="toStudent('${t.tid}')">查看</td>
										<td class='center'>${t.address }</td>
										<td class='center'>${t.updateTime }</td>
										<td class='center'>
										<c:if test="${QX.edit != 1 && QX.del != 1 }">
												<span class="label label-large label-grey arrowed-in-right arrowed-in"><i class="ace-icon fa fa-lock" title="无权限"></i></span>
												</c:if>
												<div class="hidden-sm hidden-xs btn-group">
													<c:if test="${QX.edit == 1 }">
													<a class="btn btn-xs btn-success" title="编辑" onclick="editT('${t.tid}');">
														<i class="ace-icon fa fa-pencil-square-o bigger-120" title="编辑"></i>
													</a>
													<button type="button" class="btn btn-xs btn-info" onClick="toIntegralMoney('${t.tid}')" >
													结算</button>
											       		   
													<a class="btn btn-xs btn-danger" onclick="delT('${t.tid}');" >
														<i class="ace-icon fa fa-trash-o bigger-120" title="删除"></i>
													</a>
													
													                         
													</c:if>
												</div>
												<div class="hidden-md hidden-lg">
													<div class="inline pos-rel">
														<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto">
															<i class="ace-icon fa fa-cog icon-only bigger-110"></i>
														</button>
														<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
															<c:if test="${QX.edit == 1 }">
															<li>
																<a style="cursor:pointer;" onclick="editT('${t.tid}');" class="tooltip-success" data-rel="tooltip" title="修改">
																	<span class="green">
																		<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																	</span>
																</a>
															</li>
															
															
															</c:if>
															<c:if test="${QX.edit == 1 }">
															<li>
																<a style="cursor:pointer;" onclick="delUser('${t.tid}');" class="tooltip-error" data-rel="tooltip" title="删除">
																	<span class="red">
																		<i class="ace-icon fa fa-trash-o bigger-120"></i>
																	</span>
																</a>
															</li>
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
							</form>
							<div>
							<c:if test="${null == pd.tid || pd.tid == '0'}">
								<a class="btn btn-sm btn-success" onclick="addtype();">新增</a>
							<a style="vertical-align:top;"><div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">${page.pageStr}</div></a>
								
							</c:if>	
								<c:if test="${null != pd.tid && pd.tid != '0'}">
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
			window.location.href="<%=basePath%>teacher/list.do?tid="+SERVE_ID;
		};
		//去此ID下 获取该老师总的结算积分
		$(top.hangge());
		function goIntegral(SERVE_ID){
			window.location.href="<%=basePath%>teacher/list.do?tid="+SERVE_ID;
		};
		
		//导出excel
		function toExcel(){
			var options=$("#state option:selected");
			var keywords = $("#nav-search-input").val();
			var start = $("#start").val();
			var end = $("#end").val();
			var state=options.val();
	        var tphone=$("#tphone").val();
			window.location.href='<%=basePath%>teacher/excel.do';
		}
		
		//检索
		function searchs(){
			top.jzts();
			$("#userForm").submit();
		}
		function addtype(){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增";
			 diag.URL = '<%=basePath%>teacher/goAddT.do';
			 diag.Width = 469;
			 diag.Height = 510;
			 diag.CancelEvent = function(){ //关闭事件
				 window.location.reload();
		         diag.close();
			 };
			 diag.show();
		}
		
		function editT(user_id){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="修改";
			 diag.URL = '<%=basePath%>teacher/goEditT.do?tid='+user_id;
			 diag.Width = 469;
			 diag.Height = 510;
			 diag.CancelEvent = function(){ //关闭事件
				 window.location.reload();
				diag.close();
			 };
			 diag.show();
		}
		function toStudent(oId){
			   top.jzts();
				 var diag = new top.Dialog();
				 diag.Drag=true;
				 diag.Title ="用户详情";
				 diag.URL = '<%=basePath%>teacher/goStudent?tid='+oId;
				 diag.Width = 625;
				 diag.Height =400;
				 diag.CancelEvent = function(){ //关闭事件
					diag.close();
				 };
				 diag.show();
			 }
		//结算积分
		function toIntegralMoney(oId){
			   top.jzts();
				 var diag = new top.Dialog();
				 diag.Drag=true;
				 diag.Title ="老师积分详情";
				 diag.URL = '<%=basePath%>teacher/toIntegralMoney?tid='+oId;
				 diag.Width = 300;
				 diag.Height =200;
				 diag.CancelEvent = function(){ //关闭事件
					diag.close();
				 };
				 diag.show();
			 }
		
		//删除
		function delT(tid){
			bootbox.confirm("确定要删除吗?", function(result) {
				if(result) {
					top.jzts();
					var url = "<%=basePath%>teacher/deleteT.do?tid="+tid;
					$.get(url,function(data){
						window.location.reload();
					});
				};
			});
		}
	</script>


</body>
</html>