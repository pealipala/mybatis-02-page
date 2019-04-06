<%--
  Created by IntelliJ IDEA.
  User: 叶朝泽
  Date: 2019/4/6
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <table border="1">
      <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
      </tr>
      <c:forEach items="${pageInfo.list}" var="list">
        <tr>
          <td>${list.id}</td>
          <td>${list.name}</td>
          <td>${list.age}</td>
        </tr>
      </c:forEach>
    </table>
    <a href="page?pageNumber=${pageInfo.pageNumber-1}&pageSize=${pageInfo.pageSize}" <c:if test="${pageInfo.pageNumber<=1}"> onclick="javascript;return false;"</c:if>>上一页</a>
    <a href="page?pageNumber=${pageInfo.pageNumber+1}&pageSize=${pageInfo.pageSize}" <c:if test="${pageInfo.pageNumber>=pageInfo.total}"> onclick="javascript;return false;"</c:if>>下一页</a>
  </body>
</html>
