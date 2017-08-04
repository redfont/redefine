(function(){
	'use strict';
	app.controller('UserController',['$location','$scope','$http','$mdDialog', UserController]);
	
	function UserController($location, $scope, $http, $mdDialog) {
		var vm = this;
		var userId = 0;
		var update = false;
		
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
            if(userId > 0) {
                update = true;
            } else {
                update = false;
            }
			
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
			$scope.readOnly = update;
			
			$scope.hide = function () {
				console.log('hide dialog');
				$mdDialog.hide();
			}
			
			if (update) {
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
                    url: context + ((update) ? '/main/user/update' : '/main/user/add'),
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