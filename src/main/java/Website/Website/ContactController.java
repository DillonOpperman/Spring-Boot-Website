package Website.Website;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import java.util.Map;
import java.util.HashMap;
@Controller

public class ContactController {
	
		@Autowired
		private JavaMailSender mailSender;
	

		@PostMapping ("/contactform")

		public String sendContactForm(HttpServletRequest request, Model model) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			/* String subject = request.getParameter("subject"); */
			String content = request.getParameter("message");
			
			Map<String, String> formData = new HashMap<>();
	        formData.put("name", name != null ? name : "test");
	        formData.put("email", email != null ? email : "test2");
	        /* formData.put("subject", subject != null ? subject : "test3"); */
	        formData.put("content", content != null ? content : "test4");

	        model.addAttribute("formData", formData);
	        
	    
	    	SimpleMailMessage mail = new SimpleMailMessage();
	    	mail.setFrom(email);
	    	System.out.println("email"+ email);
	    	mail.setTo("dopperm2@my.heartland.edu");
	    	mail.setSubject("test " + " from " +	email);
	    	mail.setText(content);
	    	mailSender.send(mail);
	    	
	    	   return "contactform";
	}
		@GetMapping("contactform")
		public String showContactForm2() {
			return "redirect:contactform.html";
		}
		
}




