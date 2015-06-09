 
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
	
	private Text t;
	
	@Inject
	public BibliographyEdit(Composite parent) {
		t = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
	    t.setLayoutData(new GridData(GridData.FILL_BOTH));
	}
	
	@Inject
	void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) BibtexEntry entry) {
	  if(entry==null) return;
	  t.setText(entry.getText());
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		
	}
	
	
	@Persist
	public void save() {
		
	}
	
}