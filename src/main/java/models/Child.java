package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "child")
public class Child {
    private int id;
    private String fullName;
    private int age;
    private int educationId;
    private School schoolByEducationId;

    public Child() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "full_name", nullable = false, length = 120)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Child child = (Child) o;

        if (id != child.id) return false;
        if (age != child.age) return false;
        if (educationId != child.educationId) return false;
        if (fullName != null ? !fullName.equals(child.fullName) : child.fullName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + educationId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "education_id", referencedColumnName = "id", nullable = false)
    public School getSchoolByEducationId() {
        return schoolByEducationId;
    }

    public void setSchoolByEducationId(School schoolByEducationId) {
        this.schoolByEducationId = schoolByEducationId;
    }

    @ManyToMany(mappedBy = "child")
    private List<Parent> parents;
}
