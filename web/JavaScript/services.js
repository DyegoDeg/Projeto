angular.module('app.service',[]).factory('ProdutoService', function($resource){
    return  $resource ('http://' + window.location.hostname + ':' + window.location.port  + '/Projeto/rest/produto/:id', { id: '@_id' }, {
    update: {
      method: 'PUT'
    }
  });
}).factory('ComentarioService', function($resource){
    return  $resource ('http://' + window.location.hostname + ':' + window.location.port + '/Projeto/rest/comentario/:id', { id: '@_id' }, {
    update: {
      method: 'PUT'
    }
    });
});


