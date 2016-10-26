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
	  })
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

.controller( 'RegisterController', function RegisterController( $scope) {
	$scope.register = function() {
		if($scope.account.password!=$scope.account.repeatPass) {
			alert("Passwords do not match");
		}else{
			alert("User " + $scope.account.username + " registered");
		}
	}
})

.controller( 'LoginController', function LoginController( $scope) {
	$scope.login = function() {
		alert("user logged in with " + $scope.account.name + " and " + $scope.account.password);
	}
})
;