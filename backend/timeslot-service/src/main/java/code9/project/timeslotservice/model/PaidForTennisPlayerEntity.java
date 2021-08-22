package code9.project.timeslotservice.model;

import javax.persistence.*;

@Entity
@Table(name = "paid_for_tennis_player", schema = "timeslots")
public class PaidForTennisPlayerEntity {

    private int tennisPlayerId;
    private PaymentMethodEntity paymentMethod;

    @Id
    @Column(name = "tennis_player_id")
    public int getTennisPlayerId() {
        return tennisPlayerId;
    }

    public void setTennisPlayerId(int tennisPlayerId) {
        this.tennisPlayerId = tennisPlayerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaidForTennisPlayerEntity that = (PaidForTennisPlayerEntity) o;

        if (tennisPlayerId != that.tennisPlayerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return tennisPlayerId;
    }

    @ManyToOne
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id", nullable = false)
    public PaymentMethodEntity getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodEntity paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}

