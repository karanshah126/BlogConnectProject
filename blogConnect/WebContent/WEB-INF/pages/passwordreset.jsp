<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html ng-app="passwordreset">
	<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- <link rel="stylesheet" href="css/style-passwordreset.css">
      <link rel="stylesheet" href="css/font-awesome.min.css">-->

      <link href="<c:url value="/resources/css/style-passwordreset.css" />" rel="stylesheet">
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
 					<!--	<div id="custom-search-input">
                            <div class="input-group">
                                <input type="text" class="  search-query form-control" placeholder="Search" />
                               		 <span class="input-group-btn">
                                    	<button class="btn btn-danger" type="button">
                                        <span class=" glyphicon glyphicon-search"></span>
                                   		</button>
               			      </span>
                          </div>
                      </div>-->
                     </div>
                        <div class="col-lg-2 col-lg-offset-2 col-md-offset-1 col-md-3 col-sm-3 col-xs-4 username">
     						<!--Hi User !-->
                        </div>    
				</div>
			</div>
		</header>

	
    <div class="row" id="mainBody"> 
     <div class="col-sm-2 col-md-1.5 col-lg-1 col-xs-12">
      <!--  <div class="sidebar-nav">
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
                 <li><a href="setting.html" class="icons"><i class="fa fa-cog fa-3x"></i>Settings</a></li>
                <li><a href="BlogCreation.html" class="icons"><i class="fa fa-pencil fa-3x"></i> Post</a></li>
                <li><a href="#" class="icons"><i class="fa fa-commenting-o fa-3x"></i> Chat</a></li>
                <li><a href="HomePage.html" class="icons"><i class="fa fa-child fa-3x"></i> Friend View</a></li>
                <li><a href="HomePage.html" class="icons"><i class="fa fa-eye fa-3x"></i> Public View</a></li>
              </ul>
            </div><!--/.nav-collapse -->
        <!--  </div>
        </div>-->
      </div>     
      <div class="col-md-10.5 col-lg-10 col-sm-10 col-xs-12">
      
     <div class="col-xs-3 col-sm-3  col-md-3 col-lg-3" >
           <!--   <ul class="secondnav">
                <li ><a href="setting.html"> PROFILE INFO</a></li>
                <li><a href="pravysetting.html"> PRAVCY SETTING</a></li>
                <li><a href="passwordreset.html">PASSWORD RESET</a></li>

              </ul>-->
        </div>
         <div id="passwordReset" class="col-lg-offset-1 col-lg-5" style="margin-top:20%;">
          <form method="post" action="setNewPassword">

		<!-- <label  for="oldpwd" >Old Password<br>
  <input type="password" id="oldPass" name="oldpwd" class="allInput" ng-model="oldpwd"
  ng-required="true">
  <p ng-show="oldpwd.$invalid && oldpwd.$touched">Enter a valid password.
 </p>
  </label>-->
  
  
  

  <label  for="newpwd" >New Password<br>
  <input type="password" id="newPass" name="newPassword" class="allInput" ng-model="user.newpwd"  ng-minlength="6" ng-maxlength="14" ng-required="true">
   <p ng-show="pwdform.newpwd.$invalid && pwdform.newpwd.$touched ">Password should be between 6-14 characters long.
 </p>
  </label>

<br>
  
  <label  for="pwdretype"  >Retype New Password<br>
  <input type="password" id="conPass" name="pwdretype" class="allInput" ng-model="user.pwdretype"   ng-required="true">
   <p ng-show="!pwdform.pwdretype.$error.required && pwdform.pwdretype.$error.noMatch && pwdform.pwdretype.$dirty&& pwdform.pwdretype.$touched ">Passwords do not match.</p>
   
  </label>
  
         <input class="col-lg-offset-9 col-lg-4 signupbutton" id="signupbuttonPass" type="submit" value="Update" name="submit"/>
          <p id="buttonErrorMessage2"></p>
    
        </form>
        </div>   
  
      </div> 
</div> 

</div>
 
</body>

<!--<script type="text/javascript" src="js/pwdreset.js"></script> -->
<script src="<c:url value="/resources/js/pwdreset.js" />"></script>
</html>