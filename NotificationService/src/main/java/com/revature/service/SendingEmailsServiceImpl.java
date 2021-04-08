package com.revature.service;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class SendingEmailsServiceImpl implements SendingEmailsService {

	@Override
	public void sendEmailToUserAndHotel(String userInfoAndStatus){//String userEmail, String hotelEmail, String status) {
		
		
		String[] words = userInfoAndStatus.split(" ");
		String status = words[0];
		
		if(!status.equals("Approved")) {
			return;
		}
		String toUserEmail = words[2];
		
		System.out.println("Email has beent sent to " + toUserEmail + " successfuly!");
	/*	
		final String from = "xxxxx@gmail.com";   // Using Gmail SMTP
		final String password = "xxxxx";
		
		String[] words = userInfoAndStatus.split(" ");
		String status = words[0];
		
		if(!status.equals("Approved")) {
			return;
		}
		String toUserEmail = words[2];
		//String toHotelEmail = hotelEmail;
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
	
		try {
			
//			InternetAddress[] recipients = new InternetAddress[2];
//			recipients[0] = new InternetAddress(toUserEmail);
//			recipients[1] = new InternetAddress(toHotelEmail);
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toUserEmail));
//			message.setRecipients(Message.RecipientType.TO, recipients);// InternetAddress.parse(toUserEmail));
//			message.addRecipients(Message.RecipientType.TO, recipients);// InternetAddress.parse(toUserEmail)); //test later -- IYAD
			message.setSubject("Booking process " + status); // later more information --- IYAD
			
			String msg = "This email sent using JavaMailer API from Java code!!!";
			
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html");
			
			// If I need it for later/ test it --- IYAD
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(mimeBodyPart);
//			
//			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
//			attachmentBodyPart.attachFile(new File(""));// we can I add a pic -- IYAD
//			multipart.addBodyPart(attachmentBodyPart);
//			message.setContent(multipart);
//			
			
			Transport.send(message);
			
			System.out.println("Mail successfully sent...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	 */
	}

}
