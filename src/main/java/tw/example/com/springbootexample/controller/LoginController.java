package tw.example.com.springbootexample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.example.com.springbootexample.application.dto.SignupDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/auth")
public class LoginController {
    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        if (this.checkIsAuthenticated()) {
            return "redirect:/";
        }

        Object message = request.getSession().getAttribute("message");
        if (null != message) {
            model.addAttribute("message", message);
            request.getSession().removeAttribute("message");
        }

        return "login";
    }

    private boolean checkIsAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (null == authentication) {
            return false;
        }
        if ("anonymousUser".equals(authentication.getPrincipal())) {
            return false;
        }
        if (authentication.isAuthenticated()) {
            return true;
        }

        return false;
    }

    @GetMapping("/api/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }

    @PostMapping("/api/signup")
    @ResponseBody
    public String postMethodName(@RequestBody SignupDto signupDto) {
        // TODO: sign up create Account then save Account
        return "success";
    }
    
}
