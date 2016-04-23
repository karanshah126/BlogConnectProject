var userHomePage = angular.module('userHomePage', []);
$(document).ready(function() {
    

/*$('.gpwrap .gppost').collapser({
	mode: 'lines',
	truncate: 5,
	changeText: true,
	showText: 'Read more( %s )'
});*/

	$("#message").click(function() {
		 $("#sendMessage").slideToggle("fast");
        
    });



});