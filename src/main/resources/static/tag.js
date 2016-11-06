$(function() {
	$("#tagList").change(function() {
		var name = $("#tagList option:selected").text();
		var id = $("#tagList option:selected").val();
		$("#tagFormUpdateLabel").text(name);
		$("#tagFormUpdate [name=name]").val(name);
		$("#tagFormUpdate [name=id]").val(id);
	});
});
