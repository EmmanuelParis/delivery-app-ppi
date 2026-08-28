package br.edu.catolica.seller_ms.repository;

import br.edu.catolica.seller_ms.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
