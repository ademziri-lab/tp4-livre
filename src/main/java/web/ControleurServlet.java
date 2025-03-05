package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.ILivreDao;
import dao.LivreDaoImpl;
import metier.entities.Livre;

@WebServlet(name="cs", urlPatterns={"/controleur", "*.do"})
public class ControleurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ILivreDao metier;
    
    @Override
    public void init() throws ServletException {
        metier = new LivreDaoImpl();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = request.getServletPath();
        
        if (path.equals("/index.do")) {
            request.getRequestDispatcher("livres.jsp").forward(request, response);
        }
        else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            LivreModele model = new LivreModele();
            model.setMotCle(motCle);
            List<Livre> livres = metier.livresParMC(motCle);
            model.setLivres(livres);
            request.setAttribute("model", model);
            request.getRequestDispatcher("livres.jsp").forward(request, response);
        }
        else if (path.equals("/saisie.do")) {
            request.getRequestDispatcher("saisieLivre.jsp").forward(request, response);
        }
        else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
            String titre = request.getParameter("titre");
            String auteur = request.getParameter("auteur");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int annee = Integer.parseInt(request.getParameter("annee"));
            
            Livre l = metier.save(new Livre(titre, auteur, prix, annee));
            request.setAttribute("livre", l);
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);
        }
        else if (path.equals("/supprimer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deleteLivre(id);
            response.sendRedirect("chercher.do?motCle=");
        }
        else if (path.equals("/editer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Livre l = metier.getLivre(id);
            request.setAttribute("livre", l);
            request.getRequestDispatcher("editerLivre.jsp").forward(request, response);
        }
        else if (path.equals("/update.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            String titre = request.getParameter("titre");
            String auteur = request.getParameter("auteur");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int annee = Integer.parseInt(request.getParameter("annee"));
            
            Livre l = new Livre();
            l.setIdLivre(id);
            l.setTitre(titre);
            l.setAuteur(auteur);
            l.setPrix(prix);
            l.setAnnee(annee);
            
            metier.updateLivre(l);
            response.sendRedirect("chercher.do?motCle=");
        }
        else {
            response.sendError(Response.SC_NOT_FOUND);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}