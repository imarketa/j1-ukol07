package cz.czechitas.ukol7;


import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class Aplikace extends JFrame {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        //new HlavniOkno(new PreferenceController()).start();
    }
}
