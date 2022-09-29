# recirende

## Documentações de uso da API Recirende.

## Castrando usuarios.

Para começa a trabalhar com a API, é necessario primeiro cadastrar um usuário.

{
"cpf": "01030405061",
"nome": "Joaquim"
}

Após ser cadastrado o usuario terá acesso a todas as requisiçôes padrão http como:
GET, POST, PUT, DELET e terá acesso ao GET por CPF seguindo a URL padrão "/usuario".

## Cadastrando embalagem

Observaçõeso, para cadastrar uma embalagem, primeiro você precisa ter um usuário cadastro no sistema.

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

Após cadastrar a embelagem você terá acesso a todos o métodos de requisições:
GET, POST, PUT e DELET seguindo a URL padrão "/embalagem".

## Cadastrando prêmio

Para cadastrar um prêmio será necessário cadastrar uma embalagem e um usuário.
O cadastro do prêmio segue o seguinte modelo abaixo.

{
"tipo":"PRODUTOS",
"nome": "IPHONE",
"valorPrmeio":6000,

    "usuario":{
    "cpf":"01030405061"
    }
}

Observação: Se você já indicar o usuário na hora do cadastro do prêmio, o prêmio será atribuído ao usuario.
Caso não queira indicar um premiado na hora do cadastrado, basta omitir o atributo "usuario".

Após cadastrar o prêmop você terá acesso a todos o métodos de requições:
GET, POST, PUT e DELET seguindo a URL padrão "/premio".

Após a etapas acima serem feita corretamente, a API estará pronta para o uso. Lembrando que se houver um novo
cadastrado, de uma nova embalagem e o corpo JASON for indicado o usuário responsável pela embalagem,
automaticamente a sua pontuação terá um valor acrencentado 1500 ponto por cadastrado.

## Regastando Premio

Para regatar um prêmio a preciso seguir todos os passos descrito acima.
Observe que para retirar seu prêmio,você precisa ter uma pontuação maior ou igual ao valor do prêmio.

A URL padrão para solicitar a retirada do prêmio é: "/usuario/{cpf}/premio/{idPremio}",
lembrando que a requisiçãoo é a do tipo PUT.

Note que sempre que você resgastar um prêmio, ele será automaticamente excluído da lista do prêmio cadastrado e a 
pontuação do usuário que solicitou o resgate, será atualizada.










