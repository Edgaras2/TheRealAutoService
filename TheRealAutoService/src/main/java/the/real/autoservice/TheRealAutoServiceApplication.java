package the.real.autoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TheRealAutoServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(TheRealAutoServiceApplication.class, args);
		System.out.println("zzz");
		System.out.println("zz");
	}
}
