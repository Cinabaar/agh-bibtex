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
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getValue <em>Value</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getTags <em>Tags</em>}</li>
 *   <li>{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getBibtexEntry()
 * @model
 * @generated
 */
public interface BibtexEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getBibtexEntry_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

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
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#getBibtexEntry_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return name;'"
	 * @generated
	 */
	String toString();

} // BibtexEntry
