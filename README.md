# UnitConversions

Java Student Demo, Case Study: UnitConverterApp

<p align="center">
<img src="/image/unitConverter_screenshot.png" width="300">
</p>

# Version

1.0

# Release date

2022-04-30

# How to run

```shell
cd UnitConverterApp/src/main/java/hlvarona/unitconverterapp/
```

```shell
java UnitConverterApp.java
```

# How to update the code?

1. For example, we will add the magnitude temperature, substitute in `UnitConverterApp`

```java
typeComboBox = new JComboBox<>(new String[]{"Length", "Weight"});  
```
by

```java
typeComboBox = new JComboBox<>(new String[]{"Length", "Weight", "Temperature"});  
```

2. Modify `class TypeComboBoxListener`

```java
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
  }  else if (selectedType.equals("Temperature")) {
    fromComboBox.addItem("Celsius");
    fromComboBox.addItem("Kelvin");

    toComboBox.addItem("Kelvin");
    toComboBox.addItem("Celsius");
  }
```
3. Finally, Modify function `convert`

```java
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
} else if (fromUnit.equals("Celsius") && toUnit.equals("Kelvin")) {
   convertedValue = value + 273.15;
} else if (fromUnit.equals("Kelvin") && toUnit.equals("Celsius")) {
   convertedValue = value - 273.15;
} 
```

