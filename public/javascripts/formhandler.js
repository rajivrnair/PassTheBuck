jQuery(function ($) {
	jQuery("#team, #category, #task").click(function() {
		var _id = jQuery(this).attr('id');
		jQuery("#overlay").show();
		jQuery("."+_id).show();
	});

	jQuery(".popup-close, .cancel-btn").click(function() {
		hideForm();
	});

	jQuery("ul#listings li").click(function() {
		jQuery("#overlay").show();
		jQuery(".edit-task").show();
	});
	
	jQuery('#teamSubmit, #categorySubmit, #taskSubmit').click(function(e) {
			var formData = jQuery(this).closest('form').serialize();

		    jsRoutes.controllers.Application.newTeam().ajax({
		    	data : formData,
		        success : function(data) {
		            hideForm();
		        },
		        error : function(data) {
		        	alert("Mayire.. form submit cheyyada!");
		        }
		    });
		    return false;
	});

	var hideForm = function() {
		jQuery(".popup-hold").hide();
		jQuery('#overlay').hide();
	};
});