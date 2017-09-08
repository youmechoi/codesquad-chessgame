$(function() {
	var index = 0;
	var source;

	$('#boards tr td').click(function() {
		var position = $(this).attr('id');
		var value = index % 2;

		if (value == 0) {
			source = position;
		} else {
			var queryString = 'source=' + source + '&target=' + position;
			$.ajax({
				type : 'post',
				url : '/api/move',
				data : queryString,
				dataType : 'json',
				error : function() {
					console.log('failure')
				},
				success : function(result) {
					console.log(result);
					if (result.status) {
						var sourceHtml = $('#' + result.source).html();
						$('#' + result.target).html(sourceHtml);
						$('#' + result.source).html('');
					} else {
						alert(result.errorMessage);
					}
				}
			});
		}

		index++;
		return false;
	});
});