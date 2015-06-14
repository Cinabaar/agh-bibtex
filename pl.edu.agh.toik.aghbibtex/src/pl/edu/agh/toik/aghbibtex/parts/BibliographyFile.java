package pl.edu.agh.toik.aghbibtex.parts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import pl.edu.agh.toik.aghbibtex.model.IBibtexImporter;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.persistence.IBibtexRepository;

public class BibliographyFile {
	private String fileName;
	private CheckboxTableViewer viewer;
	private List<BibtexEntry> items;
	@Inject
	private IBibtexImporter converter;
	@Inject
	private ESelectionService selectionService;
	@Inject
	private IBibtexRepository repository;
	@Inject
	private MDirtyable dirtyable;

	private List<BibtexEntry> viewerInput;
	
	@PostConstruct
	public void createControls(Composite parent,
			@Named("fileName") String fileName) {
		this.fileName = fileName;
		createViewer(parent);
viewer.getTable().addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
			
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.DEL)
				{
					IStructuredSelection sel = (IStructuredSelection)viewer.getSelection();
					for(Object o : sel.toList())
					{
						int index = viewer.getTable().getSelectionIndex() - 1;
						if(index >= 0)
						{
							viewer.getTable().setSelection(index);
						}
						else if(viewer.getTable().getItemCount() > 0)
						{
							viewer.getTable().setSelection(1);
						}
						viewerInput.remove(o);
					}
					
				}
				viewer.refresh();
			}
		});
	}

	@Inject
	@Optional
	private void refreshTable(@UIEventTopic("refreshTable") String data) {
		viewer.refresh();
	}

	private void createViewer(Composite parent) {
		viewer = CheckboxTableViewer.newCheckList(parent, SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		createColumns(parent, viewer);
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		viewer.setContentProvider(new ArrayContentProvider());
		viewerInput = converter.importFromFile(fileName);
		viewer.setInput(viewerInput);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				BibtexEntry entry = (BibtexEntry) ((IStructuredSelection) event
						.getSelection()).getFirstElement();
				selectionService.setSelection(entry);
				dirtyable.setDirty(true);
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

	private void createColumns(final Composite parent,
			final CheckboxTableViewer viewer) {
		String[] titles = { "Title", "Author", "Journal", "Volume", "Pages",
				"Year" };
		int[] bounds = { 300, 100, 100, 100, 100, 100 };

		// first column is for the first name

		final TableViewerColumn maincol = createTableViewerColumn("", 30, 0);
		maincol.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return "";
			}
		});
		maincol.getColumn().setImage(
				new Image(parent.getDisplay(), getClass().getResourceAsStream(
						"/res/icons/unchecked.png")));
		maincol.getColumn().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (viewer.getCheckedElements().length == ((List) viewer
						.getInput()).size()) {
					viewer.setCheckedElements(new Object[0]);
					maincol.getColumn().setImage(
							new Image(parent.getDisplay(), getClass()
									.getResourceAsStream(
											"/res/icons/unchecked.png")));

				} else {
					viewer.setCheckedElements(((List) viewer.getInput()).toArray());
					maincol.getColumn().setImage(
							new Image(parent.getDisplay(), getClass()
									.getResourceAsStream(
											"/res/icons/checked.png")));
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		viewer.addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (viewer.getCheckedElements().length == ((List) viewer
						.getInput()).size()) {
					maincol.getColumn().setImage(
							new Image(parent.getDisplay(), getClass()
									.getResourceAsStream(
											"/res/icons/checked.png")));

				} else {
					maincol.getColumn().setImage(
							new Image(parent.getDisplay(), getClass()
									.getResourceAsStream(
											"/res/icons/unchecked.png")));
				}
			}
		});

		TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
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

	private TableViewerColumn createTableViewerColumn(String title, int bound,
			final int colNumber) {
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
		List<BibtexEntry> bs = new ArrayList<BibtexEntry>();

		for(Object o : viewer.getCheckedElements())
		{
			bs.add((BibtexEntry)o);
			viewer.remove(o);
		}
		repository.saveBibtexEntries(bs);
		dirtyable.setDirty(false);
		viewer.setCheckedElements(new Object[0]);
	}

}
