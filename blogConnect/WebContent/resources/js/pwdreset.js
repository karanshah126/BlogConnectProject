var passwordreset = angular.module('passwordreset', []);


$(document).ready(function() {
    
	$('#oldPass, #newPass, #conPass').change(validatePasswordInfo);
  $('#signupbuttonPass').on('click', function(){validatePasswordInfo();});
	
});





	function validatePasswordInfo(){
			console.log("Entered");
    if ($('#newPass').val().length  >   0 &&  $('#conPass').val().length  >   0 &&  $('#newPass').val()=== $('#conPass').val()) {
        $("#signupbuttonPass").prop("disabled", false);
		$("#buttonErrorMessage2").html("");
    }
    else {
        $("#signupbuttonPass").prop("disabled", true);
		$("#buttonErrorMessage2").html("Fields are empty or passwords do not match");
    }
	}
