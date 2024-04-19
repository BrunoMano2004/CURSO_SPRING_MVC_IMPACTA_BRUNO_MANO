package integracao_api.integracao_api;

import integracao_api.integracao_api.client.PhotoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //Para habilitar o consumo de API
public class IntegracaoApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IntegracaoApiApplication.class, args);
	}

	@Autowired
	private PhotoClient photoClient;
	//Apenas para teste e usar para testar algo
	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.photoClient.getPhotos());
	}
}
