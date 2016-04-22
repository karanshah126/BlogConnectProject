var blogCreationPage = angular.module('blogCreationPage', []);



window.onload= function(){



  var editor = CKEDITOR.instances.content;


          editor.on( 'change', function() {
       var data = editor.getData();
        validateCKEDITORforBlank(data);


    } );


         $('#title').change(validateTitle);

        document.getElementById("postButton").onclick = function() {

                var data = editor.getData();
                validateCKEDITORforBlank(data);};
                validateTitle();



                 };



function validateCKEDITORforBlank(ckData)
{
   ckData = ckData.replace(/<[^>]*>|\s/g, '');
   var vArray = new Array();
   vArray = ckData.split("&nbsp;");
   var vFlag = 0;
   for(var i=0;i<vArray.length;i++)
   {
       if(vArray[i] == '' || vArray[i] == "")
       {
          continue;
       }
       else
       {
           vFlag = 1;
           break;
       }
    }
    if(vFlag == 0)
    {
      // alert('Entered if');
            $('#output').html('You need to fill the blog content');
       $("#postButton").prop("disabled",true);
            return true;
    }
    else
    {
      // alert('Entered else');
           $('#output').html('');
       $("#postButton").prop("disabled",false);

           return false;
    }
}

$(document).ready(function() {


//function for changing the text on the button



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

    jQuery(this).parent().slideUp();
    return false;
});



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

function validateTitle(){
    //validateCKEDITORforBlank(data);
    if ($('#title').val().length   >   0 )
        {
        $("#postButton").prop("disabled", false);
                $("#buttonErrorMessage").html("");
    }
    else {
        $("#postButton").prop("disabled", true);
                $("#buttonErrorMessage").html("Enter valid title");
    }
        }