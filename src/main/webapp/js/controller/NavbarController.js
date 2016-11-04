webApp.controller('NavbarController', ['$scope','sessionService', '$state',
	function NavbarController( $scope, sessionService, $state) {
		
		$scope.isLoggedIn = sessionService.isLoggedIn;
	
		$scope.logout = function() {
			sessionService.logout();
		};
}]);