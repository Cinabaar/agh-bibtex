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
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY__TEXT = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY__TITLE = 1;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY__AUTHOR = 2;

	/**
	 * The feature id for the '<em><b>Journal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY__JOURNAL = 3;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY__VOLUME = 4;

	/**
	 * The feature id for the '<em><b>Pages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY__PAGES = 5;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY__YEAR = 6;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY__TAGS = 7;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_ENTRY_FEATURE_COUNT = 8;

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
	 * The number of structural features of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = 1;

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
	 * Returns the meta object for the attribute '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getText()
	 * @see #getBibtexEntry()
	 * @generated
	 */
	EAttribute getBibtexEntry_Text();

	/**
	 * Returns the meta object for the attribute '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getTitle()
	 * @see #getBibtexEntry()
	 * @generated
	 */
	EAttribute getBibtexEntry_Title();

	/**
	 * Returns the meta object for the attribute '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getAuthor()
	 * @see #getBibtexEntry()
	 * @generated
	 */
	EAttribute getBibtexEntry_Author();

	/**
	 * Returns the meta object for the attribute '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getJournal <em>Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Journal</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getJournal()
	 * @see #getBibtexEntry()
	 * @generated
	 */
	EAttribute getBibtexEntry_Journal();

	/**
	 * Returns the meta object for the attribute '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getVolume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volume</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getVolume()
	 * @see #getBibtexEntry()
	 * @generated
	 */
	EAttribute getBibtexEntry_Volume();

	/**
	 * Returns the meta object for the attribute '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getPages <em>Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pages</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getPages()
	 * @see #getBibtexEntry()
	 * @generated
	 */
	EAttribute getBibtexEntry_Pages();

	/**
	 * Returns the meta object for the attribute '{@link pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry#getYear()
	 * @see #getBibtexEntry()
	 * @generated
	 */
	EAttribute getBibtexEntry_Year();

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
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIBTEX_ENTRY__TEXT = eINSTANCE.getBibtexEntry_Text();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIBTEX_ENTRY__TITLE = eINSTANCE.getBibtexEntry_Title();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIBTEX_ENTRY__AUTHOR = eINSTANCE.getBibtexEntry_Author();

		/**
		 * The meta object literal for the '<em><b>Journal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIBTEX_ENTRY__JOURNAL = eINSTANCE.getBibtexEntry_Journal();

		/**
		 * The meta object literal for the '<em><b>Volume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIBTEX_ENTRY__VOLUME = eINSTANCE.getBibtexEntry_Volume();

		/**
		 * The meta object literal for the '<em><b>Pages</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIBTEX_ENTRY__PAGES = eINSTANCE.getBibtexEntry_Pages();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIBTEX_ENTRY__YEAR = eINSTANCE.getBibtexEntry_Year();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIBTEX_ENTRY__TAGS = eINSTANCE.getBibtexEntry_Tags();

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
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TAG___TO_STRING = eINSTANCE.getTag__ToString();

	}

} //BibtexPackage
