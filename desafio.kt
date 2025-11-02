// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val matricula: Int)

data class ConteudoEducacional(val nome: String, var duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        if (usuario in inscritos) {
            println("${usuario.nome} já está matriculado(a) na formação $nome!")
            return
        }
        inscritos.add(usuario)
        println("${usuario.nome} foi matriculado(a) com sucesso na formação $nome!")
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    val kotlinBasico = ConteudoEducacional("Learning Kotlin", 90, Nivel.BASICO)
    val kotlinIntermediario = ConteudoEducacional("POO with Kotlin", nivel = Nivel.INTERMEDIARIO)
    val kotlinAvancado = ConteudoEducacional("Projects and Corrence",150, Nivel.AVANCADO)

    val kotlinFormacao = Formacao("Kotlin Dev", listOf(kotlinBasico, kotlinIntermediario, kotlinAvancado))

    val usuario1 = Usuario("Alex", 1)
    val usuario2 = Usuario("May", 2)

    kotlinFormacao.matricular(usuario1)
    kotlinFormacao.matricular(usuario2)
    kotlinFormacao.matricular(usuario2)

    println("--- Info ---")
    println("Nome: ${kotlinFormacao.nome}")
    println("Conteúdos:")
    kotlinFormacao.conteudos.forEach {
        println(" - ${it.nome} - ${it.nivel} - ${it.duracao}(min)")
    }

    kotlinFormacao.inscritos.forEach {
        println(" - ${it.nome} - Matrícula: ${it.matricula}")
    }

}