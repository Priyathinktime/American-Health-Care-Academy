/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package com.thinktimetechno.utils;

import com.thinktimetechno.constants.FrameworkConstants;
import com.thinktimetechno.mail.EmailAttachmentsSender;

import javax.mail.MessagingException;

import static com.thinktimetechno.mail.EmailConfig.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailSendUtils {

    private EmailSendUtils() {
        super();
    }

    public static void sendEmail(int count_totalTCs, int count_passedTCs, int count_failedTCs, int count_skippedTCs) {

        if (FrameworkConstants.SEND_EMAIL_TO_USERS.trim().equalsIgnoreCase(FrameworkConstants.YES)) {
            System.out.println("****************************************");
            System.out.println("Send Email - START");
            System.out.println("****************************************");

            System.out.println("File name: " + FrameworkConstants.getExtentReportFilePath());

            String messageBody = getTestCasesCountInFormat(count_totalTCs, count_passedTCs, count_failedTCs,
                    count_skippedTCs);
            //System.out.println(messageBody);

            String attachmentFile_ExtentReport = FrameworkConstants.getExtentReportFilePath();

            try {
                EmailAttachmentsSender.sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, messageBody,
                        attachmentFile_ExtentReport);

                System.out.println("****************************************");
                System.out.println("Email sent successfully.");
                System.out.println("Send Email - END");
                System.out.println("****************************************");
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        }

    }

 private static String getTestCasesCountInFormat(int count_totalTCs, int count_passedTCs, int count_failedTCs,
			int count_skippedTCs) {

		String executionDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' hh:mm a"));
		String companyName = "ThinkTime Automation Team";

		double passPercentage = ((double) count_passedTCs / count_totalTCs) * 100;
		double failurePercentage = ((double) count_failedTCs / count_totalTCs) * 100;

		String statusMessage;
		if (count_failedTCs == 0) {
			statusMessage = "<br/><p><strong style='color:#4169E1;'>Status Overview:</strong></p>" + "<ul>"
					+ "<li>The application is performing optimally, with all monitored functionalities operating as expected.</li>"
					+ "<li>No issues have been identified in the latest evaluation cycle.</li>"
					+ "<li>At this time, no immediate action is required. Continued monitoring is recommended.</li>" + "</ul>";
		} else if (failurePercentage < 50) {
			statusMessage = "<br/><p><strong style='color:#4169E1;'>Status Overview:</strong></p>" + "<ul>"
					+ "<li>The application remains largely stable, with minor discrepancies observed.</li>"
					+ "<li><strong>" + count_failedTCs + "</strong> functionalities exhibited deviations from the expected behavior.</li>"
					+ "<li>It is advisable to review and address these areas to ensure sustained performance and user satisfaction.</li>" + "</ul>";
		} else if (failurePercentage < 100) {
			statusMessage = "<br/><p><strong style='color:#4169E1;'>Status Overview:</strong></p>" + "<ul>"
					+ "<li>The application is currently experiencing significant functional challenges.</li>"
					+ "<li>A substantial number of functionalities (<strong>" + count_failedTCs + "</strong> instances) did not meet expected outcomes.</li>"
					+ "<li>Prompt investigation and remediation are strongly recommended to restore operational reliability.</li>" + "</ul>";
		} else {
			statusMessage = "<br/><p><strong style='color:#4169E1;'>Status Overview:</strong></p>" + "<ul>"
					+ "<li>The application is presently non-operational, with all monitored functionalities failing validation.</li>"
					+ "<li>This situation requires immediate and prioritized attention to initiate recovery and stabilize the platform.</li>"
					+ "<li>It is recommended to conduct a comprehensive review and implement corrective actions urgently.</li>" + "</ul>";
		}

		return "<html>" + "<body style=\"font-family:Verdana, sans-serif; font-size:13px; color:#333\">" +

				"<p>Hi Team,</p>"
				+ "<p>Here's today's UI application testing summary highlighting your application's current health.</p>"
				+ "<p><strong style='color:#4169E1;'>Application Name:</strong> American Health Care Academy</p>"
				+ "<p><strong style='color:#4169E1;'>Application URL:</strong> <a href='https://cpraedcourse.com/' style='color:#1E90FF;'>https://cpraedcourse.com</a></p>"
				+ "<p><strong style='color:#4169E1;'>Execution Date & Time:</strong> " + executionDate + " IST</p>" +

				"<p><strong style='color:#4169E1;'>UI Page Health Check Summary:</strong></p>"
				+ "<table border='1' cellpadding='5' cellspacing='0' "
				+ "style='border-collapse:collapse; text-align:center; width:40%; font-size:9px; margin-top:5px; margin-bottom:5px;'>"
				+ "<tr style='background-color:#000000; color:#ffffff;'>"
				+ "<th>Total Pages</th>" + "<th>Passed</th>" + "<th>Failed</th>" + "<th>Skipped</th>" + "<th>Pass %</th>"
				+ "</tr>" + "<tr>" + "<td>" + count_totalTCs + "</td>" + "<td style='color:green;'>" + count_passedTCs
				+ "</td>" + "<td style='color:red;'>" + count_failedTCs + "</td>" + "<td style='color:orange;'>"
				+ count_skippedTCs + "</td>" + "<td>" + String.format("%.2f", passPercentage) + "%</td>" + "</tr>"
				+ "</table>" +

				statusMessage
				+ "<p>Please download the attached HTML report to access detailed test results.</p>"
				+ "<p>Best regards,<br/>" + companyName + ".<br/>"
				+ "<a href='https://thinktime.in/' style='color:#1E90FF;'>www.thinktime.in</a></p>" + "</body></html>";
	}
}
