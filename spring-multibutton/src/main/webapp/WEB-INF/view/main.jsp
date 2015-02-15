	
<jsp:directive.include file="/WEB-INF/view/header.jsp"/>	

<body>

    <!-- Navigation -->
    <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
    <nav id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
            <li class="sidebar-brand">
                <a href="#top">Start App</a>
            </li>
            <li>
                <a href="#top">Home</a>
            </li>
            <li>
                <a href="#about">Test</a>
            </li>
            <li>
                <a href="#services">Services</a>
            </li>
            <li>
                <a href="#description">Description</a>
            </li>
        </ul>
    </nav>

    <!-- Header -->
    <header id="top" class="header">
        <div class="text-vertical-center">
            <h2>Spring MVC form with handling of multiple buttons </h2>
            <h3>Also is used Spring MVC form:checkbox</h3>
            <br>
            <a href="#about" class="btn btn-dark btn-lg">Let's test it</a>
        </div>
    </header>

    <!-- About -->
    <section id="about" class="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                   <div class="container">  
						<div class="col col-sm-11">
	
 	<c:if test="${not empty rowList}">
 	<form:form modelAttribute="selectedRows" method="POST" >
 		 
   	<div class="table-responsive"> 
    <table class="table">
        <thead>
            <tr>
           		<th>select</th>
                <th>id</th>
                <th>iAmLikeChar</th>
                <th>iAmString</th>
                <th>iAmDate</th>
                <th>iAmBigDecimal</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="rowValue" items="${rowList}" >
            <tr>
       			 <td><form:checkbox path="idHolder" value="${rowValue.id}" /></td>
       			 <td>${rowValue.id}</td>
       			 <td>${rowValue.iAmLikeChar}</td>
      			 <td>${rowValue.iAmString}</td>
       			 <td><fmt:formatDate value="${rowValue.iAmDate}" pattern="yyyy/MM/dd" /> </td>
       			 <td>${rowValue.iAmBigDecimal}</td>     			 
    		</tr>
    		  </c:forEach>
		
        </tbody>
    </table>
     </div>
  
     	<div class="col col-sm-5">	
     	<c:if test="${not empty warning}">
     	<div class="alert alert-warning">
        	<a href="#" class="close" data-dismiss="alert">&times;</a>
        	<strong>Warning!</strong> Please select just one row to be edited
    	</div>
     	</c:if>
     	<div class="container-fluid">
   		<div class="row">

     		<button type="submit" name="refresh" class="btn btn-info pull-left " autofocus >
			<span class="glyphicon glyphicon-refresh"></span> refresh </button>

           	
           	<button type="submit" name="edit" class="btn btn-info pull-right" autofocus >
			<span class="glyphicon glyphicon-edit"></span> edit &nbsp;&nbsp;&nbsp;</button>
			
			           	
           	<button type="submit" name="delete" class="btn btn-info center-block" autofocus >
			<span class="glyphicon glyphicon-remove"></span> delete </button>
		
		</div>	
		</div>
	 	</div>		
    </form:form>
    </c:if> 
    </div>
	</div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
    </section>

    <!-- Services -->
    <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
    <section id="services" class="services bg-primary">
        <div class="container">
            <div class="row text-center">
                <div class="col-lg-10 col-lg-offset-1">
                    <h2>Application Services</h2>
                    <hr class="small">
                    <div class="row">
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-refresh fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>Refresh</strong>
                                </h4>
                                <p>Reload the data from DB in datagrid </p>
                                <a href="#about" class="btn btn-light">Let's try it</a>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-eraser fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>Delete</strong>
                                </h4>
                                <p>Delete all selected rows and refresh actual content</p>
                                <a href="#about" class="btn btn-light">Let's try it</a>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-edit fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>Edit</strong>
                                </h4>
                                <p>Edit selected data or add new row</p>
                                <a href="#about" class="btn btn-light">Let's try it</a>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-clipboard fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>Create</strong>
                                </h4>
                                <p>Create new row and refresh actual content </p>
                                <a href="/spring-multibutton/editRow/null" class="btn btn-light">Let's try it</a>
                            </div>
                        </div>
                    </div>
                    <!-- /.row (nested) -->
                </div>
                <!-- /.col-lg-10 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
    </section>

   

    <!-- Footer -->
    <section id="description">
    <footer>
        <div class="container" >
            <div class="row">
                <div class="col-lg-8 col-lg-offset-1 text-left">
                    <h4><strong>Technologies used:</strong>
                    </h4>
                    <ul class="list-unstyled" >
                    
                   		 <li>Java SE7, Spring Framework 4.1.1.RELEASE</li>
                    	 <li>Spring Data 1.7.1.RELEASE</li>
                    	 <li>Needed Tomcat 7+ (for Servlet 3.0 and Tomcat JDBC Connection Pool)</li>
                    	 <li>Persistence: JPA (Persistence provider - Hibernate), DBMS - PostgreSQL</li>
                    	 <li>Frontend: JSP, JSTL, HTML, CSS, Bootstrap</li>
                    	 <li>Controllers are tested with Mockito, service with JUnit</li>
                    	 <li>Build tool: Maven</li>
                    	 
                    </ul>
                    <ul class="list-unstyled">
                        <li><i class="fa fa-bell-o fa-fw"></i> <a href="http://www.linkedin.com/in/olehshpak">linkedin.com/in/olehshpak</a></li>
                        <li><i class="fa fa-envelope-o fa-fw"></i>  <a href="mailto:oleh.shpak.89@gmail.com">oleh.shpak.89@gmail.com</a></li>
                    </ul>
                    <br>
                    <ul class="list-inline">
                        <li>
                            <a href="#"><i class="fa fa-facebook fa-fw fa-3x"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-twitter fa-fw fa-3x"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-dribbble fa-fw fa-3x"></i></a>
                        </li>
                    </ul>
                    <hr class="small">
                    <p class="text-muted">Copyright &copy; Website 2015</p>
                </div>
            </div>
        </div>
    </footer>
    </section>

    <!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
		<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
		
    <!-- Custom Theme JavaScript -->
    <script>
    // Closes the sidebar menu
    $("#menu-close").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    // Opens the sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    // Scrolls to the selected menu item on the page
    $(function() {
        $('a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
    </script>

</body>

</html>