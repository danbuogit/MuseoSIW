<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
	<title>Galleria</title>
	<meta charset="utf-8">
	<!-- sottostante: meta name="viewport". Necessario cambiare? -->
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
	      .row.content {height:auto;} 
	    }
  	</style>
</head>
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
      		<a class="navbar-brand" href="#">Logo</a>
    	</div>
    	<div class="collapse navbar-collapse" id="myNavbar">
      		<ul class="nav navbar-nav">
        		<li><a href="mainPage.jsp">Home</a></li>
        		<li class="active"><a href="#">Galleria</a></li>
        		<li><a href="#">Artisti</a></li>
        		<li><a href="#">Contact</a></li>
      		</ul>
      		<ul class="nav navbar-nav navbar-right">
      			<li class="dropdown"><!-- menu per ordinare i quadri -->
          		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ordina per<span class="caret"></span></a>
          			<ul class="dropdown-menu">
          				<!-- lasciare le intestazioni del tipo <a> ad Autore, in quanto è necessario per fornire la giusta intavolazione -->
          				<li><a>Artista</a></li>
          				<li role="separator" class="divider"></li>
            			<li><a href="#">+Artista: nome</a></li>
            			<li><a href="#">+Artista: cognome</a></li>
            			<li role="separator" class="divider"></li>
           	 			<li><a href="#">Titolo</a></li>
            			<li><a href="#">Anno</a></li>
          			</ul>
          		</li>
        		<li><a href="loginForm.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      		</ul>
      		<!-- barra di ricerca, bisogna impostare l'action-->
      		<form class="navbar-form navbar-right" action="#" method="post">
        		<div class="form-group">
          			<input type="text" class="form-control" placeholder="Search">
        		</div>
        		<button type="submit" class="btn btn-default">Cerca</button>
      		</form>
    	</div>
  	</div>
</nav>
<div class="container-fluid text-center">    
  	<div class="row content">
    	<div class="col-sm-8 text-left">
    	<h1>Qui devono essere mostrati i primi dieci (?) quadri, con titolo, autore ed anno al fianco</h1>
    	</div>
    </div>
</div>
</body>
</html>