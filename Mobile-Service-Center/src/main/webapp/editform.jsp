<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Apply For Mobile Service</title>
</head>

<body>

<form action="update" method="post">
    ID : <input type="int" name="ID" value="${Data.ID}" readonly> <br><br>
    CenterName : <input type="text"  name="centerName" value="${Data.centerName} "> <br><br>
    MobileBrand : <input type="text" name="mobileBrand" value="${Data.mobileBrand}"><br><br>
    ModelNumber : <input type="number" name="modelNumber" value="${Data.modelNumber}"><br><br>
    DefectType : <input type="text" name="defectType"value="${Data.defectType}"><br><br>
    CustumberName : <input type="text" name="custumberName" value="${Data.custumberName}"><br><br>
    Warrentry : <input type="date" name="warrentry" value="${Data.warrentry}"><br><br>
    <input type="submit" value="submit">

</form>


</body>
</body>
</body>
</html>