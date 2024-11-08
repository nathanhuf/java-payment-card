package com.example.project;

import java.time.LocalDate;

class Checkout {
  Tool tool;
  int rentalDayCount;
  int discountPercent;
  LocalDate checkoutDate;

  public Checkout(Tool tool, int rentalDayCount, int discountPercent, LocalDate checkoutDate) {
    this.tool = tool;
    if (rentalDayCount < 1) {
      throw new IllegalArgumentException("Rental day count must be 1 or greater");
    }
    this.rentalDayCount = rentalDayCount;
    if (discountPercent < 0 || discountPercent > 100) {
      throw new IllegalArgumentException("Discount percent must be between 0 and 100");
    }
    this.discountPercent = discountPercent;
    this.checkoutDate = checkoutDate;
  }

  public RentalAgreement generateRentalAgreement() {
    LocalDate dueDate = checkoutDate.plusDays(rentalDayCount);
    int chargeDays = calculateChargeDays(checkoutDate, dueDate);
    double preDiscountCharge = chargeDays * tool.dailyCharge;
    double discountAmount = Math.round(preDiscountCharge * discountPercent / 100 * 100.0) / 100.0;
    double finalCharge = Math.round((preDiscountCharge - discountAmount) * 100.0) / 100.0;

    return new RentalAgreement(tool.toolCode, tool.toolType, tool.brand, rentalDayCount, checkoutDate, dueDate,
        tool.dailyCharge, chargeDays, preDiscountCharge, discountPercent, discountAmount, finalCharge);
  }

  public int calculateChargeDays(LocalDate startDate, LocalDate endDate) {
    int chargeDays = 0;
    LocalDate currentDate = startDate;

    while (!currentDate.isAfter(endDate)) {
      if (isChargeableDay(currentDate)) {
        chargeDays++;
      }
      currentDate = currentDate.plusDays(1);
    }

    return chargeDays;
  }

  public boolean isChargeableDay(LocalDate date) {
    boolean isWeekday = date.getDayOfWeek().getValue() >= 1 && date.getDayOfWeek().getValue() <= 5;
    boolean isWeekend = date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7;
    boolean isHoliday = isIndependenceDay(date) || isLaborDay(date);

    return (isWeekday && tool.weekdayCharge) || (isWeekend && tool.weekendCharge) || (isHoliday && tool.holidayCharge);
  }

  public boolean isIndependenceDay(LocalDate date) {
    int year = date.getYear();
    LocalDate independenceDay = LocalDate.of(year, 7, 4);

    if (independenceDay.getDayOfWeek().getValue() == 6) {
      independenceDay = independenceDay.minusDays(1);
    } else if (independenceDay.getDayOfWeek().getValue() == 7) {
      independenceDay = independenceDay.plusDays(1);
    }

    return date.equals(independenceDay);
  }

  public boolean isLaborDay(LocalDate date) {
    int year = date.getYear();
    LocalDate laborDay = LocalDate.of(year, 9, 1);

    while (laborDay.getDayOfWeek().getValue() != 1) {
      laborDay = laborDay.plusDays(1);
    }

    return date.equals(laborDay);
  }
}
