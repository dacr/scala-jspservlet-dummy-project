<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="dummy.MetaInfo" %>
<%!
  // Of course this is not thread safe
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:MM:ss.SSS");
%>
<html>
<head>
</head>
<body>
  <h1> <%=sdf.format(new Date()) %>  </h1>
<p>
  project <%=MetaInfo.project()%> release <%=MetaInfo.version()%>
</p>
</body>
</html>
