/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module('app',[]);

app.controller('principalController', function($scope){
    
    $scope.showTela = function(menu){
        switch (menu){
            case 'cadastro' :
                window.location = "cadastroProduto.html";
                return;
        }
    };
    
});


