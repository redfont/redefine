(function() {
	'use strict';
	app.config(['$routeProvider',config]);
	
	function config($routeProvider){
		
		$routeProvider
			.when('/', {
				templateUrl: 'app/partials/home.view.jsp'
			});
		/*$routeProvider
			.when('/userpage', {
				controller  : 'UserController as vm',
				templateUrl : 'app/partials/user.view.jsp'
			})
			.when('/homepage', {
				controller  : 'RootController as vm',
				templateUrl : 'app/partials/root.view.jsp'
			})
			.when('/itemcategorypage',{
				controller	: 'ItemCategoryController as vm',
				templateUrl : 'app/partials/item.category.view.jsp'
			})
			.when('/expensetypepage', {
				controller  : 'ExpenseTypeController as vm',
				templateUrl : 'app/partials/expense.type.view.jsp'
			})
			.when('/supplierpage', {
				controller	: 'SupplierController as vm',
				templateUrl : 'app/partials/supplier.view.jsp'
			})
			.when('/customerpage', {
				controller	: 'CustomerController as vm',
				templateUrl : 'app/partials/customer.view.jsp'
			})
			.when('/', {
				controller  : 'LoginController as vm',
				templateUrl : 'app/partials/login.view.jsp'
			})*/
	}
})();