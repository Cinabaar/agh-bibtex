 
package pl.edu.agh.toik.aghbibtex.parts;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.services.IServiceConstants;

import pl.edu.agh.toik.aghbibtex.model.IBibtexImporter;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;

public class BibliographyEdit {
	
	private Text textBox;
	private BibtexEntry currentSelection;
	
	@Inject
	IBibtexImporter importer;
	@Inject
	MDirtyable dirtyable;
	@Inject
	IEventBroker eventBroker;

	
	@Inject
	void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) BibtexEntry entry,
			MDirtyable dirtyable) {
	  if(entry==null) return;
	  currentSelection = entry;
	  textBox.setText(currentSelection.getText());
	  dirtyable.setDirty(false);
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		textBox = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		textBox.setLayoutData(new GridData(GridData.FILL_BOTH));
		textBox.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				dirtyable.setDirty(true);			
			}
		});
	}
	
	@Persist
	public void doSave(Composite parent) {
		BibtexEntry e = importer.readEntry(textBox.getText());
		if(e!= null)
		{
			currentSelection.setAuthor(e.getAuthor());
			currentSelection.setJournal(e.getJournal());
			currentSelection.setText(e.getText());
			currentSelection.setVolume(e.getVolume());
			currentSelection.setYear(e.getYear());
			currentSelection.setTitle(e.getTitle());
			currentSelection.setPages(e.getPages());
			dirtyable.setDirty(false);
			eventBroker.send("refreshTable", "");
		}
		else
		{
			MessageBox box = new MessageBox(parent.getShell(), SWT.ICON_ERROR);
			box.setText("Error");
			box.setMessage("Unable to save changes");
			box.open();
		}
	}
}