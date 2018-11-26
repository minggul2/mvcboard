$(document).ready(function(){
	$('#board_reply_button').on('click', function(){
		$('#content_div').empty();
		$('#subject_div').empty();
		
		if($('#content').val() == ''){
			$('#content_div').html("내용을 입력하세요");
		}else if($('#subject').val() == ''){
			$('#subject_div').html("제목을 입력하세요");
		}else{
			$('#board_reply_form').submit();
		}
	});
});