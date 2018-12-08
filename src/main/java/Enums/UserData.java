package Enums;

import java.util.Random;

public enum UserData {
    USER_EMAIL("gartung-high-skill-qa@gmail.com"), USER_SEARCH_DATA("USA");

    String value;

    UserData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static String generateUniqueEmail(String value) {
        Random random = new Random();
        String uniqueEmail = String.valueOf(random.nextInt(50 - 10)).concat(value);
        return uniqueEmail;
    }
}

