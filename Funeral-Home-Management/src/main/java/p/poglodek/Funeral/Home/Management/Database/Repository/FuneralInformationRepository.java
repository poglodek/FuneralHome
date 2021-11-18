package p.poglodek.Funeral.Home.Management.Database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.poglodek.Funeral.Home.Management.Database.Entity.FuneralInformation;

@Repository
public interface FuneralInformationRepository extends JpaRepository<FuneralInformation, Long> {

}
