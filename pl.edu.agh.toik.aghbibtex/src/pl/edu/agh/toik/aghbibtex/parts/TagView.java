package pl.edu.agh.toik.aghbibtex.parts;

import java.util.List;

import javax.annotation.PostConstruct;

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

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexFactory;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag;

public class TagView {

	/*ListViewer listViewer;
	ComboViewer comboViewer;
	
	@PostConstruct
	public void createContents(Composite parent)
	{	
		RowLayout layout = new RowLayout();
		layout.fill = true;
		parent.setLayout(layout);
		comboViewer = new ComboViewer(parent, SWT.BORDER);
		comboViewer.getCombo().setLayoutData(new RowData(270, 20));

		Tag t = BibtexFactory.eINSTANCE.createTag();
		t.setName("t1");
		List<BibtexEntry> bibtexEntries = t.getBibtexEntries();
		BibtexEntry entry1 = BibtexFactory.eINSTANCE.createBibtexEntry();
		entry1.setName("e1");
		entry1.setValue("e1");
		BibtexEntry entry2 =  BibtexFactory.eINSTANCE.createBibtexEntry();
		entry2.setName("e2");
		entry2.setValue("e2");
		bibtexEntries.add(entry1);
		bibtexEntries.add(entry2);
		Tag t2 = BibtexFactory.eINSTANCE.createTag();
		t2.setName("t2");
		List<BibtexEntry> bibtexEntries2 = t2.getBibtexEntries();
		BibtexEntry entry3 = BibtexFactory.eINSTANCE.createBibtexEntry();
		entry3.setName("e3");
		entry3.setValue("e3");
		BibtexEntry entry4 =  BibtexFactory.eINSTANCE.createBibtexEntry();
		entry4.setName("e4");
		entry4.setValue("e4");
		bibtexEntries2.add(entry3);
		bibtexEntries2.add(entry4);
		bibtexEntries2.add(entry1);
		bibtexEntries2.add(entry2);
		Tag[] tags = new Tag[2];
		tags[0] = t;
		tags[1] = t2;
		
		comboViewer.setContentProvider(new IStructuredContentProvider() {		
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }
			@Override
			public void dispose() { }
			@Override
			public Object[] getElements(Object inputElement) {
				return (Tag[])inputElement;
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
				return ((Tag)inputElement).getBibtexEntries().toArray();			
			}
		});
	}*/
	
}
