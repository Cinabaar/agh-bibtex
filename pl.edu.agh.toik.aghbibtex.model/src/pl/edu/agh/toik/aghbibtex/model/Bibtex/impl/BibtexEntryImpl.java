/**
 */
package pl.edu.agh.toik.aghbibtex.model.Bibtex.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl#getText <em>Text</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl#getJournal <em>Journal</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl#getVolume <em>Volume</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl#getPages <em>Pages</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl#getYear <em>Year</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl#getPublicationFilePath <em>Publication File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BibtexEntryImpl extends MinimalEObjectImpl.Container implements BibtexEntry {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getJournal() <em>Journal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJournal()
	 * @generated
	 * @ordered
	 */
	protected static final String JOURNAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJournal() <em>Journal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJournal()
	 * @generated
	 * @ordered
	 */
	protected String journal = JOURNAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getVolume() <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVolume()
	 * @generated
	 * @ordered
	 */
	protected static final String VOLUME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVolume() <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVolume()
	 * @generated
	 * @ordered
	 */
	protected String volume = VOLUME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPages() <em>Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPages()
	 * @generated
	 * @ordered
	 */
	protected static final String PAGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPages() <em>Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPages()
	 * @generated
	 * @ordered
	 */
	protected String pages = PAGES_EDEFAULT;

	/**
	 * The default value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected static final String YEAR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected String year = YEAR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<Tag> tags;

	/**
	 * The default value of the '{@link #getPublicationFilePath() <em>Publication File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicationFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLICATION_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublicationFilePath() <em>Publication File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicationFilePath()
	 * @generated
	 * @ordered
	 */
	protected String publicationFilePath = PUBLICATION_FILE_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BibtexEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BibtexPackage.Literals.BIBTEX_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.BIBTEX_ENTRY__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.BIBTEX_ENTRY__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.BIBTEX_ENTRY__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJournal() {
		return journal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJournal(String newJournal) {
		String oldJournal = journal;
		journal = newJournal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.BIBTEX_ENTRY__JOURNAL, oldJournal, journal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolume(String newVolume) {
		String oldVolume = volume;
		volume = newVolume;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.BIBTEX_ENTRY__VOLUME, oldVolume, volume));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPages() {
		return pages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPages(String newPages) {
		String oldPages = pages;
		pages = newPages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.BIBTEX_ENTRY__PAGES, oldPages, pages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYear() {
		return year;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYear(String newYear) {
		String oldYear = year;
		year = newYear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.BIBTEX_ENTRY__YEAR, oldYear, year));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tag> getTags() {
		if (tags == null) {
			tags = new EObjectResolvingEList<Tag>(Tag.class, this, BibtexPackage.BIBTEX_ENTRY__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublicationFilePath() {
		return publicationFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublicationFilePath(String newPublicationFilePath) {
		String oldPublicationFilePath = publicationFilePath;
		publicationFilePath = newPublicationFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.BIBTEX_ENTRY__PUBLICATION_FILE_PATH, oldPublicationFilePath, publicationFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BibtexPackage.BIBTEX_ENTRY__TEXT:
				return getText();
			case BibtexPackage.BIBTEX_ENTRY__TITLE:
				return getTitle();
			case BibtexPackage.BIBTEX_ENTRY__AUTHOR:
				return getAuthor();
			case BibtexPackage.BIBTEX_ENTRY__JOURNAL:
				return getJournal();
			case BibtexPackage.BIBTEX_ENTRY__VOLUME:
				return getVolume();
			case BibtexPackage.BIBTEX_ENTRY__PAGES:
				return getPages();
			case BibtexPackage.BIBTEX_ENTRY__YEAR:
				return getYear();
			case BibtexPackage.BIBTEX_ENTRY__TAGS:
				return getTags();
			case BibtexPackage.BIBTEX_ENTRY__PUBLICATION_FILE_PATH:
				return getPublicationFilePath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BibtexPackage.BIBTEX_ENTRY__TEXT:
				setText((String)newValue);
				return;
			case BibtexPackage.BIBTEX_ENTRY__TITLE:
				setTitle((String)newValue);
				return;
			case BibtexPackage.BIBTEX_ENTRY__AUTHOR:
				setAuthor((String)newValue);
				return;
			case BibtexPackage.BIBTEX_ENTRY__JOURNAL:
				setJournal((String)newValue);
				return;
			case BibtexPackage.BIBTEX_ENTRY__VOLUME:
				setVolume((String)newValue);
				return;
			case BibtexPackage.BIBTEX_ENTRY__PAGES:
				setPages((String)newValue);
				return;
			case BibtexPackage.BIBTEX_ENTRY__YEAR:
				setYear((String)newValue);
				return;
			case BibtexPackage.BIBTEX_ENTRY__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends Tag>)newValue);
				return;
			case BibtexPackage.BIBTEX_ENTRY__PUBLICATION_FILE_PATH:
				setPublicationFilePath((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BibtexPackage.BIBTEX_ENTRY__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case BibtexPackage.BIBTEX_ENTRY__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case BibtexPackage.BIBTEX_ENTRY__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case BibtexPackage.BIBTEX_ENTRY__JOURNAL:
				setJournal(JOURNAL_EDEFAULT);
				return;
			case BibtexPackage.BIBTEX_ENTRY__VOLUME:
				setVolume(VOLUME_EDEFAULT);
				return;
			case BibtexPackage.BIBTEX_ENTRY__PAGES:
				setPages(PAGES_EDEFAULT);
				return;
			case BibtexPackage.BIBTEX_ENTRY__YEAR:
				setYear(YEAR_EDEFAULT);
				return;
			case BibtexPackage.BIBTEX_ENTRY__TAGS:
				getTags().clear();
				return;
			case BibtexPackage.BIBTEX_ENTRY__PUBLICATION_FILE_PATH:
				setPublicationFilePath(PUBLICATION_FILE_PATH_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BibtexPackage.BIBTEX_ENTRY__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case BibtexPackage.BIBTEX_ENTRY__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case BibtexPackage.BIBTEX_ENTRY__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case BibtexPackage.BIBTEX_ENTRY__JOURNAL:
				return JOURNAL_EDEFAULT == null ? journal != null : !JOURNAL_EDEFAULT.equals(journal);
			case BibtexPackage.BIBTEX_ENTRY__VOLUME:
				return VOLUME_EDEFAULT == null ? volume != null : !VOLUME_EDEFAULT.equals(volume);
			case BibtexPackage.BIBTEX_ENTRY__PAGES:
				return PAGES_EDEFAULT == null ? pages != null : !PAGES_EDEFAULT.equals(pages);
			case BibtexPackage.BIBTEX_ENTRY__YEAR:
				return YEAR_EDEFAULT == null ? year != null : !YEAR_EDEFAULT.equals(year);
			case BibtexPackage.BIBTEX_ENTRY__TAGS:
				return tags != null && !tags.isEmpty();
			case BibtexPackage.BIBTEX_ENTRY__PUBLICATION_FILE_PATH:
				return PUBLICATION_FILE_PATH_EDEFAULT == null ? publicationFilePath != null : !PUBLICATION_FILE_PATH_EDEFAULT.equals(publicationFilePath);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BibtexPackage.BIBTEX_ENTRY___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return title;
	}

} //BibtexEntryImpl
