/**
 * 
 */
webApp.service('commentsService', [ '$http', 'commonResourcesFactory',
		function($http, commonResourcesFactory) {
			return {
				getAllComments : function() {
					data = [ {
						"author" : "Narcisa",
						"text" : "Smecheras <3, m-am indragostit"
					}, {

						"author" : "Georgiana",
						"text" : "Vreau sa fiu ca tine!!!!!!!"
					}, {

						"author" : "Vlad",
						"text" : "Esti idolul meu!"
					}, {

						"author" : "Florin Salam",
						"text" : "Iti cant o melodie!"
					}, {

						"author" : "Florin Salam2",
						"text" : "Iti cant o melodie!"
					} ];
					return data;

				}
			}
		} ]);