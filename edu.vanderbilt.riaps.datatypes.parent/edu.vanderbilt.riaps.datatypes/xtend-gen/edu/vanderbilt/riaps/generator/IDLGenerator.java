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
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class IDLGenerator extends AbstractGenerator {
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
  
  private final Logger LOGGER = Logger.getLogger(IDLGenerator.class.getName());
  
  private static HashMap<String, IDLGenerator.SequenceDefinition> typedefs = new HashMap<String, IDLGenerator.SequenceDefinition>();
  
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
        String _plus = (_string + ".idl");
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
    {
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, (s - 1), true);
      for(final Integer i : _doubleDotLessThan) {
        _builder.append("module ");
        String _segment = x.getSegment((i).intValue());
        _builder.append(_segment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("{");
        _builder.newLine();
      }
    }
    _builder.append("enum ");
    String _name = message.getName();
    _builder.append(_name, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<FEnumerator> _enumerators = message.getEnumerators();
      boolean _hasElements = false;
      for(final FEnumerator j : _enumerators) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t");
        }
        _builder.append("\t");
        String _name_1 = j.getName();
        _builder.append(_name_1, "\t");
        _builder.append("\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    {
      IntegerRange _upTo = new IntegerRange((s - 1), 1);
      for(final Integer i_1 : _upTo) {
        _builder.append("};");
        _builder.newLine();
      }
    }
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
    _builder.append("\t\t");
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
                _builder.append("#include <");
                _builder.append(n, "");
                _builder.append(".idl>");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    {
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, (s - 1), true);
      for(final Integer i : _doubleDotLessThan) {
        _builder.append("module ");
        String _segment = x.getSegment((i).intValue());
        _builder.append(_segment, "");
        _builder.newLineIfNotEmpty();
        _builder.append("{");
        _builder.newLine();
      }
    }
    {
      EList<FField> _elements_1 = message.getElements();
      for(final FField j_1 : _elements_1) {
        {
          boolean _isList = j_1.isList();
          if (_isList) {
            String _idlType = this.getIdlType(j_1);
            boolean result_1 = listz.add(_idlType);
            _builder.newLineIfNotEmpty();
            {
              if (result_1) {
                String _idlType_1 = this.getIdlType(j_1);
                IDLGenerator.SequenceDefinition temp = new IDLGenerator.SequenceDefinition(message, _idlType_1);
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                String _sequenceName = temp.sequenceName();
                _builder.append(_sequenceName, "\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("struct ");
    String _name_1 = message.getName();
    _builder.append(_name_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    {
      EList<FField> _elements_2 = message.getElements();
      for(final FField j_2 : _elements_2) {
        {
          boolean _isList_1 = j_2.isList();
          if (_isList_1) {
            _builder.append("\t");
            String _idlType_2 = this.getIdlType(j_2);
            IDLGenerator.SequenceDefinition temp_1 = new IDLGenerator.SequenceDefinition(message, _idlType_2);
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            String _uniqueIdentifier = temp_1.uniqueIdentifier();
            _builder.append(_uniqueIdentifier, "\t\t");
            _builder.append(" ");
            String _name_2 = j_2.getName();
            _builder.append(_name_2, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            String _idlType_3 = this.getIdlType(j_2);
            _builder.append(_idlType_3, "\t");
            _builder.append("  ");
            String _name_3 = j_2.getName();
            _builder.append(_name_3, "\t");
            _builder.append(";\t\t\t\t\t\t\t\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    {
      IntegerRange _upTo = new IntegerRange((s - 1), 1);
      for(final Integer i_1 : _upTo) {
        _builder.append("};");
        _builder.newLine();
      }
    }
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
    boolean _equals = Objects.equal(_literal_1, "Int8");
    if (_equals) {
      return "octet";
    }
    FTypeRef _type_4 = field.getType();
    FBasicTypeId _predefined_2 = _type_4.getPredefined();
    String _literal_2 = _predefined_2.getLiteral();
    boolean _equals_1 = Objects.equal(_literal_2, "UInt8");
    if (_equals_1) {
      return "octet";
    }
    FTypeRef _type_5 = field.getType();
    FBasicTypeId _predefined_3 = _type_5.getPredefined();
    String _literal_3 = _predefined_3.getLiteral();
    boolean _equals_2 = Objects.equal(_literal_3, "Int16");
    if (_equals_2) {
      return "short";
    }
    FTypeRef _type_6 = field.getType();
    FBasicTypeId _predefined_4 = _type_6.getPredefined();
    String _literal_4 = _predefined_4.getLiteral();
    boolean _equals_3 = Objects.equal(_literal_4, "UInt16");
    if (_equals_3) {
      return "unsigned short ";
    }
    FTypeRef _type_7 = field.getType();
    FBasicTypeId _predefined_5 = _type_7.getPredefined();
    String _literal_5 = _predefined_5.getLiteral();
    boolean _equals_4 = Objects.equal(_literal_5, "Int32");
    if (_equals_4) {
      return "long";
    }
    FTypeRef _type_8 = field.getType();
    FBasicTypeId _predefined_6 = _type_8.getPredefined();
    String _literal_6 = _predefined_6.getLiteral();
    boolean _equals_5 = Objects.equal(_literal_6, "UInt32");
    if (_equals_5) {
      return "unsigned long";
    }
    FTypeRef _type_9 = field.getType();
    FBasicTypeId _predefined_7 = _type_9.getPredefined();
    String _literal_7 = _predefined_7.getLiteral();
    boolean _equals_6 = Objects.equal(_literal_7, "Int64");
    if (_equals_6) {
      return "long long";
    }
    FTypeRef _type_10 = field.getType();
    FBasicTypeId _predefined_8 = _type_10.getPredefined();
    String _literal_8 = _predefined_8.getLiteral();
    boolean _equals_7 = Objects.equal(_literal_8, "UInt64");
    if (_equals_7) {
      return "unsigned long long";
    }
    FTypeRef _type_11 = field.getType();
    FBasicTypeId _predefined_9 = _type_11.getPredefined();
    String _literal_9 = _predefined_9.getLiteral();
    boolean _equals_8 = Objects.equal(_literal_9, "Boolean");
    if (_equals_8) {
      return "boolean";
    }
    FTypeRef _type_12 = field.getType();
    FBasicTypeId _predefined_10 = _type_12.getPredefined();
    String _literal_10 = _predefined_10.getLiteral();
    boolean _equals_9 = Objects.equal(_literal_10, "Float");
    if (_equals_9) {
      return "float";
    }
    FTypeRef _type_13 = field.getType();
    FBasicTypeId _predefined_11 = _type_13.getPredefined();
    String _literal_11 = _predefined_11.getLiteral();
    boolean _equals_10 = Objects.equal(_literal_11, "Double");
    if (_equals_10) {
      return "double";
    }
    FTypeRef _type_14 = field.getType();
    FBasicTypeId _predefined_12 = _type_14.getPredefined();
    String _literal_12 = _predefined_12.getLiteral();
    boolean _equals_11 = Objects.equal(_literal_12, "ByteBuffer");
    if (_equals_11) {
      return "Octet";
    }
    FTypeRef _type_15 = field.getType();
    FBasicTypeId _predefined_13 = _type_15.getPredefined();
    String _literal_13 = _predefined_13.getLiteral();
    boolean _equals_12 = Objects.equal(_literal_13, "char");
    if (_equals_12) {
      return "char";
    }
    FTypeRef _type_16 = field.getType();
    FBasicTypeId _predefined_14 = _type_16.getPredefined();
    return _predefined_14.getLiteral();
  }
}
