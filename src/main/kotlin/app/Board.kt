package app

import java.lang.StringBuilder

 class Board(val size: Int) {
    val fields: MutableList<Field> = mutableListOf()

    init {
        for (i in 0 until size) {
            for (j in 0 until size) {
                fields.add(Field(i, j))
            }
        }
    }

     fun getCopy(): Board {
         val copyBoard = Board(size)
         for (i in 0 until size) {
             for (j in 0 until size) {
                 copyBoard.get(i, j).value = get(i, j).value
             }
         }
         return copyBoard
     }

    fun get(row: Int, column: Int): Field {
        for (field in fields) {
            if ((field.row == row) and (field.column == column)) {
                return field
            }
        }
        throw IndexOutOfBoundsException()
    }


    fun getRow(row: Int): List<Field> {
        val rowsField: MutableList<Field> = mutableListOf()
        for (field in fields) {
            if (field.row == row)
                rowsField.add(field)
        }
        return rowsField
    }

    fun getColumn(column: Int): List<Field> {
        val columnsField: MutableList<Field> = mutableListOf()
        for (field in fields) {
            if (field.column == column)
                columnsField.add(field)
        }
        return columnsField
    }


    fun printBoard() {
        val stringBuilder = StringBuilder()
        stringBuilder.append("Board(size=$size,")
        for (i in 0 until size) {
            stringBuilder.append("\n")
            for (j in 0 until size) {
                stringBuilder.append(get(i, j).toPrintBoard())
            }
        }
        stringBuilder.append("\n)")
        return println(stringBuilder.toString())
    }

    override fun toString(): String {
        return "Board(size=$size, fields=$fields)"
    }

     override fun equals(other: Any?): Boolean {
         if (this === other) return true
         if (javaClass != other?.javaClass) return false

         other as Board

         if (size != other.size) return false
         if (fields != other.fields) return false

         return true
     }

     override fun hashCode(): Int {
         var result = size
         result = 31 * result + fields.hashCode()
         return result
     }

}