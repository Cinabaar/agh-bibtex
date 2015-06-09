package pl.edu.agh.toik.aghbibtex.lifecycle;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.equinox.app.IApplicationContext;

import pl.edu.agh.toik.aghbibtex.model.IBibtexEntryConverter;
import pl.edu.agh.toik.aghbibtex.persistence.IBibtexRepository;

public class Manager {
	
	@PostContextCreate
	public void postContextCreate(IEclipseContext context) {
		IConfigurationElement[] persist = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("pl.edu.agh.toik.aghbibtex.persistence");
		IConfigurationElement[] model = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("pl.edu.agh.toik.aghbibtex.model.BibtexEntryConverter");

		try {
			IBibtexRepository bib = (IBibtexRepository)persist[0].createExecutableExtension("class");
			context.set(IBibtexRepository.class, bib);
			IBibtexEntryConverter entryConverter = (IBibtexEntryConverter)model[0].createExecutableExtension("class");
			context.set(IBibtexEntryConverter.class, entryConverter);
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}
}
