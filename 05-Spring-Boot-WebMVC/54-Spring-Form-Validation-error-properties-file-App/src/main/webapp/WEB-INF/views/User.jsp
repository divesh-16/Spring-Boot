<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="spring" %>

<html>
<body>
	
	
	<spring:form modelAttribute="user" method="POST" action="/register">
		
		User name : <spring:input type="text"  path="username"/> 
						<font color="red"> <spring:errors path="username"/> </font>	
					<br/>
					
		Email ID  : <spring:input type="text" path="email"/> 
						<font color="red"> <spring:errors path="email"/> </font>
					<br>
					
		Mobile    : <spring:input type="text"  path="mobile"/>
						<font color="red"> <spring:errors path="mobile"/> </font>
					 <br> 
		
		Gender    : <spring:radiobutton path="gender" value="male" label="Male"/> 
					<spring:radiobutton path="gender" value="female" label="Female"/> 
					
					<font color="red"> <spring:errors path="gender"/> </font>
					<br>
					
		Birth Date: <spring:input type="date"  path="bdate"/>		
						<font color="red"> <spring:errors path="bdate"/> </font>
					<br> 
					
		<input type="submit" value="Submit"> <br>
	</spring:form>
	
</body>	

</html>