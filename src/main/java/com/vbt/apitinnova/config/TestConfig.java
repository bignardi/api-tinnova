package com.vbt.apitinnova.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vbt.apitinnova.entities.Car;
import com.vbt.apitinnova.entities.enums.CarStatus;
import com.vbt.apitinnova.repositories.CarRepository;

/*
 	Simula uma interface Front-End, aonde os recursos da classe controladora são aplicados
*/

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired // Injeção de Dependência automática
	private CarRepository carRepository;

	// Será executado tudo o que estiver neste método, assim que a aplicação for
	@Override
	public void run(String... args) throws Exception {

		// Domain Model
		// ISO 8601 para data e horário
		Car car01 = new Car(null, "x5", "bmw", 2016, "Preço sugerido: A partir de R$ 502.950", CarStatus.SOLD, Instant.parse("2019-06-20T19:53:07Z"), null);
		Car car02 = new Car(null, "serie 1", "bmw", 2017, "Preço sugerido: A partir de R$ 197.950", CarStatus.UNSOLD, Instant.parse("2019-07-21T03:42:10Z"), null);
		Car car03 = new Car(null, "classe c", "mercedes bens", 2020, "Preço sugerido: A partir de R$ 237.900", CarStatus.UNSOLD, Instant.parse("2020-03-19T07:32:11Z"), null);
		Car car04 = new Car(null, "classe a", "mercedes bens", 2021, "Preço sugerido: A partir de R$ 190.900", CarStatus.UNSOLD, Instant.parse("2021-01-20T10:11:15Z"), null);
		Car car05 = new Car(null, "renegade", "jeep", 2017, "Preço sugerido: A partir de R$ 69.999", CarStatus.SOLD, Instant.parse("2017-01-24T12:09:35Z"), null);
		Car car06 = new Car(null, "compass", "jeep", 2018, "Preço sugerido: A partir de R$ 138.320", CarStatus.SOLD, Instant.parse("2017-09-21T09:08:25Z"), null);
		Car car07 = new Car(null, "onix", "chevrolet", 2019, "Preço sugerido: A partir de R$ 62.150", CarStatus.UNSOLD, Instant.parse("2018-03-09T10:04:21Z"), null);
		Car car08 = new Car(null, "onix", "chevrolet", 2010, "Preço sugerido: A partir de R$ 19.500", CarStatus.SOLD, Instant.parse("2009-03-09T10:04:21Z"), null);
		Car car09 = new Car(null, "cruze", "chevrolet", 2014, "Preço sugerido: A partir de R$ 33.300", CarStatus.UNSOLD, Instant.parse("2018-03-09T10:04:21Z"), null);
		Car car10 = new Car(null, "jetta", "volkswagen", 1995, "Preço sugerido: A partir de R$ 406.520", CarStatus.UNSOLD, Instant.parse("2018-03-09T10:04:21Z"), null);
		Car car11 = new Car(null, "virtus", "volkswagen", 2019, "Preço sugerido: A partir de R$ 68.490", CarStatus.SOLD, Instant.parse("2019-06-20T19:53:07Z"), null);
		Car car12 = new Car(null, "del rey", "ford", 1981 , "Preço sugerido: A partir de R$ 20.000" , CarStatus.UNSOLD, Instant.parse("2018-03-09T10:04:21Z"), null);
		Car car13 = new Car(null, "fiesta", "ford", 2004, "Preço sugerido: A partir de R$ 12.000", CarStatus.SOLD, Instant.parse("2017-01-24T12:09:35Z"), null);
		Car car14 = new Car(null, "novo uno", "fiat", 2012, "Preço sugerido: A partir de R$ 15.300", CarStatus.SOLD, Instant.parse("2018-03-09T10:04:21Z"), null);
		Car car15 = new Car(null, "fusca fafa", "volkswagen", 1972, "Preço sugerido: A partir de R$ 50.000", CarStatus.UNSOLD, Instant.parse("2018-03-09T10:04:21Z"), null);
		Car car16 = new Car(null, "novo civic", "honda", 2021, "Preço sugerido: A partir de R$ 119.000", CarStatus.UNSOLD, Instant.parse("2021-04-01T10:04:21Z"), null);
		Car car17 = new Car(null, "novo fit", "honda", 2021, "Preço sugerido: A partir de R$ 78.699.000", CarStatus.UNSOLD, Instant.parse("2021-04-01T10:04:21Z"), null);
		Car car18 = new Car(null, "novo corolla", "toyota", 2021, "Preço sugerido: A partir de R$ 119.000", CarStatus.UNSOLD, Instant.parse("2021-04-01T10:04:21Z"), null);
		Car car19 = new Car(null, "novo etios", "toyota", 2021, "Preço sugerido: A partir de R$ 61.000", CarStatus.UNSOLD, Instant.parse("2021-04-01T10:04:21Z"), null);
		Car car20 = new Car(null, "nova hilux", "toyota", 2021, "Preço sugerido: A partir de R$ 139.900", CarStatus.UNSOLD, Instant.parse("2021-04-01T10:04:21Z"), null);
		
		// Passando a list de objetos para inserção no banco de dados
		carRepository.saveAll(Arrays.asList(car01, car02, car03, car04, car05, car06, car07, car08, car09, car10, car11,
				car12, car13, car14, car15, car16, car17, car18, car19, car20));
	}

}
