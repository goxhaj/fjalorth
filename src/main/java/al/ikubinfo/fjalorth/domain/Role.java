package al.ikubinfo.fjalorth.domain;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    @Column(name = "role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
