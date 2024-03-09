package ir.fanap.loyalty.suna.config;


   import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface TokenRepository extends JpaRepository<Token, String> {
    Optional<Token> findByTokenAndValidTrue(String token);
    List<Token> findByExpireDateBefore(Date date);
    List<Token> findByValidFalse();
    List<Token> findByUserIdAndValidTrue(String userId);

}
