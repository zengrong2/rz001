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
						<form action="company/editLabourTypeByCid.do" name="form1" id="form1"  method="post" enctype="multipart/form-data">
						<input type="hidden" name="labour_id" id="tid" value="${pd.labour_id}"/>
							<div id="zhongxin" style="padding-top:13px;">
							<table id="table_report" class="table table-striped table-bordered table-hover">
										
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;">类型名字:</td>
											<td><input style="width:98%;" type="text" name="labour_name" id="name"  value="${pd.labour_name }"  maxlength="32" placeholder="这里输入劳动就业类型" title="劳动就业类型"  /></td>
										</tr>
										
													
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;">选择修改类型图片:</td>
											<td><input type="file" name="file" id="fileImage"  maxlength="64" placeholder="这里修改类型图片" title="类型图片" style="width:98%;"/></td>
										</tr>
								
										
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;">备注:</td>
											<td><textarea name="remark" id="remark" rows="5" cols="45">${pd.remark }</textarea></td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10">
												<a class="btn btn-mini btn-primary" onclick="save();">修改</a>
												<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
											</td>
										</tr>
										
							</table>
							
							</div>
						</form>
					<div>
					<img src="<%=basePath%>uploadFiles/uploadImgs/${pd.labour_image}" alt="图片" width="500">
					
					</div>
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
		if ($("#name").val() == "") {
			$("#name").tips({
				side : 3,
				msg : '请输入类型名称',
				bg : '#AE81FF',
				time : 2
			});
			$("#name").focus();
			return false;
		}
		if ($("#fileImage").val() == "") {
			$("#fileImage").tips({
				side : 3,
				msg : '请添加类型图片',
				bg : '#AE81FF',
				time : 2
			});
			$("#fileImage").focus();
			return false;
		}
		
			$("#form1").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
	}
	
	
	</script>
</body>
</html>

