var userHomePage = angular.module('userHomePage', []);
$(document).ready(function() {
    
	console.log("entered");

$('.gpwrap .gppost').collapser({
	mode: 'lines',
	truncate: 5,
	changeText: true,
	showText: 'Read more'
});

	$("#friendmessage").click(function() {
		console.log("entered and working");
		 $("#sendMessage").slideToggle("show");
        
    });
	
	
	
	$("#connect").click(function() {
		if($("#connect").attr("value")==="Connect")
		{
		console.log("entered connect");
		 $("#connectFriend").slideToggle("show");
		}
		else if($("#connect").attr("value")==="Connected")
		{
			console.log("entered connected");
			$("#removeFriend").slideToggle("show");
			}
			
			else if ($("#connect").attr("value")==="Connect Request Sent")
			{
				console.log("entered RequestSent");
				$("#requestAlreadySent").slideToggle("show");
				$("#requestAlreadySentText").html("You have already sent a friend request to this user");
				}
				
					else if ($("#connect").attr("value")==="Respond to Connect Request")
			{
				console.log("entered Respond to friend request");
				$("#acceptFriend").slideToggle("show");
				}
				
						else if ($("#connect").attr("value")==="Your Profile")
			{
				console.log("entered your profile");
				$("#sameUser").slideToggle("show");
				$("#sameUserText").html("Cannot send request to self");
				}
        
    });
	
	$("#yesFriend").click(function() {
        
		$("#removeFriend").slideToggle("hide");
    });
	
	$("#noFriend").click(function() {
        
		$("#connectFriend").slideToggle("hide");
    });
	
	$("#noAcceptFriendButton").click(function() {
        
		$("#acceptFriend").slideToggle("hide");
    });





});