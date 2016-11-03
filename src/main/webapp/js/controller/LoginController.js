/**
 * created by andrei
 */
webApp
.config(function config( $stateProvider ) {
  $stateProvider
	  .state( 'login', {
	    url: '/login',
	    views: {
	      "main": {
	        controller: 'LoginController',
	        templateUrl: 'views/login.html'
	      }
	    },
	    data:{ pageTitle: 'Login' }
	  });
})


.controller( 'LoginController',['$scope','sessionService', '$state', function LoginController( $scope, sessionService, $state) {
	$scope.login = function() {
		sessionService.login($scope.account);
		$state.go("home");
	}
}])