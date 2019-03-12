AUI().ready('aui-base', function(A){
	A.all('.qty-input').on('blur',function(event){
		var total = 0;
		A.each(A.all('.qty-input'), function(value, index) {
			if (isNaN(parseInt(value.val())) || parseInt(value.val()) < 0) {
				return;
			}
			total += parseInt(value.val());
		});
		A.one('.total-qty-input').val(total);
	});
});