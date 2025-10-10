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
public class ApplyContactController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@PostMapping("/applyform")
	public String sendApplyForm(HttpServletRequest request, Model model) {
		// Get all form parameters
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String content = request.getParameter("message");
		String role = request.getParameter("role");
		String minecraftUsername = request.getParameter("minecraft");
		String age = request.getParameter("age");
		String discord = request.getParameter("discord");
		
		// Store all form data in the model
		Map<String, String> formData = new HashMap<>();
		formData.put("name", name != null ? name : "");
		formData.put("email", email != null ? email : "");
		formData.put("content", content != null ? content : "");
		formData.put("role", role != null ? role : "");
		formData.put("minecraft", minecraftUsername != null ? minecraftUsername : "");
		formData.put("age", age != null ? age : "");
		formData.put("discord", discord != null ? discord : "");
		model.addAttribute("formData", formData);
		
		// Create email with all application details
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(email);
		mail.setTo("dopperm2@my.heartland.edu");
		mail.setSubject("Staff Application for " + role + " from " + name);
		
		// Build a more comprehensive email body
		StringBuilder emailBody = new StringBuilder();
		emailBody.append("New Staff Application\n\n");
		emailBody.append("Role: ").append(role).append("\n");
		emailBody.append("Name: ").append(name).append("\n");
		emailBody.append("Email: ").append(email).append("\n");
		emailBody.append("Minecraft Username: ").append(minecraftUsername).append("\n");
		emailBody.append("Age: ").append(age).append("\n");
		emailBody.append("Discord: ").append(discord).append("\n\n");
		emailBody.append("Application Message:\n").append(content);
		
		mail.setText(emailBody.toString());
		mailSender.send(mail);
		
		return "applyform";
	}
	
	@GetMapping("applyform")
	public String showApplyForm() {
		return "redirect:applyform.html";
	}
	
	@GetMapping("staff-apply")
	public String showStaffApply() {
		return "redirect:staff-apply.html";
	}
}