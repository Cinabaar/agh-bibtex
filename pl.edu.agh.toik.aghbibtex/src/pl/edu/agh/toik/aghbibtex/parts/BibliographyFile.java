package pl.edu.agh.toik.aghbibtex.parts;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import pl.edu.agh.toik.aghbibtex.model.IBibtexEntryConverter;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl;
import pl.edu.agh.toik.aghbibtex.util.StringUtil;

public class BibliographyFile {
	private String fileName;
	private Table table;
	private CheckboxTableViewer viewer;
	private List<BibtexEntry> items;
	@Inject
	IBibtexEntryConverter converter;
	@Inject
	private ESelectionService selectionService;
	
	@PostConstruct
	public void createControls(Composite parent, @Named("fileName") String fileName) 
	{
		
		this.fileName = fileName;
		createViewer(parent);

	}
	private void createViewer(Composite parent) {
	    viewer = CheckboxTableViewer.newCheckList(parent, SWT.H_SCROLL
	        | SWT.V_SCROLL | SWT.BORDER);
	    createColumns(parent, viewer);
	    final Table table = viewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    viewer.setContentProvider(new ArrayContentProvider());
	    viewer.setInput(converter.convertFile(fileName).toArray());
	    
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

	    // first column is for the first name
	    TableViewerColumn col = createTableViewerColumn("", 20, 0);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	        return "";
	      }
	    });
	    
	    col = createTableViewerColumn(titles[0], bounds[0], 1);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	        BibtexEntry p = (BibtexEntry) element;
	        return p.getTitle();
	      }
	    });

	    // second column is for the last name
	    col = createTableViewerColumn(titles[1], bounds[1], 2);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	    	  BibtexEntry p = (BibtexEntry) element;
	        return p.getAuthor();
	      }
	    });

	    // now the gender
	    col = createTableViewerColumn(titles[2], bounds[2], 3);
	    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		    	  BibtexEntry p = (BibtexEntry) element;
		        return p.getJournal();
		      }
		    });

	    // now the status married
	    col = createTableViewerColumn(titles[3], bounds[3], 4);
	    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		    	  BibtexEntry p = (BibtexEntry) element;
		        return p.getVolume();
		      }
		    });
	    col = createTableViewerColumn(titles[4], bounds[4], 5);
	    col.setLabelProvider(new ColumnLabelProvider() {
		      @Override
		      public String getText(Object element) {
		    	  BibtexEntry p = (BibtexEntry) element;
		        return p.getPages();
		      }
		    });
	    col = createTableViewerColumn(titles[5], bounds[5], 6);
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
	  
	  @Persist
	  public void save() {
		
	  }

}
