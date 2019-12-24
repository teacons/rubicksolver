import java.util.Arrays;
import java.util.Collections;

class Solver {
    private StringBuilder builder = new StringBuilder();
    private Cube cube;

    Solver(Cube cube) {
        this.cube = cube;
    }

    String solve() {
        step1();
        if (cube.isSolved()) return builder.toString();
        step2();
        if (cube.isSolved()) return builder.toString();
        step3();
        if (cube.isSolved()) return builder.toString();
        step4();
        if (cube.isSolved()) return builder.toString();
        step5();
        if (cube.isSolved()) return builder.toString();
        step6();
        if (cube.isSolved()) return builder.toString();
        step7();
        if (cube.isSolved()) return builder.toString();
        step8();
        if (cube.isSolved()) return builder.toString();
        return "ERROR";
    }

    private void step1() {
        while (!(cube.sides[0].cells[1].color.equals("white") && cube.sides[0].cells[5].color.equals("white") &&
                cube.sides[0].cells[7].color.equals("white") && cube.sides[0].cells[3].color.equals("white"))) {
            for (int i = 1; i < 6; i++) {
                switch (i) {
                    case 1:
                        for (Integer k : cube.find("white", i)) {
                            switch (k) {
                                case 1:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("B");
                                        builder.append("B ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("U'");
                                        cube.turn("B");
                                        cube.turn("U");
                                        builder.append("U' B U ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("U");
                                        cube.turn("B");
                                        cube.turn("U'");
                                        cube.turn("U'");
                                        builder.append("U U B U' U' ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("B");
                                        cube.turn("U'");
                                        builder.append("U B U' ");
                                    }
                                    break;
                                case 5:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("R'");
                                        cube.turn("B");
                                        cube.turn("R");
                                        builder.append("R' B R ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("R'");
                                        cube.turn("U'");
                                        cube.turn("B");
                                        cube.turn("U");
                                        builder.append("R' U' B U ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("R");
                                        cube.turn("F'");
                                        cube.turn("R'");
                                        builder.append("R F' R' ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("U'");
                                        cube.turn("R");
                                        cube.turn("F'");
                                        cube.turn("R'");
                                        cube.turn("U");
                                        builder.append("U' R F' R' U ");
                                    }
                                    break;
                                case 7:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("U");
                                        cube.turn("B");
                                        cube.turn("U'");
                                        cube.turn("U'");
                                        builder.append("U U B U' U' ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("F'");
                                        cube.turn("U'");
                                        builder.append("U F' U' ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("F'");
                                        builder.append("F' ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("U'");
                                        cube.turn("F'");
                                        cube.turn("U");
                                        builder.append("U' F' U ");
                                    }
                                    break;
                                case 3:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("R");
                                        cube.turn("B");
                                        builder.append("R B ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("R");
                                        cube.turn("U'");
                                        cube.turn("B");
                                        cube.turn("U");
                                        builder.append("R U' B U ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("R'");
                                        cube.turn("F'");
                                        builder.append("R' F' ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("R'");
                                        cube.turn("U'");
                                        cube.turn("F'");
                                        cube.turn("U");
                                        builder.append("R' U' F' U ");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 2:
                        for (Integer k : cube.find("white", i)) {
                            switch (k) {
                                case 1:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("B'");
                                        builder.append("B' ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("U'");
                                        cube.turn("B'");
                                        cube.turn("U");
                                        builder.append("U' B' U ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("U");
                                        cube.turn("B'");
                                        cube.turn("U'");
                                        cube.turn("U'");
                                        builder.append("U U B' U' U' ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("B'");
                                        cube.turn("U'");
                                        builder.append("U B' U' ");
                                    }
                                    break;
                                case 5:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("L'");
                                        cube.turn("B'");
                                        builder.append("L' B' ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("L'");
                                        cube.turn("U'");
                                        cube.turn("B'");
                                        cube.turn("U");
                                        builder.append("L' U' B' U ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("L");
                                        cube.turn("F");
                                        builder.append("L F ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("L'");
                                        cube.turn("U");
                                        cube.turn("B'");
                                        cube.turn("U'");
                                        builder.append("L' U B' U' ");
                                    }
                                    break;
                                case 7:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("U");
                                        cube.turn("F");
                                        cube.turn("U");
                                        cube.turn("U");
                                        builder.append("U U F U U ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("F");
                                        cube.turn("U'");
                                        builder.append("U F U' ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("F");
                                        builder.append("F ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("U'");
                                        cube.turn("F");
                                        cube.turn("U");
                                        builder.append("U' F U ");
                                    }
                                    break;
                                case 3:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("L");
                                        cube.turn("B'");
                                        cube.turn("L'");
                                        builder.append("L B' L' ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("U'");
                                        cube.turn("L");
                                        cube.turn("B'");
                                        cube.turn("L'");
                                        cube.turn("U");
                                        builder.append("U' L B' L' U ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("L'");
                                        cube.turn("F");
                                        cube.turn("L");
                                        builder.append("L' F L ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("L");
                                        cube.turn("B'");
                                        cube.turn("L'");
                                        cube.turn("U'");
                                        builder.append("U L B' L' U' ");
                                    }
                                    break;

                            }
                        }
                        break;
                    case 3:
                        for (Integer k : cube.find("white", i)) {
                            switch (k) {
                                case 1:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("U'");
                                        cube.turn("B'");
                                        cube.turn("L'");
                                        cube.turn("B");
                                        cube.turn("U");
                                        builder.append("U' B' L' B U ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("B");
                                        cube.turn("R'");
                                        cube.turn("B'");
                                        builder.append("B R' B' ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("U'");
                                        cube.turn("B");
                                        cube.turn("R'");
                                        cube.turn("B'");
                                        cube.turn("U");
                                        builder.append("U' B R' B' U ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("B'");
                                        cube.turn("L");
                                        cube.turn("B");
                                        builder.append("B' L B ");
                                    }
                                    break;
                                case 5:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("R'");
                                        cube.turn("U'");
                                        builder.append("U R' U' ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("R'");
                                        builder.append("R' ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("U'");
                                        cube.turn("R'");
                                        cube.turn("U");
                                        builder.append("U' R' U ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("U");
                                        cube.turn("R'");
                                        cube.turn("U");
                                        cube.turn("U");
                                        builder.append("U U R' U U ");
                                    }
                                    break;
                                case 7:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("B'");
                                        cube.turn("U");
                                        cube.turn("R'");
                                        cube.turn("U'");
                                        builder.append("B' U R' U' ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("B'");
                                        cube.turn("R'");
                                        builder.append("B' R' ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("B'");
                                        cube.turn("U'");
                                        cube.turn("R'");
                                        cube.turn("U");
                                        builder.append("B' U' R' U ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("B");
                                        cube.turn("L");
                                        builder.append("B L ");
                                    }
                                    break;
                                case 3:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("U'");
                                        cube.turn("L");
                                        cube.turn("U");
                                        builder.append("U' L U ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("U");
                                        cube.turn("L");
                                        cube.turn("U");
                                        cube.turn("U");
                                        builder.append("U U L U U ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("L");
                                        cube.turn("U'");
                                        builder.append("U L U' ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("L");
                                        builder.append("L ");
                                    }
                                    break;

                            }
                        }
                        break;
                    case 4:
                        for (Integer k : cube.find("white", i)) {
                            switch (k) {
                                case 1:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("F");
                                        cube.turn("U");
                                        cube.turn("R");
                                        cube.turn("U'");
                                        builder.append("F U R U' ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("F");
                                        cube.turn("R");
                                        builder.append("F R ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("F");
                                        cube.turn("U'");
                                        cube.turn("R");
                                        cube.turn("U");
                                        builder.append("F U' R U ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("F'");
                                        cube.turn("L'");
                                        builder.append("F' L' ");
                                    }
                                    break;
                                case 5:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("R");
                                        cube.turn("U'");
                                        builder.append("U R U' ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("R");
                                        builder.append("R ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("U'");
                                        cube.turn("R");
                                        cube.turn("U");
                                        builder.append("U' R U ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("U");
                                        cube.turn("R");
                                        cube.turn("U");
                                        cube.turn("U");
                                        builder.append("U U R U U ");
                                    }
                                    break;
                                case 7:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("F");
                                        cube.turn("U'");
                                        cube.turn("L'");
                                        cube.turn("U");
                                        cube.turn("F'");
                                        builder.append("F U' L' U F' ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("F'");
                                        cube.turn("R");
                                        cube.turn("F");
                                        builder.append("F' R F ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("F'");
                                        cube.turn("U'");
                                        cube.turn("R");
                                        cube.turn("U");
                                        builder.append("F' U' R U ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("F");
                                        cube.turn("L'");
                                        cube.turn("F'");
                                        builder.append("F L' F' ");
                                    }
                                    break;
                                case 3:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("U'");
                                        cube.turn("L'");
                                        cube.turn("U");
                                        builder.append("U' L' U ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("U");
                                        cube.turn("L'");
                                        cube.turn("U");
                                        cube.turn("U");
                                        builder.append("U U L' U U ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("U");
                                        cube.turn("L'");
                                        cube.turn("U'");
                                        builder.append("U L' U' ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("L'");
                                        builder.append("L' ");
                                    }
                                    break;

                            }
                        }
                        break;
                    case 5:
                        for (Integer k : cube.find("white", i)) {
                            switch (k) {
                                case 1:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("B");
                                        cube.turn("B");
                                        builder.append("D D B B ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("D");
                                        cube.turn("R");
                                        cube.turn("R");
                                        builder.append("D R R ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("F");
                                        cube.turn("F");
                                        builder.append("F F ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("D'");
                                        cube.turn("L");
                                        cube.turn("L");
                                        builder.append("D' L L ");
                                    }
                                    break;
                                case 5:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("D");
                                        cube.turn("B");
                                        cube.turn("B");
                                        builder.append("D B B ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("R");
                                        cube.turn("R");
                                        builder.append("R R ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("D'");
                                        cube.turn("F");
                                        cube.turn("F");
                                        builder.append("D' F F ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("L");
                                        builder.append("D D L L ");
                                    }
                                    break;
                                case 7:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("B");
                                        cube.turn("B");
                                        builder.append("B B ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("D'");
                                        cube.turn("R");
                                        cube.turn("R");
                                        builder.append("D' R R ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("F");
                                        cube.turn("F");
                                        builder.append("D D F F ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("L");
                                        builder.append("D L L ");
                                    }
                                    break;
                                case 3:
                                    if (!cube.sides[0].cells[1].color.equals("white")) {
                                        cube.turn("D'");
                                        cube.turn("B");
                                        cube.turn("B");
                                        builder.append("D' B B ");
                                    } else if (!cube.sides[0].cells[5].color.equals("white")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("R");
                                        cube.turn("R");
                                        builder.append("D D R R ");
                                    } else if (!cube.sides[0].cells[7].color.equals("white")) {
                                        cube.turn("D");
                                        cube.turn("F");
                                        cube.turn("F");
                                        builder.append("D F F ");
                                    } else if (!cube.sides[0].cells[3].color.equals("white")) {
                                        cube.turn("L");
                                        cube.turn("L");
                                        builder.append("L L ");
                                    }
                                    break;

                            }
                        }
                        break;

                }
            }
        }
    }

    private void step2() {
        while (!(cube.sides[1].cells[3].color.equals("orange") && cube.sides[1].cells[4].color.equals("orange") &&
                cube.sides[2].cells[5].color.equals("red") && cube.sides[2].cells[4].color.equals("red") &&
                cube.sides[3].cells[7].color.equals("green") && cube.sides[3].cells[4].color.equals("green") &&
                cube.sides[4].cells[1].color.equals("blue") && cube.sides[4].cells[4].color.equals("blue"))) {
            if (cube.sides[4].cells[1].color.equals("blue") && cube.sides[4].cells[4].color.equals("blue")) {
                if (cube.sides[2].cells[5].color.equals("red") && cube.sides[2].cells[4].color.equals("red")) {
                    cube.turn("R");
                    cube.turn("U");
                    cube.turn("R'");
                    cube.turn("U'");
                    cube.turn("R");
                    builder.append("R U R' U' R ");
                    continue;
                }
                if (cube.sides[1].cells[3].color.equals("orange") && cube.sides[1].cells[4].color.equals("orange")) {
                    cube.turn("B");
                    cube.turn("U");
                    cube.turn("B'");
                    cube.turn("U'");
                    cube.turn("B");
                    builder.append("B U B' U' B ");
                    continue;
                }
            }
            if (cube.sides[3].cells[7].color.equals("green") && cube.sides[3].cells[4].color.equals("green")) {
                if (cube.sides[2].cells[5].color.equals("red") && cube.sides[2].cells[4].color.equals("red")) {
                    cube.turn("F");
                    cube.turn("U");
                    cube.turn("F'");
                    cube.turn("U'");
                    cube.turn("F");
                    builder.append("F U F' U' F ");
                    continue;
                }
                if (cube.sides[1].cells[3].color.equals("orange") && cube.sides[1].cells[4].color.equals("orange")) {
                    cube.turn("L");
                    cube.turn("U");
                    cube.turn("L'");
                    cube.turn("U'");
                    cube.turn("L");
                    builder.append("L U L' U' L ");
                    continue;
                }
            }
            if ((cube.sides[4].cells[1].color.equals("blue") && cube.sides[4].cells[4].color.equals("blue") &&
                    cube.sides[3].cells[7].color.equals("green") && cube.sides[3].cells[4].color.equals("green")) ||
                    (cube.sides[1].cells[3].color.equals("orange") && cube.sides[1].cells[4].color.equals("orange") &&
                            cube.sides[2].cells[5].color.equals("red") && cube.sides[2].cells[4].color.equals("red"))) {
                cube.turn("R");
                cube.turn("U");
                cube.turn("R'");
                cube.turn("U'");
                cube.turn("R");
                builder.append("R U R' U' R ");
                continue;
            }
            cube.turn("U");
            builder.append("U ");
        }
    }

    private void step3() {
        while (!(cube.sideFull(0) &&
                cube.equalsColor(1, Arrays.asList(0, 3, 4, 6), "orange") &&
                cube.equalsColor(2, Arrays.asList(2, 4, 5, 8), "red") &&
                cube.equalsColor(3, Arrays.asList(4, 6, 7, 8), "green") &&
                cube.equalsColor(4, Arrays.asList(0, 1, 2, 4), "blue"))) {
            for (int i = 1; i < 6; i++) {
                switch (i) {
                    case 1:
                        for (Integer k : cube.find("white", i)) {
                            switch (k) {
                                case 0:
                                    if (cube.sides[0].cells[2].color.equals("red") &&
                                            cube.sides[3].cells[8].color.equals("green")) {
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        builder.append("B' D B L' D L ");
                                    } else if (cube.sides[0].cells[2].color.equals("green") &&
                                            cube.sides[3].cells[8].color.equals("orange")) {
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        builder.append("B' D B D' B' D B ");
                                    } else if (cube.sides[0].cells[2].color.equals("blue") &&
                                            cube.sides[3].cells[8].color.equals("red")) {
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("F");
                                        builder.append("B' D B F' D D F ");
                                    } else if (cube.sides[0].cells[2].color.equals("orange") &&
                                            cube.sides[3].cells[8].color.equals("blue")) {
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        builder.append("B' D B D D R' D R ");
                                    }
                                    break;
                                case 2:
                                    if (cube.sides[3].cells[2].color.equals("red") &&
                                            cube.sides[5].cells[8].color.equals("green")) {
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        builder.append("L' D L ");
                                    } else if (cube.sides[3].cells[2].color.equals("green") &&
                                            cube.sides[5].cells[8].color.equals("orange")) {
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        builder.append("D' B' D B ");
                                    } else if (cube.sides[3].cells[2].color.equals("blue") &&
                                            cube.sides[5].cells[8].color.equals("red")) {
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("F");
                                        builder.append("F' D D F ");
                                    } else if (cube.sides[3].cells[2].color.equals("orange") &&
                                            cube.sides[5].cells[8].color.equals("blue")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        builder.append("D D R' D R ");
                                    }
                                    break;
                                case 6:
                                    if (cube.sides[4].cells[2].color.equals("red") &&
                                            cube.sides[0].cells[8].color.equals("green")) {
                                        cube.turn("F");
                                        cube.turn("D'");
                                        cube.turn("F'");
                                        cube.turn("B");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("B'");
                                        builder.append("F D' F' B D D B' ");
                                    } else if (cube.sides[4].cells[2].color.equals("green") &&
                                            cube.sides[0].cells[8].color.equals("orange")) {
                                        cube.turn("F");
                                        cube.turn("D'");
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("R'");
                                        builder.append("F D' F' D R D D R ");
                                    } else if (cube.sides[4].cells[2].color.equals("blue") &&
                                            cube.sides[0].cells[8].color.equals("red")) {
                                        cube.turn("F");
                                        cube.turn("D'");
                                        cube.turn("F'");
                                        cube.turn("L");
                                        cube.turn("D");
                                        cube.turn("L'");
                                        builder.append("F D' F' L D L'");
                                    } else if (cube.sides[4].cells[2].color.equals("orange") &&
                                            cube.sides[0].cells[8].color.equals("blue")) {
                                        cube.turn("F");
                                        cube.turn("D'");
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("F");
                                        cube.turn("D'");
                                        cube.turn("F'");
                                        builder.append("F D' F' D F D' F' ");
                                    }
                                    break;
                                case 8:
                                    if (cube.sides[5].cells[2].color.equals("red") &&
                                            cube.sides[4].cells[8].color.equals("green")) {
                                        cube.turn("B");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("B'");
                                        builder.append("B D D B'");
                                    } else if (cube.sides[5].cells[2].color.equals("green") &&
                                            cube.sides[4].cells[8].color.equals("orange")) {
                                        cube.turn("D'");
                                        cube.turn("R");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("R'");
                                        builder.append("D' R D D R' ");
                                    } else if (cube.sides[5].cells[2].color.equals("blue") &&
                                            cube.sides[4].cells[8].color.equals("red")) {
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        builder.append("L D' L'");
                                    } else if (cube.sides[5].cells[2].color.equals("orange") &&
                                            cube.sides[4].cells[8].color.equals("blue")) {
                                        cube.turn("D");
                                        cube.turn("F");
                                        cube.turn("D'");
                                        cube.turn("F'");
                                        builder.append("D F D' F'");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 2:
                        for (Integer k : cube.find("white", i)) {
                            switch (k) {
                                case 0:
                                    if (cube.sides[5].cells[6].color.equals("red") &&
                                            cube.sides[3].cells[0].color.equals("green")) {
                                        cube.turn("D");
                                        cube.turn("B");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        builder.append("D B D' B' ");
                                    } else if (cube.sides[5].cells[6].color.equals("green") &&
                                            cube.sides[3].cells[0].color.equals("orange")) {
                                        cube.turn("R");
                                        cube.turn("D'");
                                        cube.turn("R'");
                                        builder.append("R D' R'");
                                    } else if (cube.sides[5].cells[6].color.equals("blue") &&
                                            cube.sides[3].cells[0].color.equals("red")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("D''");
                                        cube.turn("L'");
                                        builder.append("D D L D' L'");
                                    } else if (cube.sides[5].cells[6].color.equals("orange") &&
                                            cube.sides[3].cells[0].color.equals("blue")) {
                                        cube.turn("F");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("F'");
                                        builder.append("F D D F' ");
                                    }
                                    break;
                                case 2:
                                    if (cube.sides[3].cells[6].color.equals("red") &&
                                            cube.sides[0].cells[0].color.equals("green")) {
                                        cube.turn("B");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        builder.append("B D' B' D B D' B' ");
                                    } else if (cube.sides[3].cells[6].color.equals("green") &&
                                            cube.sides[0].cells[0].color.equals("orange")) {
                                        cube.turn("B");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        cube.turn("R");
                                        cube.turn("D'");
                                        cube.turn("R'");
                                        builder.append("B D' B' R D' R' ");
                                    } else if (cube.sides[3].cells[6].color.equals("blue") &&
                                            cube.sides[0].cells[0].color.equals("red")) {
                                        cube.turn("B");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        builder.append("B D' B' D D L D' L' ");
                                    } else if (cube.sides[3].cells[6].color.equals("orange") &&
                                            cube.sides[0].cells[0].color.equals("blue")) {
                                        cube.turn("B");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        cube.turn("F");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("F'");
                                        builder.append("B D' B' F D D F' ");
                                    }
                                    break;
                                case 6:
                                    if (cube.sides[4].cells[6].color.equals("red") &&
                                            cube.sides[5].cells[0].color.equals("green")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        builder.append("D D L' D L ");
                                    } else if (cube.sides[4].cells[6].color.equals("green") &&
                                            cube.sides[5].cells[0].color.equals("orange")) {
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("B");
                                        builder.append("B' D D B ");
                                    } else if (cube.sides[4].cells[6].color.equals("blue") &&
                                            cube.sides[5].cells[0].color.equals("red")) {
                                        cube.turn("D'");
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("F");
                                        builder.append("D' F' D F ");
                                    } else if (cube.sides[4].cells[6].color.equals("orange") &&
                                            cube.sides[5].cells[0].color.equals("blue")) {
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        builder.append("R' D R ");
                                    }
                                    break;
                                case 8:
                                    if (cube.sides[0].cells[6].color.equals("red") &&
                                            cube.sides[4].cells[0].color.equals("green")) {
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("F");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        builder.append("F' D F D D L' D L ");
                                    } else if (cube.sides[0].cells[6].color.equals("green") &&
                                            cube.sides[4].cells[0].color.equals("orange")) {
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("F");
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("B");
                                        builder.append("F' D F B' D D B ");
                                    } else if (cube.sides[0].cells[6].color.equals("blue") &&
                                            cube.sides[4].cells[0].color.equals("red")) {
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("F");
                                        cube.turn("D'");
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("F");
                                        builder.append("F' D F D' F' D F ");
                                    } else if (cube.sides[0].cells[6].color.equals("orange") &&
                                            cube.sides[4].cells[0].color.equals("blue")) {
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("F");
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        builder.append("F' D F R' D R ");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 3:
                        for (Integer k : cube.find("white", i)) {
                            switch (k) {
                                case 0:
                                    if (cube.sides[2].cells[0].color.equals("red") &&
                                            cube.sides[5].cells[6].color.equals("green")) {
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        builder.append("D' L' D L ");
                                    } else if (cube.sides[2].cells[0].color.equals("green") &&
                                            cube.sides[5].cells[6].color.equals("orange")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        builder.append("D D B' D B ");
                                    } else if (cube.sides[2].cells[0].color.equals("blue") &&
                                            cube.sides[5].cells[6].color.equals("red")) {
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("F");
                                        builder.append("F' D F ");
                                    } else if (cube.sides[2].cells[0].color.equals("orange") &&
                                            cube.sides[5].cells[6].color.equals("blue")) {
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("R");
                                        builder.append("R' D D R ");
                                    }
                                    break;
                                case 2:
                                    if (cube.sides[5].cells[8].color.equals("red") &&
                                            cube.sides[1].cells[2].color.equals("green")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("B");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        builder.append("D D B D' B' ");
                                    } else if (cube.sides[5].cells[8].color.equals("green") &&
                                            cube.sides[1].cells[2].color.equals("orange")) {
                                        cube.turn("D");
                                        cube.turn("R");
                                        cube.turn("D'");
                                        cube.turn("R'");
                                        builder.append("D R D' R' ");
                                    } else if (cube.sides[5].cells[8].color.equals("blue") &&
                                            cube.sides[1].cells[2].color.equals("red")) {
                                        cube.turn("L");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("L'");
                                        builder.append("L D D L' ");
                                    } else if (cube.sides[5].cells[8].color.equals("orange") &&
                                            cube.sides[1].cells[2].color.equals("blue")) {
                                        cube.turn("F");
                                        cube.turn("D'");
                                        cube.turn("F'");
                                        builder.append("F D' F' ");
                                    }
                                    break;
                                case 6:
                                    if (cube.sides[0].cells[0].color.equals("red") &&
                                            cube.sides[2].cells[2].color.equals("green")) {
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        builder.append("L' D L D' L' D L ");
                                    } else if (cube.sides[0].cells[0].color.equals("green") &&
                                            cube.sides[2].cells[2].color.equals("orange")) {
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        builder.append("L' D L D D B' D B ");
                                    } else if (cube.sides[0].cells[0].color.equals("blue") &&
                                            cube.sides[2].cells[2].color.equals("red")) {
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("F");
                                        builder.append("L' D L F' D F ");
                                    } else if (cube.sides[0].cells[0].color.equals("orange") &&
                                            cube.sides[2].cells[2].color.equals("blue")) {
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("R");
                                        builder.append("L' D L R' D D R ");
                                    }
                                    break;
                                case 8:
                                    if (cube.sides[1].cells[0].color.equals("red") &&
                                            cube.sides[0].cells[2].color.equals("green")) {
                                        cube.turn("R");
                                        cube.turn("D'");
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("B");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        builder.append("R D' R' D D B D' B' ");
                                    } else if (cube.sides[1].cells[0].color.equals("green") &&
                                            cube.sides[0].cells[2].color.equals("orange")) {
                                        cube.turn("R");
                                        cube.turn("D'");
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        cube.turn("D'");
                                        cube.turn("R'");
                                        builder.append("R D' R' D R D' R' ");
                                    } else if (cube.sides[1].cells[0].color.equals("blue") &&
                                            cube.sides[0].cells[2].color.equals("red")) {
                                        cube.turn("R");
                                        cube.turn("D'");
                                        cube.turn("R'");
                                        cube.turn("L");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("L'");
                                        builder.append("R D' R' L D D L' ");
                                    } else if (cube.sides[1].cells[0].color.equals("orange") &&
                                            cube.sides[0].cells[2].color.equals("blue")) {
                                        cube.turn("R");
                                        cube.turn("D'");
                                        cube.turn("R'");
                                        cube.turn("F");
                                        cube.turn("D'");
                                        cube.turn("F'");
                                        builder.append("R D' R' F D' F' ");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 4:
                        for (Integer k : cube.find("white", i)) {
                            switch (k) {
                                case 0:
                                    if (cube.sides[2].cells[8].color.equals("red") &&
                                            cube.sides[0].cells[6].color.equals("green")) {
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("B");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        builder.append("L D' L' B D' B' ");
                                    } else if (cube.sides[2].cells[8].color.equals("green") &&
                                            cube.sides[0].cells[6].color.equals("orange")) {
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("R");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("R'");
                                        builder.append("L D' L' R D D R' ");
                                    } else if (cube.sides[2].cells[8].color.equals("blue") &&
                                            cube.sides[0].cells[6].color.equals("red")) {
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        builder.append("L D' L' D L D' L' ");
                                    } else if (cube.sides[2].cells[8].color.equals("orange") &&
                                            cube.sides[0].cells[6].color.equals("blue")) {
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("F");
                                        cube.turn("D'");
                                        cube.turn("F'");
                                        builder.append("L D' L' D D F D' F' ");
                                    }
                                    break;
                                case 2:
                                    if (cube.sides[0].cells[8].color.equals("red") &&
                                            cube.sides[1].cells[6].color.equals("green")) {
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("L");
                                        builder.append("R' D R L' F F L ");
                                    } else if (cube.sides[0].cells[8].color.equals("green") &&
                                            cube.sides[1].cells[6].color.equals("orange")) {
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        builder.append("R' D R B' D B ");
                                    } else if (cube.sides[5].cells[8].color.equals("blue") &&
                                            cube.sides[1].cells[6].color.equals("red")) {
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        cube.turn("D'");
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        builder.append("R' D R D' R' D R");
                                    } else if (cube.sides[5].cells[8].color.equals("orange") &&
                                            cube.sides[1].cells[6].color.equals("blue")) {
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("F");
                                        builder.append("R' D R D D F' D F ");
                                    }
                                    break;
                                case 6:
                                    if (cube.sides[5].cells[0].color.equals("red") &&
                                            cube.sides[2].cells[6].color.equals("green")) {
                                        cube.turn("B");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        builder.append("B D' B' ");
                                    } else if (cube.sides[5].cells[0].color.equals("green") &&
                                            cube.sides[2].cells[6].color.equals("orange")) {
                                        cube.turn("R");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("R'");
                                        builder.append("R D D R' ");
                                    } else if (cube.sides[5].cells[0].color.equals("blue") &&
                                            cube.sides[2].cells[6].color.equals("red")) {
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        builder.append("D L D' L' ");
                                    } else if (cube.sides[5].cells[0].color.equals("orange") &&
                                            cube.sides[2].cells[6].color.equals("blue")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("F");
                                        cube.turn("D'");
                                        cube.turn("F'");
                                        builder.append("D D F D' F' ");
                                    }
                                    break;
                                case 8:
                                    if (cube.sides[1].cells[8].color.equals("red") &&
                                            cube.sides[5].cells[2].color.equals("green")) {
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("L");
                                        builder.append("L' F F L ");
                                    } else if (cube.sides[1].cells[8].color.equals("green") &&
                                            cube.sides[5].cells[2].color.equals("orange")) {
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        builder.append("B' D B ");
                                    } else if (cube.sides[1].cells[8].color.equals("blue") &&
                                            cube.sides[5].cells[2].color.equals("red")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("F");
                                        builder.append("D D F' D F ");

                                    } else if (cube.sides[1].cells[8].color.equals("orange") &&
                                            cube.sides[5].cells[2].color.equals("blue")) {
                                        cube.turn("D'");
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        builder.append("D' R' D R");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 5:
                        for (Integer k : cube.find("white", i)) {
                            switch (k) {
                                case 0:
                                    if (cube.sides[2].cells[6].color.equals("red") &&
                                            cube.sides[4].cells[6].color.equals("green")) {
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        builder.append("L D' L' L' D L ");
                                    } else if (cube.sides[2].cells[6].color.equals("green") &&
                                            cube.sides[4].cells[6].color.equals("orange")) {
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        builder.append("L D' L' D' B' D B ");
                                    } else if (cube.sides[2].cells[6].color.equals("blue") &&
                                            cube.sides[4].cells[6].color.equals("red")) {
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("F");
                                        builder.append("L D' L' F' D D F ");
                                    } else if (cube.sides[2].cells[6].color.equals("orange") &&
                                            cube.sides[4].cells[6].color.equals("blue")) {
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        builder.append("L D' L' D D R' D R ");
                                    }
                                    break;
                                case 2:
                                    if (cube.sides[4].cells[8].color.equals("red") &&
                                            cube.sides[1].cells[8].color.equals("green")) {
                                        cube.turn("D'");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        builder.append("D' L D' L' L' D L ");
                                    } else if (cube.sides[4].cells[8].color.equals("green") &&
                                            cube.sides[1].cells[8].color.equals("orange")) {
                                        cube.turn("D'");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        builder.append("D' L D' L' D' B' D B ");
                                    } else if (cube.sides[4].cells[8].color.equals("blue") &&
                                            cube.sides[1].cells[8].color.equals("red")) {
                                        cube.turn("D'");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("F");
                                        builder.append("D' L D' L' F' D D F ");
                                    } else if (cube.sides[4].cells[8].color.equals("orange") &&
                                            cube.sides[1].cells[8].color.equals("blue")) {
                                        cube.turn("D'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        builder.append("D' L D' L' D D R' D R ");
                                    }
                                    break;
                                case 6:
                                    if (cube.sides[3].cells[0].color.equals("red") &&
                                            cube.sides[2].cells[0].color.equals("green")) {
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        builder.append("D L D' L' L' D L ");
                                    } else if (cube.sides[3].cells[0].color.equals("green") &&
                                            cube.sides[2].cells[0].color.equals("orange")) {
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        builder.append("D L D' L' D' B' D B ");
                                    } else if (cube.sides[3].cells[0].color.equals("blue") &&
                                            cube.sides[2].cells[0].color.equals("red")) {
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("F");
                                        builder.append("D L D' L' F' D D F ");
                                    } else if (cube.sides[3].cells[0].color.equals("orange") &&
                                            cube.sides[2].cells[0].color.equals("blue")) {
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("R");
                                        builder.append("D L D' L' D D R' D R ");
                                    }
                                    break;
                                case 8:
                                    if (cube.sides[1].cells[2].color.equals("red") &&
                                            cube.sides[3].cells[2].color.equals("green")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("L");
                                        builder.append("D D L D' L' L' D L ");
                                    } else if (cube.sides[1].cells[2].color.equals("green") &&
                                            cube.sides[3].cells[2].color.equals("orange")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("D'");
                                        cube.turn("B'");
                                        cube.turn("D");
                                        cube.turn("B");
                                        builder.append("D D L D' L' D' B' D B ");
                                    } else if (cube.sides[1].cells[2].color.equals("blue") &&
                                            cube.sides[3].cells[2].color.equals("red")) {
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("D'");
                                        cube.turn("L'");
                                        cube.turn("F'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("F");
                                        builder.append("D D L D' L' F' D D F ");
                                    } else if (cube.sides[1].cells[2].color.equals("orange") &&
                                            cube.sides[3].cells[2].color.equals("blue")) {
                                        cube.turn("L'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("L");
                                        cube.turn("R'");
                                        cube.turn("D");
                                        cube.turn("D");
                                        cube.turn("R");
                                        builder.append("L' D D L R' D D R ");
                                    }
                                    break;
                            }
                        }
                        break;
                }
            }
            if (cube.sideFull(0)) {
                for (int j = 0; j < 9; j++) {
                    switch (j) {
                        case 0:
                            if (!cube.sides[3].cells[6].color.equals("green")) {
                                cube.turn("L'");
                                cube.turn("D'");
                                cube.turn("L");
                                builder.append("L' D' L ");
                            }
                        case 2:
                            if (!cube.sides[3].cells[8].color.equals("green")) {
                                cube.turn("R");
                                cube.turn("D");
                                cube.turn("R'");
                                builder.append("R D R' ");
                            }
                        case 6:
                            if (!cube.sides[4].cells[0].color.equals("blue")) {
                                cube.turn("L");
                                cube.turn("D");
                                cube.turn("L'");
                                builder.append("L D L' ");
                            }
                        case 8:
                            if (!cube.sides[4].cells[2].color.equals("blue")) {
                                cube.turn("R'");
                                cube.turn("D'");
                                cube.turn("R");
                                builder.append("R' D' R ");
                            }
                    }
                }
            }
        }
    }

    private void step4() {
        while (!(cube.sideFull(0) && cube.equalsColor(1, Arrays.asList(0, 1, 3, 4, 6, 7), "orange") &&
                cube.equalsColor(2, Arrays.asList(1, 2, 4, 5, 7, 8), "red") &&
                cube.equalsColor(3, Arrays.asList(3, 4, 5, 6, 7, 8), "green") &&
                cube.equalsColor(4, Arrays.asList(0, 1, 2, 3, 4, 5), "blue"))) {
            if (!cube.sides[5].cells[1].color.equals("yellow") && !cube.sides[4].cells[7].color.equals("yellow")) {
                switch (cube.sides[4].cells[7].color) {
                    case "blue":
                        switch (cube.sides[5].cells[1].color) {
                            case "red":
                                cube.turn("D");
                                cube.turn("L");
                                cube.turn("D'");
                                cube.turn("L'");
                                cube.turn("D'");
                                cube.turn("F'");
                                cube.turn("D");
                                cube.turn("F");
                                builder.append("D L D' L' D' F' D F ");
                                break;
                            case "orange":
                                cube.turn("D'");
                                cube.turn("R'");
                                cube.turn("D");
                                cube.turn("R");
                                cube.turn("D");
                                cube.turn("F");
                                cube.turn("D'");
                                cube.turn("F'");
                                builder.append("D' R' D R D F D' F' ");
                                break;
                        }
                        break;
                    case "green":
                        switch (cube.sides[5].cells[1].color) {
                            case "red":
                                cube.turn("D");
                                cube.turn("L'");
                                cube.turn("D");
                                cube.turn("L");
                                cube.turn("D");
                                cube.turn("B");
                                cube.turn("D'");
                                cube.turn("B'");
                                builder.append("D L' D L D B D' B' ");
                                break;
                            case "orange":
                                cube.turn("D'");
                                cube.turn("R");
                                cube.turn("D'");
                                cube.turn("R'");
                                cube.turn("D'");
                                cube.turn("B'");
                                cube.turn("D");
                                cube.turn("B");
                                builder.append("D' R D' R' D' B' D B ");
                                break;
                        }
                        break;
                    case "red":
                        switch (cube.sides[5].cells[1].color) {
                            case "blue":
                                cube.turn("D");
                                cube.turn("D");
                                cube.turn("F'");
                                cube.turn("D");
                                cube.turn("F");
                                cube.turn("D");
                                cube.turn("L");
                                cube.turn("D'");
                                cube.turn("L'");
                                builder.append("D D F' D F D L D' L' ");
                                break;
                            case "green":
                                cube.turn("B");
                                cube.turn("D'");
                                cube.turn("B'");
                                cube.turn("D'");
                                cube.turn("L'");
                                cube.turn("D");
                                cube.turn("L");
                                builder.append("B D' B' D' L' D L ");
                                break;
                        }
                        break;
                    case "orange":
                        switch (cube.sides[5].cells[1].color) {
                            case "blue":
                                cube.turn("D");
                                cube.turn("D");
                                cube.turn("F");
                                cube.turn("D'");
                                cube.turn("F'");
                                cube.turn("D'");
                                cube.turn("R'");
                                cube.turn("D");
                                cube.turn("R");
                                builder.append("D D F D' F' D' R' D R ");
                                break;
                            case "green":
                                cube.turn("B'");
                                cube.turn("D");
                                cube.turn("B");
                                cube.turn("D");
                                cube.turn("R");
                                cube.turn("D'");
                                cube.turn("R'");
                                builder.append("B' D B D R D' R' ");
                                break;
                        }
                        break;
                }
            } else {
                if ((cube.equalsColor(4, Collections.singletonList(7), "yellow") ||
                        cube.equalsColor(5, Collections.singletonList(1), "yellow")) &&
                        (cube.equalsColor(1, Collections.singletonList(5), "yellow") ||
                                cube.equalsColor(5, Collections.singletonList(5), "yellow")) &&
                        (cube.equalsColor(2, Collections.singletonList(3), "yellow") ||
                                cube.equalsColor(5, Collections.singletonList(3), "yellow")) &&
                        (cube.equalsColor(3, Collections.singletonList(1), "yellow") ||
                                cube.equalsColor(5, Collections.singletonList(7), "yellow"))) {
                    if (!cube.sides[4].cells[5].color.equals("blue") || !cube.sides[1].cells[7].color.equals("orange")) {
                        cube.turn("R'");
                        cube.turn("D");
                        cube.turn("R");
                        cube.turn("D");
                        cube.turn("F");
                        cube.turn("D'");
                        cube.turn("F'");
                        builder.append("R' D R D F D' F' ");
                    } else if (!cube.sides[4].cells[3].color.equals("blue") || !cube.sides[2].cells[7].color.equals("red")) {
                        cube.turn("L");
                        cube.turn("D'");
                        cube.turn("L'");
                        cube.turn("D'");
                        cube.turn("F'");
                        cube.turn("D");
                        cube.turn("F");
                        builder.append("L D' L' D' F' D F ");
                    } else if (!cube.sides[3].cells[5].color.equals("green") || !cube.sides[1].cells[1].color.equals("orange")) {
                        cube.turn("R");
                        cube.turn("D'");
                        cube.turn("R'");
                        cube.turn("D'");
                        cube.turn("B'");
                        cube.turn("D");
                        cube.turn("B");
                        builder.append("R D' R' D' B' D B ");
                    } else if (!cube.sides[3].cells[3].color.equals("green") || !cube.sides[2].cells[1].color.equals("red")) {
                        cube.turn("L'");
                        cube.turn("D");
                        cube.turn("L");
                        cube.turn("D");
                        cube.turn("B");
                        cube.turn("D'");
                        cube.turn("B'");
                        builder.append("L' D L D B D' B' ");
                    }
                } else {
                    cube.turn("D");
                    builder.append("D ");
                }
            }
        }
    }

    private void step5() {
        while (!(cube.equalsColor(5, Arrays.asList(1, 3, 4, 5, 7), "yellow"))) {
            if (cube.equalsColor(5, Arrays.asList(0, 4, 7), "yellow") ||
                    cube.equalsColor(5, Arrays.asList(3, 4, 7), "yellow") ||
                    cube.equalsColor(5, Arrays.asList(4, 5, 7), "yellow") ||
                    cube.equalsColor(5, Arrays.asList(1, 4, 5), "yellow")) {
                cube.turn("D");
                builder.append("D ");
            }
            if (cube.equalsColor(5, Arrays.asList(3, 4, 5), "yellow") ||
                    cube.equalsColor(5, Arrays.asList(1, 3, 4), "yellow") ||
                    cube.equalsColor(5, Collections.singletonList(4), "yellow")) {
                cube.turn("B");
                cube.turn("R");
                cube.turn("D");
                cube.turn("R'");
                cube.turn("D'");
                cube.turn("B'");
                builder.append("B R D R' D' B' ");
            }
        }
    }

    private void step6() {
        while (!(cube.equalsColor(1, Collections.singletonList(5), "orange") &&
                cube.equalsColor(2, Collections.singletonList(3), "red") &&
                cube.equalsColor(3, Collections.singletonList(1), "green") &&
                cube.equalsColor(4, Collections.singletonList(7), "blue"))) {
            if (cube.equalsColor(4, Collections.singletonList(7), "blue")) {
                if (cube.equalsColor(1, Collections.singletonList(5), "orange")) {
                    cube.turn("R");
                    cube.turn("D");
                    cube.turn("R'");
                    cube.turn("D");
                    cube.turn("R");
                    cube.turn("D");
                    cube.turn("D");
                    cube.turn("R'");
                    cube.turn("D");
                    builder.append("R D R' D R D D R' D ");
                } else if (cube.equalsColor(3, Collections.singletonList(1), "green")) {
                    cube.turn("R");
                    cube.turn("D");
                    cube.turn("R'");
                    cube.turn("D");
                    cube.turn("R");
                    cube.turn("D");
                    cube.turn("D");
                    cube.turn("R'");
                    cube.turn("D");
                    builder.append("R D R' D R D D R' D ");
                } else if (cube.equalsColor(2, Collections.singletonList(3), "red")) {
                    cube.turn("F");
                    cube.turn("D");
                    cube.turn("F'");
                    cube.turn("D");
                    cube.turn("F");
                    cube.turn("D");
                    cube.turn("D");
                    cube.turn("F'");
                    cube.turn("D");
                    builder.append("F D F' D F D D F' D ");
                } else {
                    cube.turn("D");
                    builder.append("D ");
                }
            } else if (cube.equalsColor(3, Collections.singletonList(1), "green")) {
                if (cube.equalsColor(1, Collections.singletonList(5), "orange")) {
                    cube.turn("B");
                    cube.turn("D");
                    cube.turn("B'");
                    cube.turn("D");
                    cube.turn("B");
                    cube.turn("D");
                    cube.turn("D");
                    cube.turn("B'");
                    cube.turn("D");
                    builder.append("B D B' D B D D B' D ");
                } else if (cube.equalsColor(2, Collections.singletonList(3), "red")) {
                    cube.turn("L");
                    cube.turn("D");
                    cube.turn("L'");
                    cube.turn("D");
                    cube.turn("L");
                    cube.turn("D");
                    cube.turn("D");
                    cube.turn("L'");
                    cube.turn("D");
                    builder.append("L D L' D L D D L' D ");
                } else {
                    cube.turn("D");
                    builder.append("D ");
                }
            } else {
                cube.turn("D");
                builder.append("D ");
            }
        }
    }

    private void step7() {
        while (!(cube.rightMinCube(0) && cube.rightMinCube(1) &&
                cube.rightMinCube(2) && cube.rightMinCube(3))) {
            if (cube.rightMinCube(0)) {
                cube.turn("D");
                cube.turn("L");
                cube.turn("D'");
                cube.turn("R'");
                cube.turn("D");
                cube.turn("L'");
                cube.turn("D'");
                cube.turn("R");
                builder.append("D L D' R' D L' D' R ");
            } else if (cube.rightMinCube(1)) {
                cube.turn("D");
                cube.turn("F");
                cube.turn("D'");
                cube.turn("B'");
                cube.turn("D");
                cube.turn("F'");
                cube.turn("D'");
                cube.turn("B");
                builder.append("D F D' B' D F' D' B ");
            } else if (cube.rightMinCube(2)) {
                cube.turn("D");
                cube.turn("R");
                cube.turn("D'");
                cube.turn("L'");
                cube.turn("D");
                cube.turn("R'");
                cube.turn("D'");
                cube.turn("L");
                builder.append("D R D' L' D R' D' L ");
            } else if (cube.rightMinCube(3)) {
                cube.turn("D");
                cube.turn("B");
                cube.turn("D'");
                cube.turn("F'");
                cube.turn("D");
                cube.turn("B'");
                cube.turn("D'");
                cube.turn("F");
                builder.append("D B D' F' D B' D' F ");
            } else {
                cube.turn("D");
                cube.turn("L");
                cube.turn("D'");
                cube.turn("R'");
                cube.turn("D");
                cube.turn("L'");
                cube.turn("D'");
                cube.turn("R");
                builder.append("D L D' R' D L' D' R ");
            }
        }
    }

    private void step8() {
        while (!cube.sideFull(5)) {
            if (!cube.equalsColor(5, Collections.singletonList(0), "yellow")) {
                cube.turn("U");
                cube.turn("F");
                cube.turn("U'");
                cube.turn("F'");
                builder.append("U F U' F' ");
            } else {
                cube.turn("D");
                builder.append("D ");
            }
        }
        while (!cube.isSolved()) {
            if (!cube.equalsColor(4, Collections.singletonList(7), "blue")) {
                cube.turn("D");
                builder.append("D ");
            }
        }
    }
}