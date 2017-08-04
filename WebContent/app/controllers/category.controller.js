(function(){
	'use strict';
	app.controller('CategoryController',['$location','$scope','$http','$mdDialog',CategoryController]);
	
	function CategoryController($location,$scope,$http,$mdDialog) {
		var vm = this;
		var catCode = 0;
		var update = false;
		
		vm.showDialog = showDialog;
		vm.del = del;
		
		init();
		
		function init() {
			$http({
				method:'GET',
				url:context + '/main/category/list',
				headers:{
					'Content-Type':'application/json'
				}
			}).then(
				function success (response){
					vm.categories = response.data.data;
					console.log(vm.categories);
				},
				function error(response){}
			);
		}
		
		function showDialog(ev, code){
			
			catCode = code;
            if(catCode != 0) {
                update = true;
            } else {
                update = false;
            }
			
			$mdDialog.show({
				templateUrl			: 'app/partials/templates/category.dialog.template.html',
				controller			: Dialog,
				targetEvent			: ev,
				clickOutsideToClose	: false,
				parent				: angular.element(document.body)
			}).then(
				function (response) {
					console.log('submitted');
					init();
				},
				function () {
					console.log('cancelled');
				}
			);
		}
		
		function Dialog($scope, $http, $mdDialog) {
			console.log('updated: ' + update);
			$scope.category = {};
			$scope.readOnly = update;
			
			$scope.hide = function () {
				console.log('hide dialog');
				$mdDialog.hide();
			}
			
			if (update) {
                $http({
                   method:'GET', 
                   url: context + '/main/category/single/' + catCode,
                   dataType:'json'
                }).then(
                	function success(response){
                		$scope.category = response.data.dataObject;
                		console.log($scope.user);
                	}, 
                	function error(message){}
                );
            }
			
			$scope.submit = function(){
                $http({
                    method:'POST',
                    url: context + ((update) ? '/main/category/update' : '/main/category/add'),
                    data : $scope.category,
                    headers : {
                    	'Content-Type':'application/json'
                    }
                }).then(
                    function success(response) {
                        $mdDialog.hide(response);
                        console.log(response);
                    },
                    function error(err) {
                        console.log(err);
                    }
                );
            }
		}
		
		function del(ev, code) {
			console.log(code);
            $mdDialog.show(
               $mdDialog.confirm()
               .title('Delete')
               .textContent('Are you sure you want to delete this user?')
               .targetEvent(ev)
               .ok('Delete')
               .cancel('Cancel')
            ).then(function() { 
                /*$http({
                    method:'GET',
                    url: context + '/user/delete/' + id,
                    dataType:'json'
                }). then(
                    function success(response){
                        init();
                    },function error(err){
                        console.log(err);
                    }
                );*/
            }, function() {
                console.log('canceled');
            });
		}
	}
	
})();