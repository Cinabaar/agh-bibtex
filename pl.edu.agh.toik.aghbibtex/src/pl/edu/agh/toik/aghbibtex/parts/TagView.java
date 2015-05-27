package pl.edu.agh.toik.aghbibtex.parts;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class TagView {

	TreeViewer treeViewer;
	Text filter;
	@PostConstruct
	public void createContents(Composite parent)
	{
		parent.setLayout(new GridLayout());
		filter = new Text(parent, SWT.BORDER);
		filter.setLayoutData(new GridData(parent.getSize().x, 20));
		treeViewer = new TreeViewer(parent);
		treeViewer.setContentProvider(new ITreeContentProvider() {
		
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Object[] getElements(Object inputElement) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object getParent(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean hasChildren(Object element) {
				// TODO Auto-generated method stub
				return false;
			}
		});
	}
	
}
