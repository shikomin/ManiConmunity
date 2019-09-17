package com.wander.core.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {

    public static void sendMail(String email, String code)
            throws AddressException, MessagingException, Exception {
        // 1.创建一个程序与邮件服务器会话对象 Session

        Properties props = new Properties();
        //设置发送的协议
        props.setProperty("mail.transport.protocol", "SMTP");

        //设置发送邮件的服务器
        props.setProperty("mail.host", "smtp.163.com");
        props.setProperty("mail.smtp.auth", "true");// 指定验证为true
        //开启加密,不然会报ssl错误
        MailSSLSocketFactory msf = new MailSSLSocketFactory();
        msf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", msf);

        // 创建验证器
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //设置发送人的帐号和密码
                return new PasswordAuthentication("keming_xu@163.com", "xukeming123");
            }
        };

        Session session = Session.getInstance(props, auth);

        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
        //设置发送者
        message.setFrom(new InternetAddress("keming_xu@163.com"));
        //设置发送方式与接收者
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

        //设置邮件主题
        message.setSubject("用户激活");
        //message.setText("这是一封激活邮件，请<a href='#'>点击</a>");
        //192.168.43.213-手机ip
        //-家里ip
        String emailMsg = "<html><head></head><body><h1>流形问答社区-邮箱验证</h1><h3>请点击下面的链接验证</h3><h5><a href='http://localhost:8080/activation?code="
                + code + "'>http://localhost:8080/activation?code=" + code + "</a></h5></body></html>";
        //设置邮件内容
        message.setContent(emailMsg, "text/html;charset=utf-8");

        // 3.创建 Transport用于将邮件发送
        Transport.send(message);
    }
}