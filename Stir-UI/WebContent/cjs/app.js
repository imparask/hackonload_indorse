
var App = angular.module('app',['ui.router']);


App.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

	//if any url does not match with states, it will redirect to login
	$urlRouterProvider.otherwise("/login")
	
	$stateProvider
	.state('login', { //state for login
		url: "/login",
		templateUrl: "views/login.html",
		controller: "LoginController"
	})

	.state('dashboard', { //state for dashboard
		url: "/dashboard",
		templateUrl: "views/dashboard.html",
		controller: "DashBoardController"
	})
	
	.state('list_items', { //state for list_items
		url: "/list_items",
		templateUrl: "views/list_items.html",
		controller: "InventoryController"
	})

	.state('cart', { 
		url: "/cart",
		templateUrl: "views/cart.html",
		controller: "CartController"
	})
}])

.controller("LoginController", function($rootScope,$scope,$http,$location,$window) {
	
	$scope.validate=function(){
		
		//call the api and do the process
		//if success[201] - redirect to /dashboard.
		$http({
	        method : "GET",
	        url : "http://localhost:1234/rest/login",
	        headers : {
		        "username" : $scope.username,
		        "password" : $scope.password
		    }
	    }).then( _success, _error );
		
		function _success(response) {
	        $rootScope.user = response.data;
	        $rootScope.auth=true;
	        //console.log($rootScope.user);
	        $window.localStorage.setItem("user", angular.toJson($rootScope.user));
	        $window.location.href="#!/dashboard";
	        
		}
	    function _error(response) {
	    	//console.log($scope.user);
	    	$scope.msg="Invalid Username/Password";
	    }

	}
	 
 })

 .controller("DashBoardController", function($rootScope,$scope,$http,$location,$window) {
	 $scope.user = JSON.parse($window.localStorage.getItem("user"));	 
	 $scope.fetch_pnr=function(){
		 $http({
		        method : "GET",
		        url : "http://localhost:1234/rest/trains/"+$scope.pnr,
		        	headers : {
		    			'Content-Type' : 'application/json'
		    		}
		    }).then( _success4, _error4 );
			
			function _success4(response) {
					$scope.trains = response.data;
		        	console.log($scope.trains);
		        	console.log($scope.user);
				
		    }
		    function _error4(response) {
		    	//console.log($scope.user);
		    	$scope.msg="Unable to load Trains Data";
		    } 
	 }
	 

	 $scope.fetch_items= function(station){
		 $rootScope.station = station;
		 console.log($scope.station);
		 $window.localStorage.setItem("station", angular.toJson($rootScope.station));
		 $window.location.href="#!/list_items";
	 }
	 
	 
 })
 .controller("InventoryController", function($rootScope,$scope,$http,$location,$window) {
	 $scope.station = JSON.parse($window.localStorage.getItem("station"));
	 var a=[];
	 $http({
		       method : "GET",
		        url : "http://localhost:1234/rest/items",
		        	headers : {
		    			'Content-Type' : 'application/json'
		    		}
		    }).then( _success5, _error5 );
			
			function _success5(response) {
					$scope.items = response.data;
		        	console.log($scope.items);
		        	//console.log($scope.user);
				
		    }
		    function _error5(response) {
		    	//console.log($scope.user);
		    	$scope.msg="Unable to load Trains Data";
		    } 
	 $scope.addToCart=function(item){
		 $scope.item=item;
		 console.log($scope.item);
		 a.push(item);
		 console.log($scope.cart);
		 $scope.cart=a.length;
		 console.log(a)
	 }
	 $scope.showCart=function(){
		 $rootScope.cart_items=a;
		 //console.log($scope.item);
		 a.push(item);
		 console.log($scope.cart);
		 $scope.cart=a.length;
		 console.log(a)
	 }
 })
 .controller("CartController", function($rootScope,$scope,$http,$location,$window) {
	 
	 
 })
 
 

