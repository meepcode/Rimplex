package rimplex;

import rimplex.gui.ComplexCalc;
import rimplex.settings.Settings;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Settings settings = Settings.getInstance();
        try {
            ComplexCalc calc = new ComplexCalc(settings);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
