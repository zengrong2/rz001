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
						<form action="schoolProType/editSchoolProTypeByCid.do" name="form1" id="form1"  method="post">
						<input type="hidden" name="c_id" id="tid" value="${pd.c_id}"/>
						<input type="hidden" name="es_id" id="es_id" value="${pd.es_id}"/>
						
							<div id="zhongxin" style="padding-top:13px;">
							<table id="table_report" class="table table-striped table-bordered table-hover">
										
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;" class="center">升学类别:</td>
											<td ><input style="width:98%;" type="text" name="c_name" id="name"  value="${pd.c_name }"  maxlength="32" placeholder="这里输入升学类别" title="升学类型"  /></td>
										</tr>
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;">升学专业:</td>
											<td><input type="text" name="c_major" id="c_major"  value="${pd.c_major }"  maxlength="32" placeholder="这里输入升学专业" title="升学专业" style="width:98%;"/></td>
										</tr>
								
										
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;">学费(学年/月):</td>
											<td><input type="text" name="c_tuition" id="c_tuition"  value="${pd.c_tuition }"  maxlength="32" placeholder="升学费用（单位：元）" title="升学费用（单位：元）" style="width:98%;"/></td>
										</tr>
										
										
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;">备注:</td>
											<td><textarea name="remark" id="remark" rows="5" cols="45">${pd.remark }</textarea></td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10">
												<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
												<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
											</td>
										</tr>
										
							</table>
							
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
		if ($("#name").val() == "") {
			$("#name").tips({
				side : 3,
				msg : '请输入升学名称',
				bg : '#AE81FF',
				time : 2
			});
			$("#name").focus();
			return false;
		}
		
		if ($("#c_major").val() == "") {
			$("#c_major").tips({
				side : 3,
				msg : '请输入升学名称',
				bg : '#AE81FF',
				time : 2
			});
			$("#c_major").focus();
			return false;
		}
		
		
	
		var myreg=/^[0-9]+([.]{1}[0-9]+){0,1}$/;
		var ph=$("#c_tuition").val();
		if($("#c_tuition").val()==""){
			
			$("#c_tuition").tips({
				side:3,
	            msg:'输入升学费用',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#c_tuition").focus();
			return false;
		}else if($("#c_tuition").val().length > 10 ){
			$("#c_tuition").tips({
				side:3,
	            msg:'数字过长',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#c_tuition").focus();
			return false;
		}else if(!myreg.test(ph)){
			$("#c_tuition").tips({
				side:3,
	            msg:'请输入数字',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#c_tuition").focus();
			return false;
		}
		
			$("#form1").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
	}
	
	
	</script>
</body>
</html>

