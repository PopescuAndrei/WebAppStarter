webApp.factory('commonResourcesFactory', function() {
	var baseUrl = "http://localhost:8029/WebApp/mvc/";
		return {
			findAllNotebooksForUser: baseUrl + "notebook/"
		};
	}
);