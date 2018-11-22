<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Place your ships</title>
</head>

<body>
<div class="w3-panel w3-blue">
    <h1 class="w3-opacity w3-animate-left">
        <b>${myGame.user.name}, place your ships! </b></h1>
</div>
${errorHolder.message}
<form method="post" action="shipplacement">
    <table class="w3-centered w3-margin w3-hoverable">
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
                        <c:set var="addr" value="${col}${row}"/>
                        <input type="checkbox"
                               name="cell"
                               value="${col}${row}"
                               <c:if test="${tempShipHolder.ships[addr]}">checked</c:if>>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
    <button class="w3-margin" type="submit">BATTLE!</button>
</form>

</body>
</html>
