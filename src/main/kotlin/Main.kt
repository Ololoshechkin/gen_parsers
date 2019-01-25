import generator.Generator

fun main(args: Array<String>) {
    Generator("grammar.txt").generate("Output.kt")
}