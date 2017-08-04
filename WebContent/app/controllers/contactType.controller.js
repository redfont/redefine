(function(){
	'use strict';
	app.controller('ContactTypeController',['$location','$scope','$http','$mdDialog', ContactTypeController]);
	
	function ContactTypeController($location,$scope,$http,$mdDialog){
		var vm = this;
		var update = false;
		var contactCode = 0;
		
		vm.showDialog = showDialog;
		
		init();
		
		function init(){
			$http({
				method : 'GET',
				url : context + '/main/contactType/list',
				headers:{
					'Content-Type':'application/json'
				}
			}).then(
				function success(response){
					console.log(response);
					vm.contactTypes = response.data.data;
					console.log(vm.contactTypes);
				},
				function error(response){
					
				}
			);
		}
		
		function showDialog(ev, code){
			contactCode = code;
            if(contactCode != 0) {
                update = true;
            } else {
                update = false;
            }
			
			$mdDialog.show({
				templateUrl			: 'app/partials/templates/contactType.dialog.template.html',
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
			
			$scope.contactType = {};
			console.log('dialog');
			$scope.readOnly = update;
			
			$scope.hide = function () {
				console.log('hide dialog');
				$mdDialog.hide();
			}
			
			if (update) {
                $http({
                   method:'GET', 
                   url: context + '/main/contactType/single/' + contactCode,
                   headers:{
                	   'Content-Type':'application/json'
                   }
                }).then(
                	function success(response){
                		$scope.contactType = response.data.dataObject;
                		console.log($scope.contactType);
                	}, 
                	function error(message){}
                );
            }
			
			$scope.submit = function(){
                $http({
                    method:'POST',
                    url: context + ((update) ? '/main/contactType/update' : '/main/contactType/add'),
                    data : $scope.contactType,
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
		
		function del(ev, code){}
	}
	
})();