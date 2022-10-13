package io.d2a.ahpe;

import javax.swing.*;

/**
 * Some aliases for JOptionDialog
 */
public class AhpeDialog {

    public static void info(final String message) {
        openWithType(message, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void info(final String title, final String message) {
        openWithType(message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void warn(final String message) {
        openWithType(message, JOptionPane.WARNING_MESSAGE);
    }

    public static void warn(final String title, final String message) {
        openWithType(message, title, JOptionPane.WARNING_MESSAGE);
    }

    public static void error(final String message) {
        openWithType(message, JOptionPane.ERROR_MESSAGE);
    }

    public static void error(final String title, final String message) {
        openWithType(message, title, JOptionPane.ERROR_MESSAGE);
    }

    ///

    private static void openWithType(final String message, final String title, final int type) {
        JOptionPane.showMessageDialog(null, message, title, type);
    }

    private static void openWithType(final String message, final int type) {
        openWithType(message, "AHPE", type);
    }

}
