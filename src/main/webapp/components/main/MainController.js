app.controller('MainController',function($scope, $http) {
	$scope.cyclecounts=null;
//	$http.get("http://localhost:8080/w4reports/cycledtlreporttest/8000417428L")
	$http.get("http://localhost:8080/w4reports/cycledtlreport")
		.success(function(data){
			$scope.cyclecounts = data; 
		}).error(function(){
	        alert("error");
	    })
});