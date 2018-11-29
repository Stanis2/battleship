<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Game</title>
    <style>
        .EMPTY {
            background-color: azure;
        }
        .SHIP {
            background-color: slategray;
        }
        .MISS {
            background-color: aqua;
        }
        .HIT {
            background-color: crimson;
        }
    </style>
    <c:if test="${not myGame.myTurn}">
        <meta http-equiv="refresh" content="3">
    </c:if>
</head>

<body>
<div class="w3-panel w3-blue">
    <h1 class="w3-opacity w3-animate-left">
        <c:if test="${myGame.myTurn}">
            <b>${myGame.user.name}, attack your enemy! </b></h1>
        </c:if>
        <c:if test="${not myGame.myTurn}">
            <b>${myGame.user.name}, wait for your turn! </b></h1>
        </c:if>
</div>
<form method="post" action="game">
    <table class="w3-centered w3-margin w3-hoverable w3-table-all">
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
                    <c:set var="addr" value="${col}${row}"/>
                    <td class="${myGame.user.enemyField.getState(addr)}">
                        <c:if test="${myGame.myTurn}">
                            <input type="radio" name="cell" value="${addr}">
                        </c:if>
                        &nbsp;
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
    <table class="w3-centered w3-margin w3-hoverable w3-table-all">
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
                    <c:set var="addr" value="${col}${row}"/>
                    <td class="${myGame.user.myField.getState(addr)}">
                        &nbsp;
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${myGame.myTurn}">
        <button class="w3-margin" type="submit">FIRE!</button>
    </c:if>
</form>
</body>
</html>
