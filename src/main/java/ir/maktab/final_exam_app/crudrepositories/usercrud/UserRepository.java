package ir.maktab.final_exam_app.crudrepositories.usercrud;

import ir.maktab.final_exam_app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    List<User> findUserByPassword(String password);
}
