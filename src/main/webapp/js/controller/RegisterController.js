/**
 * created by andrei
 */
webApp
.config(function config( $stateProvider ) {
  $stateProvider
	  .state( 'register', {
	    url: '/register',
	    views: {
	      "main": {
	        controller: 'RegisterController',
	        templateUrl: 'views/register.html'
	      }
	    },
	    data:{ pageTitle: 'Registration' }
	  });
})

.controller( 'RegisterController', ['$scope','sessionService', '$state', function RegisterController($scope, sessionService, $state) {
	$scope.register = function() {
		sessionService.login($scope.account);
		$state.go("home");
	}
}])