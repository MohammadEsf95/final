package ir.maktab.final_exam_app.crudrepositories.rolecrud;

import ir.maktab.final_exam_app.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findRoleById(Long id){
        return roleRepository.findById(id).get();
    }
}
