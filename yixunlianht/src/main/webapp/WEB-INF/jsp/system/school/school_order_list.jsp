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
						<form action="school/order/listSchoolOrder.do" method="post" name="userForm" id="userForm">
						<table style="margin-top:5px;">
							<tr>
							   <td style="vertical-align:top;padding-left:2px;">
								 	<select class="chosen-select form-control" name="state" id="state" data-placeholder="请选择状态" style="vertical-align:top;width: 120px;" onchange="searchs();">
									<option value="" <c:if test=" ${pd.state == '' }">selected</c:if>>全部</option>
									<option value="0" <c:if test="${pd.state == '0' }">selected</c:if>>待学生确认</option>
									<option value="1" <c:if test="${pd.state == '1' }">selected</c:if>>待学校确认</option>
									<option value="2" <c:if test="${pd.state == '2' }">selected</c:if>>已就读</option>
									<option value="3" <c:if test="${pd.state == '3' }">selected</c:if>>已申请退款</option>
									<option value="4" <c:if test="${pd.state == '4' }">selected</c:if>>已退学</option>
									</select>
								</td>
								<td>
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="keywords" value="${pd.keywords }" placeholder="这里输入关键字" />
										<i class="ace-icon fa fa-search nav-search-icon"></i>
									</span>
									</div>
								</td>
								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
							    <td style="cursor:pointer;color:red;font-size: 18px">
								&nbsp;&nbsp; 试读费总收入:${zje/100 }
								</td>
							</tr>
						</table>
							<table id="dynamic-table" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center" style="width: 50px;">序号</th>
										<th class='center'>订单号</th>
										<th class='center'>学校名称</th>
										<th class='center'>学生姓名</th>
										<th class='center'>专业名称</th>
										<th class='center'>试读费</th>
										<th class='center'>总学费</th>
										<th class='center'>实交费用</th>
										<th class='center'>试读天数</th>
										<th class='center'>学生试读天数</th>
										<th class='center'>报名时间</th>
										<th class='center'>试读时间</th>
										<th class='center'>状态</th>
									</tr>
								</thead>
								<tbody style="line:30px">
								<c:choose>
									<c:when test="${not empty soList}">
									<c:forEach items="${soList}" var="t" varStatus="vs">
									<tr>
										<td class='center' >${vs.index+1 }</td>
										<td class='center'>${t.order_num}</td>
										<td class='center'>${t.school_name }</td>
										<td class='center'>${t.student_name }</td>
										<td class='center'>${t.major_name }</td>
										<td class='center'>${t.money/100 }</td>
										<td class='center'>${t.tution/100 }</td>
										<td class='center'>${t.sjmoney/100 }</td>
										<td class='center'>${t.probation_day }</td>
										<td class='center'>${t.studay }</td>
										<td class='center'>${t.created}</td>
										<td class='center'>${t.create_time}</td>
										<c:if test="${t.state=='1'}"><td class="center">待学校确认 &nbsp;&nbsp;
										<a class="label label-success arrowed" onclick="changeState('${t.order_id}',2);">确认</a>
										</td></c:if>
										<c:if test="${t.state=='0'}"><td class="center">待学生确认</td></c:if>
										<c:if test="${t.state=='2'}"><td class="center">已就读</td></c:if>
										<c:if test="${t.state=='3'}"><td class="center">已申请退款</td></c:if>
										<c:if test="${t.state=='4'}"><td class="center">已退学</td></c:if>
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
	
	function changeState(cid,state){	
		bootbox.confirm("确定要进行此操作吗?", function(result) {
			
			    if(result){
			    	top.jzts();
		          $.ajax({
	                  type:'POST',
	                  url:'<%=basePath%>school/order/updateState.do',
	                  data:{
	                	 state:state,
	                	  order_id:cid,
	                       },
	                 success:function(data){
			         window.location.reload();
	                 }
				})
			    }
		});
	}
	</script>


</body>
</html>