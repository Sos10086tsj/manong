$(function(){
	var local_jPageUrl = jPageUrl;
	var local_jPageId = jPageId;
	$("#" + local_jPageId).paginate({  
		count : jPageCount,
		start : jPageStart,
		display : jPageDisplay,
		border : true,
		border_color : '#BEF8B8',
		text_color : '#79B5E3',
		background_color : '#E3F2E1',
		border_hover_color : '#68BA64',
		text_hover_color : '#2573AF',
		background_hover_color : '#CAE6C6',
		images : false,
		mouse : 'press', 
		onChange : function(page){ 
			window.location.href = local_jPageUrl + page;
        } 
	}); 
});