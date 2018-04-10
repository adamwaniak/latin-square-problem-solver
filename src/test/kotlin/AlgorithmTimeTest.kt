import app.BackTracking
import app.Board
import app.ForwardChecking
import org.junit.Assert
import org.junit.Test

class AlgorithmTimeTest {
    @Test
    fun allPossibleSolutionBackTracking() {
        val board = Board(4)
        val algorithm = BackTracking(board)
        val solutions = algorithm.fillBoard(true)
        println("Number of possible solutions: ${solutions.size}")
//        solutions.forEach { println(it.printBoard()) }
//        Assert.assertTrue(solutions.size == 12)
    }

    @Test
    fun allPossibleSolutionForwardChecking() {
        val board = Board(4)
        val algorithm = ForwardChecking(board)
        val solutions = algorithm.fillBoard(true)
        println("Number of possible solutions: ${solutions.size}")
//        solutions.forEach { println(it.printBoard()) }
//        Assert.assertTrue(solutions.size == 12)
    }
}