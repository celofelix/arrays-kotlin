package br.com.alura.arrays

fun testaRanges() {
    /*
    Função rangeTo cria um array com os valores de acordo com o determinado
    Nesse caso vai criar um IntRange de 1 até 100
    Retorno dessa função é de um IntRange
    */
    val serie = 1.rangeTo(10)
    for (s in serie) {
        print("$s ")
    }

    println()

    /*
    Operador de .. tem a mesma funcionalidade do rangeTo
    Porém é mais otimizada a forma de escrita/sintaxe
    E usando o step para iterar de 2 em 2
    Retorno dessa função é de um IntProgression
    */
    val numerosPares = 2..100 step 2
    for (pares in numerosPares) {
        print("$pares ")
    }

    println()

    /*
    Função until não inclui o número informado
    Nesse caso o 50 não será incluso
    E usando o step para iterar de 2 em 2
    Retorno dessa função é de um IntProgression
    */
    val paresAte = 2.until(50) step 2
    for (pares in paresAte) {
        print("$pares ")
    }

    println()

    /*
     downTo tem a adicionar valores de forma decremental
     E em conjunto com o step irá decrementar de 2 em 2
     Retorno dessa função é de um IntProgression
     */
    val paresDecrementando = 100 downTo 0 step 2
    paresDecrementando.forEach { pares -> print("$pares ") }

    println()

    /*
     Verificando se um valor está dentro do range com o operador in
     O operador in dentro de uma estrura if funciona diferente de uma estrutura for
     Nesse caso o operador in ele vai servir para verificar se o valor do salario está dentro do range
     */
    val intervalorSalarios = 1500.0..5000.0
    val salario = 4000.0
    if (salario in intervalorSalarios) {
        println("Está dentro do intervalo dos salários")
    } else {
        println("Não está dentro do intervalo de salários")
    }

    // Também é possível criar range de strings
    // E podemos usar o in para comparar valores string também
    val alfabeto = "a".."z"
    val letra = "m"
    println(letra in alfabeto)
}