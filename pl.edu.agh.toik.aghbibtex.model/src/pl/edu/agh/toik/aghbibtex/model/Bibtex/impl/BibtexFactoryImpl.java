/**
 */
package pl.edu.agh.toik.aghbibtex.model.Bibtex.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pl.edu.agh.toik.aghbibtex.model.Bibtex.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BibtexFactoryImpl extends EFactoryImpl implements BibtexFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BibtexFactory init() {
		try {
			BibtexFactory theBibtexFactory = (BibtexFactory)EPackage.Registry.INSTANCE.getEFactory(BibtexPackage.eNS_URI);
			if (theBibtexFactory != null) {
				return theBibtexFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BibtexFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BibtexPackage.BIBTEX_ENTRY: return createBibtexEntry();
			case BibtexPackage.TAG: return createTag();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexEntry createBibtexEntry() {
		BibtexEntryImpl bibtexEntry = new BibtexEntryImpl();
		return bibtexEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag createTag() {
		TagImpl tag = new TagImpl();
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexPackage getBibtexPackage() {
		return (BibtexPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BibtexPackage getPackage() {
		return BibtexPackage.eINSTANCE;
	}

} //BibtexFactoryImpl
