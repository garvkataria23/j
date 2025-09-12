<%@ page import="com.mycompany.prac6.studentbean" %>
<jsp:useBean id="student" class="com.mycompany.prac6.studentbean" scope="request" />
<jsp:setProperty name="student" property="*" />

<jsp:forward page="display.jsp" />
