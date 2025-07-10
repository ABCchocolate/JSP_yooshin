<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>this is your color</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
}

#wrapper {
	margin: 50px auto;
	width: 500px;
	height: 500px;
	position: relative;
	background-color: pink;
	border: 2px solid #ccc;
	border-radius: 10px;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

#option {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	height: 120px;
	margin-bottom: 20px;
}

#option select {
	width: 200px;
	padding: 8px;
	font-size: 16px;
	border-radius: 5px;
	border: 1px solid #aaa;
}

button {
	display: block;
	margin: 0 auto;
	padding: 10px 20px;
	font-size: 16px;
	background-color: #333;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.2s ease;
}

button:hover {
	background-color: #555;
}

form{
	margin auto;
	
}
</style>
</head>
<body>
	<div id="wrapper">
		
		<form action="/color.do" method="get">
			<div id="option">
				<select name="color">
					<option value="">색상 선택</option>
					<option value="red">red</option>
					<option value="green">green</option>
					<option value="yellow">yellow</option>
					<option value="blue">blue</option>
				</select>
			</div>
			<button type="submit">전송</button>
			
			<div style="text-align: center; margin-top: 20px; font-weight: bold;">
				<%=session.getAttribute("msg")%> 
			</div>
		</form>
	</div>
</body>

</html>