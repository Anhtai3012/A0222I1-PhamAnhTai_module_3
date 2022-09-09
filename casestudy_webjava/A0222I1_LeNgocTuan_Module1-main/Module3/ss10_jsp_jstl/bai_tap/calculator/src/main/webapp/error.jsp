<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/12/2022
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<form action="index.jsp">
<p>value 2 = <%=request.getAttribute("value2") %> MUST difference 0 </p>
<p><input type="submit" name="Button" value ="Try Again"></p>
</form>
</body>
</html>
