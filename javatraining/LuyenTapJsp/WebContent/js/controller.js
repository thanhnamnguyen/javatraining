function editItem(ctr) {
	var pr = $(ctr).parent().parent();
	var manhanvien = $(pr).find('.item1').text();
	var tennhanvien = $(pr).find('.item2').text();
	var luong = $(pr).find('.item3').text();
	var chucvu = $(pr).find('.item4').text();
    $('#manhanvien').val(manhanvien);
    $('#tennhanvien').val(tennhanvien);
    $('#luong').val(luong);
    $('#chucvu').val(chucvu);
}
function change(){
	$('.edit').on('click',function(){
		 $('#frominfo').attr('action','EditServlet');
		 $('#them').attr('value',"Sửa");
		 $('#them').attr('id',"sua");
	});
	$('#sua').on('click',function(){
		 $('#frominfo').attr('action','AddServlet');
		 $('#sua').attr('value',"Thêm");
		 $('#sua').attr('id',"them");
	});
	$('#btSeach').on('click',function(){
		 $('#frominfo').attr('action','SelectServlet');
		 $('#frominfo').attr('method','get');
	});
}
$(document).ready(function(){
	change();
});