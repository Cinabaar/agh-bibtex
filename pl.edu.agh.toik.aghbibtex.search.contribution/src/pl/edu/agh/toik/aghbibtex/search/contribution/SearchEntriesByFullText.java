package pl.edu.agh.toik.aghbibtex.search.contribution;

import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.search.ISearchEntriesBy;

public class SearchEntriesByFullText implements ISearchEntriesBy {

	@Override
	public String getSearchType() {
		return "Full Text";
	}

	@Override
	public List<BibtexEntry> filterEntriesBy(List<BibtexEntry> entries,	List<String> filters) {
		if(filters.size() == 0)
			return entries;
		List<BibtexEntry> result = new ArrayList<BibtexEntry>();
		for(BibtexEntry e : entries)
		{
			for(String f : filters)
			{
				if(e.getText().toLowerCase().contains(f.toLowerCase()))
				{
					result.add(e);
					break;
				}
			}
		}
		return result;
	}
	
	@Override
	public String toString()
	{
		return getSearchType();
	}

}
