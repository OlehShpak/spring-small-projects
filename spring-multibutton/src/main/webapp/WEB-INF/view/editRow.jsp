
<jsp:directive.include file="/WEB-INF/view/header.jsp"/>

<body>

	<div class="container">  
	<div class="col col-sm-5">
 	<form:form modelAttribute="editedRow" method="post" class="form-signin" role="form" >		
								
					<form:input path="iAmLikeChar" class="form-control" placeholder="I am like char" /> 
					<form:errors path="iAmLikeChar" cssClass="errorblock"/>
					<br>
					<form:input path="iAmString" class="form-control" placeholder="I am String"/> 
					<form:errors path="iAmString" cssClass="errorblock"/>
					<br>
					<form:input path="iAmBigDecimal" class="form-control" placeholder="I am BigDecimal"/> 
					<form:errors path="iAmBigDecimal" cssClass="errorblock"/>
					<br>
					<h4>Please select the date</h4>
					<br>
					<form:input type="date" path="iAmDate"/>
					<form:hidden path="id" />
					<br>
					<br>
					
     				<c:if test="${not empty errorMessage}">
     				<div class="alert alert-warning">
        				<a href="#" class="close" data-dismiss="alert">&times;</a>
        				<strong>Warning!</strong> ${errorMessage}
    				</div>
     				</c:if>
     				
     				<br>
     				<div class="container-fluid">
   					<div class="row">
   					
					<c:if test="${not empty editedRow.id}">
					<button type="submit" name="save" class="btn btn-info pull-left" >
					<span class="glyphicon glyphicon-ok"></span> Save &nbsp;&nbsp;&nbsp;</button>
					</c:if>
					
					<c:if test="${empty editedRow.id}">
					<button type="submit" name="add" class="btn btn-info pull-left" >
					<span class="glyphicon glyphicon-ok"></span> Add &nbsp;&nbsp;&nbsp;</button>
					</c:if>
					
					<a href="/spring-multibutton/" class="btn btn-info pull-right ">
					<span class="glyphicon glyphicon-share-alt"></span> Cancel</a>
					</div>
					</div>
					
		</form:form>
		</div>
		</div>
		
<!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
		<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>

</body>
</html>
