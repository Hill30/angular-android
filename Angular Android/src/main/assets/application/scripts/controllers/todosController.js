angular.module('application').controller('todosController', [
    '$scope', '$log', '$resource', '$location',  function($scope, console, $resource, $location) {

     var Records = $resource('api/get');

     var Update = $resource('api/update/:index')

     var current = -1;

     $scope.records = Records.query();

     $scope.isSelected = function(index) {
        return index === current;
     };

     $scope.select = function(index) {
        current = index;
     };

     $scope.save = function(index) {
        Update.save({index:index}, $scope.records[index]);
        current = -1;
     }

     $scope.showWatch = function() {
        $location.path("watch");
     };

}])
