import java.util.Arrays;
import java.util.Collections;

class Solver {
    private StringBuilder builder = new StringBuilder();
    private Cube cube;

    Solver(Cube cube) {
        this.cube = cube;
    }

    String solve() {
        whiteCross();
        if (cube.isSolved()) return builder.toString();
        rightWhiteCross();
        if (cube.isSolved()) return builder.toString();
        whiteSide();
        if (cube.isSolved()) return builder.toString();
        secondLayer();
        if (cube.isSolved()) return builder.toString();
        yellowCross();
        if (cube.isSolved()) return builder.toString();
        rightYellowCross();
        if (cube.isSolved()) return builder.toString();
        rightCorner();
        if (cube.isSolved()) return builder.toString();
        turnCorner();
        if (cube.isSolved()) return builder.toString();
        return "ERROR";
    }

    private void whiteCross() {
        while (!(cube.equalsColor(0, Arrays.asList(1, 3, 4, 5, 7), Cube.Color.WHITE))) {
            for (int i = 1; i < 6; i++) {
                switch (i) {
                    case 1:
                        for (Integer k : cube.find(Cube.Color.WHITE, i)) {
                            switch (k) {
                                case 1:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("B")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U' B U")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U U B U' U' ")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U B U'")).append(" ");
                                    }
                                    break;
                                case 5:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("R' B R")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("R' U' B U")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("R F' R'")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U' R F' R' U")).append(" ");
                                    }
                                    break;
                                case 7:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U U B U' U'")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U F' U'")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("F'")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U' F' U")).append(" ");
                                    }
                                    break;
                                case 3:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("R B")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("R U' B U")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("R' F'")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("R' U' F' U")).append(" ");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 2:
                        for (Integer k : cube.find(Cube.Color.WHITE, i)) {
                            switch (k) {
                                case 1:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("B'")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U' B' U")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U U B' U' U'")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U B' U'")).append(" ");
                                    }
                                    break;
                                case 5:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("L' B'")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("L' U' B' U")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("L F")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("L' U B' U'")).append(" ");
                                    }
                                    break;
                                case 7:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U U F U U")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U F U'")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("F")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U' F U")).append(" ");
                                    }
                                    break;
                                case 3:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("L B' L'")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U' L B' L' U")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("L' F L")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U L B' L' U'")).append(" ");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 3:
                        for (Integer k : cube.find(Cube.Color.WHITE, i)) {
                            switch (k) {
                                case 1:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U' B' L' B U")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("B R' B'")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U' B R' B' U")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("B' L B")).append(" ");
                                    }
                                    break;
                                case 5:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U R' U'")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("R'")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U' R' U")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U U R' U U")).append(" ");
                                    }
                                    break;
                                case 7:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("B' U R' U'")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("B' R'")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("B' U' R' U")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("B L")).append(" ");
                                    }
                                    break;
                                case 3:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U' L U")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U U L U U")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U L U'")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("L")).append(" ");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 4:
                        for (Integer k : cube.find(Cube.Color.WHITE, i)) {
                            switch (k) {
                                case 1:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("F U R U'")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("F R")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("F U' R U")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("F' L'")).append(" ");
                                    }
                                    break;
                                case 5:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U R U'")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("R")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U' R U")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U U R U U")).append(" ");
                                    }
                                    break;
                                case 7:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("F U' L' U F'")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("F' R F")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("F' U' R U")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("F L' F'")).append(" ");
                                    }
                                    break;
                                case 3:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U' L' U")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U U L' U U")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("U L' U'")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("L'")).append(" ");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 5:
                        for (Integer k : cube.find(Cube.Color.WHITE, i)) {
                            switch (k) {
                                case 1:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("D D B B")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("D R R")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("F F")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("D' L L")).append(" ");
                                    }
                                    break;
                                case 5:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("D B B")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("R R")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("D' F F")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("D D L L")).append(" ");
                                    }
                                    break;
                                case 7:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("B B")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("D' R R")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("D D F F")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("D L L")).append(" ");
                                    }
                                    break;
                                case 3:
                                    if (!cube.get(0, 1).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("D' B B")).append(" ");
                                    } else if (!cube.get(0, 5).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("D D R R")).append(" ");
                                    } else if (!cube.get(0, 7).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("D F F")).append(" ");
                                    } else if (!cube.get(0, 3).equals(Cube.Color.WHITE)) {
                                        builder.append(cube.turn("L L")).append(" ");
                                    }
                                    break;
                            }
                        }
                        break;
                }
            }
        }
    }

    private void rightWhiteCross() {
        while (!(cube.equalsColor(1, Arrays.asList(3, 4), Cube.Color.ORANGE) &&
                cube.equalsColor(2, Arrays.asList(4, 5), Cube.Color.RED) &&
                cube.equalsColor(3, Arrays.asList(4, 7), Cube.Color.GREEN) &&
                cube.equalsColor(4, Arrays.asList(1, 4), Cube.Color.BLUE))) {
            if (cube.equalsColor(4, Arrays.asList(1, 4), Cube.Color.BLUE)) {
                if (cube.equalsColor(2, Arrays.asList(4, 5), Cube.Color.RED)) {
                    builder.append(cube.turn("R U R' U' R")).append(" ");
                    continue;
                }
                if (cube.equalsColor(1, Arrays.asList(3, 4), Cube.Color.ORANGE)) {
                    builder.append(cube.turn("B U B' U' B")).append(" ");
                    continue;
                }
            }
            if (cube.equalsColor(3, Arrays.asList(4, 7), Cube.Color.GREEN)) {
                if (cube.equalsColor(2, Arrays.asList(4, 5), Cube.Color.RED)) {
                    builder.append(cube.turn("F U F' U' F")).append(" ");
                    continue;
                }
                if (cube.equalsColor(1, Arrays.asList(3, 4), Cube.Color.ORANGE)) {
                    builder.append(cube.turn("L U L' U' L")).append(" ");
                    continue;
                }
            }
            if ((cube.equalsColor(4, Arrays.asList(1, 4), Cube.Color.BLUE) &&
                    cube.equalsColor(3, Arrays.asList(4, 7), Cube.Color.GREEN)) ||
                    (cube.equalsColor(1, Arrays.asList(3, 4), Cube.Color.ORANGE)
                            && cube.equalsColor(2, Arrays.asList(4, 5), Cube.Color.RED))) {
                builder.append(cube.turn("R U R' U' R")).append(" ");
                continue;
            }
            builder.append(cube.turn("U")).append(" ");
        }
    }

    private void whiteSide() {
        while (!(cube.sideFull(0) &&
                cube.equalsColor(1, Arrays.asList(0, 3, 4, 6), Cube.Color.ORANGE) &&
                cube.equalsColor(2, Arrays.asList(2, 4, 5, 8), Cube.Color.RED) &&
                cube.equalsColor(3, Arrays.asList(4, 6, 7, 8), Cube.Color.GREEN) &&
                cube.equalsColor(4, Arrays.asList(0, 1, 2, 4), Cube.Color.BLUE))) {
            for (int i = 1; i < 6; i++) {
                switch (i) {
                    case 1:
                        for (Integer k : cube.find(Cube.Color.WHITE, i)) {
                            switch (k) {
                                case 0:
                                    if (cube.get(0, 2).equals(Cube.Color.RED) &&
                                            cube.get(3, 8).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("B' D B L' D L")).append(" ");
                                    } else if (cube.get(0, 2).equals(Cube.Color.GREEN) &&
                                            cube.get(3, 8).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("B' D B D' B' D B")).append(" ");
                                    } else if (cube.get(0, 2).equals(Cube.Color.BLUE) &&
                                            cube.get(3, 8).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("B' D B F' D D F")).append(" ");
                                    } else if (cube.get(0, 2).equals(Cube.Color.ORANGE) &&
                                            cube.get(3, 8).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("B' D B D D R' D R")).append(" ");
                                    }
                                    break;
                                case 2:
                                    if (cube.get(3, 2).equals(Cube.Color.RED) &&
                                            cube.get(5, 8).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("L' D L")).append(" ");
                                    } else if (cube.get(3, 2).equals(Cube.Color.GREEN) &&
                                            cube.get(5, 8).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("D' B' D B")).append(" ");
                                    } else if (cube.get(3, 2).equals(Cube.Color.BLUE) &&
                                            cube.get(5, 8).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("F' D D F")).append(" ");
                                    } else if (cube.get(3, 2).equals(Cube.Color.ORANGE) &&
                                            cube.get(5, 8).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("D D R' D R")).append(" ");
                                    }
                                    break;
                                case 6:
                                    if (cube.get(4, 2).equals(Cube.Color.RED) &&
                                            cube.get(0, 8).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("F D' F' B D D B'")).append(" ");
                                    } else if (cube.get(4, 2).equals(Cube.Color.GREEN) &&
                                            cube.get(0, 8).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("F D' F' D R D D R")).append(" ");
                                    } else if (cube.get(4, 2).equals(Cube.Color.BLUE) &&
                                            cube.get(0, 8).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("F D' F' L D L'")).append(" ");
                                    } else if (cube.get(4, 2).equals(Cube.Color.ORANGE) &&
                                            cube.get(0, 8).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("F D' F' D F D' F'")).append(" ");
                                    }
                                    break;
                                case 8:
                                    if (cube.get(5, 2).equals(Cube.Color.RED) &&
                                            cube.get(4, 8).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("B D D B'")).append(" ");
                                    } else if (cube.get(5, 2).equals(Cube.Color.GREEN) &&
                                            cube.get(4, 8).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("D' R D D R'")).append(" ");
                                    } else if (cube.get(5, 2).equals(Cube.Color.BLUE) &&
                                            cube.get(4, 8).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("L D' L'")).append(" ");
                                    } else if (cube.get(5, 2).equals(Cube.Color.ORANGE) &&
                                            cube.get(4, 8).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("D F D' F'")).append(" ");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 2:
                        for (Integer k : cube.find(Cube.Color.WHITE, i)) {
                            switch (k) {
                                case 0:
                                    if (cube.get(5, 6).equals(Cube.Color.RED) &&
                                            cube.get(3, 0).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("D B D' B'")).append(" ");
                                    } else if (cube.get(5, 6).equals(Cube.Color.GREEN) &&
                                            cube.get(3, 0).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("R D' R'")).append(" ");
                                    } else if (cube.get(5, 6).equals(Cube.Color.BLUE) &&
                                            cube.get(3, 0).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("D D L D' L'")).append(" ");
                                    } else if (cube.get(5, 6).equals(Cube.Color.ORANGE) &&
                                            cube.get(3, 0).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("F D D F'")).append(" ");
                                    }
                                    break;
                                case 2:
                                    if (cube.get(3, 6).equals(Cube.Color.RED) &&
                                            cube.get(0, 0).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("B D' B' D B D' B'")).append(" ");
                                    } else if (cube.get(3, 6).equals(Cube.Color.GREEN) &&
                                            cube.get(0, 0).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("B D' B' R D' R'")).append(" ");
                                    } else if (cube.get(3, 6).equals(Cube.Color.BLUE) &&
                                            cube.get(0, 0).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("B D' B' D D L D' L'")).append(" ");
                                    } else if (cube.get(3, 6).equals(Cube.Color.ORANGE) &&
                                            cube.get(0, 0).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("B D' B' F D D F'")).append(" ");
                                    }
                                    break;
                                case 6:
                                    if (cube.get(4, 6).equals(Cube.Color.RED) &&
                                            cube.get(5, 0).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("D D L' D L")).append(" ");
                                    } else if (cube.get(4, 6).equals(Cube.Color.GREEN) &&
                                            cube.get(5, 0).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("B' D D B")).append(" ");
                                    } else if (cube.get(4, 6).equals(Cube.Color.BLUE) &&
                                            cube.get(5, 0).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("D' F' D F")).append(" ");
                                    } else if (cube.get(4, 6).equals(Cube.Color.ORANGE) &&
                                            cube.get(5, 0).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("R' D R")).append(" ");
                                    }
                                    break;
                                case 8:
                                    if (cube.get(0, 6).equals(Cube.Color.RED) &&
                                            cube.get(4, 0).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("F' D F D D L' D L")).append(" ");
                                    } else if (cube.get(0, 6).equals(Cube.Color.GREEN) &&
                                            cube.get(4, 0).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("F' D F B' D D B")).append(" ");
                                    } else if (cube.get(0, 6).equals(Cube.Color.BLUE) &&
                                            cube.get(4, 0).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("F' D F D' F' D F")).append(" ");
                                    } else if (cube.get(0, 6).equals(Cube.Color.ORANGE) &&
                                            cube.get(4, 0).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("F' D F R' D R")).append(" ");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 3:
                        for (Integer k : cube.find(Cube.Color.WHITE, i)) {
                            switch (k) {
                                case 0:
                                    if (cube.get(2, 0).equals(Cube.Color.RED) &&
                                            cube.get(5, 6).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("D' L' D L")).append(" ");
                                    } else if (cube.get(2, 0).equals(Cube.Color.GREEN) &&
                                            cube.get(5, 6).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("D D B' D B")).append(" ");
                                    } else if (cube.get(2, 0).equals(Cube.Color.BLUE) &&
                                            cube.get(5, 6).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("F' D F")).append(" ");
                                    } else if (cube.get(2, 0).equals(Cube.Color.ORANGE) &&
                                            cube.get(5, 6).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("R' D D R")).append(" ");
                                    }
                                    break;
                                case 2:
                                    if (cube.get(5, 8).equals(Cube.Color.RED) &&
                                            cube.get(1, 2).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("D D B D' B'")).append(" ");
                                    } else if (cube.get(5, 8).equals(Cube.Color.GREEN) &&
                                            cube.get(1, 2).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("D R D' R'")).append(" ");
                                    } else if (cube.get(5, 8).equals(Cube.Color.BLUE) &&
                                            cube.get(1, 2).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("L D D L'")).append(" ");
                                    } else if (cube.get(5, 8).equals(Cube.Color.ORANGE) &&
                                            cube.get(1, 2).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("F D' F'")).append(" ");
                                    }
                                    break;
                                case 6:
                                    if (cube.get(0, 0).equals(Cube.Color.RED) &&
                                            cube.get(2, 2).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("L' D L D' L' D L")).append(" ");
                                    } else if (cube.get(0, 0).equals(Cube.Color.GREEN) &&
                                            cube.get(2, 2).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("L' D L D D B' D B")).append(" ");
                                    } else if (cube.get(0, 0).equals(Cube.Color.BLUE) &&
                                            cube.get(2, 2).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("L' D L F' D F")).append(" ");
                                    } else if (cube.get(0, 0).equals(Cube.Color.ORANGE) &&
                                            cube.get(2, 2).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("L' D L R' D D R")).append(" ");
                                    }
                                    break;
                                case 8:
                                    if (cube.get(1, 0).equals(Cube.Color.RED) &&
                                            cube.get(0, 2).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("R D' R' D D B D' B'")).append(" ");
                                    } else if (cube.get(1, 0).equals(Cube.Color.GREEN) &&
                                            cube.get(0, 2).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("R D' R' D R D' R'")).append(" ");
                                    } else if (cube.get(1, 0).equals(Cube.Color.BLUE) &&
                                            cube.get(0, 2).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("R D' R' L D D L'")).append(" ");
                                    } else if (cube.get(1, 0).equals(Cube.Color.ORANGE) &&
                                            cube.get(0, 2).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("R D' R' F D' F'")).append(" ");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 4:
                        for (Integer k : cube.find(Cube.Color.WHITE, i)) {
                            switch (k) {
                                case 0:
                                    if (cube.get(2, 8).equals(Cube.Color.RED) &&
                                            cube.get(0, 6).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("L D' L' B D' B'")).append(" ");
                                    } else if (cube.get(2, 8).equals(Cube.Color.GREEN) &&
                                            cube.get(0, 6).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("L D' L' R D D R'")).append(" ");
                                    } else if (cube.get(2, 8).equals(Cube.Color.BLUE) &&
                                            cube.get(0, 6).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("L D' L' D L D' L'")).append(" ");
                                    } else if (cube.get(2, 8).equals(Cube.Color.ORANGE) &&
                                            cube.get(0, 6).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("L D' L' D D F D' F'")).append(" ");
                                    }
                                    break;
                                case 2:
                                    if (cube.get(0, 8).equals(Cube.Color.RED) &&
                                            cube.get(1, 6).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("R' D R L' F F L")).append(" ");
                                    } else if (cube.get(0, 8).equals(Cube.Color.GREEN) &&
                                            cube.get(1, 6).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("R' D R B' D B")).append(" ");
                                    } else if (cube.get(5, 8).equals(Cube.Color.BLUE) &&
                                            cube.get(1, 6).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("R' D R D' R' D R")).append(" ");
                                    } else if (cube.get(5, 8).equals(Cube.Color.ORANGE) &&
                                            cube.get(1, 6).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("R' D R D D F' D F")).append(" ");
                                    }
                                    break;
                                case 6:
                                    if (cube.get(5, 0).equals(Cube.Color.RED) &&
                                            cube.get(2, 6).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("B D' B'")).append(" ");
                                    } else if (cube.get(5, 0).equals(Cube.Color.GREEN) &&
                                            cube.get(2, 6).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("R D D R'")).append(" ");
                                    } else if (cube.get(5, 0).equals(Cube.Color.BLUE) &&
                                            cube.get(2, 6).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("D L D' L'")).append(" ");
                                    } else if (cube.get(5, 0).equals(Cube.Color.ORANGE) &&
                                            cube.get(2, 6).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("D D F D' F'")).append(" ");
                                    }
                                    break;
                                case 8:
                                    if (cube.get(1, 8).equals(Cube.Color.RED) &&
                                            cube.get(5, 2).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("L' D D L")).append(" ");
                                    } else if (cube.get(1, 8).equals(Cube.Color.GREEN) &&
                                            cube.get(5, 2).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("B' D B")).append(" ");
                                    } else if (cube.get(1, 8).equals(Cube.Color.BLUE) &&
                                            cube.get(5, 2).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("D D F' D F")).append(" ");
                                    } else if (cube.get(1, 8).equals(Cube.Color.ORANGE) &&
                                            cube.get(5, 2).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("D' R' D R")).append(" ");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 5:
                        for (Integer k : cube.find(Cube.Color.WHITE, i)) {
                            switch (k) {
                                case 0:
                                    if (cube.get(2, 6).equals(Cube.Color.RED) &&
                                            cube.get(4, 6).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("L D' L' L' D L")).append(" ");
                                    } else if (cube.get(2, 6).equals(Cube.Color.GREEN) &&
                                            cube.get(4, 6).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("L D' L' D' B' D B")).append(" ");
                                    } else if (cube.get(2, 6).equals(Cube.Color.BLUE) &&
                                            cube.get(4, 6).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("L D' L' F' D D F")).append(" ");
                                    } else if (cube.get(2, 6).equals(Cube.Color.ORANGE) &&
                                            cube.get(4, 6).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("L D' L' D D R' D R")).append(" ");
                                    }
                                    break;
                                case 2:
                                    if (cube.get(4, 8).equals(Cube.Color.RED) &&
                                            cube.get(1, 8).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("D' L D' L' L' D L")).append(" ");
                                    } else if (cube.get(4, 8).equals(Cube.Color.GREEN) &&
                                            cube.get(1, 8).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("D' L D' L' D' B' D B")).append(" ");
                                    } else if (cube.get(4, 8).equals(Cube.Color.BLUE) &&
                                            cube.get(1, 8).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("D' L D' L' F' D D F")).append(" ");
                                    } else if (cube.get(4, 8).equals(Cube.Color.ORANGE) &&
                                            cube.get(1, 8).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("D' L D' L' D D R' D R")).append(" ");
                                    }
                                    break;
                                case 6:
                                    if (cube.get(3, 0).equals(Cube.Color.RED) &&
                                            cube.get(2, 0).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("D L D' L' L' D L")).append(" ");
                                    } else if (cube.get(3, 0).equals(Cube.Color.GREEN) &&
                                            cube.get(2, 0).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("D L D' L' D' B' D B")).append(" ");
                                    } else if (cube.get(3, 0).equals(Cube.Color.BLUE) &&
                                            cube.get(2, 0).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("D L D' L' F' D D F")).append(" ");
                                    } else if (cube.get(3, 0).equals(Cube.Color.ORANGE) &&
                                            cube.get(2, 0).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("D L D' L' D D R' D R")).append(" ");
                                    }
                                    break;
                                case 8:
                                    if (cube.get(1, 2).equals(Cube.Color.RED) &&
                                            cube.get(3, 2).equals(Cube.Color.GREEN)) {
                                        builder.append(cube.turn("D D L D' L' L' D L")).append(" ");
                                    } else if (cube.get(1, 2).equals(Cube.Color.GREEN) &&
                                            cube.get(3, 2).equals(Cube.Color.ORANGE)) {
                                        builder.append(cube.turn("D D L D' L' D' B' D B")).append(" ");
                                    } else if (cube.get(1, 2).equals(Cube.Color.BLUE) &&
                                            cube.get(3, 2).equals(Cube.Color.RED)) {
                                        builder.append(cube.turn("D D L D' L' F' D D F")).append(" ");
                                    } else if (cube.get(1, 2).equals(Cube.Color.ORANGE) &&
                                            cube.get(3, 2).equals(Cube.Color.BLUE)) {
                                        builder.append(cube.turn("L' D D L R' D D R")).append(" ");
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
                            if (!cube.get(3, 6).equals(Cube.Color.GREEN)) {
                                builder.append(cube.turn("L' D' L")).append(" ");
                            }
                        case 2:
                            if (!cube.get(3, 8).equals(Cube.Color.GREEN)) {
                                builder.append(cube.turn("R D R'")).append(" ");
                            }
                        case 6:
                            if (!cube.get(4, 0).equals(Cube.Color.BLUE)) {
                                builder.append(cube.turn("L D L'")).append(" ");
                            }
                        case 8:
                            if (!cube.get(4, 2).equals(Cube.Color.BLUE)) {
                                builder.append(cube.turn("R' D' R")).append(" ");
                            }
                    }
                }
            }
        }
    }

    private void secondLayer() {
        while (!(cube.sideFull(0) &&
                cube.equalsColor(1, Arrays.asList(0, 1, 3, 4, 6, 7), Cube.Color.ORANGE) &&
                cube.equalsColor(2, Arrays.asList(1, 2, 4, 5, 7, 8), Cube.Color.RED) &&
                cube.equalsColor(3, Arrays.asList(3, 4, 5, 6, 7, 8), Cube.Color.GREEN) &&
                cube.equalsColor(4, Arrays.asList(0, 1, 2, 3, 4, 5), Cube.Color.BLUE))) {
            if (!cube.get(5, 1).equals(Cube.Color.YELLOW) && !cube.get(4, 7).equals(Cube.Color.YELLOW)) {
                switch (cube.get(4, 7)) {
                    case BLUE:
                        switch (cube.get(5, 1)) {
                            case RED:
                                builder.append(cube.turn("D L D' L' D' F' D F")).append(" ");
                                break;
                            case ORANGE:
                                builder.append(cube.turn("D' R' D R D F D' F'")).append(" ");
                                break;
                        }
                        break;
                    case GREEN:
                        switch (cube.get(5, 1)) {
                            case RED:
                                builder.append(cube.turn("D L' D L D B D' B'")).append(" ");
                                break;
                            case ORANGE:
                                builder.append(cube.turn("D' R D' R' D' B' D B")).append(" ");
                                break;
                        }
                        break;
                    case RED:
                        switch (cube.get(5, 1)) {
                            case BLUE:
                                builder.append(cube.turn("D D F' D F D L D' L'")).append(" ");
                                break;
                            case GREEN:
                                builder.append(cube.turn("B D' B' D' L' D L")).append(" ");
                                break;
                        }
                        break;
                    case ORANGE:
                        switch (cube.get(5, 1)) {
                            case BLUE:
                                builder.append(cube.turn("D D F D' F' D' R' D R")).append(" ");
                                break;
                            case GREEN:
                                builder.append(cube.turn("B' D B D R D' R'")).append(" ");
                                break;
                        }
                        break;
                }
            } else {
                if ((cube.equalsColor(4, Collections.singletonList(7), Cube.Color.YELLOW) ||
                        cube.equalsColor(5, Collections.singletonList(1), Cube.Color.YELLOW)) &&
                        (cube.equalsColor(1, Collections.singletonList(5), Cube.Color.YELLOW) ||
                                cube.equalsColor(5, Collections.singletonList(5), Cube.Color.YELLOW)) &&
                        (cube.equalsColor(2, Collections.singletonList(3), Cube.Color.YELLOW) ||
                                cube.equalsColor(5, Collections.singletonList(3), Cube.Color.YELLOW)) &&
                        (cube.equalsColor(3, Collections.singletonList(1), Cube.Color.YELLOW) ||
                                cube.equalsColor(5, Collections.singletonList(7), Cube.Color.YELLOW))) {
                    if (!cube.get(4, 5).equals(Cube.Color.BLUE) || !cube.get(1, 7).equals(Cube.Color.ORANGE)) {
                        builder.append(cube.turn("R' D R D F D' F'")).append(" ");
                    } else if (!cube.get(4, 3).equals(Cube.Color.BLUE) || !cube.get(2, 7).equals(Cube.Color.RED)) {
                        builder.append(cube.turn("L D' L' D' F' D F")).append(" ");
                    } else if (!cube.get(3, 5).equals(Cube.Color.GREEN) || !cube.get(1, 1).equals(Cube.Color.ORANGE)) {
                        builder.append(cube.turn("R D' R' D' B' D B")).append(" ");
                    } else if (!cube.get(3, 3).equals(Cube.Color.GREEN) || !cube.get(2, 1).equals(Cube.Color.RED)) {
                        builder.append(cube.turn("L' D L D B D' B'")).append(" ");
                    }
                } else {
                    builder.append(cube.turn("D")).append(" ");
                }
            }
        }
    }

    private void yellowCross() {
        while (!(cube.equalsColor(5, Arrays.asList(1, 3, 4, 5, 7), Cube.Color.YELLOW))) {
            if (cube.equalsColor(5, Arrays.asList(0, 4, 7), Cube.Color.YELLOW) ||
                    cube.equalsColor(5, Arrays.asList(3, 4, 7), Cube.Color.YELLOW) ||
                    cube.equalsColor(5, Arrays.asList(4, 5, 7), Cube.Color.YELLOW) ||
                    cube.equalsColor(5, Arrays.asList(1, 4, 5), Cube.Color.YELLOW)) {
                builder.append(cube.turn("D")).append(" ");
            }
            if (cube.equalsColor(5, Arrays.asList(3, 4, 5), Cube.Color.YELLOW) ||
                    cube.equalsColor(5, Arrays.asList(1, 3, 4), Cube.Color.YELLOW) ||
                    cube.equalsColor(5, Collections.singletonList(4), Cube.Color.YELLOW)) {
                builder.append(cube.turn("B R D R' D' B'")).append(" ");
            }
        }
    }

    private void rightYellowCross() {
        while (!(cube.equalsColor(1, Collections.singletonList(5), Cube.Color.ORANGE) &&
                cube.equalsColor(2, Collections.singletonList(3), Cube.Color.RED) &&
                cube.equalsColor(3, Collections.singletonList(1), Cube.Color.GREEN) &&
                cube.equalsColor(4, Collections.singletonList(7), Cube.Color.BLUE))) {
            if (cube.equalsColor(4, Collections.singletonList(7), Cube.Color.BLUE)) {
                if (cube.equalsColor(1, Collections.singletonList(5), Cube.Color.ORANGE)) {
                    builder.append(cube.turn("R D R' D R D D R' D")).append(" ");
                } else if (cube.equalsColor(3, Collections.singletonList(1), Cube.Color.GREEN)) {
                    builder.append(cube.turn("R D R' D R D D R' D")).append(" ");
                } else if (cube.equalsColor(2, Collections.singletonList(3), Cube.Color.RED)) {
                    builder.append(cube.turn("F D F' D F D D F' D")).append(" ");
                } else {
                    builder.append(cube.turn("D")).append(" ");
                }
            } else if (cube.equalsColor(3, Collections.singletonList(1), Cube.Color.GREEN)) {
                if (cube.equalsColor(1, Collections.singletonList(5), Cube.Color.ORANGE)) {
                    builder.append(cube.turn("B D B' D B D D B' D")).append(" ");
                } else if (cube.equalsColor(2, Collections.singletonList(3), Cube.Color.RED)) {
                    builder.append(cube.turn("L D L' D L D D L' D")).append(" ");
                } else {
                    builder.append(cube.turn("D")).append(" ");
                }
            } else {
                builder.append(cube.turn("D")).append(" ");
            }
        }
    }

    private void rightCorner() {
        while (!(cube.rightMinCube(0) && cube.rightMinCube(1) &&
                cube.rightMinCube(2) && cube.rightMinCube(3))) {
            if (cube.rightMinCube(0)) {
                builder.append(cube.turn("D L D' R' D L' D' R")).append(" ");
            } else if (cube.rightMinCube(1)) {
                builder.append(cube.turn("D F D' B' D F' D' B")).append(" ");
            } else if (cube.rightMinCube(2)) {
                builder.append(cube.turn("D R D' L' D R' D' L")).append(" ");
            } else if (cube.rightMinCube(3)) {
                builder.append(cube.turn("D B D' F' D B' D' F")).append(" ");
            } else {
                builder.append(cube.turn("D L D' R' D L' D' R")).append(" ");
            }
        }
    }

    private void turnCorner() {
        while (!cube.sideFull(5)) {
            if (!cube.equalsColor(5, Collections.singletonList(0), Cube.Color.YELLOW)) {
                builder.append(cube.turn("U F U' F'")).append(" ");
            } else {
                builder.append(cube.turn("D")).append(" ");
            }
        }
        while (!cube.isSolved()) {
            if (!cube.equalsColor(4, Collections.singletonList(7), Cube.Color.BLUE)) {
                builder.append(cube.turn("D")).append(" ");
            }
        }
    }
}