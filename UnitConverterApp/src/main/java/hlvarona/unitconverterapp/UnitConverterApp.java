/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package hlvarona.unitconverterapp;

/**
 *
 * @author HL Varona
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public class UnitConverterApp {
    private JFrame frame;
    private JComboBox<String> typeComboBox;
    private JComboBox<String> fromComboBox;
    private JComboBox<String> toComboBox;
    private JTextField valueTextField;
    private JButton convertButton;
    private JButton copyButton;

    private double convertedValue;
    private boolean conversionDone;

    public UnitConverterApp() {
        frame = new JFrame("Unit Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        typeComboBox = new JComboBox<>(new String[]{"Length", "Weight"});
        typeComboBox.addActionListener(new TypeComboBoxListener());
        frame.add(new JLabel("Type:"));
        frame.add(typeComboBox);

        fromComboBox = new JComboBox<>();
        frame.add(new JLabel("From:"));
        frame.add(fromComboBox);

        JLabel arrowLabel = new JLabel("\u2192");
        frame.add(arrowLabel);

        toComboBox = new JComboBox<>();
        frame.add(new JLabel("To:"));
        frame.add(toComboBox);

        valueTextField = new JTextField("1.0", 10);
        frame.add(new JLabel("Value:"));
        frame.add(valueTextField);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(new ConvertButtonListener());
        frame.add(convertButton);

        copyButton = new JButton("Copy");
        copyButton.addActionListener(new CopyButtonListener());
        copyButton.setEnabled(false);
        frame.add(copyButton);
        frame.setSize(700, 100);
        frame.setVisible(true);

        setDefaultComboBoxValues();
    }

    private void setDefaultComboBoxValues() {
        // Valores predeterminados para los JComboBox
        fromComboBox.addItem("Meters");
        fromComboBox.addItem("Centimeters");
        fromComboBox.addItem("Feet");

        toComboBox.addItem("Centimeters");
        toComboBox.addItem("Meters");
        toComboBox.addItem("Feet");
    }

    private class TypeComboBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedType = (String) typeComboBox.getSelectedItem();

            fromComboBox.removeAllItems();
            toComboBox.removeAllItems();

            if (selectedType.equals("Length")) {
                fromComboBox.addItem("Meters");
                fromComboBox.addItem("Centimeters");
                fromComboBox.addItem("Feet");

                toComboBox.addItem("Centimeters");
                toComboBox.addItem("Meters");
                toComboBox.addItem("Feet");
            } else if (selectedType.equals("Weight")) {
                fromComboBox.addItem("Kilograms");
                fromComboBox.addItem("Pounds");

                toComboBox.addItem("Pounds");
                toComboBox.addItem("Kilograms");
            }
        }
    }

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fromUnit = (String) fromComboBox.getSelectedItem();
            String toUnit = (String) toComboBox.getSelectedItem();
            double value = Double.parseDouble(valueTextField.getText());

            convertedValue = convert(fromUnit, toUnit, value);
            conversionDone = true;

            JOptionPane.showMessageDialog(frame, "Converted value: " + convertedValue);

            copyButton.setEnabled(true);
        }
    }

    private class CopyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringSelection stringSelection = new StringSelection(Double.toString(convertedValue));
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            JOptionPane.showMessageDialog(frame, "Result copied to clipboard.");

            copyButton.setEnabled(false);
        }
    }


    private double convert(String fromUnit, String toUnit, double value) {
        double convertedValue = 1.0;

        if (fromUnit.equals("Meters") && toUnit.equals("Centimeters")) {
            convertedValue = value * 100;
        } else if (fromUnit.equals("Meters") && toUnit.equals("Feet")) {
            convertedValue = value * 3.28084;
        } else if (fromUnit.equals("Centimeters") && toUnit.equals("Meters")) {
            convertedValue = value / 100;
        } else if (fromUnit.equals("Centimeters") && toUnit.equals("Feet")) {
            convertedValue = value * 0.0328084;
        } else if (fromUnit.equals("Feet") && toUnit.equals("Meters")) {
            convertedValue = value * 0.3048;
        } else if (fromUnit.equals("Kilograms") && toUnit.equals("Pounds")) {
        convertedValue = value * 2.20462;
        } else if (fromUnit.equals("Pounds") && toUnit.equals("Kilograms")) {
            convertedValue = value * 0.453592;
        }

        return convertedValue;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UnitConverterApp();
            }
        });
    }
}
