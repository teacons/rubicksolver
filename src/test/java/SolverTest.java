import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    @Test
    void solve() {
        Cube cube = new Cube();
        Cube cube2 = new Cube();
        Solver solver;
        cube.shuffle(20);
        solver = new Solver(cube);
        for (String i : cube.scramble.split(" ")) {
            cube2.turn(i);
        }
        String temp = solver.solve();
        for (String i : temp.split(" ")) {
            cube2.turn(i);
        }
        System.out.println(cube.scramble);
        System.out.println(temp);
        assertTrue(cube2.isSolved());
    }
}