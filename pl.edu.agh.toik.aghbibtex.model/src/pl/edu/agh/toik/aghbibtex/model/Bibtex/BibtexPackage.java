/**
 */
package pl.edu.agh.toik.aghbibtex.model.Bibtex;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexFactory
 * @model kind="package"
 * @generated
 */
public interface BibtexPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Bibtex";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "pl.edu.agh.toik.aghbibtex.model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pl.edu.agh.toik.aghbibtex.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BibtexPackage eINSTANCE = pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexPackageImpl.init();

	/**
	 * The meta object id for the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexPackageImpl#getBibtexEntry()
	 * @generated
	 */
	int BIBTEX_ENTRY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY__TAGS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY__NAME = 2;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY___TO_STRING = 0;

	/**
	 * The number of operations of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.TagImpl <em>Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.TagImpl
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexPackageImpl#getTag()
	 * @generated
	 */
	int TAG = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__NAME = 0;

	/**
	 * The feature id for the '<em><b>Bibtex Entries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__BIBTEX_ENTRIES = 1;

	/**
	 * The number of structural features of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG___TO_STRING = 0;

	/**
	 * The number of operations of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_OPERATION_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry
	 * @generated
	 */
	EClass getBibtexEntry();

	/**
	 * Returns the meta object for the attribute '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getValue()
	 * @see #getBibtexEntry()
	 * @generated
	 */
	EAttribute getBibtexEntry_Value();

	/**
	 * Returns the meta object for the reference list '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tags</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getTags()
	 * @see #getBibtexEntry()
	 * @generated
	 */
	EReference getBibtexEntry_Tags();

	/**
	 * Returns the meta object for the attribute '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getName()
	 * @see #getBibtexEntry()
	 * @generated
	 */
	EAttribute getBibtexEntry_Name();

	/**
	 * Returns the meta object for the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#toString()
	 * @generated
	 */
	EOperation getBibtexEntry__ToString();

	/**
	 * Returns the meta object for class '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag
	 * @generated
	 */
	EClass getTag();

	/**
	 * Returns the meta object for the attribute '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag#getName()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Name();

	/**
	 * Returns the meta object for the reference list '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag#getBibtexEntries <em>Bibtex Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Bibtex Entries</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag#getBibtexEntries()
	 * @see #getTag()
	 * @generated
	 */
	EReference getTag_BibtexEntries();

	/**
	 * Returns the meta object for the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag#toString()
	 * @generated
	 */
	EOperation getTag__ToString();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BibtexFactory getBibtexFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexEntryImpl
		 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexPackageImpl#getBibtexEntry()
		 * @generated
		 */
		EClass BIBTEX_ENTRY = eINSTANCE.getBibtexEntry();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIBTEX_ENTRY__VALUE = eINSTANCE.getBibtexEntry_Value();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIBTEX_ENTRY__TAGS = eINSTANCE.getBibtexEntry_Tags();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIBTEX_ENTRY__NAME = eINSTANCE.getBibtexEntry_Name();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BIBTEX_ENTRY___TO_STRING = eINSTANCE.getBibtexEntry__ToString();

		/**
		 * The meta object literal for the '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.TagImpl <em>Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.TagImpl
		 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.impl.BibtexPackageImpl#getTag()
		 * @generated
		 */
		EClass TAG = eINSTANCE.getTag();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__NAME = eINSTANCE.getTag_Name();

		/**
		 * The meta object literal for the '<em><b>Bibtex Entries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG__BIBTEX_ENTRIES = eINSTANCE.getTag_BibtexEntries();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TAG___TO_STRING = eINSTANCE.getTag__ToString();

	}

} //BibtexPackage
