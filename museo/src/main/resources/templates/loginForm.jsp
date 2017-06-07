<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
	<meta charset="utf-8">
	<title>Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
	    /* Remove the navbar's default margin-bottom and rounded borders */ 
	    .navbar {
	      margin-bottom: 0;
	      border-radius: 0;
	    }
	    
	    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
	    .row.content {height: 450px}
	    
	    /* Set gray background color and 100% height */
	    .sidenav {
	      padding-top: 20px;
	      background-color: #f1f1f1;
	      height: 100%;
	    }
	    
	    /* Set black background color, white text and some padding */
	    footer {
	      background-color: #555;
	      color: white;
	      padding: 15px;
	    }
	    
	    /* On small screens, set height to 'auto' for sidenav and grid */
	    @media screen and (max-width: 767px) {
	      .sidenav {
	        height: auto;
	        padding: 15px;
	      }
	      .row.content {height:auto;};
	    }
  	</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  	<div class="container-fluid">
    	<div class="navbar-header">
      		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        	<span class="icon-bar"></span>
        	<span class="icon-bar"></span>
        	<span class="icon-bar"></span>                        
      		</button>
      		<a class="navbar-brand">Logo</a>
    	</div>
    	<div class="collapse navbar-collapse" id="myNavbar">
      		<ul class="nav navbar-nav">
        		<li><a href="mainPage.jsp">Home</a></li>
        		<!-- href deve essere settato ad un controller o service che fornisca le immagini da inserire -->
        		<li><a href="gallery.jsp">Galleria</a></li>
        		<li><a href="#">Artisti</a></li>
        		<li><a href="#">Contact</a></li>
      		</ul>
      		<ul class="nav navbar-nav navbar-right">
        		<li class="active"><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      		</ul>
    	</div>
  	</div>
</nav>
<div class="container-fluid text-center">    
  	<div class="row content">
    	<div class="col-sm-8 text-center">
    		<h3>Prego, inserire le credenziali</h3>
    		<!-- impostare pagina successiva. Passa ad una schermata del tipo "benvenuto, scelga i comandi" oppure torna alla home? -->
    		<form action="#" method="post">
    			<h4>Nome: <input type="text" name="accessName" value="${accessName}">${errAccessName}</h4>
    			<h4>Password: <input type="password" name="password">${errPassword}</h4>
    			<hr>
    			<input type="submit" name="buttonSubmit" value="Accedi">
    		</form>
    		<hr>
    		<p>Questa pagina � riservata al personale amministrativo del museo e l'accesso al sistema � consentito solo al personale fornito delle credenziali dall'amministrazione stessa del museo.</p>
    	</div>
    </div>
</div>
</body>
</html>