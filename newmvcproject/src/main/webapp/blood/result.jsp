<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>this is your color</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

@keyframes fadeIn {
	from { opacity: 0; transform: translateY(20px); }
	to { opacity: 1; transform: translateY(0); }
}

@keyframes pulse {
	0%, 100% { transform: scale(1); }
	50% { transform: scale(1.03); }
}

body {
	font-family: 'Noto Sans KR', sans-serif;
	background: linear-gradient(135deg, #ffeef2, #fbe0ff);
	margin: 0;
	padding: 0;
	display: flex;
	align-items: center;
	justify-content: center;
	min-height: 100vh;
}

#wrapper {
	width: 92%;
	max-width: 450px;
	padding: 40px 30px;
	background-color: #ffffff;
	border: 2px solid #ffbcd4;
	border-radius: 20px;
	box-shadow: 0 12px 30px rgba(0, 0, 0, 0.08);
	text-align: center;
	animation: fadeIn 1s ease;
}

#wrapper h1 {
	font-size: 28px;
	color: #d6336c;
	margin-bottom: 25px;
}

#option {
	margin-bottom: 20px;
}

#option select {
	width: 85%;
	padding: 12px;
	font-size: 16px;
	border-radius: 10px;
	border: 1px solid #ccc;
	background-color: #fffafc;
	box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.05);
	transition: all 0.3s ease;
}

#option select:focus {
	border-color: #ff87b4;
	box-shadow: 0 0 6px rgba(255, 135, 180, 0.3);
	outline: none;
}

button {
	padding: 12px 32px;
	font-size: 16px;
	background-color: #ff66a3;
	color: white;
	border: none;
	border-radius: 10px;
	cursor: pointer;
	transition: background-color 0.3s ease, transform 0.2s ease;
	box-shadow: 0 6px 10px rgba(255, 102, 163, 0.3);
	animation: pulse 2.5s infinite;
	margin-top: 15px;
}

button:hover {
	background-color: #e25592;
	transform: translateY(-2px);
}

.result-label {
	margin-top: 25px;
	font-size: 18px;
	font-weight: 500;
	color: #b1004b;
	background-color: #fff2f7;
	padding: 12px 20px;
	border-radius: 12px;
	display: inline-block;
	box-shadow: 0 4px 10px rgba(0,0,0,0.05);
	animation: fadeIn 0.8s ease-in-out;
}
</style>


</head>
<body>
	<div id="wrapper">
		<h1>당신의 혈액형은?</h1>
		

		<form action="/blood/advice" method="get">
			<div id="option">
				<select name="bloodType" required>
					<option value="">혈액형 선택</option>
					<option value="A">A형</option>
					<option value="B">B형</option>
					<option value="O">O형</option>
					<option value="AB">AB형</option>
				</select>
			</div>
			
			<div><label class="result-label"><%= request.getAttribute("msg") %></label></div>
			<button type="submit">성격 알아보기</button>
			
		</form>
	</div>
</body>

</html>