<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 06/09/2022
  Time: 3:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>
<center>
    <form action="" method="post">
        <table>
            <tr>
                <th>List Member</th>
            </tr>
            <c:forEach var="member" items="${listMember}" >
                        <c:if test="${member.houseHoldId == houseHold.getId()}">
                            <tr>
                                <td>${member.fullName}</td>
                            </tr>
                        </c:if>
            </c:forEach>
        </table>
        <button type="submit">Close</button>
    </form>
</center>
</body>
</html>
