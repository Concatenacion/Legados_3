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
    }).when('/create', {
        templateUrl: 'views/create.html',
        controller: 'CreateCtrl'
    }).otherwise({
        redirectTo: '/'
    })
});

app.controller('ListCtrl', function ($scope, $http) {
    $http.get('/numbers').success(function (data) {
        console.log(data)
    }).error(function (data, status) {
        console.log('Error ' + data)
    })
});

app.controller('CreateCtrl', function ($scope, $http, $location) {
    $scope.todo = {
        done: false
    };

    $scope.createTodo = function () {
        console.log($scope.todo);
        $http.get('/game/2', $scope.todo).success(function (data) {
            console.log(data)
            $location.path('/');
        }).error(function (data, status) {
            console.log('Error ' + data)
        })
    }
});