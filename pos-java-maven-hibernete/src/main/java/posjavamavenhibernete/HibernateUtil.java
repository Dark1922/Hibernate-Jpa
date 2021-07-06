package posjavamavenhibernete;

import javax.persistence.EntityManagerFactory;

public class HibernateUtil {
	//deixar istanciado a conexão com o banco de dados 
	
	//static pq só pode ler o arquivo apenas uma vez para evitar erros
	public static EntityManagerFactory factory = null;
	

}
