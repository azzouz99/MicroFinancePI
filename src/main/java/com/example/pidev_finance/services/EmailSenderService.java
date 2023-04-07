package com.example.pidev_finance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailSenderService {






    @Autowired
    private JavaMailSender mailSender;
    public void receiveTransactionEmail(String from, String to, float amount) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Transaction Notification");
        message.setText("A transaction of " + amount + " has been made to your account ");
        mailSender.send(message);
    }

    public void sendTransactionEmail(String from, String to, float amount) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Transaction Notification");
        message.setText("A transaction of " + amount + " has been made from your account ");
        mailSender.send(message);
    }
    public void SendInvestmentEmail(String from, String to, float amount) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Investment Notification");
        message.setText("A investment of " + amount + " has been made ");
        mailSender.send(message);
    }
    public void SendInvestmentInterestEmail(String from, String to, float amount,String project) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Investment Notification");
        message.setText("An interest of " + amount + " has been sent to you from the project :"+project);
        mailSender.send(message);
    }

}

