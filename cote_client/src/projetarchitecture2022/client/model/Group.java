package projetarchitecture2022.client.model;

/*
 *Methodes de création, selection , modification et suppression concernant l groupe
 *@params: Group
 */
import java.util.ArrayList;

public class Group {

    public Integer id;
    public String name;
    public TeachingUnit teachingunit;
    public ArrayList<Student> students; //j'utilise un arraylist le nombre de personnes pouvant varier
    public Subject subject;

    /*
 *Constructeur avec id de groupe
 *@params: Group
     */
    public Group(Integer id, String name, TeachingUnit teachingUnit, ArrayList<Student> students, Subject subject) {
        super();
        this.id = id;
        this.name = name;
        this.teachingunit = teachingUnit;
        this.students = students;
        this.subject = subject;
    }

    /*
 *Constructeur sans id de groupe
 *@params: Group
     */
    public Group(String name, TeachingUnit teachingUnit, ArrayList<Student> students, Subject subject) {
        super();
        this.name = name;
        this.teachingunit = teachingUnit;
        this.students = students;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeachingUnit getTeachingUnit() {
        return teachingunit;
    }

    public void setTeachingUnit(TeachingUnit teachingUnit) {
        this.teachingunit = teachingUnit;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /*
 *methode toString pour retourner le nom et l'id du group en string
 *@params: Group
     */
    @Override
    public String toString() {
        String subjectName = "PAS DE SUJET!";
        if (subject != null) {
            subjectName = subject.getTitle();
        }
        return getName() + " - [" + teachingunit.getId() + "] - " + subjectName + " Subject: " + getSubject().toString() + " Students: " + getStudents().toString() + " ue "+ getTeachingUnit().toString();
    }
}
