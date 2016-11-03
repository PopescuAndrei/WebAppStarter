var webApp = angular.module( 'webApp', ['ui.router']);

webApp.config( function myAppConfig ( $stateProvider, $urlRouterProvider ) {
  $urlRouterProvider.otherwise( '/home' );
})

.run( function run () {
})

.controller( 'webAppController', ['$scope','$location','MenuController','HomeController','sessionService', function WebAppController ( $scope, $location, MenuController, HomeController, sessionService ) {
  $scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
    if ( angular.isDefined( toState.data.pageTitle ) ) {
      $scope.pageTitle = toState.data.pageTitle + ' | ngBoilerplate' ;
    }
  });
  
	$scope.isLoggedIn = sessionService.isLoggedIn;
	$scope.logout = sessionService.logout;
	
}])

