package com.company;

/*

1611 Hours
1. Understand what the program does.
2. Implement the logic of the printTikTak method:
2.1. In the first half a second, the phrase: Tik should be displayed in the console.
2.2. In the second half a second, the phrase: Tak should be displayed in the console.

Requirements:
1. The printTikTak method should output two lines: "Tik" and "Tak".
2. The printTikTak method should take about a second.
3. The printTikTak method should fall asleep twice in half a second. Use the Thread.sleep (500) method.
4. There should be no messages in the console after the phrase "Double-check".
5. The main method should create an object of type Clock.

 */

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread.sleep(2000);
        isStopped = true;
        System.out.println("Clock has to be stopped");
        Thread.sleep(2000);
        System.out.println("Double-check");
    }

    public static class Clock extends Thread {
        public Clock() {
            setPriority(MAX_PRIORITY);
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTikTak();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTikTak() throws InterruptedException {
            Thread.sleep(500);
            System.out.println("Tik");
            Thread.sleep(500);
            System.out.println("Tak");
        }
    }
}





