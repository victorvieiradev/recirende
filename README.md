# recirende

# Dcocumentação de uso da API Recirende.

Para começa a trabalhar com a API, é necessario primeiro cadastrar um usuário.
{ 
    "cpf": "0103040506-1",
    "nome": "Joaquim"
}
Após ser cadastrado ou apenas um dos usuario você terá acesso á todas as requições padrão http como:
GET, POST, PUT e DELET seguindo à URL padrão "/usuário".

## Cadastrando embalagem

Observação, para cadastrar uma embalagem, primeiro você ter pelo menos um usuário cadastro no sistema.

O seguinte modelo abaixo, cadastra uma embalagem:

{
    "marca":"Dorito"
    numeroDeSerie:"123d",
    localDeColeta:"SP",

    "usuario":{ 
    "cpf":"0103040506-1"
    }
}
Após cadastrar a embelagem você terá acesso a todos o métodos de requição:
GET, POST, PUT e DELET seguindo à URL padrão "/embalagem".

## Cadastrando prêmio
Para cadastrar um prêmio será necessário cadastrar uma embalagem e um usuário.
O cadastro do prêmio segue o seguinte modelo abaixo.

{
    "tipo":"PRODUTOS",
    "nome": "IPHONE",
    "valorPrmeio":6000,
    
    "usuario":{
    "cpf":"0103040506-1"
    }
}

Observação: Se você já indicar o usuário na hora do cadastro do prêmio, o mesmo será atribuído ao usuario.
Cado não queira indicar um premiado na hora do cadastrado, basta omitir o atributo "usuario".

Após cadastrar o prêmop você terá acesso a todos o métodos de requição:
GET, POST, PUT e DELET seguindo à URL padrão "/premio".

Após a etapas acima serem feita corretamente, a API estará pronta para o uso, lembrando que se  houver um novo cadastrado,
de uma nova embalagem e o corpo JASON for indicado o usuário responsável pela embalagem, 
automaticamente a sua pontuação terá um valor acrencentado 1500 ponto por cadastrado.

O








