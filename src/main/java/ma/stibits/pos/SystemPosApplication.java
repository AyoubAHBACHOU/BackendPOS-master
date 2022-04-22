package ma.stibits.pos;

import ma.stibits.pos.service.Implementation.MerchantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemPosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemPosApplication.class, args);
	}

}
