package p.poglodek.Funeral.Home.Management.Database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.poglodek.Funeral.Home.Management.Database.entity.flowerType;

import java.util.List;
import java.util.Optional;

@Repository
public interface flowerReposiotry extends JpaRepository<flowerType,Long> {

    List<flowerType> findAll();
}
