<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2024
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

    <title> Dogs list </title>
</head>
<body>
<main class="container">

    <div class="col-8 offset-2 rounded text-bg-dark p-3">
        <form method="post" action="${pageContext.request.contextPath}/dogs">

            <div class="mb-3">
                <label for="name" class="form-label">Name :</label>
                <input type="text" class="form-control" name="name" id="name" required>
            </div>
            <div class="mb-3">
                <label for="breed" class="form-label">Breed :</label>
                <input type="text" class="form-control" name="breed" id="breed" required>
            </div>
            <div class="mb-3">
                <label for="birthDate" class="form-label">Date of birth :</label>
                <input type="date" class="form-control" name="birthDate" id="birthDate" required>
            </div>

            <button class="text-end">Add</button>
        </form>
    </div>
</main>
</body>
</html>
