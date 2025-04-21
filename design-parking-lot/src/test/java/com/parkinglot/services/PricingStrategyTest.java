package com.parkinglot.services;

import com.parkinglot.services.core.model.Car;
import com.parkinglot.services.core.model.Vehicle;
import com.parkinglot.services.price.PricingService;
import com.parkinglot.services.price.model.PricingStrategyType;

/**
 * This class contains unit tests for various parking pricing strategies.
 * It simulates parking durations and compares calculated prices to expected ones.
 */
public class PricingStrategyTest {

    // Sample vehicle used across all test cases
    private static final Vehicle vehicle = new Car("KA01AB1234", "white");

    public static void main(String[] args) {
        // Execute test cases for each pricing strategy
        testFlatRatePricing();
        testHourlyPricing();
        testTimeBasedSurgePricing();
        testSlabBasedPricingFirstSlab();
        testSlabBasedPricingSecondSlab();
    }

    /**
     * Tests flat rate pricing strategy for 5 hours of parking.
     * Expected output: fixed price regardless of duration.
     */
    private static void testFlatRatePricing() {
        test("FlatRatePricing", PricingStrategyType.FLAT, 5, 100);
    }

    /**
     * Tests hourly pricing strategy for 4 hours of parking.
     * Expected output: per-hour rate multiplied by hours.
     */
    private static void testHourlyPricing() {
        test("HourlyPricing", PricingStrategyType.HOURLY, 4, 100);
    }

    /**
     * Tests time-based surge pricing (e.g., different prices for peak hours).
     * Expected output depends on internal logic, e.g., higher price during surge.
     */
    private static void testTimeBasedSurgePricing() {
        test("TimeBasedSurgePricing", PricingStrategyType.SURGE, 1, 40.0);
    }

    /**
     * Tests slab-based pricing for 1 hour (within first slab).
     * Expected output: low rate as per first slab configuration.
     */
    private static void testSlabBasedPricingFirstSlab() {
        test("SlabBasedPricing (First Slab)", PricingStrategyType.SLAB, 1, 20);
    }

    /**
     * Tests slab-based pricing for 3 hours (crosses into second slab).
     * Expected output: sum of first slab + second slab prices.
     */
    private static void testSlabBasedPricingSecondSlab() {
        test("SlabBasedPricing (Second Slab)", PricingStrategyType.SLAB, 3, 50); // 20 + 30
    }

    /**
     * Generic test runner for a pricing strategy.
     */
    private static void test(String testName, PricingStrategyType type, int hoursParked, double expectedPrice) {
        long entry = System.currentTimeMillis();
        long exit = entry + hoursParked * 60 * 60 * 1000L;

        double actualPrice = PricingService.calculatePrice(type, entry, exit);
        System.out.printf("%s: %.2f%n", testName, actualPrice);

        if (actualPrice == expectedPrice) {
            System.out.printf("✅ Test Passed: %s%n%n", testName);
        } else {
            System.out.printf("❌ Test Failed: %s (Expected %.2f)%n%n", testName, expectedPrice);
        }
    }
}
