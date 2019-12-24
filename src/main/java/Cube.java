import java.util.*;

class Cube {
    class Side {
        Cell[] cells = new Cell[9];

        Side(String color) {
            for (int i = 0; i < 9; i++) {
                cells[i] = new Cell(color);
            }
        }
    }

    class Cell {
        String color;
        Cell(String color) {
            this.color = color;
        }
    }

    Side[] sides = new Side[6];
    String scramble;

    Cube() {
        String[] colors = new String[]{"white", "orange", "red", "green", "blue", "yellow"};
        for (int i = 0; i < 6; i++) {
            sides[i] = new Side(colors[i]);
        }
    }

    boolean isSolved() {
        int[] test = new int[]{0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    for (int j = 0; j < 9; j++) if (this.sides[i].cells[j].color.equals("white")) test[i]++;
                    break;
                case 1:
                    for (int j = 0; j < 9; j++) if (this.sides[i].cells[j].color.equals("orange")) test[i]++;
                    break;
                case 2:
                    for (int j = 0; j < 9; j++) if (this.sides[i].cells[j].color.equals("red")) test[i]++;
                    break;
                case 3:
                    for (int j = 0; j < 9; j++) if (this.sides[i].cells[j].color.equals("green")) test[i]++;
                    break;
                case 4:
                    for (int j = 0; j < 9; j++) if (this.sides[i].cells[j].color.equals("blue")) test[i]++;
                    break;
                case 5:
                    for (int j = 0; j < 9; j++) if (this.sides[i].cells[j].color.equals("yellow")) test[i]++;
                    break;
            }
        }
        return test[0] == 9 && test[1] == 9 && test[2] == 9 && test[3] == 9 && test[4] == 9 && test[5] == 9;
    }

    Boolean sideFull(int side) {
        int j = 0;
        String color = "";
        switch (side) {
            case 0:
                color = "white";
                break;
            case 1:
                color = "orange";
                break;
            case 2:
                color = "red";
                break;
            case 3:
                color = "green";
                break;
            case 4:
                color = "blue";
                break;
            case 5:
                color = "yellow";
                break;
        }
        for (int i = 0; i < 9; i++) if (this.sides[side].cells[i].color.equals(color)) j++;
        return j == 9;
    }

    Boolean equalsColor(int side, List<Integer> cells, String color) {
        int j = 0;
        for (Integer i : cells) {
            if (this.sides[side].cells[i].color.equals(color)) j++;
        }
        return cells.size() == j;
    }

    Boolean rightMinCube(int i) {
        List temp = Arrays.asList("yellow", "red", "blue");
        List temp1 = Arrays.asList("yellow", "blue", "orange");
        List temp2 = Arrays.asList("yellow", "orange", "green");
        List temp3 = Arrays.asList("yellow", "green", "red");
        int[] counter = new int[4];
        List<String> colors = new ArrayList<>();
        switch (i) {
            case 0:
                colors.add(this.sides[4].cells[6].color);
                colors.add(this.sides[5].cells[0].color);
                colors.add(this.sides[2].cells[6].color);
                break;
            case 1:
                colors.add(this.sides[4].cells[8].color);
                colors.add(this.sides[1].cells[8].color);
                colors.add(this.sides[5].cells[2].color);
                break;
            case 2:
                colors.add(this.sides[3].cells[2].color);
                colors.add(this.sides[1].cells[2].color);
                colors.add(this.sides[5].cells[8].color);
                break;
            case 3:
                colors.add(this.sides[3].cells[0].color);
                colors.add(this.sides[2].cells[0].color);
                colors.add(this.sides[5].cells[6].color);
                break;
        }
        for (String str : colors) {
            switch (i) {
                case 0:
                    if (temp.contains(str)) counter[0]++;
                    break;
                case 1:
                    if (temp1.contains(str)) counter[1]++;
                    break;
                case 2:
                    if (temp2.contains(str)) counter[2]++;
                    break;
                case 3:
                    if (temp3.contains(str)) counter[3]++;
                    break;
            }
        }
        boolean answer = false;
        switch (i) {
            case 0:
                answer = counter[0] == 3;
                break;
            case 1:
                answer = counter[1] == 3;
                break;
            case 2:
                answer = counter[2] == 3;
                break;
            case 3:
                answer = counter[3] == 3;
                break;
        }
        return answer;
    }

    Set<Integer> find(String color, int side) {
        Set<Integer> finder = new HashSet<>();
        for (int j = 0; j < 9; j++) if (this.sides[side].cells[j].color.equals(color)) finder.add(j);
        return finder;
    }

    String shuffle(Integer length) {
        Random rand = new Random();
        List<String> steps = Arrays.asList("F", "F'", "B", "B'", "L", "L'", "R", "R'", "U", "U'", "D", "D'");
        List<String> scramble = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String step = steps.get(rand.nextInt(steps.size()));
            scramble.add(step);
            builder.append(step).append(" ");
        }
        for (String step : scramble) {
            turn(step);
        }
        this.scramble = builder.toString();
        return this.scramble;
    }

    String reverse() {
        List<String> scramble = new ArrayList<>(Arrays.asList(this.scramble.split(" ")));
        StringBuilder builder = new StringBuilder();
        for (int i = scramble.size() - 1; i >= 0; i--) {
            switch (scramble.get(i)) {
                case "F":
                    builder.append("F'").append(" ");
                    break;
                case "F'":
                    builder.append("F").append(" ");
                    break;
                case "B":
                    builder.append("B'").append(" ");
                    break;
                case "B'":
                    builder.append("B").append(" ");
                    break;
                case "L":
                    builder.append("L'").append(" ");
                    break;
                case "L'":
                    builder.append("L").append(" ");
                    break;
                case "R":
                    builder.append("R'").append(" ");
                    break;
                case "R'":
                    builder.append("R").append(" ");
                    break;
                case "U":
                    builder.append("U'").append(" ");
                    break;
                case "U'":
                    builder.append("U").append(" ");
                    break;
                case "D":
                    builder.append("D'").append(" ");
                    break;
                case "D'":
                    builder.append("D").append(" ");
                    break;
            }
        }
        return builder.toString();
    }

    private void sideTurn(int side, boolean forward) {
        Cell[] tempSide = new Cell[9];
        if (forward) {
            tempSide[0] = sides[side].cells[0];
            tempSide[1] = sides[side].cells[1];
            tempSide[2] = sides[side].cells[2];
            tempSide[3] = sides[side].cells[3];
            tempSide[4] = sides[side].cells[4];
            tempSide[5] = sides[side].cells[5];
            tempSide[6] = sides[side].cells[6];
            tempSide[7] = sides[side].cells[7];
            tempSide[8] = sides[side].cells[8];
            sides[side].cells[0] = tempSide[2];
            sides[side].cells[1] = tempSide[5];
            sides[side].cells[2] = tempSide[8];
            sides[side].cells[3] = tempSide[1];
            sides[side].cells[5] = tempSide[7];
            sides[side].cells[6] = tempSide[0];
            sides[side].cells[7] = tempSide[3];
            sides[side].cells[8] = tempSide[6];
        } else {
            tempSide[0] = sides[side].cells[0];
            tempSide[1] = sides[side].cells[1];
            tempSide[2] = sides[side].cells[2];
            tempSide[3] = sides[side].cells[3];
            tempSide[4] = sides[side].cells[4];
            tempSide[5] = sides[side].cells[5];
            tempSide[6] = sides[side].cells[6];
            tempSide[7] = sides[side].cells[7];
            tempSide[8] = sides[side].cells[8];
            sides[side].cells[0] = tempSide[6];
            sides[side].cells[1] = tempSide[3];
            sides[side].cells[2] = tempSide[0];
            sides[side].cells[3] = tempSide[7];
            sides[side].cells[5] = tempSide[1];
            sides[side].cells[6] = tempSide[8];
            sides[side].cells[7] = tempSide[5];
            sides[side].cells[8] = tempSide[2];
        }
    }

    void turn(String turn) {
        Cell[] tempCells = new Cell[12];

        switch (turn) {
            case "F":
                tempCells[0] = sides[0].cells[6];
                tempCells[1] = sides[0].cells[7];
                tempCells[2] = sides[0].cells[8];
                tempCells[3] = sides[1].cells[6];
                tempCells[4] = sides[1].cells[7];
                tempCells[5] = sides[1].cells[8];
                tempCells[6] = sides[5].cells[2];
                tempCells[7] = sides[5].cells[1];
                tempCells[8] = sides[5].cells[0];
                tempCells[9] = sides[2].cells[6];
                tempCells[10] = sides[2].cells[7];
                tempCells[11] = sides[2].cells[8];
                sides[0].cells[6] = tempCells[9];
                sides[0].cells[7] = tempCells[10];
                sides[0].cells[8] = tempCells[11];
                sides[1].cells[6] = tempCells[0];
                sides[1].cells[7] = tempCells[1];
                sides[1].cells[8] = tempCells[2];
                sides[5].cells[2] = tempCells[3];
                sides[5].cells[1] = tempCells[4];
                sides[5].cells[0] = tempCells[5];
                sides[2].cells[6] = tempCells[6];
                sides[2].cells[7] = tempCells[7];
                sides[2].cells[8] = tempCells[8];
                sideTurn(4, false);
                break;
            case "F'":
                for (int i = 0; i < 3; i++) turn("F");
                break;
            case "B":
                for (int i = 0; i < 3; i++) turn("B'");
                break;
            case "B'":
                tempCells[0] = sides[0].cells[0];
                tempCells[1] = sides[0].cells[1];
                tempCells[2] = sides[0].cells[2];
                tempCells[3] = sides[1].cells[0];
                tempCells[4] = sides[1].cells[1];
                tempCells[5] = sides[1].cells[2];
                tempCells[6] = sides[5].cells[8];
                tempCells[7] = sides[5].cells[7];
                tempCells[8] = sides[5].cells[6];
                tempCells[9] = sides[2].cells[0];
                tempCells[10] = sides[2].cells[1];
                tempCells[11] = sides[2].cells[2];
                sides[0].cells[0] = tempCells[9];
                sides[0].cells[1] = tempCells[10];
                sides[0].cells[2] = tempCells[11];
                sides[1].cells[0] = tempCells[0];
                sides[1].cells[1] = tempCells[1];
                sides[1].cells[2] = tempCells[2];
                sides[5].cells[8] = tempCells[3];
                sides[5].cells[7] = tempCells[4];
                sides[5].cells[6] = tempCells[5];
                sides[2].cells[0] = tempCells[6];
                sides[2].cells[1] = tempCells[7];
                sides[2].cells[2] = tempCells[8];
                sideTurn(3, true);
                break;
            case "L":
                tempCells[0] = sides[0].cells[0];
                tempCells[1] = sides[0].cells[3];
                tempCells[2] = sides[0].cells[6];
                tempCells[3] = sides[4].cells[0];
                tempCells[4] = sides[4].cells[3];
                tempCells[5] = sides[4].cells[6];
                tempCells[6] = sides[5].cells[0];
                tempCells[7] = sides[5].cells[3];
                tempCells[8] = sides[5].cells[6];
                tempCells[9] = sides[3].cells[0];
                tempCells[10] = sides[3].cells[3];
                tempCells[11] = sides[3].cells[6];
                sides[0].cells[0] = tempCells[9];
                sides[0].cells[3] = tempCells[10];
                sides[0].cells[6] = tempCells[11];
                sides[4].cells[0] = tempCells[0];
                sides[4].cells[3] = tempCells[1];
                sides[4].cells[6] = tempCells[2];
                sides[5].cells[0] = tempCells[3];
                sides[5].cells[3] = tempCells[4];
                sides[5].cells[6] = tempCells[5];
                sides[3].cells[0] = tempCells[6];
                sides[3].cells[3] = tempCells[7];
                sides[3].cells[6] = tempCells[8];
                sideTurn(2, false);
                break;
            case "L'":
                for (int i = 0; i < 3; i++) turn("L");
                break;
            case "R":
                for (int i = 0; i < 3; i++) turn("R'");
                break;
            case "R'":
                tempCells[0] = sides[0].cells[2];
                tempCells[1] = sides[0].cells[5];
                tempCells[2] = sides[0].cells[8];
                tempCells[3] = sides[4].cells[2];
                tempCells[4] = sides[4].cells[5];
                tempCells[5] = sides[4].cells[8];
                tempCells[6] = sides[5].cells[2];
                tempCells[7] = sides[5].cells[5];
                tempCells[8] = sides[5].cells[8];
                tempCells[9] = sides[3].cells[2];
                tempCells[10] = sides[3].cells[5];
                tempCells[11] = sides[3].cells[8];
                sides[0].cells[2] = tempCells[9];
                sides[0].cells[5] = tempCells[10];
                sides[0].cells[8] = tempCells[11];
                sides[4].cells[2] = tempCells[0];
                sides[4].cells[5] = tempCells[1];
                sides[4].cells[8] = tempCells[2];
                sides[5].cells[2] = tempCells[3];
                sides[5].cells[5] = tempCells[4];
                sides[5].cells[8] = tempCells[5];
                sides[3].cells[2] = tempCells[6];
                sides[3].cells[5] = tempCells[7];
                sides[3].cells[8] = tempCells[8];
                sideTurn(1, true);
                break;
            case "U":
                for (int i = 0; i < 3; i++) turn("U'");
                break;
            case "U'":
                tempCells[0] = sides[4].cells[0];
                tempCells[1] = sides[4].cells[1];
                tempCells[2] = sides[4].cells[2];
                tempCells[3] = sides[1].cells[6];
                tempCells[4] = sides[1].cells[3];
                tempCells[5] = sides[1].cells[0];
                tempCells[6] = sides[3].cells[8];
                tempCells[7] = sides[3].cells[7];
                tempCells[8] = sides[3].cells[6];
                tempCells[9] = sides[2].cells[2];
                tempCells[10] = sides[2].cells[5];
                tempCells[11] = sides[2].cells[8];
                sides[4].cells[0] = tempCells[9];
                sides[4].cells[1] = tempCells[10];
                sides[4].cells[2] = tempCells[11];
                sides[1].cells[6] = tempCells[0];
                sides[1].cells[3] = tempCells[1];
                sides[1].cells[0] = tempCells[2];
                sides[3].cells[8] = tempCells[3];
                sides[3].cells[7] = tempCells[4];
                sides[3].cells[6] = tempCells[5];
                sides[2].cells[2] = tempCells[6];
                sides[2].cells[5] = tempCells[7];
                sides[2].cells[8] = tempCells[8];
                sideTurn(0, true);
                break;
            case "D":
                tempCells[0] = sides[4].cells[6];
                tempCells[1] = sides[4].cells[7];
                tempCells[2] = sides[4].cells[8];
                tempCells[3] = sides[1].cells[8];
                tempCells[4] = sides[1].cells[5];
                tempCells[5] = sides[1].cells[2];
                tempCells[6] = sides[3].cells[2];
                tempCells[7] = sides[3].cells[1];
                tempCells[8] = sides[3].cells[0];
                tempCells[9] = sides[2].cells[0];
                tempCells[10] = sides[2].cells[3];
                tempCells[11] = sides[2].cells[6];
                sides[4].cells[6] = tempCells[9];
                sides[4].cells[7] = tempCells[10];
                sides[4].cells[8] = tempCells[11];
                sides[1].cells[8] = tempCells[0];
                sides[1].cells[5] = tempCells[1];
                sides[1].cells[2] = tempCells[2];
                sides[3].cells[2] = tempCells[3];
                sides[3].cells[1] = tempCells[4];
                sides[3].cells[0] = tempCells[5];
                sides[2].cells[0] = tempCells[6];
                sides[2].cells[3] = tempCells[7];
                sides[2].cells[6] = tempCells[8];
                sideTurn(5, false);
                break;
            case "D'":
                for (int i = 0; i < 3; i++) turn("D");
                break;
        }
    }
}

