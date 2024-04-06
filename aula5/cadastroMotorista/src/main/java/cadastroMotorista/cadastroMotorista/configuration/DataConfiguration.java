package cadastroMotorista.cadastroMotorista.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//Drive do BD
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//URL do BD
		dataSource.setUrl("jdbc:mysql://localhost:3306/db_curso_spring?useTimezone=true&serverTimezone=UTC");
		//Usuario
		dataSource.setUsername("root");
		//Senha
		dataSource.setPassword("bruno2004");
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		//Informa o tipo de BD que vai se ligar
		adapter.setDatabase(Database.MYSQL);
		//Solicita para mostrar o SQL que está sendo executado
		adapter.setShowSql(true);
		//Caso as tabelas não existam crie
		adapter.setGenerateDdl(true);
		//Qual o tipo de SQL que vai ser usado
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		//Inicie a conexão
		adapter.setPrepareConnection(true);
		
		return adapter;
	}
}
