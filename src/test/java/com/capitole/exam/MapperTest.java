package com.capitole.exam;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import com.capitole.exam.domain.PricesDto;
import com.capitole.exam.domain.PricesEntity;
import com.capitole.exam.mapping.PricesMapper;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = ExamApplication.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureTestDatabase
@ActiveProfiles("logging-test")
class MapperTest {

	private final PricesMapper mapper = Mappers.getMapper(PricesMapper.class);
	
	@Test
	void testPrice(){
		
		PricesEntity source = new PricesEntity();
		
		source.setPriceId(Long.valueOf(1));
		source.setBrandId((long) 1);
		source.setCurr("10.1");
		
		
		final PricesDto target = mapper.priceDbToPricesDto(source);
		
		Assert.assertNotNull(target);
		Assert.assertEquals("10.1",target.getCurr());
		
	}
	
}
