class Algorithm(val board: Array2D<Int?>) {

    fun isBoardCorrect(): Boolean {
        val size = board.xSize
        for (i in 0 until size) {
            for (j in 0 until size) {
                val value = board[i, j]
                if (value!! > size) {
                    throw IllegalArgumentException()
                }
                for (k in 0 until size) {
                    if (((k != j) and (value == board[i, k])) or ((k != i) and (value == board[k, j]))) {
                        return false
                    }
                }
            }
        }
        return true
    }

}