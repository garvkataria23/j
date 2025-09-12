<%@ page import="com.mycompany.prac6.studentbean" %>
<jsp:useBean id="student" class="com.mycompany.prac6.studentbean" scope="request" />

<html>
<head>
    <title>Student Info Display</title>
</head>
<body>
    <h2>Student Information</h2>
    <p><strong>Name:</strong> <jsp:getProperty name="student" property="name" /></p>
    <p><strong>Roll Number:</strong> <jsp:getProperty name="student" property="roll" /></p>
    <p><strong>Course:</strong> <jsp:getProperty name="student" property="course" /></p>
</body>
</html>
