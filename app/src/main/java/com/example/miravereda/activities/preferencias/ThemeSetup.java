package com.example.miravereda.activities.preferencias;

import android.content.Context;
import android.os.Build;
import androidx.appcompat.app.AppCompatDelegate;

/**
 * Clase la cual modifica el tema de la App
 */
public final class ThemeSetup {

    /**
     * Constructor sin parámetros
     */
    private ThemeSetup() {
    }

    /**
     * Clase enum que defino los idiomas posibles
     */
    public enum Mode {
        DEFAULT, DARK, LIGHT
    }

    /**
     * Clase el cual aplica el tema dependiendo cuál esté seleccionado
     * @param mode El tema que se quiere aplicar
     */
    public static void applyTheme(Mode mode) {
        switch (mode) {
            case DARK:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case LIGHT:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            default:
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                }
        }
    }

    /**
     * Aplica el tema y cambia el tema de la App
     * @param context La clase de donde se recibe la información
     */
    public static void applyPreferenceTheme(Context context) {

        applyTheme(Mode.valueOf(GestionPreferencias.getInstance().getTheme(context)));
    }

}
