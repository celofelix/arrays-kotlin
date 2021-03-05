package br.com.alura.arrays

fun testaIntArray() {

    val idades: IntArray = IntArray(5)
    idades[0] = 25
    idades[1] = 19
    idades[2] = 33
    idades[3] = 20
    idades[4] = 55

    var idadeMaior = 0
    for (idade in idades) {
        if (idade > idadeMaior)
            idadeMaior = idade
    }
    println("Maior idade com IntArray e For: $idadeMaior") 

    var idadeMenor = Int.MAX_VALUE
    idades.forEach { idade ->
        if (idade < idadeMenor) {
            idadeMenor = idade
        }
    }
    println("Menor idade com IntArray e Forach: $idadeMenor")

    val idades2: IntArray = intArrayOf(30, 72, 27, 33, 55)
    var maiorIdade = 0
    idades2.forEach { idade ->
        if (idade > maiorIdade) {
            maiorIdade = idade
        }
    }
    println("Maior idade com intArrayOf e ForEach: $maiorIdade")
}