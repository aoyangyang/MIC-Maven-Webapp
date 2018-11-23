/*发起post请求*/
function post(URL, PARAMS){
     var temp = document.createElement("form");
     temp.action = URL;
     temp.method = "post";
     temp.style.display = "none";
     for (var x in PARAMS)
     {
         var opt = document.createElement("textarea");
         opt.name = x;
         opt.value = PARAMS[x];
         temp.appendChild(opt);
     }
     document.body.appendChild(temp);
     temp.submit();
     document.getElementById("rollback").submit();
     return temp;
 }

/*返回上一级*/
function goBack(){
	window.location.href = document.referrer;
	window.history.back(-1);
}

/*显示数据*/
function show(arr,id){
	var chart = AmCharts.makeChart(id, {
	    "theme": "light",
	    "type": "serial",
		"startDuration": 0,
	    "dataProvider":
	    [{
	        "country": "到课",
	        "visits": arr[0],
	        "color": "#A020F0"
	    },{
	        "country": "请假",
	        "visits": arr[1],
	        "color": "#FFFF00"
	    },{
	        "country": "缺勤",
	        "visits": arr[2],
	        "color": "#FF0000"
	    }],
	    "valueAxes": [{
	        "position": "left",
	        "title": "人数（个）"
	    }],
	    "fontSize":18,
	    "graphs": [{
	        "balloonText": "[[category]]: <b>[[value]]</b>",
	        "fillColorsField": "color",
	        "fillAlphas": 1,
	        "lineAlpha": 0.1,
	        "type": "column",
	        "valueField": "visits"
	    }],
	    "depth3D": 20,
		"angle": 30,
	    "chartCursor": {
	        "categoryBalloonEnabled": false,
	        "cursorAlpha": 1,
	        "zoomable": false
	    },
	    "categoryField": "country",
	    "categoryAxis": {
	        "gridPosition": "start",
	        "labelRotation": 90
	    },
	    "export": {
	    	"enabled": true
	     }
	});
}



