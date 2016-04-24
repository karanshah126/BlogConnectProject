<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html ng-app="blogCreationPage">
	<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <!-- <link rel="stylesheet" href="css/blogpostCreation.css">-->
     <link rel="stylesheet" href="<c:url value="/resources/css/blogpostCreation.css" />">
      <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css" />">

      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
    <script src="https://code.angularjs.org/1.4.5/angular-route.js"></script>
  <!--  <script type="text/javascript" src="ckeditor/ckeditor/ckeditor.js"></script>-->
	 <script src="<c:url value="/resources/js/ckeditor/ckeditor.js" />"></script>
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


      <div id="likeBody">
<div class="page">
  <section class="card register" ng-app="blogCreationPage">
<!--   <div class="blogCreationHeader">

 <img src="https://lh6.googleusercontent.com/-oDY5lt3j20o/AAAAAAAAAAI/AAAAAAAAAAA/LIaSRRwrnB4/s32-c/photo.jpg" style="float:left; border-radius:4px; height:100px; width:100px;" />
 <div style="clear:both"></div>
  <h2 style="padding-bottom:20px; float: inherit; padding:20px;">User status </h2>
  <div style="clear:both"></div>
  </div>
 -->
  <form name="myform" action="createBlogpost" method="POST" enctype="multipart/form-data" novalidate>

<!--   <div class="textintro">
      <h1>Blog Creation</h1>

    </div>-->

    <fieldset>



    <textarea rows="1" cols="100" name="title" id="title" required placeholder="Blog Title" ng-model="blog.blogTitle" ng-required="true"></textarea>
    <p ng-show="myform.title.$invalid && myform.title.$touched ">You need to enter a valid title.
 </p>

    <textarea rows="10" cols="100" name="content" id="content" placeholder="Blog Body"> 
    </textarea>
    
    
        <p id="output" style=" color:#FF0004;">
 </p>



    <!-- newly added code for image --->

    <input type="file" name="upload" id="image" class="image" style="display:none !important;"/>



<div id="image_preview">
    <img src="#" id="image-preview" style="width: 100px; height: 100px;" /><br />
    <a id="image_remove" href="#">Remove</a>
</div>


    </fieldset>

<div id="postPrivacy">


        <label for="private" style="float:left; padding:5px; font-weight:400; color:#777777; font-size:1.5em;">Private
        <input type="radio" name="type" id="private" value="private" /> </label>
 <label for="public" style="float:left; padding:5px; font-weight:400; color:#777777; font-size:1.5em;">Public
        <input type="radio" name="type" id="pubs" value="public" /> </label>

     
        </div>

    <!-- <button type="button" id="public" class="btn public" onClick="toggleText()">Public</button> -->
    <button type="submit" class="btn post" id="postButton" ng-disabled="myform.title.$invalid">Post</button>
    <button type="submit" id="image123" class="btn photo">Photo (Optional)</button>
    
    <p>${successMessage}</p>
      <div style="clear:both"></div>
			<script>
        CKEDITOR.replace('content', {fileBrowserImageUploadUrl:'post/upload'});
      </script>
  </form>
 <!--  <form action="post/upload" method="POST" enctype="multipart/form-data">
      <input type="file" name="upload" >
      <input type="submit">
     </form>
 -->
 </section>
</div>
</div>


      </div>
</div>

</div>

</body>

<script type="text/javascript" src="<c:url value="/resources/js/postCreation.js" />"></script>
<!--<script type="text/javascript" src="js/postCreation.js"></script>-->
    
</html>
