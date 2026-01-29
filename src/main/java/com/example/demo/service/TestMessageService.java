package com.example.demo.service;

import com.example.demo.entity.TestMessage;
import com.example.demo.repository.TestMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TestMessageService {

    private static final Logger log = LoggerFactory.getLogger(TestMessageService.class);


    private static final String SUBJECT = "Groupa TEST Email ";

    private final TestMessageRepository repository;
    private final BrevoEmailService mailSender;

    public TestMessageService(TestMessageRepository repository,
                              BrevoEmailService mailSender) {
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
                        SUBJECT + msg.getRowKey(),
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
            String htmlBody) {

        log.info("Email start to {}", to);
        mailSender.sendHtmlEmail(to, subject, htmlBody);

        log.info("Email sent successfully to {}", to);

    }
}
