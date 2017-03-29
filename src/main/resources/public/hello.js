/**
 * Created by jgodoi on 29/03/2017.
 */
angular.module('demo', [])
    .controller('HelloListing', function($scope, $http, $location) {
        $scope.listing=function () {
            var url = "/greeting";
            $http.get(url).
            then(function(response) {
                $scope.greetings = response.data;
            });
        };
        $scope.deleteGreeting=function (id) {
            var url = "/greeting?id="+id;
            $http.delete(url).
            then(function(response) {
                $scope.greeting = response.data;
                $scope.listing();
            });
        };
        $scope.updateGreeting=function (id,name) {
            var url = "/greeting?id="+id+"&name="+name;
            $http.put(url).
            then(function(response) {
                $scope.greeting = response.data;
                $scope.listing();
            });
        };
        $scope.listing();
    });
