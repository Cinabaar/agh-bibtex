/**
 */
package pl.edu.agh.toik.aghbibtex.model.Bibtex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getText <em>Text</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getTitle <em>Title</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getAuthor <em>Author</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getJournal <em>Journal</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getVolume <em>Volume</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getPages <em>Pages</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getYear <em>Year</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getTags <em>Tags</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getPublicationFilePath <em>Publication File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getBibtexEntry()
 * @model
 * @generated
 */
public interface BibtexEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getBibtexEntry_Text()
	 * @model default=""
	 *        annotation="teneo.jpa value='@Lob\r\n@Column(length=65535)'"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getBibtexEntry_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getBibtexEntry_Author()
	 * @model
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Journal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Journal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Journal</em>' attribute.
	 * @see #setJournal(String)
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getBibtexEntry_Journal()
	 * @model
	 * @generated
	 */
	String getJournal();

	/**
	 * Sets the value of the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getJournal <em>Journal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Journal</em>' attribute.
	 * @see #getJournal()
	 * @generated
	 */
	void setJournal(String value);

	/**
	 * Returns the value of the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume</em>' attribute.
	 * @see #setVolume(String)
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getBibtexEntry_Volume()
	 * @model
	 * @generated
	 */
	String getVolume();

	/**
	 * Sets the value of the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getVolume <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume</em>' attribute.
	 * @see #getVolume()
	 * @generated
	 */
	void setVolume(String value);

	/**
	 * Returns the value of the '<em><b>Pages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pages</em>' attribute.
	 * @see #setPages(String)
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getBibtexEntry_Pages()
	 * @model
	 * @generated
	 */
	String getPages();

	/**
	 * Sets the value of the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getPages <em>Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pages</em>' attribute.
	 * @see #getPages()
	 * @generated
	 */
	void setPages(String value);

	/**
	 * Returns the value of the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Year</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Year</em>' attribute.
	 * @see #setYear(String)
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getBibtexEntry_Year()
	 * @model
	 * @generated
	 */
	String getYear();

	/**
	 * Sets the value of the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getYear <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' attribute.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(String value);

	/**
	 * Returns the value of the '<em><b>Tags</b></em>' reference list.
	 * The list contents are of type {@link pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tags</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' reference list.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getBibtexEntry_Tags()
	 * @model
	 * @generated
	 */
	EList<Tag> getTags();

	/**
	 * Returns the value of the '<em><b>Publication File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publication File Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publication File Path</em>' attribute.
	 * @see #setPublicationFilePath(String)
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getBibtexEntry_PublicationFilePath()
	 * @model
	 * @generated
	 */
	String getPublicationFilePath();

	/**
	 * Sets the value of the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getPublicationFilePath <em>Publication File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publication File Path</em>' attribute.
	 * @see #getPublicationFilePath()
	 * @generated
	 */
	void setPublicationFilePath(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='String name = title;\nfor(Tag t : tags)\n{\n\tname += \" @\" + t.getName(); \n}\nreturn name;'"
	 * @generated
	 */
	String toString();

} // BibtexEntry
