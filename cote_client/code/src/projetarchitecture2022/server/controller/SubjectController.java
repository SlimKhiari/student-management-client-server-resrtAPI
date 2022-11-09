package projetarchitecture2022.controller;

/*
 *classe de Lecture, création, et  suppression de sujet de groupe
 *@params: Subject
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projetarchitecture2022.model.Subject;

public class SubjectController {

    /*
     *recuperer tout les sujets
     *@params: Subject
     *Retour : ArrayList de sujets
     */
    public ArrayList<Subject> getSubjects() {
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        String query = "SELECT * FROM subject";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject sub = new Subject(rs.getInt(1), rs.getString(2), rs.getString(3));
                subjects.add(sub);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return subjects;
    }

    /*
     *recuperer un sujet par id
     *@params: Subject
     *Retour : Un sujet
     */
    public Subject getSubjectById(int subjectId) {
        Subject sub = null;
        String query = "SELECT `idsubject`,`title`,`description` FROM subject WHERE idsubject = ?";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, subjectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sub = new Subject(subjectId, rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return sub;
    }
    
    public Subject getSubjectByTitle(String subjectId) {
        Subject sub = null;
        String query = "SELECT `idsubject`,`title`,`description` FROM subject WHERE title = ?";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, subjectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sub = new Subject(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return sub;
    }

    /*
     *crée un nouveau sujet de groupe
     *@params: Subject
     *Retour : void
     */
    public void createSubject(Subject sub) {
        String query = "INSERT INTO `subject` (`title`,`description`) VALUES (?, ?)";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, sub.getTitle());
            ps.setString(2, sub.getDescription());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /*
     *supprime un sujet par id
     *@params: Subject
     *Retour : void
     */
    public void deleteSubject(Subject sub) {
        String query = "DELETE FROM `subject` WHERE idsubject=?";

        try {
            Connection connection = connectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, sub.getId());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
