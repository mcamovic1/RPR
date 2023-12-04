package com.example.lv6z1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Kalkulator extends Application {
    private StringBuilder input = new StringBuilder();
    private Label izlazLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kalkulator");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        // Postavljanje proporcionalnih širina kolona
        for (int i = 0; i < 4; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(25);
            grid.getColumnConstraints().add(columnConstraints);
        }

        // Postavljanje proporcionalnih visina redova
        for (int i = 0; i < 6; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(16.66); // 100% / 6 redova
            grid.getRowConstraints().add(rowConstraints);
        }

        // Red 1
        izlazLabel = new Label("Izlaz");
        izlazLabel.setStyle("-fx-background-color: lightgreen;");
        grid.add(izlazLabel, 0, 0, 4, 1);

        // Red 2
        Button btnMod = createButton("%");
        Button btnDivide = createButton("/");
        Button btnMultiply = createButton("x");
        Button btnSubtract = createButton("-");
        grid.add(btnMod, 0, 1);
        grid.add(btnDivide, 1, 1);
        grid.add(btnMultiply, 2, 1);
        grid.add(btnSubtract, 3, 1);

        // Red 3
        Button btn7 = createButton("7");
        Button btn8 = createButton("8");
        Button btn9 = createButton("9");
        Button btnAdd = createButton("+");
        GridPane.setRowSpan(btnAdd, 2);
        btnAdd.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        grid.add(btn7, 0, 2);
        grid.add(btn8, 1, 2);
        grid.add(btn9, 2, 2);
        grid.add(btnAdd, 3, 2);

        // Red 4
        Button btn4 = createButton("4");
        Button btn5 = createButton("5");
        Button btn6 = createButton("6");
        grid.add(btn4, 0, 3);
        grid.add(btn5, 1, 3);
        grid.add(btn6, 2, 3);

        // Red 5
        Button btn1 = createButton("1");
        Button btn2 = createButton("2");
        Button btn3 = createButton("3");
        Button btnEquals = createButton("=");
        btnEquals.setStyle("-fx-background-color: #F3A89B;");
        GridPane.setRowSpan(btnEquals, 2);
        btnEquals.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        grid.add(btn1, 0, 4);
        grid.add(btn2, 1, 4);
        grid.add(btn3, 2, 4);
        grid.add(btnEquals, 3, 4);

        // Red 6
        Button btn0 = createButton("0");
        btn0.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane.setColumnSpan(btn0, 2);
        Button btnDot = createButton(".");
        grid.add(btn0, 0, 5, 2, 1);
        grid.add(btnDot, 2, 5);

        addNumericButtonAction(btn0);
        addNumericButtonAction(btn1);
        addNumericButtonAction(btn2);
        addNumericButtonAction(btn3);
        addNumericButtonAction(btn4);
        addNumericButtonAction(btn5);
        addNumericButtonAction(btn6);
        addNumericButtonAction(btn7);
        addNumericButtonAction(btn8);
        addNumericButtonAction(btn9);
        btnDot.setOnAction(e -> appendToInput("."));

        btnMod.setOnAction(e -> performOperation("%"));
        btnDivide.setOnAction(e -> performOperation("/"));
        btnMultiply.setOnAction(e -> performOperation("*"));
        btnSubtract.setOnAction(e -> performOperation("-"));
        btnAdd.setOnAction(e -> performOperation("+"));
        btnEquals.setOnAction(e -> calculateResult());

        Scene scene = new Scene(grid, 300, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
    public Button createButton(String text) {
        Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return button;
    }

    public void addNumericButtonAction(Button button) {
        button.setOnAction(e -> appendToInput(button.getText()));
    }

    public void appendToInput(String value) {
        input.append(value);
        updateOutput();
    }

    public void performOperation(String operator) {
        input.append(" ").append(operator).append(" ");
        updateOutput();
    }

    public void calculateResult() {
        try {
            String result = String.valueOf(eval(input.toString()));
            input.setLength(0);
            input.append(result);
            updateOutput();
        } catch (Exception e) {
            input.setLength(0);
            input.append("Error");
            updateOutput();
        }
    }

    public void updateOutput() {
        izlazLabel.setText(input.toString());
    }

    public double eval(String expression) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else if (eat('%')) x %= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if (eat('(')) { // Parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                return x;
            }
        }.parse();
    }
    public StringBuilder getInput() {
        return input;
    }
}

