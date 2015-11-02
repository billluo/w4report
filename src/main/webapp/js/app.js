//var app = angular.module('4wall-reports', ['ui.router','ui.router.stateHelper','ngAnimate','ngCookies','ngResource','ngMockE2E','ngStorage']);
var app = angular.module('4wall-reports', []);

/** Start of Configurable constants **/
app.constant('useMockData', false);
app.constant('context', '/petclinic');
/** End of Configurable constants **/

//stateHelperProvider is a 3rd party module created by @marklagendijk.
//app.config(['stateHelperProvider','$urlRouterProvider','$urlMatcherFactoryProvider',function(stateHelperProvider,$urlRouterProvider,$urlMatcherFactoryProvider) {
//
//	$urlRouterProvider.otherwise("/");
//
//	$urlMatcherFactoryProvider.strictMode(false)

//	stateHelperProvider.state({
//		name: "landing",
//		url: "/",
//		templateUrl: "components/landing.html",
//		controller: "MainController",
//		data: { requireLogin : false }
//	});
//	}).state({
//		name: "contactUs",
//		url: "/contactus",
//		templateUrl: "components/contactus.html",
//		controller: "ContactusController",
//		data: { requireLogin : true }
//	}).state({
//		name: "about",
//		url: "/about",
//		templateUrl: "components/about.html",
//		controller: "AboutController",
//		data: { requireLogin : true }
//	});

//} ]);
//
///** Controllers **/
app.controller('MainController', MainController);
app.controller('ContactusController', DashboardController);
app.controller('AboutController', VeterinarianController);


/** Services **/
app.factory('Owner', Owner);
app.factory('Pet', Pet);
app.factory('OwnerPet', OwnerPet);
app.factory('Vet', Vet);
app.factory('Visit', Visit);
app.factory('PetType', PetType);
app.factory('MockService', MockService);

/** Directives **/

app.directive('scrollToTarget', function() {
  return function(scope, element) {
    element.bind('click', function() {
    	angular.element('html, body').stop().animate({
			scrollTop: angular.element(angular.element(element).attr('href')).offset().top - 20
		}, 1500);
		return false;
    });
  };
});

//app.directive('datePicker', DatePickerDirective);

//app.run(function(useMockData, MockService) {
//	MockService.mock(useMockData);
//});