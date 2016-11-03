
webApp.factory('sessionService', function() {
	var session = {};
	
	//persists the data between page refreshes
	session.login = function(data) {
		localStorage.setItem("session", data);
		console.log("user logged in with credentials " + data.name + " and " + data.password);
	};
	
	//deletes the data on logout
	session.logout = function() {
		console.log(localStorage.getItem("session").name + " " + localStorage.getItem("session").password);
		localStorage.removeItem("session");
	};
	
	//checks if user is logged in
	session.isLoggedIn = function() {
		return localStorage.getItem("session") !== null;
	};
	
	return session;
})