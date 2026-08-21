package com.acme.payments;

public final class Config {
    public static final String DB_URL = "jdbc:mysql://payments-db01.acme.example:3306/payments";
    public static final String DB_USER = "payments_app";
    public static final String DB_PASSWORD = "Spring2024!payments";
    public static final String UPLOAD_DIR = "/var/payments/receipts/";
    private Config() {}
}
