<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/06/2024
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <title>Formulaire</title>

</head>
<body>
<form>
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" placeholder="Enter name">
    </div>
    <div class="form-group">
        <label for="race">Race</label>
        <input type="text" class="form-control" id="race" placeholder="Enter race">
    </div>
    <div class="form-group">
        <label for="meal">Meal</label>
        <input type="text" class="form-control" id="meal" placeholder="Enter meal">
    </div>
    <div class="form-group">
        <label for="birth">Name</label>
        <input type="date" class="form-control" id="birth" placeholder="Enter birth">
    </div>

    <button type="submit" class="btn btn-primary">Add animals</button>

</form>
</body>
</html>
