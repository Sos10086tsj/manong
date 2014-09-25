celebrityHelp = {
		jump2CreatePage : function(){
			window.location.href = "/celebrity/showCreate";
		},
		recuit : function(id){
			$.ajax({
				url : '/celebrity/recruitTougao',
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
		}
};