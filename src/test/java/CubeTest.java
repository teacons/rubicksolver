import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CubeTest {

    @Test
    void isSolved() {
        Cube cube = new Cube();
        assertTrue(cube.isSolved());
        for (int i = 1; i <= 20; i++) {
            cube.shuffle(i);
            assertFalse(cube.isSolved());
        }
    }

    @Test
    void sideFull() {
        Cube cube = new Cube();
        for (int i = 0; i < 6; i++) {
            assertTrue(cube.sideFull(i));
        }
        cube.shuffle(20);
        for (int i = 0; i < 6; i++) {
            assertFalse(cube.sideFull(i));
        }
    }

    @Test
    void equalsColor() {
        Cube cube = new Cube();
        int i = 0;
        for (Cube.Color color : Cube.Color.values()) {
            assertTrue(cube.equalsColor(i, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8), color));
            i++;
        }
        cube.turn("D");
        assertTrue(cube.equalsColor(0, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8), Cube.Color.WHITE));
        assertTrue(cube.equalsColor(1, Arrays.asList(0, 1, 3, 4, 6, 7), Cube.Color.ORANGE));
        assertTrue(cube.equalsColor(2, Arrays.asList(1, 2, 4, 5, 7, 8), Cube.Color.RED));
        assertTrue(cube.equalsColor(3, Arrays.asList(3, 4, 5, 6, 7, 8), Cube.Color.GREEN));
        assertTrue(cube.equalsColor(4, Arrays.asList(0, 1, 2, 3, 4, 5), Cube.Color.BLUE));
        assertTrue(cube.equalsColor(5, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8), Cube.Color.YELLOW));
    }

    @Test
    void rightMinCube() {
        Cube cube = new Cube();
        for (int i = 0; i < 4; i++) {
            assertTrue(cube.rightMinCube(i));
        }
        for (int i = 0; i < 9; i++) {
            cube.sides[5].cells[i].color = Cube.Color.WHITE;
        }
        for (int i = 0; i < 4; i++) {
            assertFalse(cube.rightMinCube(i));
        }
    }

    @Test
    void find() {
        Cube cube = new Cube();
        Set<Integer> expected = new HashSet<>();
        int j = 0;
        for (int i = 0; i < 9; i++) expected.add(i);
        for (Cube.Color color : Cube.Color.values()) {
            assertEquals(expected, cube.find(color, j));
            j++;
        }
    }

    @Test
    void shuffle() {
        Cube cube = new Cube();
        for (int i = 1; i < 100; i++) {
            assertEquals(i, cube.shuffle(i).split(" ").length);
        }
    }

    @Test
    void turn() {
        Cube cube = new Cube();
        cube.turn("U U' R R' L L' D D' F F' B B'");
        assertTrue(cube.isSolved());
    }
}