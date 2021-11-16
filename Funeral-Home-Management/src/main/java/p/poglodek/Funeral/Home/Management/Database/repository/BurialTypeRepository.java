package p.poglodek.Funeral.Home.Management.Database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.poglodek.Funeral.Home.Management.Database.entity.BurialType;
import p.poglodek.Funeral.Home.Management.Database.entity.User;

import java.util.List;

@Repository
public interface BurialTypeRepository extends JpaRepository<BurialType,Long> {
    List<BurialType> findAll();
    List<BurialType> findByUser(User user);
}
