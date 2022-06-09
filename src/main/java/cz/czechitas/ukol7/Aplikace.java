package cz.czechitas.ukol7;


import com.formdev.flatlaf.FlatLightLaf;
import cz.czechitas.ukol7.controller.PreferenceController;
import cz.czechitas.ukol7.view.HlavniOkno;

import javax.swing.*;

public class Aplikace {

    public static void main(String... args) {
        FlatLightLaf.setup();
        new HlavniOkno(new PreferenceController()).start();
    }

}
