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
						<form action="engageIndustry/editEngageIndustryById.do" name="form1" id="form1"  method="post">
						<%-- <input type="hidden" name="p_id" id="tid" value="${pd.p_id}"/>--%>
						<input type="hidden" name="egid_id" id="tid" value="${pd.egid_id}"/> 
							<div id="zhongxin" style="padding-top:13px;">
							<table id="table_report" class="table table-striped table-bordered table-hover">
										
										<tr>
											<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">从事行业名称:</td>
											<td><input style="width:98%;" type="text" name="egidName" id="name"  value="${tdEngagendustry.egidName }"  maxlength="32" placeholder="这里输入活动类型名称" title="活动类型名称"  /></td>
										</tr>
										
										<tr>
											<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">备注:</td>
											<td><textarea name="remark" id="remark" rows="5" cols="45">${tdEngagendustry.remark }</textarea></td>
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
		/* if ($("#name").val() == "") {
			$("#name").tips({
				side : 3,
				msg : '请输入职位名称',
				bg : '#AE81FF',
				time : 2
			});
			$("#name").focus();
			return false;
		}
		var myreg=/^[0-9]+([.]{1}[0-9]+){0,1}$/;
		var ph=$("#p_salary").val();
		if($("#p_salary").val()==""){
			
			$("#p_salary").tips({
				side:3,
	            msg:'输入职位薪资',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#p_salary").focus();
			return false;
		}else if($("#p_salary").val().length > 15 ){
			$("#p_salary").tips({
				side:3,
	            msg:'数字过长',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#p_salary").focus();
			return false;
		}else if(!myreg.test(ph)){
			$("#p_salary").tips({
				side:3,
	            msg:'请输入数字',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#p_salary").focus();
			return false;
		}
		if ($("#p_content").val() == "") {
			$("#p_content").tips({
				side : 3,
				msg : '请输入工作详细内容',
				bg : '#AE81FF',
				time : 2
			});
			$("#p_content").focus();
			return false;
		}
		
		if ($("#p_requirement").val() == "") {
			$("#p_requirement").tips({
				side : 3,
				msg : '请输入职位需求',
				bg : '#AE81FF',
				time : 2
			});
			$("#p_requirement").focus();
			return false;
		}
		if ($("#work").val() == "") {
			$("#work").tips({
				side : 3,
				msg : '请输入工作职位',
				bg : '#AE81FF',
				time : 2
			});
			$("#work").focus();
			return false;
		}
		 */
		
		
			$("#form1").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
	}
	
	
	</script>
</body>
</html>

