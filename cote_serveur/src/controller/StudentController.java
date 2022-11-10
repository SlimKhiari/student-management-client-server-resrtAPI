package controller;

/*
 *classe de Lecture, création, et  suppression d'étudiant
 *@params: Student
 */
import java.sql.*;
import java.util.ArrayList;
import projetarchitecture2022.model.Student;

public class StudentController {

    /*
     *retourne la liste de tous les étudiants 
     *@params: Student
     *Retour : ArrayList d'étudiants
     */
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        String query = "SELECT * FROM student";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student stud = new Student(rs.getInt(1), rs.getString(2), rs.getString(3));
                students.add(stud);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return students;
    }

    /*
     *retourne un étudiant par id 
     *@params: Student
     *Retour : Retourne un étudiant
     */
    public Student getStudentById(int studentId) {
        Student student = null;
        String query = "SELECT `idstudent`,`firstname`,`lastname` FROM student WHERE idstudent = ?";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student(studentId, rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return student;
    }

    /*
     *créer un nouvel étudiant 
     *@params: Student
     *Retour : void
     */
    public void createStudent(Student stud) {
        String query = "INSERT INTO `student` (`firstname`, `lastname`) VALUES (?, ?)";
        try {
            Connection con = connectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, stud.getFirstname());
            ps.setString(2, stud.getLastname());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /*
     *supprime un étudiant par id 
     *@params: Student
     *Retour : void
     */
    public void deleteStudent(Student stud) {
        String query = "DELETE FROM `student` WHERE idstudent=?";

        try {
            Connection connection = connectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, stud.getId());
            ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
