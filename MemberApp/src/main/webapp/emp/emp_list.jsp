
<%@page import="com.sinse.memberapp.repository.EmpDAO"%>
<%@page import="com.sinse.memberapp.model.Emp"%>
<%@page import="java.util.List"%>
<%@page import="com.sinse.memberapp.repository.DeptDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!EmpDAO empDAO = new EmpDAO();

	List<Emp> list = empDAO.selectAll();%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td {
	text-align: center;
	vertical-align: middle;
}

table, td {
	border: 1px solid black;
}
</style>
</head>

<body>
	<table width="100%">
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>loc</th>
			<th>Mgr</th>
			<th>hiredate</th>
			<th>sal</th>
			<th>comm</th>
			<th>deptno</th>
			<th>dept_loc</th>
			<th>dept_name</th>
		</tr>

		<%
		for (Emp emp : list) {
		%>
		<tr>

			<td><%=emp.getEmpno()%></td>
			<td><%=emp.getEname()%></td>
			<td><%=emp.getJob()%></td>
			<td><%=emp.getMgr()%></td>
			<td><%=emp.getHiredate()%></td>
			<td><%=emp.getSal()%></td>
			<td><%=emp.getComm()%></td>
			<td><%=emp.getDept().getDeptno()%></td>
			<td><%=emp.getDept().getLoc()%></td>
			<td><%=emp.getDept().getDname()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>