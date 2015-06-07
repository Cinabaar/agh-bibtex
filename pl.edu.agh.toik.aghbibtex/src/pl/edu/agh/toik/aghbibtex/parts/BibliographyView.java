package pl.edu.agh.toik.aghbibtex.parts;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.management.InvalidApplicationException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Composite;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.persistence.IBibtexRepository;

public class BibliographyView {
	
	
	@Inject
	IBibtexRepository repository;
	
	@PostConstruct
	public void createControls(Composite parent) 
	{
		
	}
}