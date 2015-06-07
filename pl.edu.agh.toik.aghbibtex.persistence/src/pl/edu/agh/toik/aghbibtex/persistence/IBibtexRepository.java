package pl.edu.agh.toik.aghbibtex.persistence;

import java.util.List;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag;

public interface IBibtexRepository 
{
	List<BibtexEntry> getAllBibtexEntries();
	List<Tag> getAllTags();
}
