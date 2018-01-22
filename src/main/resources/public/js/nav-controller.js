angular.module('navController', [])
	.controller('nav', function($scope, $state) {
		$scope.title = 'Havin Board Game Chooser';

		// returns true if the current router url matches the passed in url
		// so views can set 'active' on links easily
		$scope.isUrl = function(url) {
			if (url === '#') return false;
			return ('#' + $state.$current.url.source + '/').indexOf(url + '/') === 0;
		};

		$scope.pages = [
			{
				name: 'Home',
				url: '#/'
			},
			{
				name: 'Games',
				url: '#/games'
			}
		]
	});
