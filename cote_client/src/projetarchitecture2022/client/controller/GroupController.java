package projetarchitecture2022.client.controller;

/*
 *Lecture, création, modification, suppression,création aléatoire
 *@params: Group
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projetarchitecture2022.model.*;

public class GroupController {

    /*
     *retourne la liste de tout les groupes 
     *@params: void
     *Retour : ArrayList de groupes 
     */
    public ArrayList<Group> getListeGroupes() {
        ArrayList<Group> temp = new ArrayList<Group>();
        String query = "SELECT * FROM groupe";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Integer id = rs.getInt("idgroup");
                String name = rs.getString("name");
                Integer idTU = rs.getInt("teachingunit");
                Integer idSubject = rs.getInt("subject");

                // get TU by ID
                TeachingUnit tu = new TeachingUnitController().getTeachingUnitById(idTU);

                // appel à SujetControleur getById
                Subject sub = new SubjectController().getSubjectById(idSubject);

                // get liste des eleves dans ce groupe
                ArrayList<Student> stud = getListStudentByGroupId(id);

                Group group = new Group(id, name, tu, stud, sub);
                temp.add(group);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return temp;
    }

    public ArrayList<Group> getListeGroupesByUE(TeachingUnit tu) {
        ArrayList<Group> temp = new ArrayList<Group>();
        String query = "SELECT * FROM `groupe` WHERE teachingunit = ?";

        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, tu.getId());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("idgroup");
                String name = rs.getString("name");
                Integer idSubject = rs.getInt("subject");

                // appel à SujetControleur getById
                Subject sub = new SubjectController().getSubjectById(idSubject);

                // get liste des eleves dans ce groupe
                ArrayList<Student> studs = getListStudentByGroupId(id);

                Group group = new Group(id, name, tu, studs, sub);
                temp.add(group);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return temp;
    }

    private ArrayList<Student> getListStudentByGroupId(Integer groupId) {
        ArrayList<Student> temp = new ArrayList<Student>();
        String query = "SELECT * FROM groupstudent WHERE `idgroup` = ?";

        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, groupId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student stud = new StudentController().getStudentById(rs.getInt("idstudent"));
                temp.add(stud);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return temp;
    }

    public void addGroupe(Group group) {
        String query = "";
        try {
            Connection con = connectionDB.getConnection();

            query = "INSERT INTO `groupe`  (name,teachingunit,subject) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, group.getName());
            ps.setInt(2, group.getTeachingUnit().getId());
            ps.setInt(3, group.getSubject().getId());
            ps.executeUpdate();

            ps.clearParameters();
            
            String query_get_last_group = "SELECT idgroup FROM `groupe` ORDER BY idgroup DESC LIMIT 1";
            int idgroup=0;
            try {
                ps = con.prepareStatement(query_get_last_group);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    idgroup = rs.getInt(1);
                }
                System.out.println("idgroup " + idgroup);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            } 
            
            
            
            ArrayList<Student> studList = group.getStudents();
            query = "INSERT INTO `groupstudent` (idstudent, idgroup) VALUES (?, ?)";
            ps = con.prepareStatement(query);
            for (int i = 0; i < studList.size(); i++) {
                System.out.println(studList.get(i).getId());
                ps.setInt(1, studList.get(i).getId());
                ps.setInt(2, idgroup);
                System.out.println(" id_stu "+ studList.get(i).getId());
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /*
     *supprimer un group par id
     *@params: Group
     *Retour : void
     */
    public void deleteGroup(Group group) {
        String query = "DELETE FROM `groupe`" + "WHERE idgroup = ?";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, group.getId());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /*
     *change de group d'étudiant
     *@params: Group, TeachingUnit ,Student
     *Retour : void
     */
    public void changeStudentGroup(TeachingUnit tu, Group group, Student stud) {
        String query = "UPDATE `groupstudent` SET `idgroup` = ? WHERE `idstudent` = ? AND (SELECT `idteachingunit` FROM `group` WHERE `idgroup` = ?) = ?";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, group.getId());
            ps.setInt(2, stud.getId());
            ps.setInt(3, group.getId());
            ps.setInt(4, tu.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
