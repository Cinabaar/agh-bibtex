package pl.edu.agh.toik.aghbibtex.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag;
import pl.edu.agh.toik.aghbibtex.persistence.IBibtexRepository;

public class AssignTagDialog extends TitleAreaDialog {

	private List<BibtexEntry> entries;
	private List<Tag> tags;
	private ComboViewer comboViewer;
	private Text tagName;
	private IBibtexRepository repository;

	public AssignTagDialog(List<BibtexEntry> entries, List<Tag> tags,
			IBibtexRepository repository) {
		super((Shell) null);
		this.repository = repository;
		this.entries = entries;
		this.tags = new ArrayList<Tag>(tags);
		for (Tag t : tags) {
			if ("Unassigned".equals(t.getName())) {
				this.tags.remove(t);
			}
		}
	}

	@Override
	public void create() {
		super.create();
		setTitle("Tag assignment");
		setMessage("Assign bibliography to existing or new tag",
				IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		createTagName(container);
		createTagCombobox(container);

		return area;
	}

	protected void createTagName(Composite parent) {
		Label tagLabel = new Label(parent, SWT.NONE);
		tagLabel.setText("New tag name: ");
		tagName = new Text(parent, SWT.BORDER);
		tagName.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				try {
					comboViewer.setSelection(null);
				} catch (Throwable t) {

				}
			}
		});
	}

	protected void createTagCombobox(Composite parent) {
		Label tagLabel = new Label(parent, SWT.NONE);
		tagLabel.setText("Choose existing tag: ");
		comboViewer = new ComboViewer(parent, SWT.BORDER);
		comboViewer.getCombo().setLayoutData(
				new GridData(GridData.FILL_HORIZONTAL));

		comboViewer.setContentProvider(new IStructuredContentProvider() {
			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}

			@Override
			public void dispose() {
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return ((List<Tag>) inputElement).toArray();
			}
		});

		comboViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						IStructuredSelection selection = (IStructuredSelection) event
								.getSelection();
						Tag t = (Tag) selection.getFirstElement();
						if (t != null) {
							tagName.setText(t.getName());
						}
					}
				});

		comboViewer.setInput(tags);

	}

	@Override
	protected void okPressed() {
		repository.assignTagToEntries(entries, tagName.getText());
		super.okPressed();
	}

}
