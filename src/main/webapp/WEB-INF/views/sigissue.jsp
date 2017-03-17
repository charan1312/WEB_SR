<%--
  Created by IntelliJ IDEA.
  User: caware
  User: caware
  Date: 12/19/2016
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Significant Issue Detail</title>
    <style>
        .blue-button{
            background: #25A6E1;
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
            padding:3px 5px;
            color:#fff;
            font-family:'Helvetica Neue',sans-serif;
            font-size:13px;
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
            font-size:13px;
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
            font-size:13px;
            border-radius:2px;
            -moz-border-radius:2px;
            -webkit-border-radius:4px;
            border:1px solid #1A87B9
        }
        .lightgray-button{
            background: lightgray;
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#009933',endColorstr='#188BC0',GradientType=0);
            padding:3px 5px;
            color:#fff;
            font-family:'Helvetica Neue',sans-serif;
            font-size:12px;
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
</head>
<body>

<form:form name="UpdateItemForm" method="post" modelAttribute="issue" action="/WebSR/updates/sigissues/add">
    <table width="60%">
        <tr>
            <th>Signicant Issues ( Please give NA if none)</th>
        </tr>
        <tr>
            <td><form:textarea name="description" rows="15" cols="200" size="15" maxlength="4000" placeholder="${issue.description}" required="required" path="description"/> </td>
        </tr>
        <tr>
            <td><input type="submit" class="blue-button" value="Update"/></td>
        </tr>
    </table>
</form:form>

<br>
<br>
<br>
<br>

<form:form name="HomeForm" method="post" action="/WebSR" >
        <input type="submit" class="orange-button" value="Home"/>
</form:form>


</body>
</html>
