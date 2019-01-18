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
						<form action="#" name="form1" id="form1"  method="post">
						
							<div id="zhongxin" style="padding-top:13px;">
							<table id="table_report" class="table  table-hover" style="border-collapse: collapse;border:0px;" >
										
										<tr>
											<td colspan="2" style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">付款金额￥${tdPartnerBonusTransferRecordinput.partnerBonusTransferRecordMoney }</td>
											
										</tr>
							   <c:if test="${tdPartnerBonusTransferRecordinput.paymentStatus ==1}">
										<tr>
											<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">当前状态:</td>
											<td >支付成功</td>
										</tr>
								</c:if>
								<c:if test="${tdPartnerBonusTransferRecordinput.paymentStatus !=1}">
										<tr>
											<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">当前状态:</td>
											<td>支付失败</td>
										</tr>
								</c:if>
										
										
										<tr>
											<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">收款方备注:</td>
											<td >${tdPartnerBonusTransferRecordinput.remark }</td>
										</tr>
										<tr>
											<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">支付方式:</td>
											<td >${tdPartnerBonusTransferRecordinput.paymentMethod }</td>
										</tr>
										<tr>
											<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">转账时间:</td>
											<td >${tdPartnerBonusTransferRecordinput.transfTime }</td>
										</tr>
										<tr>
											<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">转账单号:</td>
											<td >${tdPartnerBonusTransferRecordinput.transferSingleNumber }</td>
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
	
	
	
	</script>
</body>
</html>

