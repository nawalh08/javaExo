<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2024
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="dogs" type="java.util.ArrayList<org.example.exercice_5.model.Dog>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <title>Title</title>
</head>
<body>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 text-bg-dark rounded p-3">
            <h1 class="fw-light">- Dogs List -</h1>
            <hr>
            <% if (!dogs.isEmpty()) { %>
            <table class="table table-dark text-center align-middle">
                <thead>
                <tr>
                    <th> Id </th>
                    <th> Name </th>
                    <th> Breed </th>
                    <th> Date of birth </th>
                    <th> Action </th>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < dogs.size();i++) { %>
                <tr>
                    <td><%= dogs.get(i).getId() %></td>
                    <td><%= dogs.get(i).getName() %></td>
                    <td><%= dogs.get(i).getBreed() %></td>
                    <td><%= dogs.get(i).getBirthDate().getDayOfMonth()+"/"+dogs.get(i).getBirthDate().getMonthValue()+"/"+dogs.get(i).getBirthDate().getYear() %></td>
                    <td><button class="btn btn-success">details</button></td>

                </tr>

                <% } %>

                </tbody>

            </table>
            <% } else { %>
            <p>You don't have a dog !!!!</p>
            <% }  %>


        </div>
    </div>
</main>
</body>
</html>
