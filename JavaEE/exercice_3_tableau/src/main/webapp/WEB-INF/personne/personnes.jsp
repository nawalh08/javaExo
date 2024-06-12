<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/06/2024
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="lastName" type="java.lang.String" scope="request" />
<jsp:useBean id="firstName" type="java.lang.String" scope="request" />
<jsp:useBean id="age" type="java.lang.Integer" scope="request" />
<jsp:useBean id="personnes" type="java.util.ArrayList<java.lang.String>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <title>Les 3 personnes </title>

    <% for (String p : personnes) { %>
     <ul><li> <%= p %></li></ul>

<% } %>



</head>
<body>

</body>
</html>
