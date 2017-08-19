(function(){
	'use strict';
	app.controller('PersonController',['$location','$routeParams', '$scope','$http','$mdDialog', PersonController]);
	
	function PersonController($location, $routeParams, $scope, $http, $mdDialog) {
		var vm = this;
		var personId = 0;
		var view = false;
		vm.showDialog = showDialog;
		vm.isProspect = false;
		init();
		
		console.log($routeParams.contactType);
		function init(){
			vm.isProspect = ($routeParams.contactType == 'P');
			console.log(vm.isProspect);
			console.log('init person ctrl');
			getPersons();
			
			
		}
		
		function getPersons(){
			$http({
				url: context + '/main/person/list/' + $routeParams.contactType,
				method : 'GET',
				headers:{
					'Content-Type':'application/json'
				}
			}).then(
				function success(response){
					console.log(response);
					vm.persons = response.data.data;
				},
				function error(response){
					console.log(response);
				}
			);
		}
		
		function showDialog(ev, id) {
			personId = id;
			$mdDialog.show({
				templateUrl			: 'app/partials/templates/person.dialog.template.html',
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
			$scope.person = {};
			$scope.viewOnly = false;
			$scope.contactTypes = [];
			console.log('dialog');			
			
			getContactTypes();
			
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
			
			function getContactTypes(){
				$http({
					url:context + '/main/contactType/list',
					method: 'GET',
					headers: {
						'Content-Type':'application/json'
					}
				}).then(
					function success(response){
						$scope.contactTypes = response.data.data;
					},function error(response){
						console.log(response);
					}
				);
			}
			
			if (personId > 0) {
                $scope.viewOnly = true;
				$http({
                	method:'GET',
                	url: context + '/main/person/single/' + personId,
                	headers:{
                		'Content-Type':'application/json'
                	}
                }).then(
                	function success(response){
                		console.log(response);
                		$scope.person = response.data.dataObject;
                		var b_date = new Date($scope.person.birthDate);
                		$scope.person.birthDate = b_date;
                	},
                	function error(response){
                		console.log(response);
                	}
                );
            } else {
        		$http({
					url:context + '/main/contactType/single/P',
					method: 'GET',
					headers: {
						'Content-Type':'application/json'
					}
				}).then(
					function success(response){
						 console.log(response.data.dataObject);
						 $scope.person.contactType = response.data.dataObject;
					},function error(response){
						console.log(response);
						return null;
					}
				);
            	
            }
			
			
			$scope.submit = function(){
				$scope.person.birthDate = new Date(
						Date.parse($scope.person
								.birthDate.toDateString()));
				console.log($scope.person.birthDate);
				
				$http({
                	url:context + ((personId > 0) ? '/main/person/update' : '/main/person/add'),
                	method:'POST',
                	headers:{
                		'Content-Type':'application/json'
                	},
                	data : $scope.person
                }).then(
                	function success(response){
                		$mdDialog.hide(response);
                		console.log(response);
                	},
                	function error(response){
                		console.log(response);
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