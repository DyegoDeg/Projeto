
function objProduto(){
    return {
        id: 0,
        cdProduto: "",
        dsProduto: "",
        vlAltura:"",
        vlLargura:"",
        vlProfundidade:""
    };
};

function objComentario(){
    return {
        cdComentario: 0,
        produto: objProduto(),
        dsComentario: ""
    };
};

