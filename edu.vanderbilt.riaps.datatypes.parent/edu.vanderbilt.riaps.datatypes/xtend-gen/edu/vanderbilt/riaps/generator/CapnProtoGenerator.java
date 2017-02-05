package edu.vanderbilt.riaps.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import edu.vanderbilt.riaps.Console;
import edu.vanderbilt.riaps.datatypes.FBasicTypeId;
import edu.vanderbilt.riaps.datatypes.FEnumerationType;
import edu.vanderbilt.riaps.datatypes.FEnumerator;
import edu.vanderbilt.riaps.datatypes.FField;
import edu.vanderbilt.riaps.datatypes.FStructType;
import edu.vanderbilt.riaps.datatypes.FType;
import edu.vanderbilt.riaps.datatypes.FTypeRef;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class CapnProtoGenerator extends AbstractGenerator {
  public static class SequenceDefinition {
    private String typename;
    
    private String suffix;
    
    public SequenceDefinition(final FType y, final String type) {
      String _name = y.getName();
      this.suffix = _name;
      this.typename = type;
    }
    
    public String uniqueIdentifier() {
      return ((this.typename + "_") + this.suffix);
    }
    
    public String sequenceName() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("typedef sequence<");
      _builder.append(this.typename, "");
      _builder.append("> ");
      String _uniqueIdentifier = this.uniqueIdentifier();
      _builder.append(_uniqueIdentifier, "");
      _builder.append(";\t\t");
      _builder.newLineIfNotEmpty();
      return _builder.toString();
    }
  }
  
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  private final Logger LOGGER = Logger.getLogger(CapnProtoGenerator.class.getName());
  
  public static String createRandomString(final int length) {
    Random random = new Random();
    StringBuilder sb = new StringBuilder();
    while ((sb.length() < length)) {
      int _nextInt = random.nextInt();
      String _hexString = Integer.toHexString(_nextInt);
      sb.append(_hexString);
    }
    return sb.toString();
  }
  
  private static HashMap<String, CapnProtoGenerator.SequenceDefinition> typedefs = new HashMap<String, CapnProtoGenerator.SequenceDefinition>();
  
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    TreeIterator<EObject> _allContents = input.getAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_allContents);
    Iterable<FStructType> _filter = Iterables.<FStructType>filter(_iterable, FStructType.class);
    for (final FStructType e : _filter) {
      {
        String messageString = this.compileToString(e);
        QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(e);
        String _string = _fullyQualifiedName.toString("/");
        String _plus = (_string + ".capnp");
        String _beautify = this.beautify(messageString);
        fsa.generateFile(_plus, _beautify);
        Console _instance = Console.getInstance();
        QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(e);
        String _string_1 = _fullyQualifiedName_1.toString("/");
        String _plus_1 = (_string_1 + ".idl generated");
        _instance.log(Level.INFO, _plus_1);
      }
    }
    TreeIterator<EObject> _allContents_1 = input.getAllContents();
    Iterable<EObject> _iterable_1 = IteratorExtensions.<EObject>toIterable(_allContents_1);
    Iterable<FEnumerationType> _filter_1 = Iterables.<FEnumerationType>filter(_iterable_1, FEnumerationType.class);
    for (final FEnumerationType e_1 : _filter_1) {
      {
        String messageString = this.compileToString(e_1);
        QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(e_1);
        String _string = _fullyQualifiedName.toString("/");
        String _plus = (_string + ".idl");
        String _beautify = this.beautify(messageString);
        fsa.generateFile(_plus, _beautify);
        Console _instance = Console.getInstance();
        QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(e_1);
        String _string_1 = _fullyQualifiedName_1.toString("/");
        String _plus_1 = (_string_1 + ".idl generated");
        _instance.log(Level.INFO, _plus_1);
      }
    }
  }
  
  public String beautify(final String code) {
    int indent = 0;
    StringBuilder temp = new StringBuilder();
    String[] contents = code.split("\n");
    String SEPARATOR = "    ";
    for (final String line : contents) {
      boolean _contains = line.contains("{");
      if (_contains) {
        for (int i = 0; (i < indent); i++) {
          temp.append(SEPARATOR);
        }
        String _trim = line.trim();
        temp.append(_trim);
        temp.append("\n");
        indent++;
      } else {
        boolean _contains_1 = line.contains("}");
        if (_contains_1) {
          indent--;
          for (int i = 0; (i < indent); i++) {
            temp.append(SEPARATOR);
          }
          String _trim_1 = line.trim();
          temp.append(_trim_1);
          temp.append("\n");
        } else {
          for (int i = 0; (i < indent); i++) {
            temp.append(SEPARATOR);
          }
          String _trim_2 = line.trim();
          temp.append(_trim_2);
          temp.append("\n");
        }
      }
    }
    return temp.toString();
  }
  
  public String compileToString(final FEnumerationType message) {
    StringConcatenation _builder = new StringConcatenation();
    QualifiedName x = this._iQualifiedNameProvider.getFullyQualifiedName(message);
    _builder.newLineIfNotEmpty();
    int s = x.getSegmentCount();
    _builder.append("\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("@0x");
    String _createRandomString = CapnProtoGenerator.createRandomString(8);
    _builder.append(_createRandomString, "");
    _builder.append(";\t");
    _builder.newLineIfNotEmpty();
    _builder.append("enum ");
    String _name = message.getName();
    _builder.append(_name, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<FEnumerator> _enumerators = message.getEnumerators();
      for(final FEnumerator j : _enumerators) {
        _builder.append("\t");
        String _name_1 = j.getName();
        _builder.append(_name_1, "\t");
        _builder.append("\t@0;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String compileToString(final FStructType message) {
    StringConcatenation _builder = new StringConcatenation();
    HashSet<String> z = new HashSet<String>();
    _builder.newLineIfNotEmpty();
    HashSet<String> listz = new HashSet<String>();
    _builder.newLineIfNotEmpty();
    QualifiedName x = this._iQualifiedNameProvider.getFullyQualifiedName(message);
    _builder.newLineIfNotEmpty();
    int s = x.getSegmentCount();
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append("@0x");
    String _createRandomString = CapnProtoGenerator.createRandomString(8);
    _builder.append(_createRandomString, "");
    _builder.append(";\t");
    _builder.newLineIfNotEmpty();
    {
      EList<FField> _elements = message.getElements();
      for(final FField j : _elements) {
        {
          FTypeRef _type = j.getType();
          FType _derived = _type.getDerived();
          boolean _notEquals = (!Objects.equal(_derived, null));
          if (_notEquals) {
            FTypeRef _type_1 = j.getType();
            FType _derived_1 = _type_1.getDerived();
            String _name = _derived_1.getName();
            boolean result = z.add(_name);
            _builder.newLineIfNotEmpty();
            {
              if (result) {
                FTypeRef _type_2 = j.getType();
                FType _derived_2 = _type_2.getDerived();
                QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(_derived_2);
                String n = _fullyQualifiedName.toString("/");
                _builder.newLineIfNotEmpty();
                _builder.append("using import  \"");
                _builder.append(n, "");
                _builder.append(".capnp\".");
                FTypeRef _type_3 = j.getType();
                FType _derived_3 = _type_3.getDerived();
                String _name_1 = _derived_3.getName();
                _builder.append(_name_1, "");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("struct ");
    String _name_2 = message.getName();
    _builder.append(_name_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    {
      EList<FField> _elements_1 = message.getElements();
      for(final FField j_1 : _elements_1) {
        {
          boolean _isList = j_1.isList();
          if (_isList) {
            _builder.append("\t");
            String _name_3 = j_1.getName();
            _builder.append(_name_3, "\t");
            _builder.append(" @0: List(");
            String _idlType = this.getIdlType(j_1);
            _builder.append(_idlType, "\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            String _name_4 = j_1.getName();
            _builder.append(_name_4, "\t");
            _builder.append(" @0: ");
            String _idlType_1 = this.getIdlType(j_1);
            _builder.append(_idlType_1, "\t");
            _builder.append(";\t\t\t\t\t\t\t\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String getIdlType(final FField field) {
    FTypeRef _type = field.getType();
    FType _derived = _type.getDerived();
    boolean _notEquals = (!Objects.equal(_derived, null));
    if (_notEquals) {
      FTypeRef _type_1 = field.getType();
      FType _derived_1 = _type_1.getDerived();
      return _derived_1.getName();
    }
    Console _instance = Console.getInstance();
    FTypeRef _type_2 = field.getType();
    FBasicTypeId _predefined = _type_2.getPredefined();
    String _literal = _predefined.getLiteral();
    _instance.log(Level.INFO, _literal);
    FTypeRef _type_3 = field.getType();
    FBasicTypeId _predefined_1 = _type_3.getPredefined();
    String _literal_1 = _predefined_1.getLiteral();
    boolean _equals = Objects.equal(_literal_1, "Boolean");
    if (_equals) {
      return "Bool";
    }
    FTypeRef _type_4 = field.getType();
    FBasicTypeId _predefined_2 = _type_4.getPredefined();
    String _literal_2 = _predefined_2.getLiteral();
    boolean _equals_1 = Objects.equal(_literal_2, "Float");
    if (_equals_1) {
      return "Float32";
    }
    FTypeRef _type_5 = field.getType();
    FBasicTypeId _predefined_3 = _type_5.getPredefined();
    String _literal_3 = _predefined_3.getLiteral();
    boolean _equals_2 = Objects.equal(_literal_3, "Double");
    if (_equals_2) {
      return "Float64";
    }
    FTypeRef _type_6 = field.getType();
    FBasicTypeId _predefined_4 = _type_6.getPredefined();
    String _literal_4 = _predefined_4.getLiteral();
    boolean _equals_3 = Objects.equal(_literal_4, "ByteBuffer");
    if (_equals_3) {
      return "Data";
    }
    FTypeRef _type_7 = field.getType();
    FBasicTypeId _predefined_5 = _type_7.getPredefined();
    String _literal_5 = _predefined_5.getLiteral();
    boolean _equals_4 = Objects.equal(_literal_5, "char");
    if (_equals_4) {
      return "UInt8";
    }
    FTypeRef _type_8 = field.getType();
    FBasicTypeId _predefined_6 = _type_8.getPredefined();
    String _literal_6 = _predefined_6.getLiteral();
    boolean _equals_5 = Objects.equal(_literal_6, "String");
    if (_equals_5) {
      return "Text";
    }
    FTypeRef _type_9 = field.getType();
    FBasicTypeId _predefined_7 = _type_9.getPredefined();
    return _predefined_7.getLiteral();
  }
}
