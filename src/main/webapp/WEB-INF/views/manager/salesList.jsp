<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
google.charts.load('current', {'packages':['bar']});
google.charts.setOnLoadCallback(drawChart);
var count = 0;
var data;
var chart;
var options;
function drawChart() {
	  var jsonData = $.ajax({
		 url : "${path}/visit/salesList",
		 dataType : "json",
		 async : false
	  }).responseText;
	  console.log(jsonData);
		data = new google.visualization.DataTable(jsonData);
		
	  options = {
	   				 chart: {
                     title: '일별 매출',
	      			 subtitle: '',
	    }
	  };
  chart = new google.charts.Bar(document.getElementById('salesList'));
  chart.draw(data, google.charts.Bar.convertOptions(options));
}


</script>
<div id="salesList" style="width: 100%; height: 500px;"></div>

