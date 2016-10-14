webApp.factory('commonResourcesFactory', function() {
	var baseUrl = "localhost/WebApp/mvc/";
		return {
			findAllBlogsUrl: baseUrl + "blogs",
			findOneBlogUrl: baseUrl + "blogs/",
			findAllBlogEntriesUrl: baseUrl + "blog-entries",
			findOneBlogEntryUrl: baseUrl + "blog-entries/"
		};
	}
);