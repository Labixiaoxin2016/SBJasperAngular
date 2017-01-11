angular.module('com.example.sbjasperangular', [ 'ui.bootstrap', 'ngResource' ])

.factory('City', [ '$resource', function($resource) {
    return $resource('/rest/city/:resourceId', {
	resourceId : '@id'
    }, {
	query : {
	    method : 'GET',
	    cache : false,
	    isArray : false
	}

    });
} ])
/*
.factory('City', [ '$resource', function($resource) {
    return $resource('/rest/city', {

    }, {
	query : {
	    method : 'GET',
	    cache : false,
	    isArray : false
	}

    });
} ])
*/
.factory('Country', [ '$resource', function($resource) {
    return $resource('/rest/city/:resourceId/country', {
	resourceId : '@id'
    }, {
	query : {
	    method : 'GET',
	    cache : false,
	    isArray : false
	}
    });
} ])

.factory('CityCountry', [ '$resource', function($resource) {
    return $resource('/rest/citycountry', {  }, {
	query : {
	    method : 'GET',
	    cache : false,
	    isArray : true
	}

    });
} ])

.factory('CityCountry2', [ '$resource', function($resource) {
    return $resource('/rest/citycountry2', {  }, {
	query : {
	    method : 'GET',
	    cache : false,
	    isArray : false
	}

    });
} ])

.factory('Report', [ '$resource', function($resource) {
    return $resource('/ajax/report', {}, {
	generate : {
	    method : 'POST',
	    cache : false,
	    isArray : true
	}
    });
} ])

.controller('CityCtrl', function($scope, $window, City, Country, Report) {
	/* */
	City.query({}, function(data) {
		var j = 0;
		$scope.cities = data._embedded.all;
		var arrayLength = $scope.cities.length;
		for (var i = 0; i < arrayLength; i++) {
			// これでも取得できない。
//			$scope.cities[i].countryName = $scope.cities[i]._links.country.name;
			///*
			// ここにはバグがある。
			Country.query({
				resourceId : $scope.cities[i].name
			}, function(data2) {
				$scope.cities[j].countryName = data2.name;
//				$windows.alert($scope.cities[i].name + " " + $scope.cities[i].country);
				++j;
			}
//			++j;
			);
//			++j;
			// */
		}

	});
	/* */
	/*
	// [実験]なぜかうまくいかなかった。
	CityCountry.query({

	}, function(data) {
		$scope.cities = data;// data._embedded.all
		for (var i = 0; i < arrayLength; i++) {
			$scope.cities[i].name = "hoge";
		}
	});
	 */
	$scope.report = function() {
		Report.generate({}, $scope.cities, function(data) {
			$window.location.href = '/jasper/report.pdf';
		}, function(err) {
			alert(err.data.message);
		});
	}
});