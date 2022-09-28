# recirende

## Documenta��o de uso da API Recirende.

## Castrando usuarios.

Para come�a a trabalhar com a API, � necessario primeiro cadastrar um usu�rio.

{
"cpf": "01030405061",
"nome": "Joaquim"
}

Ap�s ser cadastrado o usuario ter� acesso � todas as requi��es padr�o http como:
GET, POST, PUT e DELET seguindo � URL padr�o "/usuario".

## Cadastrando embalagem

Observa��o, para cadastrar uma embalagem, primeiro voc� precisa ter um usu�rio cadastro no sistema.

O seguinte modelo abaixo cadastra uma embalagem:

{
"marca":"Dorito"
"numeroDeSerie":"123d",
"localDeColeta":"SP",

    "usuario":{ 
    "nome":"Joaquim",
    "cpf":"01030405061"
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
    "cpf":"01030405061"
    }
}

Observa��o: Se voc� j� indicar o usu�rio na hora do cadastro do pr�mio, o pr�mio ser� atribu�do ao usuario.
Caso n�o queira indicar um premiado na hora do cadastrado, basta omitir o atributo "usuario".

Ap�s cadastrar o pr�mop voc� ter� acesso a todos o m�todos de requi��o:
GET, POST, PUT e DELET seguindo � URL padr�o "/premio".

Ap�s a etapas acima serem feita corretamente, a API estar� pronta para o uso. Lembrando que se houver um novo
cadastrado, de uma nova embalagem e o corpo JASON for indicado o usu�rio respons�vel pela embalagem,
automaticamente a sua pontua��o ter� um valor acrencentado 1500 ponto por cadastrado.

## Regastando Premio

Para regatar um pr�mio � preciso seguir todos os passos descrito acima.
Observe que para retirar seu pr�mio,voc� precisa ter uma pontua��o maior ou igual ao valor do pr�mio.

A URL padr�o para solicitar a retirada do pr�mio �: "/usuario/{cpf}/premio/{idPremio}",
lembrando que a requisi��o � a do tipo PUT.

Note que sempre que voc� resgastar um pr�mio, ele ser� automaticamente exclu�do da lista do pr�mio cadastrado e a 
pontua��o do usu�rio que solicitou o resgate, ser� atualizada.










