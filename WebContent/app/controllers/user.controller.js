(function(){
	'use strict';
	app.controller('UserController',['$location','$scope','$http','$mdDialog', UserController]);
	
	function UserController($location, $scope, $http, $mdDialog) {
		var vm = this;
		var userId = 0;
		
		vm.showDialog = showDialog;
		
		init();
		
		function init(){
			console.log('init user ctrl');
			
			$http({
				method:'GET',
				url:context + '/main/user/list',
				headers:{
					'Content-Type':'application/json'
				}
			}).then(
			   function success(response) {
				   console.log(response);
				   vm.users = response.data.data;
				   console.log(vm.users);
			   },
			   function error(response){}
			);
		}
		
		function showDialog(ev, id) {
			userId = id;
			$mdDialog.show({
				templateUrl			: 'app/partials/templates/user.dialog.template.html',
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
		
		function Dialog($scope, $http, $mdDialog){
			$scope.user = {};
			console.log('dialog');
			$scope.viewOnly = false;
			
			$scope.hide = function () {
				console.log('hide dialog');
				$mdDialog.hide();
			}
			
			$scope.checkAction = function(value){
				console.log(value.action);
				if(value.action == "upd") {
					$scope.viewOnly = false;
				} else {
					$scope.viewOnly = true;
				}
			}
			
			$scope.hovered = function(){
				console.log('hovered!');
			}
			
			if (userId > 0) {
				$scope.viewOnly = true;
				console.log(userId);
                $http({
                   method:'GET', 
                   url: context + '/main/user/single/' + userId,
                   dataType:'json'
                }).then(
                	function success(response){
                		$scope.user = response.data.dataObject;
                		$scope.user.password = "";
                		console.log($scope.user);
                	}, 
                	function error(message){}
                );
            }
			
			$scope.submit = function(){
                $http({
                    method:'POST',
                    url: context + ((userId > 0) ? '/main/user/update' : '/main/user/add'),
                    data : $scope.user,
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
		
		function del(ev, id) {
			console.log(id);
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