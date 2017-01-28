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
    <title>VBV Completed Action Items</title>
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

<c:if test="${!empty vbvInActiveItems}">
    <h3>
        <ul class="blue-button">
            Completed Action Points
        </ul>
    </h3>

    <table class="tg">
        <tr>
            <th width="150">Action Item #</th>
            <th width="280">Creation Date Time</th>
            <th width="1500">Summary</th>
            <th width="2500">Description</th>
            <th width="280">Last Updated Time</th>
        </tr>
        <c:forEach items="${vbvInActiveItems}" var="vbvitem">
            <c:set var="hrefURL" value='/vbv/history/${vbvitem.serialNo}' />
            <tr>
                <td>
                    <a href="<c:url value='${hrefURL}'/>">
                        ${vbvitem.serialNo}
                    </a>
                </td>
                <td>${vbvitem.creationDate}</td>
                <td> ${vbvitem.summary}</td>
                <td>${vbvitem.description}</td>
                <td>${vbvitem.lastModified}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<c:if test="${empty vbvInActiveItems}">
    <h3>
        <ul class="no-data">
            There are No Completed Action Items
        </ul>
    </h3>
</c:if>

</body>
</html>
