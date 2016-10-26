/**
 * Created by Andrei
 */
webApp.service('blogService', ['$http', 'commonResourcesFactory', function($http, commonResourcesFactory) {
	return {
		findById: function(id) {
			$http.get(commonResourcesFactory.findOneBlogUrl + id)
				.success(function (data) {
					return data;
				})
				.error(function (data) {
					return {
						"":""
					};
				})
		}
	}
}]);