var blogCreationPage = angular.module('blogCreationPage', []);



window.onload= function(){

	 var el = document.getElementById("public").onclick= function togglePost(){

		 if (this.textContent == "Public")
   {
       this.textContent = "Private";
	   this.value = "Private";
   }
   else
   {
     this.textContent = "Public";
	 this.value = "Private";
   }

		 };
	};

$(document).ready(function() {


//function for changing the text on the button

$('editor1').attr('content');

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

/**
onclick event handler for the delete button.
It removes the image, clears and unhides the file input field.
*/
jQuery('#image_preview a').bind('click', function () {
    resetFormElement(jQuery('#image'));
    //$('div#image_preview').remove();
	//jQuery('#image').slideDown();
    jQuery(this).parent().slideUp();
    return false;
});

/*$(document).ready(function() {
$( "#image-remove" ).click(function() {
  alert( "Handler for .click() called." );
});
});*/


/**
 * Reset form element
 *
 * @param e jQuery object
 */
function resetFormElement(e) {
	$('div#image-preview').remove();
    e.wrap('<form>').closest('form').get(0).reset();
    e.unwrap();
}

$( "#image123" ).click(function() {

  $('#image').click(); return false;


});

});
