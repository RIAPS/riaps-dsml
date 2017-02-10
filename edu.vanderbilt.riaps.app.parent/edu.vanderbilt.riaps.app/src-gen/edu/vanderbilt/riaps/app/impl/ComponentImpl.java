/**
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.app.impl;

import edu.vanderbilt.riaps.app.AppPackage;
import edu.vanderbilt.riaps.app.Component;
import edu.vanderbilt.riaps.app.ComponentFormal;
import edu.vanderbilt.riaps.app.Port;
import edu.vanderbilt.riaps.app.Requirement;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.vanderbilt.riaps.app.impl.ComponentImpl#getFormals <em>Formals</em>}</li>
 *   <li>{@link edu.vanderbilt.riaps.app.impl.ComponentImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link edu.vanderbilt.riaps.app.impl.ComponentImpl#getPorts <em>Ports</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentImpl extends CollectionImpl implements Component
{
  /**
   * The cached value of the '{@link #getFormals() <em>Formals</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormals()
   * @generated
   * @ordered
   */
  protected EList<ComponentFormal> formals;

  /**
   * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirements()
   * @generated
   * @ordered
   */
  protected EList<Requirement> requirements;

  /**
   * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPorts()
   * @generated
   * @ordered
   */
  protected EList<Port> ports;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComponentImpl()
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
    return AppPackage.Literals.COMPONENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ComponentFormal> getFormals()
  {
    if (formals == null)
    {
      formals = new EObjectContainmentEList<ComponentFormal>(ComponentFormal.class, this, AppPackage.COMPONENT__FORMALS);
    }
    return formals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Requirement> getRequirements()
  {
    if (requirements == null)
    {
      requirements = new EObjectContainmentEList<Requirement>(Requirement.class, this, AppPackage.COMPONENT__REQUIREMENTS);
    }
    return requirements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Port> getPorts()
  {
    if (ports == null)
    {
      ports = new EObjectContainmentEList<Port>(Port.class, this, AppPackage.COMPONENT__PORTS);
    }
    return ports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AppPackage.COMPONENT__FORMALS:
        return ((InternalEList<?>)getFormals()).basicRemove(otherEnd, msgs);
      case AppPackage.COMPONENT__REQUIREMENTS:
        return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
      case AppPackage.COMPONENT__PORTS:
        return ((InternalEList<?>)getPorts()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case AppPackage.COMPONENT__FORMALS:
        return getFormals();
      case AppPackage.COMPONENT__REQUIREMENTS:
        return getRequirements();
      case AppPackage.COMPONENT__PORTS:
        return getPorts();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AppPackage.COMPONENT__FORMALS:
        getFormals().clear();
        getFormals().addAll((Collection<? extends ComponentFormal>)newValue);
        return;
      case AppPackage.COMPONENT__REQUIREMENTS:
        getRequirements().clear();
        getRequirements().addAll((Collection<? extends Requirement>)newValue);
        return;
      case AppPackage.COMPONENT__PORTS:
        getPorts().clear();
        getPorts().addAll((Collection<? extends Port>)newValue);
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
      case AppPackage.COMPONENT__FORMALS:
        getFormals().clear();
        return;
      case AppPackage.COMPONENT__REQUIREMENTS:
        getRequirements().clear();
        return;
      case AppPackage.COMPONENT__PORTS:
        getPorts().clear();
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
      case AppPackage.COMPONENT__FORMALS:
        return formals != null && !formals.isEmpty();
      case AppPackage.COMPONENT__REQUIREMENTS:
        return requirements != null && !requirements.isEmpty();
      case AppPackage.COMPONENT__PORTS:
        return ports != null && !ports.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ComponentImpl
