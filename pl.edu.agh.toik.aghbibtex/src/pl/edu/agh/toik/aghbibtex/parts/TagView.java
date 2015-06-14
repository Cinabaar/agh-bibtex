package pl.edu.agh.toik.aghbibtex.parts;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexFactory;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag;
import pl.edu.agh.toik.aghbibtex.persistence.IBibtexRepository;
import pl.edu.agh.toik.aghbibtex.search.ISearchEntriesBy;

public class TagView {

	
	@Inject
	IBibtexRepository repository;
	
	@Inject
	IEventBroker eventBroker;
	
	@Inject
	@Named("searchEntriesBy")
	List<ISearchEntriesBy> searchEntriesBy;
	
	ListViewer listViewer;
	ComboViewer comboViewer;
	Text filterText;
	Button assignButton;
		
	@PostConstruct
	public void createContents(Composite parent)
	{	
		GridLayout gridLayout = new GridLayout();
		parent.setLayout(gridLayout);
		comboViewer = new ComboViewer(parent, SWT.BORDER);
		comboViewer.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		comboViewer.setContentProvider(new IStructuredContentProvider() {		
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }
			@Override
			public void dispose() { }
			@Override
			public Object[] getElements(Object inputElement) {
				return ((List<ISearchEntriesBy>)inputElement).toArray();
			}
		});
		
		comboViewer.addSelectionChangedListener(new ISelectionChangedListener() {	
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				filterText.setText("");
			}
		});
		comboViewer.setInput(searchEntriesBy);
		comboViewer.getCombo().select(0);
		
		filterText = new Text(parent, SWT.BORDER);
		filterText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		filterText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				StructuredSelection sel = (StructuredSelection) comboViewer.getSelection();
				ISearchEntriesBy element = (ISearchEntriesBy) sel.getFirstElement();
				String[] q  = filterText.getText().split(",");
				List<String> f = new ArrayList<String>();
				for(String s : q)
				{
					if(s.length()>0)
						f.add(s.trim());
				}
				listViewer.setInput(element.filterEntriesBy(repository.getAllBibtexEntries(), f));
			}
		});
		
		
		listViewer = new ListViewer(parent);
		listViewer.getList().setLayoutData(new GridData(GridData.FILL_BOTH));
		listViewer.setContentProvider(new IStructuredContentProvider() {
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {	}
			@Override
			public void dispose() {	}
			@Override
			public Object[] getElements(Object inputElement) {
				return ((List<BibtexEntry>)inputElement).toArray();			
			}
		});
		
		listViewer.addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event) {	
				eventBroker.send("bibliographySelected", (BibtexEntry) ((IStructuredSelection)event.getSelection()).getFirstElement());
			}
		});
		listViewer.setInput(repository.getAllBibtexEntries());
		
		assignButton = new Button(parent, SWT.NONE);
		assignButton.setText("Assign bibliographies to tag");
		assignButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		assignButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<BibtexEntry> selected = new ArrayList<BibtexEntry>();
				for (Object o : ((IStructuredSelection)listViewer.getSelection()).toArray()) {
					selected.add((BibtexEntry)o);
				}
				
				if (selected.size() > 0) {
					Dialog dialog = new AssignTagDialog(selected, repository.getAllTags(), repository);
					dialog.setBlockOnOpen(true);
					dialog.open();
					refreshComboBox(); 
				} else {
					MessageDialog.openWarning(null, "Empty selection", "Choose some bibliographies from the list.");
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		parent.pack();
		
	}
	
	private void refreshComboBox()
	{
		comboViewer.refresh();
		filterText.setText(filterText.getText() + " ");
		filterText.setText(filterText.getText().substring(0, filterText.getText().length()-1));

	}
	
}
