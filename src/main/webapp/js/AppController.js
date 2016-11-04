webApp.controller( 'AppController', ['$scope','$location','sessionService',
	function AppController ( $scope, $location, sessionService ) {
		$scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
    		if ( angular.isDefined( toState.data.pageTitle ) ) {
      			$scope.pageTitle = toState.data.pageTitle + ' | ngBoilerplate' ;
    		}
		});
  
	$scope.isLoggedIn = sessionService.isLoggedIn;
	
	$scope.logout = sessionService.logout;
}])