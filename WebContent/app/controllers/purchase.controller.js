(function(){
	'use strict';
	app.controller('PurchaseController',['$location','$scope','$http','$mdDialog', PurchaseController]);
	
	function PurchaseController($location, $scope, $http, $mdDialog) {
		var vm = this;
		var purchaseId = 0;
		vm.showDialog = showDialog;
		vm.purchases = new Array();
		
		init();
		
		function init(){
			console.log('init user ctrl');
			
			$http({
				method:'GET',
				url:context + '/main/purchase/list',
				headers:{
					'Content-Type':'application/json'
				}
			}).then(
			   function success(response) {
				   //console.log(response);
				   //response.data.data;
				   var p = response.data.data;
				   angular.forEach(p, function(key,value) {
					   
					   var amnt = 0;
					   angular.forEach(value.purchaseItems, function(key,value){
						   amnt += key.totalCost;
					   });
					  console.log(value);
					  console.log(key.supplier);
					   var purchase = {
							 'id'	: key.purchaseId,  
							 'poid' : pad(key.purchaseId, 10),
							 'amnt' : amnt,
							 'poDate':key.purchaseDate,
							 'supplier' : key.supplier.lastName + ', ' + key.supplier.firstName,
							 'dateCreated' : key.dateCreated,
							 'createdBy' : key.createdBy,
							 'dateUpdated': key.dateUpdated,
							 'updatedBy' : key.updatedBy
					   }
					   vm.purchases.push(purchase);
				   });
				   
				   //console.log(vm.purchases);
			   },
			   function error(response){
				   console.error(response);
			   }
			);
		}
		
		function pad(n, width) {
			n = n + '';
			return n.length >= width ? 'PO-' + n : 'PO-' + new Array(width - n.length + 1).join('0') + n; 
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