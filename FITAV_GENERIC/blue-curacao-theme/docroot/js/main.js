	AUI().ready(function(A){
		var submitButton = A.one('.taglib-form-navigator [type="submit"]');

		if(submitButton){
			submitButton.on('click', validateSections);
		}
	});
	

	function validateSections(){
		AUI().use(function(A){
			setTimeout(function () {
				A.all('.form-section').each(function(node){
					var sectionNav = A.one('li[data-sectionid=' + node.attr("id") +']');
					if(sectionNav){
						if(node.html().indexOf('error-field') !== -1){
							if(!A.one(sectionNav).hasClass('section-error')){
								A.one(sectionNav).addClass('section-error');
							}
						}
						else{
							if(A.one(sectionNav).hasClass('section-error')){
								A.one(sectionNav).removeClass('section-error');
							}
						}
					}
				});
			}, 700)
		});
	}