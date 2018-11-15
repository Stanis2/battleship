<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Place your ships</title>
</head>

<body>
    <div class="w3-panel w3-blue">
        <h1 class="w3-opacity">
            <b>${myGame.user.name}, place your ships! </b></h1>
    </div>
<form>
    <table>
        <tr>
            <td>&nbsp</td>
        <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
            <td>${col}</td>
        </c:forEach>
        </tr>
        <c:forEach begin="1" end="10" var="row">
            <tr>
                <td>${row}</td>
                <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                    <td>
                        <input type="checkbox" name="cell" value="${col}${row}">
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
    <button type="submit">BATTLE!</button>
</form>

</body>
</html>
