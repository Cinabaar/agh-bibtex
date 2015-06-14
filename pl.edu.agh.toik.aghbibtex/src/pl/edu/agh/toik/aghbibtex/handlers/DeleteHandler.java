package pl.edu.agh.toik.aghbibtex.handlers;

import java.util.ArrayList;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;

public class DeleteHandler {
	@Execute
	public void execute() {
		System.out.println("deletehandler");
	}
}
