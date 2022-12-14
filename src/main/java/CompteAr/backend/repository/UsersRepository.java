package CompteAr.backend.repository;

import CompteAr.backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);

    Users findByEmail(String s);

    Users findByEmailAndPassword(String email, String password);
}
