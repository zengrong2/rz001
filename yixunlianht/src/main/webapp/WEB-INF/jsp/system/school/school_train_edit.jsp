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
												<form  action="<%=basePath%>train/editTrainSchoolByCid.do" name="menuForm" id="menuForm" method="post" class="form-horizontal">
													<textarea name="CONTENT" id="CONTENT" style="display: none"></textarea>
													<input type="hidden" value="028-82687920" name="phone">
													<input type="hidden" name="school_id" id="tid" value="${pd.school_id}"/>
													
													<table style="width: 100%;" id="xtable">
						
														<tr id="users">
															<td style="padding-top: 10px;">培训机构名称:<input
																type="text" name="name" id="name" value="${pd.name}"
																maxlength="50"  title="培训机构名称"
																style="width: 500px; margin-left: 20px; margin-right: 10px;" />
												
															</td>
														</tr>
														<tr >
															<td style="padding-top: 10px;">培训机构电话:<input
																type="text" name="school_phone" id="phone" value="${pd.phone }"
																maxlength="50"  title="培训机构电话" 
																style="width: 240px; margin-left: 20px; margin-right: 10px;" />
																校长:<input type="text" placeholder="这里输入培训机构校长"  id="principal"  name="principal"  value="${pd.principal }"/> 
															</td>
														</tr>
														<tr>
														 <td style="padding-top: 10px;">培训机构类型:<input
																type="text" name="stype" id="stype" value="${pd.stype }"
																maxlength="50" placeholder="例如：财经类等" title="培训机构名称"
																style="width: 240px; margin-left: 20px; margin-right: 10px;" />
																类型:<input type="text" placeholder="例如:公立、私立等"  id="type"  name="type" value="${pd.type }" /> 
															</td>
														</tr>
														<tr>
																 <td style="padding-top: 10px;">专业数量:<input
																type="number" name="major_num" id="major_num" value="${pd.major_num }"
																maxlength="50" title="专业数量" style="width: 240px; margin-left: 20px; margin-right: 10px;" />
																培训机构等级:<input type="text" placeholder="例如:本科，专科"  id="grade"  name="grade" value="${pd.grade }" /> 
															</td>
														</tr>
														<tr>
																 <td style="padding-top: 10px;"> 
																培训机构管理员: <select  name="user_id" id="user_id" data-placeholder="选择培训机构管理员" style="vertical-align:top;width: 120px;">
															<option value="">请选择管理员</option>
															<c:forEach items="${uList}" var="u">
																<option value="${u.USER_ID}">${u.NAME }</option>
															</c:forEach>
														  	</select>&nbsp;&nbsp;&nbsp;
																 经度:<input type="text" id="lng" name="lng" style="width:100px;" readonly="readonly" value="${pd.lng }" />&nbsp;&nbsp;纬度:<input type="text"  id="lat" name="lat" style="width:100px;" readonly="readonly" value="${pd.lat }" />
															</td>
														</tr>
														<tr>
															<td style="padding-top: 10px;">
	                                               <div id="r-result">请输入地址:<input type="text" id="suggestId" size="100"  style="width:400px;" value="${pd.saddress }"/>
	                                              &nbsp;&nbsp;  </div>
	                                               <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
	                                               </td>
														</tr>
														<tr>
														   <td style="padding-top:10px;">
														    详细地址：<input type="text" name="saddress" id="saddress"  style="width: 550px; margin-left: 20px; margin-right: 10px;"></span>
														   </td>
														</tr>
														<tr>
														  <td style="padding-top: 10px;"><div id="l-map"></div></td>
														</tr>
														<tr>
															<td style="text-align: center;" colspan="10"><a
																class="btn btn-mini btn-primary" onclick="save();">修改</a>
																<a class="btn btn-mini btn-danger"
																onclick="top.Dialog.close();">取消</a></td>
														</tr>
													</table>
													</form>
												</div>
												<div id="zhongxin2" class="center" style="display: none">
													<br />
													<img src="static/images/jiazai.gif" /><br />
													<h4 class="lighter block green">提交中...</h4>
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
	// 百度地图API功能
		function G(id) {
			return document.getElementById(id);
		}

		var map = new BMap.Map("l-map");
		map.centerAndZoom("成都",12);                   // 初始化地图,设置城市和地图级别。

		var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
			{"input" : "suggestId"
			,"location" : map
		});

		ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
		var str = "";
			var _value = e.fromitem.value;
			var value = "";
			if (e.fromitem.index > -1) {
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}    
			str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
			
			value = "";
			if (e.toitem.index > -1) {
				_value = e.toitem.value;
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}    
			str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
			G("searchResultPanel").innerHTML = str;
		});

		var myValue;
		ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
		var _value = e.item.value;
			myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
			setPlace();
		});

		function setPlace(){
			map.clearOverlays();    //清除地图上所有覆盖物
			function myFun(){
				var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
				map.centerAndZoom(pp, 18);
				map.addOverlay(new BMap.Marker(pp));    //添加标注
				$("#lng").val(pp.lng);
				$("#lat").val(pp.lat);
				var dz=$("#suggestId").val();
				$("#saddress").val(dz);
			}
			var local = new BMap.LocalSearch(map, { //智能搜索
			  onSearchComplete: myFun
			});
			local.search(myValue);
		}

		
   	//保存
		function save() {
			if ($("#name").val() == "") {
				$("#name").tips({
					side : 3,
					msg : '请输入培训机构名称',
					bg : '#AE81FF',
					time : 2
				});
				$("#name").focus();
				return false;
			}
			if ($("#principal").val() == "") {
				$("#principal").tips({
					side : 3,
					msg : '请输入校长',
					bg : '#AE81FF',
					time : 2
				});
				$("#principal").focus();
				return false;
			}
			
			if ($("#saddress").val() == "") {
				$("#saddress").tips({
					side : 3,
					msg : '请输入地址',
					bg : '#AE81FF',
					time : 2
				});
				$("#saddress").focus();
				return false;
			}
			
			$("#menuForm").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();

		}
	   
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