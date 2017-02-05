/**
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.formatting2;

import com.google.inject.Inject;
import edu.vanderbilt.riaps.datatypes.FField;
import edu.vanderbilt.riaps.datatypes.FStructType;
import edu.vanderbilt.riaps.datatypes.FType;
import edu.vanderbilt.riaps.datatypes.FTypeCollection;
import edu.vanderbilt.riaps.datatypes.FVersion;
import edu.vanderbilt.riaps.datatypes.Import;
import edu.vanderbilt.riaps.datatypes.Model;
import edu.vanderbilt.riaps.services.DatatypesGrammarAccess;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DatatypesFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private DatatypesGrammarAccess _datatypesGrammarAccess;
  
  protected void _format(final Model model, @Extension final IFormattableDocument document) {
    EList<Import> _imports = model.getImports();
    for (final Import imports : _imports) {
      {
        document.<Import>format(imports);
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.noSpace();
          it.newLine();
        };
        Import _prepend = document.<Import>prepend(imports, _function);
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
          it.newLine();
        };
        document.<Import>append(_prepend, _function_1);
      }
    }
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    Model _prepend = document.<Model>prepend(model, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
      it.newLine();
    };
    document.<Model>append(_prepend, _function_1);
    EList<FTypeCollection> _typeCollections = model.getTypeCollections();
    for (final FTypeCollection typeCollections : _typeCollections) {
      document.<FTypeCollection>format(typeCollections);
    }
  }
  
  protected void _format(final FTypeCollection collection, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(collection);
    ISemanticRegion _keyword = _regionFor.keyword("{");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
      it.newLine();
    };
    ISemanticRegion _prepend = document.prepend(_keyword, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
      it.newLine();
    };
    final ISemanticRegion open = document.append(_prepend, _function_1);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(collection);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
      it.newLine();
    };
    ISemanticRegion _prepend_1 = document.prepend(_keyword_1, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
      it.newLine();
    };
    final ISemanticRegion close = document.append(_prepend_1, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(open, close, _function_4);
    EList<FType> _types = collection.getTypes();
    for (final FType elements : _types) {
      document.<FType>format(elements);
    }
    FVersion v = collection.getVersion();
    {
      ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(v);
      ISemanticRegion _keyword_2 = _regionFor_2.keyword("{");
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
        it.newLine();
      };
      ISemanticRegion _prepend_2 = document.prepend(_keyword_2, _function_5);
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
        it.newLine();
      };
      final ISemanticRegion opena = document.append(_prepend_2, _function_6);
      ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(v);
      ISemanticRegion _keyword_3 = _regionFor_3.keyword("}");
      final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
        it.newLine();
      };
      ISemanticRegion _prepend_3 = document.prepend(_keyword_3, _function_7);
      final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
        it.newLine();
      };
      final ISemanticRegion closea = document.append(_prepend_3, _function_8);
      final Procedure1<IHiddenRegionFormatter> _function_9 = (IHiddenRegionFormatter it) -> {
        it.indent();
      };
      document.<ISemanticRegion, ISemanticRegion>interior(opena, closea, _function_9);
    }
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
      it.newLine();
    };
    FTypeCollection _prepend_2 = document.<FTypeCollection>prepend(collection, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
      it.newLine();
    };
    document.<FTypeCollection>append(_prepend_2, _function_6);
  }
  
  protected void _format(final FType collection, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(collection);
    ISemanticRegion _keyword = _regionFor.keyword("{");
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
      it.newLine();
    };
    ISemanticRegion _prepend = document.prepend(_keyword, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
      it.newLine();
    };
    final ISemanticRegion open = document.append(_prepend, _function_1);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(collection);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
      it.newLine();
    };
    ISemanticRegion _prepend_1 = document.prepend(_keyword_1, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
      it.newLine();
    };
    final ISemanticRegion close = document.append(_prepend_1, _function_3);
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(open, close, _function_4);
    final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
      it.newLine();
    };
    FType _prepend_2 = document.<FType>prepend(collection, _function_5);
    final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
      it.newLine();
    };
    document.<FType>append(_prepend_2, _function_6);
    if ((collection instanceof FStructType)) {
      EList<FField> _elements = ((FStructType)collection).getElements();
      for (final FField e : _elements) {
        final Procedure1<IHiddenRegionFormatter> _function_7 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
          it.newLine();
        };
        FField _prepend_3 = document.<FField>prepend(e, _function_7);
        final Procedure1<IHiddenRegionFormatter> _function_8 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
          it.newLine();
        };
        document.<FField>append(_prepend_3, _function_8);
      }
    }
  }
  
  public void format(final Object model, final IFormattableDocument document) {
    if (model instanceof XtextResource) {
      _format((XtextResource)model, document);
      return;
    } else if (model instanceof Model) {
      _format((Model)model, document);
      return;
    } else if (model instanceof FType) {
      _format((FType)model, document);
      return;
    } else if (model instanceof FTypeCollection) {
      _format((FTypeCollection)model, document);
      return;
    } else if (model instanceof EObject) {
      _format((EObject)model, document);
      return;
    } else if (model == null) {
      _format((Void)null, document);
      return;
    } else if (model != null) {
      _format(model, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(model, document).toString());
    }
  }
}
