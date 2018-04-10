package app

class ForwardChecking(private val board: Board) : Algorithm(board) {

    private val allPossibleSolutions = mutableSetOf<Board>()

    override fun fillBoard(allSolutions: Boolean): MutableSet<Board> {
        allPossibleSolutions.clear()
        val availableValues: MutableList<Int> = generateValues() as MutableList<Int>
        fillBoardHelper(availableValues, allSolutions)
        return allPossibleSolutions
    }

    private fun fillBoardHelper(availableValues: MutableList<Int>, isAllSolutions: Boolean): Boolean {
        if (availableValues.isEmpty())
            return if (isAllSolutions) {
                allPossibleSolutions.add(board.getCopy())
                false
            } else {
                true
            }
        for (value in availableValues) {
            val availableFields = getAvailableFieldsForValue(value)
            if (availableFields.isEmpty()) return false
            else for (field in availableFields) {
                field.value = value
                availableValues.remove(value)
                if (fillBoardHelper(availableValues, isAllSolutions)) return true
                else {
                    availableValues.add(value)
                    field.value = null
                }
            }
            return false
        }
        return false
    }

    internal fun getAvailableFieldsForValue(value: Int): Set<Field> {
        val availableFields = mutableSetOf<Field>()
        board.fields.forEach { if (isFieldAvailableForValue(it, value)) availableFields.add(it) }
        return availableFields
    }



}