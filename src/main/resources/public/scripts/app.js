var app = angular.module('todoapp', [
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute'
]);

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'views/list.html',
        controller: 'ListCtrl'
    }).otherwise({
        redirectTo: '/'
    })
});

app.controller('ListCtrl', function ($scope, $http) {
    $http.get('/numbers').success(function (data) {
        $scope.numbers=data;
    }).error(function (data, status) {
        console.log('Error ' + data)
    });

    $scope.game = function () {
        $http.get('/game/'+$scope.title).success(function (data) {
            console.log(data);
            $scope.todo = data;
        }).error(function (data) {
            console.log('Error ' + data)
        });
    }

    $scope.cinta = function () {
        $http.get('/cinta/'+$scope.title).success(function (data) {
            console.log(data);
            $scope.todo = data;
        }).error(function (data) {
            console.log('Error ' + data)
        });
    }
});
