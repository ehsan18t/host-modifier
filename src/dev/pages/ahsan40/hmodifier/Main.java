package dev.pages.ahsan40.hmodifier;

import java.io.PrintStream;
import java.util.prefs.Preferences;

/**
 * @author Ahsan
 */
public class Main {
    public static boolean isAdmin() {
        Preferences prefs = Preferences.systemRoot();
        PrintStream systemErr = System.err;
        synchronized (systemErr) {    // better synchronize to avoid problems with other threads that access System.err
            System.setErr(null);
            try {
                prefs.put(Configs.title, "Test"); // SecurityException on Windows
                prefs.remove(Configs.title);
                prefs.flush(); // BackingStoreException on Linux
                return true;
            } catch (Exception e) {
                return false;
            } finally {
                System.setErr(systemErr);
            }
        }
    }

    public static void main(String[] args) {
        // start gui
        if (isAdmin()) {
            java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
            // System.out.println(Thread.currentThread().getId()); // debug
        } else {
            //Check for environment and escalate privileges
            System.out.println("Administrator Privileges required. Please rerun with appropriate permissions.");
            System.exit(1);
        }
    }
}
