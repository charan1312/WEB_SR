<%--
  Created by IntelliJ IDEA.
  User: caware
  Date: 12/19/2016
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>VBV Item History</title>
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
        table {
            /*width: 50%;*/
            font-family:'Calibri',sans-serif;
            white-space: normal;
        }
        th {
            background: SteelBlue;
            color: white;
            font-size:12px;
            white-space: normal;
        }
        td,th{
            border: 1px solid gray;
            /*width: 25%;*/
            white-space: normal;
            text-align: left;
            font-size:12px;
            padding: 3px 6px;
        }
    </style>
</head>
<body>
<h3>
    <ul class="blue-button">
        Item History List
    </ul>
</h3>
<c:if test="${!empty allOlderUpdatesOfItem}">
    <table class="tg">
        <tr>
            <th width="1000">#</th>
            <th width="1000">Summary</th>
            <th width="4000">Description</th>
            <th width="300">Last Updated Time</th>
        </tr>
        <c:forEach items="${allOlderUpdatesOfItem}" var="historyItem" varStatus="sNo">
            <tr>
                <td>${sNo.count}</td>
                <td>${historyItem.summary}</td>
                <td>${historyItem.description}</td>
                <td>${historyItem.lastModified}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty allOlderUpdatesOfItem}">
    <ul class="blue-button">
        No other updates for this Item
    </ul>
</c:if>

</body>
</html>
