infoHelp = {
	createTougao : function(){
		window.location.href = 'itInfo/showCreateForm';
	},
	
	acceptTougao : function(id){
		//window.location.href = 'itinfo/acceptTougao?id=' + id;
		$.ajax({
			url : '/itInfo/acceptTougao',
			type : 'get',
			async : false,
			data : {
				id : id
			},
			success : function(result){
				location.reload();
			},
			failure : function(){
				alert("保存失败！");
			}
		});
	},
	
	cancelAcceptTougao : function(id){
		$.ajax({
			url : '/itInfo/accept/cancel/' + id,
			type : 'get',
			async : false,
			success : function(result){
				location.reload();
			},
			failure : function(){
				alert("保存失败！");
			}
		});
	}
};