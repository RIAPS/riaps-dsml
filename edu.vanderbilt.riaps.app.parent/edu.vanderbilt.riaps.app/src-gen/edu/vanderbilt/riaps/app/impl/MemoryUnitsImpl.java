/**
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.app.impl;

import edu.vanderbilt.riaps.app.AppPackage;
import edu.vanderbilt.riaps.app.MemoryUnits;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Memory Units</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.vanderbilt.riaps.app.impl.MemoryUnitsImpl#isKb <em>Kb</em>}</li>
 *   <li>{@link edu.vanderbilt.riaps.app.impl.MemoryUnitsImpl#isMb <em>Mb</em>}</li>
 *   <li>{@link edu.vanderbilt.riaps.app.impl.MemoryUnitsImpl#isGb <em>Gb</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MemoryUnitsImpl extends MinimalEObjectImpl.Container implements MemoryUnits
{
  /**
   * The default value of the '{@link #isKb() <em>Kb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isKb()
   * @generated
   * @ordered
   */
  protected static final boolean KB_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isKb() <em>Kb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isKb()
   * @generated
   * @ordered
   */
  protected boolean kb = KB_EDEFAULT;

  /**
   * The default value of the '{@link #isMb() <em>Mb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMb()
   * @generated
   * @ordered
   */
  protected static final boolean MB_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMb() <em>Mb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMb()
   * @generated
   * @ordered
   */
  protected boolean mb = MB_EDEFAULT;

  /**
   * The default value of the '{@link #isGb() <em>Gb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGb()
   * @generated
   * @ordered
   */
  protected static final boolean GB_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isGb() <em>Gb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isGb()
   * @generated
   * @ordered
   */
  protected boolean gb = GB_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MemoryUnitsImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AppPackage.Literals.MEMORY_UNITS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isKb()
  {
    return kb;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKb(boolean newKb)
  {
    boolean oldKb = kb;
    kb = newKb;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AppPackage.MEMORY_UNITS__KB, oldKb, kb));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMb()
  {
    return mb;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMb(boolean newMb)
  {
    boolean oldMb = mb;
    mb = newMb;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AppPackage.MEMORY_UNITS__MB, oldMb, mb));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isGb()
  {
    return gb;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGb(boolean newGb)
  {
    boolean oldGb = gb;
    gb = newGb;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AppPackage.MEMORY_UNITS__GB, oldGb, gb));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AppPackage.MEMORY_UNITS__KB:
        return isKb();
      case AppPackage.MEMORY_UNITS__MB:
        return isMb();
      case AppPackage.MEMORY_UNITS__GB:
        return isGb();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AppPackage.MEMORY_UNITS__KB:
        setKb((Boolean)newValue);
        return;
      case AppPackage.MEMORY_UNITS__MB:
        setMb((Boolean)newValue);
        return;
      case AppPackage.MEMORY_UNITS__GB:
        setGb((Boolean)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AppPackage.MEMORY_UNITS__KB:
        setKb(KB_EDEFAULT);
        return;
      case AppPackage.MEMORY_UNITS__MB:
        setMb(MB_EDEFAULT);
        return;
      case AppPackage.MEMORY_UNITS__GB:
        setGb(GB_EDEFAULT);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AppPackage.MEMORY_UNITS__KB:
        return kb != KB_EDEFAULT;
      case AppPackage.MEMORY_UNITS__MB:
        return mb != MB_EDEFAULT;
      case AppPackage.MEMORY_UNITS__GB:
        return gb != GB_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (kb: ");
    result.append(kb);
    result.append(", mb: ");
    result.append(mb);
    result.append(", gb: ");
    result.append(gb);
    result.append(')');
    return result.toString();
  }

} //MemoryUnitsImpl
