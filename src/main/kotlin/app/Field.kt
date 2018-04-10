package app

 class Field(val row: Int, val column: Int, var value: Int? = null) {

    fun toPrintBoard(): String {
        return if (value == null) "[ ]"
        else "[$value]"
    }

    override fun toString(): String {
        return "Field(row=$row, column=$column, value=$value)"
    }

     override fun equals(other: Any?): Boolean {
         if (this === other) return true
         if (javaClass != other?.javaClass) return false

         other as Field

         if (row != other.row) return false
         if (column != other.column) return false
         if (value != other.value) return false

         return true
     }

     override fun hashCode(): Int {
         var result = row
         result = 31 * result + column
         result = 31 * result + (value ?: 0)
         return result
     }


 }