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
						<div class="content pb0">
	<!-- Info boxes -->
	<!-- <div class="row">
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-aqua"><i class="fa fa-cog"></i></span>
				<div class="info-box-content">
					 <span class="info-box-text">钻石客户经理</span>
					<span class="info-box-number">90<small></small></span> 
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-red"><i class="fa fa-google-plus"></i></span>
				<div class="info-box-content">
					<span class="info-box-text">未激活用户数量</span>
					<span class="info-box-number">41,410</span>
				</div>
			</div>
		</div>

		fix for small devices only
		<div class="clearfix visible-sm-block"></div>

		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-green"><i class="fa fa-internet-explorer"></i></span>
				<div class="info-box-content">
					<span class="info-box-text">VIP客户经理</span>
					<span class="info-box-number">760</span>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-yellow"><i class="fa fa-users"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">新用户</span>
					<span class="info-box-number">2,000</span>
				</div>
			</div>
		</div>
	</div> -->
	<!-- Chart boxes -->
	<div class="row">
		<div class="col-md-12"  >
			<div class="box box-widget" >
				<div class="box-header with-border" >
					<h3 class="box-title">
					<form action="financialStatements/goListFinancialStatements.do" name="form1" id="form1"  method="post">
					<input type="number" value="${pd.yearNumber }" id="yearNumber" name="yearNumber" style="border:none;width:100px;height:60px;font-size: 25px;font-weight: bold;">
					<button class="btn btn-mini">查询</button>
					财务报告					 
					</form>
					</h3>
					<div style="margin-left:300px;margin-top:-70px;float:left;">
					<span class="description-percentage text-red"> </span>
					<h3 class="description-header"  ><span class="description-text" >年总利润</span><span style="color:red;">￥ ${totalProfitCountByYear }</span></h3>							  
					</div>
					<div style="margin-left:500px;margin-top:-60px;">
					<span class="description-percentage text-red"> </span>					
					<h3 class="description-header" ><span class="description-text" >平台总盈利</span><span style="color:red;">￥ ${totalProfitCountByYear }</span></h3>								  
					</div>
					<!-- <div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool" data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						 <div class="btn-group">
							<button type="button" class="btn btn-box-tool dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-wrench"></i></button>
							 <ul class="dropdown-menu" role="menu">
								<li><a href="#">导出Excel</a></li>
								<li><a href="#">导出Word</a></li>
								<li class="divider"></li>
								<li><a href="#">基本设置</a></li>
							</ul> 
						</div> 
						<button type="button" class="btn btn-box-tool" data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div> -->
				</div>
				<div class="box-body" >
					<div class="row">
						<div class="col-md-8">
							<div class="chart">
								<div id="myChart" style="height:230px;width:99%"></div>
								<script src="http://echarts.baidu.com/dist/echarts.common.min.js"></script>
								<script>
									var option = {
									    title : {
									        text: ''
									    },
									    tooltip : {
									        trigger: 'axis'
									      
									    },
									    legend: {
									        data:['总收入','总支出','助创基金','合伙人分红']
									    },
									    toolbox: {
									        show : true,
									        feature : {
									            mark : {show: true},
									            dataView : {show: true, readOnly: false},
									            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
									            restore : {show: true},
									            saveAsImage : {show: true}
									        }
									    },
									    calculable : true,
									    grid : {
									    	top: '49',
									    	right: '20',
									    	bottom: '30'
									    },
									    xAxis : [
									        {
									            type : 'category',
									            boundaryGap : false,
									            data : ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
									        }
									    ],
									    yAxis : [
									        {
									            type : 'value'
									        }
									    ],
									    series : [
									        {
									            name:'助创基金',
									            type:'line',
									            smooth:true,
									            itemStyle: {normal: {areaStyle: {type: 'default'}}},
									            data:[
									            	  <c:forEach items="${financialAidFundInputs}" var="ts">
											            ${ts},
											            </c:forEach>
									            ]
									        },
									        {
									            name:'总支出',
									            type:'line',
									            smooth:true,
									            itemStyle: {normal: {areaStyle: {type: 'default'}}},
									            data:[
									            	 <c:forEach items="${financialBackgroundOuts}" var="ts">
											            ${ts},
											            </c:forEach>
									            ]
									        },
									        {
									            name:'总收入',
									            type:'line',
									            smooth:true,
									            itemStyle: {normal: {areaStyle: {type: 'default'}}},
									            data:[
									            	
									            	  <c:forEach items="${financialBackgroundInputs}" var="ts">
											            ${ts},
											            </c:forEach>
									            ]
									        },
									        {
									            name:'合伙人分红',
									            type:'line',
									            smooth:true,
									            itemStyle: {normal: {areaStyle: {type: 'default'}}},
									            data:[
									            	<c:forEach items="${financialPartnerBonusInputs}" var="ts">
										            ${ts},
										            </c:forEach>
									            ]
									        }
									     ]
									};
									// 基于准备好的dom，初始化echarts实例
							        var myChart = echarts.init(document.getElementById('myChart'));
							        myChart.setOption(option);
								</script>
							</div>
						</div>
						
					</div>
				</div>
				
				<div class="box-footer" id="zhongjian" >
				<!-- 右边条柱状 -->
				
				       <div class="col-md-4" style="margin-left:850px;margin-top:-300px;">
				       <div v-if="pd=='financialSourceType1'">
							<p class="text-center">
								<strong>系统年总营收金额资金来源</strong>
							</p>
							<div class="progress-group">
								<span class="progress-text">升级/续费钻石客户经理</span>
								<span class="progress-number"><b><span id="promotionDiamondCustomerManager">160</span></b>/<span id="promotionDiamondCustomerManagerTotal">200</span></span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-aqua" v-bind:style="{width:promotionDiamondCustomerManagerRate}"></div>
								</div>
							</div>
							<div class="progress-group">
								<span class="progress-text">升级/续费VIP客户经理</span>
								<span class="progress-number"><b><span id="promotionVIPCustomerManager">310</span></b>/<span id="promotionVIPCustomerManagerTotal">400</span></span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-red" style="width: 80%"></div>
								</div>
							</div>
							<div class="progress-group">
								<span class="progress-text">升级/续费普通客户经理</span>
								<span class="progress-number"><b><span id="promotionCustomerManager" >480</span></b>/<span id="promotionCustomerManagerTotal">800</span></span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-green" style="width: 80%"></div>
								</div>
							</div>
							<div class="progress-group">
								<span class="progress-text">活动项目提成</span>
								<span class="progress-number"><b><span id="activityExtract">800</span></b>/<span id="activityExtractTotal">1000</span></span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-yellow" style="width: 80%"></div>
								</div>
							</div>
							
							</div>
							<div v-if="pd=='financialSourceType2'">
							<p class="text-center">
								<strong>系统年总支出金额去向</strong>
							</p>
							<div class="progress-group">
								<span class="progress-text">活动提成支出/活动主办方推荐人提成</span>
								<span class="progress-number"><b><span id="promotionDiamondCustomerManager">160</span></b>/<span id="promotionDiamondCustomerManagerTotal">200</span></span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-aqua" v-bind:style="{width:promotionDiamondCustomerManagerRate}"></div>
								</div>
							</div>
							<div class="progress-group">
								<span class="progress-text">活动提成支出/活动分享人提成</span>
								<span class="progress-number"><b><span id="promotionVIPCustomerManager">310</span></b>/<span id="promotionVIPCustomerManagerTotal">400</span></span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-red" style="width: 80%"></div>
								</div>
							</div>
							<div class="progress-group">
								<span class="progress-text">活动提成支出/分红池提成</span>
								<span class="progress-number"><b><span id="promotionCustomerManager" >480</span></b>/<span id="promotionCustomerManagerTotal">800</span></span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-green" style="width: 80%"></div>
								</div>
							</div>
							<div class="progress-group">
								<span class="progress-text">活动提成支出/公益基金</span>
								<span class="progress-number"><b><span id="activityExtract">800</span></b>/<span id="activityExtractTotal">1000</span></span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-yellow" style="width: 80%"></div>
								</div>
							</div>
							
							</div>
							<div v-if="pd=='financialSourceType3'">
							<p class="text-center">
								<strong>合伙人分红池来源</strong>
							</p>
							<div class="progress-group">
								<span class="progress-text">会员升级/续费</span>
								<span class="progress-number"><b><span id="promotionDiamondCustomerManager">160</span></b>/<span id="promotionDiamondCustomerManagerTotal">200</span></span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-aqua" v-bind:style="{width:promotionDiamondCustomerManagerRate}"></div>
								</div>
							</div>
							<div class="progress-group">
								<span class="progress-text">活动分享提成</span>
								<span class="progress-number"><b><span id="promotionVIPCustomerManager">310</span></b>/<span id="promotionVIPCustomerManagerTotal">400</span></span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-red" style="width: 80%"></div>
								</div>
							</div>
							
							</div>
							<div v-if="pd=='financialSourceType4'">
							<p class="text-center">
								<strong>年助创基金来源</strong>
							</p>
							<div class="progress-group">
								<span class="progress-text">会员升级/续费</span>
								<span class="progress-number"><b><span id="promotionDiamondCustomerManager">160</span></b>/<span id="promotionDiamondCustomerManagerTotal">200</span></span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-aqua" v-bind:style="{width:promotionDiamondCustomerManagerRate}"></div>
								</div>
							</div>
							<div class="progress-group">
								<span class="progress-text">活动分享提成</span>
								<span class="progress-number"><b><span id="promotionVIPCustomerManager">310</span></b>/<span id="promotionVIPCustomerManagerTotal">400</span></span>
								<div class="progress sm">
									<div class="progress-bar progress-bar-red" style="width: 80%"></div>
								</div>
							</div>
							
							</div>
						</div>
						
						<!-- 下边数据统计 -->
					<div class="row" style="margin-left:50px;margin-top:50px;">
						<div class="col-sm-3 col-xs-6" >
							<div class="description-block border-right" >
								<span class="description-percentage text-green"></span>
								<h5 class="description-header"><span style="color:red;" id="financialBackgroundInputCountByYear" @mousemove="financialBackgroundInputCountByYear(financialSource)">￥ ${financialBackgroundInputCountByYear }</span></h5>
								<span class="description-text">年总营收金额</span>
									
							</div>
						</div>
						<div class="col-sm-3 col-xs-6">
							<div class="description-block border-right">
								<span class="description-percentage text-yellow"></span>
								<h5 class="description-header"><span style="color:red;" id="financialBackgroundOutCountByYear"   @mousemove="financialBackgroundOutCountByYear(financialSource)">￥ ${financialBackgroundOutCountByYear }</span></h5>
								<span class="description-text">年总支出金额</span>
							</div>
						</div>
						<div class="col-sm-3 col-xs-6">
							<div class="description-block border-right">
								<span class="description-percentage text-green"></span>
								<h5 class="description-header"><span style="color:red;" id="financialPartnerBonusInputCountByYear" @mousemove="financialPartnerBonusInputCountByYear(financialSource)">￥ ${financialPartnerBonusInputCountByYear }</span></h5>
								<span class="description-text">年合伙人分红池金额</span>
							</div>
						</div>
						<div class="col-sm-3 col-xs-6">
							<div class="description-block border-right">
								<span class="description-percentage text-green"></span>
								<h5 class="description-header"><span style="color:red;" id="financialAidFundInputCountByYear"  @mousemove="financialAidFundInputCountByYear(financialSource)">￥ ${financialAidFundInputCountByYear }</span></h5>
								<span class="description-text">年助创基金</span>
							</div>
						</div>
						<%-- <div class="col-sm-3 col-xs-6" >
							<div class="description-block">
								<span class="description-percentage text-red"><i class="fa fa-caret-down"></i> </span>
								<h5 class="description-header">￥ ${totalProfitCountByYear }</h5>
								<span class="description-text">年总利润</span>
							</div>
						</div> --%>
					</div>
				</div>
			</div>
		</div>
	</div>
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
	<script src="static/vue.js"></script>
	<script src="static/vue-resource.js"></script>
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script src="static/ace/js/bootbox.js"></script>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	
	<script type="text/javascript">
	top.hangge();
	new Vue({
		el:'#zhongjian',
		 data: {
			 promotionDiamondCustomerManagerRate:0 ,
			    list: [],
			    shop:{},
			    pd:'financialSourceType1'
			  },
			  filters: {/* 时间过滤 */
				  formatDate(time) {
					let date = new Date(time);
					return formatDate(date, "yyyy-MM-dd hh:mm");
				  }
			  },
			  created:function () {
				  var _this=this;
				 <%--  alert("create");
				   $.ajax({
					   url:'<%=basePath%>financialStatements/goListFinancialStatements',
				       type:'GET',
				       success:function(data){
				    	   _this.list=data.rows;
				       },
				       error:function(){
				    	   alert('失败')
				       }
				   }); --%>
			  }, 
			  methods: {
				  
				  //年总营收金额资金来源
				  financialBackgroundInputCountByYear:function(financialSource){
					  var _this=this;
					var financialBackgroundInputCountByYearValue = $("#financialBackgroundInputCountByYear").text();
				
					  $.ajax({
						  url:'<%=basePath%>financialStatements/financialSource',
						  dataType:"json",
					      data:{
					    		financialSource:"financialSourceType1",
								financialBackgroundInputCountByYearValue:financialBackgroundInputCountByYearValue
					      },
					      success:function(datas){
					    	  _this.pd = datas.pd;
					    	 
					    	  //1钻石客户经理金额
					    	 $("#promotionDiamondCustomerManager").text(datas.promotionDiamondCustomerManagerMoney);
					  		
					  	    //1钻石客户经理占比年总营收金额资金比率
					  		_this.promotionDiamondCustomerManagerRate = datas.promotionDiamondCustomerManagerRate+"%";
					        //还有三个角色
					  	    /* 	alert("2"+_this.promotionDiamondCustomerManagerRate); */
					  		$("#promotionDiamondCustomerManagerTotal").text(financialBackgroundInputCountByYearValue);
					  		$("#promotionVIPCustomerManagerTotal").text(financialBackgroundInputCountByYearValue);
					  		$("#promotionCustomerManagerTotal").text(financialBackgroundInputCountByYearValue);
					  		$("#activityExtractTotal").text(financialBackgroundInputCountByYearValue);

					      },
					      error:function(){
					    	  alert("失败");
					      }
					    
					  
					  })
					  
				  },
				//年总支出金额
				  financialBackgroundOutCountByYear:function(financialSource){
					  var _this=this;
					var financialBackgroundOutCountByYearValue  = $("#financialBackgroundOutCountByYear").text();
				
					  $.ajax({
						  url:'<%=basePath%>financialStatements/financialSource',
						  dataType:"json",
					      data:{
					    		financialSource:"financialSourceType2",
					    		financialBackgroundOutCountByYearValue:financialBackgroundOutCountByYearValue
					      },
					      success:function(datas){
					    	  _this.pd = datas.pd;
					    	
					    	 // 1钻石客户经理金额
					    	 $("#promotionDiamondCustomerManager").text(datas.promotionDiamondCustomerManagerMoney);
					  	    //1钻石客户经理占年总支出金额来源比率
					  		_this.promotionDiamondCustomerManagerRate = datas.promotionDiamondCustomerManagerRate+"%";
					  	    //还有三个角色
					  	    /* 	alert("2"+_this.promotionDiamondCustomerManagerRate); */
					  		$("#promotionDiamondCustomerManagerTotal").text((financialBackgroundOutCountByYearValue));
					  		$("#promotionVIPCustomerManagerTotal").text((financialBackgroundOutCountByYearValue));
					  		$("#promotionCustomerManagerTotal").text((financialBackgroundOutCountByYearValue));
					  		$("#activityExtractTotal").text((financialBackgroundOutCountByYearValue));

					      },
					      error:function(){
					    	  alert("失败");
					      }
					    
					  
					  })
					  
				  },
				  //年合伙人分红池金额
				  financialPartnerBonusInputCountByYear:function(financialSource){
					  var _this=this;
					var financialPartnerBonusInputCountByYearValue  = $("#financialPartnerBonusInputCountByYear").text();
				
					  $.ajax({
						  url:'<%=basePath%>financialStatements/financialSource',
						  dataType:"json",
					      data:{
					    		financialSource:"financialSourceType3",
					    		financialPartnerBonusInputCountByYearValue :financialPartnerBonusInputCountByYearValue 
					      },
					      success:function(datas){
					    	  _this.pd = datas.pd;
					    	  // 1钻石客户经理金额
					    	 $("#promotionDiamondCustomerManager").text(datas.promotionDiamondCustomerManagerMoney);	
					  	    //1钻石客户经理占比年合伙人分红池金额比率
					  		_this.promotionDiamondCustomerManagerRate = datas.promotionDiamondCustomerManagerRate+"%";
					  	    //还有三个角色
					  	    /* 	alert("2"+_this.promotionDiamondCustomerManagerRate); */
					  		$("#promotionDiamondCustomerManagerTotal").text(financialPartnerBonusInputCountByYearValue);
					  		$("#promotionVIPCustomerManagerTotal").text(financialPartnerBonusInputCountByYearValue);
					  		$("#promotionCustomerManagerTotal").text(financialPartnerBonusInputCountByYearValue);
					  		$("#activityExtractTotal").text(financialPartnerBonusInputCountByYearValue);

					      },
					      error:function(){
					    	  alert("失败");
					      }
					    
					  
					  })
					  
				  },
				  //年助创基金
				  financialAidFundInputCountByYear:function(financialSource){
					  var _this=this;
					var financialAidFundInputCountByYearValue  = $("#financialAidFundInputCountByYear").text();
				
					  $.ajax({
						  url:'<%=basePath%>financialStatements/financialSource',
						  dataType:"json",
					      data:{
					    		financialSource:"financialSourceType4",
					    		financialAidFundInputCountByYearValue :financialAidFundInputCountByYearValue 
					      },
					      success:function(datas){
					    	  _this.pd = datas.pd;
					    	  //1钻石客户经理金额
					    	 $("#promotionDiamondCustomerManager").text(datas.promotionDiamondCustomerManagerMoney);
					  		
					  	    //1钻石客户经理占比年助创基金
					  		_this.promotionDiamondCustomerManagerRate = datas.promotionDiamondCustomerManagerRate+"%";
					  	    //还有三个角色
					  	    /* 	alert("2"+_this.promotionDiamondCustomerManagerRate); */
					  		$("#promotionDiamondCustomerManagerTotal").text(financialAidFundInputCountByYearValue);
					  		$("#promotionVIPCustomerManagerTotal").text(financialAidFundInputCountByYearValue);
					  		$("#promotionCustomerManagerTotal").text(financialAidFundInputCountByYearValue);
					  		$("#activityExtractTotal").text(financialAidFundInputCountByYearValue);

					      },
					      error:function(){
					    	  alert("失败");
					      }
					    
					  
					  })
					  
				  },
				  
			  }
	})
	
	//年总营收金额资金来源
	<%-- $("#financialBackgroundInputCountByYear").mouseover(function() {
		var financialBackgroundInputCountByYearValue = $("#financialBackgroundInputCountByYear").text();
        alert("a");
        alert("aa"+financialBackgroundInputCountByYearValue)
		$.ajax({
		url : '<%=basePath%>financialStatements/financialSource.do',
		dataType:"json",
		data : {
			financialSource:"financialSourceType1",
			financialBackgroundInputCountByYearValue:financialBackgroundInputCountByYearValue
		},
		success:function(datas) {
		$("#promotionDiamondCustomerManager").text(datas.promotionDiamondCustomerManagerMoney);
		/* $("#promotionDiamondCustomerManagerRate").css("width":datas.promotionDiamondCustomerManagerRate+"%");
		 */
		$("#promotionDiamondCustomerManagerRate").style.width="10%";
		alert("aaaaaa");
		$("#promotionDiamondCustomerManagerTotal").text(financialBackgroundInputCountByYearValue);
		$("#promotionVIPCustomerManagerTotal").text(financialBackgroundInputCountByYearValue);
		$("#promotionCustomerManagerTotal").text(financialBackgroundInputCountByYearValue);
		$("#activityExtractTotal").text(financialBackgroundInputCountByYearValue);

		},
		error:function(){
			alert("失败");
		 
		}
		});
		}); --%>
	
	//年总支出金额
	<%-- $("#financialBackgroundOutCountByYear").mouseover(function() {
		var financialBackgroundOutCountByYearValue = $("#financialBackgroundOutCountByYear").text();

        alert("b");
		$.ajax({
		url : '<%=basePath%>financialStatements/financialSource.do',
		dataType:"json",
		data : {
			financialSource:"financialSourceType2",
		},
		success:function(datas) {
		$("#source").text(datas.data);
		$("#promotionDiamondCustomerManagerTotal").text(financialBackgroundOutCountByYearValue);
		$("#promotionVIPCustomerManagerTotal").text(financialBackgroundOutCountByYearValue);
		$("#promotionCustomerManagerTotal").text(financialBackgroundOutCountByYearValue);
		$("#activityExtractTotal").text(financialBackgroundOutCountByYearValue);

		},
		error:function(){
			alert("失败");
		 
		}
		});
		});
	 --%>
	//年合伙人分红池金额
	<%-- $("#financialPartnerBonusInputCountByYear").mouseover(function() {
		var financialPartnerBonusInputCountByYearValue = $("#financialPartnerBonusInputCountByYear").text();

        alert("c");
		$.ajax({
		url : '<%=basePath%>financialStatements/financialSource.do',
		dataType:"json",
		data : {
			financialSource:"financialSourceType3",
		},
		success:function(datas) {
		$("#source").text(datas.data);
		$("#promotionDiamondCustomerManagerTotal").text(financialPartnerBonusInputCountByYearValue);
		$("#promotionVIPCustomerManagerTotal").text(financialPartnerBonusInputCountByYearValue);
		$("#promotionCustomerManagerTotal").text(financialPartnerBonusInputCountByYearValue);
		$("#activityExtractTotal").text(financialPartnerBonusInputCountByYearValue);

		},
		error:function(){
			alert("失败");
		 
		}
		});
		}); --%>
	//年助创基金
   <%--  $("#financialAidFundInputCountByYear").mouseover(function() {
		var financialAidFundInputCountByYearValue = $("#financialAidFundInputCountByYear").text();

        alert("d");
		$.ajax({
		url : '<%=basePath%>financialStatements/financialSource.do',
		dataType:"json",
		data : {
			financialSource:"financialSourceType4",
		},
		success:function(datas) {
		$("#source").text(datas.data);
		$("#promotionDiamondCustomerManagerTotal").text(financialAidFundInputCountByYearValue);
		$("#promotionVIPCustomerManagerTotal").text(financialAidFundInputCountByYearValue);
		$("#promotionCustomerManagerTotal").text(financialAidFundInputCountByYearValue);
		$("#activityExtractTotal").text(financialAidFundInputCountByYearValue);

		},
		error:function(){
			alert("失败");
		 
		}
		});
		}); --%>

	
	
	</script>
</body>
</html>

