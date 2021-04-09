package br.com.garbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration //Permitir que o application content do spring seja automaticamente carregado com os jars e configurações definidas. É feito após o carregamento dos Beans
@ComponentScan //Para scanear os pacotes e encontrar arquivos de configuração(como o webconfig)
public class Startup {
	
	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}
}
