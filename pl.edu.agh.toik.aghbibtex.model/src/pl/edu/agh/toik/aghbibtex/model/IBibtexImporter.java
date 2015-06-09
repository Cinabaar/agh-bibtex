package pl.edu.agh.toik.aghbibtex.model;

import java.util.List;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;

public interface IBibtexImporter {

	List<BibtexEntry> importFromFile(String fileName);
	BibtexEntry readEntry(String entry);

}
