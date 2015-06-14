package pl.edu.agh.toik.aghbibtex.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.widgets.Shell;

public class SaveHandler {
	@Execute
	public void execute(Shell shell, MApplication app, EModelService modelService, EPartService partService) {
		MPart activePart = partService.getActivePart();
		partService.savePart(activePart, false);
	}
}
