package com.example.demo.service;

import com.example.demo.entity.TestMessage;
import com.example.demo.repository.TestMessageRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TestMessageService {

    private static final Logger log = LoggerFactory.getLogger(TestMessageService.class);

    private static final String FROM_EMAIL = "hr.groupa.system@gmail.com";
    private static final String SUBJECT = "Groupa TEST Email ";

    private final TestMessageRepository repository;
    private final JavaMailSender mailSender;

    public TestMessageService(TestMessageRepository repository,
                              JavaMailSender mailSender) {
        this.repository = repository;
        this.mailSender = mailSender;
    }

    /**
     * Read-only operation
     */
    public List<TestMessage> getAllMessages() {
        List<TestMessage> messages = repository.findAll();

        messages.stream()
                .filter(msg -> msg != null && StringUtils.hasText(msg.getEmail()))
                .forEach(msg -> sendHtmlEmailAsync(
                        msg.getEmail(),
                        SUBJECT+msg.getRowKey(),
                        HtmlTemplates.TEST_EMAIL
                ));

        return messages;
    }


    /**
     * Async HTML email sender
     */
    @Async
    public void sendHtmlEmailAsync(
            String to,
            String subject,
            String htmlBody
    ) {
        try {

            log.info("Email start to {}", to);
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlBody, true);
            helper.setFrom(FROM_EMAIL);

            mailSender.send(message);

            log.info("Email sent successfully to {}", to);

        } catch (MessagingException ex) {
            log.error("Failed to send email to {}", to, ex);
        }
    }
}
