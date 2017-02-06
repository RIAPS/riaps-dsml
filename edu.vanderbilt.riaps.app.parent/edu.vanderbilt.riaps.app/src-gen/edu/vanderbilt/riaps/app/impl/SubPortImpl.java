/**
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.app.impl;

import edu.vanderbilt.riaps.app.AppPackage;
import edu.vanderbilt.riaps.app.Message;
import edu.vanderbilt.riaps.app.RateLimit;
import edu.vanderbilt.riaps.app.SubPort;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.vanderbilt.riaps.app.impl.SubPortImpl#getType <em>Type</em>}</li>
 *   <li>{@link edu.vanderbilt.riaps.app.impl.SubPortImpl#getRatelimit <em>Ratelimit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubPortImpl extends PortImpl implements SubPort
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Message type;

  /**
   * The cached value of the '{@link #getRatelimit() <em>Ratelimit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRatelimit()
   * @generated
   * @ordered
   */
  protected RateLimit ratelimit;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SubPortImpl()
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
    return AppPackage.Literals.SUB_PORT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Message getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (Message)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AppPackage.SUB_PORT__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Message basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(Message newType)
  {
    Message oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AppPackage.SUB_PORT__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RateLimit getRatelimit()
  {
    return ratelimit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRatelimit(RateLimit newRatelimit, NotificationChain msgs)
  {
    RateLimit oldRatelimit = ratelimit;
    ratelimit = newRatelimit;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppPackage.SUB_PORT__RATELIMIT, oldRatelimit, newRatelimit);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRatelimit(RateLimit newRatelimit)
  {
    if (newRatelimit != ratelimit)
    {
      NotificationChain msgs = null;
      if (ratelimit != null)
        msgs = ((InternalEObject)ratelimit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppPackage.SUB_PORT__RATELIMIT, null, msgs);
      if (newRatelimit != null)
        msgs = ((InternalEObject)newRatelimit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppPackage.SUB_PORT__RATELIMIT, null, msgs);
      msgs = basicSetRatelimit(newRatelimit, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AppPackage.SUB_PORT__RATELIMIT, newRatelimit, newRatelimit));
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
      case AppPackage.SUB_PORT__RATELIMIT:
        return basicSetRatelimit(null, msgs);
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
      case AppPackage.SUB_PORT__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case AppPackage.SUB_PORT__RATELIMIT:
        return getRatelimit();
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
      case AppPackage.SUB_PORT__TYPE:
        setType((Message)newValue);
        return;
      case AppPackage.SUB_PORT__RATELIMIT:
        setRatelimit((RateLimit)newValue);
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
      case AppPackage.SUB_PORT__TYPE:
        setType((Message)null);
        return;
      case AppPackage.SUB_PORT__RATELIMIT:
        setRatelimit((RateLimit)null);
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
      case AppPackage.SUB_PORT__TYPE:
        return type != null;
      case AppPackage.SUB_PORT__RATELIMIT:
        return ratelimit != null;
    }
    return super.eIsSet(featureID);
  }

} //SubPortImpl
