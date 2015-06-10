package pl.edu.agh.toik.aghbibtex.parts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexFactory;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag;
import pl.edu.agh.toik.aghbibtex.persistence.IBibtexRepository;

public class TagView {

	
	@Inject
	IBibtexRepository repository;
	
	ListViewer listViewer;
	ComboViewer comboViewer;
	
	private List<Tag> tags;
	
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
				return ((List<Tag>)inputElement).toArray();
			}
		});
		
		comboViewer.addSelectionChangedListener(new ISelectionChangedListener() {	
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection)event.getSelection();
				Tag t = (Tag)selection.getFirstElement();
				listViewer.setInput(t);
			}
		});
		refreshComboBox();
			
		listViewer = new ListViewer(parent);
		listViewer.getList().setLayoutData(new GridData(GridData.FILL_BOTH));
		parent.pack();
		listViewer.setContentProvider(new IStructuredContentProvider() {
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {	}
			@Override
			public void dispose() {	}
			@Override
			public Object[] getElements(Object inputElement) {
				return repository.getBibteEntriesWithTag(((Tag)inputElement)).toArray();			
			}
		});
		
		listViewer.addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event) {
				List<BibtexEntry> selected = new ArrayList<BibtexEntry>();
				for (Object o : ((IStructuredSelection)event.getSelection()).toArray()) {
					selected.add((BibtexEntry)o);
				}
				
				Dialog dialog = new AssignTagDialog(selected, tags, repository);
				dialog.setBlockOnOpen(true);
				dialog.open();
				refreshComboBox();
			}
		});
	}
	
	private void refreshComboBox() {
		tags = repository.getAllTags();
		Tag unassignedTag = BibtexFactory.eINSTANCE.createTag();
		unassignedTag.setName("Unassigned");
		tags.add(unassignedTag);
		comboViewer.setInput(tags);
	}
	
}
