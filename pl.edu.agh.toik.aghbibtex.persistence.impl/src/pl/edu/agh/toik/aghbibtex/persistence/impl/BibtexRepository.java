package pl.edu.agh.toik.aghbibtex.persistence.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Environment;
import org.osgi.framework.BundleContext;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexFactory;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag;
import pl.edu.agh.toik.aghbibtex.persistence.IBibtexRepository;

public class BibtexRepository implements IBibtexRepository
{	
	private SessionFactory _sessionFactory;
	
	public BibtexRepository() 
	{
		System.out.println("1111111111111111111111");
		final Properties props = new Properties();
		props.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
		props.setProperty(Environment.USER, "sa");
		props.setProperty(Environment.URL, "jdbc:hsqldb:file:library");
		props.setProperty(Environment.PASS, "");
		props.setProperty(Environment.DIALECT, org.hibernate.dialect.HSQLDialect.class.getName());
		props.setProperty(PersistenceOptions.CASCADE_POLICY_ON_NON_CONTAINMENT, "REFRESH,PERSIST,MERGE");
		String hbName = "Library";
		final HbDataStore hbds = HbHelper.INSTANCE.createRegisterDataStore(hbName);
		hbds.setDataStoreProperties(props);
		EPackage pack = BibtexPackage.eINSTANCE;
		hbds.setEPackages(new EPackage[] { pack });
		
		try {
			hbds.initialize();
		} finally {
			// print the generated mapping
			System.err.println(hbds.getMappingXML());			
		}
		_sessionFactory = hbds.getSessionFactory();
	}

	@Override
	public List<BibtexEntry> getAllBibtexEntries() {
		List<BibtexEntry> entries = new ArrayList<BibtexEntry>();
		BibtexEntry entry = BibtexFactory.eINSTANCE.createBibtexEntry();
		entry.setName("ala");
		entry.setValue("bala");
		entries.add(entry);
		return entries;
	}

	@Override
	public List<Tag> getAllTags() {
		return new ArrayList<Tag>() {{add(BibtexFactory.eINSTANCE.createTag());}};
	}
}
