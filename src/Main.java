import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Inventory update program
 * @author Dino Cajic
 */
public class Main {

    /**
     * Launches the CMD program and launches POS.exe through it.
     * Goes through the prompts to export the inventory file from POS and emails it to
     * inventory@company.com. Closes both POS and CMD programs. Waits
     * 2 minutes to make sure that the email was successfully sent/received. It then opens
     * up the Chrome browser (has to be marked default on computer) and goes to the specified
     * page on both company.com and company2.com to update the inventory on
     * both websites. Once the inventory has been updated, on both sites, it closes the Chrome
     * browser and waits for 30 seconds before repeating the process again.
     *
     * @param args - Default arguments
     */
    public static void main(String[] args) {
        String company_1_web_address = "https://company.com/";
        String company_2_web_address   = "https://company2.com";

        try {
            Robot robot = new Robot();

            while (true) {
                launchProgram(robot);
                robot.delay(5000);
                exportFile(robot);
                robot.delay(5000);
                closeProgram("cmd.exe");
                robot.delay(60000); // Wait 2 minutes before accessing online handler
                robot.delay(60000); // Max time for delay() method is 60000 milliseconds
                openOnlineHandler(company_1_web_address); // Update Company 1 inventory
                robot.delay(30000);
                openOnlineHandler(company_2_web_address); // Update Company 2 inventory
                robot.delay(30000);
                closeProgram("chrome.exe");
                robot.delay(60000); // Wait 2 minutes before opening up POS again
                robot.delay(60000);
            }

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens CMD and navigates to the POS folder to launch POS.exe
     *
     * @param robot - KeyPress handler
     */
    public static void launchProgram(Robot robot) {
        Desktop desktop = Desktop.getDesktop();
        File file = new File("C:\\Windows\\System32\\cmd.exe");

        try {
            desktop.open(file);
        } catch(IOException e) {
            e.printStackTrace();
        }

        robot.delay(2000); // wait 2 seconds for CMD to open

        int[] colon       = {KeyEvent.VK_SHIFT, KeyEvent.VK_SEMICOLON};
        int[] doubleQuote = {KeyEvent.VK_SHIFT, KeyEvent.VK_QUOTE};
        int[] leftParen   = {KeyEvent.VK_SHIFT, KeyEvent.VK_9};
        int[] rightParen  = {KeyEvent.VK_SHIFT, KeyEvent.VK_0};

        // c:
        pressKey(robot, KeyEvent.VK_C, 100, 1);
        pressKey(robot, colon, 100);
        pressKey(robot, KeyEvent.VK_ENTER, 100, 1);
        // cd "C:\Program Files (x86)\POS23"
        pressKey(robot, KeyEvent.VK_C, 100, 1);
        pressKey(robot, KeyEvent.VK_D, 100, 1);
        pressKey(robot, KeyEvent.VK_SPACE, 100, 1);
        pressKey(robot, doubleQuote, 100);
        pressKey(robot, KeyEvent.VK_C, 100, 1);
        pressKey(robot, colon, 100);
        pressKey(robot, KeyEvent.VK_BACK_SLASH, 100, 1);
        pressKey(robot, KeyEvent.VK_P, 100, 1);
        pressKey(robot, KeyEvent.VK_R, 100, 1);
        pressKey(robot, KeyEvent.VK_O, 100, 1);
        pressKey(robot, KeyEvent.VK_G, 100, 1);
        pressKey(robot, KeyEvent.VK_R, 100, 1);
        pressKey(robot, KeyEvent.VK_A, 100, 1);
        pressKey(robot, KeyEvent.VK_M, 100, 1);
        pressKey(robot, KeyEvent.VK_SPACE, 100, 1);
        pressKey(robot, KeyEvent.VK_F, 100, 1);
        pressKey(robot, KeyEvent.VK_I, 100, 1);
        pressKey(robot, KeyEvent.VK_L, 100, 1);
        pressKey(robot, KeyEvent.VK_E, 100, 1);
        pressKey(robot, KeyEvent.VK_S, 100, 1);
        pressKey(robot, KeyEvent.VK_SPACE, 100, 1);
        pressKey(robot, leftParen, 100);
        pressKey(robot, KeyEvent.VK_X, 100, 1);
        pressKey(robot, KeyEvent.VK_8, 100, 1);
        pressKey(robot, KeyEvent.VK_6, 100, 1);
        pressKey(robot, rightParen, 100);
        pressKey(robot, KeyEvent.VK_BACK_SLASH, 100, 1);
        pressKey(robot, KeyEvent.VK_P, 100, 1);
        pressKey(robot, KeyEvent.VK_O, 100, 1);
        pressKey(robot, KeyEvent.VK_S, 100, 1);
        pressKey(robot, KeyEvent.VK_ENTER, 1000, 1);
        // POS.exe
        pressKey(robot, KeyEvent.VK_P, 100, 1);
        pressKey(robot, KeyEvent.VK_O, 100, 1);
        pressKey(robot, KeyEvent.VK_S, 100, 1);
        pressKey(robot, KeyEvent.VK_PERIOD, 100, 1);
        pressKey(robot, KeyEvent.VK_E, 100, 1);
        pressKey(robot, KeyEvent.VK_X, 100, 1);
        pressKey(robot, KeyEvent.VK_E, 100, 1);
        pressKey(robot, KeyEvent.VK_ENTER, 100, 1);
    }

    /**
     * Goes through the POS Program to export the inventory file.
     * Closes the program upon completion
     *
     * @param robot - KeyPress handler
     */
    public static void exportFile(Robot robot) {
        int[] atSymbol    = {KeyEvent.VK_SHIFT, KeyEvent.VK_2};

        // Enter Username
        pressKey(robot, KeyEvent.VK_D, 100, 1);
        pressKey(robot, KeyEvent.VK_I, 100, 1);
        pressKey(robot, KeyEvent.VK_N, 100, 1);
        pressKey(robot, KeyEvent.VK_O, 100, 1);
        pressKey(robot, KeyEvent.VK_ENTER, 1000, 1);
        // Enter First Password
        pressKey(robot, KeyEvent.VK_1, 100, 1);
        pressKey(robot, KeyEvent.VK_2, 100, 1);
        pressKey(robot, KeyEvent.VK_3, 100, 1);
        pressKey(robot, KeyEvent.VK_4, 100, 1);
        pressKey(robot, KeyEvent.VK_ENTER, 1000, 1);
        // Press F10 to make warning message disappear (if one exists)
        pressKey(robot, KeyEvent.VK_F10, 500, 1);
        // Second Password
        pressKey(robot, KeyEvent.VK_1, 100, 1);
        pressKey(robot, KeyEvent.VK_2, 100, 1);
        pressKey(robot, KeyEvent.VK_3, 100, 1);
        pressKey(robot, KeyEvent.VK_4, 100, 1);
        pressKey(robot, KeyEvent.VK_ENTER, 500, 1);
        //Enter on Atlanta
        pressKey(robot, KeyEvent.VK_ENTER, 500, 1);
        // Down to Inventory Control
        pressKey(robot, KeyEvent.VK_DOWN, 500, 6);
        pressKey(robot, KeyEvent.VK_ENTER, 500, 1);
        // Down to Custom Reports and Applications
        pressKey(robot, KeyEvent.VK_DOWN, 500, 7);
        pressKey(robot, KeyEvent.VK_ENTER, 500, 1);
        // Down to Create Custom Export File
        pressKey(robot, KeyEvent.VK_DOWN, 500, 2);
        pressKey(robot, KeyEvent.VK_ENTER, 500, 1);
        pressKey(robot, KeyEvent.VK_Y, 500, 1);
        pressKey(robot, KeyEvent.VK_ENTER, 500, 1);
        // Down to Location 2
        pressKey(robot, KeyEvent.VK_DOWN, 500, 2);
        pressKey(robot, KeyEvent.VK_ENTER, 500, 1);
        // Down to Location 3
        pressKey(robot, KeyEvent.VK_DOWN, 500, 1);
        pressKey(robot, KeyEvent.VK_ENTER, 500, 1);
        // Wait 15 seconds since it's spooling all of the data
        pressKey(robot, KeyEvent.VK_F10, 15000, 1);
        // Escape to main screen
        pressKey(robot, KeyEvent.VK_ESCAPE, 500, 2);
        // Down to Other Options
        pressKey(robot, KeyEvent.VK_DOWN, 500, 2);
        pressKey(robot, KeyEvent.VK_ENTER, 500, 1);
        // Down to System Command Prompt
        pressKey(robot, KeyEvent.VK_DOWN, 500, 8);
        pressKey(robot, KeyEvent.VK_ENTER, 500, 1);
        // Type disptext itemrepo
        pressKey(robot, KeyEvent.VK_D, 500, 1);
        pressKey(robot, KeyEvent.VK_I, 500, 1);
        pressKey(robot, KeyEvent.VK_S, 500, 1);
        pressKey(robot, KeyEvent.VK_P, 500, 1);
        pressKey(robot, KeyEvent.VK_T, 500, 1);
        pressKey(robot, KeyEvent.VK_E, 500, 1);
        pressKey(robot, KeyEvent.VK_X, 500, 1);
        pressKey(robot, KeyEvent.VK_T, 500, 1);
        pressKey(robot, KeyEvent.VK_SPACE, 500, 1);
        pressKey(robot, KeyEvent.VK_I, 500, 1);
        pressKey(robot, KeyEvent.VK_T, 500, 1);
        pressKey(robot, KeyEvent.VK_E, 500, 1);
        pressKey(robot, KeyEvent.VK_M, 500, 1);
        pressKey(robot, KeyEvent.VK_R, 500, 1);
        pressKey(robot, KeyEvent.VK_E, 500, 1);
        pressKey(robot, KeyEvent.VK_P, 500, 1);
        pressKey(robot, KeyEvent.VK_O, 500, 1);
        pressKey(robot, KeyEvent.VK_ENTER, 500, 1);
        // To enter email option screen
        pressKey(robot, KeyEvent.VK_P, 500, 1);
        pressKey(robot, KeyEvent.VK_PAGE_DOWN, 500, 2);
        // Down to email to user text
        pressKey(robot, KeyEvent.VK_DOWN, 500, 8);
        // To go through the default screens
        pressKey(robot, KeyEvent.VK_ENTER, 500, 3);
        // inventory@firstchoicewheelsandtires.com
        pressKey(robot, KeyEvent.VK_I, 500, 1);
        pressKey(robot, KeyEvent.VK_N, 500, 1);
        pressKey(robot, KeyEvent.VK_V, 500, 1);
        pressKey(robot, KeyEvent.VK_E, 500, 1);
        pressKey(robot, KeyEvent.VK_N, 500, 1);
        pressKey(robot, KeyEvent.VK_T, 500, 1);
        pressKey(robot, KeyEvent.VK_O, 500, 1);
        pressKey(robot, KeyEvent.VK_R, 500, 1);
        pressKey(robot, KeyEvent.VK_Y, 500, 1);
        pressKey(robot, atSymbol, 500);
        pressKey(robot, KeyEvent.VK_C, 500, 1);
        pressKey(robot, KeyEvent.VK_O, 500, 1);
        pressKey(robot, KeyEvent.VK_M, 500, 1);
        pressKey(robot, KeyEvent.VK_P, 500, 1);
        pressKey(robot, KeyEvent.VK_A, 500, 1);
        pressKey(robot, KeyEvent.VK_N, 500, 1);
        pressKey(robot, KeyEvent.VK_Y, 500, 1);
        pressKey(robot, KeyEvent.VK_PERIOD, 500, 1);
        pressKey(robot, KeyEvent.VK_C, 500, 1);
        pressKey(robot, KeyEvent.VK_O, 500, 1);
        pressKey(robot, KeyEvent.VK_M, 500, 1);
        pressKey(robot, KeyEvent.VK_ENTER, 10000, 1);
        // Close the program
        pressKey(robot, KeyEvent.VK_ESCAPE, 2000, 1);
        pressKey(robot, KeyEvent.VK_Y, 1000, 1);
        pressKey(robot, KeyEvent.VK_ENTER, 1000, 1);
        pressKey(robot, KeyEvent.VK_E, 500, 1);
        pressKey(robot, KeyEvent.VK_X, 500, 1);
        pressKey(robot, KeyEvent.VK_I, 500, 1);
        pressKey(robot, KeyEvent.VK_T, 500, 1);
        pressKey(robot, KeyEvent.VK_ENTER, 1000, 1);
        pressKey(robot, KeyEvent.VK_ESCAPE, 500, 2);
    }

    /**
     * Closes the specified program
     *
     * @param programName - The name of the program (i.e. cmd.exe)
     */
    public static void closeProgram(String programName) {
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("taskkill /F /IM " + programName);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens the online page that will execute the script to import the exported inventory into the database
     *
     * @param web_address - The website address of the handler
     */
    public static void openOnlineHandler(String web_address) {
        if(Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(web_address));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Handles single key-press a certain amount of times (i.e. Press Down Arrow 7 times)
     *
     * @param robot  - KeyPress handler
     * @param key    - KeyEvent.VK_xxx
     * @param delay  - The time in milliseconds to wait before continuing
     * @param repeat - If key pressed multiple times, repeat for desired amount
     */
    public static void pressKey(Robot robot, int key, int delay, int repeat) {
        for (int i = 0; i < repeat; i++) {
            robot.keyPress(key);
            robot.keyRelease(key);
            robot.delay(delay);
        }
    }

    /**
     * Handles multiple simultaneous key-presses (i.e. Shift-Semicolon)
     *
     * @param robot - KeyPress handler
     * @param key   - KeyEvent.VK_xxx
     * @param delay - The time in milliseconds to wait before continuing
     */
    public static void pressKey(Robot robot, int[] key, int delay) {
        for (int key_down : key) {
            robot.keyPress(key_down);
        }

        for (int key_down : key) {
            robot.keyRelease(key_down);
        }

        robot.delay(delay);
    }
}