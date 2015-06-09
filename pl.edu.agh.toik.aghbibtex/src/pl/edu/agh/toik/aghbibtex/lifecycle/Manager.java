package pl.edu.agh.toik.aghbibtex.lifecycle;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.internal.workbench.ExtensionPointProxy;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.emf.ecore.plugin.EcorePlugin.ExtensionProcessor;
import org.eclipse.equinox.app.IApplicationContext;

import pl.edu.agh.toik.aghbibtex.model.IBibtexExporter;
import pl.edu.agh.toik.aghbibtex.model.IBibtexImporter;
import pl.edu.agh.toik.aghbibtex.persistence.IBibtexRepository;

public class Manager {
	
	@PostContextCreate
	public void postContextCreate(IEclipseContext context) {
		IConfigurationElement[] persist = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("pl.edu.agh.toik.aghbibtex.persistence");
		IConfigurationElement[] model = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("pl.edu.agh.toik.aghbibtex.model.pl.edu.agh.toik.aghbibtex.model");
		
		try {
			IBibtexRepository bib = (IBibtexRepository)persist[0].createExecutableExtension("class");
			context.set(IBibtexRepository.class, bib);
			IBibtexImporter importer = (IBibtexImporter)model[1].createExecutableExtension("class");
			context.set(IBibtexImporter.class, importer);
			IBibtexExporter exporter = (IBibtexExporter)model[0].createExecutableExtension("class");
			context.set(IBibtexExporter.class, exporter);
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}
}
