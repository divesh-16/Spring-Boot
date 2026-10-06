<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="spring" %>

<html>
<body>
	<spring:form modelAtribute="user" method="post" action="\register" >
		
		User Name : <spring:input type="text" name="username"/> <br/>
		Email ID  : <spring:input type="email" name="email"/> <br/>
		Mobile    : <spring:input type="text" name="mobile"/> <br/>
		
		Gender    : <spring:radiobutton path="gender" value="male" label="Male"/> 
					<spring:radiobutton path="gender" value="female" label="Female"/> <br>

					
				<input type="submit" value="Submit">
	</spring:form>
	
</body>	
</html>


<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="spring" %>

<html>
<body>
	
	
	
	
	<spring:form modelAttribute="user" method="POST" action="/register">
		
		User name : <spring:input type="text"  path="username"/> <br/>
		Email ID  : <spring:input type="email" path="email"/> <br>
		Mobile    : <spring:input type="text"  path="mobile"/> <br> 
		
		Gender    : <spring:radiobutton path="gender" value="male" label="Male"/> 
		
					<spring:radiobutton path="gender" value="female" label="Female"/> <br>

		<input type="submit" value="Submit"> <br>
	</spring:form>
	
</body>	

</html>