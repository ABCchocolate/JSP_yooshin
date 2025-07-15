<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	function regist() {
		$("form").attr({
			action: "/shop/staff/regist",
			method: "POST"
		});
		$("form").submit();
	}

	$(function() {
		$("button").click(function(e) {
			e.preventDefault(); // 기본 submit 막기
			regist();
		});
	});
</script>
<style>
@keyframes fadeInUp {
	from {
		opacity: 0;
		transform: translateY(30px);
	}
	to {
		opacity: 1;
		transform: translateY(0);
	}
}

body {
	font-family: 'Segoe UI', sans-serif;
	background: linear-gradient(135deg, #f8f9fa, #e0f7fa);
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.signup-container {
	background: white;
	padding: 30px 40px;
	border-radius: 16px;
	box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
	width: 420px;
	animation: fadeInUp 0.8s ease forwards;
	opacity: 0;
}

.signup-container h2 {
	text-align: center;
	margin-bottom: 28px;
	color: #2c3e50;
	font-size: 24px;
	letter-spacing: 1px;
}

.form-group {
	display: flex;
	flex-direction: column;
	margin-bottom: 18px;
	position: relative;
}

.form-group label {
	margin-bottom: 6px;
	font-weight: 500;
	color: #34495e;
}

.form-group input {
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 14px;
	transition: all 0.3s ease;
}

.form-group input:focus {
	border-color: #4CAF50;
	box-shadow: 0 0 8px rgba(76, 175, 80, 0.3);
	outline: none;
}

.submit-btn {
	width: 100%;
	padding: 14px;
	background-color: #4CAF50;
	color: white;
	border: none;
	font-size: 16px;
	border-radius: 8px;
	cursor: pointer;
	transition: background-color 0.3s ease, transform 0.2s ease;
}

.submit-btn:hover {
	background-color: #45a049;
	transform: translateY(-2px);
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
}

.submit-btn:active {
	transform: scale(0.98);
}
</style>
</head>
<body>
	<div class="signup-container">
		<h2>회원가입</h2>
		<form>
			<!-- staff table -->
			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" id="name" name="name" placeholder="이름">
			</div>

			<div class="form-group">
				<label for="sal">급여</label>
				<input type="text" id="sal" name="sal" placeholder="급여">
			</div>

			<div class="form-group">
				<label for="email">이메일</label>
				<input type="text" id="email" name="email" placeholder="이메일">
			</div>

			<!-- bio table -->
			<div class="form-group">
				<label for="blood">혈액형</label>
				<input type="text" id="blood" name="blood" placeholder="혈액형">
			</div>

			<div class="form-group">
				<label for="height">키 (cm)</label>
				<input type="text" id="height" name="height" placeholder="키">
			</div>

			<div class="form-group">
				<label for="weight">몸무게 (kg)</label>
				<input type="text" id="weight" name="weight" placeholder="몸무게">
			</div>

			<button type="button" class="submit-btn">가입</button>
		</form>
	</div>
</body>
</html>
