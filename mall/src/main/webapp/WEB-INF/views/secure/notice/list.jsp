<%@page import="mall.domain.Notice"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List<Notice> list=(List)request.getAttribute("noticeList");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
body {
  font-family: 'Noto Sans KR', sans-serif;
  background-color: #fdfbfb;
  margin: 0;
  padding: 30px;
  color: #333;
}

h2 {
  text-align: center;
  color: #d63384;
  margin-bottom: 10px;
}

p {
  text-align: center;
  color: #888;
  margin-bottom: 30px;
  font-size: 14px;
}

table {
  width: 100%;
  max-width: 900px;
  margin: auto;
  border-collapse: collapse;
  background-color: white;
  box-shadow: 0 4px 12px rgba(0,0,0,0.05);
  border-radius: 10px;
  overflow: hidden;
}

th {
  background-color: #ffebf2;
  color: #b1004b;
  text-align: center;
  padding: 14px;
  font-weight: 600;
  font-size: 15px;
  border-bottom: 1px solid #ddd;
}

td {
  text-align: center;
  padding: 14px;
  font-size: 14px;
  border-bottom: 1px solid #f0f0f0;
}

tr:hover td {
  background-color: #fff7fb;
}

tr:last-child td {
  border-bottom: none;
}

a {
  text-decoration: none;
  color: #333;
}

a:hover {
  color: #ff4081;
  font-weight: bold;
}

button {
  background-color: #ff66a3;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  font-size: 15px;
  margin-top: 10px;
}

button:hover {
  background-color: #e25592;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(()=>{
		$("button").click(()=>{
			location.href="/notice/write.jsp";
		});
	});
</script>
</head>
<body>

<h2>Zebra Striped Table</h2>
<p>For zebra-striped tables, use the nth-child() selector and add a background-color to all even (or odd) table rows:</p>

<table>
  <tr>
    <th>No</th>
    <th>제목</th>
    <th>작성자</th>
    <th>등록일</th>
    <th>조회</th>
  </tr>
  
  <%for(int i=0;i<list.size();i++){ %>
  <% Notice notice=list.get(i);%>
  <tr>
    <td>Jill</td>
    <td><a href="/notice/content.do?notice_id=<%=notice.getNotice_id()%>"><%=notice.getTitle() %></a></td>
    <td><%=notice.getWriter() %></td>
    <td><%=notice.getRegdate()%></td>
    <td><%=notice.getHit() %></td>
  </tr>
	<%} %>
	<tr>
		<td colspan="5"><button>글등록</button></td>		
	</tr>
</table>

</body>
</html>