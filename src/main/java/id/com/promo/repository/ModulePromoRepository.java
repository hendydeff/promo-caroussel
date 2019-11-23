package id.com.promo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.com.promo.entity.ModulePromo;

public interface ModulePromoRepository extends JpaRepository<ModulePromo, Long> {

	@Query(value = "SELECT u.id, u.module_name, g.module_order FROM module_promo u "
			+ "INNER JOIN group_user g ON u.id = g.module_promo_id "
			+ "WHERE g.group_id = ?1 ORDER BY g.module_order ASC", nativeQuery = true)
	Optional<List<ModulePromo>> findModulePromoByGroupId(Integer groupID);

}
