$(function(){
	//初始化
	workObj.init(workObj.condition);
	
	workObj.bindEvent();
});

var workObj = {
	"condition" : {
		"pageSize":10,
		"pageNo":1
	},
	"init" : function(paramObj){
		$.ajax({
			method : "POST",
			url : "/worker/list",
			async : true,
			dataType : "json",
			contentType: "application/json;charset-UTF-8",
			data : JSON.stringify(paramObj),
			success : function(dataObj){
				if(!dataObj || dataObj.status != 200) {
					alert(dataObj.errMsg);
					return false;
				}
				var arr = dataObj.data.list;
				var html = [];
				for(var i = 0, len = arr.length; i < len; i++) {
					var obj = arr[i];
					html.push('<tr class="text-c">');
					html.push('	<td><input type="checkbox" value="" name=""></td>');
					html.push('	<td>'+obj.jobName+'</td>');
					html.push('	<td>'+obj.relatedMajor+'</td>');
					html.push('	<td>'+obj.academicRequire+'</td>');
					html.push('	<td>'+obj.workPlace+'</td>');
					html.push('	<td>'+obj.cityName+'</td>');
					html.push('	<td>'+obj.regionName+'</td>');
					html.push('	<td>'+obj.salary+'</td>');
					html.push('	<td>'+obj.jobBrightSpot+'</td>');
					html.push('	<td>'+obj.statusMsg+'</td>');
					html.push('	<td>'+obj.updateTime+'</td>');
					html.push('	<td class="f-14 td-manage"><a style="text-decoration:none" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> <a style="text-decoration:none" class="ml-5" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>');
					html.push('</tr>');
				}
				$("#workListDom").html(html.join(""));
				$("#pagination").remove();
				$("#pagerDom").append('<ul id="pagination" class="pagination"></ul>');
				$("#totalRecord").html(dataObj.data.total);
				$("#pager").pager({
                    pagenumber: dataObj.data.pageNum, 
                    pagecount:dataObj.data.pageSize,
                    totalcount:dataObj.data.total,
                    buttonClickCallback: function(pageclickednumber){
                    	workObj.condition.pageNo = pageclickednumber;
                    	workObj.init(workObj.condition);
                    }
                });
			}
		});
	},
	"bindEvent" : function(){
		$("#search").click(function(){
			var status = $("#status").val();
			var startDateMin = $("#startDateMin").val();
			var startDateMax = $("#startDateMax").val();
			var jobName = $("#jobName").val();
			if(status != "") {
				workObj.condition["status"] = status;
			}
			if(startDateMin) {
				workObj.condition["startDateMin"] = startDateMin;
			}
			if(startDateMax) {
				workObj.condition["startDateMax"] = startDateMax;
			}
			if(jobName) {
				workObj.condition["jobName"] = jobName;
			}
			workObj.init(workObj.condition);
		});
	}
};