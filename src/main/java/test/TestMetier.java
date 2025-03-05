package test;

import java.util.List;

import dao.LivreDaoImpl;
import metier.entities.Livre;

public class TestMetier {
    public static void main(String[] args) {
        LivreDaoImpl ldao = new LivreDaoImpl();
        
        Livre livre = ldao.save(new Livre("1984", "George Orwell", 50, 1949));
        System.out.println(livre);
        
      
        List<Livre> livres = ldao.livresParMC("Or");
        for (Livre l : livres)
            System.out.println(l);
    }
}