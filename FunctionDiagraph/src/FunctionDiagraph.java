/**
 * Created by WangGuanyu on 16/3/1.
 */

//FunctionDiagraph.java

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.TitledBorder;

public class FunctionDiagraph extends JFrame {
    //Create text field for input f(x) and output result
    private JTextArea jtaFunction = new JTextArea(1, 10);
    private JTextArea jtaResult = new JTextArea(1, 10);
    private JTextArea jtaX = new JTextArea(1,5);

    private JTextArea jtaNumberFirst = new JTextArea(1, 5);
    private JTextArea jtaNumberFinal = new JTextArea(1, 5);

    //A Boolean variable for transforming keyboard
    private Boolean KeyboardTransformer = true;

    //Two integer variable for number form
    private int FormFirst = 0;
    private int FormFinal = 0;

    //Create radio buttons for transforming keyboard
    private JRadioButton jrbFx = new JRadioButton("f(x)");
    private JRadioButton jrbX = new JRadioButton("x");

    //Create radio buttons for selecting number form
    private JRadioButton jrb2First = new JRadioButton("二进制");
    private JRadioButton jrb8First = new JRadioButton("八进制");
    private JRadioButton jrb10First = new JRadioButton("十进制");
    private JRadioButton jrb16First = new JRadioButton("十六进制");

    private JRadioButton jrb2Final = new JRadioButton("二进制");
    private JRadioButton jrb8Final = new JRadioButton("八进制");
    private JRadioButton jrb10Final = new JRadioButton("十进制");
    private JRadioButton jrb16Final = new JRadioButton("十六进制");

    //Create buttons
    private JButton jbtConverse = new JButton("—Converse—>");
    private JButton jbtBracket1 = new JButton("(");
    private JButton jbtBracket2 = new JButton(")");
    private JButton jbtPlus = new JButton("+");
    private JButton jbtMinus = new JButton("-");
    private JButton jbtMultiply = new JButton("*");
    private JButton jbtDivide = new JButton("/");
    private JButton jbtPower = new JButton("^");
    private JButton jbtPi = new JButton("π");
    private JButton jbtE = new JButton("e");
    private JButton jbtX = new JButton("x");
    private JButton jbtSin = new JButton("sin(");
    private JButton jbtCos = new JButton("cos(");
    private JButton jbtTan = new JButton("tan(");
    private JButton jbtAsin = new JButton("arcsin(");
    private JButton jbtAcos = new JButton("arccos(");
    private JButton jbtAtan = new JButton("arctan(");
    private JButton jbtLog = new JButton("log(");
    private JButton jbtPlotting = new JButton("Plotting");
    private JButton jbtEmpty = new JButton("Empty");
    private JButton jbtCalculate = new JButton("Calculate");

    //Create Slider to control value
    private JSlider jsldValue = new JSlider(1, 10, 1);


    //Create PlotPanel to plotting
    private PlotPanel plPanel = new PlotPanel();

    public FunctionDiagraph() {
        //Panel p1 to hold text field for f(x)
        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(new Label("f(x)="), BorderLayout.WEST);
        p1.add(jtaFunction, BorderLayout.CENTER);
        p1.add(jbtEmpty, BorderLayout.EAST);

        //Create a radio-button group to group four buttons
        ButtonGroup groupLeft = new ButtonGroup();
        groupLeft.add(jrb2First);
        groupLeft.add(jrb8First);
        groupLeft.add(jrb10First);
        groupLeft.add(jrb16First);

        //Create a radio-button group to group four buttons
        ButtonGroup groupRight = new ButtonGroup();
        groupRight.add(jrb2Final);
        groupRight.add(jrb8Final);
        groupRight.add(jrb10Final);
        groupRight.add(jrb16Final);


        //Panel p12 to hold  left radio buttons
        JPanel p12 = new JPanel(new GridLayout(2, 2));
        p12.add(jrb2First);
        p12.add(jrb8First);
        p12.add(jrb10First);
        p12.add(jrb16First);

        //Panel p13 to hold right radio buttons
        JPanel p13 = new JPanel(new GridLayout(2, 2));
        p13.add(jrb2Final);
        p13.add(jrb8Final);
        p13.add(jrb10Final);
        p13.add(jrb16Final);

        //Panel p14
        JPanel p14 = new JPanel(new BorderLayout());
        p14.add(jtaNumberFirst, BorderLayout.NORTH);
        p14.add(p12, BorderLayout.CENTER);
        p14.setBorder(new TitledBorder("Enter integer number"));

        //Panel p15
        JPanel p15 = new JPanel(new BorderLayout());
        p15.add(jtaNumberFinal, BorderLayout.NORTH);
        p15.add(p13, BorderLayout.CENTER);
        p15.setBorder(new TitledBorder("Output"));

        //Panel p16
        JPanel p16 = new JPanel(new BorderLayout());
        p16.add(p14, BorderLayout.WEST);
        p16.add(p15, BorderLayout.EAST);
        p16.add(jbtConverse, BorderLayout.CENTER);
        p16.setBorder(new TitledBorder("Number Conversion"));



        //Panel p11 to hold radio buttons (keyboard)
        JPanel p11 = new JPanel(new GridLayout(1, 2));
        p11.add(jrbFx);
        p11.add(jrbX);
        p11.setBorder(new TitledBorder("Transform Keyboard"));

        //Create a radio-button group to group two buttons
        ButtonGroup groupKeyboard = new ButtonGroup();
        groupKeyboard.add(jrbFx);
        groupKeyboard.add(jrbX);

        //Panel p10 to hold calculator
        JPanel p10 = new JPanel(new GridLayout(2, 3));
        p10.add(new Label("x="));
        p10.add(jtaX);
        p10.add(jbtCalculate);
        p10.add(new Label("RESULT:"));
        p10.add(jtaResult);
        p10.setBorder(new TitledBorder("Calculator"));
        p1.add(p10, BorderLayout.SOUTH);



        //Panel p2 to hold number buttons
        JButton[] jbtNumber = new JButton[10];
        JPanel p2 = new JPanel(new GridLayout(4, 3));
        //p2.add(new Label());
        //p2.add(p11);
        //p2.add(new Label());
        for(int i=1; i<=9; i++) {
            jbtNumber[i] = new JButton();
            jbtNumber[i].setText("" + i);
            p2.add(jbtNumber[i]);
        }

        p2.add(jbtBracket1);
        jbtNumber[0] = new JButton();
        jbtNumber[0].setText("" + 0);
        p2.add(jbtNumber[0]);
        p2.add(jbtBracket2);
        p2.setBorder(new TitledBorder("Number"));

        //Panel p17 to hold number(p2) and p16
        JPanel p17 = new JPanel(new BorderLayout());
        p17.add(p16, BorderLayout.NORTH);
        p17.add(p2, BorderLayout.CENTER);

        //Panel p3 to hold operator buttons
        JPanel p3 = new JPanel(new GridLayout(2, 4));
        p3.add(jbtPlus);
        p3.add(jbtMinus);
        p3.add(jbtMultiply);
        p3.add(jbtDivide);
        p3.add(jbtPower);
        p3.add(jbtPi);
        p3.add(jbtE);
        p3.add(jbtX);
        p3.setBorder(new TitledBorder("Operator and X Factor"));

        //Panel p4 to hold special function buttons
        JPanel p4 = new JPanel(new GridLayout(2, 4));
        p4.add(jbtSin);
        p4.add(jbtCos);
        p4.add(jbtTan);
        p4.add(jbtLog);
        p4.add(jbtAsin);
        p4.add(jbtAcos);
        p4.add(jbtAtan);
        p4.setBorder(new TitledBorder("Specail Function"));

        //Set properties for slider
        jsldValue.setPaintLabels(true);
        jsldValue.setPaintTicks(true);
        jsldValue.setMajorTickSpacing(9);
        jsldValue.setMinorTickSpacing(1);

        //Panel p5 to hold Plotting button
        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p11, BorderLayout.NORTH);
        p5.add(jbtPlotting, BorderLayout.CENTER);

        //Panel p6 to hold p3, p4 and p5
        JPanel p6 = new JPanel(new GridLayout(3, 1));
        p6.add(p3);
        p6.add(p4);
        p6.add(p5);

        //Panel p7 to hold p1, p2 and p6
        JPanel p7 = new JPanel(new BorderLayout());
        p7.add(p1, BorderLayout.NORTH);
        p7.add(p17, BorderLayout.CENTER);
        p7.add(p6, BorderLayout.SOUTH);

        //Panel p8 to hold slider
        JPanel p8 = new JPanel(new GridLayout(1, 1));
        p8.add(jsldValue);
        p8.setBorder(new TitledBorder("Value"));

        //Panel p9 to hold plotting area
        JPanel p9 = new JPanel(new BorderLayout());
        p9.add(p8, BorderLayout.SOUTH);
        p9.add(plPanel, BorderLayout.CENTER);
        p9.setBorder(new TitledBorder("Plotting Area"));

        //add the panels to the frame
        add(p7, BorderLayout.WEST);
        add(p9, BorderLayout.CENTER);

        //Register listener

        jrb2First.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FormFirst = 2;
            }
        });

        jrb8First.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FormFirst = 8;
            }
        });

        jrb10First.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FormFirst = 10;
            }
        });

        jrb16First.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FormFirst = 16;
            }
        });

        jrb2Final.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FormFinal = 2;
            }
        });

        jrb8Final.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FormFinal = 8;
            }
        });

        jrb10Final.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FormFinal = 10;
            }
        });

        jrb16Final.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FormFinal = 16;
            }
        });


        jbtConverse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumberConversion numberconversion = new NumberConversion();
                String number = jtaNumberFirst.getText();
                String result = numberconversion.Conversion(number, FormFirst, FormFinal);
                jtaNumberFinal.setText("");
                jtaNumberFinal.append(result);
            }
        });
        jrbFx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                KeyboardTransformer = true;//Define true as "f(x)"
            }
        });
        jrbX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                KeyboardTransformer = false;//Define false as "x="
            }
        });

        jrbFx.setSelected(true);

        for(int i=0; i<=9; i++) {
            jbtNumber[i].addActionListener(new NumberListener(i));
        }
        jbtBracket1.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("(");
                }
                else {
                    jtaX.append("(");
                }
            }
        });
        jbtBracket2.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append(")");
                }
                else {
                    jtaX.append(")");
                }
            }
        });
        jbtPlus.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("+");
                }
                else {
                    jtaX.append("+");
                }
            }
        });
        jbtMinus.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("-");
                }
                else {
                    jtaX.append("-");
                }
            }
        });
        jbtMultiply.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("*");
                }
                else {
                    jtaX.append("*");
                }
            }
        });
        jbtDivide.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("/");
                }
                else {
                    jtaX.append("/");
                }
            }
        });
        jbtPower.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("^");
                }
                else {
                    jtaX.append("^");
                }
            }
        });
        jbtPi.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("π");
                }
                else {
                    jtaX.append("π");
                }
            }
        });
        jbtE.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("e");
                }
                else {
                    jtaX.append("e");
                }
            }
        });
        jbtX.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                jtaFunction.append("x");
            }
        });
        jbtSin.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("sin(");
                }
                else {
                    jtaX.append("sin(");
                }
            }
        });
        jbtCos.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("cos(");
                }
                else {
                    jtaX.append("cos(");
                }
            }
        });
        jbtTan.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("tan(");
                }
                else {
                    jtaX.append("tan(");
                }
            }
        });
        jbtLog.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("log(");
                }
                else {
                    jtaX.append("log(");
                }
            }
        });
        jbtAsin.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("arcsin(");
                }
                else {
                    jtaX.append("arcsin(");
                }
            }
        });
        jbtAcos.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("arccos(");
                }
                else {
                    jtaX.append("arccos(");
                }
            }
        });
        jbtAtan.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                if(KeyboardTransformer) {
                    jtaFunction.append("arctan(");
                }
                else {
                    jtaX.append("arctan(");
                }
            }
        });




        jbtEmpty.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e){
                jtaFunction.setText("");
                plPanel.Empty();
                plPanel.InitalPanel();
            }
        });
        jbtPlotting.addActionListener(new PlottingListener());
        jbtCalculate.addActionListener(new CalculateListener());
        jsldValue.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                plPanel.setValue(jsldValue.getValue());
            }
        });
    }

    //Handle the Plotting button
    private class PlottingListener implements ActionListener {
        private Polygon p = new Polygon();
        private Calculator calculator = new Calculator();
        public void actionPerformed(ActionEvent e) {
            int overflow = 0;
            try {
                plPanel.Empty();
                p.reset();
                for(int x=-300; x<=300; x++) {
                    calculator.calc(jtaFunction.getText() + "#", (x/30.0)*(float)plPanel.getValue());
                    if(calculator.getValue() == 0) {
                        continue;
                    }
                    p.addPoint(x + 300, 300-(int)(30*calculator.getValue()/(float)plPanel.getValue()));
                    if(300-(int)(30*calculator.getValue()/(float)plPanel.getValue()) < 0 | 300-(int)(30*calculator.getValue()/(float)plPanel.getValue()) > 600) {
                        overflow++;
                    }
                }
                if(overflow >= 600) {
                    JOptionPane.showMessageDialog(null, "Overflow! Please adjust the sliding block to change value.");
                }
                else {
                    plPanel.paint(p);
                }
            }
            catch(java.lang.StringIndexOutOfBoundsException | java.util.EmptyStackException ex) {
                JOptionPane.showMessageDialog(null, "The expression is wrong!");
            }

        }
    }

    //Handle the Calculate button
    private class CalculateListener implements ActionListener {
        private Calculator calculator = new Calculator();
        private double x;
        private double result;
        public void actionPerformed(ActionEvent e) {
            calculator.calc(jtaX.getText() + "#", 0);
            x = calculator.getValue();
            calculator.calc(jtaFunction.getText() + "#", x);
            result = calculator.getValue();
            jtaResult.setText("");
            jtaResult.append("f(" + jtaX.getText() + ")=" + String.format("%.3f", result));
        }
    }


    //Handle the Number buttons
    private class NumberListener implements ActionListener {
        int num;
        public NumberListener(int i) {
            num = i;
        }
        public void actionPerformed(ActionEvent e) {
            if(KeyboardTransformer) {
                jtaFunction.append("" + num);
            }
            else {
                jtaX.append("" + num);
            }
        }
    }
    //class for plotting area
    class PlotPanel extends JPanel {
        //Declare Value to control scale
        private int Value = 1;

        public void setValue(int Value) {
            this.Value = Value;
        }

        public int getValue() {
            return Value;
        }
        protected void paintComponent(Graphics g) {
            //Draw axis
            g.drawLine(0, plPanel.getHeight()/2, getWidth(), plPanel.getHeight()/2);
            g.drawLine(plPanel.getWidth()/2, 0, plPanel.getWidth()/2, getHeight());
            int[] Xarrow_x = {plPanel.getWidth()-5, plPanel.getWidth(), plPanel.getWidth()-5};
            int[] Xarrow_y = {plPanel.getHeight()/2-5, plPanel.getHeight()/2, plPanel.getHeight()/2+5};
            g.drawPolyline(Xarrow_x, Xarrow_y, 3);
            int[] Yarrow_x = {plPanel.getWidth()/2-5, plPanel.getWidth()/2, plPanel.getWidth()/2+5};
            int[] Yarrow_y = {5, 0, 5};
            g.drawPolyline(Yarrow_x, Yarrow_y, 3);
            g.drawString("x", plPanel.getWidth()-20, plPanel.getWidth()/2-10);
            g.drawString("y=f(x)", plPanel.getWidth()/2+5, 20);
            for(int i=0, n=plPanel.getWidth()/2; i<=10; i++, n=n+30) {
                g.drawString("" + i*Value, n, plPanel.getHeight()/2+10);
                if(i == 0){
                    continue;
                }
                g.drawString("" + i*Value, plPanel.getWidth()/2-10, 600-(n));
            }
            for(int i=-1, n=plPanel.getWidth()/2-30; i>=-10; i--, n=n-30) {
                g.drawString("" + i*Value, n, plPanel.getHeight()/2+10);
                g.drawString("" + i*Value, plPanel.getWidth()/2-10, 600-(n));
            }
        }
        public void InitalPanel()
        {
            Graphics g = getGraphics();
            Empty();
            paintComponent(g);
        }
        public void Empty() {
            Graphics g = getGraphics();
            g.clearRect(0, 0, 600, 600);
        }
        public void paint(Polygon p) {
            InitalPanel();
            Graphics g = getGraphics();
            g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
        }
    }
    public static void main(String[] args) {
        FunctionDiagraph frame = new FunctionDiagraph();
        frame.setSize(1085,734);
        frame.setTitle("FunctionDiagraph");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}