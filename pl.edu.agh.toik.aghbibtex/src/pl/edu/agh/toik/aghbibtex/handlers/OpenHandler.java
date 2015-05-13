 
package pl.edu.agh.toik.aghbibtex.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class OpenHandler {
	
	@Inject
	private IEventBroker eventBroker; 
	
	@Execute
	public void execute(Shell shell) {
		FileDialog fileDialog = new FileDialog(shell);
		fileDialog.setFilterExtensions(new String[] {"*.bibtex;*.bib"});
		String fileName = fileDialog.open();
		eventBroker.send("OpenFile", fileName);
	}
		
}