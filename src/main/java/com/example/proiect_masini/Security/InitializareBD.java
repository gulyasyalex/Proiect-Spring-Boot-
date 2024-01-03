package com.example.proiect_masini.Security;

/*
import com.example.proiect_masini.Model.Masina;
import com.example.proiect_masini.Model.Utilizator;
import com.example.proiect_masini.Repository.MasinaRepository;
import com.example.proiect_masini.Repository.UtilizatorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitializareBD implements CommandLineRunner {

    UtilizatorRepository utilizatorRepository;
    PasswordEncoder passwordEncoder;
    MasinaRepository masinaRepository;

    public InitializareBD(UtilizatorRepository utilizatorRepository, PasswordEncoder passwordEncoder, MasinaRepository masinaRepository) {
        this.utilizatorRepository = utilizatorRepository;
        this.passwordEncoder = passwordEncoder;
        this.masinaRepository = masinaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        utilizatorRepository.deleteAll();
        Utilizator admin = new Utilizator("Admin", "admin", passwordEncoder.encode("admin") ,"ROLE_ADMIN");
        Utilizator user =  new Utilizator("User", "user", passwordEncoder.encode("user") ,"ROLE_USER");
        Utilizator alex =  new Utilizator("Alex", "alex", passwordEncoder.encode("admin") ,"ROLE_ADMIN");
        utilizatorRepository.saveAllAndFlush(List.of( admin, user, alex ));
        admin = utilizatorRepository.findByUtilizator("admin");
        masinaRepository.saveAndFlush(
                new Masina("TM22GUL", admin.getId_utilizator(),
                        "BMW","E36","Rosie",
                        1996,2499,"Benzina",
                        192,300,250,12499)
        );
    }
}
*/
