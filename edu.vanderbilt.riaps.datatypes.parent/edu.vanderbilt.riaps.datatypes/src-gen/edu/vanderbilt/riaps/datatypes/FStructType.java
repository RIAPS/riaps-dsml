/**
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.datatypes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FStruct Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.vanderbilt.riaps.datatypes.FStructType#getBase <em>Base</em>}</li>
 *   <li>{@link edu.vanderbilt.riaps.datatypes.FStructType#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see edu.vanderbilt.riaps.datatypes.DatatypesPackage#getFStructType()
 * @model
 * @generated
 */
public interface FStructType extends FType
{
  /**
   * Returns the value of the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' reference.
   * @see #setBase(FStructType)
   * @see edu.vanderbilt.riaps.datatypes.DatatypesPackage#getFStructType_Base()
   * @model
   * @generated
   */
  FStructType getBase();

  /**
   * Sets the value of the '{@link edu.vanderbilt.riaps.datatypes.FStructType#getBase <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' reference.
   * @see #getBase()
   * @generated
   */
  void setBase(FStructType value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link edu.vanderbilt.riaps.datatypes.FField}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see edu.vanderbilt.riaps.datatypes.DatatypesPackage#getFStructType_Elements()
   * @model containment="true"
   * @generated
   */
  EList<FField> getElements();

} // FStructType
