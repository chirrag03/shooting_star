'use strict';

SIRIUS.config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        // $urlRouterProvider.otherwise('/profile-page');
        $stateProvider
            .state('profile-page', {
                url: '/profile-page',
                templateUrl: 'html/common/profile-page.html',
                controller: 'profilePageCtrl'
            })
            .state('resources', {
                url: '/resources',
                templateUrl: 'html/common/resources.html',
                controller: 'resourcesCtrl'
            })
            .state('artworks', {
                url: '/artworks',
                templateUrl: 'html/common/artworks.html',
                controller: 'artworksCtrl'
            });
    }
]);

// SIRIUS.config(['$httpProvider', 'loginServiceProvider',
//     function($httpProvider, loginServiceProvider){
//         var interceptor = [
//             '$q', '$rootScope',
//             function($q, $rootScope){
//                 var service = {
//                     // run this function before making requests
//                     'request': function(config) {
//                         if(config.method === 'POST' || config.method === 'PUT'){
//                             config.headers['X-Auth-Token'] = "VVTsND3Kl77W1NpJc9sKsl60m3ViiKi9DQgJ";
//                             config.headers['X-Requested-By'] = loginServiceProvider.$get().getUserId();
//                             config.headers['X-Request-Origin'] = 'CMS App';
//                             return config;
//                         }
//                         return config;
//                     }
//                 };
//                 return service;
//             }
//         ];
//         $httpProvider.interceptors.push(interceptor);
//     }]);