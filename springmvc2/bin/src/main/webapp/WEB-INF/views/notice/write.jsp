<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>공지 작성</title>
<style>
body {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  background: linear-gradient(120deg, #f6f9fc, #e2f0ff);
  margin: 0;
  padding: 0;
}

h3 {
  text-align: center;
  color: #333;
  margin-top: 40px;
  animation: fadeIn 1s ease-in;
}

.container {
  max-width: 600px;
  margin: 40px auto;
  background-color: #ffffff;
  padding: 30px 40px;
  border-radius: 10px;
  box-shadow: 0 10px 20px rgba(0,0,0,0.1);
  animation: slideUp 0.6s ease-out;
}

label {
  font-weight: bold;
  margin-top: 10px;
  display: block;
  color: #555;
}

input[type=text], textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 6px;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
  font-size: 14px;
  transition: all 0.3s ease;
}

input[type=text]:focus,
textarea:focus {
  border-color: #00aaff;
  outline: none;
  box-shadow: 0 0 5px rgba(0, 170, 255, 0.3);
}

input[type=button] {
  background-color: #00aaff;
  color: white;
  padding: 14px 20px;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  width: 100%;
  font-size: 16px;
  transition: background-color 0.3s ease;
}

input[type=button]:hover {
  background-color: #007acc;
}

/* 애니메이션 */
@keyframes fadeIn {
  from { opacity: 0; transform: translateY(-20px); }
  to { opacity: 1; transform: translateY(0); }
}

@keyframes slideUp {
  from { transform: translateY(50px); opacity: 0; }
  to { transform: translateY(0); opacity: 1; }
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
  $(() => {
    $("input[type='button']").click(() => {
      $("form").attr({
        action: "/notice/regist",
        method: "POST",
      });
      $("form").submit();
    });
  });
</script>
</head>
<body>

<h3>공지사항 등록</h3>

<div class="container">
  <form>
    <label for="fname">제목</label>
    <input type="text" id="fname" name="title" placeholder="제목 입력...">

    <label for="lname">작성자</label>
    <input type="text" id="lname" name="writer" placeholder="작성자 입력...">

    <label for="subject">내용</label>
    <textarea id="content" name="content" placeholder="내용을 입력하세요..." style="height: 200px;"></textarea>

    <input type="button" value="등록하기">
  </form>
</div>

</body>
</html>
