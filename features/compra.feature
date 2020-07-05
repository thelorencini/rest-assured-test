# language: pt
# charset: UTF-8

Funcionalidade: Fluxo de compra de produto
  Eu como usuário gostaria de poder buscar um produto e validar seu preço.

  @COMPRACT001
  Esquema do Cenario: Cenario: CT001 - Buscar e adicionar produtos na cesta validando o parcelamento.
    Dado que eu busco pelo produto "<produto>"
    E seleciono o primeiro retorno
    Quando eu clicar em comprar
    E incluir mais um produto na cesta
    Entao devo visualizar a opção de parcelamento em "<parcelamento>"
    E que o valor total de produtos é inferior a "<valor>"
    Exemplos:
      | produto  | parcelamento | valor |
      | iphone 7 | 10x          | 5000  |