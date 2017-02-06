package edu.vanderbilt.riaps.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import edu.vanderbilt.riaps.services.AppGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAppParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_BOOL", "RULE_INT", "RULE_DECIMAL", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'componentCollection'", "'{'", "'}'", "'application'", "'extends'", "'collocate'", "','", "';'", "'distribute'", "'import'", "'*'", "'messageCollection'", "'message'", "':'", "'key'", "'jar'", "'sharedObject'", "'file'", "'device'", "'('", "')'", "'component'", "'KB'", "'MB'", "'GB'", "'requires'", "'artifact'", "'memory'", "'storage'", "'Hz'", "'['", "'-'", "']'", "'pub'", "'sub'", "'within'", "'clt'", "'srv'", "'req'", "'months'", "'days'", "'s'", "'ms'", "'ns'", "'mus'", "'timer'", "'inside'", "'default'", "'='", "'actor'", "'local'", "'internal'", "'critical'", "'ami'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=8;
    public static final int RULE_DECIMAL=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=10;
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
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_BOOL=5;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalAppParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAppParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAppParser.tokenNames; }
    public String getGrammarFileName() { return "InternalApp.g"; }



     	private AppGrammarAccess grammarAccess;

        public InternalAppParser(TokenStream input, AppGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected AppGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalApp.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalApp.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalApp.g:65:2: iv_ruleModel= ruleModel EOF
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
    // InternalApp.g:71:1: ruleModel returns [EObject current=null] : ( () otherlv_1= 'package' ( (lv_name_2_0= ruleFQN ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_collections_4_0= ruleCollection ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_imports_3_0 = null;

        EObject lv_collections_4_0 = null;



        	enterRule();

        try {
            // InternalApp.g:77:2: ( ( () otherlv_1= 'package' ( (lv_name_2_0= ruleFQN ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_collections_4_0= ruleCollection ) )* ) )
            // InternalApp.g:78:2: ( () otherlv_1= 'package' ( (lv_name_2_0= ruleFQN ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_collections_4_0= ruleCollection ) )* )
            {
            // InternalApp.g:78:2: ( () otherlv_1= 'package' ( (lv_name_2_0= ruleFQN ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_collections_4_0= ruleCollection ) )* )
            // InternalApp.g:79:3: () otherlv_1= 'package' ( (lv_name_2_0= ruleFQN ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_collections_4_0= ruleCollection ) )*
            {
            // InternalApp.g:79:3: ()
            // InternalApp.g:80:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getModelAccess().getModelAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getModelAccess().getPackageKeyword_1());
            		
            // InternalApp.g:90:3: ( (lv_name_2_0= ruleFQN ) )
            // InternalApp.g:91:4: (lv_name_2_0= ruleFQN )
            {
            // InternalApp.g:91:4: (lv_name_2_0= ruleFQN )
            // InternalApp.g:92:5: lv_name_2_0= ruleFQN
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
            						"edu.vanderbilt.riaps.App.FQN");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:109:3: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==24) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalApp.g:110:4: (lv_imports_3_0= ruleImport )
            	    {
            	    // InternalApp.g:110:4: (lv_imports_3_0= ruleImport )
            	    // InternalApp.g:111:5: lv_imports_3_0= ruleImport
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
            	    						"edu.vanderbilt.riaps.App.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalApp.g:128:3: ( (lv_collections_4_0= ruleCollection ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15||LA2_0==18||LA2_0==26) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalApp.g:129:4: (lv_collections_4_0= ruleCollection )
            	    {
            	    // InternalApp.g:129:4: (lv_collections_4_0= ruleCollection )
            	    // InternalApp.g:130:5: lv_collections_4_0= ruleCollection
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getCollectionsCollectionParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_collections_4_0=ruleCollection();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"collections",
            	    						lv_collections_4_0,
            	    						"edu.vanderbilt.riaps.App.Collection");
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


    // $ANTLR start "entryRuleFormalDefault"
    // InternalApp.g:151:1: entryRuleFormalDefault returns [EObject current=null] : iv_ruleFormalDefault= ruleFormalDefault EOF ;
    public final EObject entryRuleFormalDefault() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormalDefault = null;


        try {
            // InternalApp.g:151:54: (iv_ruleFormalDefault= ruleFormalDefault EOF )
            // InternalApp.g:152:2: iv_ruleFormalDefault= ruleFormalDefault EOF
            {
             newCompositeNode(grammarAccess.getFormalDefaultRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFormalDefault=ruleFormalDefault();

            state._fsp--;

             current =iv_ruleFormalDefault; 
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
    // $ANTLR end "entryRuleFormalDefault"


    // $ANTLR start "ruleFormalDefault"
    // InternalApp.g:158:1: ruleFormalDefault returns [EObject current=null] : (this_StringDefault_0= ruleStringDefault | this_NumberDefault_1= ruleNumberDefault | this_BoolDefault_2= ruleBoolDefault ) ;
    public final EObject ruleFormalDefault() throws RecognitionException {
        EObject current = null;

        EObject this_StringDefault_0 = null;

        EObject this_NumberDefault_1 = null;

        EObject this_BoolDefault_2 = null;



        	enterRule();

        try {
            // InternalApp.g:164:2: ( (this_StringDefault_0= ruleStringDefault | this_NumberDefault_1= ruleNumberDefault | this_BoolDefault_2= ruleBoolDefault ) )
            // InternalApp.g:165:2: (this_StringDefault_0= ruleStringDefault | this_NumberDefault_1= ruleNumberDefault | this_BoolDefault_2= ruleBoolDefault )
            {
            // InternalApp.g:165:2: (this_StringDefault_0= ruleStringDefault | this_NumberDefault_1= ruleNumberDefault | this_BoolDefault_2= ruleBoolDefault )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt3=1;
                }
                break;
            case RULE_INT:
            case RULE_DECIMAL:
                {
                alt3=2;
                }
                break;
            case RULE_BOOL:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalApp.g:166:3: this_StringDefault_0= ruleStringDefault
                    {

                    			newCompositeNode(grammarAccess.getFormalDefaultAccess().getStringDefaultParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringDefault_0=ruleStringDefault();

                    state._fsp--;


                    			current = this_StringDefault_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalApp.g:175:3: this_NumberDefault_1= ruleNumberDefault
                    {

                    			newCompositeNode(grammarAccess.getFormalDefaultAccess().getNumberDefaultParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumberDefault_1=ruleNumberDefault();

                    state._fsp--;


                    			current = this_NumberDefault_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalApp.g:184:3: this_BoolDefault_2= ruleBoolDefault
                    {

                    			newCompositeNode(grammarAccess.getFormalDefaultAccess().getBoolDefaultParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolDefault_2=ruleBoolDefault();

                    state._fsp--;


                    			current = this_BoolDefault_2;
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
    // $ANTLR end "ruleFormalDefault"


    // $ANTLR start "entryRuleStringDefault"
    // InternalApp.g:196:1: entryRuleStringDefault returns [EObject current=null] : iv_ruleStringDefault= ruleStringDefault EOF ;
    public final EObject entryRuleStringDefault() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringDefault = null;


        try {
            // InternalApp.g:196:54: (iv_ruleStringDefault= ruleStringDefault EOF )
            // InternalApp.g:197:2: iv_ruleStringDefault= ruleStringDefault EOF
            {
             newCompositeNode(grammarAccess.getStringDefaultRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringDefault=ruleStringDefault();

            state._fsp--;

             current =iv_ruleStringDefault; 
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
    // $ANTLR end "entryRuleStringDefault"


    // $ANTLR start "ruleStringDefault"
    // InternalApp.g:203:1: ruleStringDefault returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringDefault() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalApp.g:209:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalApp.g:210:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalApp.g:210:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalApp.g:211:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalApp.g:211:3: (lv_value_0_0= RULE_STRING )
            // InternalApp.g:212:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getStringDefaultAccess().getValueSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStringDefaultRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

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
    // $ANTLR end "ruleStringDefault"


    // $ANTLR start "entryRuleNumberDefault"
    // InternalApp.g:231:1: entryRuleNumberDefault returns [EObject current=null] : iv_ruleNumberDefault= ruleNumberDefault EOF ;
    public final EObject entryRuleNumberDefault() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberDefault = null;


        try {
            // InternalApp.g:231:54: (iv_ruleNumberDefault= ruleNumberDefault EOF )
            // InternalApp.g:232:2: iv_ruleNumberDefault= ruleNumberDefault EOF
            {
             newCompositeNode(grammarAccess.getNumberDefaultRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumberDefault=ruleNumberDefault();

            state._fsp--;

             current =iv_ruleNumberDefault; 
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
    // $ANTLR end "entryRuleNumberDefault"


    // $ANTLR start "ruleNumberDefault"
    // InternalApp.g:238:1: ruleNumberDefault returns [EObject current=null] : ( (lv_value_0_0= ruleNumber ) ) ;
    public final EObject ruleNumberDefault() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalApp.g:244:2: ( ( (lv_value_0_0= ruleNumber ) ) )
            // InternalApp.g:245:2: ( (lv_value_0_0= ruleNumber ) )
            {
            // InternalApp.g:245:2: ( (lv_value_0_0= ruleNumber ) )
            // InternalApp.g:246:3: (lv_value_0_0= ruleNumber )
            {
            // InternalApp.g:246:3: (lv_value_0_0= ruleNumber )
            // InternalApp.g:247:4: lv_value_0_0= ruleNumber
            {

            				newCompositeNode(grammarAccess.getNumberDefaultAccess().getValueNumberParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleNumber();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getNumberDefaultRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"edu.vanderbilt.riaps.App.Number");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleNumberDefault"


    // $ANTLR start "entryRuleBoolDefault"
    // InternalApp.g:267:1: entryRuleBoolDefault returns [EObject current=null] : iv_ruleBoolDefault= ruleBoolDefault EOF ;
    public final EObject entryRuleBoolDefault() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolDefault = null;


        try {
            // InternalApp.g:267:52: (iv_ruleBoolDefault= ruleBoolDefault EOF )
            // InternalApp.g:268:2: iv_ruleBoolDefault= ruleBoolDefault EOF
            {
             newCompositeNode(grammarAccess.getBoolDefaultRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolDefault=ruleBoolDefault();

            state._fsp--;

             current =iv_ruleBoolDefault; 
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
    // $ANTLR end "entryRuleBoolDefault"


    // $ANTLR start "ruleBoolDefault"
    // InternalApp.g:274:1: ruleBoolDefault returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOL ) ) ;
    public final EObject ruleBoolDefault() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalApp.g:280:2: ( ( (lv_value_0_0= RULE_BOOL ) ) )
            // InternalApp.g:281:2: ( (lv_value_0_0= RULE_BOOL ) )
            {
            // InternalApp.g:281:2: ( (lv_value_0_0= RULE_BOOL ) )
            // InternalApp.g:282:3: (lv_value_0_0= RULE_BOOL )
            {
            // InternalApp.g:282:3: (lv_value_0_0= RULE_BOOL )
            // InternalApp.g:283:4: lv_value_0_0= RULE_BOOL
            {
            lv_value_0_0=(Token)match(input,RULE_BOOL,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getBoolDefaultAccess().getValueBOOLTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getBoolDefaultRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"edu.vanderbilt.riaps.App.BOOL");
            			

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
    // $ANTLR end "ruleBoolDefault"


    // $ANTLR start "entryRuleNumber"
    // InternalApp.g:302:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalApp.g:304:2: (iv_ruleNumber= ruleNumber EOF )
            // InternalApp.g:305:2: iv_ruleNumber= ruleNumber EOF
            {
             newCompositeNode(grammarAccess.getNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;

             current =iv_ruleNumber.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // InternalApp.g:314:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT | this_DECIMAL_1= RULE_DECIMAL ) (kw= '.' (this_INT_3= RULE_INT | this_DECIMAL_4= RULE_DECIMAL ) )? ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_DECIMAL_1=null;
        Token kw=null;
        Token this_INT_3=null;
        Token this_DECIMAL_4=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalApp.g:321:2: ( ( (this_INT_0= RULE_INT | this_DECIMAL_1= RULE_DECIMAL ) (kw= '.' (this_INT_3= RULE_INT | this_DECIMAL_4= RULE_DECIMAL ) )? ) )
            // InternalApp.g:322:2: ( (this_INT_0= RULE_INT | this_DECIMAL_1= RULE_DECIMAL ) (kw= '.' (this_INT_3= RULE_INT | this_DECIMAL_4= RULE_DECIMAL ) )? )
            {
            // InternalApp.g:322:2: ( (this_INT_0= RULE_INT | this_DECIMAL_1= RULE_DECIMAL ) (kw= '.' (this_INT_3= RULE_INT | this_DECIMAL_4= RULE_DECIMAL ) )? )
            // InternalApp.g:323:3: (this_INT_0= RULE_INT | this_DECIMAL_1= RULE_DECIMAL ) (kw= '.' (this_INT_3= RULE_INT | this_DECIMAL_4= RULE_DECIMAL ) )?
            {
            // InternalApp.g:323:3: (this_INT_0= RULE_INT | this_DECIMAL_1= RULE_DECIMAL )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_INT) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_DECIMAL) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalApp.g:324:4: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_6); 

                    				current.merge(this_INT_0);
                    			

                    				newLeafNode(this_INT_0, grammarAccess.getNumberAccess().getINTTerminalRuleCall_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalApp.g:332:4: this_DECIMAL_1= RULE_DECIMAL
                    {
                    this_DECIMAL_1=(Token)match(input,RULE_DECIMAL,FOLLOW_6); 

                    				current.merge(this_DECIMAL_1);
                    			

                    				newLeafNode(this_DECIMAL_1, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_0_1());
                    			

                    }
                    break;

            }

            // InternalApp.g:340:3: (kw= '.' (this_INT_3= RULE_INT | this_DECIMAL_4= RULE_DECIMAL ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalApp.g:341:4: kw= '.' (this_INT_3= RULE_INT | this_DECIMAL_4= RULE_DECIMAL )
                    {
                    kw=(Token)match(input,14,FOLLOW_7); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_0());
                    			
                    // InternalApp.g:346:4: (this_INT_3= RULE_INT | this_DECIMAL_4= RULE_DECIMAL )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==RULE_INT) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==RULE_DECIMAL) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // InternalApp.g:347:5: this_INT_3= RULE_INT
                            {
                            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); 

                            					current.merge(this_INT_3);
                            				

                            					newLeafNode(this_INT_3, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalApp.g:355:5: this_DECIMAL_4= RULE_DECIMAL
                            {
                            this_DECIMAL_4=(Token)match(input,RULE_DECIMAL,FOLLOW_2); 

                            					current.merge(this_DECIMAL_4);
                            				

                            					newLeafNode(this_DECIMAL_4, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_1_1());
                            				

                            }
                            break;

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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleCollection"
    // InternalApp.g:371:1: entryRuleCollection returns [EObject current=null] : iv_ruleCollection= ruleCollection EOF ;
    public final EObject entryRuleCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollection = null;


        try {
            // InternalApp.g:371:51: (iv_ruleCollection= ruleCollection EOF )
            // InternalApp.g:372:2: iv_ruleCollection= ruleCollection EOF
            {
             newCompositeNode(grammarAccess.getCollectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCollection=ruleCollection();

            state._fsp--;

             current =iv_ruleCollection; 
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
    // $ANTLR end "entryRuleCollection"


    // $ANTLR start "ruleCollection"
    // InternalApp.g:378:1: ruleCollection returns [EObject current=null] : (this_MessageCollection_0= ruleMessageCollection | this_ComponentCollection_1= ruleComponentCollection | this_Application_2= ruleApplication ) ;
    public final EObject ruleCollection() throws RecognitionException {
        EObject current = null;

        EObject this_MessageCollection_0 = null;

        EObject this_ComponentCollection_1 = null;

        EObject this_Application_2 = null;



        	enterRule();

        try {
            // InternalApp.g:384:2: ( (this_MessageCollection_0= ruleMessageCollection | this_ComponentCollection_1= ruleComponentCollection | this_Application_2= ruleApplication ) )
            // InternalApp.g:385:2: (this_MessageCollection_0= ruleMessageCollection | this_ComponentCollection_1= ruleComponentCollection | this_Application_2= ruleApplication )
            {
            // InternalApp.g:385:2: (this_MessageCollection_0= ruleMessageCollection | this_ComponentCollection_1= ruleComponentCollection | this_Application_2= ruleApplication )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt7=1;
                }
                break;
            case 15:
                {
                alt7=2;
                }
                break;
            case 18:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalApp.g:386:3: this_MessageCollection_0= ruleMessageCollection
                    {

                    			newCompositeNode(grammarAccess.getCollectionAccess().getMessageCollectionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_MessageCollection_0=ruleMessageCollection();

                    state._fsp--;


                    			current = this_MessageCollection_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalApp.g:395:3: this_ComponentCollection_1= ruleComponentCollection
                    {

                    			newCompositeNode(grammarAccess.getCollectionAccess().getComponentCollectionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ComponentCollection_1=ruleComponentCollection();

                    state._fsp--;


                    			current = this_ComponentCollection_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalApp.g:404:3: this_Application_2= ruleApplication
                    {

                    			newCompositeNode(grammarAccess.getCollectionAccess().getApplicationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Application_2=ruleApplication();

                    state._fsp--;


                    			current = this_Application_2;
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
    // $ANTLR end "ruleCollection"


    // $ANTLR start "entryRuleComponentCollection"
    // InternalApp.g:416:1: entryRuleComponentCollection returns [EObject current=null] : iv_ruleComponentCollection= ruleComponentCollection EOF ;
    public final EObject entryRuleComponentCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentCollection = null;


        try {
            // InternalApp.g:416:60: (iv_ruleComponentCollection= ruleComponentCollection EOF )
            // InternalApp.g:417:2: iv_ruleComponentCollection= ruleComponentCollection EOF
            {
             newCompositeNode(grammarAccess.getComponentCollectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentCollection=ruleComponentCollection();

            state._fsp--;

             current =iv_ruleComponentCollection; 
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
    // $ANTLR end "entryRuleComponentCollection"


    // $ANTLR start "ruleComponentCollection"
    // InternalApp.g:423:1: ruleComponentCollection returns [EObject current=null] : ( () otherlv_1= 'componentCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_components_4_0= ruleComponent ) )* otherlv_5= '}' ) ;
    public final EObject ruleComponentCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_components_4_0 = null;



        	enterRule();

        try {
            // InternalApp.g:429:2: ( ( () otherlv_1= 'componentCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_components_4_0= ruleComponent ) )* otherlv_5= '}' ) )
            // InternalApp.g:430:2: ( () otherlv_1= 'componentCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_components_4_0= ruleComponent ) )* otherlv_5= '}' )
            {
            // InternalApp.g:430:2: ( () otherlv_1= 'componentCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_components_4_0= ruleComponent ) )* otherlv_5= '}' )
            // InternalApp.g:431:3: () otherlv_1= 'componentCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_components_4_0= ruleComponent ) )* otherlv_5= '}'
            {
            // InternalApp.g:431:3: ()
            // InternalApp.g:432:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getComponentCollectionAccess().getComponentCollectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getComponentCollectionAccess().getComponentCollectionKeyword_1());
            		
            // InternalApp.g:442:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalApp.g:443:4: (lv_name_2_0= RULE_ID )
            {
            // InternalApp.g:443:4: (lv_name_2_0= RULE_ID )
            // InternalApp.g:444:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_2_0, grammarAccess.getComponentCollectionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentCollectionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getComponentCollectionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalApp.g:464:3: ( (lv_components_4_0= ruleComponent ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==33||LA8_0==36) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalApp.g:465:4: (lv_components_4_0= ruleComponent )
            	    {
            	    // InternalApp.g:465:4: (lv_components_4_0= ruleComponent )
            	    // InternalApp.g:466:5: lv_components_4_0= ruleComponent
            	    {

            	    					newCompositeNode(grammarAccess.getComponentCollectionAccess().getComponentsComponentParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_components_4_0=ruleComponent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getComponentCollectionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"components",
            	    						lv_components_4_0,
            	    						"edu.vanderbilt.riaps.App.Component");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_5=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getComponentCollectionAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleComponentCollection"


    // $ANTLR start "entryRuleApplication"
    // InternalApp.g:491:1: entryRuleApplication returns [EObject current=null] : iv_ruleApplication= ruleApplication EOF ;
    public final EObject entryRuleApplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplication = null;


        try {
            // InternalApp.g:491:52: (iv_ruleApplication= ruleApplication EOF )
            // InternalApp.g:492:2: iv_ruleApplication= ruleApplication EOF
            {
             newCompositeNode(grammarAccess.getApplicationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleApplication=ruleApplication();

            state._fsp--;

             current =iv_ruleApplication; 
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
    // $ANTLR end "entryRuleApplication"


    // $ANTLR start "ruleApplication"
    // InternalApp.g:498:1: ruleApplication returns [EObject current=null] : ( () otherlv_1= 'application' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_artifacts_6_0= ruleArtifact ) ) | ( (lv_actors_7_0= ruleActor ) ) | ( (lv_components_8_0= ruleComponent ) ) | ( (lv_messages_9_0= ruleMessage ) ) )* ( (lv_deploymentConstraints_10_0= ruleDeploymentConstraint ) )* otherlv_11= '}' ) ;
    public final EObject ruleApplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_11=null;
        EObject lv_artifacts_6_0 = null;

        EObject lv_actors_7_0 = null;

        EObject lv_components_8_0 = null;

        EObject lv_messages_9_0 = null;

        EObject lv_deploymentConstraints_10_0 = null;



        	enterRule();

        try {
            // InternalApp.g:504:2: ( ( () otherlv_1= 'application' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_artifacts_6_0= ruleArtifact ) ) | ( (lv_actors_7_0= ruleActor ) ) | ( (lv_components_8_0= ruleComponent ) ) | ( (lv_messages_9_0= ruleMessage ) ) )* ( (lv_deploymentConstraints_10_0= ruleDeploymentConstraint ) )* otherlv_11= '}' ) )
            // InternalApp.g:505:2: ( () otherlv_1= 'application' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_artifacts_6_0= ruleArtifact ) ) | ( (lv_actors_7_0= ruleActor ) ) | ( (lv_components_8_0= ruleComponent ) ) | ( (lv_messages_9_0= ruleMessage ) ) )* ( (lv_deploymentConstraints_10_0= ruleDeploymentConstraint ) )* otherlv_11= '}' )
            {
            // InternalApp.g:505:2: ( () otherlv_1= 'application' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_artifacts_6_0= ruleArtifact ) ) | ( (lv_actors_7_0= ruleActor ) ) | ( (lv_components_8_0= ruleComponent ) ) | ( (lv_messages_9_0= ruleMessage ) ) )* ( (lv_deploymentConstraints_10_0= ruleDeploymentConstraint ) )* otherlv_11= '}' )
            // InternalApp.g:506:3: () otherlv_1= 'application' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_artifacts_6_0= ruleArtifact ) ) | ( (lv_actors_7_0= ruleActor ) ) | ( (lv_components_8_0= ruleComponent ) ) | ( (lv_messages_9_0= ruleMessage ) ) )* ( (lv_deploymentConstraints_10_0= ruleDeploymentConstraint ) )* otherlv_11= '}'
            {
            // InternalApp.g:506:3: ()
            // InternalApp.g:507:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getApplicationAccess().getApplicationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getApplicationAccess().getApplicationKeyword_1());
            		
            // InternalApp.g:517:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalApp.g:518:4: (lv_name_2_0= RULE_ID )
            {
            // InternalApp.g:518:4: (lv_name_2_0= RULE_ID )
            // InternalApp.g:519:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getApplicationAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getApplicationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalApp.g:535:3: (otherlv_3= 'extends' ( ( ruleFQN ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalApp.g:536:4: otherlv_3= 'extends' ( ( ruleFQN ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getApplicationAccess().getExtendsKeyword_3_0());
                    			
                    // InternalApp.g:540:4: ( ( ruleFQN ) )
                    // InternalApp.g:541:5: ( ruleFQN )
                    {
                    // InternalApp.g:541:5: ( ruleFQN )
                    // InternalApp.g:542:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getApplicationRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getApplicationAccess().getBaseappApplicationCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_5, grammarAccess.getApplicationAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalApp.g:561:3: ( ( (lv_artifacts_6_0= ruleArtifact ) ) | ( (lv_actors_7_0= ruleActor ) ) | ( (lv_components_8_0= ruleComponent ) ) | ( (lv_messages_9_0= ruleMessage ) ) )*
            loop10:
            do {
                int alt10=5;
                switch ( input.LA(1) ) {
                case 30:
                case 31:
                case 32:
                    {
                    alt10=1;
                    }
                    break;
                case 64:
                    {
                    alt10=2;
                    }
                    break;
                case 33:
                case 36:
                    {
                    alt10=3;
                    }
                    break;
                case 27:
                    {
                    alt10=4;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // InternalApp.g:562:4: ( (lv_artifacts_6_0= ruleArtifact ) )
            	    {
            	    // InternalApp.g:562:4: ( (lv_artifacts_6_0= ruleArtifact ) )
            	    // InternalApp.g:563:5: (lv_artifacts_6_0= ruleArtifact )
            	    {
            	    // InternalApp.g:563:5: (lv_artifacts_6_0= ruleArtifact )
            	    // InternalApp.g:564:6: lv_artifacts_6_0= ruleArtifact
            	    {

            	    						newCompositeNode(grammarAccess.getApplicationAccess().getArtifactsArtifactParserRuleCall_5_0_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_artifacts_6_0=ruleArtifact();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getApplicationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"artifacts",
            	    							lv_artifacts_6_0,
            	    							"edu.vanderbilt.riaps.App.Artifact");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalApp.g:582:4: ( (lv_actors_7_0= ruleActor ) )
            	    {
            	    // InternalApp.g:582:4: ( (lv_actors_7_0= ruleActor ) )
            	    // InternalApp.g:583:5: (lv_actors_7_0= ruleActor )
            	    {
            	    // InternalApp.g:583:5: (lv_actors_7_0= ruleActor )
            	    // InternalApp.g:584:6: lv_actors_7_0= ruleActor
            	    {

            	    						newCompositeNode(grammarAccess.getApplicationAccess().getActorsActorParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_actors_7_0=ruleActor();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getApplicationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"actors",
            	    							lv_actors_7_0,
            	    							"edu.vanderbilt.riaps.App.Actor");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalApp.g:602:4: ( (lv_components_8_0= ruleComponent ) )
            	    {
            	    // InternalApp.g:602:4: ( (lv_components_8_0= ruleComponent ) )
            	    // InternalApp.g:603:5: (lv_components_8_0= ruleComponent )
            	    {
            	    // InternalApp.g:603:5: (lv_components_8_0= ruleComponent )
            	    // InternalApp.g:604:6: lv_components_8_0= ruleComponent
            	    {

            	    						newCompositeNode(grammarAccess.getApplicationAccess().getComponentsComponentParserRuleCall_5_2_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_components_8_0=ruleComponent();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getApplicationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"components",
            	    							lv_components_8_0,
            	    							"edu.vanderbilt.riaps.App.Component");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalApp.g:622:4: ( (lv_messages_9_0= ruleMessage ) )
            	    {
            	    // InternalApp.g:622:4: ( (lv_messages_9_0= ruleMessage ) )
            	    // InternalApp.g:623:5: (lv_messages_9_0= ruleMessage )
            	    {
            	    // InternalApp.g:623:5: (lv_messages_9_0= ruleMessage )
            	    // InternalApp.g:624:6: lv_messages_9_0= ruleMessage
            	    {

            	    						newCompositeNode(grammarAccess.getApplicationAccess().getMessagesMessageParserRuleCall_5_3_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_messages_9_0=ruleMessage();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getApplicationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"messages",
            	    							lv_messages_9_0,
            	    							"edu.vanderbilt.riaps.App.Message");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalApp.g:642:3: ( (lv_deploymentConstraints_10_0= ruleDeploymentConstraint ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==20||LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalApp.g:643:4: (lv_deploymentConstraints_10_0= ruleDeploymentConstraint )
            	    {
            	    // InternalApp.g:643:4: (lv_deploymentConstraints_10_0= ruleDeploymentConstraint )
            	    // InternalApp.g:644:5: lv_deploymentConstraints_10_0= ruleDeploymentConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getApplicationAccess().getDeploymentConstraintsDeploymentConstraintParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_deploymentConstraints_10_0=ruleDeploymentConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getApplicationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"deploymentConstraints",
            	    						lv_deploymentConstraints_10_0,
            	    						"edu.vanderbilt.riaps.App.DeploymentConstraint");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_11=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getApplicationAccess().getRightCurlyBracketKeyword_7());
            		

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
    // $ANTLR end "ruleApplication"


    // $ANTLR start "entryRuleDeploymentConstraint"
    // InternalApp.g:669:1: entryRuleDeploymentConstraint returns [EObject current=null] : iv_ruleDeploymentConstraint= ruleDeploymentConstraint EOF ;
    public final EObject entryRuleDeploymentConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeploymentConstraint = null;


        try {
            // InternalApp.g:669:61: (iv_ruleDeploymentConstraint= ruleDeploymentConstraint EOF )
            // InternalApp.g:670:2: iv_ruleDeploymentConstraint= ruleDeploymentConstraint EOF
            {
             newCompositeNode(grammarAccess.getDeploymentConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeploymentConstraint=ruleDeploymentConstraint();

            state._fsp--;

             current =iv_ruleDeploymentConstraint; 
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
    // $ANTLR end "entryRuleDeploymentConstraint"


    // $ANTLR start "ruleDeploymentConstraint"
    // InternalApp.g:676:1: ruleDeploymentConstraint returns [EObject current=null] : (this_CollocateConstraint_0= ruleCollocateConstraint | this_DistributeConstraint_1= ruleDistributeConstraint ) ;
    public final EObject ruleDeploymentConstraint() throws RecognitionException {
        EObject current = null;

        EObject this_CollocateConstraint_0 = null;

        EObject this_DistributeConstraint_1 = null;



        	enterRule();

        try {
            // InternalApp.g:682:2: ( (this_CollocateConstraint_0= ruleCollocateConstraint | this_DistributeConstraint_1= ruleDistributeConstraint ) )
            // InternalApp.g:683:2: (this_CollocateConstraint_0= ruleCollocateConstraint | this_DistributeConstraint_1= ruleDistributeConstraint )
            {
            // InternalApp.g:683:2: (this_CollocateConstraint_0= ruleCollocateConstraint | this_DistributeConstraint_1= ruleDistributeConstraint )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            else if ( (LA12_0==23) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalApp.g:684:3: this_CollocateConstraint_0= ruleCollocateConstraint
                    {

                    			newCompositeNode(grammarAccess.getDeploymentConstraintAccess().getCollocateConstraintParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_CollocateConstraint_0=ruleCollocateConstraint();

                    state._fsp--;


                    			current = this_CollocateConstraint_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalApp.g:693:3: this_DistributeConstraint_1= ruleDistributeConstraint
                    {

                    			newCompositeNode(grammarAccess.getDeploymentConstraintAccess().getDistributeConstraintParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_DistributeConstraint_1=ruleDistributeConstraint();

                    state._fsp--;


                    			current = this_DistributeConstraint_1;
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
    // $ANTLR end "ruleDeploymentConstraint"


    // $ANTLR start "entryRuleCollocateConstraint"
    // InternalApp.g:705:1: entryRuleCollocateConstraint returns [EObject current=null] : iv_ruleCollocateConstraint= ruleCollocateConstraint EOF ;
    public final EObject entryRuleCollocateConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollocateConstraint = null;


        try {
            // InternalApp.g:705:60: (iv_ruleCollocateConstraint= ruleCollocateConstraint EOF )
            // InternalApp.g:706:2: iv_ruleCollocateConstraint= ruleCollocateConstraint EOF
            {
             newCompositeNode(grammarAccess.getCollocateConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCollocateConstraint=ruleCollocateConstraint();

            state._fsp--;

             current =iv_ruleCollocateConstraint; 
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
    // $ANTLR end "entryRuleCollocateConstraint"


    // $ANTLR start "ruleCollocateConstraint"
    // InternalApp.g:712:1: ruleCollocateConstraint returns [EObject current=null] : (otherlv_0= 'collocate' ( ( ruleFQN ) ) otherlv_2= ',' ( ( ruleFQN ) ) (otherlv_4= ',' ( ( ruleFQN ) ) )* (otherlv_6= ';' )? ) ;
    public final EObject ruleCollocateConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalApp.g:718:2: ( (otherlv_0= 'collocate' ( ( ruleFQN ) ) otherlv_2= ',' ( ( ruleFQN ) ) (otherlv_4= ',' ( ( ruleFQN ) ) )* (otherlv_6= ';' )? ) )
            // InternalApp.g:719:2: (otherlv_0= 'collocate' ( ( ruleFQN ) ) otherlv_2= ',' ( ( ruleFQN ) ) (otherlv_4= ',' ( ( ruleFQN ) ) )* (otherlv_6= ';' )? )
            {
            // InternalApp.g:719:2: (otherlv_0= 'collocate' ( ( ruleFQN ) ) otherlv_2= ',' ( ( ruleFQN ) ) (otherlv_4= ',' ( ( ruleFQN ) ) )* (otherlv_6= ';' )? )
            // InternalApp.g:720:3: otherlv_0= 'collocate' ( ( ruleFQN ) ) otherlv_2= ',' ( ( ruleFQN ) ) (otherlv_4= ',' ( ( ruleFQN ) ) )* (otherlv_6= ';' )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCollocateConstraintAccess().getCollocateKeyword_0());
            		
            // InternalApp.g:724:3: ( ( ruleFQN ) )
            // InternalApp.g:725:4: ( ruleFQN )
            {
            // InternalApp.g:725:4: ( ruleFQN )
            // InternalApp.g:726:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCollocateConstraintRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCollocateConstraintAccess().getActorcollocatelistActorCrossReference_1_0());
            				
            pushFollow(FOLLOW_13);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getCollocateConstraintAccess().getCommaKeyword_2());
            		
            // InternalApp.g:744:3: ( ( ruleFQN ) )
            // InternalApp.g:745:4: ( ruleFQN )
            {
            // InternalApp.g:745:4: ( ruleFQN )
            // InternalApp.g:746:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCollocateConstraintRule());
            					}
            				

            					newCompositeNode(grammarAccess.getCollocateConstraintAccess().getActorcollocatelistActorCrossReference_3_0());
            				
            pushFollow(FOLLOW_14);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:760:3: (otherlv_4= ',' ( ( ruleFQN ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==21) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalApp.g:761:4: otherlv_4= ',' ( ( ruleFQN ) )
            	    {
            	    otherlv_4=(Token)match(input,21,FOLLOW_3); 

            	    				newLeafNode(otherlv_4, grammarAccess.getCollocateConstraintAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalApp.g:765:4: ( ( ruleFQN ) )
            	    // InternalApp.g:766:5: ( ruleFQN )
            	    {
            	    // InternalApp.g:766:5: ( ruleFQN )
            	    // InternalApp.g:767:6: ruleFQN
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getCollocateConstraintRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getCollocateConstraintAccess().getActorcollocatelistActorCrossReference_4_1_0());
            	    					
            	    pushFollow(FOLLOW_14);
            	    ruleFQN();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalApp.g:782:3: (otherlv_6= ';' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalApp.g:783:4: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getCollocateConstraintAccess().getSemicolonKeyword_5());
                    			

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
    // $ANTLR end "ruleCollocateConstraint"


    // $ANTLR start "entryRuleDistributeConstraint"
    // InternalApp.g:792:1: entryRuleDistributeConstraint returns [EObject current=null] : iv_ruleDistributeConstraint= ruleDistributeConstraint EOF ;
    public final EObject entryRuleDistributeConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDistributeConstraint = null;


        try {
            // InternalApp.g:792:61: (iv_ruleDistributeConstraint= ruleDistributeConstraint EOF )
            // InternalApp.g:793:2: iv_ruleDistributeConstraint= ruleDistributeConstraint EOF
            {
             newCompositeNode(grammarAccess.getDistributeConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDistributeConstraint=ruleDistributeConstraint();

            state._fsp--;

             current =iv_ruleDistributeConstraint; 
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
    // $ANTLR end "entryRuleDistributeConstraint"


    // $ANTLR start "ruleDistributeConstraint"
    // InternalApp.g:799:1: ruleDistributeConstraint returns [EObject current=null] : (otherlv_0= 'distribute' ( ( ruleFQN ) ) otherlv_2= ',' ( ( ruleFQN ) ) (otherlv_4= ',' ( ( ruleFQN ) ) )* (otherlv_6= ';' )? ) ;
    public final EObject ruleDistributeConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalApp.g:805:2: ( (otherlv_0= 'distribute' ( ( ruleFQN ) ) otherlv_2= ',' ( ( ruleFQN ) ) (otherlv_4= ',' ( ( ruleFQN ) ) )* (otherlv_6= ';' )? ) )
            // InternalApp.g:806:2: (otherlv_0= 'distribute' ( ( ruleFQN ) ) otherlv_2= ',' ( ( ruleFQN ) ) (otherlv_4= ',' ( ( ruleFQN ) ) )* (otherlv_6= ';' )? )
            {
            // InternalApp.g:806:2: (otherlv_0= 'distribute' ( ( ruleFQN ) ) otherlv_2= ',' ( ( ruleFQN ) ) (otherlv_4= ',' ( ( ruleFQN ) ) )* (otherlv_6= ';' )? )
            // InternalApp.g:807:3: otherlv_0= 'distribute' ( ( ruleFQN ) ) otherlv_2= ',' ( ( ruleFQN ) ) (otherlv_4= ',' ( ( ruleFQN ) ) )* (otherlv_6= ';' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDistributeConstraintAccess().getDistributeKeyword_0());
            		
            // InternalApp.g:811:3: ( ( ruleFQN ) )
            // InternalApp.g:812:4: ( ruleFQN )
            {
            // InternalApp.g:812:4: ( ruleFQN )
            // InternalApp.g:813:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDistributeConstraintRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDistributeConstraintAccess().getActordistributelistActorCrossReference_1_0());
            				
            pushFollow(FOLLOW_13);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getDistributeConstraintAccess().getCommaKeyword_2());
            		
            // InternalApp.g:831:3: ( ( ruleFQN ) )
            // InternalApp.g:832:4: ( ruleFQN )
            {
            // InternalApp.g:832:4: ( ruleFQN )
            // InternalApp.g:833:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDistributeConstraintRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDistributeConstraintAccess().getActordistributelistActorCrossReference_3_0());
            				
            pushFollow(FOLLOW_14);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:847:3: (otherlv_4= ',' ( ( ruleFQN ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==21) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalApp.g:848:4: otherlv_4= ',' ( ( ruleFQN ) )
            	    {
            	    otherlv_4=(Token)match(input,21,FOLLOW_3); 

            	    				newLeafNode(otherlv_4, grammarAccess.getDistributeConstraintAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalApp.g:852:4: ( ( ruleFQN ) )
            	    // InternalApp.g:853:5: ( ruleFQN )
            	    {
            	    // InternalApp.g:853:5: ( ruleFQN )
            	    // InternalApp.g:854:6: ruleFQN
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getDistributeConstraintRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getDistributeConstraintAccess().getActordistributelistActorCrossReference_4_1_0());
            	    					
            	    pushFollow(FOLLOW_14);
            	    ruleFQN();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // InternalApp.g:869:3: (otherlv_6= ';' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==22) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalApp.g:870:4: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getDistributeConstraintAccess().getSemicolonKeyword_5());
                    			

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
    // $ANTLR end "ruleDistributeConstraint"


    // $ANTLR start "entryRuleImport"
    // InternalApp.g:879:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalApp.g:879:47: (iv_ruleImport= ruleImport EOF )
            // InternalApp.g:880:2: iv_ruleImport= ruleImport EOF
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
    // InternalApp.g:886:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;



        	enterRule();

        try {
            // InternalApp.g:892:2: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) )
            // InternalApp.g:893:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            {
            // InternalApp.g:893:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            // InternalApp.g:894:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalApp.g:898:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            // InternalApp.g:899:4: (lv_importedNamespace_1_0= ruleImportedFQN )
            {
            // InternalApp.g:899:4: (lv_importedNamespace_1_0= ruleImportedFQN )
            // InternalApp.g:900:5: lv_importedNamespace_1_0= ruleImportedFQN
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
            						"edu.vanderbilt.riaps.App.ImportedFQN");
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
    // InternalApp.g:921:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalApp.g:921:51: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalApp.g:922:2: iv_ruleImportedFQN= ruleImportedFQN EOF
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
    // InternalApp.g:928:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;



        	enterRule();

        try {
            // InternalApp.g:934:2: ( (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) )
            // InternalApp.g:935:2: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            {
            // InternalApp.g:935:2: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            // InternalApp.g:936:3: this_FQN_0= ruleFQN (kw= '.' kw= '*' )?
            {

            			newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0());
            		
            pushFollow(FOLLOW_6);
            this_FQN_0=ruleFQN();

            state._fsp--;


            			current.merge(this_FQN_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalApp.g:946:3: (kw= '.' kw= '*' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalApp.g:947:4: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,14,FOLLOW_15); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getImportedFQNAccess().getFullStopKeyword_1_0());
                    			
                    kw=(Token)match(input,25,FOLLOW_2); 

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
    // InternalApp.g:962:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalApp.g:962:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalApp.g:963:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalApp.g:969:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalApp.g:975:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalApp.g:976:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalApp.g:976:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalApp.g:977:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
            		
            // InternalApp.g:984:3: (kw= '.' this_ID_2= RULE_ID )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==14) ) {
                    int LA18_2 = input.LA(2);

                    if ( (LA18_2==RULE_ID) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // InternalApp.g:985:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,14,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_6); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop18;
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


    // $ANTLR start "entryRuleMessageCollection"
    // InternalApp.g:1002:1: entryRuleMessageCollection returns [EObject current=null] : iv_ruleMessageCollection= ruleMessageCollection EOF ;
    public final EObject entryRuleMessageCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageCollection = null;


        try {
            // InternalApp.g:1002:58: (iv_ruleMessageCollection= ruleMessageCollection EOF )
            // InternalApp.g:1003:2: iv_ruleMessageCollection= ruleMessageCollection EOF
            {
             newCompositeNode(grammarAccess.getMessageCollectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessageCollection=ruleMessageCollection();

            state._fsp--;

             current =iv_ruleMessageCollection; 
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
    // $ANTLR end "entryRuleMessageCollection"


    // $ANTLR start "ruleMessageCollection"
    // InternalApp.g:1009:1: ruleMessageCollection returns [EObject current=null] : ( () otherlv_1= 'messageCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}' ) ;
    public final EObject ruleMessageCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_messages_4_0 = null;



        	enterRule();

        try {
            // InternalApp.g:1015:2: ( ( () otherlv_1= 'messageCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}' ) )
            // InternalApp.g:1016:2: ( () otherlv_1= 'messageCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}' )
            {
            // InternalApp.g:1016:2: ( () otherlv_1= 'messageCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}' )
            // InternalApp.g:1017:3: () otherlv_1= 'messageCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}'
            {
            // InternalApp.g:1017:3: ()
            // InternalApp.g:1018:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMessageCollectionAccess().getMessageCollectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getMessageCollectionAccess().getMessageCollectionKeyword_1());
            		
            // InternalApp.g:1028:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalApp.g:1029:4: (lv_name_2_0= RULE_ID )
            {
            // InternalApp.g:1029:4: (lv_name_2_0= RULE_ID )
            // InternalApp.g:1030:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_2_0, grammarAccess.getMessageCollectionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMessageCollectionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_16); 

            			newLeafNode(otherlv_3, grammarAccess.getMessageCollectionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalApp.g:1050:3: ( (lv_messages_4_0= ruleMessage ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==27) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalApp.g:1051:4: (lv_messages_4_0= ruleMessage )
            	    {
            	    // InternalApp.g:1051:4: (lv_messages_4_0= ruleMessage )
            	    // InternalApp.g:1052:5: lv_messages_4_0= ruleMessage
            	    {

            	    					newCompositeNode(grammarAccess.getMessageCollectionAccess().getMessagesMessageParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_messages_4_0=ruleMessage();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMessageCollectionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"messages",
            	    						lv_messages_4_0,
            	    						"edu.vanderbilt.riaps.App.Message");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_5=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getMessageCollectionAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleMessageCollection"


    // $ANTLR start "entryRuleMessage"
    // InternalApp.g:1077:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalApp.g:1077:48: (iv_ruleMessage= ruleMessage EOF )
            // InternalApp.g:1078:2: iv_ruleMessage= ruleMessage EOF
            {
             newCompositeNode(grammarAccess.getMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessage=ruleMessage();

            state._fsp--;

             current =iv_ruleMessage; 
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
    // $ANTLR end "entryRuleMessage"


    // $ANTLR start "ruleMessage"
    // InternalApp.g:1084:1: ruleMessage returns [EObject current=null] : (otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= 'key' ( ( ruleFQN ) ) )? (otherlv_6= ';' )? ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalApp.g:1090:2: ( (otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= 'key' ( ( ruleFQN ) ) )? (otherlv_6= ';' )? ) )
            // InternalApp.g:1091:2: (otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= 'key' ( ( ruleFQN ) ) )? (otherlv_6= ';' )? )
            {
            // InternalApp.g:1091:2: (otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= 'key' ( ( ruleFQN ) ) )? (otherlv_6= ';' )? )
            // InternalApp.g:1092:3: otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= 'key' ( ( ruleFQN ) ) )? (otherlv_6= ';' )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMessageAccess().getMessageKeyword_0());
            		
            // InternalApp.g:1096:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:1097:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:1097:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:1098:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_1_0, grammarAccess.getMessageAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getMessageAccess().getColonKeyword_2());
            		
            // InternalApp.g:1118:3: ( ( ruleFQN ) )
            // InternalApp.g:1119:4: ( ruleFQN )
            {
            // InternalApp.g:1119:4: ( ruleFQN )
            // InternalApp.g:1120:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMessageRule());
            					}
            				

            					newCompositeNode(grammarAccess.getMessageAccess().getTypeFStructTypeCrossReference_3_0());
            				
            pushFollow(FOLLOW_18);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:1134:3: (otherlv_4= 'key' ( ( ruleFQN ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalApp.g:1135:4: otherlv_4= 'key' ( ( ruleFQN ) )
                    {
                    otherlv_4=(Token)match(input,29,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getMessageAccess().getKeyKeyword_4_0());
                    			
                    // InternalApp.g:1139:4: ( ( ruleFQN ) )
                    // InternalApp.g:1140:5: ( ruleFQN )
                    {
                    // InternalApp.g:1140:5: ( ruleFQN )
                    // InternalApp.g:1141:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMessageRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getMessageAccess().getKeyFFieldCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_19);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalApp.g:1156:3: (otherlv_6= ';' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==22) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalApp.g:1157:4: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getMessageAccess().getSemicolonKeyword_5());
                    			

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
    // $ANTLR end "ruleMessage"


    // $ANTLR start "entryRuleArtifact"
    // InternalApp.g:1166:1: entryRuleArtifact returns [EObject current=null] : iv_ruleArtifact= ruleArtifact EOF ;
    public final EObject entryRuleArtifact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArtifact = null;


        try {
            // InternalApp.g:1166:49: (iv_ruleArtifact= ruleArtifact EOF )
            // InternalApp.g:1167:2: iv_ruleArtifact= ruleArtifact EOF
            {
             newCompositeNode(grammarAccess.getArtifactRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArtifact=ruleArtifact();

            state._fsp--;

             current =iv_ruleArtifact; 
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
    // $ANTLR end "entryRuleArtifact"


    // $ANTLR start "ruleArtifact"
    // InternalApp.g:1173:1: ruleArtifact returns [EObject current=null] : ( ( ( (lv_jar_0_0= 'jar' ) ) | ( (lv_sharedObject_1_0= 'sharedObject' ) ) | ( (lv_configurationFile_2_0= 'file' ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_path_5_0= RULE_STRING ) ) (otherlv_6= ';' )? ) ;
    public final EObject ruleArtifact() throws RecognitionException {
        EObject current = null;

        Token lv_jar_0_0=null;
        Token lv_sharedObject_1_0=null;
        Token lv_configurationFile_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_path_5_0=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalApp.g:1179:2: ( ( ( ( (lv_jar_0_0= 'jar' ) ) | ( (lv_sharedObject_1_0= 'sharedObject' ) ) | ( (lv_configurationFile_2_0= 'file' ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_path_5_0= RULE_STRING ) ) (otherlv_6= ';' )? ) )
            // InternalApp.g:1180:2: ( ( ( (lv_jar_0_0= 'jar' ) ) | ( (lv_sharedObject_1_0= 'sharedObject' ) ) | ( (lv_configurationFile_2_0= 'file' ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_path_5_0= RULE_STRING ) ) (otherlv_6= ';' )? )
            {
            // InternalApp.g:1180:2: ( ( ( (lv_jar_0_0= 'jar' ) ) | ( (lv_sharedObject_1_0= 'sharedObject' ) ) | ( (lv_configurationFile_2_0= 'file' ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_path_5_0= RULE_STRING ) ) (otherlv_6= ';' )? )
            // InternalApp.g:1181:3: ( ( (lv_jar_0_0= 'jar' ) ) | ( (lv_sharedObject_1_0= 'sharedObject' ) ) | ( (lv_configurationFile_2_0= 'file' ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_path_5_0= RULE_STRING ) ) (otherlv_6= ';' )?
            {
            // InternalApp.g:1181:3: ( ( (lv_jar_0_0= 'jar' ) ) | ( (lv_sharedObject_1_0= 'sharedObject' ) ) | ( (lv_configurationFile_2_0= 'file' ) ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt22=1;
                }
                break;
            case 31:
                {
                alt22=2;
                }
                break;
            case 32:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalApp.g:1182:4: ( (lv_jar_0_0= 'jar' ) )
                    {
                    // InternalApp.g:1182:4: ( (lv_jar_0_0= 'jar' ) )
                    // InternalApp.g:1183:5: (lv_jar_0_0= 'jar' )
                    {
                    // InternalApp.g:1183:5: (lv_jar_0_0= 'jar' )
                    // InternalApp.g:1184:6: lv_jar_0_0= 'jar'
                    {
                    lv_jar_0_0=(Token)match(input,30,FOLLOW_3); 

                    						newLeafNode(lv_jar_0_0, grammarAccess.getArtifactAccess().getJarJarKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getArtifactRule());
                    						}
                    						setWithLastConsumed(current, "jar", true, "jar");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalApp.g:1197:4: ( (lv_sharedObject_1_0= 'sharedObject' ) )
                    {
                    // InternalApp.g:1197:4: ( (lv_sharedObject_1_0= 'sharedObject' ) )
                    // InternalApp.g:1198:5: (lv_sharedObject_1_0= 'sharedObject' )
                    {
                    // InternalApp.g:1198:5: (lv_sharedObject_1_0= 'sharedObject' )
                    // InternalApp.g:1199:6: lv_sharedObject_1_0= 'sharedObject'
                    {
                    lv_sharedObject_1_0=(Token)match(input,31,FOLLOW_3); 

                    						newLeafNode(lv_sharedObject_1_0, grammarAccess.getArtifactAccess().getSharedObjectSharedObjectKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getArtifactRule());
                    						}
                    						setWithLastConsumed(current, "sharedObject", true, "sharedObject");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalApp.g:1212:4: ( (lv_configurationFile_2_0= 'file' ) )
                    {
                    // InternalApp.g:1212:4: ( (lv_configurationFile_2_0= 'file' ) )
                    // InternalApp.g:1213:5: (lv_configurationFile_2_0= 'file' )
                    {
                    // InternalApp.g:1213:5: (lv_configurationFile_2_0= 'file' )
                    // InternalApp.g:1214:6: lv_configurationFile_2_0= 'file'
                    {
                    lv_configurationFile_2_0=(Token)match(input,32,FOLLOW_3); 

                    						newLeafNode(lv_configurationFile_2_0, grammarAccess.getArtifactAccess().getConfigurationFileFileKeyword_0_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getArtifactRule());
                    						}
                    						setWithLastConsumed(current, "configurationFile", true, "file");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalApp.g:1227:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalApp.g:1228:4: (lv_name_3_0= RULE_ID )
            {
            // InternalApp.g:1228:4: (lv_name_3_0= RULE_ID )
            // InternalApp.g:1229:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_3_0, grammarAccess.getArtifactAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArtifactRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,28,FOLLOW_20); 

            			newLeafNode(otherlv_4, grammarAccess.getArtifactAccess().getColonKeyword_2());
            		
            // InternalApp.g:1249:3: ( (lv_path_5_0= RULE_STRING ) )
            // InternalApp.g:1250:4: (lv_path_5_0= RULE_STRING )
            {
            // InternalApp.g:1250:4: (lv_path_5_0= RULE_STRING )
            // InternalApp.g:1251:5: lv_path_5_0= RULE_STRING
            {
            lv_path_5_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

            					newLeafNode(lv_path_5_0, grammarAccess.getArtifactAccess().getPathSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArtifactRule());
            					}
            					setWithLastConsumed(
            						current,
            						"path",
            						lv_path_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalApp.g:1267:3: (otherlv_6= ';' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==22) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalApp.g:1268:4: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getArtifactAccess().getSemicolonKeyword_4());
                    			

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
    // $ANTLR end "ruleArtifact"


    // $ANTLR start "entryRuleComponent"
    // InternalApp.g:1277:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // InternalApp.g:1277:50: (iv_ruleComponent= ruleComponent EOF )
            // InternalApp.g:1278:2: iv_ruleComponent= ruleComponent EOF
            {
             newCompositeNode(grammarAccess.getComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponent=ruleComponent();

            state._fsp--;

             current =iv_ruleComponent; 
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
    // $ANTLR end "entryRuleComponent"


    // $ANTLR start "ruleComponent"
    // InternalApp.g:1284:1: ruleComponent returns [EObject current=null] : (this_AppComponent_0= ruleAppComponent | this_DeviceComponent_1= ruleDeviceComponent ) ;
    public final EObject ruleComponent() throws RecognitionException {
        EObject current = null;

        EObject this_AppComponent_0 = null;

        EObject this_DeviceComponent_1 = null;



        	enterRule();

        try {
            // InternalApp.g:1290:2: ( (this_AppComponent_0= ruleAppComponent | this_DeviceComponent_1= ruleDeviceComponent ) )
            // InternalApp.g:1291:2: (this_AppComponent_0= ruleAppComponent | this_DeviceComponent_1= ruleDeviceComponent )
            {
            // InternalApp.g:1291:2: (this_AppComponent_0= ruleAppComponent | this_DeviceComponent_1= ruleDeviceComponent )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==36) ) {
                alt24=1;
            }
            else if ( (LA24_0==33) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalApp.g:1292:3: this_AppComponent_0= ruleAppComponent
                    {

                    			newCompositeNode(grammarAccess.getComponentAccess().getAppComponentParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AppComponent_0=ruleAppComponent();

                    state._fsp--;


                    			current = this_AppComponent_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalApp.g:1301:3: this_DeviceComponent_1= ruleDeviceComponent
                    {

                    			newCompositeNode(grammarAccess.getComponentAccess().getDeviceComponentParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_DeviceComponent_1=ruleDeviceComponent();

                    state._fsp--;


                    			current = this_DeviceComponent_1;
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
    // $ANTLR end "ruleComponent"


    // $ANTLR start "entryRuleDeviceComponent"
    // InternalApp.g:1313:1: entryRuleDeviceComponent returns [EObject current=null] : iv_ruleDeviceComponent= ruleDeviceComponent EOF ;
    public final EObject entryRuleDeviceComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeviceComponent = null;


        try {
            // InternalApp.g:1313:56: (iv_ruleDeviceComponent= ruleDeviceComponent EOF )
            // InternalApp.g:1314:2: iv_ruleDeviceComponent= ruleDeviceComponent EOF
            {
             newCompositeNode(grammarAccess.getDeviceComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeviceComponent=ruleDeviceComponent();

            state._fsp--;

             current =iv_ruleDeviceComponent; 
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
    // $ANTLR end "entryRuleDeviceComponent"


    // $ANTLR start "ruleDeviceComponent"
    // InternalApp.g:1320:1: ruleDeviceComponent returns [EObject current=null] : (otherlv_0= 'device' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' ) ;
    public final EObject ruleDeviceComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject lv_formals_3_0 = null;

        EObject lv_formals_5_0 = null;

        EObject lv_requirements_8_0 = null;

        EObject lv_ports_9_0 = null;



        	enterRule();

        try {
            // InternalApp.g:1326:2: ( (otherlv_0= 'device' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' ) )
            // InternalApp.g:1327:2: (otherlv_0= 'device' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' )
            {
            // InternalApp.g:1327:2: (otherlv_0= 'device' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' )
            // InternalApp.g:1328:3: otherlv_0= 'device' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDeviceComponentAccess().getDeviceKeyword_0());
            		
            // InternalApp.g:1332:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:1333:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:1333:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:1334:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDeviceComponentAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeviceComponentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalApp.g:1350:3: (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==34) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalApp.g:1351:4: otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getDeviceComponentAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalApp.g:1355:4: ( (lv_formals_3_0= ruleComponentFormal ) )
                    // InternalApp.g:1356:5: (lv_formals_3_0= ruleComponentFormal )
                    {
                    // InternalApp.g:1356:5: (lv_formals_3_0= ruleComponentFormal )
                    // InternalApp.g:1357:6: lv_formals_3_0= ruleComponentFormal
                    {

                    						newCompositeNode(grammarAccess.getDeviceComponentAccess().getFormalsComponentFormalParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_formals_3_0=ruleComponentFormal();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDeviceComponentRule());
                    						}
                    						add(
                    							current,
                    							"formals",
                    							lv_formals_3_0,
                    							"edu.vanderbilt.riaps.App.ComponentFormal");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalApp.g:1374:4: (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==21) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalApp.g:1375:5: otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) )
                    	    {
                    	    otherlv_4=(Token)match(input,21,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDeviceComponentAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalApp.g:1379:5: ( (lv_formals_5_0= ruleComponentFormal ) )
                    	    // InternalApp.g:1380:6: (lv_formals_5_0= ruleComponentFormal )
                    	    {
                    	    // InternalApp.g:1380:6: (lv_formals_5_0= ruleComponentFormal )
                    	    // InternalApp.g:1381:7: lv_formals_5_0= ruleComponentFormal
                    	    {

                    	    							newCompositeNode(grammarAccess.getDeviceComponentAccess().getFormalsComponentFormalParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_22);
                    	    lv_formals_5_0=ruleComponentFormal();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDeviceComponentRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"formals",
                    	    								lv_formals_5_0,
                    	    								"edu.vanderbilt.riaps.App.ComponentFormal");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,35,FOLLOW_8); 

                    				newLeafNode(otherlv_6, grammarAccess.getDeviceComponentAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_23); 

            			newLeafNode(otherlv_7, grammarAccess.getDeviceComponentAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalApp.g:1408:3: ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+
            int cnt27=0;
            loop27:
            do {
                int alt27=3;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==40) ) {
                    alt27=1;
                }
                else if ( ((LA27_0>=48 && LA27_0<=49)||(LA27_0>=51 && LA27_0<=53)||(LA27_0>=60 && LA27_0<=61)) ) {
                    alt27=2;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalApp.g:1409:4: ( (lv_requirements_8_0= ruleRequirement ) )
            	    {
            	    // InternalApp.g:1409:4: ( (lv_requirements_8_0= ruleRequirement ) )
            	    // InternalApp.g:1410:5: (lv_requirements_8_0= ruleRequirement )
            	    {
            	    // InternalApp.g:1410:5: (lv_requirements_8_0= ruleRequirement )
            	    // InternalApp.g:1411:6: lv_requirements_8_0= ruleRequirement
            	    {

            	    						newCompositeNode(grammarAccess.getDeviceComponentAccess().getRequirementsRequirementParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_requirements_8_0=ruleRequirement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDeviceComponentRule());
            	    						}
            	    						add(
            	    							current,
            	    							"requirements",
            	    							lv_requirements_8_0,
            	    							"edu.vanderbilt.riaps.App.Requirement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalApp.g:1429:4: ( (lv_ports_9_0= rulePort ) )
            	    {
            	    // InternalApp.g:1429:4: ( (lv_ports_9_0= rulePort ) )
            	    // InternalApp.g:1430:5: (lv_ports_9_0= rulePort )
            	    {
            	    // InternalApp.g:1430:5: (lv_ports_9_0= rulePort )
            	    // InternalApp.g:1431:6: lv_ports_9_0= rulePort
            	    {

            	    						newCompositeNode(grammarAccess.getDeviceComponentAccess().getPortsPortParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_ports_9_0=rulePort();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDeviceComponentRule());
            	    						}
            	    						add(
            	    							current,
            	    							"ports",
            	    							lv_ports_9_0,
            	    							"edu.vanderbilt.riaps.App.Port");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            otherlv_10=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getDeviceComponentAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleDeviceComponent"


    // $ANTLR start "entryRuleAppComponent"
    // InternalApp.g:1457:1: entryRuleAppComponent returns [EObject current=null] : iv_ruleAppComponent= ruleAppComponent EOF ;
    public final EObject entryRuleAppComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAppComponent = null;


        try {
            // InternalApp.g:1457:53: (iv_ruleAppComponent= ruleAppComponent EOF )
            // InternalApp.g:1458:2: iv_ruleAppComponent= ruleAppComponent EOF
            {
             newCompositeNode(grammarAccess.getAppComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAppComponent=ruleAppComponent();

            state._fsp--;

             current =iv_ruleAppComponent; 
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
    // $ANTLR end "entryRuleAppComponent"


    // $ANTLR start "ruleAppComponent"
    // InternalApp.g:1464:1: ruleAppComponent returns [EObject current=null] : (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' ) ;
    public final EObject ruleAppComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject lv_formals_3_0 = null;

        EObject lv_formals_5_0 = null;

        EObject lv_requirements_8_0 = null;

        EObject lv_ports_9_0 = null;



        	enterRule();

        try {
            // InternalApp.g:1470:2: ( (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' ) )
            // InternalApp.g:1471:2: (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' )
            {
            // InternalApp.g:1471:2: (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' )
            // InternalApp.g:1472:3: otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAppComponentAccess().getComponentKeyword_0());
            		
            // InternalApp.g:1476:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:1477:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:1477:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:1478:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAppComponentAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAppComponentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalApp.g:1494:3: (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==34) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalApp.g:1495:4: otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getAppComponentAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalApp.g:1499:4: ( (lv_formals_3_0= ruleComponentFormal ) )
                    // InternalApp.g:1500:5: (lv_formals_3_0= ruleComponentFormal )
                    {
                    // InternalApp.g:1500:5: (lv_formals_3_0= ruleComponentFormal )
                    // InternalApp.g:1501:6: lv_formals_3_0= ruleComponentFormal
                    {

                    						newCompositeNode(grammarAccess.getAppComponentAccess().getFormalsComponentFormalParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_formals_3_0=ruleComponentFormal();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAppComponentRule());
                    						}
                    						add(
                    							current,
                    							"formals",
                    							lv_formals_3_0,
                    							"edu.vanderbilt.riaps.App.ComponentFormal");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalApp.g:1518:4: (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==21) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalApp.g:1519:5: otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) )
                    	    {
                    	    otherlv_4=(Token)match(input,21,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getAppComponentAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalApp.g:1523:5: ( (lv_formals_5_0= ruleComponentFormal ) )
                    	    // InternalApp.g:1524:6: (lv_formals_5_0= ruleComponentFormal )
                    	    {
                    	    // InternalApp.g:1524:6: (lv_formals_5_0= ruleComponentFormal )
                    	    // InternalApp.g:1525:7: lv_formals_5_0= ruleComponentFormal
                    	    {

                    	    							newCompositeNode(grammarAccess.getAppComponentAccess().getFormalsComponentFormalParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_22);
                    	    lv_formals_5_0=ruleComponentFormal();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAppComponentRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"formals",
                    	    								lv_formals_5_0,
                    	    								"edu.vanderbilt.riaps.App.ComponentFormal");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,35,FOLLOW_8); 

                    				newLeafNode(otherlv_6, grammarAccess.getAppComponentAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_23); 

            			newLeafNode(otherlv_7, grammarAccess.getAppComponentAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalApp.g:1552:3: ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+
            int cnt30=0;
            loop30:
            do {
                int alt30=3;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==40) ) {
                    alt30=1;
                }
                else if ( ((LA30_0>=48 && LA30_0<=49)||(LA30_0>=51 && LA30_0<=53)||(LA30_0>=60 && LA30_0<=61)) ) {
                    alt30=2;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalApp.g:1553:4: ( (lv_requirements_8_0= ruleRequirement ) )
            	    {
            	    // InternalApp.g:1553:4: ( (lv_requirements_8_0= ruleRequirement ) )
            	    // InternalApp.g:1554:5: (lv_requirements_8_0= ruleRequirement )
            	    {
            	    // InternalApp.g:1554:5: (lv_requirements_8_0= ruleRequirement )
            	    // InternalApp.g:1555:6: lv_requirements_8_0= ruleRequirement
            	    {

            	    						newCompositeNode(grammarAccess.getAppComponentAccess().getRequirementsRequirementParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_requirements_8_0=ruleRequirement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAppComponentRule());
            	    						}
            	    						add(
            	    							current,
            	    							"requirements",
            	    							lv_requirements_8_0,
            	    							"edu.vanderbilt.riaps.App.Requirement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalApp.g:1573:4: ( (lv_ports_9_0= rulePort ) )
            	    {
            	    // InternalApp.g:1573:4: ( (lv_ports_9_0= rulePort ) )
            	    // InternalApp.g:1574:5: (lv_ports_9_0= rulePort )
            	    {
            	    // InternalApp.g:1574:5: (lv_ports_9_0= rulePort )
            	    // InternalApp.g:1575:6: lv_ports_9_0= rulePort
            	    {

            	    						newCompositeNode(grammarAccess.getAppComponentAccess().getPortsPortParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_ports_9_0=rulePort();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAppComponentRule());
            	    						}
            	    						add(
            	    							current,
            	    							"ports",
            	    							lv_ports_9_0,
            	    							"edu.vanderbilt.riaps.App.Port");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);

            otherlv_10=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getAppComponentAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleAppComponent"


    // $ANTLR start "entryRuleMemoryUnits"
    // InternalApp.g:1601:1: entryRuleMemoryUnits returns [EObject current=null] : iv_ruleMemoryUnits= ruleMemoryUnits EOF ;
    public final EObject entryRuleMemoryUnits() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMemoryUnits = null;


        try {
            // InternalApp.g:1601:52: (iv_ruleMemoryUnits= ruleMemoryUnits EOF )
            // InternalApp.g:1602:2: iv_ruleMemoryUnits= ruleMemoryUnits EOF
            {
             newCompositeNode(grammarAccess.getMemoryUnitsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMemoryUnits=ruleMemoryUnits();

            state._fsp--;

             current =iv_ruleMemoryUnits; 
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
    // $ANTLR end "entryRuleMemoryUnits"


    // $ANTLR start "ruleMemoryUnits"
    // InternalApp.g:1608:1: ruleMemoryUnits returns [EObject current=null] : ( ( (lv_kb_0_0= 'KB' ) ) | ( (lv_mb_1_0= 'MB' ) ) | ( (lv_gb_2_0= 'GB' ) ) ) ;
    public final EObject ruleMemoryUnits() throws RecognitionException {
        EObject current = null;

        Token lv_kb_0_0=null;
        Token lv_mb_1_0=null;
        Token lv_gb_2_0=null;


        	enterRule();

        try {
            // InternalApp.g:1614:2: ( ( ( (lv_kb_0_0= 'KB' ) ) | ( (lv_mb_1_0= 'MB' ) ) | ( (lv_gb_2_0= 'GB' ) ) ) )
            // InternalApp.g:1615:2: ( ( (lv_kb_0_0= 'KB' ) ) | ( (lv_mb_1_0= 'MB' ) ) | ( (lv_gb_2_0= 'GB' ) ) )
            {
            // InternalApp.g:1615:2: ( ( (lv_kb_0_0= 'KB' ) ) | ( (lv_mb_1_0= 'MB' ) ) | ( (lv_gb_2_0= 'GB' ) ) )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt31=1;
                }
                break;
            case 38:
                {
                alt31=2;
                }
                break;
            case 39:
                {
                alt31=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalApp.g:1616:3: ( (lv_kb_0_0= 'KB' ) )
                    {
                    // InternalApp.g:1616:3: ( (lv_kb_0_0= 'KB' ) )
                    // InternalApp.g:1617:4: (lv_kb_0_0= 'KB' )
                    {
                    // InternalApp.g:1617:4: (lv_kb_0_0= 'KB' )
                    // InternalApp.g:1618:5: lv_kb_0_0= 'KB'
                    {
                    lv_kb_0_0=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_kb_0_0, grammarAccess.getMemoryUnitsAccess().getKbKBKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMemoryUnitsRule());
                    					}
                    					setWithLastConsumed(current, "kb", true, "KB");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalApp.g:1631:3: ( (lv_mb_1_0= 'MB' ) )
                    {
                    // InternalApp.g:1631:3: ( (lv_mb_1_0= 'MB' ) )
                    // InternalApp.g:1632:4: (lv_mb_1_0= 'MB' )
                    {
                    // InternalApp.g:1632:4: (lv_mb_1_0= 'MB' )
                    // InternalApp.g:1633:5: lv_mb_1_0= 'MB'
                    {
                    lv_mb_1_0=(Token)match(input,38,FOLLOW_2); 

                    					newLeafNode(lv_mb_1_0, grammarAccess.getMemoryUnitsAccess().getMbMBKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMemoryUnitsRule());
                    					}
                    					setWithLastConsumed(current, "mb", true, "MB");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalApp.g:1646:3: ( (lv_gb_2_0= 'GB' ) )
                    {
                    // InternalApp.g:1646:3: ( (lv_gb_2_0= 'GB' ) )
                    // InternalApp.g:1647:4: (lv_gb_2_0= 'GB' )
                    {
                    // InternalApp.g:1647:4: (lv_gb_2_0= 'GB' )
                    // InternalApp.g:1648:5: lv_gb_2_0= 'GB'
                    {
                    lv_gb_2_0=(Token)match(input,39,FOLLOW_2); 

                    					newLeafNode(lv_gb_2_0, grammarAccess.getMemoryUnitsAccess().getGbGBKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMemoryUnitsRule());
                    					}
                    					setWithLastConsumed(current, "gb", true, "GB");
                    				

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
    // $ANTLR end "ruleMemoryUnits"


    // $ANTLR start "entryRuleRequirement"
    // InternalApp.g:1664:1: entryRuleRequirement returns [EObject current=null] : iv_ruleRequirement= ruleRequirement EOF ;
    public final EObject entryRuleRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirement = null;


        try {
            // InternalApp.g:1664:52: (iv_ruleRequirement= ruleRequirement EOF )
            // InternalApp.g:1665:2: iv_ruleRequirement= ruleRequirement EOF
            {
             newCompositeNode(grammarAccess.getRequirementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRequirement=ruleRequirement();

            state._fsp--;

             current =iv_ruleRequirement; 
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
    // $ANTLR end "entryRuleRequirement"


    // $ANTLR start "ruleRequirement"
    // InternalApp.g:1671:1: ruleRequirement returns [EObject current=null] : (otherlv_0= 'requires' ( (otherlv_1= 'artifact' ( ( ruleFQN ) ) ) | (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) ) | (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) ) | (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) ) ) (otherlv_11= ';' )? ) ;
    public final EObject ruleRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_memoryRequirement_4_0=null;
        Token otherlv_6=null;
        Token lv_storageRequirement_7_0=null;
        Token otherlv_9=null;
        Token lv_deviceRequirement_10_0=null;
        Token otherlv_11=null;
        EObject lv_memoryunit_5_0 = null;

        EObject lv_storageunit_8_0 = null;



        	enterRule();

        try {
            // InternalApp.g:1677:2: ( (otherlv_0= 'requires' ( (otherlv_1= 'artifact' ( ( ruleFQN ) ) ) | (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) ) | (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) ) | (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) ) ) (otherlv_11= ';' )? ) )
            // InternalApp.g:1678:2: (otherlv_0= 'requires' ( (otherlv_1= 'artifact' ( ( ruleFQN ) ) ) | (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) ) | (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) ) | (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) ) ) (otherlv_11= ';' )? )
            {
            // InternalApp.g:1678:2: (otherlv_0= 'requires' ( (otherlv_1= 'artifact' ( ( ruleFQN ) ) ) | (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) ) | (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) ) | (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) ) ) (otherlv_11= ';' )? )
            // InternalApp.g:1679:3: otherlv_0= 'requires' ( (otherlv_1= 'artifact' ( ( ruleFQN ) ) ) | (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) ) | (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) ) | (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) ) ) (otherlv_11= ';' )?
            {
            otherlv_0=(Token)match(input,40,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getRequirementAccess().getRequiresKeyword_0());
            		
            // InternalApp.g:1683:3: ( (otherlv_1= 'artifact' ( ( ruleFQN ) ) ) | (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) ) | (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) ) | (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) ) )
            int alt32=4;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt32=1;
                }
                break;
            case 42:
                {
                alt32=2;
                }
                break;
            case 43:
                {
                alt32=3;
                }
                break;
            case 33:
                {
                alt32=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalApp.g:1684:4: (otherlv_1= 'artifact' ( ( ruleFQN ) ) )
                    {
                    // InternalApp.g:1684:4: (otherlv_1= 'artifact' ( ( ruleFQN ) ) )
                    // InternalApp.g:1685:5: otherlv_1= 'artifact' ( ( ruleFQN ) )
                    {
                    otherlv_1=(Token)match(input,41,FOLLOW_3); 

                    					newLeafNode(otherlv_1, grammarAccess.getRequirementAccess().getArtifactKeyword_1_0_0());
                    				
                    // InternalApp.g:1689:5: ( ( ruleFQN ) )
                    // InternalApp.g:1690:6: ( ruleFQN )
                    {
                    // InternalApp.g:1690:6: ( ruleFQN )
                    // InternalApp.g:1691:7: ruleFQN
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRequirementRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getRequirementAccess().getArtifactrequirementArtifactCrossReference_1_0_1_0());
                    						
                    pushFollow(FOLLOW_19);
                    ruleFQN();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalApp.g:1707:4: (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) )
                    {
                    // InternalApp.g:1707:4: (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) )
                    // InternalApp.g:1708:5: otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) )
                    {
                    otherlv_3=(Token)match(input,42,FOLLOW_26); 

                    					newLeafNode(otherlv_3, grammarAccess.getRequirementAccess().getMemoryKeyword_1_1_0());
                    				
                    // InternalApp.g:1712:5: ( (lv_memoryRequirement_4_0= RULE_INT ) )
                    // InternalApp.g:1713:6: (lv_memoryRequirement_4_0= RULE_INT )
                    {
                    // InternalApp.g:1713:6: (lv_memoryRequirement_4_0= RULE_INT )
                    // InternalApp.g:1714:7: lv_memoryRequirement_4_0= RULE_INT
                    {
                    lv_memoryRequirement_4_0=(Token)match(input,RULE_INT,FOLLOW_27); 

                    							newLeafNode(lv_memoryRequirement_4_0, grammarAccess.getRequirementAccess().getMemoryRequirementINTTerminalRuleCall_1_1_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRequirementRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"memoryRequirement",
                    								lv_memoryRequirement_4_0,
                    								"edu.vanderbilt.riaps.App.INT");
                    						

                    }


                    }

                    // InternalApp.g:1730:5: ( (lv_memoryunit_5_0= ruleMemoryUnits ) )
                    // InternalApp.g:1731:6: (lv_memoryunit_5_0= ruleMemoryUnits )
                    {
                    // InternalApp.g:1731:6: (lv_memoryunit_5_0= ruleMemoryUnits )
                    // InternalApp.g:1732:7: lv_memoryunit_5_0= ruleMemoryUnits
                    {

                    							newCompositeNode(grammarAccess.getRequirementAccess().getMemoryunitMemoryUnitsParserRuleCall_1_1_2_0());
                    						
                    pushFollow(FOLLOW_19);
                    lv_memoryunit_5_0=ruleMemoryUnits();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getRequirementRule());
                    							}
                    							set(
                    								current,
                    								"memoryunit",
                    								lv_memoryunit_5_0,
                    								"edu.vanderbilt.riaps.App.MemoryUnits");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalApp.g:1751:4: (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) )
                    {
                    // InternalApp.g:1751:4: (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) )
                    // InternalApp.g:1752:5: otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) )
                    {
                    otherlv_6=(Token)match(input,43,FOLLOW_26); 

                    					newLeafNode(otherlv_6, grammarAccess.getRequirementAccess().getStorageKeyword_1_2_0());
                    				
                    // InternalApp.g:1756:5: ( (lv_storageRequirement_7_0= RULE_INT ) )
                    // InternalApp.g:1757:6: (lv_storageRequirement_7_0= RULE_INT )
                    {
                    // InternalApp.g:1757:6: (lv_storageRequirement_7_0= RULE_INT )
                    // InternalApp.g:1758:7: lv_storageRequirement_7_0= RULE_INT
                    {
                    lv_storageRequirement_7_0=(Token)match(input,RULE_INT,FOLLOW_27); 

                    							newLeafNode(lv_storageRequirement_7_0, grammarAccess.getRequirementAccess().getStorageRequirementINTTerminalRuleCall_1_2_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRequirementRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"storageRequirement",
                    								lv_storageRequirement_7_0,
                    								"edu.vanderbilt.riaps.App.INT");
                    						

                    }


                    }

                    // InternalApp.g:1774:5: ( (lv_storageunit_8_0= ruleMemoryUnits ) )
                    // InternalApp.g:1775:6: (lv_storageunit_8_0= ruleMemoryUnits )
                    {
                    // InternalApp.g:1775:6: (lv_storageunit_8_0= ruleMemoryUnits )
                    // InternalApp.g:1776:7: lv_storageunit_8_0= ruleMemoryUnits
                    {

                    							newCompositeNode(grammarAccess.getRequirementAccess().getStorageunitMemoryUnitsParserRuleCall_1_2_2_0());
                    						
                    pushFollow(FOLLOW_19);
                    lv_storageunit_8_0=ruleMemoryUnits();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getRequirementRule());
                    							}
                    							set(
                    								current,
                    								"storageunit",
                    								lv_storageunit_8_0,
                    								"edu.vanderbilt.riaps.App.MemoryUnits");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalApp.g:1795:4: (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) )
                    {
                    // InternalApp.g:1795:4: (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) )
                    // InternalApp.g:1796:5: otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,33,FOLLOW_20); 

                    					newLeafNode(otherlv_9, grammarAccess.getRequirementAccess().getDeviceKeyword_1_3_0());
                    				
                    // InternalApp.g:1800:5: ( (lv_deviceRequirement_10_0= RULE_STRING ) )
                    // InternalApp.g:1801:6: (lv_deviceRequirement_10_0= RULE_STRING )
                    {
                    // InternalApp.g:1801:6: (lv_deviceRequirement_10_0= RULE_STRING )
                    // InternalApp.g:1802:7: lv_deviceRequirement_10_0= RULE_STRING
                    {
                    lv_deviceRequirement_10_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

                    							newLeafNode(lv_deviceRequirement_10_0, grammarAccess.getRequirementAccess().getDeviceRequirementSTRINGTerminalRuleCall_1_3_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRequirementRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"deviceRequirement",
                    								lv_deviceRequirement_10_0,
                    								"org.eclipse.xtext.common.Terminals.STRING");
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalApp.g:1820:3: (otherlv_11= ';' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==22) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalApp.g:1821:4: otherlv_11= ';'
                    {
                    otherlv_11=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getRequirementAccess().getSemicolonKeyword_2());
                    			

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
    // $ANTLR end "ruleRequirement"


    // $ANTLR start "entryRulePort"
    // InternalApp.g:1830:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // InternalApp.g:1830:45: (iv_rulePort= rulePort EOF )
            // InternalApp.g:1831:2: iv_rulePort= rulePort EOF
            {
             newCompositeNode(grammarAccess.getPortRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePort=rulePort();

            state._fsp--;

             current =iv_rulePort; 
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
    // $ANTLR end "entryRulePort"


    // $ANTLR start "rulePort"
    // InternalApp.g:1837:1: rulePort returns [EObject current=null] : (this_PubPort_0= rulePubPort | this_SubPort_1= ruleSubPort | this_ClntPort_2= ruleClntPort | this_SrvPort_3= ruleSrvPort | this_ReqPort_4= ruleReqPort | this_TimPort_5= ruleTimPort | this_InsPort_6= ruleInsPort ) ;
    public final EObject rulePort() throws RecognitionException {
        EObject current = null;

        EObject this_PubPort_0 = null;

        EObject this_SubPort_1 = null;

        EObject this_ClntPort_2 = null;

        EObject this_SrvPort_3 = null;

        EObject this_ReqPort_4 = null;

        EObject this_TimPort_5 = null;

        EObject this_InsPort_6 = null;



        	enterRule();

        try {
            // InternalApp.g:1843:2: ( (this_PubPort_0= rulePubPort | this_SubPort_1= ruleSubPort | this_ClntPort_2= ruleClntPort | this_SrvPort_3= ruleSrvPort | this_ReqPort_4= ruleReqPort | this_TimPort_5= ruleTimPort | this_InsPort_6= ruleInsPort ) )
            // InternalApp.g:1844:2: (this_PubPort_0= rulePubPort | this_SubPort_1= ruleSubPort | this_ClntPort_2= ruleClntPort | this_SrvPort_3= ruleSrvPort | this_ReqPort_4= ruleReqPort | this_TimPort_5= ruleTimPort | this_InsPort_6= ruleInsPort )
            {
            // InternalApp.g:1844:2: (this_PubPort_0= rulePubPort | this_SubPort_1= ruleSubPort | this_ClntPort_2= ruleClntPort | this_SrvPort_3= ruleSrvPort | this_ReqPort_4= ruleReqPort | this_TimPort_5= ruleTimPort | this_InsPort_6= ruleInsPort )
            int alt34=7;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt34=1;
                }
                break;
            case 49:
                {
                alt34=2;
                }
                break;
            case 51:
                {
                alt34=3;
                }
                break;
            case 52:
                {
                alt34=4;
                }
                break;
            case 53:
                {
                alt34=5;
                }
                break;
            case 60:
                {
                alt34=6;
                }
                break;
            case 61:
                {
                alt34=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalApp.g:1845:3: this_PubPort_0= rulePubPort
                    {

                    			newCompositeNode(grammarAccess.getPortAccess().getPubPortParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PubPort_0=rulePubPort();

                    state._fsp--;


                    			current = this_PubPort_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalApp.g:1854:3: this_SubPort_1= ruleSubPort
                    {

                    			newCompositeNode(grammarAccess.getPortAccess().getSubPortParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SubPort_1=ruleSubPort();

                    state._fsp--;


                    			current = this_SubPort_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalApp.g:1863:3: this_ClntPort_2= ruleClntPort
                    {

                    			newCompositeNode(grammarAccess.getPortAccess().getClntPortParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ClntPort_2=ruleClntPort();

                    state._fsp--;


                    			current = this_ClntPort_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalApp.g:1872:3: this_SrvPort_3= ruleSrvPort
                    {

                    			newCompositeNode(grammarAccess.getPortAccess().getSrvPortParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_SrvPort_3=ruleSrvPort();

                    state._fsp--;


                    			current = this_SrvPort_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalApp.g:1881:3: this_ReqPort_4= ruleReqPort
                    {

                    			newCompositeNode(grammarAccess.getPortAccess().getReqPortParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReqPort_4=ruleReqPort();

                    state._fsp--;


                    			current = this_ReqPort_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalApp.g:1890:3: this_TimPort_5= ruleTimPort
                    {

                    			newCompositeNode(grammarAccess.getPortAccess().getTimPortParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimPort_5=ruleTimPort();

                    state._fsp--;


                    			current = this_TimPort_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalApp.g:1899:3: this_InsPort_6= ruleInsPort
                    {

                    			newCompositeNode(grammarAccess.getPortAccess().getInsPortParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_InsPort_6=ruleInsPort();

                    state._fsp--;


                    			current = this_InsPort_6;
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
    // $ANTLR end "rulePort"


    // $ANTLR start "entryRuleRateLimit"
    // InternalApp.g:1911:1: entryRuleRateLimit returns [EObject current=null] : iv_ruleRateLimit= ruleRateLimit EOF ;
    public final EObject entryRuleRateLimit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRateLimit = null;


        try {
            // InternalApp.g:1911:50: (iv_ruleRateLimit= ruleRateLimit EOF )
            // InternalApp.g:1912:2: iv_ruleRateLimit= ruleRateLimit EOF
            {
             newCompositeNode(grammarAccess.getRateLimitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRateLimit=ruleRateLimit();

            state._fsp--;

             current =iv_ruleRateLimit; 
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
    // $ANTLR end "entryRuleRateLimit"


    // $ANTLR start "ruleRateLimit"
    // InternalApp.g:1918:1: ruleRateLimit returns [EObject current=null] : (otherlv_0= 'Hz' otherlv_1= '[' ( ( (lv_lower_2_0= RULE_INT ) ) | ( (lv_nolower_3_0= '-' ) ) ) otherlv_4= ',' ( ( (lv_upper_5_0= RULE_INT ) ) | ( (lv_noupper_6_0= '-' ) ) ) otherlv_7= ']' ) ;
    public final EObject ruleRateLimit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_lower_2_0=null;
        Token lv_nolower_3_0=null;
        Token otherlv_4=null;
        Token lv_upper_5_0=null;
        Token lv_noupper_6_0=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalApp.g:1924:2: ( (otherlv_0= 'Hz' otherlv_1= '[' ( ( (lv_lower_2_0= RULE_INT ) ) | ( (lv_nolower_3_0= '-' ) ) ) otherlv_4= ',' ( ( (lv_upper_5_0= RULE_INT ) ) | ( (lv_noupper_6_0= '-' ) ) ) otherlv_7= ']' ) )
            // InternalApp.g:1925:2: (otherlv_0= 'Hz' otherlv_1= '[' ( ( (lv_lower_2_0= RULE_INT ) ) | ( (lv_nolower_3_0= '-' ) ) ) otherlv_4= ',' ( ( (lv_upper_5_0= RULE_INT ) ) | ( (lv_noupper_6_0= '-' ) ) ) otherlv_7= ']' )
            {
            // InternalApp.g:1925:2: (otherlv_0= 'Hz' otherlv_1= '[' ( ( (lv_lower_2_0= RULE_INT ) ) | ( (lv_nolower_3_0= '-' ) ) ) otherlv_4= ',' ( ( (lv_upper_5_0= RULE_INT ) ) | ( (lv_noupper_6_0= '-' ) ) ) otherlv_7= ']' )
            // InternalApp.g:1926:3: otherlv_0= 'Hz' otherlv_1= '[' ( ( (lv_lower_2_0= RULE_INT ) ) | ( (lv_nolower_3_0= '-' ) ) ) otherlv_4= ',' ( ( (lv_upper_5_0= RULE_INT ) ) | ( (lv_noupper_6_0= '-' ) ) ) otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getRateLimitAccess().getHzKeyword_0());
            		
            otherlv_1=(Token)match(input,45,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getRateLimitAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalApp.g:1934:3: ( ( (lv_lower_2_0= RULE_INT ) ) | ( (lv_nolower_3_0= '-' ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_INT) ) {
                alt35=1;
            }
            else if ( (LA35_0==46) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalApp.g:1935:4: ( (lv_lower_2_0= RULE_INT ) )
                    {
                    // InternalApp.g:1935:4: ( (lv_lower_2_0= RULE_INT ) )
                    // InternalApp.g:1936:5: (lv_lower_2_0= RULE_INT )
                    {
                    // InternalApp.g:1936:5: (lv_lower_2_0= RULE_INT )
                    // InternalApp.g:1937:6: lv_lower_2_0= RULE_INT
                    {
                    lv_lower_2_0=(Token)match(input,RULE_INT,FOLLOW_13); 

                    						newLeafNode(lv_lower_2_0, grammarAccess.getRateLimitAccess().getLowerINTTerminalRuleCall_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRateLimitRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"lower",
                    							lv_lower_2_0,
                    							"edu.vanderbilt.riaps.App.INT");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalApp.g:1954:4: ( (lv_nolower_3_0= '-' ) )
                    {
                    // InternalApp.g:1954:4: ( (lv_nolower_3_0= '-' ) )
                    // InternalApp.g:1955:5: (lv_nolower_3_0= '-' )
                    {
                    // InternalApp.g:1955:5: (lv_nolower_3_0= '-' )
                    // InternalApp.g:1956:6: lv_nolower_3_0= '-'
                    {
                    lv_nolower_3_0=(Token)match(input,46,FOLLOW_13); 

                    						newLeafNode(lv_nolower_3_0, grammarAccess.getRateLimitAccess().getNolowerHyphenMinusKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRateLimitRule());
                    						}
                    						setWithLastConsumed(current, "nolower", true, "-");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,21,FOLLOW_29); 

            			newLeafNode(otherlv_4, grammarAccess.getRateLimitAccess().getCommaKeyword_3());
            		
            // InternalApp.g:1973:3: ( ( (lv_upper_5_0= RULE_INT ) ) | ( (lv_noupper_6_0= '-' ) ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_INT) ) {
                alt36=1;
            }
            else if ( (LA36_0==46) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalApp.g:1974:4: ( (lv_upper_5_0= RULE_INT ) )
                    {
                    // InternalApp.g:1974:4: ( (lv_upper_5_0= RULE_INT ) )
                    // InternalApp.g:1975:5: (lv_upper_5_0= RULE_INT )
                    {
                    // InternalApp.g:1975:5: (lv_upper_5_0= RULE_INT )
                    // InternalApp.g:1976:6: lv_upper_5_0= RULE_INT
                    {
                    lv_upper_5_0=(Token)match(input,RULE_INT,FOLLOW_30); 

                    						newLeafNode(lv_upper_5_0, grammarAccess.getRateLimitAccess().getUpperINTTerminalRuleCall_4_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRateLimitRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"upper",
                    							lv_upper_5_0,
                    							"edu.vanderbilt.riaps.App.INT");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalApp.g:1993:4: ( (lv_noupper_6_0= '-' ) )
                    {
                    // InternalApp.g:1993:4: ( (lv_noupper_6_0= '-' ) )
                    // InternalApp.g:1994:5: (lv_noupper_6_0= '-' )
                    {
                    // InternalApp.g:1994:5: (lv_noupper_6_0= '-' )
                    // InternalApp.g:1995:6: lv_noupper_6_0= '-'
                    {
                    lv_noupper_6_0=(Token)match(input,46,FOLLOW_30); 

                    						newLeafNode(lv_noupper_6_0, grammarAccess.getRateLimitAccess().getNoupperHyphenMinusKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRateLimitRule());
                    						}
                    						setWithLastConsumed(current, "noupper", true, "-");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,47,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getRateLimitAccess().getRightSquareBracketKeyword_5());
            		

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
    // $ANTLR end "ruleRateLimit"


    // $ANTLR start "entryRulePubPort"
    // InternalApp.g:2016:1: entryRulePubPort returns [EObject current=null] : iv_rulePubPort= rulePubPort EOF ;
    public final EObject entryRulePubPort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePubPort = null;


        try {
            // InternalApp.g:2016:48: (iv_rulePubPort= rulePubPort EOF )
            // InternalApp.g:2017:2: iv_rulePubPort= rulePubPort EOF
            {
             newCompositeNode(grammarAccess.getPubPortRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePubPort=rulePubPort();

            state._fsp--;

             current =iv_rulePubPort; 
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
    // $ANTLR end "entryRulePubPort"


    // $ANTLR start "rulePubPort"
    // InternalApp.g:2023:1: rulePubPort returns [EObject current=null] : (otherlv_0= 'pub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_ratelimit_4_0= ruleRateLimit ) )? (otherlv_5= ';' )? ) ;
    public final EObject rulePubPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_ratelimit_4_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2029:2: ( (otherlv_0= 'pub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_ratelimit_4_0= ruleRateLimit ) )? (otherlv_5= ';' )? ) )
            // InternalApp.g:2030:2: (otherlv_0= 'pub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_ratelimit_4_0= ruleRateLimit ) )? (otherlv_5= ';' )? )
            {
            // InternalApp.g:2030:2: (otherlv_0= 'pub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_ratelimit_4_0= ruleRateLimit ) )? (otherlv_5= ';' )? )
            // InternalApp.g:2031:3: otherlv_0= 'pub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_ratelimit_4_0= ruleRateLimit ) )? (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,48,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPubPortAccess().getPubKeyword_0());
            		
            // InternalApp.g:2035:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:2036:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:2036:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:2037:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPubPortAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPubPortRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getPubPortAccess().getColonKeyword_2());
            		
            // InternalApp.g:2057:3: ( ( ruleFQN ) )
            // InternalApp.g:2058:4: ( ruleFQN )
            {
            // InternalApp.g:2058:4: ( ruleFQN )
            // InternalApp.g:2059:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPubPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPubPortAccess().getTypeMessageCrossReference_3_0());
            				
            pushFollow(FOLLOW_31);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:2073:3: ( (lv_ratelimit_4_0= ruleRateLimit ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==44) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalApp.g:2074:4: (lv_ratelimit_4_0= ruleRateLimit )
                    {
                    // InternalApp.g:2074:4: (lv_ratelimit_4_0= ruleRateLimit )
                    // InternalApp.g:2075:5: lv_ratelimit_4_0= ruleRateLimit
                    {

                    					newCompositeNode(grammarAccess.getPubPortAccess().getRatelimitRateLimitParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_19);
                    lv_ratelimit_4_0=ruleRateLimit();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPubPortRule());
                    					}
                    					set(
                    						current,
                    						"ratelimit",
                    						lv_ratelimit_4_0,
                    						"edu.vanderbilt.riaps.App.RateLimit");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalApp.g:2092:3: (otherlv_5= ';' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==22) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalApp.g:2093:4: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPubPortAccess().getSemicolonKeyword_5());
                    			

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
    // $ANTLR end "rulePubPort"


    // $ANTLR start "entryRuleSubPort"
    // InternalApp.g:2102:1: entryRuleSubPort returns [EObject current=null] : iv_ruleSubPort= ruleSubPort EOF ;
    public final EObject entryRuleSubPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubPort = null;


        try {
            // InternalApp.g:2102:48: (iv_ruleSubPort= ruleSubPort EOF )
            // InternalApp.g:2103:2: iv_ruleSubPort= ruleSubPort EOF
            {
             newCompositeNode(grammarAccess.getSubPortRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubPort=ruleSubPort();

            state._fsp--;

             current =iv_ruleSubPort; 
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
    // $ANTLR end "entryRuleSubPort"


    // $ANTLR start "ruleSubPort"
    // InternalApp.g:2109:1: ruleSubPort returns [EObject current=null] : (otherlv_0= 'sub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_ratelimit_4_0= ruleRateLimit ) )? (otherlv_5= ';' )? ) ;
    public final EObject ruleSubPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_ratelimit_4_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2115:2: ( (otherlv_0= 'sub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_ratelimit_4_0= ruleRateLimit ) )? (otherlv_5= ';' )? ) )
            // InternalApp.g:2116:2: (otherlv_0= 'sub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_ratelimit_4_0= ruleRateLimit ) )? (otherlv_5= ';' )? )
            {
            // InternalApp.g:2116:2: (otherlv_0= 'sub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_ratelimit_4_0= ruleRateLimit ) )? (otherlv_5= ';' )? )
            // InternalApp.g:2117:3: otherlv_0= 'sub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) ( (lv_ratelimit_4_0= ruleRateLimit ) )? (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSubPortAccess().getSubKeyword_0());
            		
            // InternalApp.g:2121:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:2122:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:2122:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:2123:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSubPortAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubPortRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getSubPortAccess().getColonKeyword_2());
            		
            // InternalApp.g:2143:3: ( ( ruleFQN ) )
            // InternalApp.g:2144:4: ( ruleFQN )
            {
            // InternalApp.g:2144:4: ( ruleFQN )
            // InternalApp.g:2145:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubPortAccess().getTypeMessageCrossReference_3_0());
            				
            pushFollow(FOLLOW_31);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:2159:3: ( (lv_ratelimit_4_0= ruleRateLimit ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==44) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalApp.g:2160:4: (lv_ratelimit_4_0= ruleRateLimit )
                    {
                    // InternalApp.g:2160:4: (lv_ratelimit_4_0= ruleRateLimit )
                    // InternalApp.g:2161:5: lv_ratelimit_4_0= ruleRateLimit
                    {

                    					newCompositeNode(grammarAccess.getSubPortAccess().getRatelimitRateLimitParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_19);
                    lv_ratelimit_4_0=ruleRateLimit();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSubPortRule());
                    					}
                    					set(
                    						current,
                    						"ratelimit",
                    						lv_ratelimit_4_0,
                    						"edu.vanderbilt.riaps.App.RateLimit");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalApp.g:2178:3: (otherlv_5= ';' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==22) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalApp.g:2179:4: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getSubPortAccess().getSemicolonKeyword_5());
                    			

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
    // $ANTLR end "ruleSubPort"


    // $ANTLR start "entryRuleDeadline"
    // InternalApp.g:2188:1: entryRuleDeadline returns [EObject current=null] : iv_ruleDeadline= ruleDeadline EOF ;
    public final EObject entryRuleDeadline() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeadline = null;


        try {
            // InternalApp.g:2188:49: (iv_ruleDeadline= ruleDeadline EOF )
            // InternalApp.g:2189:2: iv_ruleDeadline= ruleDeadline EOF
            {
             newCompositeNode(grammarAccess.getDeadlineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeadline=ruleDeadline();

            state._fsp--;

             current =iv_ruleDeadline; 
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
    // $ANTLR end "entryRuleDeadline"


    // $ANTLR start "ruleDeadline"
    // InternalApp.g:2195:1: ruleDeadline returns [EObject current=null] : (otherlv_0= 'within' ( (lv_deadline_1_0= RULE_INT ) ) ( (lv_units_2_0= ruleTimeUnit ) ) ) ;
    public final EObject ruleDeadline() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_deadline_1_0=null;
        EObject lv_units_2_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2201:2: ( (otherlv_0= 'within' ( (lv_deadline_1_0= RULE_INT ) ) ( (lv_units_2_0= ruleTimeUnit ) ) ) )
            // InternalApp.g:2202:2: (otherlv_0= 'within' ( (lv_deadline_1_0= RULE_INT ) ) ( (lv_units_2_0= ruleTimeUnit ) ) )
            {
            // InternalApp.g:2202:2: (otherlv_0= 'within' ( (lv_deadline_1_0= RULE_INT ) ) ( (lv_units_2_0= ruleTimeUnit ) ) )
            // InternalApp.g:2203:3: otherlv_0= 'within' ( (lv_deadline_1_0= RULE_INT ) ) ( (lv_units_2_0= ruleTimeUnit ) )
            {
            otherlv_0=(Token)match(input,50,FOLLOW_26); 

            			newLeafNode(otherlv_0, grammarAccess.getDeadlineAccess().getWithinKeyword_0());
            		
            // InternalApp.g:2207:3: ( (lv_deadline_1_0= RULE_INT ) )
            // InternalApp.g:2208:4: (lv_deadline_1_0= RULE_INT )
            {
            // InternalApp.g:2208:4: (lv_deadline_1_0= RULE_INT )
            // InternalApp.g:2209:5: lv_deadline_1_0= RULE_INT
            {
            lv_deadline_1_0=(Token)match(input,RULE_INT,FOLLOW_32); 

            					newLeafNode(lv_deadline_1_0, grammarAccess.getDeadlineAccess().getDeadlineINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeadlineRule());
            					}
            					setWithLastConsumed(
            						current,
            						"deadline",
            						lv_deadline_1_0,
            						"edu.vanderbilt.riaps.App.INT");
            				

            }


            }

            // InternalApp.g:2225:3: ( (lv_units_2_0= ruleTimeUnit ) )
            // InternalApp.g:2226:4: (lv_units_2_0= ruleTimeUnit )
            {
            // InternalApp.g:2226:4: (lv_units_2_0= ruleTimeUnit )
            // InternalApp.g:2227:5: lv_units_2_0= ruleTimeUnit
            {

            					newCompositeNode(grammarAccess.getDeadlineAccess().getUnitsTimeUnitParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_units_2_0=ruleTimeUnit();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDeadlineRule());
            					}
            					set(
            						current,
            						"units",
            						lv_units_2_0,
            						"edu.vanderbilt.riaps.App.TimeUnit");
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
    // $ANTLR end "ruleDeadline"


    // $ANTLR start "entryRuleClntPort"
    // InternalApp.g:2248:1: entryRuleClntPort returns [EObject current=null] : iv_ruleClntPort= ruleClntPort EOF ;
    public final EObject entryRuleClntPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClntPort = null;


        try {
            // InternalApp.g:2248:49: (iv_ruleClntPort= ruleClntPort EOF )
            // InternalApp.g:2249:2: iv_ruleClntPort= ruleClntPort EOF
            {
             newCompositeNode(grammarAccess.getClntPortRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClntPort=ruleClntPort();

            state._fsp--;

             current =iv_ruleClntPort; 
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
    // $ANTLR end "entryRuleClntPort"


    // $ANTLR start "ruleClntPort"
    // InternalApp.g:2255:1: ruleClntPort returns [EObject current=null] : (otherlv_0= 'clt' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) ( (lv_deadline_7_0= ruleDeadline ) )? otherlv_8= ')' ( (lv_ratelimit_9_0= ruleRateLimit ) )? (otherlv_10= ';' )? ) ;
    public final EObject ruleClntPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_deadline_7_0 = null;

        EObject lv_ratelimit_9_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2261:2: ( (otherlv_0= 'clt' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) ( (lv_deadline_7_0= ruleDeadline ) )? otherlv_8= ')' ( (lv_ratelimit_9_0= ruleRateLimit ) )? (otherlv_10= ';' )? ) )
            // InternalApp.g:2262:2: (otherlv_0= 'clt' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) ( (lv_deadline_7_0= ruleDeadline ) )? otherlv_8= ')' ( (lv_ratelimit_9_0= ruleRateLimit ) )? (otherlv_10= ';' )? )
            {
            // InternalApp.g:2262:2: (otherlv_0= 'clt' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) ( (lv_deadline_7_0= ruleDeadline ) )? otherlv_8= ')' ( (lv_ratelimit_9_0= ruleRateLimit ) )? (otherlv_10= ';' )? )
            // InternalApp.g:2263:3: otherlv_0= 'clt' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) ( (lv_deadline_7_0= ruleDeadline ) )? otherlv_8= ')' ( (lv_ratelimit_9_0= ruleRateLimit ) )? (otherlv_10= ';' )?
            {
            otherlv_0=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getClntPortAccess().getCltKeyword_0());
            		
            // InternalApp.g:2267:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:2268:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:2268:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:2269:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_1_0, grammarAccess.getClntPortAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClntPortRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_33); 

            			newLeafNode(otherlv_2, grammarAccess.getClntPortAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getClntPortAccess().getLeftParenthesisKeyword_3());
            		
            // InternalApp.g:2293:3: ( ( ruleFQN ) )
            // InternalApp.g:2294:4: ( ruleFQN )
            {
            // InternalApp.g:2294:4: ( ruleFQN )
            // InternalApp.g:2295:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClntPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getClntPortAccess().getReq_typeMessageCrossReference_4_0());
            				
            pushFollow(FOLLOW_13);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getClntPortAccess().getCommaKeyword_5());
            		
            // InternalApp.g:2313:3: ( ( ruleFQN ) )
            // InternalApp.g:2314:4: ( ruleFQN )
            {
            // InternalApp.g:2314:4: ( ruleFQN )
            // InternalApp.g:2315:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClntPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getClntPortAccess().getRep_typeMessageCrossReference_6_0());
            				
            pushFollow(FOLLOW_34);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:2329:3: ( (lv_deadline_7_0= ruleDeadline ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==50) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalApp.g:2330:4: (lv_deadline_7_0= ruleDeadline )
                    {
                    // InternalApp.g:2330:4: (lv_deadline_7_0= ruleDeadline )
                    // InternalApp.g:2331:5: lv_deadline_7_0= ruleDeadline
                    {

                    					newCompositeNode(grammarAccess.getClntPortAccess().getDeadlineDeadlineParserRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_35);
                    lv_deadline_7_0=ruleDeadline();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getClntPortRule());
                    					}
                    					set(
                    						current,
                    						"deadline",
                    						lv_deadline_7_0,
                    						"edu.vanderbilt.riaps.App.Deadline");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,35,FOLLOW_31); 

            			newLeafNode(otherlv_8, grammarAccess.getClntPortAccess().getRightParenthesisKeyword_8());
            		
            // InternalApp.g:2352:3: ( (lv_ratelimit_9_0= ruleRateLimit ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==44) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalApp.g:2353:4: (lv_ratelimit_9_0= ruleRateLimit )
                    {
                    // InternalApp.g:2353:4: (lv_ratelimit_9_0= ruleRateLimit )
                    // InternalApp.g:2354:5: lv_ratelimit_9_0= ruleRateLimit
                    {

                    					newCompositeNode(grammarAccess.getClntPortAccess().getRatelimitRateLimitParserRuleCall_9_0());
                    				
                    pushFollow(FOLLOW_19);
                    lv_ratelimit_9_0=ruleRateLimit();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getClntPortRule());
                    					}
                    					set(
                    						current,
                    						"ratelimit",
                    						lv_ratelimit_9_0,
                    						"edu.vanderbilt.riaps.App.RateLimit");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalApp.g:2371:3: (otherlv_10= ';' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==22) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalApp.g:2372:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getClntPortAccess().getSemicolonKeyword_10());
                    			

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
    // $ANTLR end "ruleClntPort"


    // $ANTLR start "entryRuleSrvPort"
    // InternalApp.g:2381:1: entryRuleSrvPort returns [EObject current=null] : iv_ruleSrvPort= ruleSrvPort EOF ;
    public final EObject entryRuleSrvPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSrvPort = null;


        try {
            // InternalApp.g:2381:48: (iv_ruleSrvPort= ruleSrvPort EOF )
            // InternalApp.g:2382:2: iv_ruleSrvPort= ruleSrvPort EOF
            {
             newCompositeNode(grammarAccess.getSrvPortRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSrvPort=ruleSrvPort();

            state._fsp--;

             current =iv_ruleSrvPort; 
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
    // $ANTLR end "entryRuleSrvPort"


    // $ANTLR start "ruleSrvPort"
    // InternalApp.g:2388:1: ruleSrvPort returns [EObject current=null] : (otherlv_0= 'srv' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' ( (lv_ratelimit_8_0= ruleRateLimit ) )? (otherlv_9= ';' )? ) ;
    public final EObject ruleSrvPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_ratelimit_8_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2394:2: ( (otherlv_0= 'srv' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' ( (lv_ratelimit_8_0= ruleRateLimit ) )? (otherlv_9= ';' )? ) )
            // InternalApp.g:2395:2: (otherlv_0= 'srv' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' ( (lv_ratelimit_8_0= ruleRateLimit ) )? (otherlv_9= ';' )? )
            {
            // InternalApp.g:2395:2: (otherlv_0= 'srv' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' ( (lv_ratelimit_8_0= ruleRateLimit ) )? (otherlv_9= ';' )? )
            // InternalApp.g:2396:3: otherlv_0= 'srv' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' ( (lv_ratelimit_8_0= ruleRateLimit ) )? (otherlv_9= ';' )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSrvPortAccess().getSrvKeyword_0());
            		
            // InternalApp.g:2400:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:2401:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:2401:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:2402:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSrvPortAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSrvPortRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_33); 

            			newLeafNode(otherlv_2, grammarAccess.getSrvPortAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getSrvPortAccess().getLeftParenthesisKeyword_3());
            		
            // InternalApp.g:2426:3: ( ( ruleFQN ) )
            // InternalApp.g:2427:4: ( ruleFQN )
            {
            // InternalApp.g:2427:4: ( ruleFQN )
            // InternalApp.g:2428:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSrvPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSrvPortAccess().getReq_typeMessageCrossReference_4_0());
            				
            pushFollow(FOLLOW_13);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getSrvPortAccess().getCommaKeyword_5());
            		
            // InternalApp.g:2446:3: ( ( ruleFQN ) )
            // InternalApp.g:2447:4: ( ruleFQN )
            {
            // InternalApp.g:2447:4: ( ruleFQN )
            // InternalApp.g:2448:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSrvPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSrvPortAccess().getRep_typeMessageCrossReference_6_0());
            				
            pushFollow(FOLLOW_35);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,35,FOLLOW_31); 

            			newLeafNode(otherlv_7, grammarAccess.getSrvPortAccess().getRightParenthesisKeyword_7());
            		
            // InternalApp.g:2466:3: ( (lv_ratelimit_8_0= ruleRateLimit ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==44) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalApp.g:2467:4: (lv_ratelimit_8_0= ruleRateLimit )
                    {
                    // InternalApp.g:2467:4: (lv_ratelimit_8_0= ruleRateLimit )
                    // InternalApp.g:2468:5: lv_ratelimit_8_0= ruleRateLimit
                    {

                    					newCompositeNode(grammarAccess.getSrvPortAccess().getRatelimitRateLimitParserRuleCall_8_0());
                    				
                    pushFollow(FOLLOW_19);
                    lv_ratelimit_8_0=ruleRateLimit();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSrvPortRule());
                    					}
                    					set(
                    						current,
                    						"ratelimit",
                    						lv_ratelimit_8_0,
                    						"edu.vanderbilt.riaps.App.RateLimit");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalApp.g:2485:3: (otherlv_9= ';' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==22) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalApp.g:2486:4: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getSrvPortAccess().getSemicolonKeyword_9());
                    			

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
    // $ANTLR end "ruleSrvPort"


    // $ANTLR start "entryRuleReqPort"
    // InternalApp.g:2495:1: entryRuleReqPort returns [EObject current=null] : iv_ruleReqPort= ruleReqPort EOF ;
    public final EObject entryRuleReqPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqPort = null;


        try {
            // InternalApp.g:2495:48: (iv_ruleReqPort= ruleReqPort EOF )
            // InternalApp.g:2496:2: iv_ruleReqPort= ruleReqPort EOF
            {
             newCompositeNode(grammarAccess.getReqPortRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReqPort=ruleReqPort();

            state._fsp--;

             current =iv_ruleReqPort; 
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
    // $ANTLR end "entryRuleReqPort"


    // $ANTLR start "ruleReqPort"
    // InternalApp.g:2502:1: ruleReqPort returns [EObject current=null] : (otherlv_0= 'req' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) ( (lv_deadline_7_0= ruleDeadline ) )? otherlv_8= ')' ( (lv_ratelimit_9_0= ruleRateLimit ) )? (otherlv_10= ';' )? ) ;
    public final EObject ruleReqPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_deadline_7_0 = null;

        EObject lv_ratelimit_9_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2508:2: ( (otherlv_0= 'req' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) ( (lv_deadline_7_0= ruleDeadline ) )? otherlv_8= ')' ( (lv_ratelimit_9_0= ruleRateLimit ) )? (otherlv_10= ';' )? ) )
            // InternalApp.g:2509:2: (otherlv_0= 'req' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) ( (lv_deadline_7_0= ruleDeadline ) )? otherlv_8= ')' ( (lv_ratelimit_9_0= ruleRateLimit ) )? (otherlv_10= ';' )? )
            {
            // InternalApp.g:2509:2: (otherlv_0= 'req' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) ( (lv_deadline_7_0= ruleDeadline ) )? otherlv_8= ')' ( (lv_ratelimit_9_0= ruleRateLimit ) )? (otherlv_10= ';' )? )
            // InternalApp.g:2510:3: otherlv_0= 'req' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) ( (lv_deadline_7_0= ruleDeadline ) )? otherlv_8= ')' ( (lv_ratelimit_9_0= ruleRateLimit ) )? (otherlv_10= ';' )?
            {
            otherlv_0=(Token)match(input,53,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getReqPortAccess().getReqKeyword_0());
            		
            // InternalApp.g:2514:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:2515:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:2515:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:2516:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_1_0, grammarAccess.getReqPortAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReqPortRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_33); 

            			newLeafNode(otherlv_2, grammarAccess.getReqPortAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getReqPortAccess().getLeftParenthesisKeyword_3());
            		
            // InternalApp.g:2540:3: ( ( ruleFQN ) )
            // InternalApp.g:2541:4: ( ruleFQN )
            {
            // InternalApp.g:2541:4: ( ruleFQN )
            // InternalApp.g:2542:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReqPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReqPortAccess().getReq_typeMessageCrossReference_4_0());
            				
            pushFollow(FOLLOW_13);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getReqPortAccess().getCommaKeyword_5());
            		
            // InternalApp.g:2560:3: ( ( ruleFQN ) )
            // InternalApp.g:2561:4: ( ruleFQN )
            {
            // InternalApp.g:2561:4: ( ruleFQN )
            // InternalApp.g:2562:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReqPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReqPortAccess().getRep_typeMessageCrossReference_6_0());
            				
            pushFollow(FOLLOW_34);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:2576:3: ( (lv_deadline_7_0= ruleDeadline ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==50) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalApp.g:2577:4: (lv_deadline_7_0= ruleDeadline )
                    {
                    // InternalApp.g:2577:4: (lv_deadline_7_0= ruleDeadline )
                    // InternalApp.g:2578:5: lv_deadline_7_0= ruleDeadline
                    {

                    					newCompositeNode(grammarAccess.getReqPortAccess().getDeadlineDeadlineParserRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_35);
                    lv_deadline_7_0=ruleDeadline();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getReqPortRule());
                    					}
                    					set(
                    						current,
                    						"deadline",
                    						lv_deadline_7_0,
                    						"edu.vanderbilt.riaps.App.Deadline");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,35,FOLLOW_31); 

            			newLeafNode(otherlv_8, grammarAccess.getReqPortAccess().getRightParenthesisKeyword_8());
            		
            // InternalApp.g:2599:3: ( (lv_ratelimit_9_0= ruleRateLimit ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==44) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalApp.g:2600:4: (lv_ratelimit_9_0= ruleRateLimit )
                    {
                    // InternalApp.g:2600:4: (lv_ratelimit_9_0= ruleRateLimit )
                    // InternalApp.g:2601:5: lv_ratelimit_9_0= ruleRateLimit
                    {

                    					newCompositeNode(grammarAccess.getReqPortAccess().getRatelimitRateLimitParserRuleCall_9_0());
                    				
                    pushFollow(FOLLOW_19);
                    lv_ratelimit_9_0=ruleRateLimit();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getReqPortRule());
                    					}
                    					set(
                    						current,
                    						"ratelimit",
                    						lv_ratelimit_9_0,
                    						"edu.vanderbilt.riaps.App.RateLimit");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalApp.g:2618:3: (otherlv_10= ';' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==22) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalApp.g:2619:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getReqPortAccess().getSemicolonKeyword_10());
                    			

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
    // $ANTLR end "ruleReqPort"


    // $ANTLR start "entryRuleTimeUnit"
    // InternalApp.g:2628:1: entryRuleTimeUnit returns [EObject current=null] : iv_ruleTimeUnit= ruleTimeUnit EOF ;
    public final EObject entryRuleTimeUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeUnit = null;


        try {
            // InternalApp.g:2628:49: (iv_ruleTimeUnit= ruleTimeUnit EOF )
            // InternalApp.g:2629:2: iv_ruleTimeUnit= ruleTimeUnit EOF
            {
             newCompositeNode(grammarAccess.getTimeUnitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeUnit=ruleTimeUnit();

            state._fsp--;

             current =iv_ruleTimeUnit; 
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
    // $ANTLR end "entryRuleTimeUnit"


    // $ANTLR start "ruleTimeUnit"
    // InternalApp.g:2635:1: ruleTimeUnit returns [EObject current=null] : ( ( (lv_months_0_0= 'months' ) ) | ( (lv_days_1_0= 'days' ) ) | ( (lv_seconds_2_0= 's' ) ) | ( (lv_milliseconds_3_0= 'ms' ) ) | ( (lv_nanoseconds_4_0= 'ns' ) ) | ( (lv_microseconds_5_0= 'mus' ) ) ) ;
    public final EObject ruleTimeUnit() throws RecognitionException {
        EObject current = null;

        Token lv_months_0_0=null;
        Token lv_days_1_0=null;
        Token lv_seconds_2_0=null;
        Token lv_milliseconds_3_0=null;
        Token lv_nanoseconds_4_0=null;
        Token lv_microseconds_5_0=null;


        	enterRule();

        try {
            // InternalApp.g:2641:2: ( ( ( (lv_months_0_0= 'months' ) ) | ( (lv_days_1_0= 'days' ) ) | ( (lv_seconds_2_0= 's' ) ) | ( (lv_milliseconds_3_0= 'ms' ) ) | ( (lv_nanoseconds_4_0= 'ns' ) ) | ( (lv_microseconds_5_0= 'mus' ) ) ) )
            // InternalApp.g:2642:2: ( ( (lv_months_0_0= 'months' ) ) | ( (lv_days_1_0= 'days' ) ) | ( (lv_seconds_2_0= 's' ) ) | ( (lv_milliseconds_3_0= 'ms' ) ) | ( (lv_nanoseconds_4_0= 'ns' ) ) | ( (lv_microseconds_5_0= 'mus' ) ) )
            {
            // InternalApp.g:2642:2: ( ( (lv_months_0_0= 'months' ) ) | ( (lv_days_1_0= 'days' ) ) | ( (lv_seconds_2_0= 's' ) ) | ( (lv_milliseconds_3_0= 'ms' ) ) | ( (lv_nanoseconds_4_0= 'ns' ) ) | ( (lv_microseconds_5_0= 'mus' ) ) )
            int alt49=6;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt49=1;
                }
                break;
            case 55:
                {
                alt49=2;
                }
                break;
            case 56:
                {
                alt49=3;
                }
                break;
            case 57:
                {
                alt49=4;
                }
                break;
            case 58:
                {
                alt49=5;
                }
                break;
            case 59:
                {
                alt49=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalApp.g:2643:3: ( (lv_months_0_0= 'months' ) )
                    {
                    // InternalApp.g:2643:3: ( (lv_months_0_0= 'months' ) )
                    // InternalApp.g:2644:4: (lv_months_0_0= 'months' )
                    {
                    // InternalApp.g:2644:4: (lv_months_0_0= 'months' )
                    // InternalApp.g:2645:5: lv_months_0_0= 'months'
                    {
                    lv_months_0_0=(Token)match(input,54,FOLLOW_2); 

                    					newLeafNode(lv_months_0_0, grammarAccess.getTimeUnitAccess().getMonthsMonthsKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTimeUnitRule());
                    					}
                    					setWithLastConsumed(current, "months", true, "months");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalApp.g:2658:3: ( (lv_days_1_0= 'days' ) )
                    {
                    // InternalApp.g:2658:3: ( (lv_days_1_0= 'days' ) )
                    // InternalApp.g:2659:4: (lv_days_1_0= 'days' )
                    {
                    // InternalApp.g:2659:4: (lv_days_1_0= 'days' )
                    // InternalApp.g:2660:5: lv_days_1_0= 'days'
                    {
                    lv_days_1_0=(Token)match(input,55,FOLLOW_2); 

                    					newLeafNode(lv_days_1_0, grammarAccess.getTimeUnitAccess().getDaysDaysKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTimeUnitRule());
                    					}
                    					setWithLastConsumed(current, "days", true, "days");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalApp.g:2673:3: ( (lv_seconds_2_0= 's' ) )
                    {
                    // InternalApp.g:2673:3: ( (lv_seconds_2_0= 's' ) )
                    // InternalApp.g:2674:4: (lv_seconds_2_0= 's' )
                    {
                    // InternalApp.g:2674:4: (lv_seconds_2_0= 's' )
                    // InternalApp.g:2675:5: lv_seconds_2_0= 's'
                    {
                    lv_seconds_2_0=(Token)match(input,56,FOLLOW_2); 

                    					newLeafNode(lv_seconds_2_0, grammarAccess.getTimeUnitAccess().getSecondsSKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTimeUnitRule());
                    					}
                    					setWithLastConsumed(current, "seconds", true, "s");
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalApp.g:2688:3: ( (lv_milliseconds_3_0= 'ms' ) )
                    {
                    // InternalApp.g:2688:3: ( (lv_milliseconds_3_0= 'ms' ) )
                    // InternalApp.g:2689:4: (lv_milliseconds_3_0= 'ms' )
                    {
                    // InternalApp.g:2689:4: (lv_milliseconds_3_0= 'ms' )
                    // InternalApp.g:2690:5: lv_milliseconds_3_0= 'ms'
                    {
                    lv_milliseconds_3_0=(Token)match(input,57,FOLLOW_2); 

                    					newLeafNode(lv_milliseconds_3_0, grammarAccess.getTimeUnitAccess().getMillisecondsMsKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTimeUnitRule());
                    					}
                    					setWithLastConsumed(current, "milliseconds", true, "ms");
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalApp.g:2703:3: ( (lv_nanoseconds_4_0= 'ns' ) )
                    {
                    // InternalApp.g:2703:3: ( (lv_nanoseconds_4_0= 'ns' ) )
                    // InternalApp.g:2704:4: (lv_nanoseconds_4_0= 'ns' )
                    {
                    // InternalApp.g:2704:4: (lv_nanoseconds_4_0= 'ns' )
                    // InternalApp.g:2705:5: lv_nanoseconds_4_0= 'ns'
                    {
                    lv_nanoseconds_4_0=(Token)match(input,58,FOLLOW_2); 

                    					newLeafNode(lv_nanoseconds_4_0, grammarAccess.getTimeUnitAccess().getNanosecondsNsKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTimeUnitRule());
                    					}
                    					setWithLastConsumed(current, "nanoseconds", true, "ns");
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalApp.g:2718:3: ( (lv_microseconds_5_0= 'mus' ) )
                    {
                    // InternalApp.g:2718:3: ( (lv_microseconds_5_0= 'mus' ) )
                    // InternalApp.g:2719:4: (lv_microseconds_5_0= 'mus' )
                    {
                    // InternalApp.g:2719:4: (lv_microseconds_5_0= 'mus' )
                    // InternalApp.g:2720:5: lv_microseconds_5_0= 'mus'
                    {
                    lv_microseconds_5_0=(Token)match(input,59,FOLLOW_2); 

                    					newLeafNode(lv_microseconds_5_0, grammarAccess.getTimeUnitAccess().getMicrosecondsMusKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTimeUnitRule());
                    					}
                    					setWithLastConsumed(current, "microseconds", true, "mus");
                    				

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
    // $ANTLR end "ruleTimeUnit"


    // $ANTLR start "entryRuleTimPort"
    // InternalApp.g:2736:1: entryRuleTimPort returns [EObject current=null] : iv_ruleTimPort= ruleTimPort EOF ;
    public final EObject entryRuleTimPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimPort = null;


        try {
            // InternalApp.g:2736:48: (iv_ruleTimPort= ruleTimPort EOF )
            // InternalApp.g:2737:2: iv_ruleTimPort= ruleTimPort EOF
            {
             newCompositeNode(grammarAccess.getTimPortRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimPort=ruleTimPort();

            state._fsp--;

             current =iv_ruleTimPort; 
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
    // $ANTLR end "entryRuleTimPort"


    // $ANTLR start "ruleTimPort"
    // InternalApp.g:2743:1: ruleTimPort returns [EObject current=null] : (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleTimPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_spec_2_0 = null;

        EObject lv_unit_3_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2749:2: ( (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) ) ) (otherlv_4= ';' )? ) )
            // InternalApp.g:2750:2: (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) ) ) (otherlv_4= ';' )? )
            {
            // InternalApp.g:2750:2: (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) ) ) (otherlv_4= ';' )? )
            // InternalApp.g:2751:3: otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) ) ) (otherlv_4= ';' )?
            {
            otherlv_0=(Token)match(input,60,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTimPortAccess().getTimerKeyword_0());
            		
            // InternalApp.g:2755:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:2756:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:2756:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:2757:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTimPortAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimPortRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalApp.g:2773:3: ( ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) ) )
            // InternalApp.g:2774:4: ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) )
            {
            // InternalApp.g:2774:4: ( (lv_spec_2_0= ruleNumber ) )
            // InternalApp.g:2775:5: (lv_spec_2_0= ruleNumber )
            {
            // InternalApp.g:2775:5: (lv_spec_2_0= ruleNumber )
            // InternalApp.g:2776:6: lv_spec_2_0= ruleNumber
            {

            						newCompositeNode(grammarAccess.getTimPortAccess().getSpecNumberParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_32);
            lv_spec_2_0=ruleNumber();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getTimPortRule());
            						}
            						set(
            							current,
            							"spec",
            							lv_spec_2_0,
            							"edu.vanderbilt.riaps.App.Number");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            // InternalApp.g:2793:4: ( (lv_unit_3_0= ruleTimeUnit ) )
            // InternalApp.g:2794:5: (lv_unit_3_0= ruleTimeUnit )
            {
            // InternalApp.g:2794:5: (lv_unit_3_0= ruleTimeUnit )
            // InternalApp.g:2795:6: lv_unit_3_0= ruleTimeUnit
            {

            						newCompositeNode(grammarAccess.getTimPortAccess().getUnitTimeUnitParserRuleCall_2_1_0());
            					
            pushFollow(FOLLOW_19);
            lv_unit_3_0=ruleTimeUnit();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getTimPortRule());
            						}
            						set(
            							current,
            							"unit",
            							lv_unit_3_0,
            							"edu.vanderbilt.riaps.App.TimeUnit");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }

            // InternalApp.g:2813:3: (otherlv_4= ';' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==22) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalApp.g:2814:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getTimPortAccess().getSemicolonKeyword_3());
                    			

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
    // $ANTLR end "ruleTimPort"


    // $ANTLR start "entryRuleInsPort"
    // InternalApp.g:2823:1: entryRuleInsPort returns [EObject current=null] : iv_ruleInsPort= ruleInsPort EOF ;
    public final EObject entryRuleInsPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInsPort = null;


        try {
            // InternalApp.g:2823:48: (iv_ruleInsPort= ruleInsPort EOF )
            // InternalApp.g:2824:2: iv_ruleInsPort= ruleInsPort EOF
            {
             newCompositeNode(grammarAccess.getInsPortRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInsPort=ruleInsPort();

            state._fsp--;

             current =iv_ruleInsPort; 
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
    // $ANTLR end "entryRuleInsPort"


    // $ANTLR start "ruleInsPort"
    // InternalApp.g:2830:1: ruleInsPort returns [EObject current=null] : (otherlv_0= 'inside' ( (lv_name_1_0= RULE_ID ) ) ( (lv_spec_2_0= 'default' ) )? (otherlv_3= ';' )? ) ;
    public final EObject ruleInsPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_spec_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalApp.g:2836:2: ( (otherlv_0= 'inside' ( (lv_name_1_0= RULE_ID ) ) ( (lv_spec_2_0= 'default' ) )? (otherlv_3= ';' )? ) )
            // InternalApp.g:2837:2: (otherlv_0= 'inside' ( (lv_name_1_0= RULE_ID ) ) ( (lv_spec_2_0= 'default' ) )? (otherlv_3= ';' )? )
            {
            // InternalApp.g:2837:2: (otherlv_0= 'inside' ( (lv_name_1_0= RULE_ID ) ) ( (lv_spec_2_0= 'default' ) )? (otherlv_3= ';' )? )
            // InternalApp.g:2838:3: otherlv_0= 'inside' ( (lv_name_1_0= RULE_ID ) ) ( (lv_spec_2_0= 'default' ) )? (otherlv_3= ';' )?
            {
            otherlv_0=(Token)match(input,61,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getInsPortAccess().getInsideKeyword_0());
            		
            // InternalApp.g:2842:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:2843:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:2843:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:2844:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_36); 

            					newLeafNode(lv_name_1_0, grammarAccess.getInsPortAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInsPortRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalApp.g:2860:3: ( (lv_spec_2_0= 'default' ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==62) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalApp.g:2861:4: (lv_spec_2_0= 'default' )
                    {
                    // InternalApp.g:2861:4: (lv_spec_2_0= 'default' )
                    // InternalApp.g:2862:5: lv_spec_2_0= 'default'
                    {
                    lv_spec_2_0=(Token)match(input,62,FOLLOW_19); 

                    					newLeafNode(lv_spec_2_0, grammarAccess.getInsPortAccess().getSpecDefaultKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInsPortRule());
                    					}
                    					setWithLastConsumed(current, "spec", true, "default");
                    				

                    }


                    }
                    break;

            }

            // InternalApp.g:2874:3: (otherlv_3= ';' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==22) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalApp.g:2875:4: otherlv_3= ';'
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getInsPortAccess().getSemicolonKeyword_3());
                    			

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
    // $ANTLR end "ruleInsPort"


    // $ANTLR start "entryRuleComponentFormal"
    // InternalApp.g:2884:1: entryRuleComponentFormal returns [EObject current=null] : iv_ruleComponentFormal= ruleComponentFormal EOF ;
    public final EObject entryRuleComponentFormal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentFormal = null;


        try {
            // InternalApp.g:2884:56: (iv_ruleComponentFormal= ruleComponentFormal EOF )
            // InternalApp.g:2885:2: iv_ruleComponentFormal= ruleComponentFormal EOF
            {
             newCompositeNode(grammarAccess.getComponentFormalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentFormal=ruleComponentFormal();

            state._fsp--;

             current =iv_ruleComponentFormal; 
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
    // $ANTLR end "entryRuleComponentFormal"


    // $ANTLR start "ruleComponentFormal"
    // InternalApp.g:2891:1: ruleComponentFormal returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) ) ;
    public final EObject ruleComponentFormal() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_argDefault_2_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2897:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) ) )
            // InternalApp.g:2898:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) )
            {
            // InternalApp.g:2898:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) )
            // InternalApp.g:2899:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) )
            {
            // InternalApp.g:2899:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalApp.g:2900:4: (lv_name_0_0= RULE_ID )
            {
            // InternalApp.g:2900:4: (lv_name_0_0= RULE_ID )
            // InternalApp.g:2901:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(lv_name_0_0, grammarAccess.getComponentFormalAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentFormalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalApp.g:2917:3: (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) )
            // InternalApp.g:2918:4: otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) )
            {
            otherlv_1=(Token)match(input,63,FOLLOW_38); 

            				newLeafNode(otherlv_1, grammarAccess.getComponentFormalAccess().getEqualsSignKeyword_1_0());
            			
            // InternalApp.g:2922:4: ( (lv_argDefault_2_0= ruleFormalDefault ) )
            // InternalApp.g:2923:5: (lv_argDefault_2_0= ruleFormalDefault )
            {
            // InternalApp.g:2923:5: (lv_argDefault_2_0= ruleFormalDefault )
            // InternalApp.g:2924:6: lv_argDefault_2_0= ruleFormalDefault
            {

            						newCompositeNode(grammarAccess.getComponentFormalAccess().getArgDefaultFormalDefaultParserRuleCall_1_1_0());
            					
            pushFollow(FOLLOW_2);
            lv_argDefault_2_0=ruleFormalDefault();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getComponentFormalRule());
            						}
            						set(
            							current,
            							"argDefault",
            							lv_argDefault_2_0,
            							"edu.vanderbilt.riaps.App.FormalDefault");
            						afterParserOrEnumRuleCall();
            					

            }


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
    // $ANTLR end "ruleComponentFormal"


    // $ANTLR start "entryRuleActorFormal"
    // InternalApp.g:2946:1: entryRuleActorFormal returns [EObject current=null] : iv_ruleActorFormal= ruleActorFormal EOF ;
    public final EObject entryRuleActorFormal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorFormal = null;


        try {
            // InternalApp.g:2946:52: (iv_ruleActorFormal= ruleActorFormal EOF )
            // InternalApp.g:2947:2: iv_ruleActorFormal= ruleActorFormal EOF
            {
             newCompositeNode(grammarAccess.getActorFormalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActorFormal=ruleActorFormal();

            state._fsp--;

             current =iv_ruleActorFormal; 
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
    // $ANTLR end "entryRuleActorFormal"


    // $ANTLR start "ruleActorFormal"
    // InternalApp.g:2953:1: ruleActorFormal returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) ) ;
    public final EObject ruleActorFormal() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_argDefault_2_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2959:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) ) )
            // InternalApp.g:2960:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) )
            {
            // InternalApp.g:2960:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) )
            // InternalApp.g:2961:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) )
            {
            // InternalApp.g:2961:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalApp.g:2962:4: (lv_name_0_0= RULE_ID )
            {
            // InternalApp.g:2962:4: (lv_name_0_0= RULE_ID )
            // InternalApp.g:2963:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(lv_name_0_0, grammarAccess.getActorFormalAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorFormalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalApp.g:2979:3: (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) )
            // InternalApp.g:2980:4: otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) )
            {
            otherlv_1=(Token)match(input,63,FOLLOW_38); 

            				newLeafNode(otherlv_1, grammarAccess.getActorFormalAccess().getEqualsSignKeyword_1_0());
            			
            // InternalApp.g:2984:4: ( (lv_argDefault_2_0= ruleFormalDefault ) )
            // InternalApp.g:2985:5: (lv_argDefault_2_0= ruleFormalDefault )
            {
            // InternalApp.g:2985:5: (lv_argDefault_2_0= ruleFormalDefault )
            // InternalApp.g:2986:6: lv_argDefault_2_0= ruleFormalDefault
            {

            						newCompositeNode(grammarAccess.getActorFormalAccess().getArgDefaultFormalDefaultParserRuleCall_1_1_0());
            					
            pushFollow(FOLLOW_2);
            lv_argDefault_2_0=ruleFormalDefault();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getActorFormalRule());
            						}
            						set(
            							current,
            							"argDefault",
            							lv_argDefault_2_0,
            							"edu.vanderbilt.riaps.App.FormalDefault");
            						afterParserOrEnumRuleCall();
            					

            }


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
    // $ANTLR end "ruleActorFormal"


    // $ANTLR start "entryRuleActor"
    // InternalApp.g:3008:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalApp.g:3008:46: (iv_ruleActor= ruleActor EOF )
            // InternalApp.g:3009:2: iv_ruleActor= ruleActor EOF
            {
             newCompositeNode(grammarAccess.getActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActor=ruleActor();

            state._fsp--;

             current =iv_ruleActor; 
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
    // $ANTLR end "entryRuleActor"


    // $ANTLR start "ruleActor"
    // InternalApp.g:3015:1: ruleActor returns [EObject current=null] : (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? ) | (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? ) | (otherlv_18= 'critical' ( ( ruleFQN ) ) (otherlv_20= ',' ( ( ruleFQN ) ) )* (otherlv_22= ';' )? ) )* ( (lv_compsection_23_0= ruleInstanceSection ) ) ( (lv_wires_24_0= ruleWire ) )* otherlv_25= '}' ) ;
    public final EObject ruleActor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_25=null;
        EObject lv_formals_3_0 = null;

        EObject lv_formals_5_0 = null;

        EObject lv_compsection_23_0 = null;

        EObject lv_wires_24_0 = null;



        	enterRule();

        try {
            // InternalApp.g:3021:2: ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? ) | (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? ) | (otherlv_18= 'critical' ( ( ruleFQN ) ) (otherlv_20= ',' ( ( ruleFQN ) ) )* (otherlv_22= ';' )? ) )* ( (lv_compsection_23_0= ruleInstanceSection ) ) ( (lv_wires_24_0= ruleWire ) )* otherlv_25= '}' ) )
            // InternalApp.g:3022:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? ) | (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? ) | (otherlv_18= 'critical' ( ( ruleFQN ) ) (otherlv_20= ',' ( ( ruleFQN ) ) )* (otherlv_22= ';' )? ) )* ( (lv_compsection_23_0= ruleInstanceSection ) ) ( (lv_wires_24_0= ruleWire ) )* otherlv_25= '}' )
            {
            // InternalApp.g:3022:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? ) | (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? ) | (otherlv_18= 'critical' ( ( ruleFQN ) ) (otherlv_20= ',' ( ( ruleFQN ) ) )* (otherlv_22= ';' )? ) )* ( (lv_compsection_23_0= ruleInstanceSection ) ) ( (lv_wires_24_0= ruleWire ) )* otherlv_25= '}' )
            // InternalApp.g:3023:3: otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? ) | (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? ) | (otherlv_18= 'critical' ( ( ruleFQN ) ) (otherlv_20= ',' ( ( ruleFQN ) ) )* (otherlv_22= ';' )? ) )* ( (lv_compsection_23_0= ruleInstanceSection ) ) ( (lv_wires_24_0= ruleWire ) )* otherlv_25= '}'
            {
            otherlv_0=(Token)match(input,64,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getActorAccess().getActorKeyword_0());
            		
            // InternalApp.g:3027:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:3028:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:3028:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:3029:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalApp.g:3045:3: (otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==34) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalApp.g:3046:4: otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getActorAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalApp.g:3050:4: ( (lv_formals_3_0= ruleActorFormal ) )
                    // InternalApp.g:3051:5: (lv_formals_3_0= ruleActorFormal )
                    {
                    // InternalApp.g:3051:5: (lv_formals_3_0= ruleActorFormal )
                    // InternalApp.g:3052:6: lv_formals_3_0= ruleActorFormal
                    {

                    						newCompositeNode(grammarAccess.getActorAccess().getFormalsActorFormalParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_formals_3_0=ruleActorFormal();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActorRule());
                    						}
                    						add(
                    							current,
                    							"formals",
                    							lv_formals_3_0,
                    							"edu.vanderbilt.riaps.App.ActorFormal");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalApp.g:3069:4: (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==21) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalApp.g:3070:5: otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) )
                    	    {
                    	    otherlv_4=(Token)match(input,21,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getActorAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalApp.g:3074:5: ( (lv_formals_5_0= ruleActorFormal ) )
                    	    // InternalApp.g:3075:6: (lv_formals_5_0= ruleActorFormal )
                    	    {
                    	    // InternalApp.g:3075:6: (lv_formals_5_0= ruleActorFormal )
                    	    // InternalApp.g:3076:7: lv_formals_5_0= ruleActorFormal
                    	    {

                    	    							newCompositeNode(grammarAccess.getActorAccess().getFormalsActorFormalParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_22);
                    	    lv_formals_5_0=ruleActorFormal();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getActorRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"formals",
                    	    								lv_formals_5_0,
                    	    								"edu.vanderbilt.riaps.App.ActorFormal");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,35,FOLLOW_8); 

                    				newLeafNode(otherlv_6, grammarAccess.getActorAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_39); 

            			newLeafNode(otherlv_7, grammarAccess.getActorAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalApp.g:3103:3: ( (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? ) | (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? ) | (otherlv_18= 'critical' ( ( ruleFQN ) ) (otherlv_20= ',' ( ( ruleFQN ) ) )* (otherlv_22= ';' )? ) )*
            loop61:
            do {
                int alt61=4;
                switch ( input.LA(1) ) {
                case 65:
                    {
                    alt61=1;
                    }
                    break;
                case 66:
                    {
                    alt61=2;
                    }
                    break;
                case 67:
                    {
                    alt61=3;
                    }
                    break;

                }

                switch (alt61) {
            	case 1 :
            	    // InternalApp.g:3104:4: (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? )
            	    {
            	    // InternalApp.g:3104:4: (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? )
            	    // InternalApp.g:3105:5: otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )?
            	    {
            	    otherlv_8=(Token)match(input,65,FOLLOW_3); 

            	    					newLeafNode(otherlv_8, grammarAccess.getActorAccess().getLocalKeyword_4_0_0());
            	    				
            	    // InternalApp.g:3109:5: ( ( ruleFQN ) )
            	    // InternalApp.g:3110:6: ( ruleFQN )
            	    {
            	    // InternalApp.g:3110:6: ( ruleFQN )
            	    // InternalApp.g:3111:7: ruleFQN
            	    {

            	    							if (current==null) {
            	    								current = createModelElement(grammarAccess.getActorRule());
            	    							}
            	    						

            	    							newCompositeNode(grammarAccess.getActorAccess().getLocalsMessageCrossReference_4_0_1_0());
            	    						
            	    pushFollow(FOLLOW_40);
            	    ruleFQN();

            	    state._fsp--;


            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }

            	    // InternalApp.g:3125:5: (otherlv_10= ',' ( ( ruleFQN ) ) )*
            	    loop55:
            	    do {
            	        int alt55=2;
            	        int LA55_0 = input.LA(1);

            	        if ( (LA55_0==21) ) {
            	            alt55=1;
            	        }


            	        switch (alt55) {
            	    	case 1 :
            	    	    // InternalApp.g:3126:6: otherlv_10= ',' ( ( ruleFQN ) )
            	    	    {
            	    	    otherlv_10=(Token)match(input,21,FOLLOW_3); 

            	    	    						newLeafNode(otherlv_10, grammarAccess.getActorAccess().getCommaKeyword_4_0_2_0());
            	    	    					
            	    	    // InternalApp.g:3130:6: ( ( ruleFQN ) )
            	    	    // InternalApp.g:3131:7: ( ruleFQN )
            	    	    {
            	    	    // InternalApp.g:3131:7: ( ruleFQN )
            	    	    // InternalApp.g:3132:8: ruleFQN
            	    	    {

            	    	    								if (current==null) {
            	    	    									current = createModelElement(grammarAccess.getActorRule());
            	    	    								}
            	    	    							

            	    	    								newCompositeNode(grammarAccess.getActorAccess().getLocalsMessageCrossReference_4_0_2_1_0());
            	    	    							
            	    	    pushFollow(FOLLOW_40);
            	    	    ruleFQN();

            	    	    state._fsp--;


            	    	    								afterParserOrEnumRuleCall();
            	    	    							

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop55;
            	        }
            	    } while (true);

            	    // InternalApp.g:3147:5: (otherlv_12= ';' )?
            	    int alt56=2;
            	    int LA56_0 = input.LA(1);

            	    if ( (LA56_0==22) ) {
            	        alt56=1;
            	    }
            	    switch (alt56) {
            	        case 1 :
            	            // InternalApp.g:3148:6: otherlv_12= ';'
            	            {
            	            otherlv_12=(Token)match(input,22,FOLLOW_39); 

            	            						newLeafNode(otherlv_12, grammarAccess.getActorAccess().getSemicolonKeyword_4_0_3());
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalApp.g:3155:4: (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? )
            	    {
            	    // InternalApp.g:3155:4: (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? )
            	    // InternalApp.g:3156:5: otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )?
            	    {
            	    otherlv_13=(Token)match(input,66,FOLLOW_3); 

            	    					newLeafNode(otherlv_13, grammarAccess.getActorAccess().getInternalKeyword_4_1_0());
            	    				
            	    // InternalApp.g:3160:5: ( ( ruleFQN ) )
            	    // InternalApp.g:3161:6: ( ruleFQN )
            	    {
            	    // InternalApp.g:3161:6: ( ruleFQN )
            	    // InternalApp.g:3162:7: ruleFQN
            	    {

            	    							if (current==null) {
            	    								current = createModelElement(grammarAccess.getActorRule());
            	    							}
            	    						

            	    							newCompositeNode(grammarAccess.getActorAccess().getInternalsMessageCrossReference_4_1_1_0());
            	    						
            	    pushFollow(FOLLOW_40);
            	    ruleFQN();

            	    state._fsp--;


            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }

            	    // InternalApp.g:3176:5: (otherlv_15= ',' ( ( ruleFQN ) ) )*
            	    loop57:
            	    do {
            	        int alt57=2;
            	        int LA57_0 = input.LA(1);

            	        if ( (LA57_0==21) ) {
            	            alt57=1;
            	        }


            	        switch (alt57) {
            	    	case 1 :
            	    	    // InternalApp.g:3177:6: otherlv_15= ',' ( ( ruleFQN ) )
            	    	    {
            	    	    otherlv_15=(Token)match(input,21,FOLLOW_3); 

            	    	    						newLeafNode(otherlv_15, grammarAccess.getActorAccess().getCommaKeyword_4_1_2_0());
            	    	    					
            	    	    // InternalApp.g:3181:6: ( ( ruleFQN ) )
            	    	    // InternalApp.g:3182:7: ( ruleFQN )
            	    	    {
            	    	    // InternalApp.g:3182:7: ( ruleFQN )
            	    	    // InternalApp.g:3183:8: ruleFQN
            	    	    {

            	    	    								if (current==null) {
            	    	    									current = createModelElement(grammarAccess.getActorRule());
            	    	    								}
            	    	    							

            	    	    								newCompositeNode(grammarAccess.getActorAccess().getInternalsMessageCrossReference_4_1_2_1_0());
            	    	    							
            	    	    pushFollow(FOLLOW_40);
            	    	    ruleFQN();

            	    	    state._fsp--;


            	    	    								afterParserOrEnumRuleCall();
            	    	    							

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop57;
            	        }
            	    } while (true);

            	    // InternalApp.g:3198:5: (otherlv_17= ';' )?
            	    int alt58=2;
            	    int LA58_0 = input.LA(1);

            	    if ( (LA58_0==22) ) {
            	        alt58=1;
            	    }
            	    switch (alt58) {
            	        case 1 :
            	            // InternalApp.g:3199:6: otherlv_17= ';'
            	            {
            	            otherlv_17=(Token)match(input,22,FOLLOW_39); 

            	            						newLeafNode(otherlv_17, grammarAccess.getActorAccess().getSemicolonKeyword_4_1_3());
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalApp.g:3206:4: (otherlv_18= 'critical' ( ( ruleFQN ) ) (otherlv_20= ',' ( ( ruleFQN ) ) )* (otherlv_22= ';' )? )
            	    {
            	    // InternalApp.g:3206:4: (otherlv_18= 'critical' ( ( ruleFQN ) ) (otherlv_20= ',' ( ( ruleFQN ) ) )* (otherlv_22= ';' )? )
            	    // InternalApp.g:3207:5: otherlv_18= 'critical' ( ( ruleFQN ) ) (otherlv_20= ',' ( ( ruleFQN ) ) )* (otherlv_22= ';' )?
            	    {
            	    otherlv_18=(Token)match(input,67,FOLLOW_3); 

            	    					newLeafNode(otherlv_18, grammarAccess.getActorAccess().getCriticalKeyword_4_2_0());
            	    				
            	    // InternalApp.g:3211:5: ( ( ruleFQN ) )
            	    // InternalApp.g:3212:6: ( ruleFQN )
            	    {
            	    // InternalApp.g:3212:6: ( ruleFQN )
            	    // InternalApp.g:3213:7: ruleFQN
            	    {

            	    							if (current==null) {
            	    								current = createModelElement(grammarAccess.getActorRule());
            	    							}
            	    						

            	    							newCompositeNode(grammarAccess.getActorAccess().getCriticalsMessageCrossReference_4_2_1_0());
            	    						
            	    pushFollow(FOLLOW_40);
            	    ruleFQN();

            	    state._fsp--;


            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }

            	    // InternalApp.g:3227:5: (otherlv_20= ',' ( ( ruleFQN ) ) )*
            	    loop59:
            	    do {
            	        int alt59=2;
            	        int LA59_0 = input.LA(1);

            	        if ( (LA59_0==21) ) {
            	            alt59=1;
            	        }


            	        switch (alt59) {
            	    	case 1 :
            	    	    // InternalApp.g:3228:6: otherlv_20= ',' ( ( ruleFQN ) )
            	    	    {
            	    	    otherlv_20=(Token)match(input,21,FOLLOW_3); 

            	    	    						newLeafNode(otherlv_20, grammarAccess.getActorAccess().getCommaKeyword_4_2_2_0());
            	    	    					
            	    	    // InternalApp.g:3232:6: ( ( ruleFQN ) )
            	    	    // InternalApp.g:3233:7: ( ruleFQN )
            	    	    {
            	    	    // InternalApp.g:3233:7: ( ruleFQN )
            	    	    // InternalApp.g:3234:8: ruleFQN
            	    	    {

            	    	    								if (current==null) {
            	    	    									current = createModelElement(grammarAccess.getActorRule());
            	    	    								}
            	    	    							

            	    	    								newCompositeNode(grammarAccess.getActorAccess().getCriticalsMessageCrossReference_4_2_2_1_0());
            	    	    							
            	    	    pushFollow(FOLLOW_40);
            	    	    ruleFQN();

            	    	    state._fsp--;


            	    	    								afterParserOrEnumRuleCall();
            	    	    							

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop59;
            	        }
            	    } while (true);

            	    // InternalApp.g:3249:5: (otherlv_22= ';' )?
            	    int alt60=2;
            	    int LA60_0 = input.LA(1);

            	    if ( (LA60_0==22) ) {
            	        alt60=1;
            	    }
            	    switch (alt60) {
            	        case 1 :
            	            // InternalApp.g:3250:6: otherlv_22= ';'
            	            {
            	            otherlv_22=(Token)match(input,22,FOLLOW_39); 

            	            						newLeafNode(otherlv_22, grammarAccess.getActorAccess().getSemicolonKeyword_4_2_3());
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

            // InternalApp.g:3257:3: ( (lv_compsection_23_0= ruleInstanceSection ) )
            // InternalApp.g:3258:4: (lv_compsection_23_0= ruleInstanceSection )
            {
            // InternalApp.g:3258:4: (lv_compsection_23_0= ruleInstanceSection )
            // InternalApp.g:3259:5: lv_compsection_23_0= ruleInstanceSection
            {

            					newCompositeNode(grammarAccess.getActorAccess().getCompsectionInstanceSectionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_41);
            lv_compsection_23_0=ruleInstanceSection();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActorRule());
            					}
            					set(
            						current,
            						"compsection",
            						lv_compsection_23_0,
            						"edu.vanderbilt.riaps.App.InstanceSection");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:3276:3: ( (lv_wires_24_0= ruleWire ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID||LA62_0==68) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalApp.g:3277:4: (lv_wires_24_0= ruleWire )
            	    {
            	    // InternalApp.g:3277:4: (lv_wires_24_0= ruleWire )
            	    // InternalApp.g:3278:5: lv_wires_24_0= ruleWire
            	    {

            	    					newCompositeNode(grammarAccess.getActorAccess().getWiresWireParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_41);
            	    lv_wires_24_0=ruleWire();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getActorRule());
            	    					}
            	    					add(
            	    						current,
            	    						"wires",
            	    						lv_wires_24_0,
            	    						"edu.vanderbilt.riaps.App.Wire");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            otherlv_25=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_25, grammarAccess.getActorAccess().getRightCurlyBracketKeyword_7());
            		

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
    // $ANTLR end "ruleActor"


    // $ANTLR start "entryRuleInstanceSection"
    // InternalApp.g:3303:1: entryRuleInstanceSection returns [EObject current=null] : iv_ruleInstanceSection= ruleInstanceSection EOF ;
    public final EObject entryRuleInstanceSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceSection = null;


        try {
            // InternalApp.g:3303:56: (iv_ruleInstanceSection= ruleInstanceSection EOF )
            // InternalApp.g:3304:2: iv_ruleInstanceSection= ruleInstanceSection EOF
            {
             newCompositeNode(grammarAccess.getInstanceSectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInstanceSection=ruleInstanceSection();

            state._fsp--;

             current =iv_ruleInstanceSection; 
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
    // $ANTLR end "entryRuleInstanceSection"


    // $ANTLR start "ruleInstanceSection"
    // InternalApp.g:3310:1: ruleInstanceSection returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_instances_2_0= ruleInstance ) )+ otherlv_3= '}' ) ;
    public final EObject ruleInstanceSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_instances_2_0 = null;



        	enterRule();

        try {
            // InternalApp.g:3316:2: ( ( () otherlv_1= '{' ( (lv_instances_2_0= ruleInstance ) )+ otherlv_3= '}' ) )
            // InternalApp.g:3317:2: ( () otherlv_1= '{' ( (lv_instances_2_0= ruleInstance ) )+ otherlv_3= '}' )
            {
            // InternalApp.g:3317:2: ( () otherlv_1= '{' ( (lv_instances_2_0= ruleInstance ) )+ otherlv_3= '}' )
            // InternalApp.g:3318:3: () otherlv_1= '{' ( (lv_instances_2_0= ruleInstance ) )+ otherlv_3= '}'
            {
            // InternalApp.g:3318:3: ()
            // InternalApp.g:3319:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInstanceSectionAccess().getInstanceSectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getInstanceSectionAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalApp.g:3329:3: ( (lv_instances_2_0= ruleInstance ) )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_ID) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalApp.g:3330:4: (lv_instances_2_0= ruleInstance )
            	    {
            	    // InternalApp.g:3330:4: (lv_instances_2_0= ruleInstance )
            	    // InternalApp.g:3331:5: lv_instances_2_0= ruleInstance
            	    {

            	    					newCompositeNode(grammarAccess.getInstanceSectionAccess().getInstancesInstanceParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_42);
            	    lv_instances_2_0=ruleInstance();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInstanceSectionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"instances",
            	    						lv_instances_2_0,
            	    						"edu.vanderbilt.riaps.App.Instance");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt63 >= 1 ) break loop63;
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
            } while (true);

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getInstanceSectionAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleInstanceSection"


    // $ANTLR start "entryRuleWire"
    // InternalApp.g:3356:1: entryRuleWire returns [EObject current=null] : iv_ruleWire= ruleWire EOF ;
    public final EObject entryRuleWire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWire = null;


        try {
            // InternalApp.g:3356:45: (iv_ruleWire= ruleWire EOF )
            // InternalApp.g:3357:2: iv_ruleWire= ruleWire EOF
            {
             newCompositeNode(grammarAccess.getWireRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWire=ruleWire();

            state._fsp--;

             current =iv_ruleWire; 
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
    // $ANTLR end "entryRuleWire"


    // $ANTLR start "ruleWire"
    // InternalApp.g:3363:1: ruleWire returns [EObject current=null] : ( () ( ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) ) | ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) ) ) (otherlv_8= ';' )? ) ;
    public final EObject ruleWire() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_ami_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalApp.g:3369:2: ( ( () ( ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) ) | ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) ) ) (otherlv_8= ';' )? ) )
            // InternalApp.g:3370:2: ( () ( ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) ) | ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) ) ) (otherlv_8= ';' )? )
            {
            // InternalApp.g:3370:2: ( () ( ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) ) | ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) ) ) (otherlv_8= ';' )? )
            // InternalApp.g:3371:3: () ( ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) ) | ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) ) ) (otherlv_8= ';' )?
            {
            // InternalApp.g:3371:3: ()
            // InternalApp.g:3372:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getWireAccess().getWireAction_0(),
            					current);
            			

            }

            // InternalApp.g:3378:3: ( ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) ) | ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==RULE_ID) ) {
                alt64=1;
            }
            else if ( (LA64_0==68) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalApp.g:3379:4: ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) )
                    {
                    // InternalApp.g:3379:4: ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) )
                    // InternalApp.g:3380:5: ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) )
                    {
                    // InternalApp.g:3380:5: ( ( ruleFQN ) )
                    // InternalApp.g:3381:6: ( ruleFQN )
                    {
                    // InternalApp.g:3381:6: ( ruleFQN )
                    // InternalApp.g:3382:7: ruleFQN
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getWireRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getWireAccess().getClntClntPortCrossReference_1_0_0_0());
                    						
                    pushFollow(FOLLOW_37);
                    ruleFQN();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,63,FOLLOW_3); 

                    					newLeafNode(otherlv_2, grammarAccess.getWireAccess().getEqualsSignKeyword_1_0_1());
                    				
                    // InternalApp.g:3400:5: ( ( ruleFQN ) )
                    // InternalApp.g:3401:6: ( ruleFQN )
                    {
                    // InternalApp.g:3401:6: ( ruleFQN )
                    // InternalApp.g:3402:7: ruleFQN
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getWireRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getWireAccess().getServerSrvPortCrossReference_1_0_2_0());
                    						
                    pushFollow(FOLLOW_19);
                    ruleFQN();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalApp.g:3418:4: ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) )
                    {
                    // InternalApp.g:3418:4: ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) )
                    // InternalApp.g:3419:5: ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) )
                    {
                    // InternalApp.g:3419:5: ( (lv_ami_4_0= 'ami' ) )
                    // InternalApp.g:3420:6: (lv_ami_4_0= 'ami' )
                    {
                    // InternalApp.g:3420:6: (lv_ami_4_0= 'ami' )
                    // InternalApp.g:3421:7: lv_ami_4_0= 'ami'
                    {
                    lv_ami_4_0=(Token)match(input,68,FOLLOW_3); 

                    							newLeafNode(lv_ami_4_0, grammarAccess.getWireAccess().getAmiAmiKeyword_1_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getWireRule());
                    							}
                    							setWithLastConsumed(current, "ami", true, "ami");
                    						

                    }


                    }

                    // InternalApp.g:3433:5: ( ( ruleFQN ) )
                    // InternalApp.g:3434:6: ( ruleFQN )
                    {
                    // InternalApp.g:3434:6: ( ruleFQN )
                    // InternalApp.g:3435:7: ruleFQN
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getWireRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getWireAccess().getReqReqPortCrossReference_1_1_1_0());
                    						
                    pushFollow(FOLLOW_37);
                    ruleFQN();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_6=(Token)match(input,63,FOLLOW_3); 

                    					newLeafNode(otherlv_6, grammarAccess.getWireAccess().getEqualsSignKeyword_1_1_2());
                    				
                    // InternalApp.g:3453:5: ( ( ruleFQN ) )
                    // InternalApp.g:3454:6: ( ruleFQN )
                    {
                    // InternalApp.g:3454:6: ( ruleFQN )
                    // InternalApp.g:3455:7: ruleFQN
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getWireRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getWireAccess().getServerSrvPortCrossReference_1_1_3_0());
                    						
                    pushFollow(FOLLOW_19);
                    ruleFQN();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalApp.g:3471:3: (otherlv_8= ';' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==22) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalApp.g:3472:4: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getWireAccess().getSemicolonKeyword_2());
                    			

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
    // $ANTLR end "ruleWire"


    // $ANTLR start "entryRuleActual"
    // InternalApp.g:3481:1: entryRuleActual returns [EObject current=null] : iv_ruleActual= ruleActual EOF ;
    public final EObject entryRuleActual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActual = null;


        try {
            // InternalApp.g:3481:47: (iv_ruleActual= ruleActual EOF )
            // InternalApp.g:3482:2: iv_ruleActual= ruleActual EOF
            {
             newCompositeNode(grammarAccess.getActualRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActual=ruleActual();

            state._fsp--;

             current =iv_ruleActual; 
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
    // $ANTLR end "entryRuleActual"


    // $ANTLR start "ruleActual"
    // InternalApp.g:3488:1: ruleActual returns [EObject current=null] : ( ( ( ruleFQN ) ) otherlv_1= '=' ( (lv_argValue_2_0= ruleActualValue ) ) ) ;
    public final EObject ruleActual() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_argValue_2_0 = null;



        	enterRule();

        try {
            // InternalApp.g:3494:2: ( ( ( ( ruleFQN ) ) otherlv_1= '=' ( (lv_argValue_2_0= ruleActualValue ) ) ) )
            // InternalApp.g:3495:2: ( ( ( ruleFQN ) ) otherlv_1= '=' ( (lv_argValue_2_0= ruleActualValue ) ) )
            {
            // InternalApp.g:3495:2: ( ( ( ruleFQN ) ) otherlv_1= '=' ( (lv_argValue_2_0= ruleActualValue ) ) )
            // InternalApp.g:3496:3: ( ( ruleFQN ) ) otherlv_1= '=' ( (lv_argValue_2_0= ruleActualValue ) )
            {
            // InternalApp.g:3496:3: ( ( ruleFQN ) )
            // InternalApp.g:3497:4: ( ruleFQN )
            {
            // InternalApp.g:3497:4: ( ruleFQN )
            // InternalApp.g:3498:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActualRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActualAccess().getArgNameComponentFormalCrossReference_0_0());
            				
            pushFollow(FOLLOW_37);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,63,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getActualAccess().getEqualsSignKeyword_1());
            		
            // InternalApp.g:3516:3: ( (lv_argValue_2_0= ruleActualValue ) )
            // InternalApp.g:3517:4: (lv_argValue_2_0= ruleActualValue )
            {
            // InternalApp.g:3517:4: (lv_argValue_2_0= ruleActualValue )
            // InternalApp.g:3518:5: lv_argValue_2_0= ruleActualValue
            {

            					newCompositeNode(grammarAccess.getActualAccess().getArgValueActualValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_argValue_2_0=ruleActualValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActualRule());
            					}
            					set(
            						current,
            						"argValue",
            						lv_argValue_2_0,
            						"edu.vanderbilt.riaps.App.ActualValue");
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
    // $ANTLR end "ruleActual"


    // $ANTLR start "entryRuleActualValue"
    // InternalApp.g:3539:1: entryRuleActualValue returns [EObject current=null] : iv_ruleActualValue= ruleActualValue EOF ;
    public final EObject entryRuleActualValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualValue = null;


        try {
            // InternalApp.g:3539:52: (iv_ruleActualValue= ruleActualValue EOF )
            // InternalApp.g:3540:2: iv_ruleActualValue= ruleActualValue EOF
            {
             newCompositeNode(grammarAccess.getActualValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActualValue=ruleActualValue();

            state._fsp--;

             current =iv_ruleActualValue; 
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
    // $ANTLR end "entryRuleActualValue"


    // $ANTLR start "ruleActualValue"
    // InternalApp.g:3546:1: ruleActualValue returns [EObject current=null] : ( ( (lv_stringdefault_0_0= ruleStringDefault ) ) | ( (lv_numberdefault_1_0= ruleNumberDefault ) ) | ( (lv_boolDefault_2_0= ruleBoolDefault ) ) | ( ( ruleFQN ) ) ) ;
    public final EObject ruleActualValue() throws RecognitionException {
        EObject current = null;

        EObject lv_stringdefault_0_0 = null;

        EObject lv_numberdefault_1_0 = null;

        EObject lv_boolDefault_2_0 = null;



        	enterRule();

        try {
            // InternalApp.g:3552:2: ( ( ( (lv_stringdefault_0_0= ruleStringDefault ) ) | ( (lv_numberdefault_1_0= ruleNumberDefault ) ) | ( (lv_boolDefault_2_0= ruleBoolDefault ) ) | ( ( ruleFQN ) ) ) )
            // InternalApp.g:3553:2: ( ( (lv_stringdefault_0_0= ruleStringDefault ) ) | ( (lv_numberdefault_1_0= ruleNumberDefault ) ) | ( (lv_boolDefault_2_0= ruleBoolDefault ) ) | ( ( ruleFQN ) ) )
            {
            // InternalApp.g:3553:2: ( ( (lv_stringdefault_0_0= ruleStringDefault ) ) | ( (lv_numberdefault_1_0= ruleNumberDefault ) ) | ( (lv_boolDefault_2_0= ruleBoolDefault ) ) | ( ( ruleFQN ) ) )
            int alt66=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt66=1;
                }
                break;
            case RULE_INT:
            case RULE_DECIMAL:
                {
                alt66=2;
                }
                break;
            case RULE_BOOL:
                {
                alt66=3;
                }
                break;
            case RULE_ID:
                {
                alt66=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalApp.g:3554:3: ( (lv_stringdefault_0_0= ruleStringDefault ) )
                    {
                    // InternalApp.g:3554:3: ( (lv_stringdefault_0_0= ruleStringDefault ) )
                    // InternalApp.g:3555:4: (lv_stringdefault_0_0= ruleStringDefault )
                    {
                    // InternalApp.g:3555:4: (lv_stringdefault_0_0= ruleStringDefault )
                    // InternalApp.g:3556:5: lv_stringdefault_0_0= ruleStringDefault
                    {

                    					newCompositeNode(grammarAccess.getActualValueAccess().getStringdefaultStringDefaultParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_stringdefault_0_0=ruleStringDefault();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getActualValueRule());
                    					}
                    					set(
                    						current,
                    						"stringdefault",
                    						lv_stringdefault_0_0,
                    						"edu.vanderbilt.riaps.App.StringDefault");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalApp.g:3574:3: ( (lv_numberdefault_1_0= ruleNumberDefault ) )
                    {
                    // InternalApp.g:3574:3: ( (lv_numberdefault_1_0= ruleNumberDefault ) )
                    // InternalApp.g:3575:4: (lv_numberdefault_1_0= ruleNumberDefault )
                    {
                    // InternalApp.g:3575:4: (lv_numberdefault_1_0= ruleNumberDefault )
                    // InternalApp.g:3576:5: lv_numberdefault_1_0= ruleNumberDefault
                    {

                    					newCompositeNode(grammarAccess.getActualValueAccess().getNumberdefaultNumberDefaultParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_numberdefault_1_0=ruleNumberDefault();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getActualValueRule());
                    					}
                    					set(
                    						current,
                    						"numberdefault",
                    						lv_numberdefault_1_0,
                    						"edu.vanderbilt.riaps.App.NumberDefault");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalApp.g:3594:3: ( (lv_boolDefault_2_0= ruleBoolDefault ) )
                    {
                    // InternalApp.g:3594:3: ( (lv_boolDefault_2_0= ruleBoolDefault ) )
                    // InternalApp.g:3595:4: (lv_boolDefault_2_0= ruleBoolDefault )
                    {
                    // InternalApp.g:3595:4: (lv_boolDefault_2_0= ruleBoolDefault )
                    // InternalApp.g:3596:5: lv_boolDefault_2_0= ruleBoolDefault
                    {

                    					newCompositeNode(grammarAccess.getActualValueAccess().getBoolDefaultBoolDefaultParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_boolDefault_2_0=ruleBoolDefault();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getActualValueRule());
                    					}
                    					set(
                    						current,
                    						"boolDefault",
                    						lv_boolDefault_2_0,
                    						"edu.vanderbilt.riaps.App.BoolDefault");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalApp.g:3614:3: ( ( ruleFQN ) )
                    {
                    // InternalApp.g:3614:3: ( ( ruleFQN ) )
                    // InternalApp.g:3615:4: ( ruleFQN )
                    {
                    // InternalApp.g:3615:4: ( ruleFQN )
                    // InternalApp.g:3616:5: ruleFQN
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getActualValueRule());
                    					}
                    				

                    					newCompositeNode(grammarAccess.getActualValueAccess().getParamActorFormalCrossReference_3_0());
                    				
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
    // $ANTLR end "ruleActualValue"


    // $ANTLR start "entryRuleInstance"
    // InternalApp.g:3634:1: entryRuleInstance returns [EObject current=null] : iv_ruleInstance= ruleInstance EOF ;
    public final EObject entryRuleInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstance = null;


        try {
            // InternalApp.g:3634:49: (iv_ruleInstance= ruleInstance EOF )
            // InternalApp.g:3635:2: iv_ruleInstance= ruleInstance EOF
            {
             newCompositeNode(grammarAccess.getInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInstance=ruleInstance();

            state._fsp--;

             current =iv_ruleInstance; 
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
    // $ANTLR end "entryRuleInstance"


    // $ANTLR start "ruleInstance"
    // InternalApp.g:3641:1: ruleInstance returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) (otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')' )? (otherlv_8= ';' )? ) ;
    public final EObject ruleInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_actuals_4_0 = null;

        EObject lv_actuals_6_0 = null;



        	enterRule();

        try {
            // InternalApp.g:3647:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) (otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')' )? (otherlv_8= ';' )? ) )
            // InternalApp.g:3648:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) (otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')' )? (otherlv_8= ';' )? )
            {
            // InternalApp.g:3648:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) (otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')' )? (otherlv_8= ';' )? )
            // InternalApp.g:3649:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) (otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')' )? (otherlv_8= ';' )?
            {
            // InternalApp.g:3649:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalApp.g:3650:4: (lv_name_0_0= RULE_ID )
            {
            // InternalApp.g:3650:4: (lv_name_0_0= RULE_ID )
            // InternalApp.g:3651:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_0_0, grammarAccess.getInstanceAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInstanceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getInstanceAccess().getColonKeyword_1());
            		
            // InternalApp.g:3671:3: ( ( ruleFQN ) )
            // InternalApp.g:3672:4: ( ruleFQN )
            {
            // InternalApp.g:3672:4: ( ruleFQN )
            // InternalApp.g:3673:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInstanceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInstanceAccess().getTypeComponentCrossReference_2_0());
            				
            pushFollow(FOLLOW_44);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:3687:3: (otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')' )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==34) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalApp.g:3688:4: otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,34,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getInstanceAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalApp.g:3692:4: ( (lv_actuals_4_0= ruleActual ) )
                    // InternalApp.g:3693:5: (lv_actuals_4_0= ruleActual )
                    {
                    // InternalApp.g:3693:5: (lv_actuals_4_0= ruleActual )
                    // InternalApp.g:3694:6: lv_actuals_4_0= ruleActual
                    {

                    						newCompositeNode(grammarAccess.getInstanceAccess().getActualsActualParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_actuals_4_0=ruleActual();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInstanceRule());
                    						}
                    						add(
                    							current,
                    							"actuals",
                    							lv_actuals_4_0,
                    							"edu.vanderbilt.riaps.App.Actual");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalApp.g:3711:4: (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==21) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // InternalApp.g:3712:5: otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) )
                    	    {
                    	    otherlv_5=(Token)match(input,21,FOLLOW_3); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getInstanceAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalApp.g:3716:5: ( (lv_actuals_6_0= ruleActual ) )
                    	    // InternalApp.g:3717:6: (lv_actuals_6_0= ruleActual )
                    	    {
                    	    // InternalApp.g:3717:6: (lv_actuals_6_0= ruleActual )
                    	    // InternalApp.g:3718:7: lv_actuals_6_0= ruleActual
                    	    {

                    	    							newCompositeNode(grammarAccess.getInstanceAccess().getActualsActualParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_22);
                    	    lv_actuals_6_0=ruleActual();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getInstanceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"actuals",
                    	    								lv_actuals_6_0,
                    	    								"edu.vanderbilt.riaps.App.Actual");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,35,FOLLOW_19); 

                    				newLeafNode(otherlv_7, grammarAccess.getInstanceAccess().getRightParenthesisKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalApp.g:3741:3: (otherlv_8= ';' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==22) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalApp.g:3742:4: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getInstanceAccess().getSemicolonKeyword_4());
                    			

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
    // $ANTLR end "ruleInstance"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000005048002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000004048002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000001200020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000013C8920000L,0x0000000000000001L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000920000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000013C8020000L,0x0000000000000001L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000020400002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000800200000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x303B010000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x303B010000020000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00000E0200000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000000E000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000100000400002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0FC0000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0004000800000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x4000000000400002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000010000L,0x000000000000000EL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000610000L,0x000000000000000EL});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000020100L,0x0000000000000010L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000020100L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000400400002L});

}