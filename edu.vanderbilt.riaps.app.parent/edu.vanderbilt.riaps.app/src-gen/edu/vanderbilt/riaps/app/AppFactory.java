/**
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.app;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.vanderbilt.riaps.app.AppPackage
 * @generated
 */
public interface AppFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AppFactory eINSTANCE = edu.vanderbilt.riaps.app.impl.AppFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Mdodel</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mdodel</em>'.
   * @generated
   */
  Mdodel createMdodel();

  /**
   * Returns a new object of class '<em>Formal Default</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Default</em>'.
   * @generated
   */
  FormalDefault createFormalDefault();

  /**
   * Returns a new object of class '<em>String Default</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Default</em>'.
   * @generated
   */
  StringDefault createStringDefault();

  /**
   * Returns a new object of class '<em>Number Default</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Number Default</em>'.
   * @generated
   */
  NumberDefault createNumberDefault();

  /**
   * Returns a new object of class '<em>Bool Default</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bool Default</em>'.
   * @generated
   */
  BoolDefault createBoolDefault();

  /**
   * Returns a new object of class '<em>Collection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Collection</em>'.
   * @generated
   */
  Collection createCollection();

  /**
   * Returns a new object of class '<em>Component Collection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component Collection</em>'.
   * @generated
   */
  ComponentCollection createComponentCollection();

  /**
   * Returns a new object of class '<em>Application</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Application</em>'.
   * @generated
   */
  Application createApplication();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Message Collection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message Collection</em>'.
   * @generated
   */
  MessageCollection createMessageCollection();

  /**
   * Returns a new object of class '<em>Message</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message</em>'.
   * @generated
   */
  Message createMessage();

  /**
   * Returns a new object of class '<em>Artifact</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Artifact</em>'.
   * @generated
   */
  Artifact createArtifact();

  /**
   * Returns a new object of class '<em>Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component</em>'.
   * @generated
   */
  Component createComponent();

  /**
   * Returns a new object of class '<em>Device Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Device Component</em>'.
   * @generated
   */
  DeviceComponent createDeviceComponent();

  /**
   * Returns a new object of class '<em>Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component</em>'.
   * @generated
   */
  AppComponent createAppComponent();

  /**
   * Returns a new object of class '<em>Memory Units</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Memory Units</em>'.
   * @generated
   */
  MemoryUnits createMemoryUnits();

  /**
   * Returns a new object of class '<em>Requirement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Requirement</em>'.
   * @generated
   */
  Requirement createRequirement();

  /**
   * Returns a new object of class '<em>Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port</em>'.
   * @generated
   */
  Port createPort();

  /**
   * Returns a new object of class '<em>Pub Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pub Port</em>'.
   * @generated
   */
  PubPort createPubPort();

  /**
   * Returns a new object of class '<em>Sub Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub Port</em>'.
   * @generated
   */
  SubPort createSubPort();

  /**
   * Returns a new object of class '<em>Clnt Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Clnt Port</em>'.
   * @generated
   */
  ClntPort createClntPort();

  /**
   * Returns a new object of class '<em>Srv Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Srv Port</em>'.
   * @generated
   */
  SrvPort createSrvPort();

  /**
   * Returns a new object of class '<em>Req Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Req Port</em>'.
   * @generated
   */
  ReqPort createReqPort();

  /**
   * Returns a new object of class '<em>Time Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Unit</em>'.
   * @generated
   */
  TimeUnit createTimeUnit();

  /**
   * Returns a new object of class '<em>Tim Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tim Port</em>'.
   * @generated
   */
  TimPort createTimPort();

  /**
   * Returns a new object of class '<em>Ins Port</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ins Port</em>'.
   * @generated
   */
  InsPort createInsPort();

  /**
   * Returns a new object of class '<em>Component Formal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component Formal</em>'.
   * @generated
   */
  ComponentFormal createComponentFormal();

  /**
   * Returns a new object of class '<em>Actor Formal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actor Formal</em>'.
   * @generated
   */
  ActorFormal createActorFormal();

  /**
   * Returns a new object of class '<em>Actor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actor</em>'.
   * @generated
   */
  Actor createActor();

  /**
   * Returns a new object of class '<em>Instance Section</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Section</em>'.
   * @generated
   */
  InstanceSection createInstanceSection();

  /**
   * Returns a new object of class '<em>Wire</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Wire</em>'.
   * @generated
   */
  Wire createWire();

  /**
   * Returns a new object of class '<em>Actual</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actual</em>'.
   * @generated
   */
  Actual createActual();

  /**
   * Returns a new object of class '<em>Actual Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actual Value</em>'.
   * @generated
   */
  ActualValue createActualValue();

  /**
   * Returns a new object of class '<em>Instance</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance</em>'.
   * @generated
   */
  Instance createInstance();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AppPackage getAppPackage();

} //AppFactory
