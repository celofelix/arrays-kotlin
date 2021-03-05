package br.com.alura.arrays

fun testaFuncoesAgregadoras() {
    // Função maxOrNull() de um Array serve para pegar o maior valor de um Array
    val idades: IntArray = intArrayOf(18, 17, 27, 21, 37, 45)
    val maiorIdade = idades.maxOrNull()
    println("Maior Idade: $maiorIdade")

    // Função minOrNull() de um array serve para pegar o menor valor de um Array
    val menorIdade = idades.minOrNull()
    println("Menor Idade: $menorIdade")

    // Função avarege() de um Array para verificar a média dos valores de um Array
    val mediaIdade = idades.average()
    println("Média de idades: $mediaIdade")

    /*
    Função all{} de um Array pode ser usada com uma expressão, ou seja, ela retorna um Boolean
    Assim é possível verificar algumas condições dentro dos valores do Array
    Para retornar true todos os valores do Array deve satisfazer a condição
     */
    val todosMaiores: Boolean = idades.all { idade -> idade >= 18 }
    println("Todos são maiores de idade? $todosMaiores")

    /*
    A função any{} de um Array também retorna um Boolean, true ou false
    Mas nesse caso se pelo menos 1 dos valores satisfazer a condição, ela já retorna true
    Diferente da função all{} que precisa que todos os valores satisfação a condição
     */
    val existeMaior: Boolean = idades.any { idade -> idade >= 18 }
    println("Existe algum aluno maior de idade? $existeMaior")

    /*
    A função filter{} ela recebe uma expressão e retorna uma Lista\List
    O retorno da Lista\List será com os valores que satisfazerem a condição passada no filter
     */
    val maiores = idades.filter { idade -> idade >= 18 }
    println("Lista somente com os Alunos maiores de idade $maiores")

    /*
    A função find{} ela recece uma expressão e retorna apenas 1 valor e não um Array ou Lista
    A função find{} ela retorna o primeiro valor que encontrar dentro do Array
     */

    val buscaMaior = idades.find { idade -> idade >= 18 }
    println("Resultado da busca $buscaMaior")
}
