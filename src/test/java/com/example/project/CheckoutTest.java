package com.example.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class CheckoutTest {

  private Tool tool;
  private Checkout checkout;

  @BeforeEach
  void setUp() {
    tool = new Tool("JAKR", "Jackhammer", "Ridgid", 2.99, true, false, false);
    checkout = new Checkout(tool, 5, 10, LocalDate.of(2015, 9, 3));
  }

  @Test
  void testCalculateChargeDays() {
    int chargeDays = checkout.calculateChargeDays(LocalDate.of(2015, 9, 3), LocalDate.of(2015, 9, 8));
    assertEquals(4, chargeDays);
  }

  @Test
  void testGenerateRentalAgreement() {
    RentalAgreement rentalAgreement = checkout.generateRentalAgreement();
    assertEquals("JAKR", rentalAgreement.getToolCode());
    assertEquals("Jackhammer", rentalAgreement.getToolType());
    assertEquals("Ridgid", rentalAgreement.getBrand());
    assertEquals(5, rentalAgreement.getRentalDayCount());
    assertEquals(LocalDate.of(2015, 9, 3), rentalAgreement.getCheckoutDate());
    assertEquals(LocalDate.of(2015, 9, 8), rentalAgreement.getDueDate());
    assertEquals(2.99, rentalAgreement.getDailyCharge());
    assertEquals(4, rentalAgreement.getChargeDays());
    assertEquals(11.96, rentalAgreement.getPreDiscountCharge());
    assertEquals(10, rentalAgreement.getDiscountPercent());
    assertEquals(1.2, rentalAgreement.getDiscountAmount());
    assertEquals(10.76, rentalAgreement.getFinalCharge());
  }

  @Test
  void testIsChargeableDay() {
    assertTrue(checkout.isChargeableDay(LocalDate.of(2015, 9, 3)));
    assertTrue(checkout.isChargeableDay(LocalDate.of(2015, 9, 4)));
    assertFalse(checkout.isChargeableDay(LocalDate.of(2015, 9, 5)));
    assertFalse(checkout.isChargeableDay(LocalDate.of(2015, 9, 6)));
    assertTrue(checkout.isChargeableDay(LocalDate.of(2015, 9, 7)));
    assertTrue(checkout.isChargeableDay(LocalDate.of(2015, 9, 8)));
  }

  @Test
  void testIsIndependenceDay() {
    assertFalse(checkout.isIndependenceDay(LocalDate.of(2015, 7, 4)));
    assertFalse(checkout.isIndependenceDay(LocalDate.of(2015, 7, 5)));
    assertTrue(checkout.isIndependenceDay(LocalDate.of(2015, 7, 3)));
  }

  @Test
  void testIsLaborDay() {
    assertTrue(checkout.isLaborDay(LocalDate.of(2015, 9, 7)));
    assertFalse(checkout.isLaborDay(LocalDate.of(2015, 9, 8)));
  }

}
