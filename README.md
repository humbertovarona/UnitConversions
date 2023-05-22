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

1. For example, we will add the magnitude temperature, substitute in UnitConverterApp

```java
typeComboBox = new JComboBox<>(new String[]{"Length", "Weight"});  
```
by

```java
typeComboBox = new JComboBox<>(new String[]{"Length", "Weight", "Temperature"});  
```

2. Modify class TypeComboBoxListener

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


