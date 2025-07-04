<%@page import="java.util.List"%>
<%@page import="tls.study.model.News"%>
<%@page import="tls.study.repository.NewsDAO"%>
<%@page import="tls.study.common.util.Paging"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%! 
	NewsDAO newsDAO = new NewsDAO();
	Paging paging = new Paging();
%>
<%
	List<News> list = newsDAO.selectAll();
	paging.init(list, request);
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">

<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
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

<h2>자유 게시판</h2>
<p> 자유롭게 글을 작성해주세요.</p>
<table>
		<tr>
			<th>No</th>
			<th>기사 제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<%
			int curPos=paging.getCurPos();
			int num=paging.getNum();
		%>
		<%for(int i=1;i<=paging.getPageSize();i++){ %>
		<%if(num<1)break; %>
		<%News news=list.get(curPos++); %>
		<tr>
			<td><%=num--%></td>
			<td><a href="/day0703/content.jsp?news_id=<%=news.getNews_id()%>"><%=news.getTitle() %></a></td>
			<td><%=news.getWriter() %></td>
			<td><%=news.getRegdate() %></td>
			<td><%=news.getHit() %>
		</tr>
		<%}%>
		<tr>
			<td colspan="5">
				◀
				<%for(int i=paging.getFirstpage();i<=paging.getLastpage();i++){%>
				<%if(i>paging.getTotalPage())break; //총 페이지수를 넘어서면 그만두기%>
				<a  <%if(paging.getCurrentPage()==i){%>class="pageNum"<%}%>  href="/news/list.jsp?currentPage=<%=i%>">[ <%=i%> ]</a>
				<%} %>
				▶
			</td>
		</tr>
		
		<tr>
			<td colspan="5">
				<button>글쓰기</button>
			</td>
		</tr>
	</table>
</table>

</body>
</html>