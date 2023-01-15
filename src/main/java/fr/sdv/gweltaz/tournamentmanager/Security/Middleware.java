package fr.sdv.gweltaz.tournamentmanager.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Middleware {
    public static void verifyAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!authentication.getAuthorities().contains("ADMIN") && !authentication.getAuthorities().contains("VISITOR")){
            throw new SecurityException();
        }
    }

    public static void verifyAuthAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!authentication.getAuthorities().contains("ADMIN")){
            throw new SecurityException();
        }
    }
}
