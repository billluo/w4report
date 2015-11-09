app.	controller('MainController', function ($scope,$http) {
	$scope.cyclecounts=null;
	$http.get("http://localhost:8080/w4report/cycledtlreport")
		.success(function(data){
			$scope.cyclecounts = data; 
			$scope.dataCsv = data; 
		}).error(function(){
	        alert("error");
	    });
	$scope.getHeader = function () {
		return ["Counted Date",
		        "Warehouse",
		        "Location Name",
		        "SKU Id",
		        "Style",
		        "Expected Qty",
		        "Actual Qty",
		        "Variance Qty"
		        ]};
    });