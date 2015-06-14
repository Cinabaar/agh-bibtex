package pl.edu.agh.toik.aghbibtex.handlers;

import java.util.ArrayList;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
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
		FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		dialog.setFileName("bibliography.bib");
		String filePath = dialog.open();
		exporter.exportToFile(new ArrayList<BibtexEntry>(currentBibliography), filePath);
	}

	@CanExecute
	public boolean canExecute()
	{
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
