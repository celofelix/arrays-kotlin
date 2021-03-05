package br.com.alura

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

    /*
    Função sorted() ordena um array do menor para o maior
    Função takeLast() pega os 3 últimos elementos de um array
     */
    val tresMaioresSalarios = salariosComAumento.sorted().takeLast(3).toTypedArray()
    val mediaTresMaioresSalarios = tresMaioresSalarios.media()
    println("Media dos 3 maiores sálarios: $mediaTresMaioresSalarios")

    val tresMenoresSalarios = salariosComAumento.sorted().take(3).toTypedArray()
    val mediaTresMenoresSalarios = tresMenoresSalarios.media()
    println("Media dos 3 menores sálarios: $mediaTresMenoresSalarios")
}

fun calculaAumento(salario: BigDecimal, aumento: BigDecimal) =
    if (salario < "5000".toBigDecimal()) {
        salario + "500".toBigDecimal()
    } else {
        (salario * aumento).setScale(2, RoundingMode.UP)
    }

