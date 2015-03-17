import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jpa.test.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vap
 * Date: 5.2.2015
 * Time: 11:03
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class JPATestIT {
//	@PersistenceContext(synchronization = SynchronizationType.UNSYNCHRONIZED, type = PersistenceContextType.TRANSACTION)
	@PersistenceContext
	EntityManager em;

	@Deployment
	public static JavaArchive setup() {
		JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addClass(Address.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		System.out.println(archive.toString(true));
		return archive;
	}

	@Test
	public void testAddress() {
		List list = em.createQuery("Select a from Address a").getResultList();
//		Address address = new Address();
	}
}
