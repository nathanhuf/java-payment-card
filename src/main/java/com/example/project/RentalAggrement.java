package com.example.project;

import java.time.LocalDate;

class RentalAgreement {
  String toolCode;
  String toolType;
  String toolBrand;
  int rentalDays;
  LocalDate checkoutDate;
  LocalDate dueDate;
  double dailyRentalCharge;
  int chargeDays;
  double preDiscountCharge;
  int discountPercent;
  double discountAmount;
  double finalCharge;

  public RentalAgreement(String toolCode, String toolType, String toolBrand, int rentalDays, LocalDate checkoutDate,
      LocalDate dueDate, double dailyRentalCharge, int chargeDays, double preDiscountCharge, int discountPercent,
      double discountAmount, double finalCharge) {
    this.toolCode = toolCode;
    this.toolType = toolType;
    this.toolBrand = toolBrand;
    this.rentalDays = rentalDays;
    this.checkoutDate = checkoutDate;
    this.dueDate = dueDate;
    this.dailyRentalCharge = dailyRentalCharge;
    this.chargeDays = chargeDays;
    this.preDiscountCharge = preDiscountCharge;
    this.discountPercent = discountPercent;
    this.discountAmount = discountAmount;
    this.finalCharge = finalCharge;
  }

  public void print() {
    System.out.println("Tool code: " + toolCode);
    System.out.println("Tool type: " + toolType);
    System.out.println("Tool brand: " + toolBrand);
    System.out.println("Rental days: " + rentalDays);
    System.out.println("Checkout date: " + checkoutDate);
    System.out.println("Due date: " + dueDate);
    System.out.println("Daily rental charge: $" + dailyRentalCharge);
    System.out.println("Charge days: " + chargeDays);
    System.out.println("Pre-discount charge: $" + preDiscountCharge);
    System.out.println("Discount percent: " + discountPercent + "%");
    System.out.println("Discount amount: $" + discountAmount);
    System.out.println("Final charge: $" + finalCharge);
  }

  public String getToolCode() {
    return toolCode;
  }

  public String getToolType() {
    return toolType;
  }

  public String getBrand() {
    return toolBrand;
  }

  public int getRentalDayCount() {
    return rentalDays;
  }

  public LocalDate getCheckoutDate() {
    return checkoutDate;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public double getDailyCharge() {
    return dailyRentalCharge;
  }

  public int getChargeDays() {
    return chargeDays;
  }

  public double getPreDiscountCharge() {
    return preDiscountCharge;
  }

  public int getDiscountPercent() {
    return discountPercent;
  }

  public double getDiscountAmount() {
    return discountAmount;
  }

  public double getFinalCharge() {
    return finalCharge;
  }
}