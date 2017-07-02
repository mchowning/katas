class NinetyNineBottles {

    fun song() = getVerses(99, 0)

    fun getVerses(start: Int, end: Int): String {
        val blankLine = "\n\n"
        return (start downTo end).joinToString(separator = blankLine) { getVerse(it) }
    }

    fun getVerse(num: Int) =
        when(num) {
            in 3..99  ->
                 """|$num bottles of beer on the wall, $num bottles of beer.
                    |Take one down and pass it around, ${num-1} bottles of beer on the wall.""".trimMargin()
            2 -> """|2 bottles of beer on the wall, 2 bottles of beer.
                    |Take one down and pass it around, 1 bottle of beer on the wall.""".trimMargin()
            1 -> """|1 bottle of beer on the wall, 1 bottle of beer.
                    |Take it down and pass it around, no more bottles of beer on the wall.""".trimMargin()
            0 -> """|No more bottles of beer on the wall, no more bottles of beer.
                    |Go to the store and buy some more, 99 bottles of beer on the wall.""".trimMargin()
            else -> throw IllegalArgumentException("Must pass number between 0 and 99 inclusive.")
        }
}