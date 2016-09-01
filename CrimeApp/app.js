var crimeApp = angular.module('HelloUserApp', []);

crimeApp.controller('HelloUserController', function($scope,$http) {
    $scope.NameChange = function () {
        $scope.greeting = "Hello " + $scope.name;
    };
    $scope.message = "HelloWorld";
    // $scope.crimes = [{"id":1,"CrimeRegion":"Dallas","CrimeType":"Murder","suspectDetails":"Indian"},{"id":2,"CrimeRegion":"Austin","CrimeType":"Robbery","suspectDetails":"Women"}];
    var response = $http.get('http://localhost:8080/CrimeStreetRestServices/Rest/crimeService/crimes');
    response.success(function (data) {
        $scope.crimes = data;
        console.log("[main] # of items: " + data.length)
        angular.forEach(data, function (element) {
            console.log("[main] crime: " + element.name);
        });
    })
    response.error(function (data, status, headers, config) {
        alert("AJAX failed to get data, status=" + status);
    })

    $scope.clearForm = function () {
        $scope.crime = {
            id: '',
            crimeRegion: '',
            crimeType: '',
            suspectDetails: ''
        };
    }

    $scope.addNew = function (element) {
        $scope.newCrime = true;
        $scope.operation = "create";
        $scope.clearForm();
    }

    $scope.addCrime = function () {
        if ($scope.newCrime == true) {

                $scope.jsonObj = angular.toJson($scope.crime, false);
                console.log("create data: " + $scope.jsonObj);

                if ($scope.operation == "create") {


                    var response = $http.post('http://localhost:8080/CrimeStreetRestServices/Rest/crimeService/add', $scope.jsonObj);
                    response.success(function (data, status, headers, config) {
                        console.log('successfully added a crime');
                        $scope.newCrime = false;
                    });

                    response.error(function (data, status, headers, config) {
                        alert("AJAX failed to get data, status=" + status);
                    })
                }
            };
        }
});

crimeApp.controller('AboutController',function($scope){
   $scope.message = "Under Construction";
});

crimeApp.controller('AddCrimeController',function($scope){
    $scope.message = "Still Building";


});
