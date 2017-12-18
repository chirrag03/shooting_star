"use strict";

SIRIUS.controller('artworksCtrl', ['$scope', '$state',
    function ($scope, $state) {

        $(document).keydown(function(e)
        {
            var currentURL = (document.URL);
            var current = currentURL.split("-")[1];

            switch (e.which)
            {
                case 37:
                    $('.lb-prev')[--current].click();
                    break;

                case 39:
                    $('.lb-next')[current++].click();
                    break;

                case 27:
                    $('.lb-close')[0].click();
                    break;
            }
        });

        console.log('artworks controller');
    }]);