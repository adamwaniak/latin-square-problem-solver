package app

abstract class Algorithm(private val board: Board) {

    abstract fun fillBoard(allSolutions: Boolean): MutableSet<Board>

    internal fun isBoardCorrect(): Boolean {
        for (field in board.fields) {
            if (field.value == null) return false
        }
        return isBoardCorrectWithNulls()
    }

    internal fun isFieldAvailableForValue(field: Field, value: Int): Boolean {
        if (field.value != null) {
            return false
        }
        val row = board.getRow(field.row)
        val column = board.getColumn(field.column)

        for (rowField in row) {
            if (rowField.value == value) {
                return false
            }
        }
        for (columnField in column) {
            if (columnField.value == value) {
                return false
            }
        }
        return true
    }

    internal fun generateValues(): Iterable<Int> {
        val size = board.size
        val values = mutableListOf<Int>()
        for (i in 1..size) {
            for (j in 1..size) {
                values.add(i)
            }
        }
        return values
    }

    private fun isBoardCorrectWithNulls(): Boolean {
        for (field1 in board.fields) {
            for (field2 in board.fields) {
                if ((field1.value != null) and (field2.value != null) and (field1 != field2)) {
                    if ((field1.row == field2.row) or (field1.column == field2.column)) {
                        if (field1.value == field2.value) return false
                    }
                }
            }
        }
        return true
    }

}