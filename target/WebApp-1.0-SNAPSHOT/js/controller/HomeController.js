webApp.config(function config($stateProvider) {
	$stateProvider.state('home', 
		{url : '/home',
		 views : {
		 "main" : { 
			controller : 'HomeController',
			templateUrl : 'views/home.html'
		 }
		},data : { pageTitle : 'Home' }
	});
})

.controller('HomeController', [ '$scope', 'commentsService', 'sessionService' ,function HomeController($scope, commentsService, sessionService) {
	
	$scope.myVar = {
		"id" : 1,
		"name" : "Andrei",
		"description" : "Most Awesome Dev Ever"
		};
	
	$scope.comments = commentsService.getAllComments();
	
}]);