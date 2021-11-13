package p.poglodek.Funeral.Home.Management.Database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.poglodek.Funeral.Home.Management.Database.entity.burialType;
import p.poglodek.Funeral.Home.Management.Database.entity.user;

import java.util.List;

@Repository
public interface burialTypeRepository extends JpaRepository<burialType,Long> {
    List<burialType> findAll();
    List<burialType> findByUser(user user);
}
