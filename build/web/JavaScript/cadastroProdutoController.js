/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var app = angular.module('app',["ngResource", "app.service","ui.mask","angular-loading-bar", "ngAnimate", "ui.bootstrap"]);

app.controller('cadastroProdutoController', function($resource, $scope, $filter, $uibModal, ProdutoService, $log, uibDateParser, $http, $q){
    $scope.showCadastro = false;
    $scope.produto = objProduto();
    $scope.allProdutos = {};
    
    $scope.abreCadastroProduto = function(){
        $scope.produto = objProduto();
        $scope.showCadastro = true;
    };
    
    $scope.processaFormProduto = function(i){
        $scope.produto = i;
        $scope.showCadastro = false;
        if($scope.produto.id===0){
            var promise = $scope.checkDuplidade($scope.produto.cdProduto);
            promise.then(function(data){
                if(data.cdProduto === 0){
                    $scope.saveProduto();
                }else{
                    $.gritter.add({
                        title : "Erro!!",
                        text : "Produto já cadastrado!!",
                        class_name : "gritter"
                    });
                }
            });
        }else{
            $scope.updateProduto();
        }
    };
    
    $scope.getProdutos = function(){
        ProdutoService.query({id: ""}, function(data){
            $scope.allProdutos = data;
        });
    };
    $scope.getProdutos();
    
    $scope.getProduto = function(id){
        ProdutoService.get({id: id}, function(data){
            console.log(data);
            $scope.produto = data;
        });
        $scope.showCadastro = true;
    };
    
    $scope.checkDuplidade = function(id){
        return $q(function (resolve, reject) {
            $http.get('http://' + window.location.hostname + ':' + window.location.port  + '/Projeto/rest/produto/codigo/'+id)
                .success(function(data){
                    console.log(data);
                    resolve(data);
                }).error(function(){
                    $.gritter.add({
                        title : "Erro!!",
                        text : "Erro ao captar dados!!",
                        class_name : "gritter"
                    });
                    reject('erro');
                });
        });
        
        
    };
    
    $scope.saveProduto = function(){
        ProdutoService.save($scope.produto, function(data){
            if(data !== null){
                $.gritter.add({
                    title : "Sucesso!!",
                    text : "Produto Salvo!!",
                    class_name : "gritter"
                });
            }else {
                $.gritter.add({
                    title : "Falha!!",
                    text : "Produto não foi Salvo!!",
                    class_name : "gritter"
                });
            }
            $scope.getProdutos();
            $scope.showCadastro = false;
        });
        
    };
    
    $scope.updateProduto = function(){
        ProdutoService.update($scope.produto, function(data){
            if(data !== null){
                $.gritter.add({
                    title : "Sucesso!!",
                    text : "Produto Atualizado!!",
                    class_name : "gritter"
                });
            } else {
                $.gritter.add({
                    title : "Falha!!",
                    text : "Produto não atualizado!!",
                    class_name : "gritter"
                });
            }
            $scope.getProdutos();
            $scope.showCadastro = false;
        });
        
    };
    
    $scope.removeProduto = function(id){
        ProdutoService.remove({id: id}, function(data){
            if(data !== 0){
                $.gritter.add({
                    title : "Sucesso!!",
                    text : "Produto Removido!!",
                    class_name : "gritter"
                });
            } else{
                $.gritter.add({
                    title : "Falha!!",
                    text : "Produto não removido!!",
                    class_name : "gritter"
                });
            }

            $scope.getProdutos();
        });
    };
    
    $scope.alteraItem = function(produto){
        ProdutoService.update(produto, function(){
            $scope.getProdutos();
        });
        
    };
    
    $scope.checkNumber = function (valor) {
        var regra = /^[0-9]+$/;
        if (valor.match(regra)) {
            
        }else{
            alert("Permitido somente números");
        }
    };
    
    $scope.open = function (i) {
        
      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'comentario.html',
        controller: 'comentarioCtrl',
        size: 'lg',
        resolve: {
          item: function () {
            return i;
          }
        }
      });

      modalInstance.result.then(function () {
        //return modal ok
      }, function () {
        //return modal cancel
      });
    };
    
}).controller('comentarioCtrl',function ($resource, $scope, ComentarioService,$uibModalInstance, item, $http) {
    $scope.allComentarios = {};
    $scope.comentario = objComentario();
    
    $scope.processaFormComentario = function(c){
        c.produto = item;
        $scope.saveProduto(c); 
    };
    
    $scope.saveProduto = function(c){
        ComentarioService.save(c, function(data){
            if(data !== null){
                $.gritter.add({
                    title : "Sucesso!!",
                    text : "Comentário Salvo!!",
                    class_name : "gritter"
                });
            }else {
                $.gritter.add({
                    title : "Falha!!",
                    text : "Comentário não foi Salvo!!",
                    class_name : "gritter"
                });
            }
            $scope.getComentarios();
            $scope.comentario = objComentario();
        });
        
    };
  
    $scope.getComentarios = function(){
        $http.get('http://localhost:8080/Projeto/rest/comentario/'+item.cdProduto)
                .success(function(data){
                    $scope.allComentarios = data;
            console.log(data);
        });
    };
    $scope.getComentarios();

    $scope.ok = function () {
        $uibModalInstance.close();
    };

});

