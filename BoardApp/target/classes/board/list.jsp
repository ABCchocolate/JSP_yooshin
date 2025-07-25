<%@ page contentType="text/html; charset=utf-8" %>
<%
	int totalRecord = 26;
	int pageSize = 10;
	int currentPage = 1;

	String paramPage = request.getParameter("currentPage");
	if (paramPage != null) {
		currentPage = Integer.parseInt(paramPage);
	}

	int totalpage = (int)Math.ceil((float)totalRecord / pageSize);
	int blockSize = 10;
	int firstPage = 10*((currentPage-1)/blockSize) + 1; //블럭당 시작페이지
	int lastPage = firstPage + (blockSize -1); //블럭당 마지막페이지
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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

.pageNum{
	font-size : 27px;
	font-weight:bold;
	color: red;
}
</style>	
</head>
<body>

<h2>총 레코드 수: <%= totalRecord %></h2>
<h2>총 페이지 수: <%= totalpage %></h2>
<h2>총 블록 크기: <%= blockSize %></h2>
<h2>현재 페이지: <%= currentPage %></h2>
<h2>첫번째 크기 : <%= firstPage %></h2>
<h2>마지막 크기: <%= lastPage %></h2>

<table>
  <tr>
    <th>No</th>
    <th>Last Name</th>
    <th>Points</th>
  </tr>
  <% for(int i = 0; i < pageSize; i++) { 
       int recordNo = (currentPage - 1) * pageSize + i + 1;
       if (recordNo > totalRecord) break;
  %>
  <tr>
    <td><%= recordNo %></td>
    <td>Smith</td>
    <td>50</td>
  </tr>
  <% } %>

  <tr>
  	<td colspan="3" align="center">
  	<%if(firstPage - 1 > 0 ){ %>
 	  <a href="?currentPage=<%=firstPage - 1 %>">⬅</a>
  	  <%}else{ %>
  	  <a href="javascript:alert('이전페이지가 없습니다.');<%=firstPage - 1 %>">⬅</a>
  	  <%} %>
  	  <% 
  		for (int i = firstPage; i <= lastPage; i++) {
  	  %>
  	    <a <%if(currentPage == i){%>class ="pageNum" <%}%> href="?currentPage=<%= i %>">[<%= i %>]</a>
  	  <% } %>
  	  <a href="?currentPage=<%=lastPage + 1 %>">➤</a>
  	</td>
  </tr>
</table>

</body>
</html>
