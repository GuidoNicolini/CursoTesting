package com.guido.testServicios;

import com.guido.testServicios.exceptions.DineroInsuficienteException;
import com.guido.testServicios.models.Cuenta;
import com.guido.testServicios.repositories.CuentaRepository;
import com.guido.testServicios.services.CuentaService;
import static org.junit.jupiter.api.Assertions.*;

import com.guido.testServicios.services.CuentaServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestServiciosApplicationTests {

	@Mock //@MockBean -> App Spring
	CuentaRepository cuentaRepository;

	@InjectMocks // @Autowired -> App Spring
	CuentaServiceImpl cuentaService;


	@Test
	void contextLoads() {
	}


	@Test
	void test1() {

		when(cuentaRepository.findById(1L)).thenReturn(Datos.CUENTA_001);
		when(cuentaRepository.findById(2L)).thenReturn(Datos.CUENTA_002);

		Cuenta c1  = cuentaService.findById(1L);
		Cuenta c2  = cuentaService.findById(2L);
		cuentaService.transeferir(1L,2L,500L);

		assertEquals("Guido",c1.getNombre());
		assertTrue(c1.getSaldo() >= 500 && c2.getSaldo() >= 500);
		assertEquals(500L,c1.getSaldo());
		verify(cuentaRepository,times(2)).update(any(Cuenta.class));


	}

	@Test
	void test2() {
		when(cuentaRepository.findById(1L)).thenReturn(Datos.CUENTA_001);

		Cuenta c1  = cuentaService.findById(1L);


		assertThrows(DineroInsuficienteException.class,()->{
			c1.debito(999999990L);
		});
	}
}
