<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html ng-app="userHomePage">
	<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!--  <link rel="stylesheet" href="css/style-profilepage.css">
      <link rel="stylesheet" href="css/font-awesome.min.css">-->
       <link href="<c:url value="/resources/css/style-profilepage.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
    <script src="https://code.angularjs.org/1.4.5/angular-route.js"></script>  
    
         
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
     <!--  <script src="js/jquery.collapser.js"></script> -->
<!--<script type="text/javascript" src="js/profilePage.js"></script> -->

<script src="<c:url value="/resources/js/jquery.collapser.js" />"></script>
<script src="<c:url value="/resources/js/profilePage.js" />"></script>


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
 						<label style="position:relative; width:100%;">
                        <div id="custom-search-input">
                          <!--  <div class="input-group">-->
                                
                                <input type="text" class="  search-query form-control" placeholder="Search" name="searchString"  />
                               		<!-- <span class="input-group-btn">-->
                                     
                                    	
                                        
                           			   <!-- </span>-->
                                       
                         <!--   </div>-->
                        </div>
                        <button class="btn btn-danger" type="submit" style="float:left; margin-top:7%; height:20px; width:10px; position:absolute;">
                                        <span class=" glyphicon glyphicon-search"></span>
                                   		</button>
                                   		</label>
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
      <div class="col-md-10.5 col-lg-10 col-sm-10 col-xs-12">
       <div class="person col-md-10.5 col-lg-10 col-sm-10 col-xs-12" style="position:relative;">
       	<img id="profile-image" src="${userDetails.profilePicture}" height="60" width="60"/>
        <span id="name">${userDetails.firstName} ${userDetails.lastName}</span>
        <span id="bio">${userDetails.bio}</span>
        <label style="float:right; margin-top:10%;">
       	 <input type="submit" id="connect" value="${connectStatus}"/> 
         <button style="margin:5px;" class="message" id="friendmessage">Message</button>
         <div style="clear:both;"></div>
         </label>
       </div>
      <div class="row">
      <form id="messageForm" name="messageForm" method="post" action="messageUser">
      <div id="sendMessage" style="padding:10px; margin:27px; display:none;"> 
      <textarea form="messageForm" rows="4" cols="50" class="allInput" name="content" ng-model="message"  ng-maxlength="200"  placeholder="Enter message here..."  ng-required="true" >
</textarea>
         <input name="receivername" type="text" value="${userDetails.username}" style="display:none;">
   <div><input type="submit" id="submitMessage" value="Send Message" style="float:right; display:inline-block;" ng-disabled="messageForm.message.$invalid"></div>

      
      </div>
      </form>
      <!--connect to friend-->
      <div class="col-lg-12">
        <p>${notifyMessage}</p>    <!--- user error message  ---->
      <form id="friendRequestForm" method="post" action="connectRequest">
      <div id="connectFriend" style="width:100%; display:none;
		border: 1px solid #CCC;
	padding: 15px;
	margin: 15px 0;
	box-shadow: 0 0 6px -2px #000;">
      <p id="connectFriendText">Do you really want to send friend request</p>
      <input type="submit" class="message" value="Yes" style="display:inline-block; float:right; margin:10px; left:93%;">
      <input type="button" id="noFriend" class="message" value="No" style="display:inline-block; float:right; margin:10px;">
      <input name="receivername" type="text" value="${userDetails.username}" style="display:none;" >
      
      
      </div>
      <div style="clear:both"></div>
      
      </form>
      </div>
      <!--connect to friend-->
      <!--removing friend-->
      
       <div class="col-lg-12">
      <form id="friendRemoveForm" method="post" action="unconnect">
      <div id="removeFriend" style="width:100%; display:none;
		border: 1px solid #CCC;
	padding: 15px;
	margin: 15px 0;
	box-shadow: 0 0 6px -2px #000;">
      <p id="removeFriendText">Do you really want to remove this user as your friend</p>
      <input type="submit" class="message" value="Yes" style="display:inline-block; float:right; margin:10px; left:93%;">
      <input type="button" id="yesFriend" class="message" value="No" style="display:inline-block; float:right; margin:10px;">
       <input name="username" type="text" value="${userDetails.username}" style="display:none;">
      
      
      </div>
      <div style="clear:both"></div>
      
      </form>
      </div>
      
      
      
      
      <!--removing friend-->
      <!--Accepting friend-->
      
             <div class="col-lg-12">
      <form id="acceptingFriendForm" method="post" action="respondToRequest">
      <div id="acceptFriend" style="width:100%; display:none;
		border: 1px solid #CCC;
	padding: 15px;
	margin: 15px 0;
	box-shadow: 0 0 6px -2px #000;">
      <p id="acceptFriendText">Do you want to accept this friend request ?</p>
      <input type="submit" class="message" value="Yes" style="display:inline-block; float:right; margin:10px; left:93%;">
      <input type="button" id="noAcceptFriendButton" class="message" value="No" style="display:inline-block; float:right; margin:10px;">
      <input name="username" type="text" value="${userDetails.username}" style="display:none;" >

      
      
      </div>
      <div style="clear:both"></div>
      
      </form>
      </div>
      
      
      
      
      
      <!--Accepting friend-->
       <!--Request Sent friend-->
       
               <div class="col-lg-12">
     
      <div id="requestAlreadySent" style="width:100%; display:none;
		border: 1px solid #CCC;
	padding: 15px;
	margin: 15px 0;
	box-shadow: 0 0 6px -2px #000;">
      <p id="requestAlreadySentText"></p>
      
      
      
      </div>
      <div style="clear:both"></div>
      
     
      </div>
       
       
       
        <!--Request Sent friend-->
           <!--Same user-->
        
        
            <div class="col-lg-12">
     
      <div id="sameUser" style="width:100%; display:none;
    border: 1px solid #CCC;
  padding: 15px;
  margin: 15px 0;
  box-shadow: 0 0 6px -2px #000;">
      <p id="sameUserText"></p>
      
      
      
      </div>
      <div style="clear:both"></div>
      
     
      </div>
       
        
        
        
        
        
         <!--Same user-->
      
      
      
      
      <c:forEach var="blog" items="${blogpostList}">
      
      <div class="col-lg-6">
     
     <div class="gpwrap">
	<img src="${blog.authorimage}" height="30" width="30" /> <b>${blog.author}</b> 
	<hr/> <p style="font-weight:700;">${blog.title}</p>
	<div class="gppost">
	
	<p>${blog.content}</p>
	<p><img class="imagen" src="${blog.image}" height="200" width="200"/></p>
	</div>
</div>
     
     
     
     
      </div> 
       </c:forEach>
     
      
      
      
      </div>
      </div> 
</div> 

</div>
 
</body>

</html>