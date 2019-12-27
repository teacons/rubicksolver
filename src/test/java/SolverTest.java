import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    @Test
    void solve() {
        Cube cube = new Cube();
        cube.shuffle(20);
        Solver solver = new Solver(cube);
        solver.solve();
        assertTrue(cube.isSolved());
    }
}