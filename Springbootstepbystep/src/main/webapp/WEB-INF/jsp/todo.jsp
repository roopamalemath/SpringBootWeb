<%@ include file="common/navigation.jspf" %>
<%@ include file="common/header.jspf" %>
	<div class="container">
		<form:form method="post" modelAttribute="todo">
			<fieldset class="form-group">
				<label>Description</label> 
				<form:input name="desc" path="desc" type="text" class="form-control" required="required" /> 
				<form:errors path="desc" cssClass="text-warning"/>
				</fieldset>
				
				<fieldset class="form-group">
				<form:label path="targetDate">Target Date</form:label>
				<form:input path="targetDate" type="text" class="form-control"
					required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>
				<input type="submit" class="btn btn-success"/>
		</form:form>
		</div>
<%@ include file="common/footer.jspf" %>