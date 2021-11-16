package p.poglodek.Funeral.Home.Management.Database.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import p.poglodek.Funeral.Home.Management.Database.Entity.Client;
import p.poglodek.Funeral.Home.Management.Database.Entity.User;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByCreatedBy(User user);
}
