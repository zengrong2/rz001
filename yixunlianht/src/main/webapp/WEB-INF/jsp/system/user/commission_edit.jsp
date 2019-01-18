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
						<form action="teacher/editT.do" name="form1" id="form1"  method="post">
						<input type="hidden" name="tid" id="tid" value="${pd.tid}"/>
							<div id="zhongxin" style="padding-top:13px;">
							<table id="table_report" class="table table-striped table-bordered table-hover">
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">手机号:</td>
											<td><input type="number" name="phone" id="phone"  value="${pd.phone }"  maxlength="32" placeholder="这里输入手机号" title="手机号" style="width:98%;"/></td>
										</tr>
								
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">姓名:</td>
											<td><input type="text" name="name" id="name"  value="${pd.name }"  maxlength="32" placeholder="这里输入姓名" title="姓名" style="width:98%;" /></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">提成:</td>
											<td><input type="number" name="commission" id="commission"  value="${pd.commission }"  maxlength="32" placeholder="提成为百分比" title="提成" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">居住地址:</td>
											<td><input type="text" name="address" id="address"  value="${pd.address }"  maxlength="32" placeholder="输入居住地址" title="居住地址" style="width:98%;"/></td>
										</tr>
										<!--  <tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">工作单位:</td>
											<td><input type="text" name="workunit" id="workunit"  value="${pd.workunit}"  maxlength="32" placeholder="输入工作单位" title="工作单位" style="width:98%;"/></td>
										</tr>-->
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">备注:</td>
											<td><textarea name="remark" id="remark" rows="5" cols="45">${pd.remark }</textarea></td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10">
												<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
												<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
											</td>
										</tr>
										
							</table>
							<br />
							<div style="font-size: 10px;color: red">
							   这里提成为百分比，并且必须为整数
							</div>
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
	//保存
	function save(){
		if($("#commission").val()==""){
			$("#commission").tips({
				side:3,
	            msg:'请输入',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#commission").focus();
			return false;
		}
		
			$("#form1").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
	}
	
	
	</script>
</body>
</html>

