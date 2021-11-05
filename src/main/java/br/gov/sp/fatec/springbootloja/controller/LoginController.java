package br.gov.sp.fatec.springbootloja.controller;

//import com.fasterxml.jackson.core.JsonProcessingException;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import br.gov.sp.fatec.springbootloja.security.JwtUtils;
import br.gov.sp.fatec.springbootloja.security.Login;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin
public class LoginController {

    private AuthenticationManager authManager;

    @PostMapping()
    public Login autenticar(@RequestBody Login login){
        Authentication auth = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
        authManager.authenticate(auth);

        return login;

    }
        
        
}
