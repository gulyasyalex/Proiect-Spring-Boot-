package com.example.proiect_masini.Service;

import com.example.proiect_masini.Model.SecurityUser;
import com.example.proiect_masini.Model.Utilizator;
import com.example.proiect_masini.Repository.UtilizatorRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    private final UtilizatorRepository utilizatorRepository;

    public JpaUserDetailsService(UtilizatorRepository utilizatorRepository) {

        this.utilizatorRepository = utilizatorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilizator utilizator= utilizatorRepository.findByUtilizator(username);
        if(utilizator==null)
            throw new UsernameNotFoundException("Username not found");
        return new SecurityUser(utilizator);

    }
}
