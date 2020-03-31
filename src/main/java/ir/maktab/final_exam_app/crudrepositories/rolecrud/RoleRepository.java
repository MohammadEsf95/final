package ir.maktab.final_exam_app.crudrepositories.rolecrud;

import ir.maktab.final_exam_app.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
