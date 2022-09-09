<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/12/2022
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Result
    <span><%=request.getAttribute("value1")%></span>
    <span><%=request.getAttribute("calculator")%></span>
    <span><%=request.getAttribute("value2")%></span>

<%--    <c:catch var="NotZeroException">--%>
<%--            <%= request.getAttribute("value2").equals(0)%>--%>
<%--    </c:catch>--%>

<%--    <c:if test="${NotZeroException != null}">--%>
<%--    <p>The type of exception is : ${NotZeroException} <br/>--%>
<%--    There is an exception: ${NotZeroException.message}</p>--%>
<%--    </c:if>--%>

<span> = <%=request.getAttribute("result")%></span></p>
</body>
</html>
