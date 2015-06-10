 
package pl.edu.agh.toik.aghbibtex.handlers;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class ImportHandler {
		
	
	@Execute
	public void execute(Shell shell, MApplication app, EModelService modelService, EPartService partService) {
		FileDialog fileDialog = new FileDialog(shell);
		fileDialog.setFilterExtensions(new String[] {"*.bibtex;*.bib"});
		String fileName = fileDialog.open();
		
		if(fileName == null || fileName.length() == 0)
			return;
		
		MPartStack stack = (MPartStack) modelService.find("pl.edu.agh.toik.aghbibtex.partstack.BibliographyPS", app);
		MPart part = modelService.createModelElement(MPart.class);
		IEclipseContext context = app.getContext();
		context.set("fileName", fileName);
		part.setElementId("pl.edu.agh.toik.aghbibtex.part.file");
		part.setContributionURI("bundleclass://pl.edu.agh.toik.aghbibtex/pl.edu.agh.toik.aghbibtex.parts.BibliographyFile");
		part.setCloseable(true);
		Path p = Paths.get(fileName);
		part.setLabel(p.getFileName().toString());
		stack.getChildren().add(part);
		partService.showPart(part, PartState.ACTIVATE);
		part.setDirty(true);
		
	}
		
}