webApp.module('menuController', [ 'ui.router' ])

.controller('MenuController', function MenuController($scope) {
	$scope.actionsList = [ {
		label : 'First Menu',
		url : '/WebApp/#/studentLogin',
		icon : 'fa fa-lock',
		show : true
	}, {
		label : 'Second Menu',
		url : '/WebApp/#/professorLogin',
		icon : 'fa fa-rocket',
		show : true
	}, {
		label : 'Third Menu',
		url : '/WebApp/#/adminLogin',
		icon : 'fa fa-smile-o',
		show : true
	}, {
		label : 'Fourth Menu',
		url : '/WebApp/#/studentsList',
		icon : 'fa fa-power-off',
		show : true
	}];
});