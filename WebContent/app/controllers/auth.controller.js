(function(){
	'use strict';
	app.controller('AuthController', ['$scope', '$http','$location', AuthController]);
	
	function AuthController($scope, $http, $location) {
		var vm = this;
		vm.reset = reset;
		vm.login = login;
		
		init();
		
		function init(){
			vm.userId = "";
			vm.secret = "";
			console.error("TEST");
		}
		
		function login() {
			console.log(vm.userId);
			console.log(vm.secret);
		}
		
		function logout() {
			
		}
		
		function reset() {
			console.log("RESET");
			vm.userId = "";
			vm.secret = "";
		}
	}
})();