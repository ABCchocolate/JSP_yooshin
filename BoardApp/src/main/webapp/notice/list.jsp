<%@page import="com.sinse.boardapp.model.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.sinse.boardapp.repository.NoticeDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	NoticeDAO noticeDAO = new NoticeDAO();
  	List<Notice> list = noticeDAO.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(() => {
		$("button").click(() => {
			location.href = "/notice/write.jsp";
		});
	});
</script>
<style>
table {
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
}
th, td {
  text-align: left;
  padding: 16px;
}
tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
</head>
<body>

<h2>공지사항 목록</h2>

<table>
  <tr>
    <th>No</th>
    <th>제목</th>
    <th>작성자</th>
    <th>등록일</th>
    <th>조회</th>
  </tr>
  <% for (int i = 0; i < list.size(); i++) { 
         Notice n = list.get(i);
  %>
    <tr>
      <td><%= n.getNotice_id() %></td>
      <td>
        <a href="content.jsp?notice_id=<%= n.getNotice_id() %>">
          <%= n.getTitle() %>
        </a>
      </td>
      <td><%= n.getWriter() %></td>
      <td><%= n.getRegdate() %></td>
      <td><%= n.getHit() %></td>
    </tr>
  <% } %>
  <tr>
    <td colspan="5"><button>글등록</button></td>
  </tr>
</table>

</body>
</html>
