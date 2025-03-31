<%--
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
    <pre>Result : <%= request.getAttribute("result") %></pre>

    <section>
        <form action="anime" method="post">
            <label>이름 : <input name="title"></label>
            <label>설명 : <input name="description"></label>
            <button>등록</button>
        </form>
    </section>
</body>
</html>
