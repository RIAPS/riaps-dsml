/**
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.datatypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FVersion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.vanderbilt.riaps.datatypes.FVersion#getMajor <em>Major</em>}</li>
 *   <li>{@link edu.vanderbilt.riaps.datatypes.FVersion#getMinor <em>Minor</em>}</li>
 * </ul>
 *
 * @see edu.vanderbilt.riaps.datatypes.DatatypesPackage#getFVersion()
 * @model
 * @generated
 */
public interface FVersion extends EObject
{
  /**
   * Returns the value of the '<em><b>Major</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Major</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Major</em>' attribute.
   * @see #setMajor(int)
   * @see edu.vanderbilt.riaps.datatypes.DatatypesPackage#getFVersion_Major()
   * @model
   * @generated
   */
  int getMajor();

  /**
   * Sets the value of the '{@link edu.vanderbilt.riaps.datatypes.FVersion#getMajor <em>Major</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Major</em>' attribute.
   * @see #getMajor()
   * @generated
   */
  void setMajor(int value);

  /**
   * Returns the value of the '<em><b>Minor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Minor</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Minor</em>' attribute.
   * @see #setMinor(int)
   * @see edu.vanderbilt.riaps.datatypes.DatatypesPackage#getFVersion_Minor()
   * @model
   * @generated
   */
  int getMinor();

  /**
   * Sets the value of the '{@link edu.vanderbilt.riaps.datatypes.FVersion#getMinor <em>Minor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Minor</em>' attribute.
   * @see #getMinor()
   * @generated
   */
  void setMinor(int value);

} // FVersion
