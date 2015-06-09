 
package pl.edu.agh.toik.aghbibtex.parts;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.services.IServiceConstants;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;

public class BibliographyEdit {
	
	private Text textBox;
	private BibtexEntry currentSelection;
	
	@Inject
	void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) BibtexEntry entry) {
	  if(entry==null) return;
	  currentSelection = entry;
	  textBox.setText(currentSelection.getText());
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		textBox = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		textBox.setLayoutData(new GridData(GridData.FILL_BOTH));
	}
	
	@Persist
	public void save() {
		
	}
	
}