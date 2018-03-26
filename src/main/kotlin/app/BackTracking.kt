package app

class BackTracking(private val board: Board) : Algorithm(board) {

    fun fillBoard() {
        val availableValues: MutableList<Int> = generateValues() as MutableList<Int>
        fillBoardHelper(availableValues)
    }

    private fun fillBoardHelper(availableValues: MutableList<Int>): Boolean {
        if (availableValues.isEmpty()) return true
        for (value in availableValues) {
            for (field in board.fields) {
                if (isFieldAvailableForValue(field, value)) {
                    availableValues.remove(value)
                    field.value = value
                    if (fillBoardHelper(availableValues)) {
                        return true
                    } else {
                        availableValues.add(value)
                        field.value = null
                    }
                }
            }
            return false
        }
        return false
    }

}