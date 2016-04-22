<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html ng-app="profileSetting">
	<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!--  <link rel="stylesheet" href="css/styles-setting.css">
      <link rel="stylesheet" href="css/font-awesome.min.css">-->
        <link href="<c:url value="/resources/css/styles-setting.css" />" rel="stylesheet">
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
						<h2> BLOGCONNECT </h2>
					</div>
                    
                    <div class="col-lg-4 col-md-4 col-sm-5 col-xs-8"> 
					<!--<div class="col-lg-offset-1 col-lg-4 col-md-offset-1 col-md-5 col-sm-offset-1 col-sm-7 col-xs-12">-->
 						<div id="custom-search-input">
                            <div class="input-group">
                                <input type="text" class="  search-query form-control" placeholder="Search" />
                               		 <span class="input-group-btn">
                                    	<button class="btn btn-danger" type="button">
                                        <span class=" glyphicon glyphicon-search"></span>
                                   		</button>
                           			    </span>
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
      <div class="col-md-10.5 col-lg-11 col-sm-10 col-xs-12">
      
    <div class="col-xs-3 col-sm-3  col-md-3 col-lg-3">
              <ul class="secondnav">
              <div id="profileInfo">  <li ><a href=""> PROFILE INFO</a></li></div>
                <div id="privacyButton"><li><a href=""> PRIVACY SETTING</a></li></div>
              <div id="passwordInfo">  <li><a href="">PASSWORD RESET</a></li> </div>

              </ul>
        </div>
        <div class="col-xs-9 col-sm-6 col-md-7.5 col-lg-8">
        <h2 class="col-lg-offset-1 col-lg-9"> PROFILE INFO SETTING</h2>
        <br/>
        <form method="post"  action="updateInfoSettings" name="prosettingForm" enctype="multipart/form-data" novalidate>
   
   
   
   <div id="profileSettings">
   <label class="col-lg-offset-1 col-lg-3" for="firstName" style="float:left;">First name<br>
  <input id="firstName" type="text" name="firstName" class="allInput" value="${userDetails.firstName}">
<div> <p  ng-show="prosettingForm.firstName.$invalid && prosettingForm.firstName.$touched ">Enter a valid first name.
 </p></div>
  </label>
  

    
  
  <label class=" col-lg-offset-1 col-lg-3" for="lastName" style="float:left;">Last name<br>
  <input id="lastName" type="text" name="lastName" class="allInput" value="${userDetails.lastName}">
<div>  <p ng-show="prosettingForm.lastName.$invalid && prosettingForm.lastName.$touched ">Enter a valid last name.
 </p> </div>
  </label>
  
   
    
  <label class="col-lg-offset-1 col-lg-7" for="datebirth" style="float: left;">Date of Birth<br>
  <input type="text" name="birthdate" class="allInput" style="width: 200px;" value="${userDetails.birthdate}">
 <div> <p ng-show="prosettingForm.bDay.$invalid && prosettingForm.bDay.$touched ">Enter a valid Date mm/dd/yyyy.
 </p></div>
  </label>
  
  
   <label id="profilePicture" for="profilePicture" class="col-lg-offset-1 col-lg-4">Profile Picture<br>
   
    <img src="${userDetails.profilePicture}" style="float:left; border-radius:4px; height:100px; width:100px; padding-left:10px;" />
  
   
   </label>
   
   
   
    <div id="changeProfilePicture" class="col-lg-offset-1 col-lg-4"  style="float: left; padding:25px;">
  
  
  
   <input type="file" name="upload" id="image" class="image" style="display:none !important;"/>



<div id="image_preview">
    <img src="#" id="image-preview" style="width: 100px; height: 100px;" /><br />
    <a id="image_remove" href="#">Remove</a>
</div>



</div>
    
    
    
    
    
    
    
  
   
    
	 <label class="col-lg-offset-1 col-lg-8" for="comment" style="float:left">Biography (200 words limit)<br/>
     <textarea rows="4" cols="50" name="bio" form="usrform"   class="allInput" >${userDetails.bio}
</textarea>
<p ng-show="prosettingForm.comment.$invalid && prosettingForm.comment.$touched ">200 words limit.
 </p>
  </label>
  
  

 	 <input type="button" class="col-lg-offset-7 col-lg-2 signupbutton" id="image123" value="Change Dp"/>
     <input class="col-lg-2 signupbutton" id="signupbutton" type="submit" value="Update" name="submit"/>
          <p id="buttonErrorMessage"></p>
    
    
    
    
    
    
    </div>
    
    
    
    
     	<div class="col-lg-offset-1 col-lg-5" id="privacySettings" style="display:none">
        <input type="radio" name="pravacy" id="private" />
        <label for="private">Private Account</label>
  		
        
        
        <input type="radio" name="pravacy" id="public" />
        <label for="public">Public Account</label>
        
        
         <input class="col-lg-offset-8 col-lg-4 signupbutton" id="signupbutton1" type="submit" value="Update" name="submit"/>
          <p id="buttonErrorMessage1"></p>
    
          

        </div>
        
        
        
        <div id="passwordReset" class="col-lg-offset-1 col-lg-5" style="display:none;">

		 <label  for="oldpwd" >Old Password<br>
  <input type="password" id="oldPass" name="oldPassword" class="allInput" ng-model="oldpwd"
  ng-required="true">
  <p ng-show="oldpwd.$invalid && oldpwd.$touched">Enter a valid password.
 </p>
  </label>
  
  
  

  <label  for="newpwd">New Password<br>
  <input type="password" id="newPass" name="newPassword" class="allInput" ng-model="user.newpwd"  ng-minlength="6" ng-maxlength="14" ng-required="true">
   <p ng-show="pwdform.newpwd.$invalid && pwdform.newpwd.$touched ">Password should be between 6-14 characters long.
 </p>
  </label>

  
  <label  for="pwdretype"  >Retype New Password<br>
  <input type="password" id="conPass" name="pwdretype" class="allInput" ng-model="user.pwdretype"   ng-required="true">
   <p ng-show="!pwdform.pwdretype.$error.required && pwdform.pwdretype.$error.noMatch && pwdform.pwdretype.$dirty&& pwdform.pwdretype.$touched ">Passwords do not match.</p>
   
  </label>
  
         <input class="col-lg-offset-8 col-lg-4 signupbutton" id="signupbuttonPass" type="submit" value="Update" name="submit"/>
          <p id="buttonErrorMessage2"></p>
    
        
        </div>    
            
        <!--  <input class="col-lg-offset-8 col-lg-4" id="signupbutton" type="submit" value="Update" name="submit"/>
          <p id="buttonErrorMessage"></p>-->
    
	</form>
        </div>
  
      </div> 
</div> 

</div>
 
</body>

<!--<script type="text/javascript" src="js/prosetting.js"></script> -->
<script src="<c:url value="/resources/js/prosetting.js" />"></script>
</html>