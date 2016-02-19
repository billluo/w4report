app.	controller('MainController', function ($scope,$http) {
	$scope.cyclecounts=null;
	var urlRpt = '/w4report/v1/cycledtlreport';
	$http.get(urlRpt)
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