package com.example.bank;

import java.util.Locale;

public class Main {
    public static Locale locale;

    public static Locale getLocale() {
        if (locale == null) {
            locale = new Locale("de", "DE");
        }
        return locale;
    }

    public static void setLocale(Locale newLocale) {
        locale = newLocale;
    }

}
