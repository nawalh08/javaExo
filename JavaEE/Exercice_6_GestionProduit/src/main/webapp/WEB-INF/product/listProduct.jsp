<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 13/06/2024
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="products" type="java.util.ArrayList<org.example.exercice_6_gestionproduit.model.Products>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

    <title> Product List </title>
</head>
<body>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 text-bg-dark rounded p-3">
            <h1 class="fw-light">- Product List -</h1>
            <hr>
            <% if (!products.isEmpty()) { %>
            <table class="table table-dark text-center align-middle">
                <thead>
                <tr>
                    <th> Id </th>
                    <th> Brand </th>
                    <th> Reference </th>
                    <th> Date of purchase </th>
                    <th> Price </th>
                    <th> Stock </th>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < products.size();i++) { %>
                <tr>
                    <td><%= products.get(i).getId() %></td>
                    <td><%= products.get(i).getBrand() %></td>
                    <td><%= products.get(i).getReference() %></td>
                    <td><%= products.get(i).getDatePurchase() %></td>
                    <td><%= products.get(i).getPrice() %></td>
                    <td><%= products.get(i).getStock() %></td>


                </tr>

                <% } %>

                </tbody>

            </table>
            <% } else { %>
            <p>You don't have a product !!!!</p>
            <% }  %>


        </div>
    </div>
</main>

</body>
</html>
