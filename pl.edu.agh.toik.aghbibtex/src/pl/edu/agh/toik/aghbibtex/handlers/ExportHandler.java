package pl.edu.agh.toik.aghbibtex.handlers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import pl.edu.agh.toik.aghbibtex.model.IBibtexExporter;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;

public class ExportHandler {

	@Inject
	IBibtexExporter exporter;

	Set<BibtexEntry> currentBibliography;
	
	@Execute
	public void execute(Shell shell) {
		System.out.println("asdf");
		FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		dialog.setFileName("bibliography.bib");
		String filePath = dialog.open();
		exporter.exportToFile(new ArrayList<BibtexEntry>(currentBibliography), filePath);
	}

	@CanExecute
	public boolean canExecute()
	{
		System.out.println("fsad" + currentBibliography + currentBibliography.size());
		if(currentBibliography == null || currentBibliography.size() == 0)
			return false;
		return true;
	}
	
	@Inject
	@Optional
	private void refreshTable(@UIEventTopic("currentBibliography") Set<BibtexEntry> currentBibliography) {
		this.currentBibliography = currentBibliography;
	} 
	
}
