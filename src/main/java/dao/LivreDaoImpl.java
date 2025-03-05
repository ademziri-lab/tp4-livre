package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Livre;

public class LivreDaoImpl implements ILivreDao {

    @Override
    public Livre save(Livre l) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO LIVRES(TITRE, AUTEUR, PRIX, ANNEE) VALUES(?, ?, ?, ?)");
            ps.setString(1, l.getTitre());
            ps.setString(2, l.getAuteur());
            ps.setDouble(3, l.getPrix());
            ps.setInt(4, l.getAnnee());
            ps.executeUpdate();
            
            PreparedStatement ps2 = conn.prepareStatement(
                    "SELECT MAX(ID_LIVRE) as MAX_ID FROM LIVRES");
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                l.setIdLivre(rs.getLong("MAX_ID"));
            }
            ps.close();
            ps2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }

    @Override
    public List<Livre> livresParMC(String mc) {
        List<Livre> livres = new ArrayList<Livre>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM LIVRES WHERE TITRE LIKE ? OR AUTEUR LIKE ?");
            ps.setString(1, "%" + mc + "%");
            ps.setString(2, "%" + mc + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Livre l = new Livre();
                l.setIdLivre(rs.getLong("ID_LIVRE"));
                l.setTitre(rs.getString("TITRE"));
                l.setAuteur(rs.getString("AUTEUR"));
                l.setPrix(rs.getDouble("PRIX"));
                l.setAnnee(rs.getInt("ANNEE"));
                livres.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livres;
    }

    @Override
    public Livre getLivre(Long id) {
        Connection conn = SingletonConnection.getConnection();
        Livre l = new Livre();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM LIVRES WHERE ID_LIVRE = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                l.setIdLivre(rs.getLong("ID_LIVRE"));
                l.setTitre(rs.getString("TITRE"));
                l.setAuteur(rs.getString("AUTEUR"));
                l.setPrix(rs.getDouble("PRIX"));
                l.setAnnee(rs.getInt("ANNEE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }

    @Override
    public Livre updateLivre(Livre l) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE LIVRES SET TITRE=?, AUTEUR=?, PRIX=?, ANNEE=? WHERE ID_LIVRE=?");
            ps.setString(1, l.getTitre());
            ps.setString(2, l.getAuteur());
            ps.setDouble(3, l.getPrix());
            ps.setInt(4, l.getAnnee());
            ps.setLong(5, l.getIdLivre());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }

    @Override
    public void deleteLivre(Long id) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM LIVRES WHERE ID_LIVRE = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}