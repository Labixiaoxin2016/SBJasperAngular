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

.factory('CassandraCityCountry', [ '$resource', function($resource) {
    return $resource('/rest/rest_resource_citycountry', {
    	resourceId : '@id'
    }, {
	query : {
	    method : 'GET',
	    cache : false,
	    isArray : false
	}

    });
} ])

.factory('CassandraCityCountryJoin', [ '$resource', function($resource) {
    return $resource('/rest/cassandra/city_country_join', {
//    	resourceId : '@id'
    }, {
	query : {
	    method : 'GET',
	    cache : false,
	    isArray : true
	}

    });
} ])

//.factory('CityCountry3', [ '$resource', function($resource) {
//    return $resource('/rest_repository/rest_resource_citycountry', {  }, {
//	query : {
//	    method : 'GET',
//	    cache : false,
//	    isArray : false
//	}
//
//    });
//} ])

.factory('Report', [ '$resource', function($resource) {
    return $resource('/ajax/report', {}, {
	generate : {
	    method : 'POST',
	    cache : false,
	    isArray : true
	}
    });
} ])

.controller('CityCtrl', function(
		$scope,
		$window,
//		City,
//		Country,
//		CassandraCityCountry,
		CassandraCityCountryJoin,
		Report) {
	/*
	City.query({}, function(data) {
		var j = 0;
		$scope.cities = data._embedded.all;
		var arrayLength = $scope.cities.length;
//		window.alert(arrayLength);
		for (var i = 0; i < arrayLength; i++) {
			// これでも取得できない。
//			$scope.cities[i].countryName = $scope.cities[i]._links.country.name;
			//
			// ここにはバグがある。
			var city_name = $scope.cities[i].name;
//			window.alert(i + ":" + city_name);
			Country.query({
				resourceId : $scope.cities[i].name
			}, function(data2) {
//				window.alert(j + ":" + city_name + ":" + data2.name);
				$scope.cities[j].countryName = data2.name;
				++j;
			}
//			++j;
			);
//			++i;
			//
		}

	});
	  */
	/*
	// [実験]
	CityCountry.query({

	}, function(data) {
//		$windows.alert(data);
		$scope.cities = data;// data
		var arrayLength = $scope.cities.length;
//		window.alert(arrayLength);
//		for (var i = 0; i < arrayLength; i++) {
//			$scope.cities[i].name = "hoge";
//		}
	});
	 */
	/*
	// [実験]
	CassandraCityCountry.query({

	}, function(data) {
//		$windows.alert(data);
		$scope.cities = data._embedded.all;// data
		var arrayLength = $scope.cities.length;
//		window.alert(arrayLength);
//		for (var i = 0; i < arrayLength; i++) {
//			$scope.cities[i].name = "hoge";
//		}
	});
	 */
	/* */
	// [実験]
	CassandraCityCountryJoin.query({

	}, function(data) {
//		$windows.alert(data);
		$scope.cities = data;// data
		var arrayLength = $scope.cities.length;
//		window.alert(arrayLength);
//		for (var i = 0; i < arrayLength; i++) {
//			$scope.cities[i].name = "hoge";
//		}
	});
	/* */
	$scope.report = function() {
		Report.generate({}, $scope.cities, function(data) {
			$window.location.href = '/jasper/report.pdf';
		}, function(err) {
			alert(err.data.message);
		});
	}
});
