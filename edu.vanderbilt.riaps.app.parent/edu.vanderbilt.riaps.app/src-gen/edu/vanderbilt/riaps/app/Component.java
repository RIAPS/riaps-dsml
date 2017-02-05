/**
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.app;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.vanderbilt.riaps.app.Component#getName <em>Name</em>}</li>
 *   <li>{@link edu.vanderbilt.riaps.app.Component#getFormals <em>Formals</em>}</li>
 *   <li>{@link edu.vanderbilt.riaps.app.Component#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link edu.vanderbilt.riaps.app.Component#getPorts <em>Ports</em>}</li>
 * </ul>
 *
 * @see edu.vanderbilt.riaps.app.AppPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends EObject
{
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
   * @see edu.vanderbilt.riaps.app.AppPackage#getComponent_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.vanderbilt.riaps.app.Component#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Formals</b></em>' containment reference list.
   * The list contents are of type {@link edu.vanderbilt.riaps.app.ComponentFormal}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formals</em>' containment reference list.
   * @see edu.vanderbilt.riaps.app.AppPackage#getComponent_Formals()
   * @model containment="true"
   * @generated
   */
  EList<ComponentFormal> getFormals();

  /**
   * Returns the value of the '<em><b>Requirements</b></em>' containment reference list.
   * The list contents are of type {@link edu.vanderbilt.riaps.app.Requirement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirements</em>' containment reference list.
   * @see edu.vanderbilt.riaps.app.AppPackage#getComponent_Requirements()
   * @model containment="true"
   * @generated
   */
  EList<Requirement> getRequirements();

  /**
   * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
   * The list contents are of type {@link edu.vanderbilt.riaps.app.Port}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ports</em>' containment reference list.
   * @see edu.vanderbilt.riaps.app.AppPackage#getComponent_Ports()
   * @model containment="true"
   * @generated
   */
  EList<Port> getPorts();

} // Component
