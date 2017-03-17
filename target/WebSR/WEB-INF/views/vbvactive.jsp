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
    <title>VBV Active Items</title>
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
        .orange-button{
            background: #ff8c1a;
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#ff8c1a',endColorstr='#188BC0',GradientType=0);
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
            background: #009933;
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
        .no-data{
            background: SteelBlue;
            color: white;
            font-size:12px;
            white-space: normal;
        }
    </style>
</head>
<body>

<form:form method="post" modelAttribute="item" action="/WebSR/vbv/add">
    <table width="60%">
        <tr>
            <th colspan="2">Enter Summary and Description to add a New Action Item</th>
        </tr>
        <tr>
            <td><form:label path="summary">Summary/Title:</form:label></td>
            <td><form:textarea path="summary" rows="5" cols="200" size="15" maxlength="4000" required="required"></form:textarea></td>
        </tr>
        <tr>
            <td><form:label path="description">Description:</form:label></td>
            <td><form:textarea path="description" rows="5" cols="200" size="15" maxlength="4000" required="required"></form:textarea></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   class="blue-button" value="Add New Item"/></td>
        </tr>
    </table>
</form:form>


</br>
<c:if test="${!empty vbvActiveItems}">
    <h3>
        <ul class="blue-button">
            Current Active Action Items
        </ul>
    </h3>

    <table class="tg">
        <tr>
            <th width=100">Serial No</th>
            <th width="280">Creation Date Time</th>
            <th width="1500">Summary</th>
            <th width="2500">Description</th>
            <th width="280">Last Updated Time</th>
            <th width="80">Action</th>
            <th width="220">Action</th>
        </tr>
        <c:forEach items="${vbvActiveItems}" var="vbvitem" varStatus="sNo">
            <c:set var="hrefURL" value='/vbv/history/${vbvitem.serialNo}' />
            <tr>
                <td>
                    <a href="<c:url value='${hrefURL}'/>">
                        ${sNo.count}
                    </a>
                </td>
                <td>${vbvitem.creationDate}</td>
                <td> ${vbvitem.summary}</td>
                <td>${vbvitem.description}</td>
                <td>${vbvitem.lastModified}</td>
                <td>
                    <a href="<c:url value='/vbv/update/${vbvitem.serialNo}' />" class="orange-button" >
                        Update
                    </a>
                </td>
                <td>
                    <a href="<c:url value='/vbv/markcomplete/${vbvitem.serialNo}' />" class="green-button" >
                            Mark Complete
                   </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty vbvActiveItems}">
    <h3>
        <ul class="no-data">
            There are no Current Active Action Items
        </ul>
    </h3>
</c:if>

<br>
<br>
<br>
<br>


<table border="0">
<tr>
    <td>
        <form:form name="HomeForm" action="/WebSR" >
            <input type="submit" class="orange-button" value="Main Home"/>
        </form:form>
    </td>
    <td>
        <form:form name="HomeForm" method="get" action="/WebSR/updates/active" >
            <input type="submit" class="orange-button" value="Active Home"/>
        </form:form>
    </td>
</tr>
</table>


</body>
</html>



