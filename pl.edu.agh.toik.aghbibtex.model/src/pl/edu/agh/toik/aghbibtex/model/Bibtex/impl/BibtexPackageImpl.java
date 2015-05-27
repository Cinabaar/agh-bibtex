/**
 */
package pl.edu.agh.toik.aghbibtex.model.Bibtex.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexEntry;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexFactory;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage;
import pl.edu.agh.toik.aghbibtex.model.Bibtex.Tag;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BibtexPackageImpl extends EPackageImpl implements BibtexPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bibtexEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see pl.edu.agh.toik.aghbibtex.model.Bibtex.BibtexPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BibtexPackageImpl() {
		super(eNS_URI, BibtexFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link BibtexPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BibtexPackage init() {
		if (isInited) return (BibtexPackage)EPackage.Registry.INSTANCE.getEPackage(BibtexPackage.eNS_URI);

		// Obtain or create and register package
		BibtexPackageImpl theBibtexPackage = (BibtexPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BibtexPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BibtexPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theBibtexPackage.createPackageContents();

		// Initialize created meta-data
		theBibtexPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBibtexPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BibtexPackage.eNS_URI, theBibtexPackage);
		return theBibtexPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBibtexEntry() {
		return bibtexEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBibtexEntry_Value() {
		return (EAttribute)bibtexEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBibtexEntry_Tags() {
		return (EReference)bibtexEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTag() {
		return tagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTag_Name() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTag_BibtexEntries() {
		return (EReference)tagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexFactory getBibtexFactory() {
		return (BibtexFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		bibtexEntryEClass = createEClass(BIBTEX_ENTRY);
		createEAttribute(bibtexEntryEClass, BIBTEX_ENTRY__VALUE);
		createEReference(bibtexEntryEClass, BIBTEX_ENTRY__TAGS);

		tagEClass = createEClass(TAG);
		createEAttribute(tagEClass, TAG__NAME);
		createEReference(tagEClass, TAG__BIBTEX_ENTRIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(bibtexEntryEClass, BibtexEntry.class, "BibtexEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBibtexEntry_Value(), ecorePackage.getEString(), "Value", null, 0, 1, BibtexEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBibtexEntry_Tags(), this.getTag(), null, "Tags", null, 0, -1, BibtexEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tagEClass, Tag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTag_Name(), ecorePackage.getEString(), "Name", null, 0, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTag_BibtexEntries(), this.getBibtexEntry(), null, "BibtexEntries", null, 0, -1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //BibtexPackageImpl
