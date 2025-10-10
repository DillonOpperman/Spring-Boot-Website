package Website.Website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import java.util.Map;
import java.util.HashMap;

@Controller
public class SubController {
    
    @Autowired
    private JavaMailSender mailSender;
    
    @PostMapping("/subscribe")
    public String processSubscription(HttpServletRequest request, Model model) {
        // Get the email from the subscription form
        String subscriberEmail = request.getParameter("email");
        
        try {
            // Send thank you email to the subscriber
            SimpleMailMessage thankYouMail = new SimpleMailMessage();
            thankYouMail.setTo(subscriberEmail);
            thankYouMail.setFrom("info@pigraid.com"); // Replace with your sender email
            thankYouMail.setSubject("Thank you for subscribing to Pigraid!");
            thankYouMail.setText("Thank you for subscribing to our newsletter! We're excited to share updates with you about Pigraid Java Edition.");
            mailSender.send(thankYouMail);
            
            // Optional: Send notification email to admin
            SimpleMailMessage notificationMail = new SimpleMailMessage();
            notificationMail.setFrom("no-reply@pigraid.com");
            notificationMail.setTo("dopperm2@my.heartland.edu"); // Your admin email
            notificationMail.setSubject("New Pigraid Subscription");
            notificationMail.setText("New subscription from: " + subscriberEmail);
            mailSender.send(notificationMail);
            
            // Return to index page with success message
            return "redirect:/?subscribed=true";
        } catch (Exception e) {
            // Log the error
            System.err.println("Error sending email: " + e.getMessage());
            // Return with error parameter
            return "redirect:/subscribe.html?error=true";
        }
    }
    
    @GetMapping("/subscribe")
    public String showSubscribeForm() {
        return "redirect:/subscribe.html";
    }
    
    // Add a test endpoint to verify the controller is working
    @GetMapping("/test-subscribe")
    @ResponseBody
    public String testSubscribe() {
        return "Subscribe controller is working!";
    }
}