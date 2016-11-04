var webApp = angular.module( 'webApp', ['ui.router']);

webApp.config( function myAppConfig ( $stateProvider, $urlRouterProvider ) {
  $urlRouterProvider.otherwise( '/home' );
})

.run( function run () {
})

