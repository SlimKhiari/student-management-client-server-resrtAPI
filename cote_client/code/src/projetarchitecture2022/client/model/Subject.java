package projetarchitecture2022.model;

public class Subject {

    public Integer id;
    public String title;
    public String description;
    // On devrait pas les attaché à un EducationUnit?

    public Subject(Integer id, String title, String description) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Subject(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title;
    }
}
