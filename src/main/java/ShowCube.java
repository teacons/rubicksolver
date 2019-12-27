import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Dec 20 05:11:26 MSK 2019
 */


/**
 * @author unknown
 */
class ShowCube extends JFrame {
    private Cube cube = new Cube();
    private Cube.Color[] colorBut = new Cube.Color[54];

    ShowCube() {

        initComponents();
        MainFrame.setName("MainFrame");
        MainPanel.setName("MainPanel");
        setContentPane(MainPanel);
        update();
    }

    private void update() {
        ArrayList<JButton> buttons = new ArrayList<>(Arrays.asList(side0_cell0, side0_cell1, side0_cell2, side0_cell3, side0_cell4, side0_cell5, side0_cell6, side0_cell7, side0_cell8, side1_cell0, side1_cell1, side1_cell2, side1_cell3, side1_cell4, side1_cell5, side1_cell6, side1_cell7, side1_cell8, side2_cell0, side2_cell1, side2_cell2, side2_cell3, side2_cell4, side2_cell5, side2_cell6, side2_cell7, side2_cell8, side3_cell0, side3_cell1, side3_cell2, side3_cell3, side3_cell4, side3_cell5, side3_cell6, side3_cell7, side3_cell8, side4_cell0, side4_cell1, side4_cell2, side4_cell3, side4_cell4, side4_cell5, side4_cell6, side4_cell7, side4_cell8, side5_cell0, side5_cell1, side5_cell2, side5_cell3, side5_cell4, side5_cell5, side5_cell6, side5_cell7, side5_cell8));
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                JButton objButton = buttons.get(i * 9 + j);
                switch (cube.sides[i].cells[j].color) {
                    case BLUE:
                        objButton.setBackground(Color.blue);
                        colorBut[i * 9 + j] = Cube.Color.BLUE;
                        break;
                    case WHITE:
                        objButton.setBackground(Color.white);
                        colorBut[i * 9 + j] = Cube.Color.WHITE;
                        break;
                    case ORANGE:
                        objButton.setBackground(Color.orange);
                        colorBut[i * 9 + j] = Cube.Color.ORANGE;
                        break;
                    case YELLOW:
                        objButton.setBackground(Color.yellow);
                        colorBut[i * 9 + j] = Cube.Color.YELLOW;
                        break;
                    case RED:
                        objButton.setBackground(Color.red);
                        colorBut[i * 9 + j] = Cube.Color.RED;
                        break;
                    case GREEN:
                        objButton.setBackground(Color.green);
                        colorBut[i * 9 + j] = Cube.Color.GREEN;
                        break;
                }
            }
        }
    }

    private void FMouseClicked(MouseEvent e) {
        cube.turn("F");
        update();
    }

    private void FreverseMouseClicked(MouseEvent e) {
        cube.turn("F'");
        update();
    }

    private void BMouseClicked(MouseEvent e) {
        cube.turn("B");
        update();
    }

    private void BreverseMouseClicked(MouseEvent e) {
        cube.turn("B'");
        update();
    }

    private void LMouseClicked(MouseEvent e) {
        cube.turn("L");
        update();
    }

    private void LreverseMouseClicked(MouseEvent e) {
        cube.turn("L'");
        update();
    }

    private void RMouseClicked(MouseEvent e) {
        cube.turn("R");
        update();
    }

    private void RreverseMouseClicked(MouseEvent e) {
        cube.turn("R'");
        update();
    }

    private void UMouseClicked(MouseEvent e) {
        cube.turn("U");
        update();
    }

    private void UreverseMouseClicked(MouseEvent e) {
        cube.turn("U'");
        update();
    }

    private void DMouseClicked(MouseEvent e) {
        cube.turn("D");
        update();
    }

    private void DreverseMouseClicked(MouseEvent e) {
        cube.turn("D'");
        update();
    }

    private void randomMouseClicked(MouseEvent e) {
        cube = new Cube();
        solve.setVisible(true);
        random.setText("Rerandom");
        if (lentghScramble.getText().matches("[-+]?\\d+"))
            scramble.setText(cube.shuffle(Integer.parseInt(lentghScramble.getText())));
        else scramble.setText(cube.shuffle(20));
        solveText.setText("");
        System.out.println(scramble.getText());
        update();
    }

    private void solveMouseClicked(MouseEvent e) {
        Solver solver = new Solver(cube);
        solveText.setText(solver.solve());
        update();
    }

    private void buttonsMouseClicked(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        int intButName = Integer.parseInt(btn.getName());
        switch (colorBut[intButName]) {
            case WHITE:
                btn.setBackground(Color.orange);
                colorBut[Integer.parseInt(btn.getName())] = Cube.Color.ORANGE;
                cube.sides[intButName / 9].cells[intButName % 9].color = Cube.Color.ORANGE;
                break;
            case ORANGE:
                btn.setBackground(Color.red);
                colorBut[Integer.parseInt(btn.getName())] = Cube.Color.RED;
                cube.sides[intButName / 9].cells[intButName % 9].color = Cube.Color.RED;
                break;
            case RED:
                btn.setBackground(Color.green);
                colorBut[Integer.parseInt(btn.getName())] = Cube.Color.GREEN;
                cube.sides[intButName / 9].cells[intButName % 9].color = Cube.Color.GREEN;
                break;
            case GREEN:
                btn.setBackground(Color.blue);
                colorBut[Integer.parseInt(btn.getName())] = Cube.Color.BLUE;
                cube.sides[intButName / 9].cells[intButName % 9].color = Cube.Color.BLUE;
                break;
            case BLUE:
                btn.setBackground(Color.yellow);
                colorBut[Integer.parseInt(btn.getName())] = Cube.Color.YELLOW;
                cube.sides[intButName / 9].cells[intButName % 9].color = Cube.Color.YELLOW;
                break;
            case YELLOW:
                btn.setBackground(Color.white);
                colorBut[Integer.parseInt(btn.getName())] = Cube.Color.WHITE;
                cube.sides[intButName / 9].cells[intButName % 9].color = Cube.Color.WHITE;
                break;
        }
    }

    private void lentghScrambleMouseClicked(MouseEvent e) {
        lentghScramble.setText("");
    }

    private void lentghScrambleFocusLost(FocusEvent e) {
        if (!lentghScramble.getText().matches("[-+]?\\d+")) lentghScramble.setText("Input length of scamble:");
    }

    private void customMouseClicked(MouseEvent e) {
        cube = new Cube();
        String[] temp = customField.getText().split(" ");
        solve.setVisible(true);
        random.setText("Restart");
        solveText.setText("");
        scramble.setText(customField.getText());
        for (String i : temp) {
            cube.turn(i);
        }
        update();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - igor
        MainFrame = new JFrame();
        MainPanel = new JPanel();
        side0_cell0 = new JButton();
        side0_cell1 = new JButton();
        side0_cell2 = new JButton();
        side0_cell3 = new JButton();
        side0_cell4 = new JButton();
        side0_cell5 = new JButton();
        side0_cell6 = new JButton();
        side0_cell7 = new JButton();
        side0_cell8 = new JButton();
        side1_cell0 = new JButton();
        side1_cell1 = new JButton();
        side1_cell2 = new JButton();
        side1_cell3 = new JButton();
        side1_cell4 = new JButton();
        side1_cell5 = new JButton();
        side1_cell6 = new JButton();
        side1_cell7 = new JButton();
        side1_cell8 = new JButton();
        side2_cell0 = new JButton();
        side2_cell1 = new JButton();
        side2_cell2 = new JButton();
        side2_cell3 = new JButton();
        side2_cell4 = new JButton();
        side2_cell5 = new JButton();
        side2_cell6 = new JButton();
        side2_cell7 = new JButton();
        side2_cell8 = new JButton();
        side3_cell0 = new JButton();
        side3_cell1 = new JButton();
        side3_cell2 = new JButton();
        side3_cell3 = new JButton();
        side3_cell4 = new JButton();
        side3_cell5 = new JButton();
        side3_cell6 = new JButton();
        side3_cell7 = new JButton();
        side3_cell8 = new JButton();
        side4_cell0 = new JButton();
        side4_cell1 = new JButton();
        side4_cell2 = new JButton();
        side4_cell3 = new JButton();
        side4_cell4 = new JButton();
        side4_cell5 = new JButton();
        side4_cell6 = new JButton();
        side4_cell7 = new JButton();
        side4_cell8 = new JButton();
        side5_cell0 = new JButton();
        side5_cell1 = new JButton();
        side5_cell2 = new JButton();
        side5_cell3 = new JButton();
        side5_cell4 = new JButton();
        side5_cell5 = new JButton();
        side5_cell6 = new JButton();
        side5_cell7 = new JButton();
        side5_cell8 = new JButton();
        F = new JButton();
        Freverse = new JButton();
        B = new JButton();
        Breverse = new JButton();
        L = new JButton();
        Lreverse = new JButton();
        R = new JButton();
        Rreverse = new JButton();
        U = new JButton();
        Ureverse = new JButton();
        D = new JButton();
        Dreverse = new JButton();
        random = new JButton();
        scramble = new JLabel();
        solve = new JButton();
        lentghScramble = new JTextField();
        customField = new JTextField();
        custom = new JButton();
        scrollPane1 = new JScrollPane();
        solveText = new JTextPane();

        //======== MainFrame ========
        {
            MainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            var MainFrameContentPane = MainFrame.getContentPane();
            MainFrameContentPane.setLayout(null);

            //======== MainPanel ========
            {
                MainPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
                (0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing.border
                .TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
                .Color.red),MainPanel. getBorder()));MainPanel. addPropertyChangeListener(e -> {if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
                ;});
                MainPanel.setLayout(null);

                //---- side0_cell0 ----
                side0_cell0.setName("0");
                side0_cell0.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side0_cell0);
                side0_cell0.setBounds(345, 240, 40, 40);

                //---- side0_cell1 ----
                side0_cell1.setName("1");
                side0_cell1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side0_cell1);
                side0_cell1.setBounds(390, 240, 40, 40);

                //---- side0_cell2 ----
                side0_cell2.setName("2");
                side0_cell2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side0_cell2);
                side0_cell2.setBounds(435, 240, 40, 40);

                //---- side0_cell3 ----
                side0_cell3.setName("3");
                side0_cell3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side0_cell3);
                side0_cell3.setBounds(345, 285, 40, 40);

                //---- side0_cell4 ----
                side0_cell4.setName("4");
                side0_cell4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side0_cell4);
                side0_cell4.setBounds(390, 285, 40, 40);

                //---- side0_cell5 ----
                side0_cell5.setName("5");
                side0_cell5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side0_cell5);
                side0_cell5.setBounds(435, 285, 40, 40);

                //---- side0_cell6 ----
                side0_cell6.setName("6");
                side0_cell6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side0_cell6);
                side0_cell6.setBounds(345, 330, 40, 40);

                //---- side0_cell7 ----
                side0_cell7.setName("7");
                side0_cell7.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side0_cell7);
                side0_cell7.setBounds(390, 330, 40, 40);

                //---- side0_cell8 ----
                side0_cell8.setName("8");
                side0_cell8.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side0_cell8);
                side0_cell8.setBounds(435, 330, 40, 40);

                //---- side1_cell0 ----
                side1_cell0.setName("9");
                side1_cell0.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side1_cell0);
                side1_cell0.setBounds(515, 240, 40, 40);

                //---- side1_cell1 ----
                side1_cell1.setName("10");
                side1_cell1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side1_cell1);
                side1_cell1.setBounds(560, 240, 40, 40);

                //---- side1_cell2 ----
                side1_cell2.setName("11");
                side1_cell2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side1_cell2);
                side1_cell2.setBounds(605, 240, 40, 40);

                //---- side1_cell3 ----
                side1_cell3.setName("12");
                side1_cell3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side1_cell3);
                side1_cell3.setBounds(515, 285, 40, 40);

                //---- side1_cell4 ----
                side1_cell4.setName("13");
                side1_cell4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side1_cell4);
                side1_cell4.setBounds(560, 285, 40, 40);

                //---- side1_cell5 ----
                side1_cell5.setName("14");
                side1_cell5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side1_cell5);
                side1_cell5.setBounds(605, 285, 40, 40);

                //---- side1_cell6 ----
                side1_cell6.setName("15");
                side1_cell6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side1_cell6);
                side1_cell6.setBounds(515, 330, 40, 40);

                //---- side1_cell7 ----
                side1_cell7.setName("16");
                side1_cell7.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side1_cell7);
                side1_cell7.setBounds(560, 330, 40, 40);

                //---- side1_cell8 ----
                side1_cell8.setName("17");
                side1_cell8.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side1_cell8);
                side1_cell8.setBounds(605, 330, 40, 40);

                //---- side2_cell0 ----
                side2_cell0.setName("18");
                side2_cell0.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side2_cell0);
                side2_cell0.setBounds(175, 240, 40, 40);

                //---- side2_cell1 ----
                side2_cell1.setName("19");
                side2_cell1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side2_cell1);
                side2_cell1.setBounds(220, 240, 40, 40);

                //---- side2_cell2 ----
                side2_cell2.setName("20");
                side2_cell2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side2_cell2);
                side2_cell2.setBounds(265, 240, 40, 40);

                //---- side2_cell3 ----
                side2_cell3.setName("21");
                side2_cell3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side2_cell3);
                side2_cell3.setBounds(175, 285, 40, 40);

                //---- side2_cell4 ----
                side2_cell4.setName("22");
                side2_cell4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side2_cell4);
                side2_cell4.setBounds(220, 285, 40, 40);

                //---- side2_cell5 ----
                side2_cell5.setName("23");
                side2_cell5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side2_cell5);
                side2_cell5.setBounds(265, 285, 40, 40);

                //---- side2_cell6 ----
                side2_cell6.setName("24");
                side2_cell6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side2_cell6);
                side2_cell6.setBounds(175, 330, 40, 40);

                //---- side2_cell7 ----
                side2_cell7.setName("25");
                side2_cell7.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side2_cell7);
                side2_cell7.setBounds(220, 330, 40, 40);

                //---- side2_cell8 ----
                side2_cell8.setName("26");
                side2_cell8.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side2_cell8);
                side2_cell8.setBounds(265, 330, 40, 40);

                //---- side3_cell0 ----
                side3_cell0.setName("27");
                side3_cell0.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side3_cell0);
                side3_cell0.setBounds(345, 90, 40, 40);

                //---- side3_cell1 ----
                side3_cell1.setName("28");
                side3_cell1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side3_cell1);
                side3_cell1.setBounds(390, 90, 40, 40);

                //---- side3_cell2 ----
                side3_cell2.setName("29");
                side3_cell2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side3_cell2);
                side3_cell2.setBounds(435, 90, 40, 40);

                //---- side3_cell3 ----
                side3_cell3.setName("30");
                side3_cell3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side3_cell3);
                side3_cell3.setBounds(345, 135, 40, 40);

                //---- side3_cell4 ----
                side3_cell4.setName("31");
                side3_cell4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side3_cell4);
                side3_cell4.setBounds(390, 135, 40, 40);

                //---- side3_cell5 ----
                side3_cell5.setName("32");
                side3_cell5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side3_cell5);
                side3_cell5.setBounds(435, 135, 40, 40);

                //---- side3_cell6 ----
                side3_cell6.setName("33");
                side3_cell6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side3_cell6);
                side3_cell6.setBounds(345, 180, 40, 40);

                //---- side3_cell7 ----
                side3_cell7.setName("34");
                side3_cell7.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side3_cell7);
                side3_cell7.setBounds(390, 180, 40, 40);

                //---- side3_cell8 ----
                side3_cell8.setName("35");
                side3_cell8.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side3_cell8);
                side3_cell8.setBounds(435, 180, 40, 40);

                //---- side4_cell0 ----
                side4_cell0.setName("36");
                side4_cell0.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side4_cell0);
                side4_cell0.setBounds(345, 395, 40, 40);

                //---- side4_cell1 ----
                side4_cell1.setName("37");
                side4_cell1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side4_cell1);
                side4_cell1.setBounds(390, 395, 40, 40);

                //---- side4_cell2 ----
                side4_cell2.setName("38");
                side4_cell2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side4_cell2);
                side4_cell2.setBounds(435, 395, 40, 40);

                //---- side4_cell3 ----
                side4_cell3.setName("39");
                side4_cell3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side4_cell3);
                side4_cell3.setBounds(345, 440, 40, 40);

                //---- side4_cell4 ----
                side4_cell4.setName("40");
                side4_cell4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side4_cell4);
                side4_cell4.setBounds(390, 440, 40, 40);

                //---- side4_cell5 ----
                side4_cell5.setName("41");
                side4_cell5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side4_cell5);
                side4_cell5.setBounds(435, 440, 40, 40);

                //---- side4_cell6 ----
                side4_cell6.setName("42");
                side4_cell6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side4_cell6);
                side4_cell6.setBounds(345, 485, 40, 40);

                //---- side4_cell7 ----
                side4_cell7.setName("43");
                side4_cell7.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side4_cell7);
                side4_cell7.setBounds(390, 485, 40, 40);

                //---- side4_cell8 ----
                side4_cell8.setName("44");
                side4_cell8.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side4_cell8);
                side4_cell8.setBounds(435, 485, 40, 40);

                //---- side5_cell0 ----
                side5_cell0.setName("45");
                side5_cell0.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side5_cell0);
                side5_cell0.setBounds(345, 540, 40, 40);

                //---- side5_cell1 ----
                side5_cell1.setName("46");
                side5_cell1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side5_cell1);
                side5_cell1.setBounds(390, 540, 40, 40);

                //---- side5_cell2 ----
                side5_cell2.setName("47");
                side5_cell2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side5_cell2);
                side5_cell2.setBounds(435, 540, 40, 40);

                //---- side5_cell3 ----
                side5_cell3.setName("48");
                side5_cell3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side5_cell3);
                side5_cell3.setBounds(345, 585, 40, 40);

                //---- side5_cell4 ----
                side5_cell4.setName("49");
                side5_cell4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side5_cell4);
                side5_cell4.setBounds(390, 585, 40, 40);

                //---- side5_cell5 ----
                side5_cell5.setName("50");
                side5_cell5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side5_cell5);
                side5_cell5.setBounds(435, 585, 40, 40);

                //---- side5_cell6 ----
                side5_cell6.setName("51");
                side5_cell6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side5_cell6);
                side5_cell6.setBounds(345, 630, 40, 40);

                //---- side5_cell7 ----
                side5_cell7.setName("52");
                side5_cell7.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side5_cell7);
                side5_cell7.setBounds(390, 630, 40, 40);

                //---- side5_cell8 ----
                side5_cell8.setName("53");
                side5_cell8.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        buttonsMouseClicked(e);
                    }
                });
                MainPanel.add(side5_cell8);
                side5_cell8.setBounds(435, 630, 40, 40);

                //---- F ----
                F.setText("F");
                F.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        FMouseClicked(e);
                    }
                });
                MainPanel.add(F);
                F.setBounds(735, 30, 50, 25);

                //---- Freverse ----
                Freverse.setText("F'");
                Freverse.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        FreverseMouseClicked(e);
                    }
                });
                MainPanel.add(Freverse);
                Freverse.setBounds(795, 30, 50, 25);

                //---- B ----
                B.setText("B");
                B.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        BMouseClicked(e);
                    }
                });
                MainPanel.add(B);
                B.setBounds(735, 65, 50, 25);

                //---- Breverse ----
                Breverse.setText("B'");
                Breverse.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        BreverseMouseClicked(e);
                    }
                });
                MainPanel.add(Breverse);
                Breverse.setBounds(795, 65, 50, 25);

                //---- L ----
                L.setText("L");
                L.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        LMouseClicked(e);
                    }
                });
                MainPanel.add(L);
                L.setBounds(735, 100, 50, 25);

                //---- Lreverse ----
                Lreverse.setText("L'");
                Lreverse.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        LreverseMouseClicked(e);
                    }
                });
                MainPanel.add(Lreverse);
                Lreverse.setBounds(795, 100, 50, 25);

                //---- R ----
                R.setText("R");
                R.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        RMouseClicked(e);
                    }
                });
                MainPanel.add(R);
                R.setBounds(735, 135, 50, 25);

                //---- Rreverse ----
                Rreverse.setText("R'");
                Rreverse.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        RreverseMouseClicked(e);
                    }
                });
                MainPanel.add(Rreverse);
                Rreverse.setBounds(795, 135, 50, 25);

                //---- U ----
                U.setText("U");
                U.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        UMouseClicked(e);
                    }
                });
                MainPanel.add(U);
                U.setBounds(735, 170, 50, 25);

                //---- Ureverse ----
                Ureverse.setText("U'");
                Ureverse.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        UreverseMouseClicked(e);
                    }
                });
                MainPanel.add(Ureverse);
                Ureverse.setBounds(795, 170, 50, 25);

                //---- D ----
                D.setText("D");
                D.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        DMouseClicked(e);
                    }
                });
                MainPanel.add(D);
                D.setBounds(735, 205, 50, 25);

                //---- Dreverse ----
                Dreverse.setText("D'");
                Dreverse.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        DreverseMouseClicked(e);
                    }
                });
                MainPanel.add(Dreverse);
                Dreverse.setBounds(795, 205, 50, 25);

                //---- random ----
                random.setText("Random");
                random.setFont(random.getFont().deriveFont(random.getFont().getStyle() | Font.BOLD, random.getFont().getSize() + 10f));
                random.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        randomMouseClicked(e);
                    }
                });
                MainPanel.add(random);
                random.setBounds(725, 525, 155, 65);

                //---- scramble ----
                scramble.setFont(scramble.getFont().deriveFont(scramble.getFont().getStyle() | Font.BOLD, scramble.getFont().getSize() + 4f));
                MainPanel.add(scramble);
                scramble.setBounds(25, 680, 910, 30);

                //---- solve ----
                solve.setText("Solve");
                solve.setFont(solve.getFont().deriveFont(solve.getFont().getStyle() | Font.BOLD, solve.getFont().getSize() + 10f));
                solve.setVisible(false);
                solve.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        solveMouseClicked(e);
                    }
                });
                MainPanel.add(solve);
                solve.setBounds(725, 610, 155, 65);

                //---- lentghScramble ----
                lentghScramble.setText("Input length of scramble:");
                lentghScramble.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        lentghScrambleMouseClicked(e);
                    }
                });
                lentghScramble.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        lentghScrambleFocusLost(e);
                    }
                });
                MainPanel.add(lentghScramble);
                lentghScramble.setBounds(725, 490, 155, lentghScramble.getPreferredSize().height);
                MainPanel.add(customField);
                customField.setBounds(25, 15, 535, customField.getPreferredSize().height);

                //---- custom ----
                custom.setText("Custom");
                custom.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        customMouseClicked(e);
                    }
                });
                MainPanel.add(custom);
                custom.setBounds(new Rectangle(new Point(510, 50), custom.getPreferredSize()));

                //======== scrollPane1 ========
                {

                    //---- solveText ----
                    solveText.setBackground(new Color(240, 240, 240));
                    scrollPane1.setViewportView(solveText);
                }
                MainPanel.add(scrollPane1);
                scrollPane1.setBounds(15, 720, 925, 160);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < MainPanel.getComponentCount(); i++) {
                        Rectangle bounds = MainPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = MainPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    MainPanel.setMinimumSize(preferredSize);
                    MainPanel.setPreferredSize(preferredSize);
                }
            }
            MainFrameContentPane.add(MainPanel);
            MainPanel.setBounds(10, 10, 955, 895);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < MainFrameContentPane.getComponentCount(); i++) {
                    Rectangle bounds = MainFrameContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = MainFrameContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                MainFrameContentPane.setMinimumSize(preferredSize);
                MainFrameContentPane.setPreferredSize(preferredSize);
            }
            MainFrame.pack();
            MainFrame.setLocationRelativeTo(MainFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - igor
    private JFrame MainFrame;
    private JPanel MainPanel;
    private JButton side0_cell0;
    private JButton side0_cell1;
    private JButton side0_cell2;
    private JButton side0_cell3;
    private JButton side0_cell4;
    private JButton side0_cell5;
    private JButton side0_cell6;
    private JButton side0_cell7;
    private JButton side0_cell8;
    private JButton side1_cell0;
    private JButton side1_cell1;
    private JButton side1_cell2;
    private JButton side1_cell3;
    private JButton side1_cell4;
    private JButton side1_cell5;
    private JButton side1_cell6;
    private JButton side1_cell7;
    private JButton side1_cell8;
    private JButton side2_cell0;
    private JButton side2_cell1;
    private JButton side2_cell2;
    private JButton side2_cell3;
    private JButton side2_cell4;
    private JButton side2_cell5;
    private JButton side2_cell6;
    private JButton side2_cell7;
    private JButton side2_cell8;
    private JButton side3_cell0;
    private JButton side3_cell1;
    private JButton side3_cell2;
    private JButton side3_cell3;
    private JButton side3_cell4;
    private JButton side3_cell5;
    private JButton side3_cell6;
    private JButton side3_cell7;
    private JButton side3_cell8;
    private JButton side4_cell0;
    private JButton side4_cell1;
    private JButton side4_cell2;
    private JButton side4_cell3;
    private JButton side4_cell4;
    private JButton side4_cell5;
    private JButton side4_cell6;
    private JButton side4_cell7;
    private JButton side4_cell8;
    private JButton side5_cell0;
    private JButton side5_cell1;
    private JButton side5_cell2;
    private JButton side5_cell3;
    private JButton side5_cell4;
    private JButton side5_cell5;
    private JButton side5_cell6;
    private JButton side5_cell7;
    private JButton side5_cell8;
    private JButton F;
    private JButton Freverse;
    private JButton B;
    private JButton Breverse;
    private JButton L;
    private JButton Lreverse;
    private JButton R;
    private JButton Rreverse;
    private JButton U;
    private JButton Ureverse;
    private JButton D;
    private JButton Dreverse;
    private JButton random;
    private JLabel scramble;
    private JButton solve;
    private JTextField lentghScramble;
    private JTextField customField;
    private JButton custom;
    private JScrollPane scrollPane1;
    private JTextPane solveText;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
