(function(){
	'use strict';
	app.controller('ControlAcctController',['$location','$scope','$http','$mdDialog', ControlAcctController]);
	
	function ControlAcctController($location, $scope, $http, $mdDialog) {
		var vm = this;
		var controlAcctId = 0;
		
		vm.showDialog = showDialog;
		
		init();
		
		function init(){
			console.log('init user ctrl');
			
			$http({
				method:'GET',
				url:context + '/main/controlacct/list',
				headers:{
					'Content-Type':'application/json'
				}
			}).then(
			   function success(response) {
				   console.log(response);
				   vm.controlAccounts = response.data.data;
				   console.log(vm.controlAcctounts);
			   },
			   function error(response){}
			);
		}
		
		function showDialog(ev, id) {
			controlAcctId = id;
            
			$mdDialog.show({
				templateUrl			: 'app/partials/templates/controlAcct.dialog.template.html',
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
			$scope.controlAccount = {
					'controlAccountSubsidiaries' : []
			};
			$scope.viewOnly = false;
			console.log('dialog');

			console.log($scope.controlAccount);
			
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
			console.log($scope.viewOnly);
			if (controlAcctId > 0) {
				$scope.viewOnly = true;
                $http({
                   method:'GET', 
                   url: context + '/main/controlacct/single/' + controlAcctId,
                   dataType:'json'
                }).then(
                	function success(response){
                		$scope.controlAccount = response.data.dataObject;
                		console.log($scope.controlAccount);
                	}, 
                	function error(message){}
                );
            }
			
			$scope.addSubAccount = function(){
				var ctrlAcct = {"accountNumber":"","accountName":"","description":""}
				$scope.controlAccount.controlAccountSubsidiaries.push(ctrlAcct);
			}
			
			$scope.delSubAccount = function(subAcct){
				console.log(subAcct);
				var idx = -1;
				
				angular.forEach($scope.controlAccount.controlAccountSubsidiaries, function(value, key){
					if(value == subAcct){
						idx = key;
					}
				});
				console.log(idx);
				if(idx > -1){
					$scope.controlAccount.controlAccountSubsidiaries.splice(idx,1);
				}
			}
			
			$scope.submit = function(){
                $http({
                    method:'POST',
                    url: context + ((controlAcctId > 0) ? '/main/controlacct/update' : '/main/controlacct/add'),
                    data : $scope.controlAccount,
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