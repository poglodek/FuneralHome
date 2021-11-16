package p.poglodek.Funeral.Home.Management.Database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.poglodek.Funeral.Home.Management.Database.entity.FlowerType;
import p.poglodek.Funeral.Home.Management.Database.entity.User;

import java.util.List;

@Repository
public interface FlowerRepository extends JpaRepository<FlowerType,Long> {

    List<FlowerType> findAll();
    List<FlowerType> findByUser(User user);
}
