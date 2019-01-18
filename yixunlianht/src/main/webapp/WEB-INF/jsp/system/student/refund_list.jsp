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
									<th class="center">退款人</th>
									<th class="center">联系电话</th>
									<th class="center">退款金额</th>
									<th class="center">退款账号</th>
									<th class="center">退款方式</th>
									<th class="center">申请时间</th>
									<th class="center">处理时间</th>
									<th class="center">操作</th>
								</tr>
							</thead>						
							<tbody>
							<!-- 开始循环 -->	
							<c:choose>
								<c:when test="${not empty rList}">
									<c:forEach items="${rList}" var="c" varStatus="vs">
										<tr>
										<td class='center' style="width: 30px;">
												<label><input type='checkbox' name='ids' value="${c.refund_id }" id="${c.refund_id }"  class="ace"/><span class="lbl"></span></label>
											</td>
											<td class="center">${vs.index+1}</td>
											<td class="center">${c.name} </td>
											<td class="center">${c.phone} </td>
											<td class="center">${c.money/100} </td>
											<td class="center">${c.number} </td>
											<td class="center">${c.pay_way==1?"支付宝":"微信" }</td>
											<td class="center">${c.created }</td>
											<td class="center">${c.update_time }</td>	
											<c:if test="${c.is_check==1}"><td class="center">已处理</td></c:if>
											<c:if test="${c.is_check==2}"><td class="center">已退款</td></c:if>
										<c:if test="${c.is_check==0}"><td class="center">待处理&nbsp;&nbsp;
										<a class="label label-success arrowed" onclick="changeState('${c.refund_id}',2,'${c.order_id }');">退款</a>
										<a class="label label-success arrowed" onclick="changeState('${c.refund_id}',1,'${c.order_id }');">已处理</a>
										</td></c:if>
										</tr>							
									</c:forEach>
									
								</c:when>
								<c:otherwise>
									<tr class="main_info">
										<td colspan="10" class="center">没有相关数据</td>
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
function changeState(rid,state,orderid){	
	bootbox.confirm("确定要进行此操作吗?", function(result) {
		
		    if(result){
		    	top.jzts();
	          $.ajax({
                  type:'POST',
                  url:'<%=basePath%>refund/updateState.do',
                  data:{
                	  refund_id:rid,
                	  is_check:state,
                	  order_id:orderid
                       },
                 success:function(data){
		         window.location.reload();
                 }
			})
		    }
	});
}
</script>
</html>
