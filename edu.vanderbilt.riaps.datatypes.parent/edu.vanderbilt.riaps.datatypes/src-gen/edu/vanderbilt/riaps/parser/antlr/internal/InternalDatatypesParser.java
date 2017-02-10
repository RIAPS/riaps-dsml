package edu.vanderbilt.riaps.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import edu.vanderbilt.riaps.services.DatatypesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDatatypesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'import'", "'.'", "'*'", "'types'", "'{'", "'version'", "'}'", "'major'", "'minor'", "'struct'", "'extends'", "'enumeration'", "','", "'='", "'map'", "'to'", "'['", "']'", "'Int8'", "'UInt8'", "'Int16'", "'UInt16'", "'Int32'", "'UInt32'", "'Int64'", "'UInt64'", "'Boolean'", "'String'", "'Float'", "'Double'", "'Char'", "'ByteBuffer'"
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

        public InternalDatatypesParser(TokenStream input, DatatypesGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected DatatypesGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalDatatypes.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalDatatypes.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalDatatypes.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalDatatypes.g:72:1: ruleModel returns [EObject current=null] : ( () otherlv_1= 'package' ( (lv_name_2_0= ruleFQN ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_typeCollections_4_0= ruleFTypeCollection ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_imports_3_0 = null;

        EObject lv_typeCollections_4_0 = null;



        	enterRule();

        try {
            // InternalDatatypes.g:78:2: ( ( () otherlv_1= 'package' ( (lv_name_2_0= ruleFQN ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_typeCollections_4_0= ruleFTypeCollection ) )* ) )
            // InternalDatatypes.g:79:2: ( () otherlv_1= 'package' ( (lv_name_2_0= ruleFQN ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_typeCollections_4_0= ruleFTypeCollection ) )* )
            {
            // InternalDatatypes.g:79:2: ( () otherlv_1= 'package' ( (lv_name_2_0= ruleFQN ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_typeCollections_4_0= ruleFTypeCollection ) )* )
            // InternalDatatypes.g:80:3: () otherlv_1= 'package' ( (lv_name_2_0= ruleFQN ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_typeCollections_4_0= ruleFTypeCollection ) )*
            {
            // InternalDatatypes.g:80:3: ()
            // InternalDatatypes.g:81:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getModelAccess().getModelAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getModelAccess().getPackageKeyword_1());
            		
            // InternalDatatypes.g:91:3: ( (lv_name_2_0= ruleFQN ) )
            // InternalDatatypes.g:92:4: (lv_name_2_0= ruleFQN )
            {
            // InternalDatatypes.g:92:4: (lv_name_2_0= ruleFQN )
            // InternalDatatypes.g:93:5: lv_name_2_0= ruleFQN
            {

            					newCompositeNode(grammarAccess.getModelAccess().getNameFQNParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleFQN();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"edu.vanderbilt.riaps.Datatypes.FQN");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDatatypes.g:110:3: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDatatypes.g:111:4: (lv_imports_3_0= ruleImport )
            	    {
            	    // InternalDatatypes.g:111:4: (lv_imports_3_0= ruleImport )
            	    // InternalDatatypes.g:112:5: lv_imports_3_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_3_0,
            	    						"edu.vanderbilt.riaps.Datatypes.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalDatatypes.g:129:3: ( (lv_typeCollections_4_0= ruleFTypeCollection ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalDatatypes.g:130:4: (lv_typeCollections_4_0= ruleFTypeCollection )
            	    {
            	    // InternalDatatypes.g:130:4: (lv_typeCollections_4_0= ruleFTypeCollection )
            	    // InternalDatatypes.g:131:5: lv_typeCollections_4_0= ruleFTypeCollection
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getTypeCollectionsFTypeCollectionParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_typeCollections_4_0=ruleFTypeCollection();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"typeCollections",
            	    						lv_typeCollections_4_0,
            	    						"edu.vanderbilt.riaps.Datatypes.FTypeCollection");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleImport"
    // InternalDatatypes.g:152:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalDatatypes.g:152:47: (iv_ruleImport= ruleImport EOF )
            // InternalDatatypes.g:153:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalDatatypes.g:159:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;



        	enterRule();

        try {
            // InternalDatatypes.g:165:2: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) )
            // InternalDatatypes.g:166:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            {
            // InternalDatatypes.g:166:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            // InternalDatatypes.g:167:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalDatatypes.g:171:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            // InternalDatatypes.g:172:4: (lv_importedNamespace_1_0= ruleImportedFQN )
            {
            // InternalDatatypes.g:172:4: (lv_importedNamespace_1_0= ruleImportedFQN )
            // InternalDatatypes.g:173:5: lv_importedNamespace_1_0= ruleImportedFQN
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceImportedFQNParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_importedNamespace_1_0=ruleImportedFQN();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"importedNamespace",
            						lv_importedNamespace_1_0,
            						"edu.vanderbilt.riaps.Datatypes.ImportedFQN");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportedFQN"
    // InternalDatatypes.g:194:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalDatatypes.g:194:51: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalDatatypes.g:195:2: iv_ruleImportedFQN= ruleImportedFQN EOF
            {
             newCompositeNode(grammarAccess.getImportedFQNRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportedFQN=ruleImportedFQN();

            state._fsp--;

             current =iv_ruleImportedFQN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportedFQN"


    // $ANTLR start "ruleImportedFQN"
    // InternalDatatypes.g:201:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;



        	enterRule();

        try {
            // InternalDatatypes.g:207:2: ( (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) )
            // InternalDatatypes.g:208:2: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            {
            // InternalDatatypes.g:208:2: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            // InternalDatatypes.g:209:3: this_FQN_0= ruleFQN (kw= '.' kw= '*' )?
            {

            			newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0());
            		
            pushFollow(FOLLOW_6);
            this_FQN_0=ruleFQN();

            state._fsp--;


            			current.merge(this_FQN_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalDatatypes.g:219:3: (kw= '.' kw= '*' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalDatatypes.g:220:4: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,13,FOLLOW_7); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getImportedFQNAccess().getFullStopKeyword_1_0());
                    			
                    kw=(Token)match(input,14,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getImportedFQNAccess().getAsteriskKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportedFQN"


    // $ANTLR start "entryRuleFQN"
    // InternalDatatypes.g:235:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalDatatypes.g:235:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalDatatypes.g:236:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalDatatypes.g:242:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalDatatypes.g:248:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalDatatypes.g:249:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalDatatypes.g:249:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalDatatypes.g:250:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
            		
            // InternalDatatypes.g:257:3: (kw= '.' this_ID_2= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2==RULE_ID) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // InternalDatatypes.g:258:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,13,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_6); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleFTypeCollection"
    // InternalDatatypes.g:275:1: entryRuleFTypeCollection returns [EObject current=null] : iv_ruleFTypeCollection= ruleFTypeCollection EOF ;
    public final EObject entryRuleFTypeCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFTypeCollection = null;


        try {
            // InternalDatatypes.g:275:56: (iv_ruleFTypeCollection= ruleFTypeCollection EOF )
            // InternalDatatypes.g:276:2: iv_ruleFTypeCollection= ruleFTypeCollection EOF
            {
             newCompositeNode(grammarAccess.getFTypeCollectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFTypeCollection=ruleFTypeCollection();

            state._fsp--;

             current =iv_ruleFTypeCollection; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFTypeCollection"


    // $ANTLR start "ruleFTypeCollection"
    // InternalDatatypes.g:282:1: ruleFTypeCollection returns [EObject current=null] : ( () otherlv_1= 'types' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= '{' (otherlv_4= 'version' ( (lv_version_5_0= ruleFVersion ) ) )? ( (lv_types_6_0= ruleFType ) )* otherlv_7= '}' ) ;
    public final EObject ruleFTypeCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_version_5_0 = null;

        EObject lv_types_6_0 = null;



        	enterRule();

        try {
            // InternalDatatypes.g:288:2: ( ( () otherlv_1= 'types' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= '{' (otherlv_4= 'version' ( (lv_version_5_0= ruleFVersion ) ) )? ( (lv_types_6_0= ruleFType ) )* otherlv_7= '}' ) )
            // InternalDatatypes.g:289:2: ( () otherlv_1= 'types' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= '{' (otherlv_4= 'version' ( (lv_version_5_0= ruleFVersion ) ) )? ( (lv_types_6_0= ruleFType ) )* otherlv_7= '}' )
            {
            // InternalDatatypes.g:289:2: ( () otherlv_1= 'types' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= '{' (otherlv_4= 'version' ( (lv_version_5_0= ruleFVersion ) ) )? ( (lv_types_6_0= ruleFType ) )* otherlv_7= '}' )
            // InternalDatatypes.g:290:3: () otherlv_1= 'types' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= '{' (otherlv_4= 'version' ( (lv_version_5_0= ruleFVersion ) ) )? ( (lv_types_6_0= ruleFType ) )* otherlv_7= '}'
            {
            // InternalDatatypes.g:290:3: ()
            // InternalDatatypes.g:291:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFTypeCollectionAccess().getFTypeCollectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getFTypeCollectionAccess().getTypesKeyword_1());
            		
            // InternalDatatypes.g:301:3: ( (lv_name_2_0= RULE_ID ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalDatatypes.g:302:4: (lv_name_2_0= RULE_ID )
                    {
                    // InternalDatatypes.g:302:4: (lv_name_2_0= RULE_ID )
                    // InternalDatatypes.g:303:5: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

                    					newLeafNode(lv_name_2_0, grammarAccess.getFTypeCollectionAccess().getNameIDTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFTypeCollectionRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_2_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getFTypeCollectionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalDatatypes.g:323:3: (otherlv_4= 'version' ( (lv_version_5_0= ruleFVersion ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalDatatypes.g:324:4: otherlv_4= 'version' ( (lv_version_5_0= ruleFVersion ) )
                    {
                    otherlv_4=(Token)match(input,17,FOLLOW_9); 

                    				newLeafNode(otherlv_4, grammarAccess.getFTypeCollectionAccess().getVersionKeyword_4_0());
                    			
                    // InternalDatatypes.g:328:4: ( (lv_version_5_0= ruleFVersion ) )
                    // InternalDatatypes.g:329:5: (lv_version_5_0= ruleFVersion )
                    {
                    // InternalDatatypes.g:329:5: (lv_version_5_0= ruleFVersion )
                    // InternalDatatypes.g:330:6: lv_version_5_0= ruleFVersion
                    {

                    						newCompositeNode(grammarAccess.getFTypeCollectionAccess().getVersionFVersionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_version_5_0=ruleFVersion();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFTypeCollectionRule());
                    						}
                    						set(
                    							current,
                    							"version",
                    							lv_version_5_0,
                    							"edu.vanderbilt.riaps.Datatypes.FVersion");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalDatatypes.g:348:3: ( (lv_types_6_0= ruleFType ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21||LA7_0==23||LA7_0==26) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalDatatypes.g:349:4: (lv_types_6_0= ruleFType )
            	    {
            	    // InternalDatatypes.g:349:4: (lv_types_6_0= ruleFType )
            	    // InternalDatatypes.g:350:5: lv_types_6_0= ruleFType
            	    {

            	    					newCompositeNode(grammarAccess.getFTypeCollectionAccess().getTypesFTypeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_types_6_0=ruleFType();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFTypeCollectionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"types",
            	    						lv_types_6_0,
            	    						"edu.vanderbilt.riaps.Datatypes.FType");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_7=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getFTypeCollectionAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFTypeCollection"


    // $ANTLR start "entryRuleFVersion"
    // InternalDatatypes.g:375:1: entryRuleFVersion returns [EObject current=null] : iv_ruleFVersion= ruleFVersion EOF ;
    public final EObject entryRuleFVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFVersion = null;


        try {
            // InternalDatatypes.g:375:49: (iv_ruleFVersion= ruleFVersion EOF )
            // InternalDatatypes.g:376:2: iv_ruleFVersion= ruleFVersion EOF
            {
             newCompositeNode(grammarAccess.getFVersionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFVersion=ruleFVersion();

            state._fsp--;

             current =iv_ruleFVersion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFVersion"


    // $ANTLR start "ruleFVersion"
    // InternalDatatypes.g:382:1: ruleFVersion returns [EObject current=null] : ( () otherlv_1= '{' otherlv_2= 'major' ( (lv_major_3_0= RULE_INT ) ) otherlv_4= 'minor' ( (lv_minor_5_0= RULE_INT ) ) otherlv_6= '}' ) ;
    public final EObject ruleFVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_major_3_0=null;
        Token otherlv_4=null;
        Token lv_minor_5_0=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalDatatypes.g:388:2: ( ( () otherlv_1= '{' otherlv_2= 'major' ( (lv_major_3_0= RULE_INT ) ) otherlv_4= 'minor' ( (lv_minor_5_0= RULE_INT ) ) otherlv_6= '}' ) )
            // InternalDatatypes.g:389:2: ( () otherlv_1= '{' otherlv_2= 'major' ( (lv_major_3_0= RULE_INT ) ) otherlv_4= 'minor' ( (lv_minor_5_0= RULE_INT ) ) otherlv_6= '}' )
            {
            // InternalDatatypes.g:389:2: ( () otherlv_1= '{' otherlv_2= 'major' ( (lv_major_3_0= RULE_INT ) ) otherlv_4= 'minor' ( (lv_minor_5_0= RULE_INT ) ) otherlv_6= '}' )
            // InternalDatatypes.g:390:3: () otherlv_1= '{' otherlv_2= 'major' ( (lv_major_3_0= RULE_INT ) ) otherlv_4= 'minor' ( (lv_minor_5_0= RULE_INT ) ) otherlv_6= '}'
            {
            // InternalDatatypes.g:390:3: ()
            // InternalDatatypes.g:391:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFVersionAccess().getFVersionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getFVersionAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getFVersionAccess().getMajorKeyword_2());
            		
            // InternalDatatypes.g:405:3: ( (lv_major_3_0= RULE_INT ) )
            // InternalDatatypes.g:406:4: (lv_major_3_0= RULE_INT )
            {
            // InternalDatatypes.g:406:4: (lv_major_3_0= RULE_INT )
            // InternalDatatypes.g:407:5: lv_major_3_0= RULE_INT
            {
            lv_major_3_0=(Token)match(input,RULE_INT,FOLLOW_14); 

            					newLeafNode(lv_major_3_0, grammarAccess.getFVersionAccess().getMajorINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFVersionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"major",
            						lv_major_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_4, grammarAccess.getFVersionAccess().getMinorKeyword_4());
            		
            // InternalDatatypes.g:427:3: ( (lv_minor_5_0= RULE_INT ) )
            // InternalDatatypes.g:428:4: (lv_minor_5_0= RULE_INT )
            {
            // InternalDatatypes.g:428:4: (lv_minor_5_0= RULE_INT )
            // InternalDatatypes.g:429:5: lv_minor_5_0= RULE_INT
            {
            lv_minor_5_0=(Token)match(input,RULE_INT,FOLLOW_15); 

            					newLeafNode(lv_minor_5_0, grammarAccess.getFVersionAccess().getMinorINTTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFVersionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"minor",
            						lv_minor_5_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_6=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getFVersionAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFVersion"


    // $ANTLR start "entryRuleFTypeRef"
    // InternalDatatypes.g:453:1: entryRuleFTypeRef returns [EObject current=null] : iv_ruleFTypeRef= ruleFTypeRef EOF ;
    public final EObject entryRuleFTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFTypeRef = null;


        try {
            // InternalDatatypes.g:453:49: (iv_ruleFTypeRef= ruleFTypeRef EOF )
            // InternalDatatypes.g:454:2: iv_ruleFTypeRef= ruleFTypeRef EOF
            {
             newCompositeNode(grammarAccess.getFTypeRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFTypeRef=ruleFTypeRef();

            state._fsp--;

             current =iv_ruleFTypeRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFTypeRef"


    // $ANTLR start "ruleFTypeRef"
    // InternalDatatypes.g:460:1: ruleFTypeRef returns [EObject current=null] : ( ( (lv_predefined_0_0= ruleFBasicTypeId ) ) | ( ( ruleFQN ) ) ) ;
    public final EObject ruleFTypeRef() throws RecognitionException {
        EObject current = null;

        Enumerator lv_predefined_0_0 = null;



        	enterRule();

        try {
            // InternalDatatypes.g:466:2: ( ( ( (lv_predefined_0_0= ruleFBasicTypeId ) ) | ( ( ruleFQN ) ) ) )
            // InternalDatatypes.g:467:2: ( ( (lv_predefined_0_0= ruleFBasicTypeId ) ) | ( ( ruleFQN ) ) )
            {
            // InternalDatatypes.g:467:2: ( ( (lv_predefined_0_0= ruleFBasicTypeId ) ) | ( ( ruleFQN ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=30 && LA8_0<=43)) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalDatatypes.g:468:3: ( (lv_predefined_0_0= ruleFBasicTypeId ) )
                    {
                    // InternalDatatypes.g:468:3: ( (lv_predefined_0_0= ruleFBasicTypeId ) )
                    // InternalDatatypes.g:469:4: (lv_predefined_0_0= ruleFBasicTypeId )
                    {
                    // InternalDatatypes.g:469:4: (lv_predefined_0_0= ruleFBasicTypeId )
                    // InternalDatatypes.g:470:5: lv_predefined_0_0= ruleFBasicTypeId
                    {

                    					newCompositeNode(grammarAccess.getFTypeRefAccess().getPredefinedFBasicTypeIdEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_predefined_0_0=ruleFBasicTypeId();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFTypeRefRule());
                    					}
                    					set(
                    						current,
                    						"predefined",
                    						lv_predefined_0_0,
                    						"edu.vanderbilt.riaps.Datatypes.FBasicTypeId");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalDatatypes.g:488:3: ( ( ruleFQN ) )
                    {
                    // InternalDatatypes.g:488:3: ( ( ruleFQN ) )
                    // InternalDatatypes.g:489:4: ( ruleFQN )
                    {
                    // InternalDatatypes.g:489:4: ( ruleFQN )
                    // InternalDatatypes.g:490:5: ruleFQN
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFTypeRefRule());
                    					}
                    				

                    					newCompositeNode(grammarAccess.getFTypeRefAccess().getDerivedFTypeCrossReference_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    ruleFQN();

                    state._fsp--;


                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFTypeRef"


    // $ANTLR start "entryRuleFType"
    // InternalDatatypes.g:508:1: entryRuleFType returns [EObject current=null] : iv_ruleFType= ruleFType EOF ;
    public final EObject entryRuleFType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFType = null;


        try {
            // InternalDatatypes.g:508:46: (iv_ruleFType= ruleFType EOF )
            // InternalDatatypes.g:509:2: iv_ruleFType= ruleFType EOF
            {
             newCompositeNode(grammarAccess.getFTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFType=ruleFType();

            state._fsp--;

             current =iv_ruleFType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFType"


    // $ANTLR start "ruleFType"
    // InternalDatatypes.g:515:1: ruleFType returns [EObject current=null] : (this_FEnumerationType_0= ruleFEnumerationType | this_FStructType_1= ruleFStructType | this_FMapType_2= ruleFMapType ) ;
    public final EObject ruleFType() throws RecognitionException {
        EObject current = null;

        EObject this_FEnumerationType_0 = null;

        EObject this_FStructType_1 = null;

        EObject this_FMapType_2 = null;



        	enterRule();

        try {
            // InternalDatatypes.g:521:2: ( (this_FEnumerationType_0= ruleFEnumerationType | this_FStructType_1= ruleFStructType | this_FMapType_2= ruleFMapType ) )
            // InternalDatatypes.g:522:2: (this_FEnumerationType_0= ruleFEnumerationType | this_FStructType_1= ruleFStructType | this_FMapType_2= ruleFMapType )
            {
            // InternalDatatypes.g:522:2: (this_FEnumerationType_0= ruleFEnumerationType | this_FStructType_1= ruleFStructType | this_FMapType_2= ruleFMapType )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt9=1;
                }
                break;
            case 21:
                {
                alt9=2;
                }
                break;
            case 26:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalDatatypes.g:523:3: this_FEnumerationType_0= ruleFEnumerationType
                    {

                    			newCompositeNode(grammarAccess.getFTypeAccess().getFEnumerationTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FEnumerationType_0=ruleFEnumerationType();

                    state._fsp--;


                    			current = this_FEnumerationType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDatatypes.g:532:3: this_FStructType_1= ruleFStructType
                    {

                    			newCompositeNode(grammarAccess.getFTypeAccess().getFStructTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_FStructType_1=ruleFStructType();

                    state._fsp--;


                    			current = this_FStructType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalDatatypes.g:541:3: this_FMapType_2= ruleFMapType
                    {

                    			newCompositeNode(grammarAccess.getFTypeAccess().getFMapTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_FMapType_2=ruleFMapType();

                    state._fsp--;


                    			current = this_FMapType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFType"


    // $ANTLR start "entryRuleFStructType"
    // InternalDatatypes.g:553:1: entryRuleFStructType returns [EObject current=null] : iv_ruleFStructType= ruleFStructType EOF ;
    public final EObject entryRuleFStructType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFStructType = null;


        try {
            // InternalDatatypes.g:553:52: (iv_ruleFStructType= ruleFStructType EOF )
            // InternalDatatypes.g:554:2: iv_ruleFStructType= ruleFStructType EOF
            {
             newCompositeNode(grammarAccess.getFStructTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFStructType=ruleFStructType();

            state._fsp--;

             current =iv_ruleFStructType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFStructType"


    // $ANTLR start "ruleFStructType"
    // InternalDatatypes.g:560:1: ruleFStructType returns [EObject current=null] : ( () otherlv_1= 'struct' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_elements_6_0= ruleFField ) )* otherlv_7= '}' ) ;
    public final EObject ruleFStructType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_elements_6_0 = null;



        	enterRule();

        try {
            // InternalDatatypes.g:566:2: ( ( () otherlv_1= 'struct' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_elements_6_0= ruleFField ) )* otherlv_7= '}' ) )
            // InternalDatatypes.g:567:2: ( () otherlv_1= 'struct' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_elements_6_0= ruleFField ) )* otherlv_7= '}' )
            {
            // InternalDatatypes.g:567:2: ( () otherlv_1= 'struct' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_elements_6_0= ruleFField ) )* otherlv_7= '}' )
            // InternalDatatypes.g:568:3: () otherlv_1= 'struct' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( (lv_elements_6_0= ruleFField ) )* otherlv_7= '}'
            {
            // InternalDatatypes.g:568:3: ()
            // InternalDatatypes.g:569:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFStructTypeAccess().getFStructTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getFStructTypeAccess().getStructKeyword_1());
            		
            // InternalDatatypes.g:579:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalDatatypes.g:580:4: (lv_name_2_0= RULE_ID )
            {
            // InternalDatatypes.g:580:4: (lv_name_2_0= RULE_ID )
            // InternalDatatypes.g:581:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_2_0, grammarAccess.getFStructTypeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFStructTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDatatypes.g:597:3: (otherlv_3= 'extends' ( ( ruleFQN ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDatatypes.g:598:4: otherlv_3= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getFStructTypeAccess().getExtendsKeyword_3_0());
                    			
                    // InternalDatatypes.g:602:4: ( ( ruleFQN ) )
                    // InternalDatatypes.g:603:5: ( ruleFQN )
                    {
                    // InternalDatatypes.g:603:5: ( ruleFQN )
                    // InternalDatatypes.g:604:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFStructTypeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getFStructTypeAccess().getBaseFStructTypeCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_17); 

            			newLeafNode(otherlv_5, grammarAccess.getFStructTypeAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalDatatypes.g:623:3: ( (lv_elements_6_0= ruleFField ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID||(LA11_0>=30 && LA11_0<=43)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalDatatypes.g:624:4: (lv_elements_6_0= ruleFField )
            	    {
            	    // InternalDatatypes.g:624:4: (lv_elements_6_0= ruleFField )
            	    // InternalDatatypes.g:625:5: lv_elements_6_0= ruleFField
            	    {

            	    					newCompositeNode(grammarAccess.getFStructTypeAccess().getElementsFFieldParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_elements_6_0=ruleFField();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFStructTypeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_6_0,
            	    						"edu.vanderbilt.riaps.Datatypes.FField");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_7=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getFStructTypeAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFStructType"


    // $ANTLR start "entryRuleFEnumerationType"
    // InternalDatatypes.g:650:1: entryRuleFEnumerationType returns [EObject current=null] : iv_ruleFEnumerationType= ruleFEnumerationType EOF ;
    public final EObject entryRuleFEnumerationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFEnumerationType = null;


        try {
            // InternalDatatypes.g:650:57: (iv_ruleFEnumerationType= ruleFEnumerationType EOF )
            // InternalDatatypes.g:651:2: iv_ruleFEnumerationType= ruleFEnumerationType EOF
            {
             newCompositeNode(grammarAccess.getFEnumerationTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFEnumerationType=ruleFEnumerationType();

            state._fsp--;

             current =iv_ruleFEnumerationType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFEnumerationType"


    // $ANTLR start "ruleFEnumerationType"
    // InternalDatatypes.g:657:1: ruleFEnumerationType returns [EObject current=null] : ( () otherlv_1= 'enumeration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_enumerators_6_0= ruleFEnumerator ) ) ( (otherlv_7= ',' )? ( (lv_enumerators_8_0= ruleFEnumerator ) ) )* )? otherlv_9= '}' ) ;
    public final EObject ruleFEnumerationType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_enumerators_6_0 = null;

        EObject lv_enumerators_8_0 = null;



        	enterRule();

        try {
            // InternalDatatypes.g:663:2: ( ( () otherlv_1= 'enumeration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_enumerators_6_0= ruleFEnumerator ) ) ( (otherlv_7= ',' )? ( (lv_enumerators_8_0= ruleFEnumerator ) ) )* )? otherlv_9= '}' ) )
            // InternalDatatypes.g:664:2: ( () otherlv_1= 'enumeration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_enumerators_6_0= ruleFEnumerator ) ) ( (otherlv_7= ',' )? ( (lv_enumerators_8_0= ruleFEnumerator ) ) )* )? otherlv_9= '}' )
            {
            // InternalDatatypes.g:664:2: ( () otherlv_1= 'enumeration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_enumerators_6_0= ruleFEnumerator ) ) ( (otherlv_7= ',' )? ( (lv_enumerators_8_0= ruleFEnumerator ) ) )* )? otherlv_9= '}' )
            // InternalDatatypes.g:665:3: () otherlv_1= 'enumeration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_enumerators_6_0= ruleFEnumerator ) ) ( (otherlv_7= ',' )? ( (lv_enumerators_8_0= ruleFEnumerator ) ) )* )? otherlv_9= '}'
            {
            // InternalDatatypes.g:665:3: ()
            // InternalDatatypes.g:666:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFEnumerationTypeAccess().getFEnumerationTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getFEnumerationTypeAccess().getEnumerationKeyword_1());
            		
            // InternalDatatypes.g:676:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalDatatypes.g:677:4: (lv_name_2_0= RULE_ID )
            {
            // InternalDatatypes.g:677:4: (lv_name_2_0= RULE_ID )
            // InternalDatatypes.g:678:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_2_0, grammarAccess.getFEnumerationTypeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFEnumerationTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDatatypes.g:694:3: (otherlv_3= 'extends' ( ( ruleFQN ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalDatatypes.g:695:4: otherlv_3= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getFEnumerationTypeAccess().getExtendsKeyword_3_0());
                    			
                    // InternalDatatypes.g:699:4: ( ( ruleFQN ) )
                    // InternalDatatypes.g:700:5: ( ruleFQN )
                    {
                    // InternalDatatypes.g:700:5: ( ruleFQN )
                    // InternalDatatypes.g:701:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFEnumerationTypeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getFEnumerationTypeAccess().getBaseFEnumerationTypeCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_18); 

            			newLeafNode(otherlv_5, grammarAccess.getFEnumerationTypeAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalDatatypes.g:720:3: ( ( (lv_enumerators_6_0= ruleFEnumerator ) ) ( (otherlv_7= ',' )? ( (lv_enumerators_8_0= ruleFEnumerator ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDatatypes.g:721:4: ( (lv_enumerators_6_0= ruleFEnumerator ) ) ( (otherlv_7= ',' )? ( (lv_enumerators_8_0= ruleFEnumerator ) ) )*
                    {
                    // InternalDatatypes.g:721:4: ( (lv_enumerators_6_0= ruleFEnumerator ) )
                    // InternalDatatypes.g:722:5: (lv_enumerators_6_0= ruleFEnumerator )
                    {
                    // InternalDatatypes.g:722:5: (lv_enumerators_6_0= ruleFEnumerator )
                    // InternalDatatypes.g:723:6: lv_enumerators_6_0= ruleFEnumerator
                    {

                    						newCompositeNode(grammarAccess.getFEnumerationTypeAccess().getEnumeratorsFEnumeratorParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_enumerators_6_0=ruleFEnumerator();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFEnumerationTypeRule());
                    						}
                    						add(
                    							current,
                    							"enumerators",
                    							lv_enumerators_6_0,
                    							"edu.vanderbilt.riaps.Datatypes.FEnumerator");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalDatatypes.g:740:4: ( (otherlv_7= ',' )? ( (lv_enumerators_8_0= ruleFEnumerator ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID||LA14_0==24) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalDatatypes.g:741:5: (otherlv_7= ',' )? ( (lv_enumerators_8_0= ruleFEnumerator ) )
                    	    {
                    	    // InternalDatatypes.g:741:5: (otherlv_7= ',' )?
                    	    int alt13=2;
                    	    int LA13_0 = input.LA(1);

                    	    if ( (LA13_0==24) ) {
                    	        alt13=1;
                    	    }
                    	    switch (alt13) {
                    	        case 1 :
                    	            // InternalDatatypes.g:742:6: otherlv_7= ','
                    	            {
                    	            otherlv_7=(Token)match(input,24,FOLLOW_3); 

                    	            						newLeafNode(otherlv_7, grammarAccess.getFEnumerationTypeAccess().getCommaKeyword_5_1_0());
                    	            					

                    	            }
                    	            break;

                    	    }

                    	    // InternalDatatypes.g:747:5: ( (lv_enumerators_8_0= ruleFEnumerator ) )
                    	    // InternalDatatypes.g:748:6: (lv_enumerators_8_0= ruleFEnumerator )
                    	    {
                    	    // InternalDatatypes.g:748:6: (lv_enumerators_8_0= ruleFEnumerator )
                    	    // InternalDatatypes.g:749:7: lv_enumerators_8_0= ruleFEnumerator
                    	    {

                    	    							newCompositeNode(grammarAccess.getFEnumerationTypeAccess().getEnumeratorsFEnumeratorParserRuleCall_5_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_19);
                    	    lv_enumerators_8_0=ruleFEnumerator();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getFEnumerationTypeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"enumerators",
                    	    								lv_enumerators_8_0,
                    	    								"edu.vanderbilt.riaps.Datatypes.FEnumerator");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getFEnumerationTypeAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFEnumerationType"


    // $ANTLR start "entryRuleFEnumerator"
    // InternalDatatypes.g:776:1: entryRuleFEnumerator returns [EObject current=null] : iv_ruleFEnumerator= ruleFEnumerator EOF ;
    public final EObject entryRuleFEnumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFEnumerator = null;


        try {
            // InternalDatatypes.g:776:52: (iv_ruleFEnumerator= ruleFEnumerator EOF )
            // InternalDatatypes.g:777:2: iv_ruleFEnumerator= ruleFEnumerator EOF
            {
             newCompositeNode(grammarAccess.getFEnumeratorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFEnumerator=ruleFEnumerator();

            state._fsp--;

             current =iv_ruleFEnumerator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFEnumerator"


    // $ANTLR start "ruleFEnumerator"
    // InternalDatatypes.g:783:1: ruleFEnumerator returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleFEnumerator() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalDatatypes.g:789:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )? ) )
            // InternalDatatypes.g:790:2: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )? )
            {
            // InternalDatatypes.g:790:2: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )? )
            // InternalDatatypes.g:791:3: () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )?
            {
            // InternalDatatypes.g:791:3: ()
            // InternalDatatypes.g:792:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFEnumeratorAccess().getFEnumeratorAction_0(),
            					current);
            			

            }

            // InternalDatatypes.g:798:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDatatypes.g:799:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDatatypes.g:799:4: (lv_name_1_0= RULE_ID )
            // InternalDatatypes.g:800:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFEnumeratorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFEnumeratorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDatatypes.g:816:3: (otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDatatypes.g:817:4: otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_21); 

                    				newLeafNode(otherlv_2, grammarAccess.getFEnumeratorAccess().getEqualsSignKeyword_2_0());
                    			
                    // InternalDatatypes.g:821:4: ( (lv_value_3_0= RULE_STRING ) )
                    // InternalDatatypes.g:822:5: (lv_value_3_0= RULE_STRING )
                    {
                    // InternalDatatypes.g:822:5: (lv_value_3_0= RULE_STRING )
                    // InternalDatatypes.g:823:6: lv_value_3_0= RULE_STRING
                    {
                    lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_3_0, grammarAccess.getFEnumeratorAccess().getValueSTRINGTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFEnumeratorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFEnumerator"


    // $ANTLR start "entryRuleFMapType"
    // InternalDatatypes.g:844:1: entryRuleFMapType returns [EObject current=null] : iv_ruleFMapType= ruleFMapType EOF ;
    public final EObject entryRuleFMapType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFMapType = null;


        try {
            // InternalDatatypes.g:844:49: (iv_ruleFMapType= ruleFMapType EOF )
            // InternalDatatypes.g:845:2: iv_ruleFMapType= ruleFMapType EOF
            {
             newCompositeNode(grammarAccess.getFMapTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFMapType=ruleFMapType();

            state._fsp--;

             current =iv_ruleFMapType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFMapType"


    // $ANTLR start "ruleFMapType"
    // InternalDatatypes.g:851:1: ruleFMapType returns [EObject current=null] : ( () otherlv_1= 'map' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_keyType_4_0= ruleFTypeRef ) ) otherlv_5= 'to' ( (lv_valueType_6_0= ruleFTypeRef ) ) otherlv_7= '}' ) ;
    public final EObject ruleFMapType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_keyType_4_0 = null;

        EObject lv_valueType_6_0 = null;



        	enterRule();

        try {
            // InternalDatatypes.g:857:2: ( ( () otherlv_1= 'map' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_keyType_4_0= ruleFTypeRef ) ) otherlv_5= 'to' ( (lv_valueType_6_0= ruleFTypeRef ) ) otherlv_7= '}' ) )
            // InternalDatatypes.g:858:2: ( () otherlv_1= 'map' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_keyType_4_0= ruleFTypeRef ) ) otherlv_5= 'to' ( (lv_valueType_6_0= ruleFTypeRef ) ) otherlv_7= '}' )
            {
            // InternalDatatypes.g:858:2: ( () otherlv_1= 'map' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_keyType_4_0= ruleFTypeRef ) ) otherlv_5= 'to' ( (lv_valueType_6_0= ruleFTypeRef ) ) otherlv_7= '}' )
            // InternalDatatypes.g:859:3: () otherlv_1= 'map' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_keyType_4_0= ruleFTypeRef ) ) otherlv_5= 'to' ( (lv_valueType_6_0= ruleFTypeRef ) ) otherlv_7= '}'
            {
            // InternalDatatypes.g:859:3: ()
            // InternalDatatypes.g:860:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFMapTypeAccess().getFMapTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getFMapTypeAccess().getMapKeyword_1());
            		
            // InternalDatatypes.g:870:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalDatatypes.g:871:4: (lv_name_2_0= RULE_ID )
            {
            // InternalDatatypes.g:871:4: (lv_name_2_0= RULE_ID )
            // InternalDatatypes.g:872:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_2_0, grammarAccess.getFMapTypeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFMapTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_22); 

            			newLeafNode(otherlv_3, grammarAccess.getFMapTypeAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalDatatypes.g:892:3: ( (lv_keyType_4_0= ruleFTypeRef ) )
            // InternalDatatypes.g:893:4: (lv_keyType_4_0= ruleFTypeRef )
            {
            // InternalDatatypes.g:893:4: (lv_keyType_4_0= ruleFTypeRef )
            // InternalDatatypes.g:894:5: lv_keyType_4_0= ruleFTypeRef
            {

            					newCompositeNode(grammarAccess.getFMapTypeAccess().getKeyTypeFTypeRefParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_23);
            lv_keyType_4_0=ruleFTypeRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFMapTypeRule());
            					}
            					set(
            						current,
            						"keyType",
            						lv_keyType_4_0,
            						"edu.vanderbilt.riaps.Datatypes.FTypeRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_22); 

            			newLeafNode(otherlv_5, grammarAccess.getFMapTypeAccess().getToKeyword_5());
            		
            // InternalDatatypes.g:915:3: ( (lv_valueType_6_0= ruleFTypeRef ) )
            // InternalDatatypes.g:916:4: (lv_valueType_6_0= ruleFTypeRef )
            {
            // InternalDatatypes.g:916:4: (lv_valueType_6_0= ruleFTypeRef )
            // InternalDatatypes.g:917:5: lv_valueType_6_0= ruleFTypeRef
            {

            					newCompositeNode(grammarAccess.getFMapTypeAccess().getValueTypeFTypeRefParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_15);
            lv_valueType_6_0=ruleFTypeRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFMapTypeRule());
            					}
            					set(
            						current,
            						"valueType",
            						lv_valueType_6_0,
            						"edu.vanderbilt.riaps.Datatypes.FTypeRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getFMapTypeAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFMapType"


    // $ANTLR start "entryRuleFField"
    // InternalDatatypes.g:942:1: entryRuleFField returns [EObject current=null] : iv_ruleFField= ruleFField EOF ;
    public final EObject entryRuleFField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFField = null;


        try {
            // InternalDatatypes.g:942:47: (iv_ruleFField= ruleFField EOF )
            // InternalDatatypes.g:943:2: iv_ruleFField= ruleFField EOF
            {
             newCompositeNode(grammarAccess.getFFieldRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFField=ruleFField();

            state._fsp--;

             current =iv_ruleFField; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFField"


    // $ANTLR start "ruleFField"
    // InternalDatatypes.g:949:1: ruleFField returns [EObject current=null] : ( ( (lv_type_0_0= ruleFTypeRef ) ) ( ( (lv_list_1_0= '[' ) ) otherlv_2= ']' )? ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleFField() throws RecognitionException {
        EObject current = null;

        Token lv_list_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalDatatypes.g:955:2: ( ( ( (lv_type_0_0= ruleFTypeRef ) ) ( ( (lv_list_1_0= '[' ) ) otherlv_2= ']' )? ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalDatatypes.g:956:2: ( ( (lv_type_0_0= ruleFTypeRef ) ) ( ( (lv_list_1_0= '[' ) ) otherlv_2= ']' )? ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalDatatypes.g:956:2: ( ( (lv_type_0_0= ruleFTypeRef ) ) ( ( (lv_list_1_0= '[' ) ) otherlv_2= ']' )? ( (lv_name_3_0= RULE_ID ) ) )
            // InternalDatatypes.g:957:3: ( (lv_type_0_0= ruleFTypeRef ) ) ( ( (lv_list_1_0= '[' ) ) otherlv_2= ']' )? ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalDatatypes.g:957:3: ( (lv_type_0_0= ruleFTypeRef ) )
            // InternalDatatypes.g:958:4: (lv_type_0_0= ruleFTypeRef )
            {
            // InternalDatatypes.g:958:4: (lv_type_0_0= ruleFTypeRef )
            // InternalDatatypes.g:959:5: lv_type_0_0= ruleFTypeRef
            {

            					newCompositeNode(grammarAccess.getFFieldAccess().getTypeFTypeRefParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_24);
            lv_type_0_0=ruleFTypeRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFFieldRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"edu.vanderbilt.riaps.Datatypes.FTypeRef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDatatypes.g:976:3: ( ( (lv_list_1_0= '[' ) ) otherlv_2= ']' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDatatypes.g:977:4: ( (lv_list_1_0= '[' ) ) otherlv_2= ']'
                    {
                    // InternalDatatypes.g:977:4: ( (lv_list_1_0= '[' ) )
                    // InternalDatatypes.g:978:5: (lv_list_1_0= '[' )
                    {
                    // InternalDatatypes.g:978:5: (lv_list_1_0= '[' )
                    // InternalDatatypes.g:979:6: lv_list_1_0= '['
                    {
                    lv_list_1_0=(Token)match(input,28,FOLLOW_25); 

                    						newLeafNode(lv_list_1_0, grammarAccess.getFFieldAccess().getListLeftSquareBracketKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFFieldRule());
                    						}
                    						setWithLastConsumed(current, "list", true, "[");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,29,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getFFieldAccess().getRightSquareBracketKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalDatatypes.g:996:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalDatatypes.g:997:4: (lv_name_3_0= RULE_ID )
            {
            // InternalDatatypes.g:997:4: (lv_name_3_0= RULE_ID )
            // InternalDatatypes.g:998:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getFFieldAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFField"


    // $ANTLR start "ruleFBasicTypeId"
    // InternalDatatypes.g:1018:1: ruleFBasicTypeId returns [Enumerator current=null] : ( (enumLiteral_0= 'Int8' ) | (enumLiteral_1= 'UInt8' ) | (enumLiteral_2= 'Int16' ) | (enumLiteral_3= 'UInt16' ) | (enumLiteral_4= 'Int32' ) | (enumLiteral_5= 'UInt32' ) | (enumLiteral_6= 'Int64' ) | (enumLiteral_7= 'UInt64' ) | (enumLiteral_8= 'Boolean' ) | (enumLiteral_9= 'String' ) | (enumLiteral_10= 'Float' ) | (enumLiteral_11= 'Double' ) | (enumLiteral_12= 'Char' ) | (enumLiteral_13= 'ByteBuffer' ) ) ;
    public final Enumerator ruleFBasicTypeId() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;


        	enterRule();

        try {
            // InternalDatatypes.g:1024:2: ( ( (enumLiteral_0= 'Int8' ) | (enumLiteral_1= 'UInt8' ) | (enumLiteral_2= 'Int16' ) | (enumLiteral_3= 'UInt16' ) | (enumLiteral_4= 'Int32' ) | (enumLiteral_5= 'UInt32' ) | (enumLiteral_6= 'Int64' ) | (enumLiteral_7= 'UInt64' ) | (enumLiteral_8= 'Boolean' ) | (enumLiteral_9= 'String' ) | (enumLiteral_10= 'Float' ) | (enumLiteral_11= 'Double' ) | (enumLiteral_12= 'Char' ) | (enumLiteral_13= 'ByteBuffer' ) ) )
            // InternalDatatypes.g:1025:2: ( (enumLiteral_0= 'Int8' ) | (enumLiteral_1= 'UInt8' ) | (enumLiteral_2= 'Int16' ) | (enumLiteral_3= 'UInt16' ) | (enumLiteral_4= 'Int32' ) | (enumLiteral_5= 'UInt32' ) | (enumLiteral_6= 'Int64' ) | (enumLiteral_7= 'UInt64' ) | (enumLiteral_8= 'Boolean' ) | (enumLiteral_9= 'String' ) | (enumLiteral_10= 'Float' ) | (enumLiteral_11= 'Double' ) | (enumLiteral_12= 'Char' ) | (enumLiteral_13= 'ByteBuffer' ) )
            {
            // InternalDatatypes.g:1025:2: ( (enumLiteral_0= 'Int8' ) | (enumLiteral_1= 'UInt8' ) | (enumLiteral_2= 'Int16' ) | (enumLiteral_3= 'UInt16' ) | (enumLiteral_4= 'Int32' ) | (enumLiteral_5= 'UInt32' ) | (enumLiteral_6= 'Int64' ) | (enumLiteral_7= 'UInt64' ) | (enumLiteral_8= 'Boolean' ) | (enumLiteral_9= 'String' ) | (enumLiteral_10= 'Float' ) | (enumLiteral_11= 'Double' ) | (enumLiteral_12= 'Char' ) | (enumLiteral_13= 'ByteBuffer' ) )
            int alt18=14;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt18=1;
                }
                break;
            case 31:
                {
                alt18=2;
                }
                break;
            case 32:
                {
                alt18=3;
                }
                break;
            case 33:
                {
                alt18=4;
                }
                break;
            case 34:
                {
                alt18=5;
                }
                break;
            case 35:
                {
                alt18=6;
                }
                break;
            case 36:
                {
                alt18=7;
                }
                break;
            case 37:
                {
                alt18=8;
                }
                break;
            case 38:
                {
                alt18=9;
                }
                break;
            case 39:
                {
                alt18=10;
                }
                break;
            case 40:
                {
                alt18=11;
                }
                break;
            case 41:
                {
                alt18=12;
                }
                break;
            case 42:
                {
                alt18=13;
                }
                break;
            case 43:
                {
                alt18=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalDatatypes.g:1026:3: (enumLiteral_0= 'Int8' )
                    {
                    // InternalDatatypes.g:1026:3: (enumLiteral_0= 'Int8' )
                    // InternalDatatypes.g:1027:4: enumLiteral_0= 'Int8'
                    {
                    enumLiteral_0=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getInt8EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFBasicTypeIdAccess().getInt8EnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalDatatypes.g:1034:3: (enumLiteral_1= 'UInt8' )
                    {
                    // InternalDatatypes.g:1034:3: (enumLiteral_1= 'UInt8' )
                    // InternalDatatypes.g:1035:4: enumLiteral_1= 'UInt8'
                    {
                    enumLiteral_1=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getUInt8EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFBasicTypeIdAccess().getUInt8EnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalDatatypes.g:1042:3: (enumLiteral_2= 'Int16' )
                    {
                    // InternalDatatypes.g:1042:3: (enumLiteral_2= 'Int16' )
                    // InternalDatatypes.g:1043:4: enumLiteral_2= 'Int16'
                    {
                    enumLiteral_2=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getInt16EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFBasicTypeIdAccess().getInt16EnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalDatatypes.g:1050:3: (enumLiteral_3= 'UInt16' )
                    {
                    // InternalDatatypes.g:1050:3: (enumLiteral_3= 'UInt16' )
                    // InternalDatatypes.g:1051:4: enumLiteral_3= 'UInt16'
                    {
                    enumLiteral_3=(Token)match(input,33,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getUInt16EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFBasicTypeIdAccess().getUInt16EnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalDatatypes.g:1058:3: (enumLiteral_4= 'Int32' )
                    {
                    // InternalDatatypes.g:1058:3: (enumLiteral_4= 'Int32' )
                    // InternalDatatypes.g:1059:4: enumLiteral_4= 'Int32'
                    {
                    enumLiteral_4=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getInt32EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getFBasicTypeIdAccess().getInt32EnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalDatatypes.g:1066:3: (enumLiteral_5= 'UInt32' )
                    {
                    // InternalDatatypes.g:1066:3: (enumLiteral_5= 'UInt32' )
                    // InternalDatatypes.g:1067:4: enumLiteral_5= 'UInt32'
                    {
                    enumLiteral_5=(Token)match(input,35,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getUInt32EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getFBasicTypeIdAccess().getUInt32EnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalDatatypes.g:1074:3: (enumLiteral_6= 'Int64' )
                    {
                    // InternalDatatypes.g:1074:3: (enumLiteral_6= 'Int64' )
                    // InternalDatatypes.g:1075:4: enumLiteral_6= 'Int64'
                    {
                    enumLiteral_6=(Token)match(input,36,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getInt64EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getFBasicTypeIdAccess().getInt64EnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalDatatypes.g:1082:3: (enumLiteral_7= 'UInt64' )
                    {
                    // InternalDatatypes.g:1082:3: (enumLiteral_7= 'UInt64' )
                    // InternalDatatypes.g:1083:4: enumLiteral_7= 'UInt64'
                    {
                    enumLiteral_7=(Token)match(input,37,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getUInt64EnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getFBasicTypeIdAccess().getUInt64EnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalDatatypes.g:1090:3: (enumLiteral_8= 'Boolean' )
                    {
                    // InternalDatatypes.g:1090:3: (enumLiteral_8= 'Boolean' )
                    // InternalDatatypes.g:1091:4: enumLiteral_8= 'Boolean'
                    {
                    enumLiteral_8=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getBooleanEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getFBasicTypeIdAccess().getBooleanEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalDatatypes.g:1098:3: (enumLiteral_9= 'String' )
                    {
                    // InternalDatatypes.g:1098:3: (enumLiteral_9= 'String' )
                    // InternalDatatypes.g:1099:4: enumLiteral_9= 'String'
                    {
                    enumLiteral_9=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getStringEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getFBasicTypeIdAccess().getStringEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalDatatypes.g:1106:3: (enumLiteral_10= 'Float' )
                    {
                    // InternalDatatypes.g:1106:3: (enumLiteral_10= 'Float' )
                    // InternalDatatypes.g:1107:4: enumLiteral_10= 'Float'
                    {
                    enumLiteral_10=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getFloatEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getFBasicTypeIdAccess().getFloatEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalDatatypes.g:1114:3: (enumLiteral_11= 'Double' )
                    {
                    // InternalDatatypes.g:1114:3: (enumLiteral_11= 'Double' )
                    // InternalDatatypes.g:1115:4: enumLiteral_11= 'Double'
                    {
                    enumLiteral_11=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getDoubleEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getFBasicTypeIdAccess().getDoubleEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalDatatypes.g:1122:3: (enumLiteral_12= 'Char' )
                    {
                    // InternalDatatypes.g:1122:3: (enumLiteral_12= 'Char' )
                    // InternalDatatypes.g:1123:4: enumLiteral_12= 'Char'
                    {
                    enumLiteral_12=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getCharEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getFBasicTypeIdAccess().getCharEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalDatatypes.g:1130:3: (enumLiteral_13= 'ByteBuffer' )
                    {
                    // InternalDatatypes.g:1130:3: (enumLiteral_13= 'ByteBuffer' )
                    // InternalDatatypes.g:1131:4: enumLiteral_13= 'ByteBuffer'
                    {
                    enumLiteral_13=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getFBasicTypeIdAccess().getByteBufferEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getFBasicTypeIdAccess().getByteBufferEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFBasicTypeId"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000009002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004A60000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004A40000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000FFFC0040010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001040010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000FFFC0000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000000L});

}