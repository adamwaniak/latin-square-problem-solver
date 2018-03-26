import app.Algorithm
import app.BackTracking
import app.Board
import app.ForwardChecking
import org.junit.Assert
import org.junit.Test

class AlgorithmTest{

    @Test
    fun testIsBoardCorrect(){
        val board = Board(3)
        board.get(0, 0).value = 1
        board.get(0, 1).value = 2
        board.get(0, 2).value = 3
        board.get(1, 0).value = 2
        board.get(1, 1).value = 3
        board.get(1, 2).value = 1
        board.get(2, 0).value = 3
        board.get(2, 1).value = 1
        board.get(2, 2).value = 2

        val algorithm = Algorithm(board)
        Assert.assertTrue(algorithm.isBoardCorrect())
    }

    @Test
    fun testIsBoardCorrect1(){
        val board = Board(3)
        board.get(0, 0).value = 1
        board.get(0, 1).value = 1
        board.get(0, 2).value = 3
        board.get(1, 0).value = 2
        board.get(1, 1).value = 3
        board.get(1, 2).value = 1
        board.get(2, 0).value = 3
        board.get(2, 1).value = 2
        board.get(2, 2).value = 2

        val algorithm = Algorithm(board)
        Assert.assertTrue(!algorithm.isBoardCorrect())

    }

    @Test
    fun testIsFieldAvailableForValue() {
        val board = Board(3)
        board.get(0, 0).value = 1
        board.get(0, 1).value = 2
        board.get(0, 2).value = 3
        board.get(1, 0).value = 2
        board.get(1, 1).value = 3
        board.get(1, 2).value = null
        board.get(2, 0).value = 3
        board.get(2, 1).value = 1
        board.get(2, 2).value = 2

        val algorithm = ForwardChecking(board)
        Assert.assertTrue(algorithm.isFieldAvailableForValue(board.get(1, 2), 1))
        Assert.assertFalse(algorithm.isFieldAvailableForValue(board.get(1, 2), 3))
    }

    @Test
    fun testGenerateValues() {
        val board = Board(3)
        val values = listOf(1, 1, 1, 2, 2, 2, 3, 3, 3)
        val algorithm = Algorithm(board)
        Assert.assertTrue(values == algorithm.generateValues())
    }

    @Test
    fun testGetAvailableFieldsForValue() {
        val board = Board(3)
        board.get(0, 0).value = 1
        board.get(0, 1).value = 2
        board.get(0, 2).value = 3
        board.get(1, 0).value = null //2
        board.get(1, 1).value = null //3
        board.get(1, 2).value = null
        board.get(2, 0).value = null //3
        board.get(2, 1).value = null
        board.get(2, 2).value = null

        val algorithm = ForwardChecking(board)
        val availableFields = algorithm.getAvailableFieldsForValue(3)
        println(availableFields.toString())
        Assert.assertTrue(availableFields == setOf(board.get(1, 0), board.get(1, 1), board.get(2, 0), board.get(2, 1)))

    }

    @Test
    fun testForwardCheckingFillSquare() {
        val board = Board(3)
        val algorithm = ForwardChecking(board)
        algorithm.fillBoard()
        print(board.printBoard())
        Assert.assertTrue(algorithm.isBoardCorrect())
    }

    @Test
    fun testBackTrackingFillBoard() {
        val board = Board(3)
        val algorithm = BackTracking(board)
        algorithm.fillBoard()
        print(board.printBoard())
        Assert.assertTrue(algorithm.isBoardCorrect())
    }
}