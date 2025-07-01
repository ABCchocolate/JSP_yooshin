<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sinse.notice.model.Notice" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Notice notice = null; // try 밖에서 선언

    try {
        // 1. DB 연결
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "shop", "12341234");

        // 2. 쿼리 실행
        String pk = request.getParameter("notice_id");
        pstmt = con.prepareStatement("SELECT * FROM notice WHERE notice_id = ?");
        pstmt.setInt(1, Integer.parseInt(pk)); // SQL 인젝션 방지

        rs = pstmt.executeQuery(); // 누락되었던 쿼리 실행

        if (rs.next()) {
            notice = new Notice();
            notice.setNotice_id(rs.getInt("notice_id"));
            notice.setTitle(rs.getString("title"));
            notice.setWriter(rs.getString("writer"));
            notice.setRegdate(rs.getString("regdate"));
            notice.setContent(rs.getString("content"));
            notice.setHit(rs.getInt("hit"));
        }
    } catch (Exception e) {
        out.println("<p>DB 연결 또는 조회 실패: " + e.getMessage() + "</p>");
        e.printStackTrace();
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote();
		
		$("input[type='button']").click(()=>{
			$("form").submit(); 
		});
	});
</script>

<style>
body { font-family: Arial, Helvetica, sans-serif; }
* { box-sizing: border-box; }

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}
input[type=button] {
	background-color: #04AA6D;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
input[type=button]:hover { background-color: #45a049; }
.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
</head>
<body>

	<h3>Contact Form</h3>

	<div class="container">
		<form action="/notice/write" method="post">
			<label for="fname">제목</label>
			<input type="text" id="fname" name="title" value="<%= notice != null ? notice.getTitle() : "" %>">

			<label for="lname">작성자</label>
			<input type="text" id="lname" name="writer" value="<%= notice != null ? notice.getWriter() : "" %>">

			<label for="subject">내용</label>
			<textarea id="summernote" name="content" style="height: 200px"><%= notice != null ? notice.getContent() : "" %></textarea>

			<input type="button" value="등록">
		</form>
	</div>

</body>
</html>
