angular.module('app.controllers', []).controller('GameListController', function($scope, $state, popupService, $window, Game) {
  $scope.games = Game.query(); //fetch all games. Issues a GET to /api/vi/games

  $scope.deleteGame = function(game) { // Delete a Game. Issues a DELETE to /api/v1/games/:id
    if (popupService.showPopup('Really delete this?')) {
      game.$delete(function() {
        $scope.games = Game.query(); 
        $state.go('games');
      });
    }
  };
}).controller('GameViewController', function($scope, $stateParams, Game) {
  $scope.game = Game.get({ id: $stateParams.id }); //Get a single game.Issues a GET to /api/v1/game/:id
}).controller('GameCreateController', function($scope, $state, $stateParams, Game) {
  $scope.game = new Game();  //create new game instance. Properties will be set via ng-model on UI

  $scope.addGame = function() { //create a new game. Issues a POST to /api/v1/games
    $scope.game.$save(function() {
      $state.go('games'); // on success go back to the list i.e. games state.
    });
  };
}).controller('GameEditController', function($scope, $state, $stateParams, Game) {
  $scope.updateGame = function() { //Update the edited game. Issues a PUT to /api/v1/games/:id
    $scope.game.$update(function() {
      $state.go('games'); // on success go back to the list i.e. games state.
    });
  };

  $scope.loadGame = function() { //Issues a GET request to /api/v1/games/:id to get a games to update
    $scope.game = Game.get({ id: $stateParams.id });
  };

  $scope.loadGame(); // Load a game which can be edited on UI
});
