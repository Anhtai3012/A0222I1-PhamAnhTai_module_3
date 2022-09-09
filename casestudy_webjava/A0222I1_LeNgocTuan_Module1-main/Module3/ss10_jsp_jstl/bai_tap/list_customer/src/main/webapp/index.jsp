<%@ page import="com.example.list_customer.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>List Customer</title>
    <style>
        .head {
            position: relative;
            left: 50%;
        }

        .table {
            position: relative;
            left: 40%;
        }

        td {
            width: 100px;
            height: 50px;
            padding: 10px;
            text-align: center;
        }

        img {
            width: 50px;
            height: 50px;
        }
    </style>
</head>
<body>
<div class="head">
    <h1><%= "List Customer!" %>
    </h1>
</div>
<br/>
<% List<Customer> list = new ArrayList<>();%>
<%
    list.add(new Customer("Khai", "11/11/1995", "Da Nang", "khai.png"));
    list.add(new Customer("Long", "31/01/1995", "Da Nang", "long.png"));
    list.add(new Customer("Vuong", "21/12/1995", "Quang Nam", "vuong.png"));
    list.add(new Customer("Will", "16/09/1995", "Da Nang", "will.png"));
    list.add(new Customer("Nhan", "01/07/1994", "Sai Gon", "nhan.png"));
%>

<div class="table">
    <table>
        <tr>
            <td><b>Full Name</b></td>
            <td><b>BirthDay</b></td>
            <td><b>Address</b></td>
            <td><b>Icon</b></td>
        </tr>
        <%
            for (Customer customer : list) { %>
        <tr>
            <td><%=customer.fullName%>
            </td>
            <td><%=customer.dateBirth%>
            </td>
            <td><%=customer.address%>
            </td>
            <td><img src="img/<%=customer.imageIcon%>" alt="No Load"></td>
        </tr>
        <% }
        %>
    </table>
</div>
</body>
</html>