webApp.controller('MenuController', ['$scope', 'sessionService', 'NotebookService', function MenuController($scope, sessionService, NotebookService) {
	
	buildMenu = function() {
		var list = [];
		if(sessionService.isLoggedIn) {
			list = NotebookService.findById(1);
		} else {
			list = [ {
				title : 'First Menu',
				id : 1,
				icon : 'fa fa-lock',
				show : true
			}, {
				title : 'Second Menu',
				id : 2,
				icon : 'fa fa-rocket',
				show : true
			}, {
				title : 'Third Menu',
				id : 3,
				icon : 'fa fa-smile-o',
				show : true
			}, {
				title : 'Fourth Menu',
				id : 4,
				icon : 'fa fa-power-off',
				show : true
			} ];
		}
		
		return list;
	};
	
	$scope.actionsList = buildMenu();
}]);