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
			var $this = $(this),
				$form = $( $this.data("form") || $this.closest('form') ),
				_formData = $form.serialize(),
				_formId = $form.attr('id'),
				_jsRoutes;

			switch (_formId) {
				case 'formTeam' :
					_jsRoutes = jsRoutes.controllers.Teams.newTeam().ajax;
					break;
				case 'formCategory' :
					_jsRoutes = jsRoutes.controllers.Categories.newCategory().ajax;
					break;
				case 'formInterview' :
					_jsRoutes = jsRoutes.controllers.Interviews.newInterview().ajax;
					break;
				default:
					break;
			}

			_jsRoutes({
				data : _formData,
				success : function(data) {
					$form.parent().find(".alert").removeClass("hide");
					setTimeout(function(){
					hideForm();
						$form.parent().find(".alert").addClass("hide");
					},1500);
				},
				error : function(data) {
					alert("Mayire.. form submit cheyyada!");
				}
			});
			return false;
	});

	var hideForm = function() {
		$('.modal').modal("hide");
	};

	jQuery("li#categories").click(function() {
		if(jQuery(this).hasClass('open')) {
			jQuery(this).removeClass('open');
			jQuery(".pulldown").hide();
		} else {
			jQuery(this).addClass('open');
			jQuery(".pulldown").show();
		}
	});

});
