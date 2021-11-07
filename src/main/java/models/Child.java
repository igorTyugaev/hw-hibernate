package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "child")
public class Child {
    public Child() {
    }

    public Child(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public Child(String fullName, int age, School school, Set<Parent> parents) {
        this.fullName = fullName;
        this.age = age;
        this.school = school;
        this.parents = parents;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "full_name", nullable = false, length = 120)
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "age", nullable = false)
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @ManyToMany(mappedBy = "children")
    private Set<Parent> parents = new HashSet<>();

    public Set<Parent> getParents() {
        return parents;
    }

    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }

    public void addParent(Parent parent) {
        parent.addChild(this);
        this.parents.add(parent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Child child = (Child) o;

        if (id != child.id) return false;
        if (age != child.age) return false;
        if (fullName != null ? !fullName.equals(child.fullName) : child.fullName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
