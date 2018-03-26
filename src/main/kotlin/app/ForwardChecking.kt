package app

class ForwardChecking(private val board: Board) : Algorithm(board) {

    fun fillBoard() {
        val availableValues: MutableList<Int> = generateValues() as MutableList<Int>
        fillBoardHelper(availableValues)
    }

    private fun fillBoardHelper(availableValues: MutableList<Int>): Boolean {
        if (availableValues.isEmpty()) return true
        for (value in availableValues) {
            val availableFields = getAvailableFieldsForValue(value)
            if (availableFields.isEmpty()) return false
            else for (field in availableFields) {
                field.value = value
                availableValues.remove(value)
                if (fillBoardHelper(availableValues)) return true
                else {
                    availableValues.add(value)
                    field.value = null
                }
            }
        }
        return false
    }

    internal fun getAvailableFieldsForValue(value: Int): Set<Field> {
        val availableFields = mutableSetOf<Field>()
        board.fields.forEach { if (isFieldAvailableForValue(it, value)) availableFields.add(it) }
        return availableFields
    }



}