package fr.sdv.gweltaz.tournamentmanager.Controller;

import fr.sdv.gweltaz.tournamentmanager.Repository.RoleRepository;
import fr.sdv.gweltaz.tournamentmanager.Repository.UserRepository;
import fr.sdv.gweltaz.tournamentmanager.Security.DTO.JwtResponse;
import fr.sdv.gweltaz.tournamentmanager.Security.DTO.LoginRequest;
import fr.sdv.gweltaz.tournamentmanager.Security.DTO.MessageResponse;
import fr.sdv.gweltaz.tournamentmanager.Security.DTO.SignupRequest;
import fr.sdv.gweltaz.tournamentmanager.Security.JWT.JwtTokenUtils;
import fr.sdv.gweltaz.tournamentmanager.Security.Services.UserDetailsImpl;
import fr.sdv.gweltaz.tournamentmanager.model.Role;
import fr.sdv.gweltaz.tournamentmanager.model.UserRole;
import fr.sdv.gweltaz.tournamentmanager.model.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.validation.Valid;
import java.security.Security;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/auth")
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final JwtTokenUtils jwtTokenUtils;
    final AuthenticationManager authenticationManager;

    final PasswordEncoder encoder;


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtils.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                new JwtResponse(jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        roles)
        );
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@Valid @RequestBody SignupRequest signupRequest) {
        if(userRepository.existsByUsername(signupRequest.getUsername()))
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken."));
        if(userRepository.existsByEmail(signupRequest.getEmail()))
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken."));

        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setPassword(encoder.encode(signupRequest.getPassword()));;
        user.setUsername(signupRequest.getUsername());

        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if(strRoles == null) {
            Role userRole = roleRepository.findByName(UserRole.ROLE_VISITOR).orElseThrow(() -> new RuntimeException("Error: Role Not Found"));
            roles.add(userRole);
        }
        else {
            strRoles.forEach(role -> {
                Role userRole;
                if(Objects.equals(role, "admin"))
                    userRole = roleRepository.findByName(UserRole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role Not Found"));
                else
                    userRole = roleRepository.findByName(UserRole.ROLE_VISITOR).orElseThrow(() -> new RuntimeException("Error: Role Not Found"));
                roles.add(userRole);
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
