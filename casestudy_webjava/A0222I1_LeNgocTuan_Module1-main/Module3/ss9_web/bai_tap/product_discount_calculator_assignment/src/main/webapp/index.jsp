<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Calculator Bill" %>
</h1>
<br/>
<form method="post" action="/display-discount">
    <div class="buy-produce">
        <h2>Enter your product that you want to buy: </h2>
        <label>
            <input type="text" name="description" size="30" placeholder="description">
        </label>
        <label>
            <input type="text" name="price" size="30" placeholder="price"/>
        </label>
        <label>
            <input type="text" name="discount" size="30" placeholder="discount"/>
        </label>
        <input type="submit" value="Buy"/>
    </div>
</form>
</body>
</html>