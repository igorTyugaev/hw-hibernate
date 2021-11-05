package models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "school")
public class School {
    private int id;
    private int num;
    private int addressId;
    private Collection<Child> childrenById;
    private Address addressByAddressId;

    public School() {
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "num", nullable = false)
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        School school = (School) o;

        if (id != school.id) return false;
        if (num != school.num) return false;
        if (addressId != school.addressId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + num;
        result = 31 * result + addressId;
        return result;
    }

    @OneToMany(mappedBy = "schoolByEducationId")
    public Collection<Child> getChildrenById() {
        return childrenById;
    }

    public void setChildrenById(Collection<Child> childrenById) {
        this.childrenById = childrenById;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }
}
