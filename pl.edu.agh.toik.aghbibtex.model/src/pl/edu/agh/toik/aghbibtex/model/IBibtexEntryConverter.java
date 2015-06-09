package pl.edu.agh.toik.aghbibtex.model;

import java.util.List;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;

public interface IBibtexEntryConverter {

	List<BibtexEntry> convertFile(String fileName);

}
