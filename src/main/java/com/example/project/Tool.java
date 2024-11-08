package com.example.project;

class Tool {
  String toolCode;
  String toolType;
  String brand;
  double dailyCharge;
  boolean weekdayCharge;
  boolean weekendCharge;
  boolean holidayCharge;

  public Tool(String toolCode, String toolType, String brand, double dailyCharge, boolean weekdayCharge,
      boolean weekendCharge, boolean holidayCharge) {
    this.toolCode = toolCode;
    this.toolType = toolType;
    this.brand = brand;
    this.dailyCharge = dailyCharge;
    this.weekdayCharge = weekdayCharge;
    this.weekendCharge = weekendCharge;
    this.holidayCharge = holidayCharge;
  }
}
