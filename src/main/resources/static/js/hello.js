/*angular.module('hehe', []).controller('home', function($scope) {
	$scope.greeting = {
		id : 'allenwish',
		content : 'Hello AllenWish,greeting you do it!!!'
	}
})*/

angular.module('hello', []).controller('home', function($scope, $http) {
	$http.get('/resource/').then(function(data) {
		console.info(data)
		data = data.data
		console.info(data)
		$scope.greeting = data;
		console.info(data.id)
		console.info(data.content)
	})
});