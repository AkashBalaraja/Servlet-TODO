<%@page import="dto.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Task> list = (List<Task>)request.getAttribute("list"); 
%>

<table border="2px">
<tr>
<th colspan="9">Welcome to Todo Home</th>
</tr>

<tr>
<th>ID</th>
<th>TaskName</th>
<th>Task description</th>
<th>Task date</th>
<th>Complete Before</th>
<th>Status</th>
<th>Change Status</th>
<th>Delete</th>
<th>Update</th>
</tr>

<%for(Task task:list ){ %>
<tr>
<td><%=task.getId() %></td>
<td><%=task.getName()%></td>
<td><%=task.getDescription() %></td>
<td><%=task.getTaskDate() %></td>
<td><%=task.getCompletionDate() %></td>
<td><%=task.isStatus() %></td>s
<td><button>Change</button></td>
<td><button>Delete</button></td>
<td><button>Update</button></td>
</tr>
<%} %>
</table>

<a href="AddTask.html"><button style="margin-left: 20px">Add Task</button></a>
<a href="login.html"><button style="margin-left: 500px">Logout</button></a>

</body>
</html>