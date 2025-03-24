package tw.example.com.springbootexample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest, HttpServletRequest httpRequest) {
        try {
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password);
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            httpRequest.getSession(true).setAttribute(
                "SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
            
            return "redirect:/";
        } catch (Exception e) {
            return "login";
        }
    }

        // @PostMapping("/login")
    // public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletRequest httpRequest) {
    //     try {
    //         UsernamePasswordAuthenticationToken token =
    //                 new UsernamePasswordAuthenticationToken(loginRequest.userName, loginRequest.password);
    //         Authentication authentication = authenticationManager.authenticate(token);
    //         SecurityContextHolder.getContext().setAuthentication(authentication);
            
    //         httpRequest.getSession(true).setAttribute(
    //             "SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
            
    //         return ResponseEntity.ok("success");
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid");
    //     }
    // }

    public static class LoginRequest {
        public String username;
        public String password;
    }

    @GetMapping("/api/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }
}
