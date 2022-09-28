# recirende

# Dcocumenta��o de uso da API Recirende.

Para come�a a trabalhar com a API, � necessario primeiro cadastrar um usu�rio.
{ 
    "cpf": "0103040506-1",
    "nome": "Joaquim"
}
Ap�s ser cadastrado ou apenas um dos usuario voc� ter� acesso � todas as requi��es padr�o http como:
GET, POST, PUT e DELET seguindo � URL padr�o "/usu�rio".

## Cadastrando embalagem

Observa��o, para cadastrar uma embalagem, primeiro voc� ter pelo menos um usu�rio cadastro no sistema.

O seguinte modelo abaixo, cadastra uma embalagem:

{
    "marca":"Dorito"
    numeroDeSerie:"123d",
    localDeColeta:"SP",

    "usuario":{ 
    "cpf":"0103040506-1"
    }
}
Ap�s cadastrar a embelagem voc� ter� acesso a todos o m�todos de requi��o:
GET, POST, PUT e DELET seguindo � URL padr�o "/embalagem".

## Cadastrando pr�mio
Para cadastrar um pr�mio ser� necess�rio cadastrar uma embalagem e um usu�rio.
O cadastro do pr�mio segue o seguinte modelo abaixo.

{
    "tipo":"PRODUTOS",
    "nome": "IPHONE",
    "valorPrmeio":6000,
    
    "usuario":{
    "cpf":"0103040506-1"
    }
}

Observa��o: Se voc� j� indicar o usu�rio na hora do cadastro do pr�mio, o mesmo ser� atribu�do ao usuario.
Cado n�o queira indicar um premiado na hora do cadastrado, basta omitir o atributo "usuario".

Ap�s cadastrar o pr�mop voc� ter� acesso a todos o m�todos de requi��o:
GET, POST, PUT e DELET seguindo � URL padr�o "/premio".

Ap�s a etapas acima serem feita corretamente, a API estar� pronta para o uso, lembrando que se  houver um novo cadastrado,
de uma nova embalagem e o corpo JASON for indicado o usu�rio respons�vel pela embalagem, 
automaticamente a sua pontua��o ter� um valor acrencentado 1500 ponto por cadastrado.

O








