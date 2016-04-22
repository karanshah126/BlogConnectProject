<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html ng-app="userHomePage">
	<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <!-- <link rel="stylesheet" href="css/Search.css">
      <link rel="stylesheet" href="css/font-awesome.min.css">-->

     <link href="<c:url value="/resources/css/Search.css" />" rel="stylesheet">
       <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
    <script src="https://code.angularjs.org/1.4.5/angular-route.js"></script>  
    
         
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
      <title>BlogConnect</title>
	</head>
   <body>
	<div id="fullControl">
		<header id="banner">
			<div class="container-fluid">
				<div class="row" id="bannerElements">
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
						<h2> BLOGCONNECT </h2>
					</div>
                    
                    <div class="col-lg-4 col-md-4 col-sm-5 col-xs-8"> 
					<!--<div class="col-lg-offset-1 col-lg-4 col-md-offset-1 col-md-5 col-sm-offset-1 col-sm-7 col-xs-12">-->
 						<div id="custom-search-input">
                            <div class="input-group">
                               <form method="post" action="search">
                                <input type="text" class="  search-query form-control" placeholder="Search" name="searchString"/>
                               		 <span class="input-group-btn">
                                    	<button class="btn btn-danger" type="submit">
                                        <span class=" glyphicon glyphicon-search"></span>
                                   		</button>
                           			    </span>
                                    </form>
                            </div>
                        </div>
                     </div>
                        <div class="col-lg-2 col-lg-offset-2 col-md-offset-1 col-md-3 col-sm-3 col-xs-4 username">
     						Hi User !
                        </div>    
				</div>
			</div>
		</header>

	
    <div class="row" id="mainBody"> 
     <div class="col-sm-2 col-md-1.5 col-lg-1 col-xs-12">
        <div class="sidebar-nav">
          <div class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <span class="visible-xs navbar-brand">Options</span>
            </div>
            <div class="navbar-collapse collapse sidebar-navbar-collapse width" style="width:100%;">
              <ul class="nav navbar-nav">
                   <li><a href="changeSettings" class="icons"><i class="fa fa-cog fa-3x"></i>Settings</a></li>
                <li><a href="blogCreation" class="icons"><i class="fa fa-pencil fa-3x"></i> Post</a></li>
                <li><a href="notifications" class="icons"><i class="fa fa-commenting-o fa-3x"></i> Notifs</a></li>
                <li><a href="friendsView" class="icons"><i class="fa fa-child fa-3x"></i> Friend View</a></li>
                <li><a href="homepage" class="icons"><i class="fa fa-eye fa-3x"></i> Public View</a></li>
              </ul>
            </div><!--/.nav-collapse -->
          </div>
        </div>
      </div>     
      <div class="col-md-10.5 col-lg-10 col-sm-10 col-xs-12">


        <c:forEach var="user" items="${searchResults}">

       
      <div class="person col-md-10.5 col-lg-10 col-sm-10 col-xs-12">
       	<img class="profile-image" src="${user.profilePicture}" />
        <span class="name">${user.firstName} ${user.lastName}</span>

        <span class="bio"> ${user.bio} </span>
       <span class="username"> <a href="username/${user.username}">${user.username}</a></span>
      
       </div>
        </c:forEach>
     

     
     
      </div> 

</div> 

</div>
 
</body>
<!--<script src="js/jquery.collapser.js"></script>-->
<!--<script type="text/javascript" src="js/Search.js"></script> -->
 <script src="<c:url value="/resources/js/Search.js" />"></script>
</html>