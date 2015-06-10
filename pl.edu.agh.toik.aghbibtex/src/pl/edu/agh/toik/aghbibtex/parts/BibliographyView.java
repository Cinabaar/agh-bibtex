package pl.edu.agh.toik.aghbibtex.parts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import pl.edu.agh.toik.aghbibtex.model.IBibtexImporter;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.persistence.IBibtexRepository;

public class BibliographyView {
	
	private TableViewer viewer;
	private List<BibtexEntry> items;
	@Inject
	private IBibtexImporter converter;
	@Inject
	private ESelectionService selectionService;
	@Inject
	private IBibtexRepository repository;
	
	private Set<BibtexEntry> viewerInput;
	
	@PostConstruct
	public void createControls(Composite parent) 
	{
		createViewer(parent);
	}
	
	@Inject
	@Optional
	private void refreshTable(@UIEventTopic("refreshTable") String data) {
	  viewer.refresh();
	} 
	
	
	@Inject
	@Optional
	private void refreshTable(@UIEventTopic("bibliographySelected") BibtexEntry entry) {
		viewerInput.add(entry);
		viewer.setInput(viewerInput);
		viewer.refresh();
	} 
	
	private void createViewer(Composite parent) {
		viewerInput = new HashSet<BibtexEntry>();
	    viewer = new TableViewer(parent, SWT.H_SCROLL
	        | SWT.V_SCROLL | SWT.BORDER);
	    createColumns(parent, viewer);
	    final Table table = viewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    viewer.setContentProvider(new ArrayContentProvider());
	    viewer.setInput(viewerInput);
	    viewer.setInput(new ArrayList<BibtexEntry>());
	    
	    viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				BibtexEntry entry = (BibtexEntry)((IStructuredSelection)event.getSelection()).getFirstElement();
				selectionService.setSelection(entry);
			}
		});
	    
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    viewer.getControl().setLayoutData(gridData);
	  }
	private void createColumns(final Composite parent, final TableViewer viewer) {
	    String[] titles = { "Title", "Author", "Journal", "Volume", "Pages", "Year"};
	    int[] bounds = { 300, 100, 100, 100, 100, 100};

	    TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	        BibtexEntry p = (BibtexEntry) element;
	        return p.getTitle();
	      }
	    });

	    // second column is for the last name
	    col = createTableViewerColumn(titles[1], bounds[1], 1);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	    	  BibtexEntry p = (BibtexEntry) element;
	        return p.getAuthor();
	      }
	    });

	    // now the gender
	    col = createTableViewerColumn(titles[2], bounds[2], 2);
	    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		    	  BibtexEntry p = (BibtexEntry) element;
		        return p.getJournal();
		      }
		    });

	    // now the status married
	    col = createTableViewerColumn(titles[3], bounds[3], 3);
	    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		    	  BibtexEntry p = (BibtexEntry) element;
		        return p.getVolume();
		      }
		    });
	    col = createTableViewerColumn(titles[4], bounds[4], 4);
	    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		    	  BibtexEntry p = (BibtexEntry) element;
		        return p.getPages();
		      }
		    });
	    col = createTableViewerColumn(titles[5], bounds[5], 5);
	    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		    	  BibtexEntry p = (BibtexEntry) element;
		        return p.getYear();
		      }
		    });
	    

	  }

	  private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
	    final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
	        SWT.NONE);
	    final TableColumn column = viewerColumn.getColumn();
	    column.setText(title);
	    column.setWidth(bound);
	    column.setResizable(true);
	    column.setMoveable(true);
	    return viewerColumn;
	  }

	  public void setFocus() {
	    viewer.getControl().setFocus();
	  }
	  

}