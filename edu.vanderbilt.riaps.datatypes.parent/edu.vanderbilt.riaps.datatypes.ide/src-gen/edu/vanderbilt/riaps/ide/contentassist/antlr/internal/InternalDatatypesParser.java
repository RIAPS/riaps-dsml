package edu.vanderbilt.riaps.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import edu.vanderbilt.riaps.services.DatatypesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDatatypesParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Int8'", "'UInt8'", "'Int16'", "'UInt16'", "'Int32'", "'UInt32'", "'Int64'", "'UInt64'", "'Boolean'", "'String'", "'Float'", "'Double'", "'Char'", "'ByteBuffer'", "'package'", "'import'", "'.'", "'*'", "'typeCollection'", "'{'", "'}'", "'version'", "'major'", "'minor'", "'struct'", "'extends'", "'enumeration'", "','", "'='", "'map'", "'to'", "']'", "'['"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalDatatypesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDatatypesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDatatypesParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDatatypes.g"; }


    	private DatatypesGrammarAccess grammarAccess;

    	public void setGrammarAccess(DatatypesGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalDatatypes.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalDatatypes.g:54:1: ( ruleModel EOF )
            // InternalDatatypes.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalDatatypes.g:62:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:66:2: ( ( ( rule__Model__Group__0 ) ) )
            // InternalDatatypes.g:67:2: ( ( rule__Model__Group__0 ) )
            {
            // InternalDatatypes.g:67:2: ( ( rule__Model__Group__0 ) )
            // InternalDatatypes.g:68:3: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalDatatypes.g:69:3: ( rule__Model__Group__0 )
            // InternalDatatypes.g:69:4: rule__Model__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleImport"
    // InternalDatatypes.g:78:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalDatatypes.g:79:1: ( ruleImport EOF )
            // InternalDatatypes.g:80:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalDatatypes.g:87:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:91:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalDatatypes.g:92:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalDatatypes.g:92:2: ( ( rule__Import__Group__0 ) )
            // InternalDatatypes.g:93:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalDatatypes.g:94:3: ( rule__Import__Group__0 )
            // InternalDatatypes.g:94:4: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportedFQN"
    // InternalDatatypes.g:103:1: entryRuleImportedFQN : ruleImportedFQN EOF ;
    public final void entryRuleImportedFQN() throws RecognitionException {
        try {
            // InternalDatatypes.g:104:1: ( ruleImportedFQN EOF )
            // InternalDatatypes.g:105:1: ruleImportedFQN EOF
            {
             before(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_1);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImportedFQN"


    // $ANTLR start "ruleImportedFQN"
    // InternalDatatypes.g:112:1: ruleImportedFQN : ( ( rule__ImportedFQN__Group__0 ) ) ;
    public final void ruleImportedFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:116:2: ( ( ( rule__ImportedFQN__Group__0 ) ) )
            // InternalDatatypes.g:117:2: ( ( rule__ImportedFQN__Group__0 ) )
            {
            // InternalDatatypes.g:117:2: ( ( rule__ImportedFQN__Group__0 ) )
            // InternalDatatypes.g:118:3: ( rule__ImportedFQN__Group__0 )
            {
             before(grammarAccess.getImportedFQNAccess().getGroup()); 
            // InternalDatatypes.g:119:3: ( rule__ImportedFQN__Group__0 )
            // InternalDatatypes.g:119:4: rule__ImportedFQN__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ImportedFQN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportedFQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImportedFQN"


    // $ANTLR start "entryRuleFQN"
    // InternalDatatypes.g:128:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalDatatypes.g:129:1: ( ruleFQN EOF )
            // InternalDatatypes.g:130:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalDatatypes.g:137:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:141:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalDatatypes.g:142:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalDatatypes.g:142:2: ( ( rule__FQN__Group__0 ) )
            // InternalDatatypes.g:143:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalDatatypes.g:144:3: ( rule__FQN__Group__0 )
            // InternalDatatypes.g:144:4: rule__FQN__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FQN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleFTypeCollection"
    // InternalDatatypes.g:153:1: entryRuleFTypeCollection : ruleFTypeCollection EOF ;
    public final void entryRuleFTypeCollection() throws RecognitionException {
        try {
            // InternalDatatypes.g:154:1: ( ruleFTypeCollection EOF )
            // InternalDatatypes.g:155:1: ruleFTypeCollection EOF
            {
             before(grammarAccess.getFTypeCollectionRule()); 
            pushFollow(FOLLOW_1);
            ruleFTypeCollection();

            state._fsp--;

             after(grammarAccess.getFTypeCollectionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFTypeCollection"


    // $ANTLR start "ruleFTypeCollection"
    // InternalDatatypes.g:162:1: ruleFTypeCollection : ( ( rule__FTypeCollection__Group__0 ) ) ;
    public final void ruleFTypeCollection() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:166:2: ( ( ( rule__FTypeCollection__Group__0 ) ) )
            // InternalDatatypes.g:167:2: ( ( rule__FTypeCollection__Group__0 ) )
            {
            // InternalDatatypes.g:167:2: ( ( rule__FTypeCollection__Group__0 ) )
            // InternalDatatypes.g:168:3: ( rule__FTypeCollection__Group__0 )
            {
             before(grammarAccess.getFTypeCollectionAccess().getGroup()); 
            // InternalDatatypes.g:169:3: ( rule__FTypeCollection__Group__0 )
            // InternalDatatypes.g:169:4: rule__FTypeCollection__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FTypeCollection__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFTypeCollectionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFTypeCollection"


    // $ANTLR start "entryRuleFVersion"
    // InternalDatatypes.g:178:1: entryRuleFVersion : ruleFVersion EOF ;
    public final void entryRuleFVersion() throws RecognitionException {
        try {
            // InternalDatatypes.g:179:1: ( ruleFVersion EOF )
            // InternalDatatypes.g:180:1: ruleFVersion EOF
            {
             before(grammarAccess.getFVersionRule()); 
            pushFollow(FOLLOW_1);
            ruleFVersion();

            state._fsp--;

             after(grammarAccess.getFVersionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFVersion"


    // $ANTLR start "ruleFVersion"
    // InternalDatatypes.g:187:1: ruleFVersion : ( ( rule__FVersion__Group__0 ) ) ;
    public final void ruleFVersion() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:191:2: ( ( ( rule__FVersion__Group__0 ) ) )
            // InternalDatatypes.g:192:2: ( ( rule__FVersion__Group__0 ) )
            {
            // InternalDatatypes.g:192:2: ( ( rule__FVersion__Group__0 ) )
            // InternalDatatypes.g:193:3: ( rule__FVersion__Group__0 )
            {
             before(grammarAccess.getFVersionAccess().getGroup()); 
            // InternalDatatypes.g:194:3: ( rule__FVersion__Group__0 )
            // InternalDatatypes.g:194:4: rule__FVersion__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FVersion__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFVersionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFVersion"


    // $ANTLR start "entryRuleFTypeRef"
    // InternalDatatypes.g:203:1: entryRuleFTypeRef : ruleFTypeRef EOF ;
    public final void entryRuleFTypeRef() throws RecognitionException {
        try {
            // InternalDatatypes.g:204:1: ( ruleFTypeRef EOF )
            // InternalDatatypes.g:205:1: ruleFTypeRef EOF
            {
             before(grammarAccess.getFTypeRefRule()); 
            pushFollow(FOLLOW_1);
            ruleFTypeRef();

            state._fsp--;

             after(grammarAccess.getFTypeRefRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFTypeRef"


    // $ANTLR start "ruleFTypeRef"
    // InternalDatatypes.g:212:1: ruleFTypeRef : ( ( rule__FTypeRef__Alternatives ) ) ;
    public final void ruleFTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:216:2: ( ( ( rule__FTypeRef__Alternatives ) ) )
            // InternalDatatypes.g:217:2: ( ( rule__FTypeRef__Alternatives ) )
            {
            // InternalDatatypes.g:217:2: ( ( rule__FTypeRef__Alternatives ) )
            // InternalDatatypes.g:218:3: ( rule__FTypeRef__Alternatives )
            {
             before(grammarAccess.getFTypeRefAccess().getAlternatives()); 
            // InternalDatatypes.g:219:3: ( rule__FTypeRef__Alternatives )
            // InternalDatatypes.g:219:4: rule__FTypeRef__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FTypeRef__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFTypeRefAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFTypeRef"


    // $ANTLR start "entryRuleFType"
    // InternalDatatypes.g:228:1: entryRuleFType : ruleFType EOF ;
    public final void entryRuleFType() throws RecognitionException {
        try {
            // InternalDatatypes.g:229:1: ( ruleFType EOF )
            // InternalDatatypes.g:230:1: ruleFType EOF
            {
             before(grammarAccess.getFTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleFType();

            state._fsp--;

             after(grammarAccess.getFTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFType"


    // $ANTLR start "ruleFType"
    // InternalDatatypes.g:237:1: ruleFType : ( ( rule__FType__Alternatives ) ) ;
    public final void ruleFType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:241:2: ( ( ( rule__FType__Alternatives ) ) )
            // InternalDatatypes.g:242:2: ( ( rule__FType__Alternatives ) )
            {
            // InternalDatatypes.g:242:2: ( ( rule__FType__Alternatives ) )
            // InternalDatatypes.g:243:3: ( rule__FType__Alternatives )
            {
             before(grammarAccess.getFTypeAccess().getAlternatives()); 
            // InternalDatatypes.g:244:3: ( rule__FType__Alternatives )
            // InternalDatatypes.g:244:4: rule__FType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFType"


    // $ANTLR start "entryRuleFStructType"
    // InternalDatatypes.g:253:1: entryRuleFStructType : ruleFStructType EOF ;
    public final void entryRuleFStructType() throws RecognitionException {
        try {
            // InternalDatatypes.g:254:1: ( ruleFStructType EOF )
            // InternalDatatypes.g:255:1: ruleFStructType EOF
            {
             before(grammarAccess.getFStructTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleFStructType();

            state._fsp--;

             after(grammarAccess.getFStructTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFStructType"


    // $ANTLR start "ruleFStructType"
    // InternalDatatypes.g:262:1: ruleFStructType : ( ( rule__FStructType__Group__0 ) ) ;
    public final void ruleFStructType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:266:2: ( ( ( rule__FStructType__Group__0 ) ) )
            // InternalDatatypes.g:267:2: ( ( rule__FStructType__Group__0 ) )
            {
            // InternalDatatypes.g:267:2: ( ( rule__FStructType__Group__0 ) )
            // InternalDatatypes.g:268:3: ( rule__FStructType__Group__0 )
            {
             before(grammarAccess.getFStructTypeAccess().getGroup()); 
            // InternalDatatypes.g:269:3: ( rule__FStructType__Group__0 )
            // InternalDatatypes.g:269:4: rule__FStructType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FStructType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFStructTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFStructType"


    // $ANTLR start "entryRuleFEnumerationType"
    // InternalDatatypes.g:278:1: entryRuleFEnumerationType : ruleFEnumerationType EOF ;
    public final void entryRuleFEnumerationType() throws RecognitionException {
        try {
            // InternalDatatypes.g:279:1: ( ruleFEnumerationType EOF )
            // InternalDatatypes.g:280:1: ruleFEnumerationType EOF
            {
             before(grammarAccess.getFEnumerationTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleFEnumerationType();

            state._fsp--;

             after(grammarAccess.getFEnumerationTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFEnumerationType"


    // $ANTLR start "ruleFEnumerationType"
    // InternalDatatypes.g:287:1: ruleFEnumerationType : ( ( rule__FEnumerationType__Group__0 ) ) ;
    public final void ruleFEnumerationType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:291:2: ( ( ( rule__FEnumerationType__Group__0 ) ) )
            // InternalDatatypes.g:292:2: ( ( rule__FEnumerationType__Group__0 ) )
            {
            // InternalDatatypes.g:292:2: ( ( rule__FEnumerationType__Group__0 ) )
            // InternalDatatypes.g:293:3: ( rule__FEnumerationType__Group__0 )
            {
             before(grammarAccess.getFEnumerationTypeAccess().getGroup()); 
            // InternalDatatypes.g:294:3: ( rule__FEnumerationType__Group__0 )
            // InternalDatatypes.g:294:4: rule__FEnumerationType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFEnumerationTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFEnumerationType"


    // $ANTLR start "entryRuleFEnumerator"
    // InternalDatatypes.g:303:1: entryRuleFEnumerator : ruleFEnumerator EOF ;
    public final void entryRuleFEnumerator() throws RecognitionException {
        try {
            // InternalDatatypes.g:304:1: ( ruleFEnumerator EOF )
            // InternalDatatypes.g:305:1: ruleFEnumerator EOF
            {
             before(grammarAccess.getFEnumeratorRule()); 
            pushFollow(FOLLOW_1);
            ruleFEnumerator();

            state._fsp--;

             after(grammarAccess.getFEnumeratorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFEnumerator"


    // $ANTLR start "ruleFEnumerator"
    // InternalDatatypes.g:312:1: ruleFEnumerator : ( ( rule__FEnumerator__Group__0 ) ) ;
    public final void ruleFEnumerator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:316:2: ( ( ( rule__FEnumerator__Group__0 ) ) )
            // InternalDatatypes.g:317:2: ( ( rule__FEnumerator__Group__0 ) )
            {
            // InternalDatatypes.g:317:2: ( ( rule__FEnumerator__Group__0 ) )
            // InternalDatatypes.g:318:3: ( rule__FEnumerator__Group__0 )
            {
             before(grammarAccess.getFEnumeratorAccess().getGroup()); 
            // InternalDatatypes.g:319:3: ( rule__FEnumerator__Group__0 )
            // InternalDatatypes.g:319:4: rule__FEnumerator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFEnumeratorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFEnumerator"


    // $ANTLR start "entryRuleFMapType"
    // InternalDatatypes.g:328:1: entryRuleFMapType : ruleFMapType EOF ;
    public final void entryRuleFMapType() throws RecognitionException {
        try {
            // InternalDatatypes.g:329:1: ( ruleFMapType EOF )
            // InternalDatatypes.g:330:1: ruleFMapType EOF
            {
             before(grammarAccess.getFMapTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleFMapType();

            state._fsp--;

             after(grammarAccess.getFMapTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFMapType"


    // $ANTLR start "ruleFMapType"
    // InternalDatatypes.g:337:1: ruleFMapType : ( ( rule__FMapType__Group__0 ) ) ;
    public final void ruleFMapType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:341:2: ( ( ( rule__FMapType__Group__0 ) ) )
            // InternalDatatypes.g:342:2: ( ( rule__FMapType__Group__0 ) )
            {
            // InternalDatatypes.g:342:2: ( ( rule__FMapType__Group__0 ) )
            // InternalDatatypes.g:343:3: ( rule__FMapType__Group__0 )
            {
             before(grammarAccess.getFMapTypeAccess().getGroup()); 
            // InternalDatatypes.g:344:3: ( rule__FMapType__Group__0 )
            // InternalDatatypes.g:344:4: rule__FMapType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FMapType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFMapTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFMapType"


    // $ANTLR start "entryRuleFField"
    // InternalDatatypes.g:353:1: entryRuleFField : ruleFField EOF ;
    public final void entryRuleFField() throws RecognitionException {
        try {
            // InternalDatatypes.g:354:1: ( ruleFField EOF )
            // InternalDatatypes.g:355:1: ruleFField EOF
            {
             before(grammarAccess.getFFieldRule()); 
            pushFollow(FOLLOW_1);
            ruleFField();

            state._fsp--;

             after(grammarAccess.getFFieldRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFField"


    // $ANTLR start "ruleFField"
    // InternalDatatypes.g:362:1: ruleFField : ( ( rule__FField__Group__0 ) ) ;
    public final void ruleFField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:366:2: ( ( ( rule__FField__Group__0 ) ) )
            // InternalDatatypes.g:367:2: ( ( rule__FField__Group__0 ) )
            {
            // InternalDatatypes.g:367:2: ( ( rule__FField__Group__0 ) )
            // InternalDatatypes.g:368:3: ( rule__FField__Group__0 )
            {
             before(grammarAccess.getFFieldAccess().getGroup()); 
            // InternalDatatypes.g:369:3: ( rule__FField__Group__0 )
            // InternalDatatypes.g:369:4: rule__FField__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FField__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFFieldAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFField"


    // $ANTLR start "ruleFBasicTypeId"
    // InternalDatatypes.g:378:1: ruleFBasicTypeId : ( ( rule__FBasicTypeId__Alternatives ) ) ;
    public final void ruleFBasicTypeId() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:382:1: ( ( ( rule__FBasicTypeId__Alternatives ) ) )
            // InternalDatatypes.g:383:2: ( ( rule__FBasicTypeId__Alternatives ) )
            {
            // InternalDatatypes.g:383:2: ( ( rule__FBasicTypeId__Alternatives ) )
            // InternalDatatypes.g:384:3: ( rule__FBasicTypeId__Alternatives )
            {
             before(grammarAccess.getFBasicTypeIdAccess().getAlternatives()); 
            // InternalDatatypes.g:385:3: ( rule__FBasicTypeId__Alternatives )
            // InternalDatatypes.g:385:4: rule__FBasicTypeId__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FBasicTypeId__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFBasicTypeIdAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFBasicTypeId"


    // $ANTLR start "rule__FTypeRef__Alternatives"
    // InternalDatatypes.g:393:1: rule__FTypeRef__Alternatives : ( ( ( rule__FTypeRef__PredefinedAssignment_0 ) ) | ( ( rule__FTypeRef__DerivedAssignment_1 ) ) );
    public final void rule__FTypeRef__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:397:1: ( ( ( rule__FTypeRef__PredefinedAssignment_0 ) ) | ( ( rule__FTypeRef__DerivedAssignment_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=11 && LA1_0<=24)) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalDatatypes.g:398:2: ( ( rule__FTypeRef__PredefinedAssignment_0 ) )
                    {
                    // InternalDatatypes.g:398:2: ( ( rule__FTypeRef__PredefinedAssignment_0 ) )
                    // InternalDatatypes.g:399:3: ( rule__FTypeRef__PredefinedAssignment_0 )
                    {
                     before(grammarAccess.getFTypeRefAccess().getPredefinedAssignment_0()); 
                    // InternalDatatypes.g:400:3: ( rule__FTypeRef__PredefinedAssignment_0 )
                    // InternalDatatypes.g:400:4: rule__FTypeRef__PredefinedAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FTypeRef__PredefinedAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFTypeRefAccess().getPredefinedAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDatatypes.g:404:2: ( ( rule__FTypeRef__DerivedAssignment_1 ) )
                    {
                    // InternalDatatypes.g:404:2: ( ( rule__FTypeRef__DerivedAssignment_1 ) )
                    // InternalDatatypes.g:405:3: ( rule__FTypeRef__DerivedAssignment_1 )
                    {
                     before(grammarAccess.getFTypeRefAccess().getDerivedAssignment_1()); 
                    // InternalDatatypes.g:406:3: ( rule__FTypeRef__DerivedAssignment_1 )
                    // InternalDatatypes.g:406:4: rule__FTypeRef__DerivedAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__FTypeRef__DerivedAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getFTypeRefAccess().getDerivedAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeRef__Alternatives"


    // $ANTLR start "rule__FType__Alternatives"
    // InternalDatatypes.g:414:1: rule__FType__Alternatives : ( ( ruleFEnumerationType ) | ( ruleFStructType ) | ( ruleFMapType ) );
    public final void rule__FType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:418:1: ( ( ruleFEnumerationType ) | ( ruleFStructType ) | ( ruleFMapType ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt2=1;
                }
                break;
            case 35:
                {
                alt2=2;
                }
                break;
            case 40:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalDatatypes.g:419:2: ( ruleFEnumerationType )
                    {
                    // InternalDatatypes.g:419:2: ( ruleFEnumerationType )
                    // InternalDatatypes.g:420:3: ruleFEnumerationType
                    {
                     before(grammarAccess.getFTypeAccess().getFEnumerationTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleFEnumerationType();

                    state._fsp--;

                     after(grammarAccess.getFTypeAccess().getFEnumerationTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDatatypes.g:425:2: ( ruleFStructType )
                    {
                    // InternalDatatypes.g:425:2: ( ruleFStructType )
                    // InternalDatatypes.g:426:3: ruleFStructType
                    {
                     before(grammarAccess.getFTypeAccess().getFStructTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleFStructType();

                    state._fsp--;

                     after(grammarAccess.getFTypeAccess().getFStructTypeParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDatatypes.g:431:2: ( ruleFMapType )
                    {
                    // InternalDatatypes.g:431:2: ( ruleFMapType )
                    // InternalDatatypes.g:432:3: ruleFMapType
                    {
                     before(grammarAccess.getFTypeAccess().getFMapTypeParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleFMapType();

                    state._fsp--;

                     after(grammarAccess.getFTypeAccess().getFMapTypeParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FType__Alternatives"


    // $ANTLR start "rule__FBasicTypeId__Alternatives"
    // InternalDatatypes.g:441:1: rule__FBasicTypeId__Alternatives : ( ( ( 'Int8' ) ) | ( ( 'UInt8' ) ) | ( ( 'Int16' ) ) | ( ( 'UInt16' ) ) | ( ( 'Int32' ) ) | ( ( 'UInt32' ) ) | ( ( 'Int64' ) ) | ( ( 'UInt64' ) ) | ( ( 'Boolean' ) ) | ( ( 'String' ) ) | ( ( 'Float' ) ) | ( ( 'Double' ) ) | ( ( 'Char' ) ) | ( ( 'ByteBuffer' ) ) );
    public final void rule__FBasicTypeId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:445:1: ( ( ( 'Int8' ) ) | ( ( 'UInt8' ) ) | ( ( 'Int16' ) ) | ( ( 'UInt16' ) ) | ( ( 'Int32' ) ) | ( ( 'UInt32' ) ) | ( ( 'Int64' ) ) | ( ( 'UInt64' ) ) | ( ( 'Boolean' ) ) | ( ( 'String' ) ) | ( ( 'Float' ) ) | ( ( 'Double' ) ) | ( ( 'Char' ) ) | ( ( 'ByteBuffer' ) ) )
            int alt3=14;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 12:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
                }
                break;
            case 14:
                {
                alt3=4;
                }
                break;
            case 15:
                {
                alt3=5;
                }
                break;
            case 16:
                {
                alt3=6;
                }
                break;
            case 17:
                {
                alt3=7;
                }
                break;
            case 18:
                {
                alt3=8;
                }
                break;
            case 19:
                {
                alt3=9;
                }
                break;
            case 20:
                {
                alt3=10;
                }
                break;
            case 21:
                {
                alt3=11;
                }
                break;
            case 22:
                {
                alt3=12;
                }
                break;
            case 23:
                {
                alt3=13;
                }
                break;
            case 24:
                {
                alt3=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalDatatypes.g:446:2: ( ( 'Int8' ) )
                    {
                    // InternalDatatypes.g:446:2: ( ( 'Int8' ) )
                    // InternalDatatypes.g:447:3: ( 'Int8' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getInt8EnumLiteralDeclaration_0()); 
                    // InternalDatatypes.g:448:3: ( 'Int8' )
                    // InternalDatatypes.g:448:4: 'Int8'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getInt8EnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDatatypes.g:452:2: ( ( 'UInt8' ) )
                    {
                    // InternalDatatypes.g:452:2: ( ( 'UInt8' ) )
                    // InternalDatatypes.g:453:3: ( 'UInt8' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getUInt8EnumLiteralDeclaration_1()); 
                    // InternalDatatypes.g:454:3: ( 'UInt8' )
                    // InternalDatatypes.g:454:4: 'UInt8'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getUInt8EnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDatatypes.g:458:2: ( ( 'Int16' ) )
                    {
                    // InternalDatatypes.g:458:2: ( ( 'Int16' ) )
                    // InternalDatatypes.g:459:3: ( 'Int16' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getInt16EnumLiteralDeclaration_2()); 
                    // InternalDatatypes.g:460:3: ( 'Int16' )
                    // InternalDatatypes.g:460:4: 'Int16'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getInt16EnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDatatypes.g:464:2: ( ( 'UInt16' ) )
                    {
                    // InternalDatatypes.g:464:2: ( ( 'UInt16' ) )
                    // InternalDatatypes.g:465:3: ( 'UInt16' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getUInt16EnumLiteralDeclaration_3()); 
                    // InternalDatatypes.g:466:3: ( 'UInt16' )
                    // InternalDatatypes.g:466:4: 'UInt16'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getUInt16EnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDatatypes.g:470:2: ( ( 'Int32' ) )
                    {
                    // InternalDatatypes.g:470:2: ( ( 'Int32' ) )
                    // InternalDatatypes.g:471:3: ( 'Int32' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getInt32EnumLiteralDeclaration_4()); 
                    // InternalDatatypes.g:472:3: ( 'Int32' )
                    // InternalDatatypes.g:472:4: 'Int32'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getInt32EnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDatatypes.g:476:2: ( ( 'UInt32' ) )
                    {
                    // InternalDatatypes.g:476:2: ( ( 'UInt32' ) )
                    // InternalDatatypes.g:477:3: ( 'UInt32' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getUInt32EnumLiteralDeclaration_5()); 
                    // InternalDatatypes.g:478:3: ( 'UInt32' )
                    // InternalDatatypes.g:478:4: 'UInt32'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getUInt32EnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDatatypes.g:482:2: ( ( 'Int64' ) )
                    {
                    // InternalDatatypes.g:482:2: ( ( 'Int64' ) )
                    // InternalDatatypes.g:483:3: ( 'Int64' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getInt64EnumLiteralDeclaration_6()); 
                    // InternalDatatypes.g:484:3: ( 'Int64' )
                    // InternalDatatypes.g:484:4: 'Int64'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getInt64EnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDatatypes.g:488:2: ( ( 'UInt64' ) )
                    {
                    // InternalDatatypes.g:488:2: ( ( 'UInt64' ) )
                    // InternalDatatypes.g:489:3: ( 'UInt64' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getUInt64EnumLiteralDeclaration_7()); 
                    // InternalDatatypes.g:490:3: ( 'UInt64' )
                    // InternalDatatypes.g:490:4: 'UInt64'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getUInt64EnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDatatypes.g:494:2: ( ( 'Boolean' ) )
                    {
                    // InternalDatatypes.g:494:2: ( ( 'Boolean' ) )
                    // InternalDatatypes.g:495:3: ( 'Boolean' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getBooleanEnumLiteralDeclaration_8()); 
                    // InternalDatatypes.g:496:3: ( 'Boolean' )
                    // InternalDatatypes.g:496:4: 'Boolean'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getBooleanEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDatatypes.g:500:2: ( ( 'String' ) )
                    {
                    // InternalDatatypes.g:500:2: ( ( 'String' ) )
                    // InternalDatatypes.g:501:3: ( 'String' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getStringEnumLiteralDeclaration_9()); 
                    // InternalDatatypes.g:502:3: ( 'String' )
                    // InternalDatatypes.g:502:4: 'String'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getStringEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDatatypes.g:506:2: ( ( 'Float' ) )
                    {
                    // InternalDatatypes.g:506:2: ( ( 'Float' ) )
                    // InternalDatatypes.g:507:3: ( 'Float' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getFloatEnumLiteralDeclaration_10()); 
                    // InternalDatatypes.g:508:3: ( 'Float' )
                    // InternalDatatypes.g:508:4: 'Float'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getFloatEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDatatypes.g:512:2: ( ( 'Double' ) )
                    {
                    // InternalDatatypes.g:512:2: ( ( 'Double' ) )
                    // InternalDatatypes.g:513:3: ( 'Double' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getDoubleEnumLiteralDeclaration_11()); 
                    // InternalDatatypes.g:514:3: ( 'Double' )
                    // InternalDatatypes.g:514:4: 'Double'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getDoubleEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDatatypes.g:518:2: ( ( 'Char' ) )
                    {
                    // InternalDatatypes.g:518:2: ( ( 'Char' ) )
                    // InternalDatatypes.g:519:3: ( 'Char' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getCharEnumLiteralDeclaration_12()); 
                    // InternalDatatypes.g:520:3: ( 'Char' )
                    // InternalDatatypes.g:520:4: 'Char'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getCharEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDatatypes.g:524:2: ( ( 'ByteBuffer' ) )
                    {
                    // InternalDatatypes.g:524:2: ( ( 'ByteBuffer' ) )
                    // InternalDatatypes.g:525:3: ( 'ByteBuffer' )
                    {
                     before(grammarAccess.getFBasicTypeIdAccess().getByteBufferEnumLiteralDeclaration_13()); 
                    // InternalDatatypes.g:526:3: ( 'ByteBuffer' )
                    // InternalDatatypes.g:526:4: 'ByteBuffer'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getFBasicTypeIdAccess().getByteBufferEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FBasicTypeId__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // InternalDatatypes.g:534:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:538:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalDatatypes.g:539:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // InternalDatatypes.g:546:1: rule__Model__Group__0__Impl : ( () ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:550:1: ( ( () ) )
            // InternalDatatypes.g:551:1: ( () )
            {
            // InternalDatatypes.g:551:1: ( () )
            // InternalDatatypes.g:552:2: ()
            {
             before(grammarAccess.getModelAccess().getModelAction_0()); 
            // InternalDatatypes.g:553:2: ()
            // InternalDatatypes.g:553:3: 
            {
            }

             after(grammarAccess.getModelAccess().getModelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // InternalDatatypes.g:561:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:565:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalDatatypes.g:566:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // InternalDatatypes.g:573:1: rule__Model__Group__1__Impl : ( 'package' ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:577:1: ( ( 'package' ) )
            // InternalDatatypes.g:578:1: ( 'package' )
            {
            // InternalDatatypes.g:578:1: ( 'package' )
            // InternalDatatypes.g:579:2: 'package'
            {
             before(grammarAccess.getModelAccess().getPackageKeyword_1()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getPackageKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // InternalDatatypes.g:588:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:592:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalDatatypes.g:593:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // InternalDatatypes.g:600:1: rule__Model__Group__2__Impl : ( ( rule__Model__NameAssignment_2 ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:604:1: ( ( ( rule__Model__NameAssignment_2 ) ) )
            // InternalDatatypes.g:605:1: ( ( rule__Model__NameAssignment_2 ) )
            {
            // InternalDatatypes.g:605:1: ( ( rule__Model__NameAssignment_2 ) )
            // InternalDatatypes.g:606:2: ( rule__Model__NameAssignment_2 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_2()); 
            // InternalDatatypes.g:607:2: ( rule__Model__NameAssignment_2 )
            // InternalDatatypes.g:607:3: rule__Model__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Model__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // InternalDatatypes.g:615:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:619:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // InternalDatatypes.g:620:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // InternalDatatypes.g:627:1: rule__Model__Group__3__Impl : ( ( rule__Model__ImportsAssignment_3 )* ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:631:1: ( ( ( rule__Model__ImportsAssignment_3 )* ) )
            // InternalDatatypes.g:632:1: ( ( rule__Model__ImportsAssignment_3 )* )
            {
            // InternalDatatypes.g:632:1: ( ( rule__Model__ImportsAssignment_3 )* )
            // InternalDatatypes.g:633:2: ( rule__Model__ImportsAssignment_3 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_3()); 
            // InternalDatatypes.g:634:2: ( rule__Model__ImportsAssignment_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==26) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalDatatypes.g:634:3: rule__Model__ImportsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Model__ImportsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getImportsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Model__Group__4"
    // InternalDatatypes.g:642:1: rule__Model__Group__4 : rule__Model__Group__4__Impl ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:646:1: ( rule__Model__Group__4__Impl )
            // InternalDatatypes.g:647:2: rule__Model__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4"


    // $ANTLR start "rule__Model__Group__4__Impl"
    // InternalDatatypes.g:653:1: rule__Model__Group__4__Impl : ( ( rule__Model__TypeCollectionsAssignment_4 )* ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:657:1: ( ( ( rule__Model__TypeCollectionsAssignment_4 )* ) )
            // InternalDatatypes.g:658:1: ( ( rule__Model__TypeCollectionsAssignment_4 )* )
            {
            // InternalDatatypes.g:658:1: ( ( rule__Model__TypeCollectionsAssignment_4 )* )
            // InternalDatatypes.g:659:2: ( rule__Model__TypeCollectionsAssignment_4 )*
            {
             before(grammarAccess.getModelAccess().getTypeCollectionsAssignment_4()); 
            // InternalDatatypes.g:660:2: ( rule__Model__TypeCollectionsAssignment_4 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==29) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalDatatypes.g:660:3: rule__Model__TypeCollectionsAssignment_4
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Model__TypeCollectionsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getTypeCollectionsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalDatatypes.g:669:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:673:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalDatatypes.g:674:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalDatatypes.g:681:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:685:1: ( ( 'import' ) )
            // InternalDatatypes.g:686:1: ( 'import' )
            {
            // InternalDatatypes.g:686:1: ( 'import' )
            // InternalDatatypes.g:687:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalDatatypes.g:696:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:700:1: ( rule__Import__Group__1__Impl )
            // InternalDatatypes.g:701:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalDatatypes.g:707:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:711:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalDatatypes.g:712:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalDatatypes.g:712:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalDatatypes.g:713:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalDatatypes.g:714:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalDatatypes.g:714:3: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ImportedNamespaceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__ImportedFQN__Group__0"
    // InternalDatatypes.g:723:1: rule__ImportedFQN__Group__0 : rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 ;
    public final void rule__ImportedFQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:727:1: ( rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1 )
            // InternalDatatypes.g:728:2: rule__ImportedFQN__Group__0__Impl rule__ImportedFQN__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__ImportedFQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImportedFQN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__0"


    // $ANTLR start "rule__ImportedFQN__Group__0__Impl"
    // InternalDatatypes.g:735:1: rule__ImportedFQN__Group__0__Impl : ( ruleFQN ) ;
    public final void rule__ImportedFQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:739:1: ( ( ruleFQN ) )
            // InternalDatatypes.g:740:1: ( ruleFQN )
            {
            // InternalDatatypes.g:740:1: ( ruleFQN )
            // InternalDatatypes.g:741:2: ruleFQN
            {
             before(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__0__Impl"


    // $ANTLR start "rule__ImportedFQN__Group__1"
    // InternalDatatypes.g:750:1: rule__ImportedFQN__Group__1 : rule__ImportedFQN__Group__1__Impl ;
    public final void rule__ImportedFQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:754:1: ( rule__ImportedFQN__Group__1__Impl )
            // InternalDatatypes.g:755:2: rule__ImportedFQN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImportedFQN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__1"


    // $ANTLR start "rule__ImportedFQN__Group__1__Impl"
    // InternalDatatypes.g:761:1: rule__ImportedFQN__Group__1__Impl : ( ( rule__ImportedFQN__Group_1__0 )? ) ;
    public final void rule__ImportedFQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:765:1: ( ( ( rule__ImportedFQN__Group_1__0 )? ) )
            // InternalDatatypes.g:766:1: ( ( rule__ImportedFQN__Group_1__0 )? )
            {
            // InternalDatatypes.g:766:1: ( ( rule__ImportedFQN__Group_1__0 )? )
            // InternalDatatypes.g:767:2: ( rule__ImportedFQN__Group_1__0 )?
            {
             before(grammarAccess.getImportedFQNAccess().getGroup_1()); 
            // InternalDatatypes.g:768:2: ( rule__ImportedFQN__Group_1__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==27) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalDatatypes.g:768:3: rule__ImportedFQN__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ImportedFQN__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getImportedFQNAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group__1__Impl"


    // $ANTLR start "rule__ImportedFQN__Group_1__0"
    // InternalDatatypes.g:777:1: rule__ImportedFQN__Group_1__0 : rule__ImportedFQN__Group_1__0__Impl rule__ImportedFQN__Group_1__1 ;
    public final void rule__ImportedFQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:781:1: ( rule__ImportedFQN__Group_1__0__Impl rule__ImportedFQN__Group_1__1 )
            // InternalDatatypes.g:782:2: rule__ImportedFQN__Group_1__0__Impl rule__ImportedFQN__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__ImportedFQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImportedFQN__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group_1__0"


    // $ANTLR start "rule__ImportedFQN__Group_1__0__Impl"
    // InternalDatatypes.g:789:1: rule__ImportedFQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__ImportedFQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:793:1: ( ( '.' ) )
            // InternalDatatypes.g:794:1: ( '.' )
            {
            // InternalDatatypes.g:794:1: ( '.' )
            // InternalDatatypes.g:795:2: '.'
            {
             before(grammarAccess.getImportedFQNAccess().getFullStopKeyword_1_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getImportedFQNAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group_1__0__Impl"


    // $ANTLR start "rule__ImportedFQN__Group_1__1"
    // InternalDatatypes.g:804:1: rule__ImportedFQN__Group_1__1 : rule__ImportedFQN__Group_1__1__Impl ;
    public final void rule__ImportedFQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:808:1: ( rule__ImportedFQN__Group_1__1__Impl )
            // InternalDatatypes.g:809:2: rule__ImportedFQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImportedFQN__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group_1__1"


    // $ANTLR start "rule__ImportedFQN__Group_1__1__Impl"
    // InternalDatatypes.g:815:1: rule__ImportedFQN__Group_1__1__Impl : ( '*' ) ;
    public final void rule__ImportedFQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:819:1: ( ( '*' ) )
            // InternalDatatypes.g:820:1: ( '*' )
            {
            // InternalDatatypes.g:820:1: ( '*' )
            // InternalDatatypes.g:821:2: '*'
            {
             before(grammarAccess.getImportedFQNAccess().getAsteriskKeyword_1_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getImportedFQNAccess().getAsteriskKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportedFQN__Group_1__1__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalDatatypes.g:831:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:835:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalDatatypes.g:836:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FQN__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__0"


    // $ANTLR start "rule__FQN__Group__0__Impl"
    // InternalDatatypes.g:843:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:847:1: ( ( RULE_ID ) )
            // InternalDatatypes.g:848:1: ( RULE_ID )
            {
            // InternalDatatypes.g:848:1: ( RULE_ID )
            // InternalDatatypes.g:849:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__0__Impl"


    // $ANTLR start "rule__FQN__Group__1"
    // InternalDatatypes.g:858:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:862:1: ( rule__FQN__Group__1__Impl )
            // InternalDatatypes.g:863:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FQN__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__1"


    // $ANTLR start "rule__FQN__Group__1__Impl"
    // InternalDatatypes.g:869:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:873:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalDatatypes.g:874:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalDatatypes.g:874:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalDatatypes.g:875:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalDatatypes.g:876:2: ( rule__FQN__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==27) ) {
                    int LA7_2 = input.LA(2);

                    if ( (LA7_2==RULE_ID) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // InternalDatatypes.g:876:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group_1__0"
    // InternalDatatypes.g:885:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:889:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalDatatypes.g:890:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FQN__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__0"


    // $ANTLR start "rule__FQN__Group_1__0__Impl"
    // InternalDatatypes.g:897:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:901:1: ( ( '.' ) )
            // InternalDatatypes.g:902:1: ( '.' )
            {
            // InternalDatatypes.g:902:1: ( '.' )
            // InternalDatatypes.g:903:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__0__Impl"


    // $ANTLR start "rule__FQN__Group_1__1"
    // InternalDatatypes.g:912:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:916:1: ( rule__FQN__Group_1__1__Impl )
            // InternalDatatypes.g:917:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FQN__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__1"


    // $ANTLR start "rule__FQN__Group_1__1__Impl"
    // InternalDatatypes.g:923:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:927:1: ( ( RULE_ID ) )
            // InternalDatatypes.g:928:1: ( RULE_ID )
            {
            // InternalDatatypes.g:928:1: ( RULE_ID )
            // InternalDatatypes.g:929:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__1__Impl"


    // $ANTLR start "rule__FTypeCollection__Group__0"
    // InternalDatatypes.g:939:1: rule__FTypeCollection__Group__0 : rule__FTypeCollection__Group__0__Impl rule__FTypeCollection__Group__1 ;
    public final void rule__FTypeCollection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:943:1: ( rule__FTypeCollection__Group__0__Impl rule__FTypeCollection__Group__1 )
            // InternalDatatypes.g:944:2: rule__FTypeCollection__Group__0__Impl rule__FTypeCollection__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__FTypeCollection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FTypeCollection__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__0"


    // $ANTLR start "rule__FTypeCollection__Group__0__Impl"
    // InternalDatatypes.g:951:1: rule__FTypeCollection__Group__0__Impl : ( () ) ;
    public final void rule__FTypeCollection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:955:1: ( ( () ) )
            // InternalDatatypes.g:956:1: ( () )
            {
            // InternalDatatypes.g:956:1: ( () )
            // InternalDatatypes.g:957:2: ()
            {
             before(grammarAccess.getFTypeCollectionAccess().getFTypeCollectionAction_0()); 
            // InternalDatatypes.g:958:2: ()
            // InternalDatatypes.g:958:3: 
            {
            }

             after(grammarAccess.getFTypeCollectionAccess().getFTypeCollectionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__0__Impl"


    // $ANTLR start "rule__FTypeCollection__Group__1"
    // InternalDatatypes.g:966:1: rule__FTypeCollection__Group__1 : rule__FTypeCollection__Group__1__Impl rule__FTypeCollection__Group__2 ;
    public final void rule__FTypeCollection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:970:1: ( rule__FTypeCollection__Group__1__Impl rule__FTypeCollection__Group__2 )
            // InternalDatatypes.g:971:2: rule__FTypeCollection__Group__1__Impl rule__FTypeCollection__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__FTypeCollection__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FTypeCollection__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__1"


    // $ANTLR start "rule__FTypeCollection__Group__1__Impl"
    // InternalDatatypes.g:978:1: rule__FTypeCollection__Group__1__Impl : ( 'typeCollection' ) ;
    public final void rule__FTypeCollection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:982:1: ( ( 'typeCollection' ) )
            // InternalDatatypes.g:983:1: ( 'typeCollection' )
            {
            // InternalDatatypes.g:983:1: ( 'typeCollection' )
            // InternalDatatypes.g:984:2: 'typeCollection'
            {
             before(grammarAccess.getFTypeCollectionAccess().getTypeCollectionKeyword_1()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getFTypeCollectionAccess().getTypeCollectionKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__1__Impl"


    // $ANTLR start "rule__FTypeCollection__Group__2"
    // InternalDatatypes.g:993:1: rule__FTypeCollection__Group__2 : rule__FTypeCollection__Group__2__Impl rule__FTypeCollection__Group__3 ;
    public final void rule__FTypeCollection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:997:1: ( rule__FTypeCollection__Group__2__Impl rule__FTypeCollection__Group__3 )
            // InternalDatatypes.g:998:2: rule__FTypeCollection__Group__2__Impl rule__FTypeCollection__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__FTypeCollection__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FTypeCollection__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__2"


    // $ANTLR start "rule__FTypeCollection__Group__2__Impl"
    // InternalDatatypes.g:1005:1: rule__FTypeCollection__Group__2__Impl : ( ( rule__FTypeCollection__NameAssignment_2 )? ) ;
    public final void rule__FTypeCollection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1009:1: ( ( ( rule__FTypeCollection__NameAssignment_2 )? ) )
            // InternalDatatypes.g:1010:1: ( ( rule__FTypeCollection__NameAssignment_2 )? )
            {
            // InternalDatatypes.g:1010:1: ( ( rule__FTypeCollection__NameAssignment_2 )? )
            // InternalDatatypes.g:1011:2: ( rule__FTypeCollection__NameAssignment_2 )?
            {
             before(grammarAccess.getFTypeCollectionAccess().getNameAssignment_2()); 
            // InternalDatatypes.g:1012:2: ( rule__FTypeCollection__NameAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalDatatypes.g:1012:3: rule__FTypeCollection__NameAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__FTypeCollection__NameAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFTypeCollectionAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__2__Impl"


    // $ANTLR start "rule__FTypeCollection__Group__3"
    // InternalDatatypes.g:1020:1: rule__FTypeCollection__Group__3 : rule__FTypeCollection__Group__3__Impl rule__FTypeCollection__Group__4 ;
    public final void rule__FTypeCollection__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1024:1: ( rule__FTypeCollection__Group__3__Impl rule__FTypeCollection__Group__4 )
            // InternalDatatypes.g:1025:2: rule__FTypeCollection__Group__3__Impl rule__FTypeCollection__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__FTypeCollection__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FTypeCollection__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__3"


    // $ANTLR start "rule__FTypeCollection__Group__3__Impl"
    // InternalDatatypes.g:1032:1: rule__FTypeCollection__Group__3__Impl : ( '{' ) ;
    public final void rule__FTypeCollection__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1036:1: ( ( '{' ) )
            // InternalDatatypes.g:1037:1: ( '{' )
            {
            // InternalDatatypes.g:1037:1: ( '{' )
            // InternalDatatypes.g:1038:2: '{'
            {
             before(grammarAccess.getFTypeCollectionAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getFTypeCollectionAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__3__Impl"


    // $ANTLR start "rule__FTypeCollection__Group__4"
    // InternalDatatypes.g:1047:1: rule__FTypeCollection__Group__4 : rule__FTypeCollection__Group__4__Impl rule__FTypeCollection__Group__5 ;
    public final void rule__FTypeCollection__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1051:1: ( rule__FTypeCollection__Group__4__Impl rule__FTypeCollection__Group__5 )
            // InternalDatatypes.g:1052:2: rule__FTypeCollection__Group__4__Impl rule__FTypeCollection__Group__5
            {
            pushFollow(FOLLOW_13);
            rule__FTypeCollection__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FTypeCollection__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__4"


    // $ANTLR start "rule__FTypeCollection__Group__4__Impl"
    // InternalDatatypes.g:1059:1: rule__FTypeCollection__Group__4__Impl : ( ( rule__FTypeCollection__Group_4__0 )? ) ;
    public final void rule__FTypeCollection__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1063:1: ( ( ( rule__FTypeCollection__Group_4__0 )? ) )
            // InternalDatatypes.g:1064:1: ( ( rule__FTypeCollection__Group_4__0 )? )
            {
            // InternalDatatypes.g:1064:1: ( ( rule__FTypeCollection__Group_4__0 )? )
            // InternalDatatypes.g:1065:2: ( rule__FTypeCollection__Group_4__0 )?
            {
             before(grammarAccess.getFTypeCollectionAccess().getGroup_4()); 
            // InternalDatatypes.g:1066:2: ( rule__FTypeCollection__Group_4__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==32) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalDatatypes.g:1066:3: rule__FTypeCollection__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FTypeCollection__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFTypeCollectionAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__4__Impl"


    // $ANTLR start "rule__FTypeCollection__Group__5"
    // InternalDatatypes.g:1074:1: rule__FTypeCollection__Group__5 : rule__FTypeCollection__Group__5__Impl rule__FTypeCollection__Group__6 ;
    public final void rule__FTypeCollection__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1078:1: ( rule__FTypeCollection__Group__5__Impl rule__FTypeCollection__Group__6 )
            // InternalDatatypes.g:1079:2: rule__FTypeCollection__Group__5__Impl rule__FTypeCollection__Group__6
            {
            pushFollow(FOLLOW_13);
            rule__FTypeCollection__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FTypeCollection__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__5"


    // $ANTLR start "rule__FTypeCollection__Group__5__Impl"
    // InternalDatatypes.g:1086:1: rule__FTypeCollection__Group__5__Impl : ( ( rule__FTypeCollection__TypesAssignment_5 )* ) ;
    public final void rule__FTypeCollection__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1090:1: ( ( ( rule__FTypeCollection__TypesAssignment_5 )* ) )
            // InternalDatatypes.g:1091:1: ( ( rule__FTypeCollection__TypesAssignment_5 )* )
            {
            // InternalDatatypes.g:1091:1: ( ( rule__FTypeCollection__TypesAssignment_5 )* )
            // InternalDatatypes.g:1092:2: ( rule__FTypeCollection__TypesAssignment_5 )*
            {
             before(grammarAccess.getFTypeCollectionAccess().getTypesAssignment_5()); 
            // InternalDatatypes.g:1093:2: ( rule__FTypeCollection__TypesAssignment_5 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==35||LA10_0==37||LA10_0==40) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalDatatypes.g:1093:3: rule__FTypeCollection__TypesAssignment_5
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__FTypeCollection__TypesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getFTypeCollectionAccess().getTypesAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__5__Impl"


    // $ANTLR start "rule__FTypeCollection__Group__6"
    // InternalDatatypes.g:1101:1: rule__FTypeCollection__Group__6 : rule__FTypeCollection__Group__6__Impl ;
    public final void rule__FTypeCollection__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1105:1: ( rule__FTypeCollection__Group__6__Impl )
            // InternalDatatypes.g:1106:2: rule__FTypeCollection__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FTypeCollection__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__6"


    // $ANTLR start "rule__FTypeCollection__Group__6__Impl"
    // InternalDatatypes.g:1112:1: rule__FTypeCollection__Group__6__Impl : ( '}' ) ;
    public final void rule__FTypeCollection__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1116:1: ( ( '}' ) )
            // InternalDatatypes.g:1117:1: ( '}' )
            {
            // InternalDatatypes.g:1117:1: ( '}' )
            // InternalDatatypes.g:1118:2: '}'
            {
             before(grammarAccess.getFTypeCollectionAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getFTypeCollectionAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group__6__Impl"


    // $ANTLR start "rule__FTypeCollection__Group_4__0"
    // InternalDatatypes.g:1128:1: rule__FTypeCollection__Group_4__0 : rule__FTypeCollection__Group_4__0__Impl rule__FTypeCollection__Group_4__1 ;
    public final void rule__FTypeCollection__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1132:1: ( rule__FTypeCollection__Group_4__0__Impl rule__FTypeCollection__Group_4__1 )
            // InternalDatatypes.g:1133:2: rule__FTypeCollection__Group_4__0__Impl rule__FTypeCollection__Group_4__1
            {
            pushFollow(FOLLOW_15);
            rule__FTypeCollection__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FTypeCollection__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group_4__0"


    // $ANTLR start "rule__FTypeCollection__Group_4__0__Impl"
    // InternalDatatypes.g:1140:1: rule__FTypeCollection__Group_4__0__Impl : ( 'version' ) ;
    public final void rule__FTypeCollection__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1144:1: ( ( 'version' ) )
            // InternalDatatypes.g:1145:1: ( 'version' )
            {
            // InternalDatatypes.g:1145:1: ( 'version' )
            // InternalDatatypes.g:1146:2: 'version'
            {
             before(grammarAccess.getFTypeCollectionAccess().getVersionKeyword_4_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getFTypeCollectionAccess().getVersionKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group_4__0__Impl"


    // $ANTLR start "rule__FTypeCollection__Group_4__1"
    // InternalDatatypes.g:1155:1: rule__FTypeCollection__Group_4__1 : rule__FTypeCollection__Group_4__1__Impl ;
    public final void rule__FTypeCollection__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1159:1: ( rule__FTypeCollection__Group_4__1__Impl )
            // InternalDatatypes.g:1160:2: rule__FTypeCollection__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FTypeCollection__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group_4__1"


    // $ANTLR start "rule__FTypeCollection__Group_4__1__Impl"
    // InternalDatatypes.g:1166:1: rule__FTypeCollection__Group_4__1__Impl : ( ( rule__FTypeCollection__VersionAssignment_4_1 ) ) ;
    public final void rule__FTypeCollection__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1170:1: ( ( ( rule__FTypeCollection__VersionAssignment_4_1 ) ) )
            // InternalDatatypes.g:1171:1: ( ( rule__FTypeCollection__VersionAssignment_4_1 ) )
            {
            // InternalDatatypes.g:1171:1: ( ( rule__FTypeCollection__VersionAssignment_4_1 ) )
            // InternalDatatypes.g:1172:2: ( rule__FTypeCollection__VersionAssignment_4_1 )
            {
             before(grammarAccess.getFTypeCollectionAccess().getVersionAssignment_4_1()); 
            // InternalDatatypes.g:1173:2: ( rule__FTypeCollection__VersionAssignment_4_1 )
            // InternalDatatypes.g:1173:3: rule__FTypeCollection__VersionAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__FTypeCollection__VersionAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getFTypeCollectionAccess().getVersionAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__Group_4__1__Impl"


    // $ANTLR start "rule__FVersion__Group__0"
    // InternalDatatypes.g:1182:1: rule__FVersion__Group__0 : rule__FVersion__Group__0__Impl rule__FVersion__Group__1 ;
    public final void rule__FVersion__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1186:1: ( rule__FVersion__Group__0__Impl rule__FVersion__Group__1 )
            // InternalDatatypes.g:1187:2: rule__FVersion__Group__0__Impl rule__FVersion__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__FVersion__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FVersion__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__0"


    // $ANTLR start "rule__FVersion__Group__0__Impl"
    // InternalDatatypes.g:1194:1: rule__FVersion__Group__0__Impl : ( () ) ;
    public final void rule__FVersion__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1198:1: ( ( () ) )
            // InternalDatatypes.g:1199:1: ( () )
            {
            // InternalDatatypes.g:1199:1: ( () )
            // InternalDatatypes.g:1200:2: ()
            {
             before(grammarAccess.getFVersionAccess().getFVersionAction_0()); 
            // InternalDatatypes.g:1201:2: ()
            // InternalDatatypes.g:1201:3: 
            {
            }

             after(grammarAccess.getFVersionAccess().getFVersionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__0__Impl"


    // $ANTLR start "rule__FVersion__Group__1"
    // InternalDatatypes.g:1209:1: rule__FVersion__Group__1 : rule__FVersion__Group__1__Impl rule__FVersion__Group__2 ;
    public final void rule__FVersion__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1213:1: ( rule__FVersion__Group__1__Impl rule__FVersion__Group__2 )
            // InternalDatatypes.g:1214:2: rule__FVersion__Group__1__Impl rule__FVersion__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__FVersion__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FVersion__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__1"


    // $ANTLR start "rule__FVersion__Group__1__Impl"
    // InternalDatatypes.g:1221:1: rule__FVersion__Group__1__Impl : ( '{' ) ;
    public final void rule__FVersion__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1225:1: ( ( '{' ) )
            // InternalDatatypes.g:1226:1: ( '{' )
            {
            // InternalDatatypes.g:1226:1: ( '{' )
            // InternalDatatypes.g:1227:2: '{'
            {
             before(grammarAccess.getFVersionAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getFVersionAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__1__Impl"


    // $ANTLR start "rule__FVersion__Group__2"
    // InternalDatatypes.g:1236:1: rule__FVersion__Group__2 : rule__FVersion__Group__2__Impl rule__FVersion__Group__3 ;
    public final void rule__FVersion__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1240:1: ( rule__FVersion__Group__2__Impl rule__FVersion__Group__3 )
            // InternalDatatypes.g:1241:2: rule__FVersion__Group__2__Impl rule__FVersion__Group__3
            {
            pushFollow(FOLLOW_17);
            rule__FVersion__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FVersion__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__2"


    // $ANTLR start "rule__FVersion__Group__2__Impl"
    // InternalDatatypes.g:1248:1: rule__FVersion__Group__2__Impl : ( 'major' ) ;
    public final void rule__FVersion__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1252:1: ( ( 'major' ) )
            // InternalDatatypes.g:1253:1: ( 'major' )
            {
            // InternalDatatypes.g:1253:1: ( 'major' )
            // InternalDatatypes.g:1254:2: 'major'
            {
             before(grammarAccess.getFVersionAccess().getMajorKeyword_2()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getFVersionAccess().getMajorKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__2__Impl"


    // $ANTLR start "rule__FVersion__Group__3"
    // InternalDatatypes.g:1263:1: rule__FVersion__Group__3 : rule__FVersion__Group__3__Impl rule__FVersion__Group__4 ;
    public final void rule__FVersion__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1267:1: ( rule__FVersion__Group__3__Impl rule__FVersion__Group__4 )
            // InternalDatatypes.g:1268:2: rule__FVersion__Group__3__Impl rule__FVersion__Group__4
            {
            pushFollow(FOLLOW_18);
            rule__FVersion__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FVersion__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__3"


    // $ANTLR start "rule__FVersion__Group__3__Impl"
    // InternalDatatypes.g:1275:1: rule__FVersion__Group__3__Impl : ( ( rule__FVersion__MajorAssignment_3 ) ) ;
    public final void rule__FVersion__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1279:1: ( ( ( rule__FVersion__MajorAssignment_3 ) ) )
            // InternalDatatypes.g:1280:1: ( ( rule__FVersion__MajorAssignment_3 ) )
            {
            // InternalDatatypes.g:1280:1: ( ( rule__FVersion__MajorAssignment_3 ) )
            // InternalDatatypes.g:1281:2: ( rule__FVersion__MajorAssignment_3 )
            {
             before(grammarAccess.getFVersionAccess().getMajorAssignment_3()); 
            // InternalDatatypes.g:1282:2: ( rule__FVersion__MajorAssignment_3 )
            // InternalDatatypes.g:1282:3: rule__FVersion__MajorAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__FVersion__MajorAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getFVersionAccess().getMajorAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__3__Impl"


    // $ANTLR start "rule__FVersion__Group__4"
    // InternalDatatypes.g:1290:1: rule__FVersion__Group__4 : rule__FVersion__Group__4__Impl rule__FVersion__Group__5 ;
    public final void rule__FVersion__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1294:1: ( rule__FVersion__Group__4__Impl rule__FVersion__Group__5 )
            // InternalDatatypes.g:1295:2: rule__FVersion__Group__4__Impl rule__FVersion__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__FVersion__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FVersion__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__4"


    // $ANTLR start "rule__FVersion__Group__4__Impl"
    // InternalDatatypes.g:1302:1: rule__FVersion__Group__4__Impl : ( 'minor' ) ;
    public final void rule__FVersion__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1306:1: ( ( 'minor' ) )
            // InternalDatatypes.g:1307:1: ( 'minor' )
            {
            // InternalDatatypes.g:1307:1: ( 'minor' )
            // InternalDatatypes.g:1308:2: 'minor'
            {
             before(grammarAccess.getFVersionAccess().getMinorKeyword_4()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getFVersionAccess().getMinorKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__4__Impl"


    // $ANTLR start "rule__FVersion__Group__5"
    // InternalDatatypes.g:1317:1: rule__FVersion__Group__5 : rule__FVersion__Group__5__Impl rule__FVersion__Group__6 ;
    public final void rule__FVersion__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1321:1: ( rule__FVersion__Group__5__Impl rule__FVersion__Group__6 )
            // InternalDatatypes.g:1322:2: rule__FVersion__Group__5__Impl rule__FVersion__Group__6
            {
            pushFollow(FOLLOW_19);
            rule__FVersion__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FVersion__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__5"


    // $ANTLR start "rule__FVersion__Group__5__Impl"
    // InternalDatatypes.g:1329:1: rule__FVersion__Group__5__Impl : ( ( rule__FVersion__MinorAssignment_5 ) ) ;
    public final void rule__FVersion__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1333:1: ( ( ( rule__FVersion__MinorAssignment_5 ) ) )
            // InternalDatatypes.g:1334:1: ( ( rule__FVersion__MinorAssignment_5 ) )
            {
            // InternalDatatypes.g:1334:1: ( ( rule__FVersion__MinorAssignment_5 ) )
            // InternalDatatypes.g:1335:2: ( rule__FVersion__MinorAssignment_5 )
            {
             before(grammarAccess.getFVersionAccess().getMinorAssignment_5()); 
            // InternalDatatypes.g:1336:2: ( rule__FVersion__MinorAssignment_5 )
            // InternalDatatypes.g:1336:3: rule__FVersion__MinorAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__FVersion__MinorAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getFVersionAccess().getMinorAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__5__Impl"


    // $ANTLR start "rule__FVersion__Group__6"
    // InternalDatatypes.g:1344:1: rule__FVersion__Group__6 : rule__FVersion__Group__6__Impl ;
    public final void rule__FVersion__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1348:1: ( rule__FVersion__Group__6__Impl )
            // InternalDatatypes.g:1349:2: rule__FVersion__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FVersion__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__6"


    // $ANTLR start "rule__FVersion__Group__6__Impl"
    // InternalDatatypes.g:1355:1: rule__FVersion__Group__6__Impl : ( '}' ) ;
    public final void rule__FVersion__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1359:1: ( ( '}' ) )
            // InternalDatatypes.g:1360:1: ( '}' )
            {
            // InternalDatatypes.g:1360:1: ( '}' )
            // InternalDatatypes.g:1361:2: '}'
            {
             before(grammarAccess.getFVersionAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getFVersionAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__Group__6__Impl"


    // $ANTLR start "rule__FStructType__Group__0"
    // InternalDatatypes.g:1371:1: rule__FStructType__Group__0 : rule__FStructType__Group__0__Impl rule__FStructType__Group__1 ;
    public final void rule__FStructType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1375:1: ( rule__FStructType__Group__0__Impl rule__FStructType__Group__1 )
            // InternalDatatypes.g:1376:2: rule__FStructType__Group__0__Impl rule__FStructType__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__FStructType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FStructType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__0"


    // $ANTLR start "rule__FStructType__Group__0__Impl"
    // InternalDatatypes.g:1383:1: rule__FStructType__Group__0__Impl : ( () ) ;
    public final void rule__FStructType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1387:1: ( ( () ) )
            // InternalDatatypes.g:1388:1: ( () )
            {
            // InternalDatatypes.g:1388:1: ( () )
            // InternalDatatypes.g:1389:2: ()
            {
             before(grammarAccess.getFStructTypeAccess().getFStructTypeAction_0()); 
            // InternalDatatypes.g:1390:2: ()
            // InternalDatatypes.g:1390:3: 
            {
            }

             after(grammarAccess.getFStructTypeAccess().getFStructTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__0__Impl"


    // $ANTLR start "rule__FStructType__Group__1"
    // InternalDatatypes.g:1398:1: rule__FStructType__Group__1 : rule__FStructType__Group__1__Impl rule__FStructType__Group__2 ;
    public final void rule__FStructType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1402:1: ( rule__FStructType__Group__1__Impl rule__FStructType__Group__2 )
            // InternalDatatypes.g:1403:2: rule__FStructType__Group__1__Impl rule__FStructType__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__FStructType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FStructType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__1"


    // $ANTLR start "rule__FStructType__Group__1__Impl"
    // InternalDatatypes.g:1410:1: rule__FStructType__Group__1__Impl : ( 'struct' ) ;
    public final void rule__FStructType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1414:1: ( ( 'struct' ) )
            // InternalDatatypes.g:1415:1: ( 'struct' )
            {
            // InternalDatatypes.g:1415:1: ( 'struct' )
            // InternalDatatypes.g:1416:2: 'struct'
            {
             before(grammarAccess.getFStructTypeAccess().getStructKeyword_1()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getFStructTypeAccess().getStructKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__1__Impl"


    // $ANTLR start "rule__FStructType__Group__2"
    // InternalDatatypes.g:1425:1: rule__FStructType__Group__2 : rule__FStructType__Group__2__Impl rule__FStructType__Group__3 ;
    public final void rule__FStructType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1429:1: ( rule__FStructType__Group__2__Impl rule__FStructType__Group__3 )
            // InternalDatatypes.g:1430:2: rule__FStructType__Group__2__Impl rule__FStructType__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__FStructType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FStructType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__2"


    // $ANTLR start "rule__FStructType__Group__2__Impl"
    // InternalDatatypes.g:1437:1: rule__FStructType__Group__2__Impl : ( ( rule__FStructType__NameAssignment_2 ) ) ;
    public final void rule__FStructType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1441:1: ( ( ( rule__FStructType__NameAssignment_2 ) ) )
            // InternalDatatypes.g:1442:1: ( ( rule__FStructType__NameAssignment_2 ) )
            {
            // InternalDatatypes.g:1442:1: ( ( rule__FStructType__NameAssignment_2 ) )
            // InternalDatatypes.g:1443:2: ( rule__FStructType__NameAssignment_2 )
            {
             before(grammarAccess.getFStructTypeAccess().getNameAssignment_2()); 
            // InternalDatatypes.g:1444:2: ( rule__FStructType__NameAssignment_2 )
            // InternalDatatypes.g:1444:3: rule__FStructType__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FStructType__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFStructTypeAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__2__Impl"


    // $ANTLR start "rule__FStructType__Group__3"
    // InternalDatatypes.g:1452:1: rule__FStructType__Group__3 : rule__FStructType__Group__3__Impl rule__FStructType__Group__4 ;
    public final void rule__FStructType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1456:1: ( rule__FStructType__Group__3__Impl rule__FStructType__Group__4 )
            // InternalDatatypes.g:1457:2: rule__FStructType__Group__3__Impl rule__FStructType__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__FStructType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FStructType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__3"


    // $ANTLR start "rule__FStructType__Group__3__Impl"
    // InternalDatatypes.g:1464:1: rule__FStructType__Group__3__Impl : ( ( rule__FStructType__Group_3__0 )? ) ;
    public final void rule__FStructType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1468:1: ( ( ( rule__FStructType__Group_3__0 )? ) )
            // InternalDatatypes.g:1469:1: ( ( rule__FStructType__Group_3__0 )? )
            {
            // InternalDatatypes.g:1469:1: ( ( rule__FStructType__Group_3__0 )? )
            // InternalDatatypes.g:1470:2: ( rule__FStructType__Group_3__0 )?
            {
             before(grammarAccess.getFStructTypeAccess().getGroup_3()); 
            // InternalDatatypes.g:1471:2: ( rule__FStructType__Group_3__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==36) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalDatatypes.g:1471:3: rule__FStructType__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FStructType__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFStructTypeAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__3__Impl"


    // $ANTLR start "rule__FStructType__Group__4"
    // InternalDatatypes.g:1479:1: rule__FStructType__Group__4 : rule__FStructType__Group__4__Impl rule__FStructType__Group__5 ;
    public final void rule__FStructType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1483:1: ( rule__FStructType__Group__4__Impl rule__FStructType__Group__5 )
            // InternalDatatypes.g:1484:2: rule__FStructType__Group__4__Impl rule__FStructType__Group__5
            {
            pushFollow(FOLLOW_22);
            rule__FStructType__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FStructType__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__4"


    // $ANTLR start "rule__FStructType__Group__4__Impl"
    // InternalDatatypes.g:1491:1: rule__FStructType__Group__4__Impl : ( '{' ) ;
    public final void rule__FStructType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1495:1: ( ( '{' ) )
            // InternalDatatypes.g:1496:1: ( '{' )
            {
            // InternalDatatypes.g:1496:1: ( '{' )
            // InternalDatatypes.g:1497:2: '{'
            {
             before(grammarAccess.getFStructTypeAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getFStructTypeAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__4__Impl"


    // $ANTLR start "rule__FStructType__Group__5"
    // InternalDatatypes.g:1506:1: rule__FStructType__Group__5 : rule__FStructType__Group__5__Impl rule__FStructType__Group__6 ;
    public final void rule__FStructType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1510:1: ( rule__FStructType__Group__5__Impl rule__FStructType__Group__6 )
            // InternalDatatypes.g:1511:2: rule__FStructType__Group__5__Impl rule__FStructType__Group__6
            {
            pushFollow(FOLLOW_22);
            rule__FStructType__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FStructType__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__5"


    // $ANTLR start "rule__FStructType__Group__5__Impl"
    // InternalDatatypes.g:1518:1: rule__FStructType__Group__5__Impl : ( ( rule__FStructType__ElementsAssignment_5 )* ) ;
    public final void rule__FStructType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1522:1: ( ( ( rule__FStructType__ElementsAssignment_5 )* ) )
            // InternalDatatypes.g:1523:1: ( ( rule__FStructType__ElementsAssignment_5 )* )
            {
            // InternalDatatypes.g:1523:1: ( ( rule__FStructType__ElementsAssignment_5 )* )
            // InternalDatatypes.g:1524:2: ( rule__FStructType__ElementsAssignment_5 )*
            {
             before(grammarAccess.getFStructTypeAccess().getElementsAssignment_5()); 
            // InternalDatatypes.g:1525:2: ( rule__FStructType__ElementsAssignment_5 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID||(LA12_0>=11 && LA12_0<=24)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalDatatypes.g:1525:3: rule__FStructType__ElementsAssignment_5
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__FStructType__ElementsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getFStructTypeAccess().getElementsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__5__Impl"


    // $ANTLR start "rule__FStructType__Group__6"
    // InternalDatatypes.g:1533:1: rule__FStructType__Group__6 : rule__FStructType__Group__6__Impl ;
    public final void rule__FStructType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1537:1: ( rule__FStructType__Group__6__Impl )
            // InternalDatatypes.g:1538:2: rule__FStructType__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FStructType__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__6"


    // $ANTLR start "rule__FStructType__Group__6__Impl"
    // InternalDatatypes.g:1544:1: rule__FStructType__Group__6__Impl : ( '}' ) ;
    public final void rule__FStructType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1548:1: ( ( '}' ) )
            // InternalDatatypes.g:1549:1: ( '}' )
            {
            // InternalDatatypes.g:1549:1: ( '}' )
            // InternalDatatypes.g:1550:2: '}'
            {
             before(grammarAccess.getFStructTypeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getFStructTypeAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group__6__Impl"


    // $ANTLR start "rule__FStructType__Group_3__0"
    // InternalDatatypes.g:1560:1: rule__FStructType__Group_3__0 : rule__FStructType__Group_3__0__Impl rule__FStructType__Group_3__1 ;
    public final void rule__FStructType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1564:1: ( rule__FStructType__Group_3__0__Impl rule__FStructType__Group_3__1 )
            // InternalDatatypes.g:1565:2: rule__FStructType__Group_3__0__Impl rule__FStructType__Group_3__1
            {
            pushFollow(FOLLOW_4);
            rule__FStructType__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FStructType__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group_3__0"


    // $ANTLR start "rule__FStructType__Group_3__0__Impl"
    // InternalDatatypes.g:1572:1: rule__FStructType__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__FStructType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1576:1: ( ( 'extends' ) )
            // InternalDatatypes.g:1577:1: ( 'extends' )
            {
            // InternalDatatypes.g:1577:1: ( 'extends' )
            // InternalDatatypes.g:1578:2: 'extends'
            {
             before(grammarAccess.getFStructTypeAccess().getExtendsKeyword_3_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getFStructTypeAccess().getExtendsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group_3__0__Impl"


    // $ANTLR start "rule__FStructType__Group_3__1"
    // InternalDatatypes.g:1587:1: rule__FStructType__Group_3__1 : rule__FStructType__Group_3__1__Impl ;
    public final void rule__FStructType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1591:1: ( rule__FStructType__Group_3__1__Impl )
            // InternalDatatypes.g:1592:2: rule__FStructType__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FStructType__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group_3__1"


    // $ANTLR start "rule__FStructType__Group_3__1__Impl"
    // InternalDatatypes.g:1598:1: rule__FStructType__Group_3__1__Impl : ( ( rule__FStructType__BaseAssignment_3_1 ) ) ;
    public final void rule__FStructType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1602:1: ( ( ( rule__FStructType__BaseAssignment_3_1 ) ) )
            // InternalDatatypes.g:1603:1: ( ( rule__FStructType__BaseAssignment_3_1 ) )
            {
            // InternalDatatypes.g:1603:1: ( ( rule__FStructType__BaseAssignment_3_1 ) )
            // InternalDatatypes.g:1604:2: ( rule__FStructType__BaseAssignment_3_1 )
            {
             before(grammarAccess.getFStructTypeAccess().getBaseAssignment_3_1()); 
            // InternalDatatypes.g:1605:2: ( rule__FStructType__BaseAssignment_3_1 )
            // InternalDatatypes.g:1605:3: rule__FStructType__BaseAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__FStructType__BaseAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getFStructTypeAccess().getBaseAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__Group_3__1__Impl"


    // $ANTLR start "rule__FEnumerationType__Group__0"
    // InternalDatatypes.g:1614:1: rule__FEnumerationType__Group__0 : rule__FEnumerationType__Group__0__Impl rule__FEnumerationType__Group__1 ;
    public final void rule__FEnumerationType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1618:1: ( rule__FEnumerationType__Group__0__Impl rule__FEnumerationType__Group__1 )
            // InternalDatatypes.g:1619:2: rule__FEnumerationType__Group__0__Impl rule__FEnumerationType__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__FEnumerationType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__0"


    // $ANTLR start "rule__FEnumerationType__Group__0__Impl"
    // InternalDatatypes.g:1626:1: rule__FEnumerationType__Group__0__Impl : ( () ) ;
    public final void rule__FEnumerationType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1630:1: ( ( () ) )
            // InternalDatatypes.g:1631:1: ( () )
            {
            // InternalDatatypes.g:1631:1: ( () )
            // InternalDatatypes.g:1632:2: ()
            {
             before(grammarAccess.getFEnumerationTypeAccess().getFEnumerationTypeAction_0()); 
            // InternalDatatypes.g:1633:2: ()
            // InternalDatatypes.g:1633:3: 
            {
            }

             after(grammarAccess.getFEnumerationTypeAccess().getFEnumerationTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__0__Impl"


    // $ANTLR start "rule__FEnumerationType__Group__1"
    // InternalDatatypes.g:1641:1: rule__FEnumerationType__Group__1 : rule__FEnumerationType__Group__1__Impl rule__FEnumerationType__Group__2 ;
    public final void rule__FEnumerationType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1645:1: ( rule__FEnumerationType__Group__1__Impl rule__FEnumerationType__Group__2 )
            // InternalDatatypes.g:1646:2: rule__FEnumerationType__Group__1__Impl rule__FEnumerationType__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__FEnumerationType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__1"


    // $ANTLR start "rule__FEnumerationType__Group__1__Impl"
    // InternalDatatypes.g:1653:1: rule__FEnumerationType__Group__1__Impl : ( 'enumeration' ) ;
    public final void rule__FEnumerationType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1657:1: ( ( 'enumeration' ) )
            // InternalDatatypes.g:1658:1: ( 'enumeration' )
            {
            // InternalDatatypes.g:1658:1: ( 'enumeration' )
            // InternalDatatypes.g:1659:2: 'enumeration'
            {
             before(grammarAccess.getFEnumerationTypeAccess().getEnumerationKeyword_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getFEnumerationTypeAccess().getEnumerationKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__1__Impl"


    // $ANTLR start "rule__FEnumerationType__Group__2"
    // InternalDatatypes.g:1668:1: rule__FEnumerationType__Group__2 : rule__FEnumerationType__Group__2__Impl rule__FEnumerationType__Group__3 ;
    public final void rule__FEnumerationType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1672:1: ( rule__FEnumerationType__Group__2__Impl rule__FEnumerationType__Group__3 )
            // InternalDatatypes.g:1673:2: rule__FEnumerationType__Group__2__Impl rule__FEnumerationType__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__FEnumerationType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__2"


    // $ANTLR start "rule__FEnumerationType__Group__2__Impl"
    // InternalDatatypes.g:1680:1: rule__FEnumerationType__Group__2__Impl : ( ( rule__FEnumerationType__NameAssignment_2 ) ) ;
    public final void rule__FEnumerationType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1684:1: ( ( ( rule__FEnumerationType__NameAssignment_2 ) ) )
            // InternalDatatypes.g:1685:1: ( ( rule__FEnumerationType__NameAssignment_2 ) )
            {
            // InternalDatatypes.g:1685:1: ( ( rule__FEnumerationType__NameAssignment_2 ) )
            // InternalDatatypes.g:1686:2: ( rule__FEnumerationType__NameAssignment_2 )
            {
             before(grammarAccess.getFEnumerationTypeAccess().getNameAssignment_2()); 
            // InternalDatatypes.g:1687:2: ( rule__FEnumerationType__NameAssignment_2 )
            // InternalDatatypes.g:1687:3: rule__FEnumerationType__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerationType__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFEnumerationTypeAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__2__Impl"


    // $ANTLR start "rule__FEnumerationType__Group__3"
    // InternalDatatypes.g:1695:1: rule__FEnumerationType__Group__3 : rule__FEnumerationType__Group__3__Impl rule__FEnumerationType__Group__4 ;
    public final void rule__FEnumerationType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1699:1: ( rule__FEnumerationType__Group__3__Impl rule__FEnumerationType__Group__4 )
            // InternalDatatypes.g:1700:2: rule__FEnumerationType__Group__3__Impl rule__FEnumerationType__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__FEnumerationType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__3"


    // $ANTLR start "rule__FEnumerationType__Group__3__Impl"
    // InternalDatatypes.g:1707:1: rule__FEnumerationType__Group__3__Impl : ( ( rule__FEnumerationType__Group_3__0 )? ) ;
    public final void rule__FEnumerationType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1711:1: ( ( ( rule__FEnumerationType__Group_3__0 )? ) )
            // InternalDatatypes.g:1712:1: ( ( rule__FEnumerationType__Group_3__0 )? )
            {
            // InternalDatatypes.g:1712:1: ( ( rule__FEnumerationType__Group_3__0 )? )
            // InternalDatatypes.g:1713:2: ( rule__FEnumerationType__Group_3__0 )?
            {
             before(grammarAccess.getFEnumerationTypeAccess().getGroup_3()); 
            // InternalDatatypes.g:1714:2: ( rule__FEnumerationType__Group_3__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==36) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalDatatypes.g:1714:3: rule__FEnumerationType__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FEnumerationType__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFEnumerationTypeAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__3__Impl"


    // $ANTLR start "rule__FEnumerationType__Group__4"
    // InternalDatatypes.g:1722:1: rule__FEnumerationType__Group__4 : rule__FEnumerationType__Group__4__Impl rule__FEnumerationType__Group__5 ;
    public final void rule__FEnumerationType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1726:1: ( rule__FEnumerationType__Group__4__Impl rule__FEnumerationType__Group__5 )
            // InternalDatatypes.g:1727:2: rule__FEnumerationType__Group__4__Impl rule__FEnumerationType__Group__5
            {
            pushFollow(FOLLOW_25);
            rule__FEnumerationType__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__4"


    // $ANTLR start "rule__FEnumerationType__Group__4__Impl"
    // InternalDatatypes.g:1734:1: rule__FEnumerationType__Group__4__Impl : ( '{' ) ;
    public final void rule__FEnumerationType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1738:1: ( ( '{' ) )
            // InternalDatatypes.g:1739:1: ( '{' )
            {
            // InternalDatatypes.g:1739:1: ( '{' )
            // InternalDatatypes.g:1740:2: '{'
            {
             before(grammarAccess.getFEnumerationTypeAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getFEnumerationTypeAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__4__Impl"


    // $ANTLR start "rule__FEnumerationType__Group__5"
    // InternalDatatypes.g:1749:1: rule__FEnumerationType__Group__5 : rule__FEnumerationType__Group__5__Impl rule__FEnumerationType__Group__6 ;
    public final void rule__FEnumerationType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1753:1: ( rule__FEnumerationType__Group__5__Impl rule__FEnumerationType__Group__6 )
            // InternalDatatypes.g:1754:2: rule__FEnumerationType__Group__5__Impl rule__FEnumerationType__Group__6
            {
            pushFollow(FOLLOW_25);
            rule__FEnumerationType__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__5"


    // $ANTLR start "rule__FEnumerationType__Group__5__Impl"
    // InternalDatatypes.g:1761:1: rule__FEnumerationType__Group__5__Impl : ( ( rule__FEnumerationType__Group_5__0 )? ) ;
    public final void rule__FEnumerationType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1765:1: ( ( ( rule__FEnumerationType__Group_5__0 )? ) )
            // InternalDatatypes.g:1766:1: ( ( rule__FEnumerationType__Group_5__0 )? )
            {
            // InternalDatatypes.g:1766:1: ( ( rule__FEnumerationType__Group_5__0 )? )
            // InternalDatatypes.g:1767:2: ( rule__FEnumerationType__Group_5__0 )?
            {
             before(grammarAccess.getFEnumerationTypeAccess().getGroup_5()); 
            // InternalDatatypes.g:1768:2: ( rule__FEnumerationType__Group_5__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDatatypes.g:1768:3: rule__FEnumerationType__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FEnumerationType__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFEnumerationTypeAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__5__Impl"


    // $ANTLR start "rule__FEnumerationType__Group__6"
    // InternalDatatypes.g:1776:1: rule__FEnumerationType__Group__6 : rule__FEnumerationType__Group__6__Impl ;
    public final void rule__FEnumerationType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1780:1: ( rule__FEnumerationType__Group__6__Impl )
            // InternalDatatypes.g:1781:2: rule__FEnumerationType__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__6"


    // $ANTLR start "rule__FEnumerationType__Group__6__Impl"
    // InternalDatatypes.g:1787:1: rule__FEnumerationType__Group__6__Impl : ( '}' ) ;
    public final void rule__FEnumerationType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1791:1: ( ( '}' ) )
            // InternalDatatypes.g:1792:1: ( '}' )
            {
            // InternalDatatypes.g:1792:1: ( '}' )
            // InternalDatatypes.g:1793:2: '}'
            {
             before(grammarAccess.getFEnumerationTypeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getFEnumerationTypeAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group__6__Impl"


    // $ANTLR start "rule__FEnumerationType__Group_3__0"
    // InternalDatatypes.g:1803:1: rule__FEnumerationType__Group_3__0 : rule__FEnumerationType__Group_3__0__Impl rule__FEnumerationType__Group_3__1 ;
    public final void rule__FEnumerationType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1807:1: ( rule__FEnumerationType__Group_3__0__Impl rule__FEnumerationType__Group_3__1 )
            // InternalDatatypes.g:1808:2: rule__FEnumerationType__Group_3__0__Impl rule__FEnumerationType__Group_3__1
            {
            pushFollow(FOLLOW_4);
            rule__FEnumerationType__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group_3__0"


    // $ANTLR start "rule__FEnumerationType__Group_3__0__Impl"
    // InternalDatatypes.g:1815:1: rule__FEnumerationType__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__FEnumerationType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1819:1: ( ( 'extends' ) )
            // InternalDatatypes.g:1820:1: ( 'extends' )
            {
            // InternalDatatypes.g:1820:1: ( 'extends' )
            // InternalDatatypes.g:1821:2: 'extends'
            {
             before(grammarAccess.getFEnumerationTypeAccess().getExtendsKeyword_3_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getFEnumerationTypeAccess().getExtendsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group_3__0__Impl"


    // $ANTLR start "rule__FEnumerationType__Group_3__1"
    // InternalDatatypes.g:1830:1: rule__FEnumerationType__Group_3__1 : rule__FEnumerationType__Group_3__1__Impl ;
    public final void rule__FEnumerationType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1834:1: ( rule__FEnumerationType__Group_3__1__Impl )
            // InternalDatatypes.g:1835:2: rule__FEnumerationType__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group_3__1"


    // $ANTLR start "rule__FEnumerationType__Group_3__1__Impl"
    // InternalDatatypes.g:1841:1: rule__FEnumerationType__Group_3__1__Impl : ( ( rule__FEnumerationType__BaseAssignment_3_1 ) ) ;
    public final void rule__FEnumerationType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1845:1: ( ( ( rule__FEnumerationType__BaseAssignment_3_1 ) ) )
            // InternalDatatypes.g:1846:1: ( ( rule__FEnumerationType__BaseAssignment_3_1 ) )
            {
            // InternalDatatypes.g:1846:1: ( ( rule__FEnumerationType__BaseAssignment_3_1 ) )
            // InternalDatatypes.g:1847:2: ( rule__FEnumerationType__BaseAssignment_3_1 )
            {
             before(grammarAccess.getFEnumerationTypeAccess().getBaseAssignment_3_1()); 
            // InternalDatatypes.g:1848:2: ( rule__FEnumerationType__BaseAssignment_3_1 )
            // InternalDatatypes.g:1848:3: rule__FEnumerationType__BaseAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerationType__BaseAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getFEnumerationTypeAccess().getBaseAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group_3__1__Impl"


    // $ANTLR start "rule__FEnumerationType__Group_5__0"
    // InternalDatatypes.g:1857:1: rule__FEnumerationType__Group_5__0 : rule__FEnumerationType__Group_5__0__Impl rule__FEnumerationType__Group_5__1 ;
    public final void rule__FEnumerationType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1861:1: ( rule__FEnumerationType__Group_5__0__Impl rule__FEnumerationType__Group_5__1 )
            // InternalDatatypes.g:1862:2: rule__FEnumerationType__Group_5__0__Impl rule__FEnumerationType__Group_5__1
            {
            pushFollow(FOLLOW_26);
            rule__FEnumerationType__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group_5__0"


    // $ANTLR start "rule__FEnumerationType__Group_5__0__Impl"
    // InternalDatatypes.g:1869:1: rule__FEnumerationType__Group_5__0__Impl : ( ( rule__FEnumerationType__EnumeratorsAssignment_5_0 ) ) ;
    public final void rule__FEnumerationType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1873:1: ( ( ( rule__FEnumerationType__EnumeratorsAssignment_5_0 ) ) )
            // InternalDatatypes.g:1874:1: ( ( rule__FEnumerationType__EnumeratorsAssignment_5_0 ) )
            {
            // InternalDatatypes.g:1874:1: ( ( rule__FEnumerationType__EnumeratorsAssignment_5_0 ) )
            // InternalDatatypes.g:1875:2: ( rule__FEnumerationType__EnumeratorsAssignment_5_0 )
            {
             before(grammarAccess.getFEnumerationTypeAccess().getEnumeratorsAssignment_5_0()); 
            // InternalDatatypes.g:1876:2: ( rule__FEnumerationType__EnumeratorsAssignment_5_0 )
            // InternalDatatypes.g:1876:3: rule__FEnumerationType__EnumeratorsAssignment_5_0
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerationType__EnumeratorsAssignment_5_0();

            state._fsp--;


            }

             after(grammarAccess.getFEnumerationTypeAccess().getEnumeratorsAssignment_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group_5__0__Impl"


    // $ANTLR start "rule__FEnumerationType__Group_5__1"
    // InternalDatatypes.g:1884:1: rule__FEnumerationType__Group_5__1 : rule__FEnumerationType__Group_5__1__Impl ;
    public final void rule__FEnumerationType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1888:1: ( rule__FEnumerationType__Group_5__1__Impl )
            // InternalDatatypes.g:1889:2: rule__FEnumerationType__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group_5__1"


    // $ANTLR start "rule__FEnumerationType__Group_5__1__Impl"
    // InternalDatatypes.g:1895:1: rule__FEnumerationType__Group_5__1__Impl : ( ( rule__FEnumerationType__Group_5_1__0 )* ) ;
    public final void rule__FEnumerationType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1899:1: ( ( ( rule__FEnumerationType__Group_5_1__0 )* ) )
            // InternalDatatypes.g:1900:1: ( ( rule__FEnumerationType__Group_5_1__0 )* )
            {
            // InternalDatatypes.g:1900:1: ( ( rule__FEnumerationType__Group_5_1__0 )* )
            // InternalDatatypes.g:1901:2: ( rule__FEnumerationType__Group_5_1__0 )*
            {
             before(grammarAccess.getFEnumerationTypeAccess().getGroup_5_1()); 
            // InternalDatatypes.g:1902:2: ( rule__FEnumerationType__Group_5_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID||LA15_0==38) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalDatatypes.g:1902:3: rule__FEnumerationType__Group_5_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__FEnumerationType__Group_5_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getFEnumerationTypeAccess().getGroup_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group_5__1__Impl"


    // $ANTLR start "rule__FEnumerationType__Group_5_1__0"
    // InternalDatatypes.g:1911:1: rule__FEnumerationType__Group_5_1__0 : rule__FEnumerationType__Group_5_1__0__Impl rule__FEnumerationType__Group_5_1__1 ;
    public final void rule__FEnumerationType__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1915:1: ( rule__FEnumerationType__Group_5_1__0__Impl rule__FEnumerationType__Group_5_1__1 )
            // InternalDatatypes.g:1916:2: rule__FEnumerationType__Group_5_1__0__Impl rule__FEnumerationType__Group_5_1__1
            {
            pushFollow(FOLLOW_26);
            rule__FEnumerationType__Group_5_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group_5_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group_5_1__0"


    // $ANTLR start "rule__FEnumerationType__Group_5_1__0__Impl"
    // InternalDatatypes.g:1923:1: rule__FEnumerationType__Group_5_1__0__Impl : ( ( ',' )? ) ;
    public final void rule__FEnumerationType__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1927:1: ( ( ( ',' )? ) )
            // InternalDatatypes.g:1928:1: ( ( ',' )? )
            {
            // InternalDatatypes.g:1928:1: ( ( ',' )? )
            // InternalDatatypes.g:1929:2: ( ',' )?
            {
             before(grammarAccess.getFEnumerationTypeAccess().getCommaKeyword_5_1_0()); 
            // InternalDatatypes.g:1930:2: ( ',' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==38) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDatatypes.g:1930:3: ','
                    {
                    match(input,38,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getFEnumerationTypeAccess().getCommaKeyword_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group_5_1__0__Impl"


    // $ANTLR start "rule__FEnumerationType__Group_5_1__1"
    // InternalDatatypes.g:1938:1: rule__FEnumerationType__Group_5_1__1 : rule__FEnumerationType__Group_5_1__1__Impl ;
    public final void rule__FEnumerationType__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1942:1: ( rule__FEnumerationType__Group_5_1__1__Impl )
            // InternalDatatypes.g:1943:2: rule__FEnumerationType__Group_5_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerationType__Group_5_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group_5_1__1"


    // $ANTLR start "rule__FEnumerationType__Group_5_1__1__Impl"
    // InternalDatatypes.g:1949:1: rule__FEnumerationType__Group_5_1__1__Impl : ( ( rule__FEnumerationType__EnumeratorsAssignment_5_1_1 ) ) ;
    public final void rule__FEnumerationType__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1953:1: ( ( ( rule__FEnumerationType__EnumeratorsAssignment_5_1_1 ) ) )
            // InternalDatatypes.g:1954:1: ( ( rule__FEnumerationType__EnumeratorsAssignment_5_1_1 ) )
            {
            // InternalDatatypes.g:1954:1: ( ( rule__FEnumerationType__EnumeratorsAssignment_5_1_1 ) )
            // InternalDatatypes.g:1955:2: ( rule__FEnumerationType__EnumeratorsAssignment_5_1_1 )
            {
             before(grammarAccess.getFEnumerationTypeAccess().getEnumeratorsAssignment_5_1_1()); 
            // InternalDatatypes.g:1956:2: ( rule__FEnumerationType__EnumeratorsAssignment_5_1_1 )
            // InternalDatatypes.g:1956:3: rule__FEnumerationType__EnumeratorsAssignment_5_1_1
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerationType__EnumeratorsAssignment_5_1_1();

            state._fsp--;


            }

             after(grammarAccess.getFEnumerationTypeAccess().getEnumeratorsAssignment_5_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__Group_5_1__1__Impl"


    // $ANTLR start "rule__FEnumerator__Group__0"
    // InternalDatatypes.g:1965:1: rule__FEnumerator__Group__0 : rule__FEnumerator__Group__0__Impl rule__FEnumerator__Group__1 ;
    public final void rule__FEnumerator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1969:1: ( rule__FEnumerator__Group__0__Impl rule__FEnumerator__Group__1 )
            // InternalDatatypes.g:1970:2: rule__FEnumerator__Group__0__Impl rule__FEnumerator__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__FEnumerator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FEnumerator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerator__Group__0"


    // $ANTLR start "rule__FEnumerator__Group__0__Impl"
    // InternalDatatypes.g:1977:1: rule__FEnumerator__Group__0__Impl : ( () ) ;
    public final void rule__FEnumerator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1981:1: ( ( () ) )
            // InternalDatatypes.g:1982:1: ( () )
            {
            // InternalDatatypes.g:1982:1: ( () )
            // InternalDatatypes.g:1983:2: ()
            {
             before(grammarAccess.getFEnumeratorAccess().getFEnumeratorAction_0()); 
            // InternalDatatypes.g:1984:2: ()
            // InternalDatatypes.g:1984:3: 
            {
            }

             after(grammarAccess.getFEnumeratorAccess().getFEnumeratorAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerator__Group__0__Impl"


    // $ANTLR start "rule__FEnumerator__Group__1"
    // InternalDatatypes.g:1992:1: rule__FEnumerator__Group__1 : rule__FEnumerator__Group__1__Impl rule__FEnumerator__Group__2 ;
    public final void rule__FEnumerator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:1996:1: ( rule__FEnumerator__Group__1__Impl rule__FEnumerator__Group__2 )
            // InternalDatatypes.g:1997:2: rule__FEnumerator__Group__1__Impl rule__FEnumerator__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__FEnumerator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FEnumerator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerator__Group__1"


    // $ANTLR start "rule__FEnumerator__Group__1__Impl"
    // InternalDatatypes.g:2004:1: rule__FEnumerator__Group__1__Impl : ( ( rule__FEnumerator__NameAssignment_1 ) ) ;
    public final void rule__FEnumerator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2008:1: ( ( ( rule__FEnumerator__NameAssignment_1 ) ) )
            // InternalDatatypes.g:2009:1: ( ( rule__FEnumerator__NameAssignment_1 ) )
            {
            // InternalDatatypes.g:2009:1: ( ( rule__FEnumerator__NameAssignment_1 ) )
            // InternalDatatypes.g:2010:2: ( rule__FEnumerator__NameAssignment_1 )
            {
             before(grammarAccess.getFEnumeratorAccess().getNameAssignment_1()); 
            // InternalDatatypes.g:2011:2: ( rule__FEnumerator__NameAssignment_1 )
            // InternalDatatypes.g:2011:3: rule__FEnumerator__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerator__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFEnumeratorAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerator__Group__1__Impl"


    // $ANTLR start "rule__FEnumerator__Group__2"
    // InternalDatatypes.g:2019:1: rule__FEnumerator__Group__2 : rule__FEnumerator__Group__2__Impl ;
    public final void rule__FEnumerator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2023:1: ( rule__FEnumerator__Group__2__Impl )
            // InternalDatatypes.g:2024:2: rule__FEnumerator__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerator__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerator__Group__2"


    // $ANTLR start "rule__FEnumerator__Group__2__Impl"
    // InternalDatatypes.g:2030:1: rule__FEnumerator__Group__2__Impl : ( ( rule__FEnumerator__Group_2__0 )? ) ;
    public final void rule__FEnumerator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2034:1: ( ( ( rule__FEnumerator__Group_2__0 )? ) )
            // InternalDatatypes.g:2035:1: ( ( rule__FEnumerator__Group_2__0 )? )
            {
            // InternalDatatypes.g:2035:1: ( ( rule__FEnumerator__Group_2__0 )? )
            // InternalDatatypes.g:2036:2: ( rule__FEnumerator__Group_2__0 )?
            {
             before(grammarAccess.getFEnumeratorAccess().getGroup_2()); 
            // InternalDatatypes.g:2037:2: ( rule__FEnumerator__Group_2__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDatatypes.g:2037:3: rule__FEnumerator__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FEnumerator__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFEnumeratorAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerator__Group__2__Impl"


    // $ANTLR start "rule__FEnumerator__Group_2__0"
    // InternalDatatypes.g:2046:1: rule__FEnumerator__Group_2__0 : rule__FEnumerator__Group_2__0__Impl rule__FEnumerator__Group_2__1 ;
    public final void rule__FEnumerator__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2050:1: ( rule__FEnumerator__Group_2__0__Impl rule__FEnumerator__Group_2__1 )
            // InternalDatatypes.g:2051:2: rule__FEnumerator__Group_2__0__Impl rule__FEnumerator__Group_2__1
            {
            pushFollow(FOLLOW_29);
            rule__FEnumerator__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FEnumerator__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerator__Group_2__0"


    // $ANTLR start "rule__FEnumerator__Group_2__0__Impl"
    // InternalDatatypes.g:2058:1: rule__FEnumerator__Group_2__0__Impl : ( '=' ) ;
    public final void rule__FEnumerator__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2062:1: ( ( '=' ) )
            // InternalDatatypes.g:2063:1: ( '=' )
            {
            // InternalDatatypes.g:2063:1: ( '=' )
            // InternalDatatypes.g:2064:2: '='
            {
             before(grammarAccess.getFEnumeratorAccess().getEqualsSignKeyword_2_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getFEnumeratorAccess().getEqualsSignKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerator__Group_2__0__Impl"


    // $ANTLR start "rule__FEnumerator__Group_2__1"
    // InternalDatatypes.g:2073:1: rule__FEnumerator__Group_2__1 : rule__FEnumerator__Group_2__1__Impl ;
    public final void rule__FEnumerator__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2077:1: ( rule__FEnumerator__Group_2__1__Impl )
            // InternalDatatypes.g:2078:2: rule__FEnumerator__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerator__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerator__Group_2__1"


    // $ANTLR start "rule__FEnumerator__Group_2__1__Impl"
    // InternalDatatypes.g:2084:1: rule__FEnumerator__Group_2__1__Impl : ( ( rule__FEnumerator__ValueAssignment_2_1 ) ) ;
    public final void rule__FEnumerator__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2088:1: ( ( ( rule__FEnumerator__ValueAssignment_2_1 ) ) )
            // InternalDatatypes.g:2089:1: ( ( rule__FEnumerator__ValueAssignment_2_1 ) )
            {
            // InternalDatatypes.g:2089:1: ( ( rule__FEnumerator__ValueAssignment_2_1 ) )
            // InternalDatatypes.g:2090:2: ( rule__FEnumerator__ValueAssignment_2_1 )
            {
             before(grammarAccess.getFEnumeratorAccess().getValueAssignment_2_1()); 
            // InternalDatatypes.g:2091:2: ( rule__FEnumerator__ValueAssignment_2_1 )
            // InternalDatatypes.g:2091:3: rule__FEnumerator__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__FEnumerator__ValueAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getFEnumeratorAccess().getValueAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerator__Group_2__1__Impl"


    // $ANTLR start "rule__FMapType__Group__0"
    // InternalDatatypes.g:2100:1: rule__FMapType__Group__0 : rule__FMapType__Group__0__Impl rule__FMapType__Group__1 ;
    public final void rule__FMapType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2104:1: ( rule__FMapType__Group__0__Impl rule__FMapType__Group__1 )
            // InternalDatatypes.g:2105:2: rule__FMapType__Group__0__Impl rule__FMapType__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__FMapType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FMapType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__0"


    // $ANTLR start "rule__FMapType__Group__0__Impl"
    // InternalDatatypes.g:2112:1: rule__FMapType__Group__0__Impl : ( () ) ;
    public final void rule__FMapType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2116:1: ( ( () ) )
            // InternalDatatypes.g:2117:1: ( () )
            {
            // InternalDatatypes.g:2117:1: ( () )
            // InternalDatatypes.g:2118:2: ()
            {
             before(grammarAccess.getFMapTypeAccess().getFMapTypeAction_0()); 
            // InternalDatatypes.g:2119:2: ()
            // InternalDatatypes.g:2119:3: 
            {
            }

             after(grammarAccess.getFMapTypeAccess().getFMapTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__0__Impl"


    // $ANTLR start "rule__FMapType__Group__1"
    // InternalDatatypes.g:2127:1: rule__FMapType__Group__1 : rule__FMapType__Group__1__Impl rule__FMapType__Group__2 ;
    public final void rule__FMapType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2131:1: ( rule__FMapType__Group__1__Impl rule__FMapType__Group__2 )
            // InternalDatatypes.g:2132:2: rule__FMapType__Group__1__Impl rule__FMapType__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__FMapType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FMapType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__1"


    // $ANTLR start "rule__FMapType__Group__1__Impl"
    // InternalDatatypes.g:2139:1: rule__FMapType__Group__1__Impl : ( 'map' ) ;
    public final void rule__FMapType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2143:1: ( ( 'map' ) )
            // InternalDatatypes.g:2144:1: ( 'map' )
            {
            // InternalDatatypes.g:2144:1: ( 'map' )
            // InternalDatatypes.g:2145:2: 'map'
            {
             before(grammarAccess.getFMapTypeAccess().getMapKeyword_1()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getFMapTypeAccess().getMapKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__1__Impl"


    // $ANTLR start "rule__FMapType__Group__2"
    // InternalDatatypes.g:2154:1: rule__FMapType__Group__2 : rule__FMapType__Group__2__Impl rule__FMapType__Group__3 ;
    public final void rule__FMapType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2158:1: ( rule__FMapType__Group__2__Impl rule__FMapType__Group__3 )
            // InternalDatatypes.g:2159:2: rule__FMapType__Group__2__Impl rule__FMapType__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__FMapType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FMapType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__2"


    // $ANTLR start "rule__FMapType__Group__2__Impl"
    // InternalDatatypes.g:2166:1: rule__FMapType__Group__2__Impl : ( ( rule__FMapType__NameAssignment_2 ) ) ;
    public final void rule__FMapType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2170:1: ( ( ( rule__FMapType__NameAssignment_2 ) ) )
            // InternalDatatypes.g:2171:1: ( ( rule__FMapType__NameAssignment_2 ) )
            {
            // InternalDatatypes.g:2171:1: ( ( rule__FMapType__NameAssignment_2 ) )
            // InternalDatatypes.g:2172:2: ( rule__FMapType__NameAssignment_2 )
            {
             before(grammarAccess.getFMapTypeAccess().getNameAssignment_2()); 
            // InternalDatatypes.g:2173:2: ( rule__FMapType__NameAssignment_2 )
            // InternalDatatypes.g:2173:3: rule__FMapType__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FMapType__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFMapTypeAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__2__Impl"


    // $ANTLR start "rule__FMapType__Group__3"
    // InternalDatatypes.g:2181:1: rule__FMapType__Group__3 : rule__FMapType__Group__3__Impl rule__FMapType__Group__4 ;
    public final void rule__FMapType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2185:1: ( rule__FMapType__Group__3__Impl rule__FMapType__Group__4 )
            // InternalDatatypes.g:2186:2: rule__FMapType__Group__3__Impl rule__FMapType__Group__4
            {
            pushFollow(FOLLOW_31);
            rule__FMapType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FMapType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__3"


    // $ANTLR start "rule__FMapType__Group__3__Impl"
    // InternalDatatypes.g:2193:1: rule__FMapType__Group__3__Impl : ( '{' ) ;
    public final void rule__FMapType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2197:1: ( ( '{' ) )
            // InternalDatatypes.g:2198:1: ( '{' )
            {
            // InternalDatatypes.g:2198:1: ( '{' )
            // InternalDatatypes.g:2199:2: '{'
            {
             before(grammarAccess.getFMapTypeAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getFMapTypeAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__3__Impl"


    // $ANTLR start "rule__FMapType__Group__4"
    // InternalDatatypes.g:2208:1: rule__FMapType__Group__4 : rule__FMapType__Group__4__Impl rule__FMapType__Group__5 ;
    public final void rule__FMapType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2212:1: ( rule__FMapType__Group__4__Impl rule__FMapType__Group__5 )
            // InternalDatatypes.g:2213:2: rule__FMapType__Group__4__Impl rule__FMapType__Group__5
            {
            pushFollow(FOLLOW_32);
            rule__FMapType__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FMapType__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__4"


    // $ANTLR start "rule__FMapType__Group__4__Impl"
    // InternalDatatypes.g:2220:1: rule__FMapType__Group__4__Impl : ( ( rule__FMapType__KeyTypeAssignment_4 ) ) ;
    public final void rule__FMapType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2224:1: ( ( ( rule__FMapType__KeyTypeAssignment_4 ) ) )
            // InternalDatatypes.g:2225:1: ( ( rule__FMapType__KeyTypeAssignment_4 ) )
            {
            // InternalDatatypes.g:2225:1: ( ( rule__FMapType__KeyTypeAssignment_4 ) )
            // InternalDatatypes.g:2226:2: ( rule__FMapType__KeyTypeAssignment_4 )
            {
             before(grammarAccess.getFMapTypeAccess().getKeyTypeAssignment_4()); 
            // InternalDatatypes.g:2227:2: ( rule__FMapType__KeyTypeAssignment_4 )
            // InternalDatatypes.g:2227:3: rule__FMapType__KeyTypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__FMapType__KeyTypeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getFMapTypeAccess().getKeyTypeAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__4__Impl"


    // $ANTLR start "rule__FMapType__Group__5"
    // InternalDatatypes.g:2235:1: rule__FMapType__Group__5 : rule__FMapType__Group__5__Impl rule__FMapType__Group__6 ;
    public final void rule__FMapType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2239:1: ( rule__FMapType__Group__5__Impl rule__FMapType__Group__6 )
            // InternalDatatypes.g:2240:2: rule__FMapType__Group__5__Impl rule__FMapType__Group__6
            {
            pushFollow(FOLLOW_31);
            rule__FMapType__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FMapType__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__5"


    // $ANTLR start "rule__FMapType__Group__5__Impl"
    // InternalDatatypes.g:2247:1: rule__FMapType__Group__5__Impl : ( 'to' ) ;
    public final void rule__FMapType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2251:1: ( ( 'to' ) )
            // InternalDatatypes.g:2252:1: ( 'to' )
            {
            // InternalDatatypes.g:2252:1: ( 'to' )
            // InternalDatatypes.g:2253:2: 'to'
            {
             before(grammarAccess.getFMapTypeAccess().getToKeyword_5()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getFMapTypeAccess().getToKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__5__Impl"


    // $ANTLR start "rule__FMapType__Group__6"
    // InternalDatatypes.g:2262:1: rule__FMapType__Group__6 : rule__FMapType__Group__6__Impl rule__FMapType__Group__7 ;
    public final void rule__FMapType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2266:1: ( rule__FMapType__Group__6__Impl rule__FMapType__Group__7 )
            // InternalDatatypes.g:2267:2: rule__FMapType__Group__6__Impl rule__FMapType__Group__7
            {
            pushFollow(FOLLOW_19);
            rule__FMapType__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FMapType__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__6"


    // $ANTLR start "rule__FMapType__Group__6__Impl"
    // InternalDatatypes.g:2274:1: rule__FMapType__Group__6__Impl : ( ( rule__FMapType__ValueTypeAssignment_6 ) ) ;
    public final void rule__FMapType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2278:1: ( ( ( rule__FMapType__ValueTypeAssignment_6 ) ) )
            // InternalDatatypes.g:2279:1: ( ( rule__FMapType__ValueTypeAssignment_6 ) )
            {
            // InternalDatatypes.g:2279:1: ( ( rule__FMapType__ValueTypeAssignment_6 ) )
            // InternalDatatypes.g:2280:2: ( rule__FMapType__ValueTypeAssignment_6 )
            {
             before(grammarAccess.getFMapTypeAccess().getValueTypeAssignment_6()); 
            // InternalDatatypes.g:2281:2: ( rule__FMapType__ValueTypeAssignment_6 )
            // InternalDatatypes.g:2281:3: rule__FMapType__ValueTypeAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__FMapType__ValueTypeAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getFMapTypeAccess().getValueTypeAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__6__Impl"


    // $ANTLR start "rule__FMapType__Group__7"
    // InternalDatatypes.g:2289:1: rule__FMapType__Group__7 : rule__FMapType__Group__7__Impl ;
    public final void rule__FMapType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2293:1: ( rule__FMapType__Group__7__Impl )
            // InternalDatatypes.g:2294:2: rule__FMapType__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FMapType__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__7"


    // $ANTLR start "rule__FMapType__Group__7__Impl"
    // InternalDatatypes.g:2300:1: rule__FMapType__Group__7__Impl : ( '}' ) ;
    public final void rule__FMapType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2304:1: ( ( '}' ) )
            // InternalDatatypes.g:2305:1: ( '}' )
            {
            // InternalDatatypes.g:2305:1: ( '}' )
            // InternalDatatypes.g:2306:2: '}'
            {
             before(grammarAccess.getFMapTypeAccess().getRightCurlyBracketKeyword_7()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getFMapTypeAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__Group__7__Impl"


    // $ANTLR start "rule__FField__Group__0"
    // InternalDatatypes.g:2316:1: rule__FField__Group__0 : rule__FField__Group__0__Impl rule__FField__Group__1 ;
    public final void rule__FField__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2320:1: ( rule__FField__Group__0__Impl rule__FField__Group__1 )
            // InternalDatatypes.g:2321:2: rule__FField__Group__0__Impl rule__FField__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__FField__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FField__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FField__Group__0"


    // $ANTLR start "rule__FField__Group__0__Impl"
    // InternalDatatypes.g:2328:1: rule__FField__Group__0__Impl : ( ( rule__FField__TypeAssignment_0 ) ) ;
    public final void rule__FField__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2332:1: ( ( ( rule__FField__TypeAssignment_0 ) ) )
            // InternalDatatypes.g:2333:1: ( ( rule__FField__TypeAssignment_0 ) )
            {
            // InternalDatatypes.g:2333:1: ( ( rule__FField__TypeAssignment_0 ) )
            // InternalDatatypes.g:2334:2: ( rule__FField__TypeAssignment_0 )
            {
             before(grammarAccess.getFFieldAccess().getTypeAssignment_0()); 
            // InternalDatatypes.g:2335:2: ( rule__FField__TypeAssignment_0 )
            // InternalDatatypes.g:2335:3: rule__FField__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__FField__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFFieldAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FField__Group__0__Impl"


    // $ANTLR start "rule__FField__Group__1"
    // InternalDatatypes.g:2343:1: rule__FField__Group__1 : rule__FField__Group__1__Impl rule__FField__Group__2 ;
    public final void rule__FField__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2347:1: ( rule__FField__Group__1__Impl rule__FField__Group__2 )
            // InternalDatatypes.g:2348:2: rule__FField__Group__1__Impl rule__FField__Group__2
            {
            pushFollow(FOLLOW_33);
            rule__FField__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FField__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FField__Group__1"


    // $ANTLR start "rule__FField__Group__1__Impl"
    // InternalDatatypes.g:2355:1: rule__FField__Group__1__Impl : ( ( rule__FField__Group_1__0 )? ) ;
    public final void rule__FField__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2359:1: ( ( ( rule__FField__Group_1__0 )? ) )
            // InternalDatatypes.g:2360:1: ( ( rule__FField__Group_1__0 )? )
            {
            // InternalDatatypes.g:2360:1: ( ( rule__FField__Group_1__0 )? )
            // InternalDatatypes.g:2361:2: ( rule__FField__Group_1__0 )?
            {
             before(grammarAccess.getFFieldAccess().getGroup_1()); 
            // InternalDatatypes.g:2362:2: ( rule__FField__Group_1__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==43) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalDatatypes.g:2362:3: rule__FField__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FField__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFFieldAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FField__Group__1__Impl"


    // $ANTLR start "rule__FField__Group__2"
    // InternalDatatypes.g:2370:1: rule__FField__Group__2 : rule__FField__Group__2__Impl ;
    public final void rule__FField__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2374:1: ( rule__FField__Group__2__Impl )
            // InternalDatatypes.g:2375:2: rule__FField__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FField__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FField__Group__2"


    // $ANTLR start "rule__FField__Group__2__Impl"
    // InternalDatatypes.g:2381:1: rule__FField__Group__2__Impl : ( ( rule__FField__NameAssignment_2 ) ) ;
    public final void rule__FField__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2385:1: ( ( ( rule__FField__NameAssignment_2 ) ) )
            // InternalDatatypes.g:2386:1: ( ( rule__FField__NameAssignment_2 ) )
            {
            // InternalDatatypes.g:2386:1: ( ( rule__FField__NameAssignment_2 ) )
            // InternalDatatypes.g:2387:2: ( rule__FField__NameAssignment_2 )
            {
             before(grammarAccess.getFFieldAccess().getNameAssignment_2()); 
            // InternalDatatypes.g:2388:2: ( rule__FField__NameAssignment_2 )
            // InternalDatatypes.g:2388:3: rule__FField__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FField__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFFieldAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FField__Group__2__Impl"


    // $ANTLR start "rule__FField__Group_1__0"
    // InternalDatatypes.g:2397:1: rule__FField__Group_1__0 : rule__FField__Group_1__0__Impl rule__FField__Group_1__1 ;
    public final void rule__FField__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2401:1: ( rule__FField__Group_1__0__Impl rule__FField__Group_1__1 )
            // InternalDatatypes.g:2402:2: rule__FField__Group_1__0__Impl rule__FField__Group_1__1
            {
            pushFollow(FOLLOW_34);
            rule__FField__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FField__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FField__Group_1__0"


    // $ANTLR start "rule__FField__Group_1__0__Impl"
    // InternalDatatypes.g:2409:1: rule__FField__Group_1__0__Impl : ( ( rule__FField__ListAssignment_1_0 ) ) ;
    public final void rule__FField__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2413:1: ( ( ( rule__FField__ListAssignment_1_0 ) ) )
            // InternalDatatypes.g:2414:1: ( ( rule__FField__ListAssignment_1_0 ) )
            {
            // InternalDatatypes.g:2414:1: ( ( rule__FField__ListAssignment_1_0 ) )
            // InternalDatatypes.g:2415:2: ( rule__FField__ListAssignment_1_0 )
            {
             before(grammarAccess.getFFieldAccess().getListAssignment_1_0()); 
            // InternalDatatypes.g:2416:2: ( rule__FField__ListAssignment_1_0 )
            // InternalDatatypes.g:2416:3: rule__FField__ListAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__FField__ListAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getFFieldAccess().getListAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FField__Group_1__0__Impl"


    // $ANTLR start "rule__FField__Group_1__1"
    // InternalDatatypes.g:2424:1: rule__FField__Group_1__1 : rule__FField__Group_1__1__Impl ;
    public final void rule__FField__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2428:1: ( rule__FField__Group_1__1__Impl )
            // InternalDatatypes.g:2429:2: rule__FField__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FField__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FField__Group_1__1"


    // $ANTLR start "rule__FField__Group_1__1__Impl"
    // InternalDatatypes.g:2435:1: rule__FField__Group_1__1__Impl : ( ']' ) ;
    public final void rule__FField__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2439:1: ( ( ']' ) )
            // InternalDatatypes.g:2440:1: ( ']' )
            {
            // InternalDatatypes.g:2440:1: ( ']' )
            // InternalDatatypes.g:2441:2: ']'
            {
             before(grammarAccess.getFFieldAccess().getRightSquareBracketKeyword_1_1()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getFFieldAccess().getRightSquareBracketKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FField__Group_1__1__Impl"


    // $ANTLR start "rule__Model__NameAssignment_2"
    // InternalDatatypes.g:2451:1: rule__Model__NameAssignment_2 : ( ruleFQN ) ;
    public final void rule__Model__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2455:1: ( ( ruleFQN ) )
            // InternalDatatypes.g:2456:2: ( ruleFQN )
            {
            // InternalDatatypes.g:2456:2: ( ruleFQN )
            // InternalDatatypes.g:2457:3: ruleFQN
            {
             before(grammarAccess.getModelAccess().getNameFQNParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getModelAccess().getNameFQNParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__NameAssignment_2"


    // $ANTLR start "rule__Model__ImportsAssignment_3"
    // InternalDatatypes.g:2466:1: rule__Model__ImportsAssignment_3 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2470:1: ( ( ruleImport ) )
            // InternalDatatypes.g:2471:2: ( ruleImport )
            {
            // InternalDatatypes.g:2471:2: ( ruleImport )
            // InternalDatatypes.g:2472:3: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getModelAccess().getImportsImportParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ImportsAssignment_3"


    // $ANTLR start "rule__Model__TypeCollectionsAssignment_4"
    // InternalDatatypes.g:2481:1: rule__Model__TypeCollectionsAssignment_4 : ( ruleFTypeCollection ) ;
    public final void rule__Model__TypeCollectionsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2485:1: ( ( ruleFTypeCollection ) )
            // InternalDatatypes.g:2486:2: ( ruleFTypeCollection )
            {
            // InternalDatatypes.g:2486:2: ( ruleFTypeCollection )
            // InternalDatatypes.g:2487:3: ruleFTypeCollection
            {
             before(grammarAccess.getModelAccess().getTypeCollectionsFTypeCollectionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleFTypeCollection();

            state._fsp--;

             after(grammarAccess.getModelAccess().getTypeCollectionsFTypeCollectionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__TypeCollectionsAssignment_4"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // InternalDatatypes.g:2496:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleImportedFQN ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2500:1: ( ( ruleImportedFQN ) )
            // InternalDatatypes.g:2501:2: ( ruleImportedFQN )
            {
            // InternalDatatypes.g:2501:2: ( ruleImportedFQN )
            // InternalDatatypes.g:2502:3: ruleImportedFQN
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleImportedFQN();

            state._fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1"


    // $ANTLR start "rule__FTypeCollection__NameAssignment_2"
    // InternalDatatypes.g:2511:1: rule__FTypeCollection__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FTypeCollection__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2515:1: ( ( RULE_ID ) )
            // InternalDatatypes.g:2516:2: ( RULE_ID )
            {
            // InternalDatatypes.g:2516:2: ( RULE_ID )
            // InternalDatatypes.g:2517:3: RULE_ID
            {
             before(grammarAccess.getFTypeCollectionAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFTypeCollectionAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__NameAssignment_2"


    // $ANTLR start "rule__FTypeCollection__VersionAssignment_4_1"
    // InternalDatatypes.g:2526:1: rule__FTypeCollection__VersionAssignment_4_1 : ( ruleFVersion ) ;
    public final void rule__FTypeCollection__VersionAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2530:1: ( ( ruleFVersion ) )
            // InternalDatatypes.g:2531:2: ( ruleFVersion )
            {
            // InternalDatatypes.g:2531:2: ( ruleFVersion )
            // InternalDatatypes.g:2532:3: ruleFVersion
            {
             before(grammarAccess.getFTypeCollectionAccess().getVersionFVersionParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFVersion();

            state._fsp--;

             after(grammarAccess.getFTypeCollectionAccess().getVersionFVersionParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__VersionAssignment_4_1"


    // $ANTLR start "rule__FTypeCollection__TypesAssignment_5"
    // InternalDatatypes.g:2541:1: rule__FTypeCollection__TypesAssignment_5 : ( ruleFType ) ;
    public final void rule__FTypeCollection__TypesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2545:1: ( ( ruleFType ) )
            // InternalDatatypes.g:2546:2: ( ruleFType )
            {
            // InternalDatatypes.g:2546:2: ( ruleFType )
            // InternalDatatypes.g:2547:3: ruleFType
            {
             before(grammarAccess.getFTypeCollectionAccess().getTypesFTypeParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleFType();

            state._fsp--;

             after(grammarAccess.getFTypeCollectionAccess().getTypesFTypeParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeCollection__TypesAssignment_5"


    // $ANTLR start "rule__FVersion__MajorAssignment_3"
    // InternalDatatypes.g:2556:1: rule__FVersion__MajorAssignment_3 : ( RULE_INT ) ;
    public final void rule__FVersion__MajorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2560:1: ( ( RULE_INT ) )
            // InternalDatatypes.g:2561:2: ( RULE_INT )
            {
            // InternalDatatypes.g:2561:2: ( RULE_INT )
            // InternalDatatypes.g:2562:3: RULE_INT
            {
             before(grammarAccess.getFVersionAccess().getMajorINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getFVersionAccess().getMajorINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__MajorAssignment_3"


    // $ANTLR start "rule__FVersion__MinorAssignment_5"
    // InternalDatatypes.g:2571:1: rule__FVersion__MinorAssignment_5 : ( RULE_INT ) ;
    public final void rule__FVersion__MinorAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2575:1: ( ( RULE_INT ) )
            // InternalDatatypes.g:2576:2: ( RULE_INT )
            {
            // InternalDatatypes.g:2576:2: ( RULE_INT )
            // InternalDatatypes.g:2577:3: RULE_INT
            {
             before(grammarAccess.getFVersionAccess().getMinorINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getFVersionAccess().getMinorINTTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FVersion__MinorAssignment_5"


    // $ANTLR start "rule__FTypeRef__PredefinedAssignment_0"
    // InternalDatatypes.g:2586:1: rule__FTypeRef__PredefinedAssignment_0 : ( ruleFBasicTypeId ) ;
    public final void rule__FTypeRef__PredefinedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2590:1: ( ( ruleFBasicTypeId ) )
            // InternalDatatypes.g:2591:2: ( ruleFBasicTypeId )
            {
            // InternalDatatypes.g:2591:2: ( ruleFBasicTypeId )
            // InternalDatatypes.g:2592:3: ruleFBasicTypeId
            {
             before(grammarAccess.getFTypeRefAccess().getPredefinedFBasicTypeIdEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleFBasicTypeId();

            state._fsp--;

             after(grammarAccess.getFTypeRefAccess().getPredefinedFBasicTypeIdEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeRef__PredefinedAssignment_0"


    // $ANTLR start "rule__FTypeRef__DerivedAssignment_1"
    // InternalDatatypes.g:2601:1: rule__FTypeRef__DerivedAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__FTypeRef__DerivedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2605:1: ( ( ( ruleFQN ) ) )
            // InternalDatatypes.g:2606:2: ( ( ruleFQN ) )
            {
            // InternalDatatypes.g:2606:2: ( ( ruleFQN ) )
            // InternalDatatypes.g:2607:3: ( ruleFQN )
            {
             before(grammarAccess.getFTypeRefAccess().getDerivedFTypeCrossReference_1_0()); 
            // InternalDatatypes.g:2608:3: ( ruleFQN )
            // InternalDatatypes.g:2609:4: ruleFQN
            {
             before(grammarAccess.getFTypeRefAccess().getDerivedFTypeFQNParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFTypeRefAccess().getDerivedFTypeFQNParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getFTypeRefAccess().getDerivedFTypeCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FTypeRef__DerivedAssignment_1"


    // $ANTLR start "rule__FStructType__NameAssignment_2"
    // InternalDatatypes.g:2620:1: rule__FStructType__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FStructType__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2624:1: ( ( RULE_ID ) )
            // InternalDatatypes.g:2625:2: ( RULE_ID )
            {
            // InternalDatatypes.g:2625:2: ( RULE_ID )
            // InternalDatatypes.g:2626:3: RULE_ID
            {
             before(grammarAccess.getFStructTypeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFStructTypeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__NameAssignment_2"


    // $ANTLR start "rule__FStructType__BaseAssignment_3_1"
    // InternalDatatypes.g:2635:1: rule__FStructType__BaseAssignment_3_1 : ( ( ruleFQN ) ) ;
    public final void rule__FStructType__BaseAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2639:1: ( ( ( ruleFQN ) ) )
            // InternalDatatypes.g:2640:2: ( ( ruleFQN ) )
            {
            // InternalDatatypes.g:2640:2: ( ( ruleFQN ) )
            // InternalDatatypes.g:2641:3: ( ruleFQN )
            {
             before(grammarAccess.getFStructTypeAccess().getBaseFStructTypeCrossReference_3_1_0()); 
            // InternalDatatypes.g:2642:3: ( ruleFQN )
            // InternalDatatypes.g:2643:4: ruleFQN
            {
             before(grammarAccess.getFStructTypeAccess().getBaseFStructTypeFQNParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFStructTypeAccess().getBaseFStructTypeFQNParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getFStructTypeAccess().getBaseFStructTypeCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__BaseAssignment_3_1"


    // $ANTLR start "rule__FStructType__ElementsAssignment_5"
    // InternalDatatypes.g:2654:1: rule__FStructType__ElementsAssignment_5 : ( ruleFField ) ;
    public final void rule__FStructType__ElementsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2658:1: ( ( ruleFField ) )
            // InternalDatatypes.g:2659:2: ( ruleFField )
            {
            // InternalDatatypes.g:2659:2: ( ruleFField )
            // InternalDatatypes.g:2660:3: ruleFField
            {
             before(grammarAccess.getFStructTypeAccess().getElementsFFieldParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleFField();

            state._fsp--;

             after(grammarAccess.getFStructTypeAccess().getElementsFFieldParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FStructType__ElementsAssignment_5"


    // $ANTLR start "rule__FEnumerationType__NameAssignment_2"
    // InternalDatatypes.g:2669:1: rule__FEnumerationType__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FEnumerationType__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2673:1: ( ( RULE_ID ) )
            // InternalDatatypes.g:2674:2: ( RULE_ID )
            {
            // InternalDatatypes.g:2674:2: ( RULE_ID )
            // InternalDatatypes.g:2675:3: RULE_ID
            {
             before(grammarAccess.getFEnumerationTypeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFEnumerationTypeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__NameAssignment_2"


    // $ANTLR start "rule__FEnumerationType__BaseAssignment_3_1"
    // InternalDatatypes.g:2684:1: rule__FEnumerationType__BaseAssignment_3_1 : ( ( ruleFQN ) ) ;
    public final void rule__FEnumerationType__BaseAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2688:1: ( ( ( ruleFQN ) ) )
            // InternalDatatypes.g:2689:2: ( ( ruleFQN ) )
            {
            // InternalDatatypes.g:2689:2: ( ( ruleFQN ) )
            // InternalDatatypes.g:2690:3: ( ruleFQN )
            {
             before(grammarAccess.getFEnumerationTypeAccess().getBaseFEnumerationTypeCrossReference_3_1_0()); 
            // InternalDatatypes.g:2691:3: ( ruleFQN )
            // InternalDatatypes.g:2692:4: ruleFQN
            {
             before(grammarAccess.getFEnumerationTypeAccess().getBaseFEnumerationTypeFQNParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFEnumerationTypeAccess().getBaseFEnumerationTypeFQNParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getFEnumerationTypeAccess().getBaseFEnumerationTypeCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__BaseAssignment_3_1"


    // $ANTLR start "rule__FEnumerationType__EnumeratorsAssignment_5_0"
    // InternalDatatypes.g:2703:1: rule__FEnumerationType__EnumeratorsAssignment_5_0 : ( ruleFEnumerator ) ;
    public final void rule__FEnumerationType__EnumeratorsAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2707:1: ( ( ruleFEnumerator ) )
            // InternalDatatypes.g:2708:2: ( ruleFEnumerator )
            {
            // InternalDatatypes.g:2708:2: ( ruleFEnumerator )
            // InternalDatatypes.g:2709:3: ruleFEnumerator
            {
             before(grammarAccess.getFEnumerationTypeAccess().getEnumeratorsFEnumeratorParserRuleCall_5_0_0()); 
            pushFollow(FOLLOW_2);
            ruleFEnumerator();

            state._fsp--;

             after(grammarAccess.getFEnumerationTypeAccess().getEnumeratorsFEnumeratorParserRuleCall_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__EnumeratorsAssignment_5_0"


    // $ANTLR start "rule__FEnumerationType__EnumeratorsAssignment_5_1_1"
    // InternalDatatypes.g:2718:1: rule__FEnumerationType__EnumeratorsAssignment_5_1_1 : ( ruleFEnumerator ) ;
    public final void rule__FEnumerationType__EnumeratorsAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2722:1: ( ( ruleFEnumerator ) )
            // InternalDatatypes.g:2723:2: ( ruleFEnumerator )
            {
            // InternalDatatypes.g:2723:2: ( ruleFEnumerator )
            // InternalDatatypes.g:2724:3: ruleFEnumerator
            {
             before(grammarAccess.getFEnumerationTypeAccess().getEnumeratorsFEnumeratorParserRuleCall_5_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFEnumerator();

            state._fsp--;

             after(grammarAccess.getFEnumerationTypeAccess().getEnumeratorsFEnumeratorParserRuleCall_5_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerationType__EnumeratorsAssignment_5_1_1"


    // $ANTLR start "rule__FEnumerator__NameAssignment_1"
    // InternalDatatypes.g:2733:1: rule__FEnumerator__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FEnumerator__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2737:1: ( ( RULE_ID ) )
            // InternalDatatypes.g:2738:2: ( RULE_ID )
            {
            // InternalDatatypes.g:2738:2: ( RULE_ID )
            // InternalDatatypes.g:2739:3: RULE_ID
            {
             before(grammarAccess.getFEnumeratorAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFEnumeratorAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerator__NameAssignment_1"


    // $ANTLR start "rule__FEnumerator__ValueAssignment_2_1"
    // InternalDatatypes.g:2748:1: rule__FEnumerator__ValueAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__FEnumerator__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2752:1: ( ( RULE_STRING ) )
            // InternalDatatypes.g:2753:2: ( RULE_STRING )
            {
            // InternalDatatypes.g:2753:2: ( RULE_STRING )
            // InternalDatatypes.g:2754:3: RULE_STRING
            {
             before(grammarAccess.getFEnumeratorAccess().getValueSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getFEnumeratorAccess().getValueSTRINGTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FEnumerator__ValueAssignment_2_1"


    // $ANTLR start "rule__FMapType__NameAssignment_2"
    // InternalDatatypes.g:2763:1: rule__FMapType__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FMapType__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2767:1: ( ( RULE_ID ) )
            // InternalDatatypes.g:2768:2: ( RULE_ID )
            {
            // InternalDatatypes.g:2768:2: ( RULE_ID )
            // InternalDatatypes.g:2769:3: RULE_ID
            {
             before(grammarAccess.getFMapTypeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFMapTypeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__NameAssignment_2"


    // $ANTLR start "rule__FMapType__KeyTypeAssignment_4"
    // InternalDatatypes.g:2778:1: rule__FMapType__KeyTypeAssignment_4 : ( ruleFTypeRef ) ;
    public final void rule__FMapType__KeyTypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2782:1: ( ( ruleFTypeRef ) )
            // InternalDatatypes.g:2783:2: ( ruleFTypeRef )
            {
            // InternalDatatypes.g:2783:2: ( ruleFTypeRef )
            // InternalDatatypes.g:2784:3: ruleFTypeRef
            {
             before(grammarAccess.getFMapTypeAccess().getKeyTypeFTypeRefParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleFTypeRef();

            state._fsp--;

             after(grammarAccess.getFMapTypeAccess().getKeyTypeFTypeRefParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__KeyTypeAssignment_4"


    // $ANTLR start "rule__FMapType__ValueTypeAssignment_6"
    // InternalDatatypes.g:2793:1: rule__FMapType__ValueTypeAssignment_6 : ( ruleFTypeRef ) ;
    public final void rule__FMapType__ValueTypeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2797:1: ( ( ruleFTypeRef ) )
            // InternalDatatypes.g:2798:2: ( ruleFTypeRef )
            {
            // InternalDatatypes.g:2798:2: ( ruleFTypeRef )
            // InternalDatatypes.g:2799:3: ruleFTypeRef
            {
             before(grammarAccess.getFMapTypeAccess().getValueTypeFTypeRefParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleFTypeRef();

            state._fsp--;

             after(grammarAccess.getFMapTypeAccess().getValueTypeFTypeRefParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FMapType__ValueTypeAssignment_6"


    // $ANTLR start "rule__FField__TypeAssignment_0"
    // InternalDatatypes.g:2808:1: rule__FField__TypeAssignment_0 : ( ruleFTypeRef ) ;
    public final void rule__FField__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2812:1: ( ( ruleFTypeRef ) )
            // InternalDatatypes.g:2813:2: ( ruleFTypeRef )
            {
            // InternalDatatypes.g:2813:2: ( ruleFTypeRef )
            // InternalDatatypes.g:2814:3: ruleFTypeRef
            {
             before(grammarAccess.getFFieldAccess().getTypeFTypeRefParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleFTypeRef();

            state._fsp--;

             after(grammarAccess.getFFieldAccess().getTypeFTypeRefParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FField__TypeAssignment_0"


    // $ANTLR start "rule__FField__ListAssignment_1_0"
    // InternalDatatypes.g:2823:1: rule__FField__ListAssignment_1_0 : ( ( '[' ) ) ;
    public final void rule__FField__ListAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2827:1: ( ( ( '[' ) ) )
            // InternalDatatypes.g:2828:2: ( ( '[' ) )
            {
            // InternalDatatypes.g:2828:2: ( ( '[' ) )
            // InternalDatatypes.g:2829:3: ( '[' )
            {
             before(grammarAccess.getFFieldAccess().getListLeftSquareBracketKeyword_1_0_0()); 
            // InternalDatatypes.g:2830:3: ( '[' )
            // InternalDatatypes.g:2831:4: '['
            {
             before(grammarAccess.getFFieldAccess().getListLeftSquareBracketKeyword_1_0_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getFFieldAccess().getListLeftSquareBracketKeyword_1_0_0()); 

            }

             after(grammarAccess.getFFieldAccess().getListLeftSquareBracketKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FField__ListAssignment_1_0"


    // $ANTLR start "rule__FField__NameAssignment_2"
    // InternalDatatypes.g:2842:1: rule__FField__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__FField__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDatatypes.g:2846:1: ( ( RULE_ID ) )
            // InternalDatatypes.g:2847:2: ( RULE_ID )
            {
            // InternalDatatypes.g:2847:2: ( RULE_ID )
            // InternalDatatypes.g:2848:3: RULE_ID
            {
             before(grammarAccess.getFFieldAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFFieldAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FField__NameAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000024000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000012980000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000012800000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000001040000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000081FFF810L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000001FFF812L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000004000000012L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000012800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000001FFF810L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000040000000000L});

}