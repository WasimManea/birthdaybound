package com.example.demo.service;

public final class HtmlTemplates {

    private HtmlTemplates() {}

    public static final String TEST_EMAIL = """
        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="UTF-8">
            <title>Test Email</title>
        </head>
        <body style="margin:0; padding:0; font-family: Arial, sans-serif; background-color:#f4f6f8;">
        <table width="100%" cellpadding="0" cellspacing="0" style="padding:20px;">
            <tr>
                <td align="center">
                    <table width="600" style="background:#ffffff; padding:20px; border-radius:6px;">
                        <tr>
                            <td style="font-size:20px; font-weight:bold;">Test Notification</td>
                        </tr>
                        <tr>
                            <td style="padding-top:10px;">
                                This is a <strong>test email</strong> from your
                                <strong>Spring Boot application</strong>.
                            </td>
                        </tr>
                        <tr>
                            <td style="padding-top:20px; font-size:12px; color:#999;">
                                © 2026 Groupa Application
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        </body>
        </html>
        """;
}
