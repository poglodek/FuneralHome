package p.poglodek.Funeral.Home.Management.Database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.poglodek.Funeral.Home.Management.Database.entity.flowerType;
import p.poglodek.Funeral.Home.Management.Database.entity.user;

import java.util.List;
import java.util.Optional;

@Repository
public interface flowerRepository extends JpaRepository<flowerType,Long> {

    List<flowerType> findAll();
    List<flowerType> findByUser(user user);
}
