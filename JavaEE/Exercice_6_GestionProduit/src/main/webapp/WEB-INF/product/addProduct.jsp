<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 13/06/2024
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <title> Add Product</title>
</head>
<body>
<main class="container">

    <div class="col-8 offset-2 rounded text-bg-dark p-3">
        <form method="post" action="${pageContext.request.contextPath}/products/add">

            <div class="mb-3">
                <label for="brand" class="form-label">brand :</label>
                <input type="text" class="form-control" name="brand" id="brand" required>
            </div>
            <div class="mb-3">
                <label for="reference" class="form-label">Reference :</label>
                <input type="text" class="form-control" name="reference" id="reference" required>
            </div>

            <div class="mb-3">
                <label for="datePurchase" class="form-label">Date of purchase :</label>
                <input type="date" class="form-control" name="datePurchase" id="datePurchase" required>
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price :</label>
                <input type="number" class="form-control" name="price" id="price" required>
            </div>
            <div class="mb-3">
                <label for="stock" class="form-label">Stock :</label>
                <input type="number" class="form-control" name="stock" id="stock" required>
            </div>

            <button class="btn btn-success">Add product</button>
        </form>
    </div>
</main>
</body>
</html>
