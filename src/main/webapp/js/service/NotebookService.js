/**
 * 
 */
webApp.service('NotebookService', ['$http', 'commonResourcesFactory', function($http, commonResourcesFactory) {
	return {
		findById: function(id) {
			$http.get(commonResourcesFactory.findAllNotebooksForUser + id)
				.success(function (data) {
					return data;
				})
				.error(function (data) {
					return {  
						   "id":1,
						   "title":"Not Cool",
						   "content":"Something Went Wrong",
						   "blog":null,
						   "entityId":1,
						   "new":false
						};
				})
		}
	}
}]);