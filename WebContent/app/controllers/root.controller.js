(function(){
	'use strict';
	app.controller('RootController', ['$scope', '$http','$location', RootController]);
	
	function RootController($scope, $http, $location) {
		var vm = this;
		console.log('root');
	}
})();