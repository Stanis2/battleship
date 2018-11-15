<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Registration</title>
</head>

<body>

<div class="w3-container w3-blue">
    <h2>Join the battle!</h2>
</div>

<form class="w3-container" method="post" action="/battleship/registration">
    <label for="username" class="w3-text-teal"><b>Enter your username:</b></label>
    <input id="username" class="w3-input w3-border w3-light-grey" type="text" name="username" minlength="4" maxlength="12" required>
    ${errorHolder.message}

    <button type="submit" class="w3-btn w3-blue-grey">Join</button>
</form>

</body>
</html>
