webApp.module('homeController', [ 'ui.router', 'ui.bootstrap' ])

.config(function config($stateProvider) {
	$stateProvider.state('home', {
		url : '/home',
		views : {
			"main" : {
				controller : 'HomeController',
				templateUrl : 'views/home.html'
			}
		},
		data : {
			pageTitle : 'Home'
		}
	});
})

/**
 * And of course we define a controller for our route.
 */
.controller(
		'HomeController',
		[ '$scope', 'commentsService',
				function HomeController($scope, commentsService) {
					$scope.myVar = {
						"id" : 1,
						"name" : "Andrei",
						"description" : "Most Awesome Dev Ever"
					};
					$scope.comments = commentsService.getAllComments();
				} ]);