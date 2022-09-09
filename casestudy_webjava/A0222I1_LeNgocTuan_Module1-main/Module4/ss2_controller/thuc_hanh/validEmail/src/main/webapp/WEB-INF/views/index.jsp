<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="eu">

<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>

<form action="/checkValid" method="post">
  <h1>Email</h1>
  <c:if test="${message!=null}">
    <p>${message}</p>
  </c:if>
  <label>
    <input type="text" name="email">
  </label>
  <button type="submit">Check</button>
</form>
</body>
</html>