<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>

<style type="text/css">
#l-map{
     height:300px;
     width:100%;
     }
#r-result{
     width:100%;
     }
#dialog-add, #dialog-message, #dialog-comment {
	width: 100%;
	height: 100%;
	position: fixed;
	top: 0px;
	z-index: 99999999;
	display: none;
}

.commitopacity {
	position: absolute;
	width: 100%;
	height: 10000px;
	background: #7f7f7f;
	filter: alpha(opacity = 50);
	-moz-opacity: 0.5;
	-khtml-opacity: 0.5;
	opacity: 0.5;
	top: 0px;
	z-index: 99999;
}

.commitbox {
	width: 100%;
	margin: 0px auto;
	position: absolute;
	top: 120px;
	z-index: 99999;
}

.commitbox_inner {
	width: 96%;
	height: 255px;
	margin: 6px auto;
	background: #efefef;
	border-radius: 5px;
}

.commitbox_top {
	width: 100%;
	height: 253px;
	margin-bottom: 10px;
	padding-top: 10px;
	background: #FFF;
	border-radius: 5px;
	box-shadow: 1px 1px 3px #e8e8e8;
}

.commitbox_top textarea {
	width: 95%;
	height: 195px;
	display: block;
	margin: 0px auto;
	border: 0px;
}

.commitbox_cen {
	width: 95%;
	height: 40px;
	padding-top: 10px;
}

.commitbox_cen div.left {
	float: left;
	background-size: 15px;
	background-position: 0px 3px;
	padding-left: 18px;
	color: #f77500;
	font-size: 16px;
	line-height: 27px;
}

.commitbox_cen div.left img {
	width: 30px;
}

.commitbox_cen div.right {
	float: right;
	margin-top: 7px;
}

.commitbox_cen div.right span {
	cursor: pointer;
}

.commitbox_cen div.right span.save {
	border: solid 1px #c7c7c7;
	background: #6FB3E0;
	border-radius: 3px;
	color: #FFF;
	padding: 5px 10px;
}

.commitbox_cen div.right span.quxiao {
	border: solid 1px #f77400;
	background: #f77400;
	border-radius: 3px;
	color: #FFF;
	padding: 4px 9px;
}

.uploadBtn {
	background: #ffffff;
	border: 1px solid #cfcfcf;
	color: #565656;
	padding: 0 18px;
	display: inline-block;
	border-radius: 3px;
	margin-left: 10px;
	cursor: pointer;
	font-size: 14px;
	float: left;
}

.uploadBtn:hover {
	background: #f0f0f0;
}

.uploadBtn {
	background: #00b7ee;
	color: #fff;
	border-color: transparent;
}

.uploadBtn:hover {
	background: #00a2d4;
}

.uploadBtn.disabled {
	pointer-events: none;
	opacity: 0.6;
}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=YOwszXAmroGjxRyPbyhmxlZGrjPLYz6m"></script>
</head>
<body>
	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="span12">
								<div class="widget-box">
									<div class="widget-body">
										<div class="widget-main">
											<div class="step-content row-fluid position-relative">
												<div id="zhongxin">
												<form  action="#" name="menuForm" id="menuForm" method="post" class="form-horizontal" enctype="multipart/form-data">	
												 <%-- <input type="hidden" value="${pd.company_id }" name="company_id"> --%>
													<table style="width: 100%;" id="xtable"  class="table table-striped table-bordered table-hover">
						
														<tr id="users">
															<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">活动名称:
															</td><td>
												             ${tdActivity.activityName }
															</td>
														
														<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">提成比例：
														</td><td>${tdActivity.royaltyRatio }
															</td>
														
											             <td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">匹配到的总人数:</td>
											             <td>${matchPersonCount }
											             </td>
										                </tr>
													</table>
						<table id="simple-table" class="table table-striped table-bordered table-hover"  style="margin-top:5px;">
							<thead>
								<tr>
									
									   
									    <th class='center'>客户经理姓名</th>
									    <th class='center'>客户经理会员号</th>
									    <th class='center'>客户经理电话</th>
									
										<th class='center'>匹配人数</th>
								</tr>
							</thead>						
							<tbody>
							<!-- 开始循环 -->	
							<c:choose>
								<c:when test="${not empty listTdTempUser}">
									<c:forEach items="${listTdTempUser}" var="ts" varStatus="vs">
										<tr>			
										
							            <td class='center'>${ts.uNickName}
							            </td>
										<td class='center'>${ts.memberId}</td>
										<td class='center'>${ts.phone}</td>
									    <td class='center'>${ts.count}</td>
																					
										</tr>
										
									</c:forEach>

									
								</c:when>
								<c:otherwise>
									<tr class="main_info">
										<td colspan="11" class="center">没有相关数据</td>
									</tr>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table>
													</form>
												</div>
												
											</div>
										</div>
										<!--/widget-main-->
									</div>
									<!--/widget-body-->
								</div>
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
	<!-- ace scripts -->
	<!-- 编辑框-->
	<script type="text/javascript" charset="utf-8">window.UEDITOR_HOME_URL = "<%=path%>/plugins/ueditor/";
	</script>
	<script type="text/javascript" charset="utf-8"
		src="plugins/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="plugins/ueditor/ueditor.all.js"></script>
	<!-- 编辑框-->
	<script src="static/vue.js"></script>
	<script src="static/vue-resource.js"></script>
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script src="static/ace/js/ace/ace.js"></script>
	<!--引入属于此页面的js -->
	<script type="text/javascript" src="static/js/myjs/toolEmail.js"></script>
	<script type="text/javascript" src="plugins/webuploader/webuploader.js"></script>
	<script type="text/javascript" src="plugins/webuploader/upload.js"></script>
	<script type="text/javascript" src="static/js/myjs/commonUrl.js"></script>
	<script type="text/javascript">	   
	
		
   	
	   
		function getLocalTimeHMS(date2) {
			var date = new Date(date2);
			var Y = date.getFullYear() + '-';
			var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1)
					: date.getMonth() + 1)
					+ '-';
			var D = date.getDate() + ' ';
			var h = date.getHours() + ':';
			var m = date.getMinutes() + ':';
			var s = date.getSeconds();
			return Y + M + D + h + m + s;

		}
		/*关闭窗口*/
		function CloseWebPage() {     
		    if (navigator.userAgent.indexOf("MSIE") > 0) {     
		        if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {     
		            window.opener = null; window.close(); 
		            
		            
			        
		        }     
		        else {     
		            window.open('', '_top'); window.top.close();   
			        
		        }     
		    }     
		    else if (navigator.userAgent.indexOf("Firefox") > 0) {     
		        window.location.href = 'about:blank '; //火狐默认状态非window.open的页面window.close是无效的    
		        //window.history.go(-2);     
		    }     
		    else {     
		        window.opener = null;      
		        window.open('', '_self', '');    
		        
		        window.close();     
		    }     
		}  
	</script>
</body>
</html>