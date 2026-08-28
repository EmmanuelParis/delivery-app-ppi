package br.edu.catolica.seller_ms.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.Objects;

@Entity
@Table(name = "seller")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@SQLDelete(sql = "UPDATE seller SET is_active = false WHERE id = ?")
@SQLRestriction("is_active = true")
public class Seller extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(id, seller.id) && Objects.equals(cpf, seller.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}
