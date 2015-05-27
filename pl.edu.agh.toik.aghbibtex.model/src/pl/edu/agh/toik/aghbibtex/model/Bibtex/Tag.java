/**
 */
package pl.edu.agh.toik.aghbibtex.model.Bibtex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag#getName <em>Name</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag#getBibtexEntries <em>Bibtex Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getTag()
 * @model
 * @generated
 */
public interface Tag extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getTag_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Bibtex Entries</b></em>' reference list.
	 * The list contents are of type {@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bibtex Entries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bibtex Entries</em>' reference list.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getTag_BibtexEntries()
	 * @model
	 * @generated
	 */
	EList<BibtexEntry> getBibtexEntries();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return name;'"
	 * @generated
	 */
	String toString();

} // Tag
