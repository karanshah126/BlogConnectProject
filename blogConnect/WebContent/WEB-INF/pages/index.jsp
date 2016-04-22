

<!--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!DOCTYPE html>
<html ng-app="loginPage">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!--<link rel="stylesheet" href="css/styles.css">-->
    <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">  
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
  <script src="https://code.angularjs.org/1.4.5/angular-route.js"></script>
   
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   <script src="<c:url value="/resources/js/login.js" />"></script> 
 <!--  <script type="text/javascript" src="js/login.js"></script> -->
   
  <title>BlogConnect</title>
</head>
<div id="fullControl">
<header id="banner">
<div class="container-fluid">

<div class="row" id="bannerElements">
<div class="col-lg-7 col-md-6 col-sm-4 col-xs-12">
<h2> BLOGCONNECT
</h2>
</div>
<div class="col-lg-offset-1 col-lg-4 col-md-offset-1 col-md-5 col-sm-offset-1 col-sm-7 col-xs-12">
<form name="headerForm" method="post" action="homepage">

 <label for="emailID">Email id<br>
  <input type="email" name="email" placeholder="Enter email" class="allInput" ng-model="emailID" ng-required="true">
 
  </label>
  
  
  
  <label for="Password">Password<br>
  <input type="password" name="password" placeholder="Enter password" class="allInput" ng-model="Password" ng-required="true">
 
  <p id="forgotPassText" style="padding-left:30px; padding-top:15px; color:#FFFFFF; font-size:0.8em; font-weight:300; ">Forgot Password</p>
  </label>
  
  
  
   <div id="button">
  <input type="submit" name="login" value="Log In" style="font-size:18px;" ng-disabled="headerForm.emailID.$invalid || headerForm.Password.$invalid" />
  
  </div>
  
  
  
</form>
<form name="forgotPassForm" action="forgotPassword" method="post">
  <div id="forgotPasswordText" style="float:right; padding-right:20px; display:none;">
     <input type="email" placeholder="Enter email" class="allInput" style="float:left; padding:1px; font-weight:200;" name="forgotEmail" ng-model="forgotEmail" ng-required="true">


 <input type="submit" name="send" value="send" style="float:left; margin-top:0px; margin-left:15px;" ng-disabled="forgotPassForm.forgotEmail.$invalid">
   <p style="float:left; padding-left:5px; padding-top:5px;" ng-show="forgotPassForm.forgotEmail.$invalid && forgotPassForm.forgotEmail.$touched ">Enter a valid email address.
 </p>
     </div>

     </form>

</div>


</div>

</div>
</header>

<div class="container-fluid">
<div class="row" id="bodyElements">

<body>
<main id="mainPart">
<div class=" col-lg-offset-3 col-lg-9 col-md-offset-3 col-md-9 col-sm-offset-3 col-sm-9 col-xs-12">
<h1>Sign up</h1>

</div>
<form method="post"  action="createUser" modelAttribute="user"  name="registrationForm" novalidate>
   
   <div class="col-lg-offset-3 col-lg-2 col-md-offset-3 col-md-2 col-sm-offset-3 col-sm-3 col-xs-5">
   <label for="firstName">First name<br>
  <input type="text" name="firstName" class="allInput" ng-model="user.firstName"
  ng-required="true">
  <p ng-show="registrationForm.firstName.$invalid && registrationForm.firstName.$touched">Enter a valid first name.
 </p>
  </label>
  </div>
  
  <div class="col-lg-2 col-md-2 col-sm-3 col-xs-5">
  <label for="lastName">Last name<br>
  <input type="text" name="lastName" class="allInput" ng-model="user.lastName" ng-required="true">
   <p ng-show="registrationForm.lastName.$invalid && registrationForm.lastName.$touched">Enter a valid last name.
 </p>
  </label>
  </div>
   
    
    <div class="col-lg-offset-3 col-lg-9 col-md-offset-3 col-md-9 col-sm-offset-3 col-sm-9 col-xs-12">
  <label for="signEmail">Email ID<br>
  <input type="email" name="email" class="allInput" placeholder="Enter email" style="width: 200px;" ng-model="user.email" ng-required="true">
  <p ng-show="registrationForm.email.$invalid && registrationForm.email.$touched ">Enter a valid email address.
 </p>
  </label>
  </div>
    
	
   
     <div class="col-lg-offset-3 col-lg-2 col-md-offset-3 col-md-2 col-sm-offset-3 col-sm-3 col-xs-5">
   <label for="userName">Username<br>
  <input type="text" name="username" class="allInput" ng-model="user.username" ng-minlength="6" ng-maxlength="14" ng-required="true">
   <p ng-show="registrationForm.username.$invalid && registrationForm.username.$touched ">Username should be between 6-14 characters long.
 </p>
  </label>
  </div>
   
    
	 <div class="col-lg-2 col-md-2 col-sm-3 col-xs-5">
	 <label for="passwordsign">Password<br>
  <input type="password" name="password" class="allInput" ng-model="user.password" ng-minlength="6" ng-maxlength="14" ng-required="true">
   <p ng-show="registrationForm.password.$invalid && registrationForm.password.$touched ">Password should be between 6-14 characters long.
 </p>
  </label>
  </div>
  
    <div class="col-lg-offset-3 col-lg-9 col-md-offset-3 col-md-9 col-sm-offset-3 col-sm-9 col-xs-12">
    <input id="signupbutton" type="submit" value="Sign Up" name="submit" style="color:#F7F2F2;" ng-disabled="registrationForm.username.$invalid || registrationForm.password.$invalid || registrationForm.email.$invalid || registrationForm.lastName.$invalid || registrationForm.firstName.$invalid" />
    </div>
    <p>${errorMessage}</p>
	</form>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</main>
</body>
</div>
</div>
</div>
</html>