# language: pt
# charset: UTF-8

Funcionalidade: Realizar POST
  Eu como usuário gostaria de poder inserir dados de uma pessoa.


  @teste2
  Esquema do Cenario: Verificar operação de POST para pessoas
    Dado que eu deseje fazer um "POST" em "/pessoas"
    E eu tenha o código "<codigo>" e o cpf "<cpf>"
    Quando eu realizar o POST
    Então o status code deverá ser "<statusCode>"
    Exemplos:
    |codigo|cpf         |statusCode|
    |5     |42184445810 |  201     |
    |5     |42184445810 |  400     |

  @teste3
  Esquema do Cenario: Verificar operação de POST para pessoas
    Dado que eu deseje fazer um "POST" em "/pessoas"
    E eu tenha o ddd "<ddd>" o numero "<numero>"
    Quando eu realizar o POST
    Então o status code deverá ser "<statusCode>"
    Exemplos:
      |ddd    |numero         |statusCode|
      |11     |996079807      |  201     |
      |11     |996079807      |  400     |