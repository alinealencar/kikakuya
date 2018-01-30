<!-- Change feature variable -->
<%! String feature = "New Page" ;%>

<% session.setAttribute("feature", feature); %>
<% session.setAttribute("title", "KIKAKUYA - " + feature); %>
<%@include file="head.jsp" %>
<body>
<%@include file="header.jsp" %>
<%@include file="menu.jsp" %>
<div class="container.container-fluid">
	<!-- body contents start -->
  <h1>NEW PAGE</h1>
  <p>This is some text.</p> 
  	<!-- body contents end -->
</div>
</body>
<%@include file="footer.jsp" %>