// Kotlin data classes initialize fields before you enter init
package watchout3

data class Stars(val n: Int) {
    init {
        println(n)
        println(this.n)
    }
}

fun main() {
    val s = Stars(42)
}
/*
42
42
 */
