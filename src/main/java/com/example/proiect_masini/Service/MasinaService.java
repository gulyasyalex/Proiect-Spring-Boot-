package com.example.proiect_masini.Service;

import com.example.proiect_masini.Model.Masina;
import com.example.proiect_masini.Repository.MasinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MasinaService {
    private MasinaRepository masinaRepository;

    public MasinaService(){}
    @Autowired
    public MasinaService(MasinaRepository masinaRepository) {
        this.masinaRepository = masinaRepository;
    }

    public List<Masina> findAll(){
        return masinaRepository.findAll();
    }

    public List<Masina> findAllByKeywords(String filter1, String filter2, String filter3){
        if(filter1.isEmpty())
            filter1=null;
        if(filter2.isEmpty())
            filter2=null;
        if(filter3.isEmpty())
            filter3=null;
        return masinaRepository.findAllByKeywords(filter1,filter2,filter3);
    }

    public boolean addMasina(Masina masina){
        System.out.println(masinaRepository.findMasinaByNumarInmatriculare(masina.getNumarInmatriculare()));

        if(masinaRepository.findMasinaByNumarInmatriculare(masina.getNumarInmatriculare()).isEmpty()
            && masina.getNumarInmatriculare().length()==7) {
            masinaRepository.saveAndFlush(masina);
            return false;
        }
        return true;
    }

    public boolean modifyMasina(Masina masina) {
        Optional<Masina> existingMasinaOptional = masinaRepository.findMasinaByNumarInmatriculare(masina.getNumarInmatriculare());

        if (existingMasinaOptional.isPresent() && masina.getNumarInmatriculare().length()==7) {
            Masina masina1 = existingMasinaOptional.get();

            if (masina.getMarca() != null && !masina.getMarca().isEmpty()) {
                masina1.setMarca(masina.getMarca());
            }
            if (masina.getModelul() != null && !masina.getModelul().isEmpty()) {
                masina1.setModelul(masina.getModelul());
            }
            if (masina.getCuloarea() != null && !masina.getCuloarea().isEmpty()) {
                masina1.setCuloarea(masina.getCuloarea());
            }
            if (masina.getAnul_fabricatiei() != null && masina.getAnul_fabricatiei() > 0) {
                masina1.setAnul_fabricatiei(masina.getAnul_fabricatiei());
            }
            if (masina.getCapacitatea_cilindrica() != null && masina.getCapacitatea_cilindrica() > 0) {
                masina1.setCapacitatea_cilindrica(masina.getCapacitatea_cilindrica());
            }
            if (masina.getTipul_de_combustibil() != null && !masina.getTipul_de_combustibil().isEmpty()) {
                masina1.setTipul_de_combustibil(masina.getTipul_de_combustibil());
            }
            if (masina.getPuterea() != null && masina.getPuterea() > 0) {
                masina1.setPuterea(masina.getPuterea());
            }
            if (masina.getCuplul() != null && masina.getCuplul() > 0) {
                masina1.setCuplul(masina.getCuplul());
            }
            if (masina.getVolumul_portbagajului() != null && masina.getVolumul_portbagajului() > 0) {
                masina1.setVolumul_portbagajului(masina.getVolumul_portbagajului());
            }
            if (masina.getPretul() != null && masina.getPretul() > 0) {
                masina1.setPretul(masina.getPretul());
            }
            masinaRepository.saveAndFlush(masina1);
            return false;
        }
        return true;
    }

    public boolean deleteMasina(Masina masina){
        if(masinaRepository.findMasinaByNumarInmatriculare(masina.getNumarInmatriculare()).isPresent()) {
            masinaRepository.delete(masinaRepository.findMasinaByNumarInmatriculare(masina.getNumarInmatriculare()).get());
            masinaRepository.flush();
            return false;
        }
        return true;
    }
}
