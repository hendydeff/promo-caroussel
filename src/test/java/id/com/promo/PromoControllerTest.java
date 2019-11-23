package id.com.promo;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import id.com.promo.entity.ModulePromo;
import id.com.promo.repository.ModulePromoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PromoControllerTest {

	@MockBean
	private ModulePromoRepository modulePromoRepository;

	@Test
	public void testGetEmployeeListSuccess() {
		Optional<List<ModulePromo>> result = modulePromoRepository.findModulePromoByGroupId(1);

		Assert.assertEquals(false, result.isPresent());
	}

}
