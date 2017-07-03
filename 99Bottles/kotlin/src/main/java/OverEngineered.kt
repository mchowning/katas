class OverEngineered : NinetyNineBottles {

    override fun song() = getVerses(99, 0)

    override fun getVerses(start: Int, end: Int): String {
        val blankLine = "\n\n"
        return (start downTo end).joinToString(separator = blankLine) { getVerse(it) }
    }

    override fun getVerse(num: Int): String {

        fun bottlesOfBeer(n: Int) = when(n) {
            in 2..99  -> "$n bottles of beer"
            1 -> "1 bottle of beer"
            0 -> "no more bottles of beer"
            else -> throw IllegalArgumentException("Must pass number between 0 and 99 inclusive.")
        }

        val firstLine = "${bottlesOfBeer(num).capitalize()} on the wall, ${bottlesOfBeer(num)}."

        val secondLine = when (num) {
            in 1..99 -> "Take ${if (num == 1) "it" else "one"} down and pass it around, ${bottlesOfBeer(num - 1)} on the wall."
            0        -> "Go to the store and buy some more, ${bottlesOfBeer(99)} on the wall."
            else     -> throw IllegalArgumentException("Must pass number between 0 and 99 inclusive.")
        }

        return firstLine + "\n" + secondLine
    }
}