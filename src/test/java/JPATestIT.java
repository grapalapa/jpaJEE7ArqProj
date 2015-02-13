import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jpa.test.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * User: vap
 * Date: 5.2.2015
 * Time: 11:03
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class JPATestIT {

	@Deployment
	public static JavaArchive setup() {
		JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addClass(Address.class);
		System.out.println(archive.toString(true));
		return archive;
	}

	@Test
	public void testAddress() {
		Persistence.createEntityManagerFactory("jpa_test").createEntityManager();
		Address address = new Address();
	}
}
