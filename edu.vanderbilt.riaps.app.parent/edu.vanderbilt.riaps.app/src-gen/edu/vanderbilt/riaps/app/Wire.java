/**
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.app;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.vanderbilt.riaps.app.Wire#getClnt <em>Clnt</em>}</li>
 *   <li>{@link edu.vanderbilt.riaps.app.Wire#getServer <em>Server</em>}</li>
 *   <li>{@link edu.vanderbilt.riaps.app.Wire#isAmi <em>Ami</em>}</li>
 *   <li>{@link edu.vanderbilt.riaps.app.Wire#getReq <em>Req</em>}</li>
 * </ul>
 *
 * @see edu.vanderbilt.riaps.app.AppPackage#getWire()
 * @model
 * @generated
 */
public interface Wire extends EObject
{
  /**
   * Returns the value of the '<em><b>Clnt</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Clnt</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clnt</em>' reference.
   * @see #setClnt(ClntPort)
   * @see edu.vanderbilt.riaps.app.AppPackage#getWire_Clnt()
   * @model
   * @generated
   */
  ClntPort getClnt();

  /**
   * Sets the value of the '{@link edu.vanderbilt.riaps.app.Wire#getClnt <em>Clnt</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clnt</em>' reference.
   * @see #getClnt()
   * @generated
   */
  void setClnt(ClntPort value);

  /**
   * Returns the value of the '<em><b>Server</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Server</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Server</em>' reference.
   * @see #setServer(SrvPort)
   * @see edu.vanderbilt.riaps.app.AppPackage#getWire_Server()
   * @model
   * @generated
   */
  SrvPort getServer();

  /**
   * Sets the value of the '{@link edu.vanderbilt.riaps.app.Wire#getServer <em>Server</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Server</em>' reference.
   * @see #getServer()
   * @generated
   */
  void setServer(SrvPort value);

  /**
   * Returns the value of the '<em><b>Ami</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ami</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ami</em>' attribute.
   * @see #setAmi(boolean)
   * @see edu.vanderbilt.riaps.app.AppPackage#getWire_Ami()
   * @model
   * @generated
   */
  boolean isAmi();

  /**
   * Sets the value of the '{@link edu.vanderbilt.riaps.app.Wire#isAmi <em>Ami</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ami</em>' attribute.
   * @see #isAmi()
   * @generated
   */
  void setAmi(boolean value);

  /**
   * Returns the value of the '<em><b>Req</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Req</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Req</em>' reference.
   * @see #setReq(ReqPort)
   * @see edu.vanderbilt.riaps.app.AppPackage#getWire_Req()
   * @model
   * @generated
   */
  ReqPort getReq();

  /**
   * Sets the value of the '{@link edu.vanderbilt.riaps.app.Wire#getReq <em>Req</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Req</em>' reference.
   * @see #getReq()
   * @generated
   */
  void setReq(ReqPort value);

} // Wire
