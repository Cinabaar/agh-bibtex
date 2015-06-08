package pl.edu.agh.toik.aghbibtex.parts;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.omg.CORBA.RepositoryIdHelper;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexFactory;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag;
import pl.edu.agh.toik.aghbibtex.persistence.IBibtexRepository;
import pl.edu.agh.toik.aghbibtex.persistence.impl.BibtexRepository;

public class TagView {

	
	@Inject
	IBibtexRepository repository;
	
	ListViewer listViewer;
	ComboViewer comboViewer;
	
	@PostConstruct
	public void createContents(Composite parent)
	{	
		RowLayout layout = new RowLayout();
		layout.fill = true;
		parent.setLayout(layout);
		comboViewer = new ComboViewer(parent, SWT.BORDER);
		comboViewer.getCombo().setLayoutData(new RowData(270, 20));
		
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
		List<Tag> tags = repository.getAllTags();
		comboViewer.setInput(tags);
			
		listViewer = new ListViewer(parent);
		listViewer.getList().setLayoutData(new RowData(250, 450));
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
	}
	
}
