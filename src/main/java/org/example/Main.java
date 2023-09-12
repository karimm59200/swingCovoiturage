package org.example;
import org.example.view.LogingUI;
import org.example.view.UsersUI;
import javax.swing.*;

public class
Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                 LogingUI logingUI =new LogingUI();
            }
        });
    }
}