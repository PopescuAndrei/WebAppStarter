
webApp.factory('sessionService', function() {
	var session = {};
	
	//persists the data between page refreshes
	session.login = function(data) {
		localStorage.setItem("session", data);
	};
	
	//deletes the data on logout
	session.logout = function() {
		localStorage.removeItem("session");
	};
	
	//checks if user is logged in
	session.isLoggedIn = function() {
		return localStorage.getItem("session") !== null;
	};
	
	return session;
})