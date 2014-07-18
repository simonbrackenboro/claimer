'use strict';

var app = angular.module('claimer', [
  'claimer.services',
  'claimer.controllers',
  'treeControl'
]);

var valueSelection = function (newValue, key, state) {
  if (typeof newValue == "undefined") {
    newValue = state.value;
  }
  if (typeof newValue == "undefined" && state.possibleValues.length < 1) {
    state.value = undefined;
  } else {
    state.value = state.possibleValues[0];
    state.possibleValues.some(function (value) {
      if (value[key] === newValue[key]) {
        state.value = value;
        return true;
      }
      return false;
    });
  }
  return state.value;
};

app.directive('selectenvbranchcommit', function () {
    return {
      restrict: 'E',
      scope: {
        name: '@name'
      },
      link: function ($scope, iElement, iAttrs, ctrl) {
        var $root = $scope.$root;
        if (typeof $root.selectenvbranchcommits == "undefined") {
          $root.selectenvbranchcommits = [];
        }
        $root.selectenvbranchcommits[$root.selectenvbranchcommits.length] = $scope;
        $scope.loadEnvironments();
      },
      controller: ['$scope', 'repoService', '$rootScope', '$http', function ($scope, repoService, $rootScope, $http) {
        /*var selector = "#" + $scope.name + "Text";
         var $2 = $(selector)[0];
         $scope.mirror = CodeMirror.fromTextArea($2, {
         lineNumbers: true,
         mode: "text/html",
         value : ""
         });*/


        $scope.showSelected = function (node) {
          $http({method: 'GET', url: node.url, headers: {'Accept': 'application/vnd.github.v3.raw'}}).
            success(function (data, status, headers, config) {
              var $rootScope2 = $rootScope[$scope.name];
              $rootScope2.setValue(data);
            });
        };

        $scope.treeOptions = {
          nodeChildren: "children",
          dirSelectable: true,
          injectClasses: {
            ul: "a1",
            li: "a2",
            liSelected: "a7",
            iExpanded: "a3",
            iCollapsed: "a4",
            iLeaf: "a5",
            label: "a6",
            labelSelected: "a8"
          }
        };

        $scope.name = 'default';
        $scope.environment = {possibleValues: undefined, value: undefined};
        $scope.branch = {possibleValues: undefined, value: undefined};
        $scope.commit = {possibleValues: undefined, value: undefined};
        $scope.tree = {possibleValues: undefined, value: undefined};

        $scope.loadEnvironments = function () {
          repoService.environmentQuery($rootScope.username).query(function (values) {
            $scope.environment.possibleValues = values;
            if (values.length > 0) {
              $scope.setEnvironment(values[0]);
            }
          });
        };

        $scope.setEnvironment = function (environment) {
          valueSelection(environment, 'name', $scope.environment)
          $scope.loadBranches({name: environment.default_branch});
        };


        $scope.loadBranches = function (def) {
          repoService.branchQuery($rootScope.username, $scope.environment.value.name).query(function (values) {
            $scope.branch.possibleValues = values;
            if (values.length > 0) {
              $scope.setBranch(def);
            }
          });
        };

        $scope.setBranch = function (branch) {
          var value = valueSelection(branch, 'name', $scope.branch);
          $scope.loadCommits(value.commit);
        };

        $scope.loadCommits = function (def) {
          repoService.commitsQuery($rootScope.username, $scope.environment.value.name, $scope.branch.value.name, def.sha).query(function (values) {
            $scope.commit.possibleValues = values;
            if (values.length > 0) {
              $scope.setCommit(def);
            }
          });
        };

        $scope.setCommit = function (commit) {
          var value = valueSelection(commit, 'sha', $scope.commit);
          $scope.loadTree();
        };

        $scope.loadTree = function () {
          repoService.treeQuery($rootScope.username, $scope.environment.value.name, $scope.branch.value.name, $scope.commit.value.commit.tree.sha).query(function (value) {
            var values = value.tree
            $scope.tree.possibleValues = values;
            if (values.length > 0) {
              $scope.setTree($scope.tree.possibleValues[0]);
            }
          });
        };

        $scope.setTree = function (tree) {
          var value = valueSelection(tree, 'sha', $scope.tree);
          $scope.showSelected(value);
        };
      }
      ],
      templateUrl: '/templates/selectenvbranchcommit.html'
    }
  }
)
;

var services = angular.module('claimer.services', ['ngResource']);

services.service('repoService', ['$resource', function ($resource) {
  return {
    environmentQuery: function (owner) {
      return $resource('https://api.github.com/users/:owner/repos',
        {owner: owner},
        {query: { method: 'GET', isArray: true }}
      )
    },
    branchQuery: function (owner, repo) {
      return $resource('https://api.github.com/repos/:owner/:repo/branches',
        {owner: owner, repo: repo},
        {query: { method: 'GET', isArray: true }}
      )
    },
    commitsQuery: function (owner, repo, sha) {
      return $resource('https://api.github.com/repos/:owner/:repo/commits',
        {owner: owner, repo: repo, sha: sha},
        {query: { method: 'GET', isArray: true }}
      )
    },
    treeQuery: function (owner, repo, sha) {
      return $resource('https://api.github.com/repos/:owner/:repo/git/trees/:sha',
        {owner: owner, repo: repo, sha: sha},
        {query: { method: 'GET'}}
      )
    }
  }
}])
;

var controllers = angular.module('claimer.controllers', []);

controllers.controller('login', ['$rootScope', '$scope', function ($rootScope, $scope) {
  $scope.username = 'opengamma';
  $rootScope.username = $scope.username;
  $scope.login = function () {
    $rootScope.username = $scope.username;
    $rootScope.password = $scope.password;
    for (var index = 0; index < $rootScope.selectenvbranchcommits.length; ++index) {
      $rootScope.selectenvbranchcommits[index].loadEnvironments();
    }
  };
  var target = document.getElementById("view");
  $rootScope.mirror = CodeMirror.MergeView(target, {
    lineNumbers: true,
    mode: "text/html",
    origLeft: "",
    value: "",
    highlightDifferences: true
  });

  var full = "100%";
  $rootScope.mirror.editor().setSize(null, full);
  if ($rootScope.mirror.leftOriginal())
    $rootScope.mirror.leftOriginal().setSize(null, full);
  if ($rootScope.mirror.rightOriginal())
    $rootScope.mirror.rightOriginal().setSize(null, full);

  $rootScope.From = $rootScope.mirror.leftOriginal();
  $rootScope.To = $rootScope.mirror.editor();
}]);