import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa (null, "Lucas", "lucas@gmail.com", "Professor");
		Pessoa p2 = new Pessoa (null, "Fernanda", "fernanda@gmail.com", "Aluna");
		Pessoa p3 = new Pessoa (null, "Zeca", "zeca@gmail.com", "Aluno");
		Pessoa p4 = new Pessoa (null, "Luana", "luana@gmail.com", "Aluna");
		Pessoa p;
		
		//System.out.println(p1);
		//System.out.println(p2);
		//System.out.println(p3);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaHibernate");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		
		p = em.find(Pessoa.class, 4);
		System.out.println(p);
	}
}
