package pl.edu.agh.toik.aghbibtex.parts;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.services.EContextService;
import org.eclipse.e4.ui.workbench.UIEvents.Dirtyable;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

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
	@Inject
	IEventBroker eventBroker;
	@Inject
	MDirtyable dirtyable;

	private Set<BibtexEntry> viewerInput;

	@PostConstruct
	public void createControls(Composite parent) {

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
				refreshTable();
			}
		});
	}

	private void refreshTable() {
		eventBroker.send("currentBibliography", viewerInput);
		viewer.refresh();
	}

	@Inject
	@Optional
	private void refreshTable(@UIEventTopic("tableDataChanged") String data) {
		dirtyable.setDirty(true);
		refreshTable();
	}

	@Inject
	@Optional
	private void refreshTable(
			@UIEventTopic("bibliographySelected") BibtexEntry entry) {
		viewerInput.add(entry);
		viewer.setInput(viewerInput);
		refreshTable();
	}

	private void createViewer(Composite parent) {
		viewerInput = new HashSet<BibtexEntry>();
		viewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER | SWT.FULL_SELECTION);
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
				BibtexEntry entry = (BibtexEntry) ((IStructuredSelection) event
						.getSelection()).getFirstElement();
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
		String[] titles = { "Title", "Author", "Journal", "Volume", "Pages",
				"Year", "Publication path", "Select file", "Show file" };
		int[] bounds = { 300, 100, 100, 100, 100, 100, 100, 100, 100 };

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
		col = createTableViewerColumn(titles[6], bounds[6], 6);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				BibtexEntry p = (BibtexEntry) element;
				return p.getPublicationFilePath();
			}
		});
		TableColumn column = new TableColumn(viewer.getTable(), SWT.NONE);
		column.setText("Publication file path");
		column.setWidth(100);
		TableViewerColumn actionsNameCol = new TableViewerColumn(viewer, column);
		actionsNameCol.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public void update(final ViewerCell cell) {

				TableItem item = (TableItem) cell.getItem();
				final BibtexEntry entry = (BibtexEntry) cell.getElement();
				Button button;
				button = new Button((Composite) cell.getViewerRow()
						.getControl(), SWT.NONE);
				button.setText("Select file");
				TableEditor editor = new TableEditor(item.getParent());
				editor.grabHorizontal = true;
				editor.grabVertical = true;
				editor.setEditor(button, item, cell.getColumnIndex());
				editor.layout();

				button.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						FileDialog dialog = new FileDialog(parent.getShell(),
								SWT.MULTI);
						dialog.setFilterExtensions(new String[] { "*.pdf", "*.doc" });
						String filePath = dialog.open();
						entry.setPublicationFilePath(filePath);
						viewer.refresh();

						repository.saveBibtexEntry(entry);

					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
					}
				});
			}

		});

		column = new TableColumn(viewer.getTable(), SWT.NONE);
		column.setText("Publication");
		column.setWidth(100);
		actionsNameCol = new TableViewerColumn(viewer, column);
		actionsNameCol.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public void update(final ViewerCell cell) {

				TableItem item = (TableItem) cell.getItem();
				final BibtexEntry entry = (BibtexEntry) cell.getElement();
				Button button;
				button = new Button((Composite) cell.getViewerRow()
						.getControl(), SWT.NONE);
				button.setText("Open file");
				TableEditor editor = new TableEditor(item.getParent());
				editor.grabHorizontal = true;
				editor.grabVertical = true;
				editor.setEditor(button, item, cell.getColumnIndex());
				editor.layout();

				button.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						if (entry.getPublicationFilePath() != null) {
							try {
								File file = new File(entry
										.getPublicationFilePath());
								Desktop.getDesktop().open(file);
							} catch (IOException ex) {
								MessageDialog.openError(null, "Error",
										"Something went wrong...");
							}

						} else {
							MessageDialog
									.openInformation(null,
											"No associated file",
											"This bibliography has not associated publication file.");
						}
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
					}
				});
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
		for(BibtexEntry b : (Set<BibtexEntry>)viewer.getInput())
		{
			bs.add((BibtexEntry)b);
		}
		repository.saveBibtexEntries(bs);
		dirtyable.setDirty(false);
	}

}