package com.web.utils;

import java.util.Random;
import java.util.UUID;

public class RandomDataGenerator {
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String[] CITIES = {"Belgrade", "Novi Sad", "Niš"};
    private static final String[] STREETS = {"Main Street", "First Avenue", "Park Road"};
    private static final Random random = new Random();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return sb.toString();
    }

    public static String generateRandomUsername() {
        return "user_" + UUID.randomUUID();
    }

    public static String generateRandomNumber(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }
        return sb.toString();
    }

    public static String generateRandomEmail() {
        return generateRandomString(10) + "@example.com";
    }

    public static String generateRandomPassword() {
        return generateRandomString(8) + NUMBERS.charAt(random.nextInt(NUMBERS.length()));
    }

    public static String generateRandomCity() {
        return CITIES[random.nextInt(CITIES.length)];
    }

    public static String generateRandomStreet() {
        return STREETS[random.nextInt(STREETS.length)] + " " + random.nextInt(100);
    }

}