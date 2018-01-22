angular.module('app.services', []).factory('Game', function($resource) {
  return $resource('/api/v1/games/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
