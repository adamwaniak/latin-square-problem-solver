import org.junit.Assert
import org.junit.Test

class AlgorithmTest{

    @Test
    fun testIsBoardCorrect(){
        val board = Array2D<Int>(3,3)
        board[0,0] = 1
        board[0,1] = 2
        board[0,2] = 3
        board[1,0] = 2
        board[1,1] = 3
        board[1,2] = 1
        board[2,0] = 3
        board[2,1] = 1
        board[2,2] = 2

        val algorithm = Algorithm(board)
        Assert.assertTrue(algorithm.isBoardCorrect())
    }

    @Test
    fun testIsBoardCorrect1(){
        val board = Array2D<Int>(3,3)
        board[0,0] = 1
        board[0,1] = 1
        board[0,2] = 3
        board[1,0] = 2
        board[1,1] = 3
        board[1,2] = 1
        board[2,0] = 3
        board[2,1] = 2
        board[2,2] = 2

        val algorithm = Algorithm(board)
        Assert.assertTrue(!algorithm.isBoardCorrect())

    }
}