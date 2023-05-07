

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailTry {
	public static void sendMail(String fileName,int restartcount,int regc,int notrespc,ArrayList<String> vmlist)
	{
		// Recipient's email ID needs to be mentioned.
//	      String to = "Aravindh_Balasubramanian@syntelinc.com";

	      // Sender's email ID needs to be mentioned
	      String from = "vishnusankar.v@atos.net";

	      final String username = "A735535";//change accordingly
	      final String password = "Mar@2020";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "cas1.syntelorg.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      //props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	            }
	         });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         InternetAddress[] recipients = new InternetAddress[4]; 
	         
	      // add email addresses 
	      recipients[0] = new InternetAddress("vishnusankar.v@atos.net"); 
	   
//	        
	      // inside of try block instead of using addRecipient()  
	      // use addRecipients() 
	        
	      // specify the type of field(TO, CC ,BCC) 
	      // pass the array of email ids of recipients 
//	         recipients[0] = new InternetAddress("Aravindh_Balasubramanian@syntelinc.com"); 
	      message.setRecipients(Message.RecipientType.TO, recipients);
	      InternetAddress[] recipients1 = new InternetAddress[2]; 
	         
	      /*// add email addresses 
	      recipients1[0] = new InternetAddress("Vishnusankar_V@syntelinc.com"); 
	      recipients1[1] = new InternetAddress("Aravindh_Balasubramanian@syntelinc.com"); */
	      message.setRecipients(Message.RecipientType.CC, recipients1); 
	         // Set Subject: header field
	         message.setSubject("VM Monitoring Tool - Log Details");

	         // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setContent("<html><body><h5>Hi all,</h5><h5>PFB VM Log from"+vmlist.get(0)+"to"+vmlist.get(vmlist.size()-1)+"</h5><table border='1'><tr><td>Total VM</td><td>"+regc+"</td></tr><tr><td>No of VM Registered</td><td>"+regc+"</td></tr><tr><td>No of VM not responding (Responded before threshold & timeout)</td><td>"+notrespc+"</td></tr><tr><td>No of VM restarted (Threshold Exceeded)</td><td>"+restartcount+"</td></tr></table><h5>Note:<ol type='1'><li>This is an autogenerated message</li><li>Threshold is limited 3 attempts</li></ol></h5><h5>Thanks & Regards,</h5><h5>"+(from.split("@")[0]).replace('_', ' ')+"</h5></body></html>","text/html");

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
//	         String filename = "VmLog1.xlsx";
	         DataSource source = new FileDataSource(fileName);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName("VmLog_"+new Date()+".xlsx");
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

	         // Send message
	         //Transport.send(message);

	         System.out.println("Sent message successfully....");
	         
	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	        
	      }
	}
   /*public static void main(String[] args) throws InterruptedException {
	   //for(int i=0;i<=2;i++){
      // Recipient's email ID needs to be mentioned.
      String to = "Aravindh_Balasubramanian@syntelinc.com";

      // Sender's email ID needs to be mentioned
      String from = "Aravindh_Balasubramanian@syntelinc.com";

      final String username = "AB5049585";//change accordingly
      final String password = "may@2019";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "cas1.syntelorg.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      //props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject("Testing Subject");

         // Create the message part
         BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText("This is message body");

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         String filename = "D:\\Xbrid_UI\\VMReport\\VmLog1.xlsx";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart);

         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");
         
      } catch (MessagingException e) {
         throw new RuntimeException(e);
        
      }
      }*/
  // }
}