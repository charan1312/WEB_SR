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
    <title>VBV Item Updates</title>
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
        .no-data{
            background: SteelBlue;
            color: white;
            font-size:12px;
            white-space: normal;
            font-family:'Calibri',sans-serif;
        }
        .yellow-button{
            background: #FFD700;
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#FFD700',endColorstr='#188BC0',GradientType=0);
            padding:3px 5px;
            color:#fff;
            font-family:'Helvetica Neue',sans-serif;
            font-size:12px;
            border-radius:2px;
            -moz-border-radius:2px;
            -webkit-border-radius:4px;
            border:1px solid #1A87B9
        }
        .green-button{
            background: #006400;
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#006400',endColorstr='#188BC0',GradientType=0);
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

<form:form method="post" modelAttribute="newUpdate" action="/WebSR/vbv/history/add">
    <table width="60%">
        <tr>
            <th colspan="2">Update Item</th>
        </tr>
        <tr>
            <td><form:label path="serialNo">Original Action Item Number:</form:label></td>
            <td><form:input path="serialNo" size="15" maxlength="40" placeholder="${newUpdate.serialNo}" readonly="true"/> </td>
        </tr>
        <tr>
            <td><form:label path="summary">Summary/Title:</form:label></td>
            <td><form:textarea path="summary" rows="5" cols="200" size="15" maxlength="4000" placeholder="${newUpdate.summary}"/> </td>
        </tr>
        <tr>
            <td><form:label path="description">Description:</form:label></td>
            <td><form:textarea path="description" rows="5" cols="200" size="15" maxlength="4000" placeholder="${newUpdate.description}"/> </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   class="blue-button" value="Add Update"/></td>
        </tr>
    </table>
</form:form>


</br>
<h3>
    <ul class="blue-button">
        Past Update(s) on this Item
    </ul>
</h3>
<c:if test="${!empty allOlderUpdatesOfItem}">
    <table class="tg">
        <tr>
            <th width="25">#</th>
            <th width="2000">Summary</th>
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
    <ul class="no-data">
        No previous updates for this Item
    </ul>
</c:if>


<%--                                                                   --%>

</br>
<h3>
    <ul class="blue-button">
        Current Update on this Item
    </ul>
</h3>

<table class="tg">
    <tr>
        <th width="25">#</th>
        <th width="2000">Summary</th>
        <th width="4000">Description</th>
        <th width="300">Last Updated Time</th>
    </tr>
    <tr>
        <td>1</td>
        <td>${newUpdate.summary}</td>
        <td>${newUpdate.description}</td>
        <td>${newUpdate.lastModified}</td>
    </tr>
</table>

</body>
</html>
