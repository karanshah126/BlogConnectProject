<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html ng-app="userHomePage">
	<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
      <!-- <link rel="stylesheet" href="css/notification.css">
      <link rel="stylesheet" href="css/font-awesome.min.css">-->
      <link rel="stylesheet" href="<c:url value="/resources/css/notification.css" />">
			<link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css" />">
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
						<h2> <a href="homepage"> BLOGCONNECT</a> </h2>
					</div>

     <div class="col-lg-4 col-md-4 col-sm-5 col-xs-8"> 
					<!--<div class="col-lg-offset-1 col-lg-4 col-md-offset-1 col-md-5 col-sm-offset-1 col-sm-7 col-xs-12">-->
 						<form method="post" action="search">
                        <div id="custom-search-input">
                          <!--  <div class="input-group">-->
                                
                                <input type="text" class="  search-query form-control" placeholder="Search" name="searchString"  />
                               		<!-- <span class="input-group-btn">-->
                                     
                                    	
                                        
                           			   <!-- </span>-->
                                       
                         <!--   </div>-->
                        </div>
                        <button class="btn btn-danger" type="submit" style="float:left; margin-top:30px; height:20px; width:10px;">
                                        <span class=" glyphicon glyphicon-search"></span>
                                   		</button>
                                        </form>
                     </div>
          <div class="col-lg-2 col-lg-offset-2 col-md-offset-1 col-md-3 col-sm-3 col-xs-4 username">
     								Hi ${session.getUsername()}!
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
   
   
	 <c:forEach items="${notificationList}" var="notification">
    <div class="col-lg-10" style="float:right; right:6%;" >
     <div class="gpwrap" >
			 <!-- <img src="https://lh6.googleusercontent.com/-oDY5lt3j20o/AAAAAAAAAAI/AAAAAAAAAAA/LIaSRRwrnB4/s32-c/photo.jpg" />-->
			<c:choose>
				<c:when test="${notification.type eq 'message'}">
			 	  <a href="${notification.sendername}"><b style="position:relative; top:5px; left:10px; font-size: 18px">${notification.sendername}</b></a><b style="position:relative; top:5px;left:20px;">sent you a message: </b>
					<small style="float: right; padding-top:10px">Message</small>
					<hr/>
					<div class="gppost">
					<!--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p> -->
					<p>${notification.content}</p>
					</div>
				</c:when>
				<c:otherwise>
					<a href="${notification.sendername}"><b style="position:relative; top:5px; left:10px; font-size: 18px">${notification.sendername}</b></a><b style="position:relative; top:5px;left:20px;">sent you a friend request: </b>
					<small style="float: right; padding-top:10px">Friend Request</small>
					<hr/>
					<div class="gppost">
						<!--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p> -->
					<p>Hi ${notification.receivername}, can I follow you on BlogConnect?</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
   </div>
 </c:forEach>





      </div>
      </div>
</div>

</div>

</body>
<!--<script src="js/jquery.collapser.js"></script>-->
<script type="text/javascript" src="<c:url value="/resources/js/notification.js" />">
</html>
