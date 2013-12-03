'use strict';
angular.module('tilosApp')
  .controller('SocialCtrl', ['$scope', '$routeParams', 'API_SERVER_ENDPOINT', 'tilosData', '$http',
    function ($scope, $routeParams, $server, $td, $http) {
      $scope.Math = window.Math;

      $td.getFacebookData(function (data) {
        $scope.facebook = data;
      });


      $scope.share = function (name, definition, alias) {
        window.open(
          "http://www.facebook.com/sharer.php?s=100&p[title]=" + encodeURIComponent(name) + "&p[summary]=" + encodeURIComponent(definition) + "&p[url]=" + encodeURIComponent(server + "/#/show/" + alias) + "",
          '',
          "width=500, height=300"
        );
      };

    }
  ]);
