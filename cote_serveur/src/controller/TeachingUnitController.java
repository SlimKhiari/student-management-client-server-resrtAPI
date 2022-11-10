package controller;

/*
 *classe de Lecture, création, et  suppression d'UE
 *@params: TeachingUnit
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projetarchitecture2022.model.TeachingUnit;

public class TeachingUnitController {

    /*
     *recuperer toute la liste des UE
     *@params: TeachingUnit
     *Retour : ArrayList d'UE
     */
    public ArrayList<TeachingUnit> getTeachingUnits() {
        ArrayList<TeachingUnit> teachingUnits = new ArrayList<TeachingUnit>();
        String query = "SELECT * FROM teachingunit";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TeachingUnit tu = new TeachingUnit(rs.getInt(1), rs.getString(2));
                teachingUnits.add(tu);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return teachingUnits;
    }

    /*
     *récupère une UE par id
     *@params: TeachingUnit
     *Retour : une UE
     */
    public TeachingUnit getTeachingUnitById(int IdTU) {
        TeachingUnit tu = null;
        String query = "SELECT `idteachingunit`,`title` FROM teachingunit WHERE idteachingunit = ?";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, IdTU);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tu = new TeachingUnit(IdTU, rs.getString(2));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tu;
    }
    
    public TeachingUnit getTeachingUnitByTitle(String IdTU) {
        TeachingUnit tu = null;
        String query = "SELECT `idteachingunit`,`title` FROM teachingunit WHERE title = ?";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, IdTU);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tu = new TeachingUnit(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tu;
    }

    /*
     *crée une nouvelle UE 
     *@params: TeachingUnit
     *Retour : void
     */
    public void createTeachingunit(TeachingUnit tu) {
        String query = "INSERT INTO `teachingunit` (`title`) VALUES (?)";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, tu.getTitle());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /*
     *supprime une UE par id
     *@params: TeachingUnit
     *Retour : void
     */
    public void deleteTeachingunit(TeachingUnit tu) {
        String query = "DELETE FROM `teachingunit` WHERE idteachingunit=?";

        try {
            Connection connection = connectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, tu.getId());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
