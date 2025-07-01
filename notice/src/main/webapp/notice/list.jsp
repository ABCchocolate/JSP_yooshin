<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sinse.notice.model.Notice" %>

<%
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Notice> list = new ArrayList<>();

    try {
        // 1. DB 연결
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "shop", "12341234");

        // 2. 쿼리 실행
        pstmt = con.prepareStatement("SELECT * FROM notice ORDER BY notice_id DESC");
        rs = pstmt.executeQuery();

        // 3. 결과 저장
        while (rs.next()) {
            Notice notice = new Notice();
            notice.setNotice_id(rs.getInt("notice_id"));
            notice.setTitle(rs.getString("title"));
            notice.setWriter(rs.getString("writer"));
            notice.setRegdate(rs.getString("regdate"));
            notice.setContent(rs.getString("content"));
            notice.setHit(rs.getInt("hit"));
            list.add(notice);
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
<title>공지사항 목록</title>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
        border: 1px solid #ddd;
    }
    th, td {
        padding: 12px;
        border: 1px solid #ccc;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    a {
        text-decoration: none;
        color: blue;
    }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
    $(() => {
        $("button").click(() => {
            location.href = "/notice/write.html";
        });
    });
</script>
</head>
<body>

<h2>📋 공지사항 리스트</h2>
<table>
    <tr>
        <th>No</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
        <th>조회수</th>
    </tr>

    <%
        int no = list.size();
        for (Notice notice : list) {
    %>
    <tr>
        <td><%= no-- %></td>
        <td><a href="/notice/detail.jsp?notice_id=<%=notice.getNotice_id()%>"><%= notice.getTitle() %></a></td>
        <td><%= notice.getWriter() %></td>
        <td><%= notice.getRegdate() %></td>
        <td><%= notice.getHit() %></td>
    </tr>
    <% } %>

    <tr>
        <td colspan="5" style="text-align: right;">
            <button type="button">글등록</button>
        </td>
    </tr>
</table>

</body>
</html>
