<%@ page 
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Date"
    session="true"
    buffer="8kb"
    autoFlush="true"
    errorPage="error.jsp"
    isErrorPage="false"
    info="This is a basic demo of JSP page directive attributes"
%>

<html>
<head>
    <title>Page Directive Attributes Demo</title>
</head>
<body>

<h2>If only life was simple</h2>

<p><strong>Current Time:</strong> <%= new Date() %></p>

<p><strong>Session Enabled:</strong> <%= session != null ? "Yes" : "No" %></p>

<p><strong>Buffer Size:</strong> 8kb</p>

<p><strong>Auto Flush:</strong> true</p>

<p><strong>Page Info:</strong> <%= getServletInfo() %></p>

</body>
</html>

