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

<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>
<link rel="stylesheet" type="text/css" href="static/datetimepicker/jquery.datetimepicker.css"/>	

	<style type="text/css">
	
	
	
	#dialog-add,#dialog-message,#dialog-comment{width:100%; height:100%; position:fixed; top:0px; z-index:99999999; display:none;}
	.commitopacity{position:absolute; width:100%; height:10000px; background:#7f7f7f; filter:alpha(opacity=50); -moz-opacity:0.5; -khtml-opacity: 0.5; opacity: 0.5; top:0px; z-index:99999;}
	.commitbox{width:100%; margin:0px auto; position:absolute; top:120px; z-index:99999;}
	.commitbox_inner{width:96%; height:255px;  margin:6px auto; background:#efefef; border-radius:5px;}
	.commitbox_top{width:100%; height:253px; margin-bottom:10px; padding-top:10px; background:#FFF; border-radius:5px; box-shadow:1px 1px 3px #e8e8e8;}
	.commitbox_top textarea{width:95%; height:195px; display:block; margin:0px auto; border:0px;}
	.commitbox_cen{width:95%; height:40px; padding-top:10px;}
	.commitbox_cen div.left{float:left;background-size:15px; background-position:0px 3px; padding-left:18px; color:#f77500; font-size:16px; line-height:27px;}
	.commitbox_cen div.left img{width:30px;}
	.commitbox_cen div.right{float:right; margin-top:7px;}
	.commitbox_cen div.right span{cursor:pointer;}
	.commitbox_cen div.right span.save{border:solid 1px #c7c7c7; background:#6FB3E0; border-radius:3px; color:#FFF; padding:5px 10px;}
	.commitbox_cen div.right span.quxiao{border:solid 1px #f77400; background:#f77400; border-radius:3px; color:#FFF; padding:4px 9px;}
	
	.dark-matter {
margin-left: auto;
margin-right: auto;
max-width: 500px;
background: #555;
padding: 20px 30px 20px 30px;
font: 12px "Helvetica Neue", Helvetica, Arial, sans-serif;
color: #D3D3D3;
text-shadow: 1px 1px 1px #444;
border: none;
border-radius: 5px;
-webkit-border-radius: 5px;
-moz-border-radius: 5px;
}
.dark-matter h1 {
padding: 0px 0px 10px 40px;
display: block;
border-bottom: 1px solid #444;
margin: -10px -30px 30px -30px;
}
.dark-matter h1>span {
display: block;
font-size: 11px;
}
.dark-matter label {
display: block;
margin: 0px 0px 5px;
}
.dark-matter label>span {
float: left;
width: 20%;
text-align: right;
padding-right: 10px;
margin-top: 10px;
font-weight: bold;
}
.dark-matter input[type="text"], .dark-matter input[type="email"], .dark-matter textarea, .dark-matter select {
border: none;
color: #525252;
height: 25px;
line-height:15px;
margin-bottom: 16px;
margin-right: 6px;
margin-top: 2px;
outline: 0 none;
padding: 5px 0px 5px 5px;
width: 70%;
border-radius: 2px;
-webkit-border-radius: 2px;
-moz-border-radius: 2px;
-moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
background: #DFDFDF;
}
.dark-matter select {
background: #DFDFDF url('down-arrow.png') no-repeat right;
background: #DFDFDF url('down-arrow.png') no-repeat right;
appearance:none;
-webkit-appearance:none;
-moz-appearance: none;
text-indent: 0.01px;
text-overflow: '';
width: 70%;
height: 35px;
color: #525252;
line-height: 25px;
}
.dark-matter textarea{
height:100px;
padding: 5px 0px 0px 5px;
width: 70%;
}
.dark-matter .button {
background: #FFCC02;
border: none;
padding: 10px 25px 10px 25px;
color: #585858;
border-radius: 4px;
-moz-border-radius: 4px;
-webkit-border-radius: 4px;
text-shadow: 1px 1px 1px #FFE477;
font-weight: bold;
box-shadow: 1px 1px 1px #3D3D3D;
-webkit-box-shadow:1px 1px 1px #3D3D3D;
-moz-box-shadow:1px 1px 1px #3D3D3D;
}
.dark-matter .button:hover {
color: #333;
background-color: #EBEBEB;
}

.showTextStyle{
width:100px;border-radius:10px;background-color:#3A87AD;color:#FFFFFF;line-height30px;font-size:16px;height: 40px;
}
.inputStyle{
/* width:50%;background-color: #BC8B83;color: #ffffff; */
font-size: 18px;font-weight: bold;font-family:cursive;
}
	</style>
	
	</head> 
<body>

<!-- 编辑邮箱  -->
<div id="dialog-add">
	<div class="commitopacity"></div>
  	<div class="commitbox">
	  	<div class="commitbox_inner">
	        <div class="commitbox_top">
	        	<textarea name="EMAILs" id="EMAILs" placeholder="请选输入对方邮箱,多个请用(;)分号隔开" title="请选输入对方邮箱,多个请用(;)分号隔开"></textarea>
	            <div class="commitbox_cen">
	                <div class="left" id="cityname"></div>
	                <div class="right"><span class="save" onClick="saveEmail()">保存</span>&nbsp;&nbsp;<span class="quxiao" onClick="cancel_pl()">取消</span></div>
	            </div>
	        </div>
	  	</div>
  	</div>
</div>
	
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
							<div class="widget-header widget-header-blue widget-header-flat wi1dget-header-large">
								<h4 class="lighter">发布活动</h4>
							</div>
							<div class="widget-body">
							 <div class="widget-main">
							 <div class="step-content row-fluid position-relative">
							
		   <div id="zhongxin">
								<textarea name="CONTENT" id="CONTENT" style="display:none" ></textarea>
								<input type="hidden" name="TYPE" id="TYPE" value="2"/>
								<input type="hidden" name="isAll" id="isAll" value="no"/>
								
								<!-- 发布活动填写内容 -->
								
			<table style="width:100%;" id="xtable"  class="table table-striped table-bordered table-hover" >
							<tr>
								<td style="width:140px; text-align: center; font-weight:bold;padding-top: 13px;">
							   <span class="inputStyle">&nbsp;&nbsp;&nbsp;活&nbsp;动&nbsp;&nbsp;名&nbsp;称：</span>	  
							</td>
						    <td>	 
						    <input style="width:50%;" type="text" name="activityName" id="activityName"  value=""  maxlength="32" placeholder="请输入活动名称" title="活动名称"  />
							</td>
							 
						  </tr>
						  <tr>
						   		<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">
						   
							  <span class="inputStyle">&nbsp;&nbsp;&nbsp;活&nbsp;动&nbsp;&nbsp;类&nbsp;别：</span>
							 </td>
							 <td>
							
							   <select  name="activitycategoryId" id="activitycategoryId" data-placeholder="选择活动类别" style="vertical-align:top;width: 200px;line-height: 40px;">
														<option value=""  >---------请选择活动类型---------</option>
														<c:forEach items="${listActivitycategory}" var="u">
																<option value="${u.activitycategoryId}"  >${u.activitycategoryName }</option>
														</c:forEach>	
							  </select>
<!-- 						       <input style="width:50%;" type="text" name="activitycategoryId" id="activitycategoryId"  value=""  maxlength="32" placeholder="请选择活动类别" title="活动类别"  />
 -->						       </td>
						   
						   </tr>
						   <!-- dddd -->
						   <tr>
						   		<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">
						 
							 <span class="inputStyle">&nbsp;&nbsp;&nbsp;活&nbsp;动&nbsp;&nbsp;时&nbsp;间：</span>
							</td>
							<td>
							<span>开始：</span> <input style="width:30%;" type="text" value="" class="datetimepicker" name="activityStartTime" id="activityStartTime"  placeholder="请输入活动开始时间" title="活动开始时间" />
                            <span>结束：</span> <input style="width:30%;" type="text" value="" class="datetimepicker" name="activityEndTime" id="activityEndTime"  placeholder="请输入活动结束时间" title="活动结束时间" />
<!--  							
 <input style="width:50%;" type="datetime-local" name="activityStartTime" id="activityStartTime"  value=""  maxlength="32" placeholder="请输入活动开始时间" title="活动开始时间"  />
 --> 						       </td>
                           </tr>
						 <!--   <tr>
						   		<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">
						   
							    <span class="inputStyle">&nbsp;&nbsp; 活动结束时间：</span>
							</td>
							<td>
							 <input style="width:50%;" type="text" value="" class="datetimepicker" name="activityEndTime" id="activityEndTime"  placeholder="请输入活动结束时间" title="活动结束时间" />
							  
 							  <input style="width:50%;" type="datetime-local" name="activityEndTime" id="activityEndTime"  value=""  maxlength="32" placeholder="请输入活动结束时间" title="活动结束时间"  />
						       </td>
						    </tr> -->
						   
						   
						    
						    <!-- dddd -->
							<tr>
						   		<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">
						   
							 <span class="inputStyle">&nbsp;&nbsp;&nbsp;报&nbsp;名&nbsp;&nbsp;时&nbsp;间：</span>
							</td>
							<td>
							 <span>开始：</span>  <input style="width:30%;" type="text" value="" class="datetimepicker" name="avtivitySignUpStartTime" id="avtivitySignUpStartTime"  placeholder="请输入报名开始时间" title="报名开始时间" />
							 <span>结束：</span>   <input style="width:30%;" type="text" value="" class="datetimepicker" name="avtivitySignUpEndTime" id="avtivitySignUpEndTime"  placeholder="请输入报名结束时间" title="报名结束时间" />
							  
<!--  							    <input style="width:50%;" type="datetime-local" name="avtivitySignUpStartTime" id="avtivitySignUpStartTime"  value=""  maxlength="32"  title="报名开始时间"  />
 --> 						       </td>
						 </tr>
						<!--  <tr>
						   		<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">
						   
							 <span class="inputStyle">&nbsp;&nbsp;    报名结束时间：</span>
						  </td>
						  <td>
							 <input style="width:50%;" type="text" value="" class="datetimepicker" name="avtivitySignUpEndTime" id="avtivitySignUpEndTime"  placeholder="请输入报名结束时间" title="报名结束时间" />
							   
 						 <input style="width:50%;" type="datetime-local" name="avtivitySignUpEndTime" id="avtivitySignUpEndTime"  value=""  maxlength="32"  title="报名结束时间"  />
 						       </td>
						    </tr> -->
						     <!-- dddd -->
							 <tr>
						   		<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">
						  
						
							 <span class="inputStyle">&nbsp;&nbsp;    活&nbsp;动&nbsp;&nbsp;人&nbsp;数：</span>
							  </td>
							  <td>
							  <input style="width:50%;" type="number" name="activitySignUpPersonNumber" id="activitySignUpPersonNumber"  value=""  maxlength="32" placeholder="请输入活动报名人数" title="活动报名人数"  />
						       </td>
					</tr>
					<tr>
					  <td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">						   
							 <span class="inputStyle">&nbsp;&nbsp;&nbsp;活&nbsp;动&nbsp;&nbsp;费&nbsp;用：</span>
							</td>
					 <td>
							 <input style="width:19%;" type="radio" name="activityCostType" id="activityCostType1"   value=""  maxlength="32"  title="费用"  />收费
						     <input style="width:19%;" type="radio" name="activityCostType" id="activityCostType2"   value="2"  checked="checked" maxlength="32"  title="费用"  />免费
						      
					  </td>
						    </tr>
						    <!-- dddd -->
						     <!-- 第二个table -->
						    <!-- 收费项目 -->
						   <table style="width:100%;" id="xtable" class="table table-striped table-bordered table-hover" >
					
						    <tr style="visibility:hidden;" id="showCostProjectInput">
						   		<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">
						   
							 <span class="inputStyle">&nbsp;&nbsp;&nbsp;收&nbsp;费&nbsp;&nbsp;项&nbsp;目：</span>
							 </td>
							 <td>
							 <input style="width:30%;" type="text" name="costProjectmName" id="costProjectmName"  value=""  maxlength="32" placeholder="请输入收费项目" title="收费项目"  />
						    <!--    </td>						
						   		<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;"> -->
							 <input style="width:30%;" type="number" name="costProjectMoney" id="costProjectMoney"  value=""  maxlength="32" placeholder="请输入收费金额" title="收费金额"  />
<!-- 						       <span style="color:red;width:20px;height:20px;font-weight:bolder; border-radius: 10px;background-color: gray;"id="addCostProject">&nbsp;&nbsp;+&nbsp;&nbsp;</span>
 -->						       <button style="border-radius: 20px;font-weight:bolder;" type="button" class="btn btn-primary btn-sm btn-warning" id="addCostProject">+</button>
						       </td>
						    </tr>
						    </table>
						  
						    <!-- 生成收费项目 -->
						     <table style="width:100%;" id="xtable"  class="createCostProjectInput table table-striped table-bordered table-hover" >
						     </table>
						      
						      <!-- 第四个table -->
						     <table style="width:100%;" id="xtable" class="matchArea table table-striped table-bordered table-hover">
						     <!-- dddd -->
							<tr>
						   		<td style="width:170px;text-align: center;font-weight:bold;padding-top: 13px;">
						   
							 <span class="inputStyle">&nbsp;&nbsp;客户匹配区域：</span>
							 </td>
							 <td> 
							 <!--    <span style="">省:</span> -->
							    <select id="pid" name="clientMatchAreaCitycode1" data-placeholder="请选择省">
　                                                                                           　<option value="">请选择省</option>
　　                                                                        </select>
　　                                                                       <!--   <span style="margin-left:-30px;">市:</span> -->
                               <select id="cid" name="clientMatchAreaCitycode2"   data-placeholder="请选择市" >
　　                                                                                             <option value="">请选择市</option>
　　                                                                       </select>
　　　                                                             <!--    <span style="margin-left:-30px;">区县:</span> -->
                                <select id="did" name="clientMatchAreaCitycode3"  data-placeholder="请选择区县">
　                                                                                           　<option value="-1">请选择区县</option>
　　                                                                       </select>
                                     
<!-- 							 <input style="width:50%;" type="text" name="journalismName" id="journalismName"  value=""  maxlength="32" placeholder="请输入活动名称" title="活动名称"  />
 -->						       </td>
                               <tr>
                               <tr>
						<td style="width:170px;text-align: center;font-weight:bold;padding-top: 13px;">						   	  
						      <span class="inputStyle" >&nbsp;&nbsp;设&nbsp;置&nbsp;&nbsp;音&nbsp;乐：</span>
							</td>
							<td>
							  <select  name="activitymusicId" id="activitymusicId" data-placeholder="选择活动音乐类别" style="vertical-align:top;width: 200px;">
														<option value=""  >---------请选择音乐类型---------</option>
														<c:forEach items="${listActivitymusicurl}" var="u">
																<option value="${u.activitymusicId}"  >${u.activitymusicName }</option>
														</c:forEach>	
							  </select>
				    </td>
						   		
						    </tr>
						  </table>
						
						 
						     <!-- dddd -->
						      <table style="width:100%;" id="xtable" class="table table-striped table-bordered table-hover">
						<tr>
						   		<td style="width:65px;text-align: center;font-weight:bold;padding-top: 13px;">						      
						 <span class="inputStyle">&nbsp;&nbsp;&nbsp;&nbsp;	    活&nbsp;动&nbsp;封&nbsp;面&nbsp;图：</span>
						</td>
						<td style="line-height: 40px;">	     
 								<span style="font-family:cursive;">请上传1：1.7比例大小的图片</span>
<!-- 						    <input style="width:50%;" type="text" name="journalismName" id="journalismName"  value=""  maxlength="32" placeholder="请输入活动名称" title="活动名称"  />
 -->					        <span id="showImgContext">
                                <span id="showCoverIng"></span>
                                </span>      
                                <div class="btn btn-mini btn-primary"
							    style="margin-left:600px;margin-top:-80px;" onclick="toImgEdit();">点击上传活动封面图
							    <input type="hidden" name="activity_cover_img" id="activity_cover_img" value="" />
							    </div> 
                        </td>
						  </tr>
						  <tr>
						   		<td style="width:65px;text-align: center;font-weight:bold;padding-top: 13px;">
						   	    
						 <span class="inputStyle" style="line-height: 50px;">&nbsp;分&nbsp;享&nbsp;&nbsp;摘&nbsp;要：</span>
<!-- 						     <input style="width:50%;" type="text" name="shareSummary" id="shareSummary"  value=""  maxlength="32" placeholder="请输入分享摘要" title="分享摘要"  />
 -->					</td>
                        <td>	     
<!--                              <textarea rows="5" cols="25" name="shareSummary" id="shareSummary"  value=""  maxlength="64" placeholder="请输入分享摘要" title="分享摘要" ></textarea>
 -->                           <textarea class="weui_textarea" onkeyup="wordStatic(this);" maxlength="60" id="shareSummary" placeholder="请输入分享摘要(60字之内)" title="分享摘要"  rows="2" cols="60"></textarea>
                           
                            <span class="weui_textarea_counter"><span id="num">0</span>/60</span>
                             </td>
						    </tr>
						     <!-- dddd -->
						    <tr>
						   		<td style="width:65px;text-align: center;font-weight:bold;padding-top: 13px;">
						    
							 <span class="inputStyle">设置邀约提成：</span>
							   </td>
							   <td>
							   <input style="width:19%;" type="radio" name="isInvitationActivityRoyalty" id="isInvitationActivityRoyalty1"  value=""  maxlength="32"  title="是"  />是&nbsp;&nbsp;&nbsp;&nbsp;
						       <input style="width:19%;" type="radio" name="isInvitationActivityRoyalty" id="isInvitationActivityRoyalty2"  value="2" checked="checked" maxlength="32"  title="否"  />否&nbsp;
						      <span class="invitationActivityRoyalty"></span>
						       </td>
						</tr>
						<tr>
						<td style="width:65px;text-align: center;font-weight:bold;padding-top: 13px;">
						   
						 <span class="inputStyle" >活&nbsp;动&nbsp;&nbsp;类&nbsp;型：</span>
						     </td>
						     <td>
						      <input style="width:19%;" type="radio" name="activityOnlineStatus" id="activityOnlineStatus1"  value="1"  checked="checked" maxlength="32"  title="线上"  />线上
						      <input style="width:19%;" type="radio" name="activityOnlineStatus" id="activityOnlineStatus2"  value=""   maxlength="32"  title="线下"  />线下
						        <!-- 线上显示 -->
						       
						    
						       </td>   		
						    </tr>
						      <!-- 提成比列 -->
						   <!--  <table style="width:100%;" id="xtable"   class="invitationActivityRoyalty table table-striped table-bordered table-hover">
						     </table> -->
						      <!-- 在线是生成标签 -->
						     <table style="width:100%;" id="xtable"  class="selectOnlineStatus table table-striped table-bordered table-hover">
						     </table> 
						   <!--  </div> -->
						      
						     
						   </table>
					</table>	
					
					<!-- 填写项目 -->
<!-- 							 可用	<input type="hidden" name="journalism_show_img" id="journalism_show_img" value="" style="margin-left:350px;margin-top:-30px;"/> 
 								<div class="btn btn-mini btn-primary"
							    style="margin-left: 15px;" onclick="toImgEdit();">请上传活动图片
							    </div> -->
								<!-- <span style="font-weight:bold;">新闻图标：</span>	<input type="file" name="journalism_showImg" id="journalism_showImg" value=""/> -->
					<table style="width:100%;margin-left:20px;" id="xtable" >
								
								<tr> 
								<td><span style="font-weight: bolder;font-size: 18px;">编辑活动详情</span></td>
								</tr>
									<tr>
										<td id="nr" style="padding-top: 5px;">
											 <script id="editor" type="text/plain" style="width:96%;height:259px;"></script>
										</td>
									</tr>
					<table style="width:100%; id="xtable" class="table table-striped table-bordered table-hover" >
									<tr>
									<td style="width:140px;text-align: left;font-weight:bold;padding-top: 13px;">
									系统预设报名填写项
									</td>
									<td>
									
									<c:forEach items="${listMustFillTdActivityFillInItem }" var="fill">
									<!-- <tr>
									<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;"> -->
								   <c:if test="${fn:length(fill.fillInItemName)=='2' }">
								   &nbsp;&nbsp;${fill.fillInItemName }&nbsp;&nbsp;/
								   </c:if>
								  <c:if test="${fn:length(fill.fillInItemName)!='2' }">
								   ${fill.fillInItemName }/
								   </c:if>
									
									<%-- <input style="width:50%;" type="text" name="signUpFillName" id="signUpFillName"  value=""  maxlength="32" placeholder="                                                                          系统设定不可修改" 
									title="${fill.fillInItemName }" readonly="readonly" /></td>
									</tr> --%>
									</c:forEach>
									（自动引用活动分享者为邀请人，报名者不可见）
									</td>
									</tr>
									<tr>
									<td style="width:140px;text-align: center;font-weight:bold;padding-top: 13px;">
								   <span>可增加报名填写项</span>
								   </td>
								   <td>
									<input style="width:50%;" type="text" name="signUpOtherFillName" id="signUpOtherFillName"  value=""  maxlength="32" placeholder="请输入其他报名填写信息" 
									title="其他报名填写信息"  />
						       <button style="border-radius: 20px;font-weight:bolder;" type="button" class="btn btn-primary btn-sm btn-success" id="addSignUpOtherFillName">+</button>
									
									<table style="width:100%;margin-left:20px;" id="xtable"  class="addSignUpfillContext">
						        </table>
									
									</td>
									</tr>
								</table>	
								<!-- <table style="width:100%;margin-left:20px;" id="xtable"  class="addSignUpfillContext">
						        </table> -->
								<table style="width:100%;" id="xtable"  >
						      
									<tr>
										<td style="text-align: center;padding-top: 5px;">
											<!-- <a class="btn btn-mini btn-primary btn-success" onclick="sendEm('4');">保存</a>
											<a class="btn btn-mini btn-primary btn-info" onclick="sendEm('0');">发布</a> -->
											<a class="btn btn-mini btn-primary btn-success" onclick="save();">保存</a>
											<a class="btn btn-mini btn-primary btn-info" onclick="pub();">发布</a>
											<label style="float:left;padding-left: 32px;"><input name="form-field-radio" id="form-field-radio1" onclick="setType('1');"  type="hidden" value="icon-edit" class="ace"><span class="lbl"></span></label>
											<label style="float:left;padding-left: 5px;"><input name="form-field-radio" id="form-field-radio2" onclick="setType('2');"  checked="checked" type="radio" value="icon-edit" class="ace" /><span class="lbl">带标签</span></label>
											<!-- <label style="float:left;padding-left: 15px;"><input name="form-field-checkbox" type="checkbox" id="allusers" onclick="isAll();" class="ace" /><span class="lbl">全体用户</span></label> -->
										</td>
									</tr>
									  </table>
						</table>
						
					
		</div>
								<div id="zhongxin2" class="center" style="display:none"><br/><img src="static/images/jzx.gif" id='msg' /><br/><h4 class="lighter block green" id='msg'>正在发送...</h4><strong id="second_shows" class="red">6秒</strong>后关闭</div>
	                            </div> 
							 </div><!--/widget-main-->
							</div><!--/widget-body-->
						</div>
					</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div >
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
<!-- ace scripts -->
<script src="static/ace/js/ace/ace.js"></script>
<!-- 编辑框-->
<script type="text/javascript" charset="utf-8">window.UEDITOR_HOME_URL = "<%=path%>/plugins/ueditor/";</script>
<script type="text/javascript" charset="utf-8" src="plugins/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="plugins/ueditor/ueditor.all.js"></script>
<!-- 编辑框-->
<script src="static/datetimepicker/jquery.js"></script>
<script src="static/datetimepicker/build/jquery.datetimepicker.full.js"></script>
<!-- 下拉框 -->
<script src="static/ace/js/chosen.jquery.js"></script>
<!--提示框-->
<script type="text/javascript" src="static/js/jquery.tips.js"></script>
<!--引入属于此页面的js -->
<script type="text/javascript" src="static/js/myjs/toolOrganizerInfoAddActivity.js"></script>	

<script type="text/javascript">
$(top.hangge());
//保存
function save() {
	
	/* if($("#activityName").val()==""){
		$("#activityName").tips({
			side:3,
            msg:'请输入活动名称',
            bg:'#AE81FF',
            time:2
        });
		$("#activityName").focus();
		return false;
	} */
	sendEm('4');
}
function pub() {

	if($("#activityName").val()==""){
		$("#activityName").tips({
			side:3,
            msg:'请输入活动名称',
            bg:'#AE81FF',
            time:2
        });
		$("#activityName").focus();
		return false;
	}
	if($("#activitycategoryId").val()==""){
		$("#activitycategoryId").tips({
			side:3,
            msg:'请选择活动类别',
            bg:'#AE81FF',
            time:2
        });
		$("#activitycategoryId").focus();
		return false;
	}
	//活动开始结束时间
	if($("#activityStartTime").val()==""){
		$("#activityStartTime").tips({
			side:3,
            msg:'请选择活动开始时间',
            bg:'#AE81FF',
            time:2
        });
		$("#activityStartTime").focus();
		return false;
	}

	if($("#activityEndTime").val()==""){
		$("#activityEndTime").tips({
			side:3,
            msg:'请选择活动结束时间',
            bg:'#AE81FF',
            time:2
        });
		$("#activityEndTime").focus();
		return false;
	}
	//活动报名开始结束时间
	if($("#avtivitySignUpStartTime").val()==""){
		$("#avtivitySignUpStartTime").tips({
			side:3,
            msg:'请选择活动报名时间',
            bg:'#AE81FF',
            time:2
        });
		$("#avtivitySignUpStartTime").focus();
		return false;
	}
	if($("#avtivitySignUpEndTime").val()==""){
		$("#avtivitySignUpEndTime").tips({
			side:3,
            msg:'请选择活动报名结束时间',
            bg:'#AE81FF',
            time:2
        });
		$("#avtivitySignUpEndTime").focus();
		return false;
	}
	//活动开始时间
	var aStartT = $("#activityStartTime").val().split("/");
	var finalASTime = aStartT[0]+"-"+aStartT[1]+"-"+aStartT[2]+":00";
	var longAStartTime = new Date(finalASTime).getTime();
	//活动结束时间
	var aEndT = $("#activityEndTime").val().split("/");
	var finaAETime = aEndT[0]+"-"+aEndT[1]+"-"+aEndT[2]+":00";
	var longAEndTime = new Date(finaAETime).getTime();
	//报名开始时间
	var aSST = $("#avtivitySignUpStartTime").val().split("/");
	var finaSsTime = aSST[0]+"-"+aSST[1]+"-"+aSST[2]+":00";
	var longSStartTime = new Date(finaSsTime).getTime();
	//报名结束时间
	var aSET = $("#avtivitySignUpEndTime").val().split("/");
	var finaSETime = aSET[0]+"-"+aSET[1]+"-"+aSET[2]+":00";
	var longSEndTime = new Date(finaSETime).getTime();
	//当前时间
	var curTime = new Date().getTime();
	
	if(longAStartTime<curTime){
		$("#activityStartTime").tips({
			side:3,
            msg:'活动开始时间不能小于当前时间',
            bg:'#AE81FF',
            time:5
        });
		$("#activityStartTime").focus();
		return false;
	}
	if(longAStartTime>=longAEndTime){
		$("#activityStartTime").tips({
			side:3,
            msg:'活动开始时间不能大于等于活动结束时间',
            bg:'#AE81FF',
            time:5
        });
		$("#activityStartTime").focus();
		return false;
	}
	if(longSStartTime<curTime){
		$("#avtivitySignUpStartTime").tips({
			side:3,
            msg:'报名开始时间不能小于当前时间',
            bg:'#AE81FF',
            time:5
        });
		$("#avtivitySignUpStartTime").focus();
		return false;
	}
	if(longSStartTime>longAEndTime
	){
		$("#avtivitySignUpStartTime").tips({
			side:3,
            msg:'报名开始时间不能大于活动结束时间',
            bg:'#AE81FF',
            time:5
        });
		$("#avtivitySignUpStartTime").focus();
		return false;
	}
	if(longSEndTime>longAEndTime){
		$("#avtivitySignUpEndTime").tips({
			side:3,
            msg:'报名结束时间不能大于活动结束时间',
            bg:'#AE81FF',
            time:5
        });
		$("#avtivitySignUpEndTime").focus();
		return false;
	}
	if(longSStartTime>longSEndTime){
		$("#avtivitySignUpEndTime").tips({
			side:3,
            msg:'报名开始时间不能大于报名结束时间',
            bg:'#AE81FF',
            time:5
        });
		$("#avtivitySignUpEndTime").focus();
		return false;
	}
	/* alert("cur"+curTime);
	alert("as"+longAStartTime);
	alert("ae"+longAEndTime);
	alert("ss"+longSStartTime);
	alert("se"+longSEndTime); */
	
	//活动报名人数
	if($("#activitySignUpPersonNumber").val()==""){
		$("#activitySignUpPersonNumber").tips({
			side:3,
            msg:'请输入活动报名人数',
            bg:'#AE81FF',
            time:2
        });
		$("#activitySignUpPersonNumber").focus();
		return false;
	}else if($("#activitySignUpPersonNumber").val()<=0){
		$("#activitySignUpPersonNumber").tips({
			side:3,
            msg:'请输入正确的报名人数',
            bg:'#AE81FF',
            time:2
        });
		$("#activitySignUpPersonNumber").focus();
		return false;
	}
	//收费项目
	
	if($("#activityCostType1").val()==1){
		
		if($("#costProjectmName").val()==""){
			$("#costProjectmName").tips({
				side:3,
	            msg:'请输入收费项目名称',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#costProjectmName").focus();
			return false;
		}
		if($("#costProjectMoney").val()==""){
			$("#costProjectMoney").tips({
				side:3,
	            msg:'请输入项目收费金额',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#costProjectMoney").focus();
			return false;
		}else if($("#costProjectMoney").val()<0){
			$("#costProjectMoney").tips({
				side:3,
	            msg:'请输入项目正确收费金额',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#costProjectMoney").focus();
			return false;
		}
	}
	//客户匹配区域
	
	if($("#pid").val()==""){
		$("#pid").tips({
			side:3,
            msg:'选择省',
            bg:'#AE81FF',
            time:2
        });
		$("#pid").focus();
		return false;
	}
	if($("#pid").val()=="-1"){
		$("#pid").val()=="000000";
	}
	if($("#cid").val()==""||$("#cid").val()=="-1"){
		$("#cid").val()=="000000";
	}
    if($("#did").val()==""||$("#did").val()=="-1"){
    	$("#did").val()=="000000";
	}
	//上传活动封面图
	if($("#activity_cover_img").val()==""){
		$("#activity_cover_img").tips({
			side:3,
            msg:'请上传活动封面图',
            bg:'#AE81FF',
            time:2
        });
		$("#activity_cover_img").focus();
		return false;
	}
	//分享摘要
	if($("#shareSummary").val()==""){
		$("#shareSummary").tips({
			side:3,
            msg:'请输入分享摘要',
            bg:'#AE81FF',
            time:2
        });
		$("#shareSummary").focus();
		return false;
	}
	
	
	//设置邀约提成  是
if($("#isInvitationActivityRoyalty1").val()==1){
	
	
		if($("#invitationActivityRoyaltyRate").val()==""){
			$("#invitationActivityRoyaltyRate").tips({
				side:3,
	            msg:'请输入活动提成比例',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#invitationActivityRoyaltyRate").focus();
			return false;
		}
		if($("#invitationActivityRoyaltyRate").val()<0||$("#invitationActivityRoyaltyRate").val()>=100){
			$("#invitationActivityRoyaltyRate").tips({
				side:3,
	            msg:'请输入正确的提成百分比',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#invitationActivityRoyaltyRate").focus();
			return false;
		}
		
	}
//活动类型判断，2为线下
if($("#activityOnlineStatus2").val()==2){
	if($("#pid2").val()==""||$("#pid2").val()=="-1"){
		$("#pid2").tips({
			side:3,
            msg:'选择省',
            bg:'#AE81FF',
            time:2
        });
		$("#pid2").focus();
		return false;
	}
	if($("#cid2").val()==""||$("#cid2").val()=="-1"){
		$("#cid2").tips({
			side:3,
            msg:'选择市',
            bg:'#AE81FF',
            time:2
        });
		$("#cid2").focus();
		return false;
	}
	if($("#did2").val()==""||$("#did2").val()=="-1"){
		$("#did2").tips({
			side:3,
            msg:'选择区县',
            bg:'#AE81FF',
            time:2
        });
		$("#did2").focus();
		return false;
	}
		if($("#detailedAddress").val()==""){
			$("#detailedAddress").tips({
				side:3,
	            msg:'请输入活动详细地址',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#detailedAddress").focus();
			return false;
		}
		
	}	

	sendEm('0');
}
//时间插件
$.datetimepicker.setLocale('ch');

$('#datetimepicker_format').datetimepicker({value:'2019/01/01 00:00', format: $("#datetimepicker_format_value").val()});
console.log($('#datetimepicker_format').datetimepicker('getValue'));

$("#datetimepicker_format_change").on("click", function(e){
	$("#datetimepicker_format").data('xdsoft_datetimepicker').setOptions({format: $("#datetimepicker_format_value").val()});
});
$("#datetimepicker_format_locale").on("change", function(e){
	$.datetimepicker.setLocale($(e.currentTarget).val());
});

$('.datetimepicker').datetimepicker({
dayOfWeekStart : 1,
lang:'en',
disabledDates:['1986/01/08','1986/01/09','1986/01/10'],
startDate:	'2019/01/01'
});
$('.datetimepicker').datetimepicker({value:'2019/01/01 00:00',step:10});

$('.some_class').datetimepicker();

$('#default_datetimepicker').datetimepicker({
	formatTime:'H:i',
	formatDate:'d.m.Y',
	//defaultDate:'8.12.1986', // it's my birthday
	defaultDate:'+03.01.1970', // it's my birthday
	defaultTime:'10:00',
	timepickerScrollbar:false
});

$('#datetimepicker10').datetimepicker({
	step:5,
	inline:true
});
$('#datetimepicker_mask').datetimepicker({
	mask:'9999/19/39 29:59'
});

$('#datetimepicker1').datetimepicker({
	datepicker:false,
	format:'H:i',
	step:5
});
$('#datetimepicker2').datetimepicker({
	yearOffset:222,
	lang:'ch',
	timepicker:false,
	format:'d/m/Y',
	formatDate:'Y/m/d',
	minDate:'-1970/01/02', // yesterday is minimum date
	maxDate:'+1970/01/02' // and tommorow is maximum date calendar
});
$('#datetimepicker3').datetimepicker({
	inline:true
});
$('#datetimepicker4').datetimepicker();
$('#open').click(function(){
	$('#datetimepicker4').datetimepicker('show');
});
$('#close').click(function(){
	$('#datetimepicker4').datetimepicker('hide');
});
$('#reset').click(function(){
	$('#datetimepicker4').datetimepicker('reset');
});
$('#datetimepicker5').datetimepicker({
	datepicker:false,
	allowTimes:['12:00','13:00','15:00','17:00','17:05','17:20','19:00','20:00'],
	step:5
});
$('#datetimepicker6').datetimepicker();
$('#destroy').click(function(){
	if( $('#datetimepicker6').data('xdsoft_datetimepicker') ){
		$('#datetimepicker6').datetimepicker('destroy');
		this.value = 'create';
	}else{
		$('#datetimepicker6').datetimepicker();
		this.value = 'destroy';
	}
});
var logic = function( currentDateTime ){
	if (currentDateTime && currentDateTime.getDay() == 6){
		this.setOptions({
			minTime:'11:00'
		});
	}else
		this.setOptions({
			minTime:'8:00'
		});
};
$('#datetimepicker7').datetimepicker({
	onChangeDateTime:logic,
	onShow:logic
});
$('#datetimepicker8').datetimepicker({
	onGenerate:function( ct ){
		$(this).find('.xdsoft_date')
			.toggleClass('xdsoft_disabled');
	},
	minDate:'-1970/01/2',
	maxDate:'+1970/01/2',
	timepicker:false
});
$('#datetimepicker9').datetimepicker({
	onGenerate:function( ct ){
		$(this).find('.xdsoft_date.xdsoft_weekend')
			.addClass('xdsoft_disabled');
	},
	weekends:['01.01.2014','02.01.2014','03.01.2014','04.01.2014','05.01.2014','06.01.2014'],
	timepicker:false
});
var dateToDisable = new Date();
	dateToDisable.setDate(dateToDisable.getDate() + 2);
$('#datetimepicker11').datetimepicker({
	beforeShowDay: function(date) {
		if (date.getMonth() == dateToDisable.getMonth() && date.getDate() == dateToDisable.getDate()) {
			return [false, ""]
		}

		return [true, ""];
	}
});
$('#datetimepicker12').datetimepicker({
	beforeShowDay: function(date) {
		if (date.getMonth() == dateToDisable.getMonth() && date.getDate() == dateToDisable.getDate()) {
			return [true, "custom-date-style"];
		}

		return [true, ""];
	}
});
$('#datetimepicker_dark').datetimepicker({theme:'dark'})
//时间插件
function wordStatic(input) {
    // 获取要显示已经输入字数文本框对象
    var content = document.getElementById('num');
    if (content && input) {
        // 获取输入框输入内容长度并更新到界面
        var value = input.value;
        // 将换行符不计算为单词数
        value = value.replace(/\n|\r/gi,"");
        // 更新计数
        content .innerText = value.length;
    }
}

//客户匹配区域，省市县
$(function(){
　　$.ajax({
　　type:"post",
　　url: "<%=basePath%>tdAddress/province.do?time="+Math.random(),
　　dataType:"json",//指定返回的格式
　　success:function(data){
	
	$("<option value='000000'>全部</option>").appendTo($("#pid"));//添加下拉列表
     for(var i=0;i<data.length;i++){

　　　　var pid=data[i].citycode//返回对象的一个属性
　　　　var pname=data[i].cityname;

　　　　$("<option value='"+pid+"'>"+pname+"</option>").appendTo($("#pid"));//添加下拉列表
　　}
}
});
//客户匹配区域，省市县
$(function(){
　　$("#pid").change(function(){
　　//清空下面两个子下拉列表(option中value值大于0的删除)
　　$("#cid option:gt(0)").remove();
　　$("#did option:gt(0)").remove();

　　if($("#pid").val()==-1){
　　return;//没有选择的就不去调用
}
//使用post方式
//客户匹配区域，省市县
  $.post(
　　　　"<%=basePath%>tdAddress/city.do?time="+Math.random(),
　　　　{"pid":$("#pid").val()},//参数
　　　　function(data){
　　　　$("<option value='000000'>全部</option>").appendTo($("#cid"));//添加下拉列表

　　　　for(var i=0;i<data.length;i++){
　　　　var cid=data[i].citycode;
　　　　var cname=data[i].cityname;
　　　　$("<option value='"+cid+"'>"+cname+"</option>").appendTo($("#cid"));//添加下拉列表
　　}
},
　　"json"//指定返回类型
　　);
}); 
});
//客户匹配区域，省市县
$(function(){
　　$("#cid").change(function(){
　　$("#did option:gt(0)").remove();
　　if($("#cid").val()==-1){
　　　　return;
　　}
　　$.getJSON(//这种访问方式返回的就是JSON格式数据
　　"<%=basePath%>tdAddress/district.do?time="+Math.random(),
　　{"cid":$("#cid").val()},
　　function(data){
　　　　$("<option value='000000'>全部</option>").appendTo($("#did"));

　　　　for(var i=0;i<data.length;i++){
　　　　var did=data[i].citycode;
　　　　var dname=data[i].cityname;
　　　　$("<option value='"+did+"'>"+dname+"</option>").appendTo($("#did"));
　　}
}
);
});
});
});


//匹配区域
function matchArea(){

/* $(function(){ */
　　$.ajax({
　　type:"post",
　　url: "<%=basePath%>tdAddress/province.do?time="+Math.random(),
　　dataType:"json",//指定返回的格式
　　success:function(data){
	
     for(var i=0;i<data.length;i++){

　　　　var pid=data[i].citycode//返回对象的一个属性
　　　　var pname=data[i].cityname;
　　　　$("<option value='"+pid+"'>"+pname+"</option>").appendTo($("#pid2"));//添加下拉列表
　　}
}
});
//匹配区域，省市县
$(function(){
　　$("#pid2").change(function(){
　　//清空下面两个子下拉列表(option中value值大于0的删除)
　　$("#cid2 option:gt(0)").remove();
　　$("#did2 option:gt(0)").remove();

　　if($("#pid2").val()==-1){
　　return;//没有选择的就不去调用
}
//使用post方式
//匹配区域，省市县
  $.post(
　　　　"<%=basePath%>tdAddress/city.do?time="+Math.random(),
　　　　{"pid":$("#pid2").val()},//参数
　　　　function(data){
　　　　for(var i=0;i<data.length;i++){
　　　　var cid=data[i].citycode;
　　　　var cname=data[i].cityname;
　　　　$("<option value='"+cid+"'>"+cname+"</option>").appendTo($("#cid2"));//添加下拉列表
　　}
},
　　"json"//指定返回类型
　　);
}); 
});
//匹配区域，省市县
$(function(){
　　$("#cid2").change(function(){
　　$("#did2 option:gt(0)").remove();
　　if($("#cid2").val()==-1){
　　　　return;
　　}
　　$.getJSON(//这种访问方式返回的就是JSON格式数据
　　"<%=basePath%>tdAddress/district.do?time="+Math.random(),
　　{"cid":$("#cid2").val()},
　　function(data){
　　　　for(var i=0;i<data.length;i++){
　　　　var did=data[i].citycode;
　　　　var dname=data[i].cityname;
　　　　$("<option value='"+did+"'>"+dname+"</option>").appendTo($("#did2"));
　　}
}
);
});
});
};
/* }); */ 

var j=1;
//添加报名填写项目

$("#addSignUpOtherFillName").click(function () {
	
	if($("#signUpOtherFillName").val()==""){
		$("#signUpOtherFillName").tips({
			side:3,
            msg:'请输入其他填写想信息',
            bg:'#AE81FF',
            time:2
        });
		$("#signUpOtherFillName").focus();
		return false;
	}
	var m = j-1;
	if($("#signUpOtherFillName"+m).val()==""){
		$("#signUpOtherFillName"+m).tips({
			side:3,
            msg:'请输入其他填写想信息',
            bg:'#AE81FF',
            time:2
        });
		$("#signUpOtherFillName"+m).focus();
		return false;
	}
	var createTr = $("<tr>");
	createTr.attr({"id":"removOtherFill"+j});
	var createTd = $("<td>");
	createTd.css({"width":"140px","text-align":"center","font-weight":"bold","padding-top":"13px"});
	var createInput = $("<input>");
	createInput.css({"width":"50%"});
	createInput.attr({"type":"text","name":"signUpOtherFillName"+j,"id":"signUpOtherFillName"+j,"value":"","maxlength":"32","placeholder":"请输入其他报名填写信息","title":"其他报名填写信息"});
	var createButton = $("<button>");
	createButton.css({"border-radius":"20px","font-weight":"bolder"});
	createButton.attr({"type":"button","class":"btn btn-primary btn-sm btn-danger","id":"removeSignUpOtherFillNames"+j,"onClick":"removeOtherFills("+j+")"});
	createButton.text("-");
	
	createTd.append(createInput);
	createTd.append(createButton);
	createTr.append(createTd);
	
	$(".addSignUpfillContext").append(createTr);
	$(".addSignUpfillContext").css({"margin-left":"-180px"});
	//统计添加了几个其他填写项目
	$("#createInputCountSumOther").remove();
	var createInputCountSumOther= $("<input>");
	createInputCountSumOther.attr({"type":"hidden","name":"createInputCountSumOther","id":"createInputCountSumOther","value":""+j});
	
    $("#zhongxin").append(createInputCountSumOther);
     j=j+1;
});
//去除其他填写项
function removeOtherFills(num) {
		
		
		$("#removOtherFill"+num).remove();			
	
}

  var isInvitation = 0;
  
//是否设置邀请人成交活动提成

	
$("#isInvitationActivityRoyalty1").click(function () {
	if(isInvitation==0){
	$("#isInvitationActivityRoyalty1").attr({"value":"1"});
	$("#isInvitationActivityRoyalty2").attr({"value":""});

/* 	var createTr = $("<tr>");
	createTr.attr({"id":"removeInvitationActivityRoyalty"});
	var createTd1 = $("<td>");
	createTd1.css({"width":"140px","text-align":"center","font-weight":"bold","padding-top":"13px"});
	createTd1.text("提     成     比     例：");
	var createInput = $("<input>");
	createInput.css({"width":"100px;"});
    createInput.attr({"type":"number","name":"invitationActivityRoyaltyRate","id":"invitationActivityRoyaltyRate","required":"required","maxlength":"32","placeholder":"请输入提成","title":"提成比例"});
    var createSpan =$("<span>");
    createSpan.text("%"); */
    var createContext =  $("<span>");
    createContext.css({"margin-left":"30px"});
    createContext.attr({"id":"removeInvitationActivityRoyalty"});
    var createSpan1 = $("<span>");
    createSpan1.text("提     成     比     例：");
    var createInput = $("<input>");
	createInput.css({"width":"100px;"});
    createInput.attr({"type":"number","name":"invitationActivityRoyaltyRate","id":"invitationActivityRoyaltyRate","required":"required","maxlength":"32","placeholder":"请输入提成","title":"提成比例"});
    var createSpan2 = $("<span>");
    createSpan2.text("%");
    //填充td
    /* var createTd2 = $("<td>");
	createTd2.css({"width":"140px","text-align":"center","font-weight":"bold","padding-top":"13px"});
	var createInput2 = $("<input>");
	createInput2.css({"width":"50%"});
    createInput2.attr({"type":"hidden","name":"no","maxlength":"32","title":"无用填充输入框"});
    */
    
/* 	createTd1.append(createInput);
    createTd1.append(createSpan); */
	/* createTd2.append(createInput2); */
/* 	createTr.append(createTd1); */
	/* createTr.append(createTd2); */

	createContext.append(createSpan1);
	createContext.append(createInput);
	createContext.append(createSpan2);
	$(".invitationActivityRoyalty").append(createContext);
	 isInvitation = 1;
}
});
$("#isInvitationActivityRoyalty2").click(function () {
	$("#isInvitationActivityRoyalty1").attr({"value":""});
	$("#isInvitationActivityRoyalty2").attr({"value":"2"});
	
	$("#removeInvitationActivityRoyalty").remove();
	 isInvitation = 0;
});
//在线状态：线下

var isOnline = 0;
$("#activityOnlineStatus2").click(function () {
	/* $("#showOnlineStatus").css({"visibility":"visible"}); */
	if(isOnline==0){
		
	
	$("#activityOnlineStatus1").attr({"value":""});
	$("#activityOnlineStatus2").attr({"value":"2"});

	var createTr =$("<tr>");
	createTr.attr({"id":"removeActivityOnlineStatus"});
	var createTd1 =$("<td>");
	createTd1.css({"width":"140px","text-align":"center","font-weight":"bold","padding-top":"13px"});
	createTd1.text("活    动    区    域：");
	 var createBr1 = $("<br/>");
	
	var createSelect1P = $("<select>");
	createSelect1P.attr({"id":"pid2","name":"activityAreaCitycode1"});
	var createOption1P = $("<option>");
	createOption1P.attr({"value":""});
	createOption1P.text("请选择省");
	
	var createSelect1C = $("<select>");
	createSelect1C.css({"margin-left":"40px"});
	createSelect1C.attr({"id":"cid2","name":"activityAreaCitycode2"});
	var createOption1C = $("<option>");
	createOption1C.attr({"value":""});
	createOption1C.text("请选择市");
	
	var createSelect1D = $("<select>");
	createSelect1D.css({"margin-left":"40px"});
	createSelect1D.attr({"id":"did2","name":"activityAreaCitycode3"});
	var createOption1D = $("<option>");
	createOption1D.attr({"value":""});
	createOption1D.text("请选择区县");
	
	var createTd2 = $("<td>");
	createTd2.css({"width":"140px","text-align":"center","font-weight":"bold","padding-top":"13px"});
	createTd2.text("详    细     地     址");
	var createInput2 = $("<input>");
	createInput2.css({"width":"50%"});
	createInput2.attr({"type":"text","name":"detailedAddress","id":"detailedAddress","value":"","maxlength":"32","placeholder":"请输入详细地址","title":"详细地址"});
	
	createTd1.append(createBr1);
	createSelect1P.append(createOption1P);
	createTd1.append(createSelect1P);
	createSelect1C.append(createOption1C);
	createTd1.append(createSelect1C);
	createSelect1D.append(createOption1D);
	createTd1.append(createSelect1D);
	
	createTd2.append(createInput2);
	createTr.append(createTd1);
	createTr.append(createTd2);
	$(".selectOnlineStatus").append(createTr);
	matchArea();
	selectFocus();
	isOnline=1;

	}
});
/* $("#pid2").blur( */
function selectFocus() { 
	
	if($("#pid2").val()==""){
		$("#pid2").tips({
			side:3,
            msg:'请选择省',
            bg:'#AE81FF',
            time:2
        });
		$("#pid2").focus();
		return false;
	}
	if($("#pid2").val()!=""){
	if($("#cid2").val()==""){
		$("#cid2").tips({
			side:3,
            msg:'请选择市',
            bg:'#AE81FF',
          /*   time:2 */
        });
		$("#cid2").focus();
		return false;
	}
	if($("#did2").val()==""){
		$("#did2").tips({
			side:3,
            msg:'请选择区县',
            bg:'#AE81FF',
           /*  time:2 */
        });
		$("#did2").focus();
		return false;
	}
	}
	
 }
/*  ) */
 ; 
 
//线下
$("#activityOnlineStatus1").click(function () {
	/* $("#showOnlineStatus").css({"visibility":"hidden"}); */
	$("#activityOnlineStatus1").attr({"value":"1"});
	$("#activityOnlineStatus2").attr({"value":""});
	$("#removeActivityOnlineStatus").remove();
	isOnline=0;
});
	$(top.hangge());
	//显示收费项目
	$("#activityCostType1").click(function() {
		$("#activityCostType1").attr({"value":"1"});
		$("#activityCostType2").attr({"value":""});
		
		//inline-block
		$("#showCostProjectInput").css("visibility","visible");
		 $(".matchArea").css({"margin-top":"0px"});	
	});
	var i=1;
	//免费：隐藏收费项目
	$("#activityCostType2").click(function() {
		$("#activityCostType1").attr({"value":""});
		$("#activityCostType2").attr({"value":"2"});
	
		
		for(var a=i;a>0;a--){
			
		$("#createTr"+a).remove();
		}
		 $(".matchArea").css({"margin-top":"-100px"});
/* 	$(".createCostProjectInput").css({"visibility":"hidden"}); 
 */
	$("#showCostProjectInput").css("visibility","hidden"); 
	 i=1;
	});
	
	//添加收费项目
	$("#addCostProject").click(function() {
		if($("#costProjectmName").val()==""){
			$("#costProjectmName").tips({
				side:3,
	            msg:'请输入活动收费项目',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#costProjectmName").focus();
			return false;
		}
		 if($("#costProjectMoney").val()==""){
			$("#costProjectMoney").tips({
				side:3,
	            msg:'请输入活动收费金额',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#costProjectMoney").focus();
			return false;
		}else if($("#costProjectMoney").val()<0){
			$("#costProjectMoney").tips({
				side:3,
	            msg:'请输入活动正确收费金额',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#costProjectMoney").focus();
			return false;
		}
		var m=i-1;
		if($("#costProjectmName"+m).val()==""){
			$("#costProjectmName"+m).tips({
				side:3,
	            msg:'请输入活动收费项目',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#costProjectmName"+m).focus();
			return false;
		}
		if($("#costProjectMoney"+m).val()==""){
			$("#costProjectMoney"+m).tips({
				side:3,
	            msg:'请输入活动收费金额',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#costProjectMoney"+m).focus();
			return false;
		}else if($("#costProjectMoney"+m).val()<0){
			$("#costProjectMoney"+m).tips({
				side:3,
	            msg:'请输入活动正确收费金额',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#costProjectMoney"+m).focus();
			return false;
		}
		
		
		$(".createCostProjectInput").css({"visibility":"visible"}); 
		/* $(".createCostProjectInput").attr({"class":"table table-striped table-bordered table-hover"}); */
		var createTr = $("<tr>");
		/* createTr.css({"width":"1000px"}); */
		createTr.attr({"id":"createTr"+i});
		//第一个td
		var createTd1 = $("<td>");
		createTd1.css({"width":"170px","text-align":"center","font-weight":"bold","padding-top":"13px","font-size":"18px","font-family":"cursive"});
		createTd1.text(" 收     费     项     目   :");
		//第一个input
		var createInput1 = $("<input>");
		createInput1.css({"width":"30%","margin-left":"-260px"});
 		createInput1.attr({"type":"text","name":"costProjectmName"+i,"required":"required","maxlength":"32",
 			"placeholder":"请输入收费项目名称","title":"项目费用名称","id":"costProjectmName"+i});
		//第二个td
 		var createTd2 = $("<td>");
		createTd2.css({"text-align":"center","font-weight":"bold","padding-top":"13px"});
		//第二个input
		var createInput2 = $("<input>");
		createInput2.css({"width":"30%","margin-left":"5px"});
 		createInput2.attr({"type":"number","name":"costProjectmMoney"+i,"required":"required","maxlength":"32",
 			"placeholder":"请输入收费项目费用","title":"项目费用","id":"costProjectMoney"+i});
		//按钮
 		var createButton = $("<button>");
		createButton.text("-");
		createButton.css({"border-radius":"20px","font-weight":"bolder"});
		createButton.attr({"class":"btn btn-primary btn-sm btn-danger","type":"button","id":"removeCostProject"+i,"onClick":"removeCostProject("+i+")"});
		
	
		
		/* createTd1.append(createInput1); */
		createTr.append(createTd1);
		createTd2.append(createInput1);
		createTd2.append(createInput2);
		createTd2.append(createButton);
		createTr.append(createTd2);
		
		$(".createCostProjectInput").append(createTr);
		//统计生成了几个收费项目
		$("#createInputCountSum").remove();
		var createInputCountSum = $("<input>");
		createInputCountSum.attr({"type":"hidden","name":"createInputCountSum","id":"createInputCountSum","value":""+i});
		$("#zhongxin").append(createInputCountSum);
		
		i = i+1;

	}); 
	//删除活动项目
	/* $("#removeCostProject").click(function () {
		
	}) */
	
	 if($("#activityCostType2").val()=="2"){
		 $(".matchArea").css({"margin-top":"-100px"});
	};
	function removeCostProject(num) {
	
		$("#createTr"+num).remove();			
	
	}
	
	


	function toImgEdit() {
		
		 top.jzts();
		 var diag = new top.Dialog();
		 diag.Drag=true;
		 diag.Title ="新增";
		 diag.URL = '<%=basePath%>page/system/activity/pubActivityOrganizerInfoPhoto_edit';
		 diag.Width = 800;
		 diag.Height = 900;
		 diag.Modal = true;				//有无遮罩窗口
		 diag. ShowMaxButton = true;	//最大化按钮
	     diag.ShowMinButton = true;		//最小化按钮
		 diag.CancelEvent = function(){ //关闭事件
		var	pdtMinImg=localStorage.getItem("pdtMinImg");
		
	/* 	var strs1= new Array(); //定义一数组
		strs1=pdtMinImgs.split(","); */
		
			/*  if(pdtMinImg!=1){
				 localStorage.setItem("pdtMinImg","1"+pdtMinImg); 
		        var strs= new Array(); //定义一数组
				strs=pdtMinImg.split(",");		
				buzhidao.imgUrl.push(strs[0]);
				var img =  $("#journalism_showImg").val(strs[0]);
				
			
				diag.close();
			 }else{ */
			    diag.close();
				var strs= new Array(); //定义一数组
				strs=pdtMinImg.split(",");
				var img =  $("#activity_cover_img").val(strs[0]);
				//1图片内容显示
			
				$("#showCoverIng").remove();
				//2生成span容器
				var createSpan = $("<span>");
				createSpan.attr({"id":"showCoverIng"});
				var coverImgShow = $("<img>");
				coverImgShow.attr({"alt":"封面图","width":"200px","src":"http://fb.yxl58.com/"+strs[0]});
				
				createSpan.append(coverImgShow);
				
				$("#showImgContext").append(createSpan);
				/*  }   */
			 };
		 diag.show();
	}
</script>
</body>
</html>