package pl.edu.agh.toik.aghbibtex.model;

import java.util.List;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;

public interface IBibtexExporter {
	void exportToFile(List<BibtexEntry> entries, String filePath);
}
