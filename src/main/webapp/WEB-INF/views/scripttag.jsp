<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> -->
<script src="//code.jquery.com/jquery.min.js"></script>

<style type="text/css">

	div{
		margin-top: 30px;
	}
	
	div{
		width: 70%;
	}
	
	#msg {
		border: 1px solid cornflowerblue;

		height: 300px;
		
		font-size: 1.2em;
	}

	
</style>

<script type="text/javascript">



$(document).ready(function(){
	$("#selectBtn").click(function(){
		$.ajax({
			type: "get",
			url:"/api/scripttag",
			//data:"",
			success:function(result){
				console.log(result);
				$("#msg").html(result);
			},
			error:function(a,b,c){
				console.log(a+b+c);
				
			}
				
		});
	});
	
	
	$("#createBtn").click(function(){
		console.log('ff');
		$.ajax({
			url:"${pageContext.request.contextPath}/api/scripttag/"+$("#scriptNo").val(),
			type: "post",
			//data:"",
			contentType:"application/json;charset=UTF-8",
			success:function(result){
				console.log(result);
				$("#msg").html(result);
			},
			error:function(a,b,c){
				console.log(a+b+c);
			}
				
		});
	});
	
	$("#deleteBtn").click(function(){
		$.ajax({
			type: "delete",
			url:"/api/scripttag/"+$("#scriptNo").val(),
			//data:"",
			success:function(result){
				console.log(result);
				
			},
			error:function(a,b,c){
				console.log(a+b+c);
			}
				
		});
	});
	
	
	
});


</script>

</head>
<body>

<div class="container">
	<label for="scriptNo">script_no</label>
	<input id="scriptNo" type="text" class="form-control"/>
	<label for="srcText">src</label>
	<input id="srcText" type="text" class="form-control"/>
	

</div>

<div class="container">

	<button id="createBtn" type="button" class="btn btn-default" >CREATE</button>
	<button id="deleteBtn" type="button" class="btn btn-default" >DELETE</button>
	<button id="selectBtn" type="button" class="btn btn-default" >SELECT</button>
</div>

<div id="msg" class="container">
	
</div>

</body>
</html>