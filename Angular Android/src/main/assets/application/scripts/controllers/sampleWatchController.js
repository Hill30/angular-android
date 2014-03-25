angular.module('application').controller('sampleWatchController', [
    '$scope', '$log', '$resource', '$location',  function($scope, console, $resource, $location) {

     $scope.time = '--:--:--'

     $scope.$on('updateWatch', function(event, time) {
                    console.log(time);
                    $scope.time = time;
                }
            );

}])
