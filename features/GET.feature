# language: pt
# charset: UTF-8

Funcionalidade: Realizar GET
  Eu como usuário gostaria de poder recuperar dados de uma pessoa.


  @teste1
  Esquema do Cenario:  Verificar operação de GET para pessoas
    Dado que eu deseje fazer um "GET" em "/{ddd}/{numero}"
    E e eu tenha o ddd "<ddd>" e o numero "<numero>"
    Quando eu fizer o GET com os dados
    Então o status code deverá ser "<statusCode>"
    Exemplos:
    |ddd  |numero         |statusCode|
    |  11 | 985388877     | 200      |
    |  12 | 474774        | 404      |