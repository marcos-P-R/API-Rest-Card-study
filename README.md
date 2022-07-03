# API para cadastrar cards de estudos

A API é um crud básico para relembrar meus estudos de java e spring, 
nessa api ela faz 4 operações básicas para armazenar as informações do card

## Para rodar no seu computador
1. Tenha o java instalado
2. Tenha instalado o Mysql
3. Faça um clone do projeto
4. configure no arquivo application.properties
as configurações do seu DB
5. Execute o projeto

## Metodo GET
/api/v1/card

Que pega todos os cards disponiveis

## Metodo POST
/api/v1/card

~~~json
{
    "titulo":"exemplo de um titulo",
    "conteudo":"Aqui vai o conteudo ou link de estudo"
}
~~~

## Metodo PUT
/api/v1/card/{id}

Você atualiza o coponente passando o id no campo da url

~~~json
{
    "titulo":"exemplo de um titulo",
    "conteudo":"Aqui vai o conteudo ou link de estudo"
}
~~~

## Metodo DELETE
/api/v1/card/{id}

Passando o id como parametro você deleta o card