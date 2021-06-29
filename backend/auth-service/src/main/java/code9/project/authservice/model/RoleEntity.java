package code9.project.authservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role", schema = "users")
public class RoleEntity {
    private int id;
    private String name;
    private List<UserEntity> userEntityList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleEntity")
    public List<UserEntity> getUsers() {
        return userEntityList;
    }

    public void setUsers(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }
}
