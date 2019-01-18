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
												<form  action="<%=basePath%>company/saveCompanyInfo.do" name="menuForm" id="menuForm" method="post" class="form-horizontal">
													<textarea name="CONTENT" id="CONTENT" style="display: none"></textarea>
													<input type="hidden" value="028-82687920" name="phone">
													<table style="width: 100%;" id="xtable">
						
														<tr id="users">
															<td style="padding-top: 10px;">公司名称:<input
																type="text" name="company_name" id="name" value=""
																maxlength="50" placeholder="这里输入公司名称" title="公司名称"
																style="width: 500px; margin-left: 20px; margin-right: 10px;" />
												
															</td>
														</tr>
														<tr >
															<td style="padding-top: 10px;">公司电话:<input
																type="text" name="company_phone" id="company_phone" value=""
																maxlength="50" placeholder="这里输入公司电话" title="公司电话"
																style="width: 240px; margin-left: 20px; margin-right: 10px;" />
															</td>
														</tr>
														<tr>
														
															<td style="padding-top: 10px;">
															公司性质: <select  name="company_nature" id="company_nature" data-placeholder="选择公司所属性质" style="vertical-align:top;width: 150px;">
															<option value="">请公司所属性质</option>
															<option value="私营企业">私营企业</option>
															<option value="国营企业">国营企业</option>														
															<option value="中外合资">中外合资</option>															
														  	</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															
															公司规模: <select  name="company_scale" id="company_scale" data-placeholder="选择公司所属规模" style="vertical-align:top;width: 150px;">
															<option value="">选择公司所属规模</option>
															<option value="0~20">0~20</option>
															<option value="20~100">20~100</option>														
															<option value="100~200">100~200</option>
															<option value="200~500">200~500</option>	
															<option value="500~1000">500~1000</option>
															<option value="1000以上">1000以上</option>																
														  	</select>
															</td>
														</tr>
														
														<tr>
																<td style="padding-top: 10px;">公司福利:<input
																type="text" name="company_welfare" id="company_welfare" value="" placeholder="列入五险一金，周末双休，团队旅游"
																maxlength="50" title="公司福利" style="width: 240px; margin-left: 20px; margin-right: 10px;" />
															(可选)就业类型:
															<select  name="labour_id" id="labour_id" data-placeholder="选择就业类型" style="vertical-align:top;width: 120px;">
															<option value="">就业类型</option>
															<c:forEach items="${listLabourType}" var="u">
																<option value="${u.labour_id}">${u.labour_name }</option>
															</c:forEach>
														  	</select>&nbsp;&nbsp;&nbsp;
															</td>
														</tr>
														<tr>
														 <td style="padding-top: 10px;"> 																												
																 经度:<input type="text" id="lng" name="lng" style="width:100px;" readonly="readonly"/>&nbsp;&nbsp;纬度:<input type="text"  id="lat" name="lat" style="width:100px;" readonly="readonly"/>
														</td>
															
														</tr>
														<tr>
															<td style="padding-top: 10px;">
	                                               <div id="r-result">请输入地址:<input type="text" id="suggestId" size="100"  style="width:400px;" />
	                                              &nbsp;&nbsp;  </div>
	                                               <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
	                                               </td>
														</tr>
														<tr>
														   <td style="padding-top:10px;">
														    详细地址：<input type="text" name="company_adress" id="saddress"  style="width: 550px; margin-left: 20px; margin-right: 10px;"></span>
														   </td>
														</tr>
														<tr>
														  <td style="padding-top: 10px;"><div id="l-map"></div></td>
														</tr>
														<tr>
															<td style="text-align: center;" colspan="10"><a
																class="btn btn-mini btn-primary" onclick="save();">保存</a>
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
			
			if ($("#company_nature").val() == "") {
				$("#company_nature").tips({
					side : 3,
					msg : '请选择公司性质',
					bg : '#AE81FF',
					time : 2
				});
				$("#company_nature").focus();
				return false;
			}
			if ($("#company_scale").val() == "") {
				$("#company_scale").tips({
					side : 3,
					msg : '请选择公司规模',
					bg : '#AE81FF',
					time : 2
				});
				$("#company_scale").focus();
				return false;
			}
			if ($("#company_welfare").val() == "") {
				$("#company_welfare").tips({
					side : 3,
					msg : '请输入公司福利',
					bg : '#AE81FF',
					time : 2
				});
				$("#company_welfare").focus();
				return false;
			}
			
			if ($("#suggestId").val() == "") {
				$("#suggestId").tips({
					side : 3,
					msg : '请输入公司地址',
					bg : '#AE81FF',
					time : 2
				});
				$("#suggestId").focus();
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