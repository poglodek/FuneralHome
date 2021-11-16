package p.poglodek.Funeral.Home.Management.Database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.poglodek.Funeral.Home.Management.Database.Entity.FlowerType;
import p.poglodek.Funeral.Home.Management.Database.Entity.User;

import java.util.List;

@Repository
public interface FlowerRepository extends JpaRepository<FlowerType,Long> {

    List<FlowerType> findAll();
    List<FlowerType> findByUser(User user);
}
