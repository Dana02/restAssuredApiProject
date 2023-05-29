package org.example.enums;

public enum Config {

    BASE_URL("baseUrl"),
    BROWSER("browser"),
    HEADLESS_MODE("headless.mode"),
    TIMEOUT("timeout"),
    TOKEN("token"),
    RETRIES("retries"),
    MY_SQL_URL("mySql.url"),
    MY_SQL_DRIVER("mySql.driver"),
    MY_SQL_USER("mySql.user"),
    MY_SQL_PASSWORD("mySql.password");

    Config(String config) {
        this.config = config;
    }

    final String config;

    public String getValue() {
        return config;
    }

    public boolean getBoolean() {
        return Boolean.getBoolean(config);
    }

}
