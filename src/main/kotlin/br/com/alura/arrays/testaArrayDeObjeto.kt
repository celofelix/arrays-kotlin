package br.com.alura.arrays

import java.math.BigDecimal
import java.math.RoundingMode

fun testaArrayDeObjeto() {
    val salarios = bigDecimalArrayOf("1500.50", "2000.00", "5000.00", "10000.00")
    val aumento = "1.1".toBigDecimal()

    println("Array de salários sem Aumento ${salarios.contentToString()}")

    /*
    Função map{} irá retornar uma nova Lista\List de acordo com o resultado do que foi passado
    Dessa forma é possível guardar em uma nova variavel e mantemos o Array anterior
    E assim possuimos 2 Arrays em mãos
    Nesse caso como estamos trabalhando com Array de BigDecial
    Então ao final com o método toTypedArray() foi convertido para um Array
     */
    val salariosComAumento: Array<BigDecimal> = salarios
        .map { salario ->
            calculaAumento(salario, aumento)
        }.toTypedArray()

    println("Array de salários com aumento: ${salariosComAumento.contentToString()}")

    val gastoInicial = salariosComAumento.somatoria()
    println("Gasto inicial após aumento dos salários $gastoInicial")

    val meses = "6".toBigDecimal()

    /*
    A função fold() tem o resultado bem parecido com a função reduce{}
    A diferença entre elas é que no fold podemos passar um valor inicial para o acumulador
    Nesse exemplo o acumulador já inicia com o valor da variavel gastoInicial
    O retorno do fold() também é apenas de 1 valor, nesse caso 1 tipo BigDecial
     */
    val gastoPorMes = salariosComAumento.fold(gastoInicial) { acumulador, valorSalario ->
        acumulador + (valorSalario * meses).setScale(2, RoundingMode.UP)
    }
    println("Gasto total após 6 meses: $gastoPorMes")
}

fun calculaAumento(salario: BigDecimal, aumento: BigDecimal) =
    if (salario < "5000".toBigDecimal()) {
        salario + "500".toBigDecimal()
    } else {
        (salario * aumento).setScale(2, RoundingMode.UP)
    }

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

