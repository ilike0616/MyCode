<%--
  Created by IntelliJ IDEA.
  User: ilike
  Date: 2018/4/25
  Time: 上午11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<pre>
<%
    for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
        Thread thread = (Thread) stackTrace.getKey();
        StackTraceElement[] stack = (StackTraceElement[]) stackTrace.getValue();
        if (thread.equals(Thread.currentThread())) {
            continue;
        }
        System.out.print("\n线程：" + thread.getName() + "\n");
        for (StackTraceElement element : stack) {
            System.out.print("\t"+element+"\n");
        }
    }
%>
</pre>
</body>
</html>
