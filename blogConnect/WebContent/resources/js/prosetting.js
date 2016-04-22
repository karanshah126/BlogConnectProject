var profileSetting = angular.module('profileSetting', []);
$(document).ready(function() {
   
   $("#privacyButton").click(function(){
	   
	   $("#privacySettings").show("fast");
	   $("#profileSettings").hide("fast");
	   $("#passwordReset").hide("fast");
	   
	   }); 
	
	 $("#profileInfo").click(function(){
	   
	   $("#privacySettings").hide("fast");
	   $("#profileSettings").show("fast");
	    $("#passwordReset").hide("fast");
	   
	   }); 
	
	 $("#passwordInfo").click(function(){
	   
	   $("#privacySettings").hide("fast");
	   $("#profileSettings").hide("fast");
	    $("#passwordReset").show("fast");
	   
	   }); 
	   
	   
	   jQuery( document ).delegate('#image', 'change', function() {
    ext = jQuery(this).val().split('.').pop().toLowerCase();
    if (jQuery.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1) {
        resetFormElement(jQuery(this));
        window.alert('Not an image!');
    } else {
        var reader = new FileReader();
        var image_holder = jQuery("#"+jQuery(this).attr('class')+"-preview");
        image_holder.empty();

        reader.onload = function (e) {
            jQuery(image_holder).attr('src', e.target.result);
        };

        reader.readAsDataURL((this).files[0]);
        jQuery('#image_preview').slideDown();
        jQuery(this).slideUp();
    }
});


jQuery('#image_preview a').bind('click', function () {
    resetFormElement(jQuery('#image'));
    //$('div#image_preview').remove();
	//jQuery('#image').slideDown();
    jQuery(this).parent().slideUp();
    return false;
});

function resetFormElement(e) {
	$('div#image-preview').remove();
    e.wrap('<form>').closest('form').get(0).reset();
    e.unwrap();
}

$( "#image123" ).click(function() {

  $('#image').click(); return false;


});

// validateProfileInfo();
  $('#firstName, #lastName').change(validateProfileInfo);
  $('#signupbutton').on('click', function(){validateProfileInfo();});
  
  $('#oldPass, #newPass, #conPass').change(validatePasswordInfo);
  $('#signupbuttonPass').on('click', function(){validatePasswordInfo();});
  
   $('#private, #public').change(validatePrivacyInfo);
  $("#signupbutton1").on('click', function(){validatePrivacyInfo();});
  
	});
	
	
	function validateProfileInfo(){
    if ($('#firstName').val().length   >   0   &&
        $('#lastName').val().length  >   0 ) {
        $("#signupbutton").prop("disabled", false);
		$("#buttonErrorMessage").html("");
    }
    else {
        $("#signupbutton").prop("disabled", true);
		$("#buttonErrorMessage").html("Enter valid first name and last name");
    }
	}
	
		function validatePasswordInfo(){
			console.log("Entered");
    if ($('#oldPass').val().length   >   0   &&
        $('#newPass').val().length  >   0 &&  $('#conPass').val().length  >   0 &&  $('#newPass').val()=== $('#conPass').val()) {
        $("#signupbuttonPass").prop("disabled", false);
		$("#buttonErrorMessage2").html("");
    }
    else {
        $("#signupbuttonPass").prop("disabled", true);
		$("#buttonErrorMessage2").html("Fields are empty or passwords do not match");
    }
	}

	function validatePrivacyInfo(){
		
		
		 if($('#private').is(':checked') ||  $('#public').is(':checked')) 
   {
   
  $("#buttonErrorMessage1").html("");
		 $("#signupbutton1").prop("disabled",false);
		
		}
		
		else
		{
			 $("#buttonErrorMessage1").html("You need to select one option");
		 $("#signupbutton1").prop("disabled",true);
			
			}
		
		
		
		
		}



	
	
	
	






