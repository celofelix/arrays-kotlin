package br.com.alura.lista

fun testaList() {
    val livro1 = Livro(
        titulo = "Grande Sertão: Veredas",
        autor = "João Guimarães Rosa",
        anoPublicacao = 1956
    )

    val livro2 = Livro(
        titulo = "Minha vida de menina",
        autor = "Helena Morley",
        anoPublicacao = 1942,
        editora = "Editora A"
    )

    val livro3 = Livro(
        titulo = "Memórias Póstumas de Brás Cubas",
        autor = "Machado de Assis",
        anoPublicacao = 1881
    )

    val livro4 = Livro(
        titulo = "Iracema",
        autor = "José de Alencar",
        anoPublicacao = 1865,
        editora = "Editora B"
    )

    val livros: MutableList<Livro> = mutableListOf(livro1, livro2, livro3, livro4)

    livros.add(
        Livro(
            titulo = "Senhor dos Anéis",
            autor = "Tolkien",
            anoPublicacao = 1954
        )
    )

    livros.add(
        Livro(
            titulo = "Hobbit",
            autor = "Tolkien",
            anoPublicacao = 1970
        )
    )

    livros.add(
        Livro(
            titulo = "O Retorno do Rei",
            autor = "Tolkien",
            anoPublicacao = 1960
        )
    )

    livros.imprimeFormatado()

    livros.remove(livro2)

    livros.imprimeFormatado()
    val livrosOrdenadosPorAnoPublicacao = livros.sorted()
    livrosOrdenadosPorAnoPublicacao.imprimeFormatado()

    livros.sortedBy { livro -> livro.autor }.imprimeFormatado()

    /*
    Função filter{} recebe uma expressão boolean
    Retorna uma lista com os valores que satisfazerem a condição
    Nesse exemplo será uma lista com os livros do autor Tolkien
     */
    livros.filter { it.autor == "Tolkien" }
        .sortedBy { it.anoPublicacao }
        .imprimeFormatado()

    /*
    Usando filter{} para filtrar o autor
    Em seguida foi usado o sortedBy{} para ordenar por ano de publicação
    E por último foi usado o map{} para criar uma nova lista com apenas o titulo dos livros
    Os titulos serão apenas do autor informado no filter e já estarão ordenados por ano de publicação
     */
    val titulos: List<String> = livros.filter { it.autor == "Tolkien" }
        .sortedBy { it.anoPublicacao }
        .map { it.titulo }

    println(titulos)

}


