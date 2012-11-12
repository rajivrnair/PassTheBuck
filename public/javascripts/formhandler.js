jQuery(function ($) {
	jQuery("#team, #category, #task").click(function() {
		var _id = jQuery(this).attr('id');
		jQuery("#overlay").show();
		jQuery("."+_id).show();
	});

	jQuery(".popup-close, .cancel-btn").click(function() {
		jQuery(".popup-hold").hide();
		$('#overlay').hide();
	});
	

	$('#teamSubmit').click(function(e) {
			var formData = $('#team').serialize();

			alert($(this).serialize());

		    jsRoutes.controllers.Application.newTeam().ajax({
		    	data : formData,
		        success : function(data) {
		            alert("Work aayi aliya!");
		        },
		        error : function(data) {
		        	alert("Mayire.. form submit cheyyada!");
		        }
		    });
		    return false;
		});

});