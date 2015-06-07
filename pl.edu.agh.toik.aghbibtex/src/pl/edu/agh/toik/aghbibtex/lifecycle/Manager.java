package pl.edu.agh.toik.aghbibtex.lifecycle;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.equinox.app.IApplicationContext;

import pl.edu.agh.toik.aghbibtex.persistence.IBibtexRepository;

public class Manager {
	
	@PostContextCreate
	public void postContextCreate(IEclipseContext context) {
		System.out.println("DUUUPPPAAAA");
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("pl.edu.agh.toik.aghbibtex.persistence");

		try {
			IBibtexRepository bib = (IBibtexRepository)config[0].createExecutableExtension("class");
			context.set(IBibtexRepository.class, bib);
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}
}
