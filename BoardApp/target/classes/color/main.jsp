<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	
	//field of service method
	String bg = request.getParameter("bg");
	if(bg == null){
		bg = "yellow";
	}
	out.print(bg);
	
%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script type = "text/javascript">
		$(()=>{
			//버튼을 누르면 서버의 jsp 에게 색상변경을 요청하자
			$("button").click(()=>{
				
				location.href = "/color/main.jsp?bg="+$("select").val(); //링크는 get 방식의요청
			});
		});
	</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor =<%=bg%>>
	<select>
		<option <%if(bg.equals("red")){%>selected<%}%> value = "red">red</option>
		<option <%if(bg.equals("orange")){%>selected<%}%> value = "orange">orange</option>
		<option <%if(bg.equals("green")){%>selected<%}%> value = "green">green</option>
		<option <%if(bg.equals("blue")){%>selected<%}%> value = "blue">blue</option>
	</select>
	
	<button>색상 바꾸기</button>
</body>
</html>