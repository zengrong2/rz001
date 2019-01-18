var locat = (window.location+'').split('/'); 
$(function(){if('tool'== locat[3]){locat =  locat[0]+'//'+locat[2];}else{locat =  locat[0]+'//'+locat[2]+'/'+locat[3];};});

$(top.hangge());

//发送
function sendEm(msg){
	
	if($("#TYPE").val()=="1"){
		$("#CONTENT").val(getContentTxt());
	}else{
		$("#CONTENT").val(getContent());
	}
/*	if($("#EMAIL").val()==""){
		$("#EMAIL").tips({
			side:3,
            msg:'请输入邮箱',
            bg:'#AE81FF',
            time:2
        });
		$("#EMAIL").focus();
		return false;
	}*/
	//活动详情
	if(msg!='4'){
		
		if($("#CONTENT").val()==""){
			
			$("#nr").tips({
				side:3,
				msg:'请输入内容',
				bg:'#AE81FF',
				time:3
			});
			return false;
		}
	}
	
	$("#zhongxin").hide();
	$("#zhongxin2").show();
	//活动id
	var activityId = $("#activityId").val();
   //活动名称
	var activityName = $("#activityName").val();
	var activitycategoryId = $("#activitycategoryId").val();
	//活动时间
	var avtivitySignUpStartTime = $("#avtivitySignUpStartTime").val();
	var avtivitySignUpEndTime = $("#avtivitySignUpEndTime").val();
	var activityStartTime = $("#activityStartTime").val();
	var activityEndTime = $("#activityEndTime").val();
	//人数
	var activitySignUpPersonNumber = $("#activitySignUpPersonNumber").val();
	//收费状态
	var activityCostType1 = $("#activityCostType1").val();
	var activityCostType2 = $("#activityCostType2").val();
	//如果是收费，活动收费项目数组
	if(activityCostType1=="1"){
		//草稿已经添加好的收费项目
	var returnCostProjectCount = $("#returnCostProjectCount").val();
	var returnCostProjectCount = parseInt(returnCostProjectCount)-1;
	var returnCostProjectmInfoSaveArray = "";
	for(var i=returnCostProjectCount;i>=0;i--){
		var	returnCostProjectmName = $("#returnCostProjectmName"+i+"").val();
		var returnCostProjectMoney = $("#returnCostProjectMoney"+i+"").val();
		returnCostProjectmInfoSaveArray+=returnCostProjectmName+":"+returnCostProjectMoney+",";
	}
	//修改新加的项目
	var	costProjectmName =$("#costProjectmName").val();
	var costProjectMoney = $("#costProjectMoney").val();
	var createInputCountSum = $("#createInputCountSum").val();
	var sum = parseInt(createInputCountSum);
	var costProjectmInfoSaveArray = "";
	costProjectmInfoSaveArray=costProjectmName+":"+costProjectMoney+",";
	for(var i=sum;i>0;i-- ){
	var	costProjectmNames = $("#costProjectmName"+i+"").val();
	var costProjectMoneys = $("#costProjectMoney"+i+"").val();
	costProjectmInfoSaveArray+=costProjectmNames+":"+costProjectMoneys+",";
	}
	}
//客户匹配区域
	var pid = $("#pid").val();
	var cid = $("#cid").val();
	var did = $("#did").val();
	//活动类型
	var activityOnlineStatus1 = $("#activityOnlineStatus1").val();
	var activityOnlineStatus2 = $("#activityOnlineStatus2").val();

	//如果活动类型选择线下，获取线下区域地区和详细地址
	if(activityOnlineStatus2=="2"){
		var pid2 = $("#pid2").val();
		var cid2 = $("#cid2").val();
		var did2 = $("#did2").val();
		var detailedAddress = $("#detailedAddress").val();
		var pid3 = $("#pid3").val();
		var cid3 = $("#cid3").val();
		var did3 = $("#did3").val();
		
	}
	//封面图
	var activity_cover_img = $("#activity_cover_img").val();
	//分享摘要
	var shareSummary = $("#shareSummary").val();
	var isInvitationActivityRoyalty1 = $("#isInvitationActivityRoyalty1").val();
	var isInvitationActivityRoyalty2 = $("#isInvitationActivityRoyalty2").val();

	if(isInvitationActivityRoyalty1=="1"){
		var invitationActivityRoyaltyRate = $("#invitationActivityRoyaltyRate").val();
	}
	//活动音乐
	var activitymusicId = $("#activitymusicId").val();
	//报名其他填写项
	//草稿已经好的填写项
	var countReturnOtherFill = $("#countReturnOtherFill").val();
	var countReturnOtherFills = parseInt(countReturnOtherFill);
	var finalReturnInputCountSumOtherArray = "";
	for(var i=countReturnOtherFills;i>=0;i--){
		var returnSignUpOtherFillName = $("#returnSignUpOtherFillName"+i+"").val();
		
		finalReturnInputCountSumOtherArray+=","+returnSignUpOtherFillName;
	}
	//新添加的填写项目
	var createInputCountSumOther = $("#createInputCountSumOther").val();
	var createInputCountSumOtherArray = "";
	var signUpOtherFillName = $("#signUpOtherFillName").val();
	createInputCountSumOtherArray=signUpOtherFillName+"";
	var sumOther = parseInt(createInputCountSumOther);
	for(var j=sumOther;j>=0;j--){
		var signUpOtherFillNames = $("#signUpOtherFillName"+j+"").val();
		createInputCountSumOtherArray+=","+signUpOtherFillNames;
	}
	var TYPE  = $("#TYPE").val();
	var onlineStatus = msg;
	/*var TITLE = $("#TITLE").val();*/
	var CONTENT = $("#CONTENT").val();
	/*var isAll = $("#isAll").val();*/
	var fmsg = "${pd.msg}";
	$.ajax({
		type: "POST",
		url: locat+'/organizerInfo/editOrganizerInfoActivity.do?tm='+new Date().getTime(),
    	data: {TYPE:TYPE,CONTENT:CONTENT,fmsg:fmsg,activityName:activityName,activitycategoryId:activitycategoryId,
    	    avtivitySignUpStartTime:avtivitySignUpStartTime,costProjectmInfoSaveArray:costProjectmInfoSaveArray,
    		avtivitySignUpEndTime:avtivitySignUpEndTime,activityStartTime:activityStartTime,activityEndTime:activityEndTime,
    		activitySignUpPersonNumber:activitySignUpPersonNumber,activityCostType1:activityCostType1,pid:pid,cid:cid,did:did,
    		activityOnlineStatus1:activityOnlineStatus1,activity_cover_img:activity_cover_img,shareSummary:shareSummary,
    		isInvitationActivityRoyalty1:isInvitationActivityRoyalty1,activitymusicId:activitymusicId, 		
    		pid2:pid2,cid2:cid2,did2:did2,detailedAddress:detailedAddress,invitationActivityRoyaltyRate:invitationActivityRoyaltyRate
    	    ,createInputCountSumOtherArray:createInputCountSumOtherArray,onlineStatus:onlineStatus,
    	    activityCostType2:activityCostType2,isInvitationActivityRoyalty2:isInvitationActivityRoyalty2,
    	    activityOnlineStatus2:activityOnlineStatus2,returnCostProjectmInfoSaveArray:returnCostProjectmInfoSaveArray,
    	    finalReturnInputCountSumOtherArray:finalReturnInputCountSumOtherArray,activityId:activityId,
    	    pid3:pid3,cid3:cid3,did3:did3
    	},
		dataType:'json',
		//beforeSend: validateData,
		cache: false,
		success: function(data){
			 $.each(data.list, function(i, list){
				 if(list.msg == 'ok'){
					 alert("发布成功");
				/*	 var count = list.count;
					 var ecount = list.ecount;
					 $("#msg").tips({
						side:3,
			            msg:'成功发出'+count+'条,失败'+ecount+'条,检查邮箱格式',
			            bg:'#68B500',
			            time:5
				      });*/
					 
				 }else{
					 alert("发布失败");
					/* $("#msg").tips({
							side:3,
				            msg:'邮件发送失败,请联系管理员检查邮件服务器配置是否正确!',
				            bg:'#FF0000',
				            time:5
					 });
					 */
				 }
				 setTimeout("showdiv()",8000);
				 timer(7);
			 });
		}
	});
	
}

//倒计时
function timer(intDiff){
	window.setInterval(function(){
	$('#second_shows').html('<s></s>'+intDiff+'秒');
	intDiff--;
	}, 1000);
}

function showdiv(){
	$("#zhongxin2").hide();
	$("#zhongxin").show();
}

function setType(value){
	$("#TYPE").val(value);
}

/*function isAll(){
	if(document.getElementsByName('form-field-checkbox')[0].checked){
		$("#isAll").val('yes');
		$("#EMAIL").attr("disabled",true);
	}else{
		$("#isAll").val('no');
		$("#EMAIL").attr("disabled",false);
	}
}*/

//编辑邮箱(此方式弃用)
function editEmail(){
   var EMAIL = $("#EMAIL").val();
   var result = showModalDialog(locat+"/head/editEmail.do?EMAIL="+EMAIL,"","dialogWidth=600px;dialogHeight=380px;");
   if(result==null || ""==result){
	    $("#EMAIL").val("");
   }else{
		$("#EMAIL").val(result);
   }
}

//打开编辑邮箱
function dialog_open(){
	/*$("#EMAILs").val($("#EMAIL").val());*/
	$("#dialog-add").css("display","block");
}
//关闭编辑邮箱
function cancel_pl(){
	$("#dialog-add").css("display","none");
}
//保存编辑邮箱
function saveEmail(){
/*	$("#EMAIL").val($("#EMAILs").val());*/
	$("#dialog-add").css("display","none");
}

//ueditor纯文本
function getContentTxt() {
    var arr = [];
    arr.push(UE.getEditor('editor').getContentTxt());
    return arr.join("");
}
//ueditor有标签文本
function getContent() {
    var arr = [];
    arr.push(UE.getEditor('editor').getContent());
    return arr.join("");
}

setTimeout("ueditor()",500);
function ueditor(){
	var ue = UE.getEditor('editor');
}
