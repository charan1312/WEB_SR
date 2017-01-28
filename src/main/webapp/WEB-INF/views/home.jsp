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

    <link href="resources/css/bootstrap.min.css" media="screen" rel="stylesheet" type="text/css" />
    <link href="resources/css/all.css" media="screen" rel="stylesheet" type="text/css" />
    <link href="resources/css/font-awesome.min.css" media="screen" rel="stylesheet" type="text/css" />


    <style>
        .blue-button{
            background: #25A6E1;
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
            padding:3px 5px;
            color:#fff;
            font-family:'Helvetica Neue',sans-serif;
            font-size:18px;
            border-radius:2px;
            -moz-border-radius:2px;
            -webkit-border-radius:4px;
            border:1px solid #1A87B9
        }
        .orange-button{
            background: #ff8c1a;
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#ff8c1a',endColorstr='#188BC0',GradientType=0);
            padding:3px 5px;
            color:#fff;
            font-family:'Helvetica Neue',sans-serif;
            font-size:18px;
            border-radius:2px;
            -moz-border-radius:2px;
            -webkit-border-radius:4px;
            border:1px solid #1A87B9
        }
        .green-button{
            background: #009933;
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#009933',endColorstr='#188BC0',GradientType=0);
            padding:3px 5px;
            color:#fff;
            font-family:'Helvetica Neue',sans-serif;
            font-size:18px;
            border-radius:2px;
            -moz-border-radius:2px;
            -webkit-border-radius:4px;
            border:1px solid #1A87B9
        }
        .lightgreen-button{
            background: lightgray;
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#009933',endColorstr='#188BC0',GradientType=0);
            padding:3px 5px;
            color:#fff;
            font-family:'Helvetica Neue',sans-serif;
            font-size:18px;
            border-radius:2px;
            -moz-border-radius:2px;
            -webkit-border-radius:4px;
            border:1px solid #1A87B9
        }
        table {
            /*width: 50%;*/
            font-family:'Calibri',sans-serif;
            white-space: normal;
        }
        th {
            background: SteelBlue;
            color: white;
            font-size:15px;
            white-space: normal;
        }
        td{
            border: 1px solid gray;
            /*width: 25%;*/
            white-space: normal;
            text-align: left;
            font-size:12px;
            padding: 3px 6px;
        }
        .no-data {
            background: SteelBlue;
            color: white;
            font-size: 12px;
            white-space: normal;
        }
    </style>
    <title>Shift Report</title>
</head>


<body>

<!--
<div class='container' role="banner">
    <header class='clearfix'>
        <div class='pull-left'>
            <img alt='visa logo' src='/WEB-INF/images/logo.png'>
        </div>
        <div class='pull-right'>
            <div id='header_title'>Action Point Tracking System</div>
        </div>
    </header>
</div>
-->

<div style="width: 70%;overflow:auto;">
    <ul class="blue-button">
        <div style="text-align:center; width: 75%;">
            <a href="<c:url value='/updates/active'/>" > Current Action Items </a>
        </div>
    </ul>
    <br>
    <br>
    <br>
    <br>
    <ul class="green-button">
        <div style="text-align:center; width: 75%;">
            <a href="<c:url value='/updates/inactive'/>" > Past Action Items </a>
        </div>
    </ul>
 </div>
<div style="clear:both"></div>
<%--
    <a href="<c:url value='/updates/active'/>" > Current Action Items </a>
    </br>
    <a href="<c:url value='/updates/inactive'/>" > Past Action Items </a>
--%>


<!--
<footer class='text-center' style="position:relative"> &copy; Copyright 2015 Visa Inc.
    All Rights Reserved </footer>
-->

</body>
</html>
