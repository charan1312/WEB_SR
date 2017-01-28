<%--
  Created by IntelliJ IDEA.
  User: caware
  Date: 11/12/2016
  Time: 01:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        .blue-button{
            background: #25A6E1;
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
            padding:3px 5px;
            color:#fff;
            font-family:'Helvetica Neue',sans-serif;
            font-size:12px;
            border-radius:2px;
            -moz-border-radius:2px;
            -webkit-border-radius:4px;
            border:1px solid #1A87B9
        }
        .active-text{
            position: absolute;
            padding:0;
            margin:0;

            top:0;
            left:0;

            background-color:green;

            color: white;
            text-align: center;
            font-size:15px;
            white-space: normal;

        }
        .inactive-text{
            position: absolute;
            padding:0;
            margin:0;

            top:0;
            left:0;

            text-align: center;
            font-size:15px;

            background: lightyellow;
            color: black;
            text-align: center;
            font-size:15px;
            white-space: normal;
        }
        table {
            font-family: "Helvetica Neue", Helvetica, sans-serif;
            width: 50%;
        }
        th {
            background: SteelBlue;
            color: white;
        }
        td,th{
            border: 1px solid gray;
            width: 25%;
            text-align: left;
            padding: 5px 10px;
        }
    </style>
    <title>Shift Report</title>
</head>


<body>

<div class="modal-body row">
    <div class="col-md-6">
        <p>
            <a href="<c:url value='/updates/active'/>" > Current Action Items </a>
        </p>
        </br>


    </div>
    <div class="col-md-6">
        <p class="inactive-text">
            <a href="<c:url value='/updates/inactive'/>" > Past Action Items </a>
        </p>
    </div>
</div>

<%--
    <a href="<c:url value='/updates/active'/>" > Current Action Items </a>
    </br>
    <a href="<c:url value='/updates/inactive'/>" > Past Action Items </a>
--%>

</body>
</html>
