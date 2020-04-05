<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<font color="red">${error}</font>
<form method="POST">
<fieldset>
<label>Name</label> 
<input type="text" name="name" class="form-control"/>
</fieldset>
<fieldset>
<label>Password</label>
<input type="password" name="password" class="form-control"/> 
</fieldset>
<input type="submit"/>
</form>
</div>
</body>
</html>