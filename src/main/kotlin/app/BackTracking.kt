package app

class BackTracking(private val board: Board) : Algorithm(board) {
    private val allPossibleSolutions = mutableSetOf<Board>()
    override fun fillBoard(allSolutions: Boolean): MutableSet<Board> {
        allPossibleSolutions.clear()
        val availableValues: MutableList<Int> = generateValues() as MutableList<Int>
        fillBoardHelper(availableValues, allSolutions)
        return allPossibleSolutions
    }

    private fun fillBoardHelper(availableValues: MutableList<Int>, isAllSolutions: Boolean): Boolean {
        if (availableValues.isEmpty()) return if (isAllSolutions) {
            allPossibleSolutions.add(board.getCopy())
            false
        } else {
            true
        }
        for (value in availableValues) {
            for (field in board.fields) {
                if (isFieldAvailableForValue(field, value)) {
                    availableValues.remove(value)
                    field.value = value
                    if (fillBoardHelper(availableValues, isAllSolutions)) {
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