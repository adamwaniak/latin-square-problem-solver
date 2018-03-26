package app

class Field(val row: Int, val column: Int, var value: Int? = null) {

    fun toPrintBoard(): String {
        return if (value == null) "[ ]"
        else "[$value]"
    }

    override fun toString(): String {
        return "Field(row=$row, column=$column, value=$value)"
    }
}