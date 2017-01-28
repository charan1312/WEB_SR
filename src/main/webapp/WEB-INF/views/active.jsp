<%--
  Created by IntelliJ IDEA.
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
    <title>Active Item List</title>
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
<h3>
    <ul class="blue-button">
        Application List and Active Action Items List
    </ul>
</h3>

<c:set var="sep" value="/"/>
<c:set var="active" value="Active"/>
<c:set var="inactive" value="InActive"/>

<c:if test="${!empty apps}">
    <table width="60%">

        <tr>
            <th colspan="2">Total Number of Active Action Items: ${totalActiveCount}</th>
        </tr>

        <c:forEach items="${apps}" var="app" varStatus="index">
            <c:set var="i" value="${index.count}"/>
            <c:set var="i" value="${i - 1}" />
            <c:set var="lowerDesc" value="${fn:toLowerCase(app.description)}"/>
            <c:set var="hrefURL" value="${sep}${lowerDesc}${sep}${lowerDesc}${active}" />
            <tr>
                <td class="blue-button"><a href="<c:url value='${hrefURL}'/>"> ${app.description} </a></td>
                <td class="lightgray-button">Total count : ${appActiveCount[i]} </td>
            </tr>
            <tr>
                <td colspan="2"><br></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<%--
<a href="<c:url value='/vbv/vbvActive'/>"> VBV </a>
</br>
<a href="<c:url value='/vcas/vcasActive'/>" > VCAS </a>
</br>
<a href="<c:url value='/tpcas/tpcasActive'/>" > TPCAS </a>
</br>
<a href="<c:url value='/vdna/vdnaActive'/>" > VDNA </a>

--%>

</body>
</html>
