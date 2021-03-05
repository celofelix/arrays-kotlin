package br.com.alura.lista

fun List<Livro?>.imprimeFormatado() {
    val livrosFormatados = this
        .filterNotNull()
        .joinToString(separator = "\n") { livro ->
        " - ${livro.titulo} do Autor(a) ${livro.autor}"
    }
    println(" #####Lista de Livros##### \n$livrosFormatados")
}