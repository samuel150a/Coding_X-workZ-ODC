
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>All datas</h1>



<table border="1">
    <tr>
        <th>ID</th>
        <th>centerName</th>
        <th>mobileBrand</th>
        <th>modelNumber</th>
        <th>defectType</th>
        <th>custumberName</th>
        <th>warrentry</th>
        <th>Update</th>
        <th>Delete</th>

    </tr>
    <c:forEach var="menu" items="${data}">
        <tr>
            <td>${menu.ID}</td>
            <td>${menu.centerName}</td>
            <td>${menu.mobileBrand}</td>
            <td>${menu.modelNumber}</td>
            <td>${menu.defectType}</td>
            <td>${menu.custumberName}</td>
            <td>${menu.warrentry}</td>
            <td> <a href="edit?id=${menu.ID}">edit</a></td>
            <td> <a href="delete?id=${menu.ID}">delete</a></td>

        </tr>
    </c:forEach>
</table>

</body>
</html>