package pl.edu.agh.toik.aghbibtex.persistence.contribution;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.Hibernate;
import org.hibernate.Query;
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
		final Properties props = new Properties();
		props.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
		props.setProperty(Environment.USER, "sa");
		props.setProperty(Environment.URL, "jdbc:hsqldb:file:library2");
		props.setProperty(Environment.PASS, "");
		props.setProperty(Environment.DIALECT, MyHSQLDialect.class.getName());
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

	private Session beginTransaction()
	{
		Session session = _sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}
	
	private void endTransaction(Session s)
	{
		Transaction t = s.getTransaction();
		t.commit();
		s.close();
	}
	
	@Override
	public List<BibtexEntry> getAllBibtexEntries() {

		Session session = beginTransaction();
		
		Query query = session.createQuery("FROM BibtexEntry");
		List<BibtexEntry> books = query.list();
		
		
		endTransaction(session);		
		return books;
	}

	@Override
	public List<Tag> getAllTags() {
		Session session = beginTransaction();
		
		Query query = session.createQuery("FROM Tag");
		List<Tag> tags = query.list();
		
		endTransaction(session);		
		return tags;
	}
	
	public void saveBibtexEntry(BibtexEntry entry)
	{
		saveBibtexEntries(new ArrayList<BibtexEntry>() {{add(entry);}});
	}
	
	public void saveBibtexEntries(List<BibtexEntry> entries)
	{
		Session session = beginTransaction();
		
		for(BibtexEntry entry : entries)
		{
			session.saveOrUpdate(entry);
		}
		
		endTransaction(session);
	}
	
	public void assignTagToEntries(List<BibtexEntry> entries, String tagName) {
		
		Tag tag = getOrCreateTag(tagName);
		
		
		Session session = beginTransaction();
		for (BibtexEntry entry : entries) {
			entry.getTags().add(tag);
			session.saveOrUpdate(entry);
		}
		
		endTransaction(session);
	}
	
	public BibtexEntry createBibtexEntry() {
		return BibtexFactory.eINSTANCE.createBibtexEntry();
	}
	
	public Tag getOrCreateTag(String name)
	{
		Tag tag;
		Session session = beginTransaction();
		Query query = session.createQuery("FROM Tag tag WHERE tag.Name = :name");
		query.setParameter("name", name);
		
		List<Tag> tags = query.list();
		if(tags.size() == 0)
		{
			tag = BibtexFactory.eINSTANCE.createTag();
			tag.setName(name);
			session.save(tag);
		} 
		else
		{
			tag = tags.get(0);
		}
		endTransaction(session);
		return tag;
	}

	@Override
	public List<BibtexEntry> getBibteEntriesWithTag(Tag tag) {
		Session session = beginTransaction();
		//tag.get
		Query query = null;
		if ("Unassigned".equals(tag.getName())) {
			query = session.createQuery("select entry from BibtexEntry as entry left outer join entry.Tags as tag where tag is null");	
		} else {
			query = session.createQuery("select entry from BibtexEntry as entry left outer join entry.Tags as tag where tag.Name = '" + tag.getName()+"'");
		}
		List<BibtexEntry> entries = query.list();
		if (entries != null) {
			for (BibtexEntry entry : entries) {
				Hibernate.initialize(entry.getTags());
			}
		}
		endTransaction(session);
		return entries;
	}
	
	
}
