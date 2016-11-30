$(function(){
	$("#btn").click(function(){
		getData();
		//updateHelp();
	})
});


function getData(){
	var json = {};
	json.nowPage=-1;
	json.pageSize = -1;
	
	$.ajax({
         url:'http://1597e1873r.iask.in:20773/helpOper/queryRoadRescue.do',
         data:json,
         type:'GET',
         cache : false,
         dataType : 'json',
         success:function(result){
             alert(result);
       },
       error : function() {
           alert("错误!");
         }
   });
}

function updateHelp(){
	var json = {};
	json.helpId=1;
	json.content = "豪车不能碰!"
	
	$.ajax({
         url:'http://127.0.0.1:8099/CityYouXia/helpOper/updateHelp.do',
         data:json,
         type:'post',
         cache : false,
         dataType : 'json',
         success:function(result){
             alert(result);
       },
       error : function() {
           alert("错误!");
         }
   });
	
}





