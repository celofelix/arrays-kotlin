package br.com.alura

import java.math.BigDecimal

/*
O Kotlin não possui um tipo primitivo BigDecimal, o BigDecimal é uma classe/objeto
Por não possuir o tipo primitivo BigDecimal não temos arrays primitivas de BigDecimal
E assim não teremos acessos aos métodos base dos arrays.
Então é necessários usar uma classe Array e dentro do operador diamond <> especificar o tipo
Essa função serve para criar um Array de tipo BigDecimal com tamanho dinâmico a partir do vararg
O vararg é um parâmetro que permite passar 1 ou mais valores como parâmetro
Então dessa forma o Array de BigDecimal poderá aumentar de tamanho de acordo com os valores passados
Dessa forma ele cria um array e podemos acessa-lo para criar o Array de BigDecimal
 */
fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> {
    return Array<BigDecimal>(valores.size) { i -> valores[i].toBigDecimal() }
}

/*
A função reduce{} ela transforma todos os valores de um Array em apenas 1 valor
A forma que o reduz irá transformar irá ser de acordo com a implementação
Nesse exemplo foi feito uma somatoria de todos os valores de um Array
Então o retorno será apenas 1 de tipo BigDecial valor com total da soma
 */
fun Array<BigDecimal>.somatoria(): BigDecimal {
    return this.reduce { acumulador, valorSalario ->
        acumulador + valorSalario
    }
}

fun Array<BigDecimal>.media(): BigDecimal {
    return if (this.isEmpty()) {
        return BigDecimal.ZERO
    } else {
        this.somatoria() / this.size.toBigDecimal()
    }
}
