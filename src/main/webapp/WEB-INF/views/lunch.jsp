<%--
  Created by IntelliJ IDEA.
  User: marsh825
  Date: 25. 3. 31.
  Time: 오전 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>오늘의 점심 메뉴</title>
</head>
<body>
<h1>🍽️ 오늘의 점심 메뉴 추천 🍽️</h1>
<h2>${lunch.name}</h2>
<p>카테고리: ${lunch.category}</p>
<p>설명: ${lunch.description}</p>
<button onclick="location.reload()">다른 메뉴 추천받기</button>
</body>
</html>