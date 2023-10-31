package io.abdul.userserviceemails.service.Implementation;

import io.abdul.userserviceemails.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class EmailServiceImplementation implements EmailService {
    private static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account Verification";
    @Value("${spring.mail.verify.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String fromEmail;

    private  final JavaMailSender emailSender;

    @Override
    public void sendSimpleMailMessage(String name, String to, String token) {
       try {
           SimpleMailMessage message = new SimpleMailMessage();
           message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
           message.setFrom(fromEmail);
           message.setTo(to);
           message.setText("Hey this is working!!");
           emailSender.send(message);
       }catch(Exception exception) {
           System.out.println(exception.getMessage());
           throw new RuntimeException(exception.getMessage());
       }

    }

    @Override
    public void sendMimeMessageWithAttachments(String name, String to, String token) {

    }

    @Override
    public void sendMimeMessageWithEmbeddedFiles(String name, String to, String token) {

    }

    @Override
    public void sendHtmlEmail(String name, String to, String token) {

    }

    @Override
    public void sendHtmlEmailWithEmbeddedFiles(String name, String to, String token) {

    }
}
