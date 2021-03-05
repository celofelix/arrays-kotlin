package br.com.alura.lista

data class Prateleira(
    val genero: String,
    val livros: List<Livro>
) {

    fun organizaPorAutor() : List<Livro> {
        return livros.sortedBy { it.autor }
    }

    fun organizaPorAnoPublicacao() : List<Livro> {
        return livros.sortedBy { it.anoPublicacao }
    }

}