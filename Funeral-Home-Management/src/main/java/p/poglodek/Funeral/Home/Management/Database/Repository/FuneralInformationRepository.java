package p.poglodek.Funeral.Home.Management.Database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.poglodek.Funeral.Home.Management.Database.Entity.FuneralInformation;
import p.poglodek.Funeral.Home.Management.Database.Entity.User;

import java.util.List;

@Repository
public interface FuneralInformationRepository extends JpaRepository<FuneralInformation, Long> {
    List<FuneralInformation> findByCreatedBy(User user);

}
