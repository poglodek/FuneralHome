package p.poglodek.Funeral.Home.Management.Database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.poglodek.Funeral.Home.Management.Database.Entity.BurialType;
import p.poglodek.Funeral.Home.Management.Database.Entity.User;

import java.util.List;

@Repository
public interface BurialTypeRepository extends JpaRepository<BurialType,Long> {
    List<BurialType> findAll();
    List<BurialType> findByUser(User user);
}
