import generator.Generator

fun main(args: Array<String>) {
//    Generator("grammar.txt").generate("Output.kt")
    Parser("input.txt").parse()
}