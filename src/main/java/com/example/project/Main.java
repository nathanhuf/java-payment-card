package com.example.project;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Map<String, Tool> tools = new HashMap<>();
    tools.put("JAKR", new Tool("JAKR", "Jackhammer", "Ridgid", 2.99, true, false, false));

    Checkout checkout = new Checkout(tools.get("JAKR"), 5, 10, LocalDate.of(2015, 9, 3));
    RentalAgreement rentalAgreement = checkout.generateRentalAgreement();

    rentalAgreement.print();
  }
}