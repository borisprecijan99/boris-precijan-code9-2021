package code9.project.timeslotservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment_method", schema = "timeslots")
public class PaymentMethodEntity {
    private int id;
    private String name;
    private List<PaidForTennisPlayerEntity> paidForTennisPlayers;

    @Id
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

        PaymentMethodEntity that = (PaymentMethodEntity) o;

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

    @OneToMany(mappedBy = "paymentMethod")
    public List<PaidForTennisPlayerEntity> getPaidForTennisPlayers() {
        return paidForTennisPlayers;
    }

    public void setPaidForTennisPlayers(List<PaidForTennisPlayerEntity> paidForTennisPlayers) {
        this.paidForTennisPlayers = paidForTennisPlayers;
    }
}

