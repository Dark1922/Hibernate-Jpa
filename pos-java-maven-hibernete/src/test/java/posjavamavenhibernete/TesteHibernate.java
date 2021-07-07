package posjavamavenhibernete;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {

	@Test
	public void salvarUsuario() {
         //passa a nossa model pro generic
         DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa> ();
         
         UsuarioPessoa pessoa = new UsuarioPessoa();

         //seta os atributo id gera automaticamente
          
         pessoa.setNome("toca");
         pessoa.setSobrenome("rei");
         pessoa.setEmail("ardmir@gmail.com");
         pessoa.setLogin("imitan");
         pessoa.setSenha("qweqwqwe");
         pessoa.setIdade(33);
         
         daoGeneric.salvar(pessoa);
	}
	
	@Test
	public void testeBuscar() {
		
		 DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa> ();
		 
		 UsuarioPessoa pessoa = new UsuarioPessoa();
		 
		 pessoa.setId(2L);
		 
		 //método pesquisar retorna pessoa ent pode atribuir pessoa = é o retorno da pesquisa
		 pessoa = daoGeneric.pesquisar(pessoa);
		 
		 System.out.println(pessoa); //vai vir a os dados com o to string na model com informação do id
	}
	
	@Test
	public void testeBuscar2() {
		
		 DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa> ();
		 //método pesquisar retorna pessoa ent pode atribuir pessoa = é o retorno da pesquisa
		 UsuarioPessoa pessoa = daoGeneric.pesquisar2(2L , UsuarioPessoa.class);
		 System.out.println(pessoa); //vai vir a os dados com o to string na model com informação do id
	}
	
	@Test
	public void update() {
		
		 DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa> ();
		 UsuarioPessoa pessoa = daoGeneric.pesquisar2(3L , UsuarioPessoa.class);
		 
		 pessoa.setIdade(22);
		 pessoa.setNome("Minha Gata Preciosa");
		 pessoa.setSenha("admin");
		 pessoa.setLogin("admin");
		 pessoa.setEmail("admin@admin.com");
		 pessoa.setSobrenome("ardmir");
		 
		pessoa = daoGeneric.updateMerge(pessoa);
		 
		 System.out.println(pessoa); 
	}
}
