package com.example.schaetzlibank;

import java.util.Locale;

public class Main
{
    private static Locale locale;



    public static Locale getLocale()
    {
        if (locale == null)
        {
            locale = new Locale("de", "DE");

        }
        return locale;
    }

    public static void setLocale (Locale newLocale)
    {
        locale = newLocale;
    }




}
