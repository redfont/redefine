(function(){
	'use strict';
	app.controller('AuthController', ['$scope', '$http','$location', AuthController]);
	
	function AuthController($scope, $http, $location) {
		var vm = this;
		vm.reset = reset;
		vm.login = login;
		vm.user = {
			"username":"",
			"password":""
		};
		
		init();
		
		function init(){
			vm.username = "";
			vm.secret = "";
		}
		
		function login() {
			console.log(vm.username);
			console.log(vm.secret);
			vm.user.username = vm.username;
			vm.user.password = vm.secret;
			
			$http({
				method:'POST',
				url:context + '/main/auth/login',
				data: vm.user,
				headers: {
					'Content-Type':'application/json'
				}
			}).then(
				function success(response){
					console.log(response);	
				},
				function error(response){
						
				}
			);
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