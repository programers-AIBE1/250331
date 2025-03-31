<%@ page import="org.example.t250331.model.domain.Anime" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: marsh825
  Date: 25. 3. 31.
  Time: 오후 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <pre>Test Result : <%= request.getAttribute("result") %></pre>--%>

<section>
    <ul>
        <% for (Anime a : (List<Anime>) request.getAttribute("result")) {%>
        <li>
            <%= a.title() %> / <%= a.description() %> / <%= a.createdAt() %> / <%= a.votes() %>
            <form method="post" action="vote">
                <input type="hidden" value="<%= a.uuid() %>" name="uuid" />
                <button>추천</button>
            </form>
        </li>
        <% } %>
    </ul>
</section>

<section>
    <form action="anime" method="post">
        <label>이름 : <input name="title"></label>
        <label>설명 : <input name="description"></label>
        <button>등록</button>
    </form>
</section>
</body>
</html>
