package learn_java_定时任务;

import lombok.var;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TimePrinter implements ActionListener {
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone,the time is "+new java.util.Date());
        System.out.println("At the tone,the time is " + Instant.ofEpochMilli(e.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }

    public static void main(String[] args) {
        var listener = new TimePrinter();
        //construct a timer that calls the listener,delay in milliseconds
        //提供一个函数，定时器定时调用函数（java以对象为基础），定时传入对象，调用对象的方法
        var timer = new Timer(1000,listener);
        timer.start();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}
