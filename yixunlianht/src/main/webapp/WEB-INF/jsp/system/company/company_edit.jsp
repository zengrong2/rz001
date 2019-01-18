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
						<form action="company/editCompanyByCid.do" name="form1" id="form1"  method="post">
						<input type="hidden" name="company_id" id="tid" value="${pd.company_id}"/>
							<div id="zhongxin" style="padding-top:13px;">
							<table id="table_report" class="table table-striped table-bordered table-hover">
										
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;" class="center">公司名字:</td>
											<td ><input style="width:98%;" type="text" name="companyName" id="name"  value="${pd.company_name }"  maxlength="32" placeholder="这里输入公司名字" title="公司名字"  /></td>
										</tr>
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;">公司电话:</td>
											<td><input type="number" name="companyPhone" id="company_phone"  value="${pd.company_phone }"  maxlength="32" placeholder="这里输入公司电话" title="公司电话" style="width:98%;"/></td>
										</tr>
								
										
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;">公司福利:</td>
											<td><input type="text" name="companyWelfare" id="companyWelfare"  value="${pd.company_phone }"  maxlength="32" placeholder="公司福利" title="公司福利" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;">公司地址:</td>
											<td><input type="text" name="companyAdress" id="companyAdress"  value="${pd.company_adress }"  maxlength="32" placeholder="输入公司地址" title="公司地址" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;">公司规模:</td>
											<td><input type="text" name="companyScale" id="companyScale"  value="${pd.company_scale }"  maxlength="32" placeholder="输入公司规模" title="公司规模" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;">公司性质:</td>
											<td><input type="text" name="companyNature" id="companyNature"  value="${pd.company_nature }"  maxlength="32" placeholder="输入公司性质" title="公司性质" style="width:98%;"/></td>
										</tr>
										
										<tr>
											<td style="width:140px;text-align: right;padding-top: 13px;">备注:</td>
											<td><textarea name="remark" id="remark" rows="5" cols="45" >${pd.remark }</textarea></td>
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
				msg : '请输入公司名称',
				bg : '#AE81FF',
				time : 2
			});
			$("#name").focus();
			return false;
		}
		
		var myreg=/^[1][3,4,5,6,7,8,9][0-9]{9}$/;
		var ph=$("#company_phone").val();
		if($("#company_phone").val()==""){
			
			$("#company_phone").tips({
				side:3,
	            msg:'输入手机号',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#company_phone").focus();
			return false;
		}else if($("#company_phone").val().length != 11 ){
			$("#company_phone").tips({
				side:3,
	            msg:'手机号格式不正确',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#company_phone").focus();
			return false;
		}else if(!myreg.test(ph)){
			$("#company_phone").tips({
				side:3,
	            msg:'手机号格式不正确',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#company_phone").focus();
			return false;
		}
	
		if ($("#companyWelfare").val() == "") {
			$("#companyWelfare").tips({
				side : 3,
				msg : '请输入公司福利',
				bg : '#AE81FF',
				time : 2
			});
			$("#companyWelfare").focus();
			return false;
		}
		if ($("#companyAdress").val() == "") {
			$("#companyAdress").tips({
				side : 3,
				msg : '请输入公司地址',
				bg : '#AE81FF',
				time : 2
			});
			$("#companyAdress").focus();
			return false;
		}
		if ($("#companyScale").val() == "") {
			$("#companyScale").tips({
				side : 3,
				msg : '请选择公司规模',
				bg : '#AE81FF',
				time : 2
			});
			$("#companyScale").focus();
			return false;
		}
		if ($("#companyNature").val() == "") {
			$("#companyNature").tips({
				side : 3,
				msg : '请选择公司性质',
				bg : '#AE81FF',
				time : 2
			});
			$("#companyNature").focus();
			return false;
		}
		
		
		
		
			$("#form1").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
	}
	
	
	</script>
</body>
</html>

