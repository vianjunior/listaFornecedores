/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module("Fornecedores", []);

app.value('urlBase', 'http://localhost:8080/listaEmpresas/rest/fornecedores');

app.controller("FornecedoresCtrl", ($scope, $http, urlBase) => {
    
    $scope.app = 'Lista de Fornecedores';
    $scope.fornecedor = {};
    $scope.info = "";
    
    $scope.registros = [];
    
    $scope.atualizarLista = function (){
        $http({
            method: 'GET',
            url: urlBase + '/lista'
        }).then(function successCallback(response) {
            $scope.registros = response.data;
        }, function errorCallback(response){
            $scope.erro();
        });
    };
    
    $scope.abrir = function (op, fornecedor) {
        if (op === 'criar') {
            zeraValores();
            $("#modalFornecedor").modal("show");
        } else {
            $scope.fornecedor.id = fornecedor.id;
            $scope.fornecedor.razaoSocial = fornecedor.razaoSocial || "";
            $scope.fornecedor.email = fornecedor.email || "";
            $scope.fornecedor.cnpj = fornecedor.cnpj || "";
            $scope.fornecedor.obs = fornecedor.obs || "";
            $("#modalFornecedor").modal("show");
        }
    };
    
    $scope.salvar = function (registro) {
        var metodo = 'POST';
        var rota = '/cadastra';
        if (registro.id) {
            metodo = 'PUT';
            rota = '/atualiza';
        };
        
        $http({
            method: metodo,
            url: urlBase + rota,
            data: $scope.fornecedor
        }).then(function successCallback(response){
            $scope.atualizarLista();
            $scope.info = "Operação realizada com sucesso!";
            
        }, function errorCallBack(response){
            $scope.erro();
        });
    };
    
    $scope.erro = function () {
        alert("Não foi possível concluír o processo!");
    };
    
    
    $scope.deletar = function(registro){
        $scope.fornecedor = registro;
        
        $http({
            method: 'DELETE',
            url: urlBase + '/deleta',
            data: $scope.fornecedor
        }).then(function successCallback(response){
            $scope.atualizarLista();
            $scope.info = "Fornecedor " + registro.id + " excluído com sucesso!";
        }, function errorCallback(response){
            $scope.erro();
        });
   
    };
    
    $scope.cancelar = function () {
        $("#modalFornecedor").modal("hide");
    };
    
    $scope.limparInfo = function () {
        $scope.info = "";
    };
    
    function zeraValores(){
        $scope.fornecedor.id = "";
        $scope.fornecedor.razaoSocial = "";
        $scope.fornecedor.email = "";
        $scope.fornecedor.cnpj = "";
        $scope.fornecedor.obs = "";
    };
    
    
    $scope.activate = function () {
        $scope.atualizarLista();
    };
    
    $scope.activate();
    
});
