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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_BOOL", "RULE_INT", "RULE_DECIMAL", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'componentCollection'", "'{'", "'}'", "'application'", "'extends'", "'import'", "'*'", "'messageCollection'", "'message'", "':'", "'key'", "';'", "'jar'", "'sharedObject'", "'file'", "'device'", "'('", "','", "')'", "'component'", "'KB'", "'MB'", "'GB'", "'requires'", "'artifact'", "'memory'", "'storage'", "'pub'", "'sub'", "'clt'", "'srv'", "'req'", "'months'", "'days'", "'s'", "'ms'", "'ns'", "'mus'", "'timer'", "'inside'", "'default'", "'='", "'actor'", "'local'", "'internal'", "'ami'"
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
    public static final int RULE_ID=8;
    public static final int RULE_DECIMAL=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
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

                if ( (LA1_0==20) ) {
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

                if ( (LA2_0==15||LA2_0==18||LA2_0==22) ) {
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
            case 22:
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

                if ( (LA8_0==30||LA8_0==34) ) {
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
    // InternalApp.g:498:1: ruleApplication returns [EObject current=null] : ( () otherlv_1= 'application' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_artifacts_6_0= ruleArtifact ) ) | ( (lv_actors_7_0= ruleActor ) ) | ( (lv_components_8_0= ruleComponent ) ) | ( (lv_messages_9_0= ruleMessage ) ) )* otherlv_10= '}' ) ;
    public final EObject ruleApplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_10=null;
        EObject lv_artifacts_6_0 = null;

        EObject lv_actors_7_0 = null;

        EObject lv_components_8_0 = null;

        EObject lv_messages_9_0 = null;



        	enterRule();

        try {
            // InternalApp.g:504:2: ( ( () otherlv_1= 'application' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_artifacts_6_0= ruleArtifact ) ) | ( (lv_actors_7_0= ruleActor ) ) | ( (lv_components_8_0= ruleComponent ) ) | ( (lv_messages_9_0= ruleMessage ) ) )* otherlv_10= '}' ) )
            // InternalApp.g:505:2: ( () otherlv_1= 'application' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_artifacts_6_0= ruleArtifact ) ) | ( (lv_actors_7_0= ruleActor ) ) | ( (lv_components_8_0= ruleComponent ) ) | ( (lv_messages_9_0= ruleMessage ) ) )* otherlv_10= '}' )
            {
            // InternalApp.g:505:2: ( () otherlv_1= 'application' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_artifacts_6_0= ruleArtifact ) ) | ( (lv_actors_7_0= ruleActor ) ) | ( (lv_components_8_0= ruleComponent ) ) | ( (lv_messages_9_0= ruleMessage ) ) )* otherlv_10= '}' )
            // InternalApp.g:506:3: () otherlv_1= 'application' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'extends' ( ( ruleFQN ) ) )? otherlv_5= '{' ( ( (lv_artifacts_6_0= ruleArtifact ) ) | ( (lv_actors_7_0= ruleActor ) ) | ( (lv_components_8_0= ruleComponent ) ) | ( (lv_messages_9_0= ruleMessage ) ) )* otherlv_10= '}'
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
                case 27:
                case 28:
                case 29:
                    {
                    alt10=1;
                    }
                    break;
                case 57:
                    {
                    alt10=2;
                    }
                    break;
                case 30:
                case 34:
                    {
                    alt10=3;
                    }
                    break;
                case 23:
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

            otherlv_10=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getApplicationAccess().getRightCurlyBracketKeyword_6());
            		

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


    // $ANTLR start "entryRuleImport"
    // InternalApp.g:650:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalApp.g:650:47: (iv_ruleImport= ruleImport EOF )
            // InternalApp.g:651:2: iv_ruleImport= ruleImport EOF
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
    // InternalApp.g:657:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;



        	enterRule();

        try {
            // InternalApp.g:663:2: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) ) )
            // InternalApp.g:664:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            {
            // InternalApp.g:664:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) ) )
            // InternalApp.g:665:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalApp.g:669:3: ( (lv_importedNamespace_1_0= ruleImportedFQN ) )
            // InternalApp.g:670:4: (lv_importedNamespace_1_0= ruleImportedFQN )
            {
            // InternalApp.g:670:4: (lv_importedNamespace_1_0= ruleImportedFQN )
            // InternalApp.g:671:5: lv_importedNamespace_1_0= ruleImportedFQN
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
    // InternalApp.g:692:1: entryRuleImportedFQN returns [String current=null] : iv_ruleImportedFQN= ruleImportedFQN EOF ;
    public final String entryRuleImportedFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportedFQN = null;


        try {
            // InternalApp.g:692:51: (iv_ruleImportedFQN= ruleImportedFQN EOF )
            // InternalApp.g:693:2: iv_ruleImportedFQN= ruleImportedFQN EOF
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
    // InternalApp.g:699:1: ruleImportedFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleImportedFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;



        	enterRule();

        try {
            // InternalApp.g:705:2: ( (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? ) )
            // InternalApp.g:706:2: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            {
            // InternalApp.g:706:2: (this_FQN_0= ruleFQN (kw= '.' kw= '*' )? )
            // InternalApp.g:707:3: this_FQN_0= ruleFQN (kw= '.' kw= '*' )?
            {

            			newCompositeNode(grammarAccess.getImportedFQNAccess().getFQNParserRuleCall_0());
            		
            pushFollow(FOLLOW_6);
            this_FQN_0=ruleFQN();

            state._fsp--;


            			current.merge(this_FQN_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalApp.g:717:3: (kw= '.' kw= '*' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==14) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalApp.g:718:4: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,14,FOLLOW_12); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getImportedFQNAccess().getFullStopKeyword_1_0());
                    			
                    kw=(Token)match(input,21,FOLLOW_2); 

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
    // InternalApp.g:733:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalApp.g:733:43: (iv_ruleFQN= ruleFQN EOF )
            // InternalApp.g:734:2: iv_ruleFQN= ruleFQN EOF
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
    // InternalApp.g:740:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalApp.g:746:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalApp.g:747:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalApp.g:747:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalApp.g:748:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
            		
            // InternalApp.g:755:3: (kw= '.' this_ID_2= RULE_ID )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==14) ) {
                    int LA12_2 = input.LA(2);

                    if ( (LA12_2==RULE_ID) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // InternalApp.g:756:4: kw= '.' this_ID_2= RULE_ID
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
            	    break loop12;
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
    // InternalApp.g:773:1: entryRuleMessageCollection returns [EObject current=null] : iv_ruleMessageCollection= ruleMessageCollection EOF ;
    public final EObject entryRuleMessageCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageCollection = null;


        try {
            // InternalApp.g:773:58: (iv_ruleMessageCollection= ruleMessageCollection EOF )
            // InternalApp.g:774:2: iv_ruleMessageCollection= ruleMessageCollection EOF
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
    // InternalApp.g:780:1: ruleMessageCollection returns [EObject current=null] : ( () otherlv_1= 'messageCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}' ) ;
    public final EObject ruleMessageCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_messages_4_0 = null;



        	enterRule();

        try {
            // InternalApp.g:786:2: ( ( () otherlv_1= 'messageCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}' ) )
            // InternalApp.g:787:2: ( () otherlv_1= 'messageCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}' )
            {
            // InternalApp.g:787:2: ( () otherlv_1= 'messageCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}' )
            // InternalApp.g:788:3: () otherlv_1= 'messageCollection' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_messages_4_0= ruleMessage ) )* otherlv_5= '}'
            {
            // InternalApp.g:788:3: ()
            // InternalApp.g:789:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMessageCollectionAccess().getMessageCollectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getMessageCollectionAccess().getMessageCollectionKeyword_1());
            		
            // InternalApp.g:799:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalApp.g:800:4: (lv_name_2_0= RULE_ID )
            {
            // InternalApp.g:800:4: (lv_name_2_0= RULE_ID )
            // InternalApp.g:801:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,16,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getMessageCollectionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalApp.g:821:3: ( (lv_messages_4_0= ruleMessage ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==23) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalApp.g:822:4: (lv_messages_4_0= ruleMessage )
            	    {
            	    // InternalApp.g:822:4: (lv_messages_4_0= ruleMessage )
            	    // InternalApp.g:823:5: lv_messages_4_0= ruleMessage
            	    {

            	    					newCompositeNode(grammarAccess.getMessageCollectionAccess().getMessagesMessageParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_11);
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
            	    break loop13;
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
    // InternalApp.g:848:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalApp.g:848:48: (iv_ruleMessage= ruleMessage EOF )
            // InternalApp.g:849:2: iv_ruleMessage= ruleMessage EOF
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
    // InternalApp.g:855:1: ruleMessage returns [EObject current=null] : (otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= 'key' ( ( ruleFQN ) ) )? (otherlv_6= ';' )? ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalApp.g:861:2: ( (otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= 'key' ( ( ruleFQN ) ) )? (otherlv_6= ';' )? ) )
            // InternalApp.g:862:2: (otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= 'key' ( ( ruleFQN ) ) )? (otherlv_6= ';' )? )
            {
            // InternalApp.g:862:2: (otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= 'key' ( ( ruleFQN ) ) )? (otherlv_6= ';' )? )
            // InternalApp.g:863:3: otherlv_0= 'message' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= 'key' ( ( ruleFQN ) ) )? (otherlv_6= ';' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMessageAccess().getMessageKeyword_0());
            		
            // InternalApp.g:867:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:868:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:868:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:869:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

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

            otherlv_2=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getMessageAccess().getColonKeyword_2());
            		
            // InternalApp.g:889:3: ( ( ruleFQN ) )
            // InternalApp.g:890:4: ( ruleFQN )
            {
            // InternalApp.g:890:4: ( ruleFQN )
            // InternalApp.g:891:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMessageRule());
            					}
            				

            					newCompositeNode(grammarAccess.getMessageAccess().getTypeFStructTypeCrossReference_3_0());
            				
            pushFollow(FOLLOW_14);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:905:3: (otherlv_4= 'key' ( ( ruleFQN ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalApp.g:906:4: otherlv_4= 'key' ( ( ruleFQN ) )
                    {
                    otherlv_4=(Token)match(input,25,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getMessageAccess().getKeyKeyword_4_0());
                    			
                    // InternalApp.g:910:4: ( ( ruleFQN ) )
                    // InternalApp.g:911:5: ( ruleFQN )
                    {
                    // InternalApp.g:911:5: ( ruleFQN )
                    // InternalApp.g:912:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMessageRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getMessageAccess().getKeyFFieldCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_15);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalApp.g:927:3: (otherlv_6= ';' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==26) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalApp.g:928:4: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,26,FOLLOW_2); 

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
    // InternalApp.g:937:1: entryRuleArtifact returns [EObject current=null] : iv_ruleArtifact= ruleArtifact EOF ;
    public final EObject entryRuleArtifact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArtifact = null;


        try {
            // InternalApp.g:937:49: (iv_ruleArtifact= ruleArtifact EOF )
            // InternalApp.g:938:2: iv_ruleArtifact= ruleArtifact EOF
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
    // InternalApp.g:944:1: ruleArtifact returns [EObject current=null] : ( ( ( (lv_jar_0_0= 'jar' ) ) | ( (lv_sharedObject_1_0= 'sharedObject' ) ) | ( (lv_configurationFile_2_0= 'file' ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_path_5_0= RULE_STRING ) ) (otherlv_6= ';' )? ) ;
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
            // InternalApp.g:950:2: ( ( ( ( (lv_jar_0_0= 'jar' ) ) | ( (lv_sharedObject_1_0= 'sharedObject' ) ) | ( (lv_configurationFile_2_0= 'file' ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_path_5_0= RULE_STRING ) ) (otherlv_6= ';' )? ) )
            // InternalApp.g:951:2: ( ( ( (lv_jar_0_0= 'jar' ) ) | ( (lv_sharedObject_1_0= 'sharedObject' ) ) | ( (lv_configurationFile_2_0= 'file' ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_path_5_0= RULE_STRING ) ) (otherlv_6= ';' )? )
            {
            // InternalApp.g:951:2: ( ( ( (lv_jar_0_0= 'jar' ) ) | ( (lv_sharedObject_1_0= 'sharedObject' ) ) | ( (lv_configurationFile_2_0= 'file' ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_path_5_0= RULE_STRING ) ) (otherlv_6= ';' )? )
            // InternalApp.g:952:3: ( ( (lv_jar_0_0= 'jar' ) ) | ( (lv_sharedObject_1_0= 'sharedObject' ) ) | ( (lv_configurationFile_2_0= 'file' ) ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( (lv_path_5_0= RULE_STRING ) ) (otherlv_6= ';' )?
            {
            // InternalApp.g:952:3: ( ( (lv_jar_0_0= 'jar' ) ) | ( (lv_sharedObject_1_0= 'sharedObject' ) ) | ( (lv_configurationFile_2_0= 'file' ) ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt16=1;
                }
                break;
            case 28:
                {
                alt16=2;
                }
                break;
            case 29:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalApp.g:953:4: ( (lv_jar_0_0= 'jar' ) )
                    {
                    // InternalApp.g:953:4: ( (lv_jar_0_0= 'jar' ) )
                    // InternalApp.g:954:5: (lv_jar_0_0= 'jar' )
                    {
                    // InternalApp.g:954:5: (lv_jar_0_0= 'jar' )
                    // InternalApp.g:955:6: lv_jar_0_0= 'jar'
                    {
                    lv_jar_0_0=(Token)match(input,27,FOLLOW_3); 

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
                    // InternalApp.g:968:4: ( (lv_sharedObject_1_0= 'sharedObject' ) )
                    {
                    // InternalApp.g:968:4: ( (lv_sharedObject_1_0= 'sharedObject' ) )
                    // InternalApp.g:969:5: (lv_sharedObject_1_0= 'sharedObject' )
                    {
                    // InternalApp.g:969:5: (lv_sharedObject_1_0= 'sharedObject' )
                    // InternalApp.g:970:6: lv_sharedObject_1_0= 'sharedObject'
                    {
                    lv_sharedObject_1_0=(Token)match(input,28,FOLLOW_3); 

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
                    // InternalApp.g:983:4: ( (lv_configurationFile_2_0= 'file' ) )
                    {
                    // InternalApp.g:983:4: ( (lv_configurationFile_2_0= 'file' ) )
                    // InternalApp.g:984:5: (lv_configurationFile_2_0= 'file' )
                    {
                    // InternalApp.g:984:5: (lv_configurationFile_2_0= 'file' )
                    // InternalApp.g:985:6: lv_configurationFile_2_0= 'file'
                    {
                    lv_configurationFile_2_0=(Token)match(input,29,FOLLOW_3); 

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

            // InternalApp.g:998:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalApp.g:999:4: (lv_name_3_0= RULE_ID )
            {
            // InternalApp.g:999:4: (lv_name_3_0= RULE_ID )
            // InternalApp.g:1000:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_13); 

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

            otherlv_4=(Token)match(input,24,FOLLOW_16); 

            			newLeafNode(otherlv_4, grammarAccess.getArtifactAccess().getColonKeyword_2());
            		
            // InternalApp.g:1020:3: ( (lv_path_5_0= RULE_STRING ) )
            // InternalApp.g:1021:4: (lv_path_5_0= RULE_STRING )
            {
            // InternalApp.g:1021:4: (lv_path_5_0= RULE_STRING )
            // InternalApp.g:1022:5: lv_path_5_0= RULE_STRING
            {
            lv_path_5_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

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

            // InternalApp.g:1038:3: (otherlv_6= ';' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalApp.g:1039:4: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,26,FOLLOW_2); 

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
    // InternalApp.g:1048:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // InternalApp.g:1048:50: (iv_ruleComponent= ruleComponent EOF )
            // InternalApp.g:1049:2: iv_ruleComponent= ruleComponent EOF
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
    // InternalApp.g:1055:1: ruleComponent returns [EObject current=null] : (this_AppComponent_0= ruleAppComponent | this_DeviceComponent_1= ruleDeviceComponent ) ;
    public final EObject ruleComponent() throws RecognitionException {
        EObject current = null;

        EObject this_AppComponent_0 = null;

        EObject this_DeviceComponent_1 = null;



        	enterRule();

        try {
            // InternalApp.g:1061:2: ( (this_AppComponent_0= ruleAppComponent | this_DeviceComponent_1= ruleDeviceComponent ) )
            // InternalApp.g:1062:2: (this_AppComponent_0= ruleAppComponent | this_DeviceComponent_1= ruleDeviceComponent )
            {
            // InternalApp.g:1062:2: (this_AppComponent_0= ruleAppComponent | this_DeviceComponent_1= ruleDeviceComponent )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==34) ) {
                alt18=1;
            }
            else if ( (LA18_0==30) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalApp.g:1063:3: this_AppComponent_0= ruleAppComponent
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
                    // InternalApp.g:1072:3: this_DeviceComponent_1= ruleDeviceComponent
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
    // InternalApp.g:1084:1: entryRuleDeviceComponent returns [EObject current=null] : iv_ruleDeviceComponent= ruleDeviceComponent EOF ;
    public final EObject entryRuleDeviceComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeviceComponent = null;


        try {
            // InternalApp.g:1084:56: (iv_ruleDeviceComponent= ruleDeviceComponent EOF )
            // InternalApp.g:1085:2: iv_ruleDeviceComponent= ruleDeviceComponent EOF
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
    // InternalApp.g:1091:1: ruleDeviceComponent returns [EObject current=null] : (otherlv_0= 'device' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' ) ;
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
            // InternalApp.g:1097:2: ( (otherlv_0= 'device' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' ) )
            // InternalApp.g:1098:2: (otherlv_0= 'device' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' )
            {
            // InternalApp.g:1098:2: (otherlv_0= 'device' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' )
            // InternalApp.g:1099:3: otherlv_0= 'device' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDeviceComponentAccess().getDeviceKeyword_0());
            		
            // InternalApp.g:1103:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:1104:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:1104:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:1105:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); 

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

            // InternalApp.g:1121:3: (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==31) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalApp.g:1122:4: otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getDeviceComponentAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalApp.g:1126:4: ( (lv_formals_3_0= ruleComponentFormal ) )
                    // InternalApp.g:1127:5: (lv_formals_3_0= ruleComponentFormal )
                    {
                    // InternalApp.g:1127:5: (lv_formals_3_0= ruleComponentFormal )
                    // InternalApp.g:1128:6: lv_formals_3_0= ruleComponentFormal
                    {

                    						newCompositeNode(grammarAccess.getDeviceComponentAccess().getFormalsComponentFormalParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_18);
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

                    // InternalApp.g:1145:4: (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==32) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalApp.g:1146:5: otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) )
                    	    {
                    	    otherlv_4=(Token)match(input,32,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDeviceComponentAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalApp.g:1150:5: ( (lv_formals_5_0= ruleComponentFormal ) )
                    	    // InternalApp.g:1151:6: (lv_formals_5_0= ruleComponentFormal )
                    	    {
                    	    // InternalApp.g:1151:6: (lv_formals_5_0= ruleComponentFormal )
                    	    // InternalApp.g:1152:7: lv_formals_5_0= ruleComponentFormal
                    	    {

                    	    							newCompositeNode(grammarAccess.getDeviceComponentAccess().getFormalsComponentFormalParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
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
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,33,FOLLOW_8); 

                    				newLeafNode(otherlv_6, grammarAccess.getDeviceComponentAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_19); 

            			newLeafNode(otherlv_7, grammarAccess.getDeviceComponentAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalApp.g:1179:3: ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==38) ) {
                    alt21=1;
                }
                else if ( ((LA21_0>=42 && LA21_0<=46)||(LA21_0>=53 && LA21_0<=54)) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalApp.g:1180:4: ( (lv_requirements_8_0= ruleRequirement ) )
            	    {
            	    // InternalApp.g:1180:4: ( (lv_requirements_8_0= ruleRequirement ) )
            	    // InternalApp.g:1181:5: (lv_requirements_8_0= ruleRequirement )
            	    {
            	    // InternalApp.g:1181:5: (lv_requirements_8_0= ruleRequirement )
            	    // InternalApp.g:1182:6: lv_requirements_8_0= ruleRequirement
            	    {

            	    						newCompositeNode(grammarAccess.getDeviceComponentAccess().getRequirementsRequirementParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_20);
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
            	    // InternalApp.g:1200:4: ( (lv_ports_9_0= rulePort ) )
            	    {
            	    // InternalApp.g:1200:4: ( (lv_ports_9_0= rulePort ) )
            	    // InternalApp.g:1201:5: (lv_ports_9_0= rulePort )
            	    {
            	    // InternalApp.g:1201:5: (lv_ports_9_0= rulePort )
            	    // InternalApp.g:1202:6: lv_ports_9_0= rulePort
            	    {

            	    						newCompositeNode(grammarAccess.getDeviceComponentAccess().getPortsPortParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_20);
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
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
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
    // InternalApp.g:1228:1: entryRuleAppComponent returns [EObject current=null] : iv_ruleAppComponent= ruleAppComponent EOF ;
    public final EObject entryRuleAppComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAppComponent = null;


        try {
            // InternalApp.g:1228:53: (iv_ruleAppComponent= ruleAppComponent EOF )
            // InternalApp.g:1229:2: iv_ruleAppComponent= ruleAppComponent EOF
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
    // InternalApp.g:1235:1: ruleAppComponent returns [EObject current=null] : (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' ) ;
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
            // InternalApp.g:1241:2: ( (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' ) )
            // InternalApp.g:1242:2: (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' )
            {
            // InternalApp.g:1242:2: (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}' )
            // InternalApp.g:1243:3: otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+ otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAppComponentAccess().getComponentKeyword_0());
            		
            // InternalApp.g:1247:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:1248:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:1248:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:1249:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); 

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

            // InternalApp.g:1265:3: (otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalApp.g:1266:4: otherlv_2= '(' ( (lv_formals_3_0= ruleComponentFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getAppComponentAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalApp.g:1270:4: ( (lv_formals_3_0= ruleComponentFormal ) )
                    // InternalApp.g:1271:5: (lv_formals_3_0= ruleComponentFormal )
                    {
                    // InternalApp.g:1271:5: (lv_formals_3_0= ruleComponentFormal )
                    // InternalApp.g:1272:6: lv_formals_3_0= ruleComponentFormal
                    {

                    						newCompositeNode(grammarAccess.getAppComponentAccess().getFormalsComponentFormalParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_18);
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

                    // InternalApp.g:1289:4: (otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==32) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalApp.g:1290:5: otherlv_4= ',' ( (lv_formals_5_0= ruleComponentFormal ) )
                    	    {
                    	    otherlv_4=(Token)match(input,32,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getAppComponentAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalApp.g:1294:5: ( (lv_formals_5_0= ruleComponentFormal ) )
                    	    // InternalApp.g:1295:6: (lv_formals_5_0= ruleComponentFormal )
                    	    {
                    	    // InternalApp.g:1295:6: (lv_formals_5_0= ruleComponentFormal )
                    	    // InternalApp.g:1296:7: lv_formals_5_0= ruleComponentFormal
                    	    {

                    	    							newCompositeNode(grammarAccess.getAppComponentAccess().getFormalsComponentFormalParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
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
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,33,FOLLOW_8); 

                    				newLeafNode(otherlv_6, grammarAccess.getAppComponentAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_19); 

            			newLeafNode(otherlv_7, grammarAccess.getAppComponentAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalApp.g:1323:3: ( ( (lv_requirements_8_0= ruleRequirement ) ) | ( (lv_ports_9_0= rulePort ) ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=3;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==38) ) {
                    alt24=1;
                }
                else if ( ((LA24_0>=42 && LA24_0<=46)||(LA24_0>=53 && LA24_0<=54)) ) {
                    alt24=2;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalApp.g:1324:4: ( (lv_requirements_8_0= ruleRequirement ) )
            	    {
            	    // InternalApp.g:1324:4: ( (lv_requirements_8_0= ruleRequirement ) )
            	    // InternalApp.g:1325:5: (lv_requirements_8_0= ruleRequirement )
            	    {
            	    // InternalApp.g:1325:5: (lv_requirements_8_0= ruleRequirement )
            	    // InternalApp.g:1326:6: lv_requirements_8_0= ruleRequirement
            	    {

            	    						newCompositeNode(grammarAccess.getAppComponentAccess().getRequirementsRequirementParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_20);
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
            	    // InternalApp.g:1344:4: ( (lv_ports_9_0= rulePort ) )
            	    {
            	    // InternalApp.g:1344:4: ( (lv_ports_9_0= rulePort ) )
            	    // InternalApp.g:1345:5: (lv_ports_9_0= rulePort )
            	    {
            	    // InternalApp.g:1345:5: (lv_ports_9_0= rulePort )
            	    // InternalApp.g:1346:6: lv_ports_9_0= rulePort
            	    {

            	    						newCompositeNode(grammarAccess.getAppComponentAccess().getPortsPortParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_20);
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
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
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
    // InternalApp.g:1372:1: entryRuleMemoryUnits returns [EObject current=null] : iv_ruleMemoryUnits= ruleMemoryUnits EOF ;
    public final EObject entryRuleMemoryUnits() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMemoryUnits = null;


        try {
            // InternalApp.g:1372:52: (iv_ruleMemoryUnits= ruleMemoryUnits EOF )
            // InternalApp.g:1373:2: iv_ruleMemoryUnits= ruleMemoryUnits EOF
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
    // InternalApp.g:1379:1: ruleMemoryUnits returns [EObject current=null] : ( ( (lv_kb_0_0= 'KB' ) ) | ( (lv_mb_1_0= 'MB' ) ) | ( (lv_gb_2_0= 'GB' ) ) ) ;
    public final EObject ruleMemoryUnits() throws RecognitionException {
        EObject current = null;

        Token lv_kb_0_0=null;
        Token lv_mb_1_0=null;
        Token lv_gb_2_0=null;


        	enterRule();

        try {
            // InternalApp.g:1385:2: ( ( ( (lv_kb_0_0= 'KB' ) ) | ( (lv_mb_1_0= 'MB' ) ) | ( (lv_gb_2_0= 'GB' ) ) ) )
            // InternalApp.g:1386:2: ( ( (lv_kb_0_0= 'KB' ) ) | ( (lv_mb_1_0= 'MB' ) ) | ( (lv_gb_2_0= 'GB' ) ) )
            {
            // InternalApp.g:1386:2: ( ( (lv_kb_0_0= 'KB' ) ) | ( (lv_mb_1_0= 'MB' ) ) | ( (lv_gb_2_0= 'GB' ) ) )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt25=1;
                }
                break;
            case 36:
                {
                alt25=2;
                }
                break;
            case 37:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalApp.g:1387:3: ( (lv_kb_0_0= 'KB' ) )
                    {
                    // InternalApp.g:1387:3: ( (lv_kb_0_0= 'KB' ) )
                    // InternalApp.g:1388:4: (lv_kb_0_0= 'KB' )
                    {
                    // InternalApp.g:1388:4: (lv_kb_0_0= 'KB' )
                    // InternalApp.g:1389:5: lv_kb_0_0= 'KB'
                    {
                    lv_kb_0_0=(Token)match(input,35,FOLLOW_2); 

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
                    // InternalApp.g:1402:3: ( (lv_mb_1_0= 'MB' ) )
                    {
                    // InternalApp.g:1402:3: ( (lv_mb_1_0= 'MB' ) )
                    // InternalApp.g:1403:4: (lv_mb_1_0= 'MB' )
                    {
                    // InternalApp.g:1403:4: (lv_mb_1_0= 'MB' )
                    // InternalApp.g:1404:5: lv_mb_1_0= 'MB'
                    {
                    lv_mb_1_0=(Token)match(input,36,FOLLOW_2); 

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
                    // InternalApp.g:1417:3: ( (lv_gb_2_0= 'GB' ) )
                    {
                    // InternalApp.g:1417:3: ( (lv_gb_2_0= 'GB' ) )
                    // InternalApp.g:1418:4: (lv_gb_2_0= 'GB' )
                    {
                    // InternalApp.g:1418:4: (lv_gb_2_0= 'GB' )
                    // InternalApp.g:1419:5: lv_gb_2_0= 'GB'
                    {
                    lv_gb_2_0=(Token)match(input,37,FOLLOW_2); 

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
    // InternalApp.g:1435:1: entryRuleRequirement returns [EObject current=null] : iv_ruleRequirement= ruleRequirement EOF ;
    public final EObject entryRuleRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirement = null;


        try {
            // InternalApp.g:1435:52: (iv_ruleRequirement= ruleRequirement EOF )
            // InternalApp.g:1436:2: iv_ruleRequirement= ruleRequirement EOF
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
    // InternalApp.g:1442:1: ruleRequirement returns [EObject current=null] : (otherlv_0= 'requires' ( (otherlv_1= 'artifact' ( ( ruleFQN ) ) ) | (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) ) | (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) ) | (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) ) ) (otherlv_11= ';' )? ) ;
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
            // InternalApp.g:1448:2: ( (otherlv_0= 'requires' ( (otherlv_1= 'artifact' ( ( ruleFQN ) ) ) | (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) ) | (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) ) | (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) ) ) (otherlv_11= ';' )? ) )
            // InternalApp.g:1449:2: (otherlv_0= 'requires' ( (otherlv_1= 'artifact' ( ( ruleFQN ) ) ) | (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) ) | (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) ) | (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) ) ) (otherlv_11= ';' )? )
            {
            // InternalApp.g:1449:2: (otherlv_0= 'requires' ( (otherlv_1= 'artifact' ( ( ruleFQN ) ) ) | (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) ) | (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) ) | (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) ) ) (otherlv_11= ';' )? )
            // InternalApp.g:1450:3: otherlv_0= 'requires' ( (otherlv_1= 'artifact' ( ( ruleFQN ) ) ) | (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) ) | (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) ) | (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) ) ) (otherlv_11= ';' )?
            {
            otherlv_0=(Token)match(input,38,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getRequirementAccess().getRequiresKeyword_0());
            		
            // InternalApp.g:1454:3: ( (otherlv_1= 'artifact' ( ( ruleFQN ) ) ) | (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) ) | (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) ) | (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) ) )
            int alt26=4;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt26=1;
                }
                break;
            case 40:
                {
                alt26=2;
                }
                break;
            case 41:
                {
                alt26=3;
                }
                break;
            case 30:
                {
                alt26=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalApp.g:1455:4: (otherlv_1= 'artifact' ( ( ruleFQN ) ) )
                    {
                    // InternalApp.g:1455:4: (otherlv_1= 'artifact' ( ( ruleFQN ) ) )
                    // InternalApp.g:1456:5: otherlv_1= 'artifact' ( ( ruleFQN ) )
                    {
                    otherlv_1=(Token)match(input,39,FOLLOW_3); 

                    					newLeafNode(otherlv_1, grammarAccess.getRequirementAccess().getArtifactKeyword_1_0_0());
                    				
                    // InternalApp.g:1460:5: ( ( ruleFQN ) )
                    // InternalApp.g:1461:6: ( ruleFQN )
                    {
                    // InternalApp.g:1461:6: ( ruleFQN )
                    // InternalApp.g:1462:7: ruleFQN
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRequirementRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getRequirementAccess().getArtifactrequirementArtifactCrossReference_1_0_1_0());
                    						
                    pushFollow(FOLLOW_15);
                    ruleFQN();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalApp.g:1478:4: (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) )
                    {
                    // InternalApp.g:1478:4: (otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) ) )
                    // InternalApp.g:1479:5: otherlv_3= 'memory' ( (lv_memoryRequirement_4_0= RULE_INT ) ) ( (lv_memoryunit_5_0= ruleMemoryUnits ) )
                    {
                    otherlv_3=(Token)match(input,40,FOLLOW_22); 

                    					newLeafNode(otherlv_3, grammarAccess.getRequirementAccess().getMemoryKeyword_1_1_0());
                    				
                    // InternalApp.g:1483:5: ( (lv_memoryRequirement_4_0= RULE_INT ) )
                    // InternalApp.g:1484:6: (lv_memoryRequirement_4_0= RULE_INT )
                    {
                    // InternalApp.g:1484:6: (lv_memoryRequirement_4_0= RULE_INT )
                    // InternalApp.g:1485:7: lv_memoryRequirement_4_0= RULE_INT
                    {
                    lv_memoryRequirement_4_0=(Token)match(input,RULE_INT,FOLLOW_23); 

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

                    // InternalApp.g:1501:5: ( (lv_memoryunit_5_0= ruleMemoryUnits ) )
                    // InternalApp.g:1502:6: (lv_memoryunit_5_0= ruleMemoryUnits )
                    {
                    // InternalApp.g:1502:6: (lv_memoryunit_5_0= ruleMemoryUnits )
                    // InternalApp.g:1503:7: lv_memoryunit_5_0= ruleMemoryUnits
                    {

                    							newCompositeNode(grammarAccess.getRequirementAccess().getMemoryunitMemoryUnitsParserRuleCall_1_1_2_0());
                    						
                    pushFollow(FOLLOW_15);
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
                    // InternalApp.g:1522:4: (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) )
                    {
                    // InternalApp.g:1522:4: (otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) ) )
                    // InternalApp.g:1523:5: otherlv_6= 'storage' ( (lv_storageRequirement_7_0= RULE_INT ) ) ( (lv_storageunit_8_0= ruleMemoryUnits ) )
                    {
                    otherlv_6=(Token)match(input,41,FOLLOW_22); 

                    					newLeafNode(otherlv_6, grammarAccess.getRequirementAccess().getStorageKeyword_1_2_0());
                    				
                    // InternalApp.g:1527:5: ( (lv_storageRequirement_7_0= RULE_INT ) )
                    // InternalApp.g:1528:6: (lv_storageRequirement_7_0= RULE_INT )
                    {
                    // InternalApp.g:1528:6: (lv_storageRequirement_7_0= RULE_INT )
                    // InternalApp.g:1529:7: lv_storageRequirement_7_0= RULE_INT
                    {
                    lv_storageRequirement_7_0=(Token)match(input,RULE_INT,FOLLOW_23); 

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

                    // InternalApp.g:1545:5: ( (lv_storageunit_8_0= ruleMemoryUnits ) )
                    // InternalApp.g:1546:6: (lv_storageunit_8_0= ruleMemoryUnits )
                    {
                    // InternalApp.g:1546:6: (lv_storageunit_8_0= ruleMemoryUnits )
                    // InternalApp.g:1547:7: lv_storageunit_8_0= ruleMemoryUnits
                    {

                    							newCompositeNode(grammarAccess.getRequirementAccess().getStorageunitMemoryUnitsParserRuleCall_1_2_2_0());
                    						
                    pushFollow(FOLLOW_15);
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
                    // InternalApp.g:1566:4: (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) )
                    {
                    // InternalApp.g:1566:4: (otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) ) )
                    // InternalApp.g:1567:5: otherlv_9= 'device' ( (lv_deviceRequirement_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,30,FOLLOW_16); 

                    					newLeafNode(otherlv_9, grammarAccess.getRequirementAccess().getDeviceKeyword_1_3_0());
                    				
                    // InternalApp.g:1571:5: ( (lv_deviceRequirement_10_0= RULE_STRING ) )
                    // InternalApp.g:1572:6: (lv_deviceRequirement_10_0= RULE_STRING )
                    {
                    // InternalApp.g:1572:6: (lv_deviceRequirement_10_0= RULE_STRING )
                    // InternalApp.g:1573:7: lv_deviceRequirement_10_0= RULE_STRING
                    {
                    lv_deviceRequirement_10_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

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

            // InternalApp.g:1591:3: (otherlv_11= ';' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==26) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalApp.g:1592:4: otherlv_11= ';'
                    {
                    otherlv_11=(Token)match(input,26,FOLLOW_2); 

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
    // InternalApp.g:1601:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // InternalApp.g:1601:45: (iv_rulePort= rulePort EOF )
            // InternalApp.g:1602:2: iv_rulePort= rulePort EOF
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
    // InternalApp.g:1608:1: rulePort returns [EObject current=null] : (this_PubPort_0= rulePubPort | this_SubPort_1= ruleSubPort | this_ClntPort_2= ruleClntPort | this_SrvPort_3= ruleSrvPort | this_ReqPort_4= ruleReqPort | this_TimPort_5= ruleTimPort | this_InsPort_6= ruleInsPort ) ;
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
            // InternalApp.g:1614:2: ( (this_PubPort_0= rulePubPort | this_SubPort_1= ruleSubPort | this_ClntPort_2= ruleClntPort | this_SrvPort_3= ruleSrvPort | this_ReqPort_4= ruleReqPort | this_TimPort_5= ruleTimPort | this_InsPort_6= ruleInsPort ) )
            // InternalApp.g:1615:2: (this_PubPort_0= rulePubPort | this_SubPort_1= ruleSubPort | this_ClntPort_2= ruleClntPort | this_SrvPort_3= ruleSrvPort | this_ReqPort_4= ruleReqPort | this_TimPort_5= ruleTimPort | this_InsPort_6= ruleInsPort )
            {
            // InternalApp.g:1615:2: (this_PubPort_0= rulePubPort | this_SubPort_1= ruleSubPort | this_ClntPort_2= ruleClntPort | this_SrvPort_3= ruleSrvPort | this_ReqPort_4= ruleReqPort | this_TimPort_5= ruleTimPort | this_InsPort_6= ruleInsPort )
            int alt28=7;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt28=1;
                }
                break;
            case 43:
                {
                alt28=2;
                }
                break;
            case 44:
                {
                alt28=3;
                }
                break;
            case 45:
                {
                alt28=4;
                }
                break;
            case 46:
                {
                alt28=5;
                }
                break;
            case 53:
                {
                alt28=6;
                }
                break;
            case 54:
                {
                alt28=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalApp.g:1616:3: this_PubPort_0= rulePubPort
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
                    // InternalApp.g:1625:3: this_SubPort_1= ruleSubPort
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
                    // InternalApp.g:1634:3: this_ClntPort_2= ruleClntPort
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
                    // InternalApp.g:1643:3: this_SrvPort_3= ruleSrvPort
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
                    // InternalApp.g:1652:3: this_ReqPort_4= ruleReqPort
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
                    // InternalApp.g:1661:3: this_TimPort_5= ruleTimPort
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
                    // InternalApp.g:1670:3: this_InsPort_6= ruleInsPort
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


    // $ANTLR start "entryRulePubPort"
    // InternalApp.g:1682:1: entryRulePubPort returns [EObject current=null] : iv_rulePubPort= rulePubPort EOF ;
    public final EObject entryRulePubPort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePubPort = null;


        try {
            // InternalApp.g:1682:48: (iv_rulePubPort= rulePubPort EOF )
            // InternalApp.g:1683:2: iv_rulePubPort= rulePubPort EOF
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
    // InternalApp.g:1689:1: rulePubPort returns [EObject current=null] : (otherlv_0= 'pub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= ';' )? ) ;
    public final EObject rulePubPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalApp.g:1695:2: ( (otherlv_0= 'pub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= ';' )? ) )
            // InternalApp.g:1696:2: (otherlv_0= 'pub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= ';' )? )
            {
            // InternalApp.g:1696:2: (otherlv_0= 'pub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= ';' )? )
            // InternalApp.g:1697:3: otherlv_0= 'pub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= ';' )?
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPubPortAccess().getPubKeyword_0());
            		
            // InternalApp.g:1701:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:1702:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:1702:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:1703:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

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

            otherlv_2=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getPubPortAccess().getColonKeyword_2());
            		
            // InternalApp.g:1723:3: ( ( ruleFQN ) )
            // InternalApp.g:1724:4: ( ruleFQN )
            {
            // InternalApp.g:1724:4: ( ruleFQN )
            // InternalApp.g:1725:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPubPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPubPortAccess().getTypeMessageCrossReference_3_0());
            				
            pushFollow(FOLLOW_15);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:1739:3: (otherlv_4= ';' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==26) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalApp.g:1740:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getPubPortAccess().getSemicolonKeyword_4());
                    			

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
    // InternalApp.g:1749:1: entryRuleSubPort returns [EObject current=null] : iv_ruleSubPort= ruleSubPort EOF ;
    public final EObject entryRuleSubPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubPort = null;


        try {
            // InternalApp.g:1749:48: (iv_ruleSubPort= ruleSubPort EOF )
            // InternalApp.g:1750:2: iv_ruleSubPort= ruleSubPort EOF
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
    // InternalApp.g:1756:1: ruleSubPort returns [EObject current=null] : (otherlv_0= 'sub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleSubPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalApp.g:1762:2: ( (otherlv_0= 'sub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= ';' )? ) )
            // InternalApp.g:1763:2: (otherlv_0= 'sub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= ';' )? )
            {
            // InternalApp.g:1763:2: (otherlv_0= 'sub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= ';' )? )
            // InternalApp.g:1764:3: otherlv_0= 'sub' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQN ) ) (otherlv_4= ';' )?
            {
            otherlv_0=(Token)match(input,43,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSubPortAccess().getSubKeyword_0());
            		
            // InternalApp.g:1768:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:1769:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:1769:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:1770:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

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

            otherlv_2=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getSubPortAccess().getColonKeyword_2());
            		
            // InternalApp.g:1790:3: ( ( ruleFQN ) )
            // InternalApp.g:1791:4: ( ruleFQN )
            {
            // InternalApp.g:1791:4: ( ruleFQN )
            // InternalApp.g:1792:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubPortAccess().getTypeMessageCrossReference_3_0());
            				
            pushFollow(FOLLOW_15);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:1806:3: (otherlv_4= ';' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==26) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalApp.g:1807:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getSubPortAccess().getSemicolonKeyword_4());
                    			

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


    // $ANTLR start "entryRuleClntPort"
    // InternalApp.g:1816:1: entryRuleClntPort returns [EObject current=null] : iv_ruleClntPort= ruleClntPort EOF ;
    public final EObject entryRuleClntPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClntPort = null;


        try {
            // InternalApp.g:1816:49: (iv_ruleClntPort= ruleClntPort EOF )
            // InternalApp.g:1817:2: iv_ruleClntPort= ruleClntPort EOF
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
    // InternalApp.g:1823:1: ruleClntPort returns [EObject current=null] : (otherlv_0= 'clt' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )? ) ;
    public final EObject ruleClntPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalApp.g:1829:2: ( (otherlv_0= 'clt' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )? ) )
            // InternalApp.g:1830:2: (otherlv_0= 'clt' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )? )
            {
            // InternalApp.g:1830:2: (otherlv_0= 'clt' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )? )
            // InternalApp.g:1831:3: otherlv_0= 'clt' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )?
            {
            otherlv_0=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getClntPortAccess().getCltKeyword_0());
            		
            // InternalApp.g:1835:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:1836:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:1836:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:1837:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

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

            otherlv_2=(Token)match(input,24,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getClntPortAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getClntPortAccess().getLeftParenthesisKeyword_3());
            		
            // InternalApp.g:1861:3: ( ( ruleFQN ) )
            // InternalApp.g:1862:4: ( ruleFQN )
            {
            // InternalApp.g:1862:4: ( ruleFQN )
            // InternalApp.g:1863:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClntPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getClntPortAccess().getReq_typeMessageCrossReference_4_0());
            				
            pushFollow(FOLLOW_25);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getClntPortAccess().getCommaKeyword_5());
            		
            // InternalApp.g:1881:3: ( ( ruleFQN ) )
            // InternalApp.g:1882:4: ( ruleFQN )
            {
            // InternalApp.g:1882:4: ( ruleFQN )
            // InternalApp.g:1883:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClntPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getClntPortAccess().getRep_typeMessageCrossReference_6_0());
            				
            pushFollow(FOLLOW_26);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,33,FOLLOW_15); 

            			newLeafNode(otherlv_7, grammarAccess.getClntPortAccess().getRightParenthesisKeyword_7());
            		
            // InternalApp.g:1901:3: (otherlv_8= ';' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==26) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalApp.g:1902:4: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getClntPortAccess().getSemicolonKeyword_8());
                    			

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
    // InternalApp.g:1911:1: entryRuleSrvPort returns [EObject current=null] : iv_ruleSrvPort= ruleSrvPort EOF ;
    public final EObject entryRuleSrvPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSrvPort = null;


        try {
            // InternalApp.g:1911:48: (iv_ruleSrvPort= ruleSrvPort EOF )
            // InternalApp.g:1912:2: iv_ruleSrvPort= ruleSrvPort EOF
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
    // InternalApp.g:1918:1: ruleSrvPort returns [EObject current=null] : (otherlv_0= 'srv' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )? ) ;
    public final EObject ruleSrvPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalApp.g:1924:2: ( (otherlv_0= 'srv' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )? ) )
            // InternalApp.g:1925:2: (otherlv_0= 'srv' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )? )
            {
            // InternalApp.g:1925:2: (otherlv_0= 'srv' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )? )
            // InternalApp.g:1926:3: otherlv_0= 'srv' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )?
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSrvPortAccess().getSrvKeyword_0());
            		
            // InternalApp.g:1930:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:1931:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:1931:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:1932:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

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

            otherlv_2=(Token)match(input,24,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getSrvPortAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getSrvPortAccess().getLeftParenthesisKeyword_3());
            		
            // InternalApp.g:1956:3: ( ( ruleFQN ) )
            // InternalApp.g:1957:4: ( ruleFQN )
            {
            // InternalApp.g:1957:4: ( ruleFQN )
            // InternalApp.g:1958:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSrvPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSrvPortAccess().getReq_typeMessageCrossReference_4_0());
            				
            pushFollow(FOLLOW_25);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getSrvPortAccess().getCommaKeyword_5());
            		
            // InternalApp.g:1976:3: ( ( ruleFQN ) )
            // InternalApp.g:1977:4: ( ruleFQN )
            {
            // InternalApp.g:1977:4: ( ruleFQN )
            // InternalApp.g:1978:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSrvPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSrvPortAccess().getRep_typeMessageCrossReference_6_0());
            				
            pushFollow(FOLLOW_26);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,33,FOLLOW_15); 

            			newLeafNode(otherlv_7, grammarAccess.getSrvPortAccess().getRightParenthesisKeyword_7());
            		
            // InternalApp.g:1996:3: (otherlv_8= ';' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==26) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalApp.g:1997:4: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getSrvPortAccess().getSemicolonKeyword_8());
                    			

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
    // InternalApp.g:2006:1: entryRuleReqPort returns [EObject current=null] : iv_ruleReqPort= ruleReqPort EOF ;
    public final EObject entryRuleReqPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqPort = null;


        try {
            // InternalApp.g:2006:48: (iv_ruleReqPort= ruleReqPort EOF )
            // InternalApp.g:2007:2: iv_ruleReqPort= ruleReqPort EOF
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
    // InternalApp.g:2013:1: ruleReqPort returns [EObject current=null] : (otherlv_0= 'req' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )? ) ;
    public final EObject ruleReqPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalApp.g:2019:2: ( (otherlv_0= 'req' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )? ) )
            // InternalApp.g:2020:2: (otherlv_0= 'req' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )? )
            {
            // InternalApp.g:2020:2: (otherlv_0= 'req' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )? )
            // InternalApp.g:2021:3: otherlv_0= 'req' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' otherlv_3= '(' ( ( ruleFQN ) ) otherlv_5= ',' ( ( ruleFQN ) ) otherlv_7= ')' (otherlv_8= ';' )?
            {
            otherlv_0=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getReqPortAccess().getReqKeyword_0());
            		
            // InternalApp.g:2025:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:2026:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:2026:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:2027:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

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

            otherlv_2=(Token)match(input,24,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getReqPortAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getReqPortAccess().getLeftParenthesisKeyword_3());
            		
            // InternalApp.g:2051:3: ( ( ruleFQN ) )
            // InternalApp.g:2052:4: ( ruleFQN )
            {
            // InternalApp.g:2052:4: ( ruleFQN )
            // InternalApp.g:2053:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReqPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReqPortAccess().getReq_typeMessageCrossReference_4_0());
            				
            pushFollow(FOLLOW_25);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getReqPortAccess().getCommaKeyword_5());
            		
            // InternalApp.g:2071:3: ( ( ruleFQN ) )
            // InternalApp.g:2072:4: ( ruleFQN )
            {
            // InternalApp.g:2072:4: ( ruleFQN )
            // InternalApp.g:2073:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReqPortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReqPortAccess().getRep_typeMessageCrossReference_6_0());
            				
            pushFollow(FOLLOW_26);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,33,FOLLOW_15); 

            			newLeafNode(otherlv_7, grammarAccess.getReqPortAccess().getRightParenthesisKeyword_7());
            		
            // InternalApp.g:2091:3: (otherlv_8= ';' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==26) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalApp.g:2092:4: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getReqPortAccess().getSemicolonKeyword_8());
                    			

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
    // InternalApp.g:2101:1: entryRuleTimeUnit returns [EObject current=null] : iv_ruleTimeUnit= ruleTimeUnit EOF ;
    public final EObject entryRuleTimeUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeUnit = null;


        try {
            // InternalApp.g:2101:49: (iv_ruleTimeUnit= ruleTimeUnit EOF )
            // InternalApp.g:2102:2: iv_ruleTimeUnit= ruleTimeUnit EOF
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
    // InternalApp.g:2108:1: ruleTimeUnit returns [EObject current=null] : ( ( (lv_months_0_0= 'months' ) ) | ( (lv_days_1_0= 'days' ) ) | ( (lv_seconds_2_0= 's' ) ) | ( (lv_milliseconds_3_0= 'ms' ) ) | ( (lv_nanoseconds_4_0= 'ns' ) ) | ( (lv_microseconds_5_0= 'mus' ) ) ) ;
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
            // InternalApp.g:2114:2: ( ( ( (lv_months_0_0= 'months' ) ) | ( (lv_days_1_0= 'days' ) ) | ( (lv_seconds_2_0= 's' ) ) | ( (lv_milliseconds_3_0= 'ms' ) ) | ( (lv_nanoseconds_4_0= 'ns' ) ) | ( (lv_microseconds_5_0= 'mus' ) ) ) )
            // InternalApp.g:2115:2: ( ( (lv_months_0_0= 'months' ) ) | ( (lv_days_1_0= 'days' ) ) | ( (lv_seconds_2_0= 's' ) ) | ( (lv_milliseconds_3_0= 'ms' ) ) | ( (lv_nanoseconds_4_0= 'ns' ) ) | ( (lv_microseconds_5_0= 'mus' ) ) )
            {
            // InternalApp.g:2115:2: ( ( (lv_months_0_0= 'months' ) ) | ( (lv_days_1_0= 'days' ) ) | ( (lv_seconds_2_0= 's' ) ) | ( (lv_milliseconds_3_0= 'ms' ) ) | ( (lv_nanoseconds_4_0= 'ns' ) ) | ( (lv_microseconds_5_0= 'mus' ) ) )
            int alt34=6;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt34=1;
                }
                break;
            case 48:
                {
                alt34=2;
                }
                break;
            case 49:
                {
                alt34=3;
                }
                break;
            case 50:
                {
                alt34=4;
                }
                break;
            case 51:
                {
                alt34=5;
                }
                break;
            case 52:
                {
                alt34=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalApp.g:2116:3: ( (lv_months_0_0= 'months' ) )
                    {
                    // InternalApp.g:2116:3: ( (lv_months_0_0= 'months' ) )
                    // InternalApp.g:2117:4: (lv_months_0_0= 'months' )
                    {
                    // InternalApp.g:2117:4: (lv_months_0_0= 'months' )
                    // InternalApp.g:2118:5: lv_months_0_0= 'months'
                    {
                    lv_months_0_0=(Token)match(input,47,FOLLOW_2); 

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
                    // InternalApp.g:2131:3: ( (lv_days_1_0= 'days' ) )
                    {
                    // InternalApp.g:2131:3: ( (lv_days_1_0= 'days' ) )
                    // InternalApp.g:2132:4: (lv_days_1_0= 'days' )
                    {
                    // InternalApp.g:2132:4: (lv_days_1_0= 'days' )
                    // InternalApp.g:2133:5: lv_days_1_0= 'days'
                    {
                    lv_days_1_0=(Token)match(input,48,FOLLOW_2); 

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
                    // InternalApp.g:2146:3: ( (lv_seconds_2_0= 's' ) )
                    {
                    // InternalApp.g:2146:3: ( (lv_seconds_2_0= 's' ) )
                    // InternalApp.g:2147:4: (lv_seconds_2_0= 's' )
                    {
                    // InternalApp.g:2147:4: (lv_seconds_2_0= 's' )
                    // InternalApp.g:2148:5: lv_seconds_2_0= 's'
                    {
                    lv_seconds_2_0=(Token)match(input,49,FOLLOW_2); 

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
                    // InternalApp.g:2161:3: ( (lv_milliseconds_3_0= 'ms' ) )
                    {
                    // InternalApp.g:2161:3: ( (lv_milliseconds_3_0= 'ms' ) )
                    // InternalApp.g:2162:4: (lv_milliseconds_3_0= 'ms' )
                    {
                    // InternalApp.g:2162:4: (lv_milliseconds_3_0= 'ms' )
                    // InternalApp.g:2163:5: lv_milliseconds_3_0= 'ms'
                    {
                    lv_milliseconds_3_0=(Token)match(input,50,FOLLOW_2); 

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
                    // InternalApp.g:2176:3: ( (lv_nanoseconds_4_0= 'ns' ) )
                    {
                    // InternalApp.g:2176:3: ( (lv_nanoseconds_4_0= 'ns' ) )
                    // InternalApp.g:2177:4: (lv_nanoseconds_4_0= 'ns' )
                    {
                    // InternalApp.g:2177:4: (lv_nanoseconds_4_0= 'ns' )
                    // InternalApp.g:2178:5: lv_nanoseconds_4_0= 'ns'
                    {
                    lv_nanoseconds_4_0=(Token)match(input,51,FOLLOW_2); 

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
                    // InternalApp.g:2191:3: ( (lv_microseconds_5_0= 'mus' ) )
                    {
                    // InternalApp.g:2191:3: ( (lv_microseconds_5_0= 'mus' ) )
                    // InternalApp.g:2192:4: (lv_microseconds_5_0= 'mus' )
                    {
                    // InternalApp.g:2192:4: (lv_microseconds_5_0= 'mus' )
                    // InternalApp.g:2193:5: lv_microseconds_5_0= 'mus'
                    {
                    lv_microseconds_5_0=(Token)match(input,52,FOLLOW_2); 

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
    // InternalApp.g:2209:1: entryRuleTimPort returns [EObject current=null] : iv_ruleTimPort= ruleTimPort EOF ;
    public final EObject entryRuleTimPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimPort = null;


        try {
            // InternalApp.g:2209:48: (iv_ruleTimPort= ruleTimPort EOF )
            // InternalApp.g:2210:2: iv_ruleTimPort= ruleTimPort EOF
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
    // InternalApp.g:2216:1: ruleTimPort returns [EObject current=null] : (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleTimPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_spec_2_0 = null;

        EObject lv_unit_3_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2222:2: ( (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) ) ) (otherlv_4= ';' )? ) )
            // InternalApp.g:2223:2: (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) ) ) (otherlv_4= ';' )? )
            {
            // InternalApp.g:2223:2: (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) ) ) (otherlv_4= ';' )? )
            // InternalApp.g:2224:3: otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) ) ) (otherlv_4= ';' )?
            {
            otherlv_0=(Token)match(input,53,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTimPortAccess().getTimerKeyword_0());
            		
            // InternalApp.g:2228:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:2229:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:2229:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:2230:5: lv_name_1_0= RULE_ID
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

            // InternalApp.g:2246:3: ( ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) ) )
            // InternalApp.g:2247:4: ( (lv_spec_2_0= ruleNumber ) ) ( (lv_unit_3_0= ruleTimeUnit ) )
            {
            // InternalApp.g:2247:4: ( (lv_spec_2_0= ruleNumber ) )
            // InternalApp.g:2248:5: (lv_spec_2_0= ruleNumber )
            {
            // InternalApp.g:2248:5: (lv_spec_2_0= ruleNumber )
            // InternalApp.g:2249:6: lv_spec_2_0= ruleNumber
            {

            						newCompositeNode(grammarAccess.getTimPortAccess().getSpecNumberParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_27);
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

            // InternalApp.g:2266:4: ( (lv_unit_3_0= ruleTimeUnit ) )
            // InternalApp.g:2267:5: (lv_unit_3_0= ruleTimeUnit )
            {
            // InternalApp.g:2267:5: (lv_unit_3_0= ruleTimeUnit )
            // InternalApp.g:2268:6: lv_unit_3_0= ruleTimeUnit
            {

            						newCompositeNode(grammarAccess.getTimPortAccess().getUnitTimeUnitParserRuleCall_2_1_0());
            					
            pushFollow(FOLLOW_15);
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

            // InternalApp.g:2286:3: (otherlv_4= ';' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==26) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalApp.g:2287:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_2); 

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
    // InternalApp.g:2296:1: entryRuleInsPort returns [EObject current=null] : iv_ruleInsPort= ruleInsPort EOF ;
    public final EObject entryRuleInsPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInsPort = null;


        try {
            // InternalApp.g:2296:48: (iv_ruleInsPort= ruleInsPort EOF )
            // InternalApp.g:2297:2: iv_ruleInsPort= ruleInsPort EOF
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
    // InternalApp.g:2303:1: ruleInsPort returns [EObject current=null] : (otherlv_0= 'inside' ( (lv_name_1_0= RULE_ID ) ) ( (lv_spec_2_0= 'default' ) )? (otherlv_3= ';' )? ) ;
    public final EObject ruleInsPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_spec_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalApp.g:2309:2: ( (otherlv_0= 'inside' ( (lv_name_1_0= RULE_ID ) ) ( (lv_spec_2_0= 'default' ) )? (otherlv_3= ';' )? ) )
            // InternalApp.g:2310:2: (otherlv_0= 'inside' ( (lv_name_1_0= RULE_ID ) ) ( (lv_spec_2_0= 'default' ) )? (otherlv_3= ';' )? )
            {
            // InternalApp.g:2310:2: (otherlv_0= 'inside' ( (lv_name_1_0= RULE_ID ) ) ( (lv_spec_2_0= 'default' ) )? (otherlv_3= ';' )? )
            // InternalApp.g:2311:3: otherlv_0= 'inside' ( (lv_name_1_0= RULE_ID ) ) ( (lv_spec_2_0= 'default' ) )? (otherlv_3= ';' )?
            {
            otherlv_0=(Token)match(input,54,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getInsPortAccess().getInsideKeyword_0());
            		
            // InternalApp.g:2315:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:2316:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:2316:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:2317:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_28); 

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

            // InternalApp.g:2333:3: ( (lv_spec_2_0= 'default' ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==55) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalApp.g:2334:4: (lv_spec_2_0= 'default' )
                    {
                    // InternalApp.g:2334:4: (lv_spec_2_0= 'default' )
                    // InternalApp.g:2335:5: lv_spec_2_0= 'default'
                    {
                    lv_spec_2_0=(Token)match(input,55,FOLLOW_15); 

                    					newLeafNode(lv_spec_2_0, grammarAccess.getInsPortAccess().getSpecDefaultKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInsPortRule());
                    					}
                    					setWithLastConsumed(current, "spec", true, "default");
                    				

                    }


                    }
                    break;

            }

            // InternalApp.g:2347:3: (otherlv_3= ';' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==26) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalApp.g:2348:4: otherlv_3= ';'
                    {
                    otherlv_3=(Token)match(input,26,FOLLOW_2); 

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
    // InternalApp.g:2357:1: entryRuleComponentFormal returns [EObject current=null] : iv_ruleComponentFormal= ruleComponentFormal EOF ;
    public final EObject entryRuleComponentFormal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentFormal = null;


        try {
            // InternalApp.g:2357:56: (iv_ruleComponentFormal= ruleComponentFormal EOF )
            // InternalApp.g:2358:2: iv_ruleComponentFormal= ruleComponentFormal EOF
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
    // InternalApp.g:2364:1: ruleComponentFormal returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) ) ;
    public final EObject ruleComponentFormal() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_argDefault_2_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2370:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) ) )
            // InternalApp.g:2371:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) )
            {
            // InternalApp.g:2371:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) )
            // InternalApp.g:2372:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) )
            {
            // InternalApp.g:2372:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalApp.g:2373:4: (lv_name_0_0= RULE_ID )
            {
            // InternalApp.g:2373:4: (lv_name_0_0= RULE_ID )
            // InternalApp.g:2374:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_29); 

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

            // InternalApp.g:2390:3: (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) )
            // InternalApp.g:2391:4: otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) )
            {
            otherlv_1=(Token)match(input,56,FOLLOW_30); 

            				newLeafNode(otherlv_1, grammarAccess.getComponentFormalAccess().getEqualsSignKeyword_1_0());
            			
            // InternalApp.g:2395:4: ( (lv_argDefault_2_0= ruleFormalDefault ) )
            // InternalApp.g:2396:5: (lv_argDefault_2_0= ruleFormalDefault )
            {
            // InternalApp.g:2396:5: (lv_argDefault_2_0= ruleFormalDefault )
            // InternalApp.g:2397:6: lv_argDefault_2_0= ruleFormalDefault
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
    // InternalApp.g:2419:1: entryRuleActorFormal returns [EObject current=null] : iv_ruleActorFormal= ruleActorFormal EOF ;
    public final EObject entryRuleActorFormal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActorFormal = null;


        try {
            // InternalApp.g:2419:52: (iv_ruleActorFormal= ruleActorFormal EOF )
            // InternalApp.g:2420:2: iv_ruleActorFormal= ruleActorFormal EOF
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
    // InternalApp.g:2426:1: ruleActorFormal returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) ) ;
    public final EObject ruleActorFormal() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_argDefault_2_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2432:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) ) )
            // InternalApp.g:2433:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) )
            {
            // InternalApp.g:2433:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) ) )
            // InternalApp.g:2434:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) )
            {
            // InternalApp.g:2434:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalApp.g:2435:4: (lv_name_0_0= RULE_ID )
            {
            // InternalApp.g:2435:4: (lv_name_0_0= RULE_ID )
            // InternalApp.g:2436:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_29); 

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

            // InternalApp.g:2452:3: (otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) ) )
            // InternalApp.g:2453:4: otherlv_1= '=' ( (lv_argDefault_2_0= ruleFormalDefault ) )
            {
            otherlv_1=(Token)match(input,56,FOLLOW_30); 

            				newLeafNode(otherlv_1, grammarAccess.getActorFormalAccess().getEqualsSignKeyword_1_0());
            			
            // InternalApp.g:2457:4: ( (lv_argDefault_2_0= ruleFormalDefault ) )
            // InternalApp.g:2458:5: (lv_argDefault_2_0= ruleFormalDefault )
            {
            // InternalApp.g:2458:5: (lv_argDefault_2_0= ruleFormalDefault )
            // InternalApp.g:2459:6: lv_argDefault_2_0= ruleFormalDefault
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
    // InternalApp.g:2481:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalApp.g:2481:46: (iv_ruleActor= ruleActor EOF )
            // InternalApp.g:2482:2: iv_ruleActor= ruleActor EOF
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
    // InternalApp.g:2488:1: ruleActor returns [EObject current=null] : (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? )? (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? )? ( (lv_compsection_18_0= ruleInstanceSection ) ) ( (lv_wires_19_0= ruleWire ) )* otherlv_20= '}' ) ;
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
        Token otherlv_20=null;
        EObject lv_formals_3_0 = null;

        EObject lv_formals_5_0 = null;

        EObject lv_compsection_18_0 = null;

        EObject lv_wires_19_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2494:2: ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? )? (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? )? ( (lv_compsection_18_0= ruleInstanceSection ) ) ( (lv_wires_19_0= ruleWire ) )* otherlv_20= '}' ) )
            // InternalApp.g:2495:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? )? (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? )? ( (lv_compsection_18_0= ruleInstanceSection ) ) ( (lv_wires_19_0= ruleWire ) )* otherlv_20= '}' )
            {
            // InternalApp.g:2495:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? )? (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? )? ( (lv_compsection_18_0= ruleInstanceSection ) ) ( (lv_wires_19_0= ruleWire ) )* otherlv_20= '}' )
            // InternalApp.g:2496:3: otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')' )? otherlv_7= '{' (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? )? (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? )? ( (lv_compsection_18_0= ruleInstanceSection ) ) ( (lv_wires_19_0= ruleWire ) )* otherlv_20= '}'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getActorAccess().getActorKeyword_0());
            		
            // InternalApp.g:2500:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalApp.g:2501:4: (lv_name_1_0= RULE_ID )
            {
            // InternalApp.g:2501:4: (lv_name_1_0= RULE_ID )
            // InternalApp.g:2502:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); 

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

            // InternalApp.g:2518:3: (otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==31) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalApp.g:2519:4: otherlv_2= '(' ( (lv_formals_3_0= ruleActorFormal ) ) (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getActorAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalApp.g:2523:4: ( (lv_formals_3_0= ruleActorFormal ) )
                    // InternalApp.g:2524:5: (lv_formals_3_0= ruleActorFormal )
                    {
                    // InternalApp.g:2524:5: (lv_formals_3_0= ruleActorFormal )
                    // InternalApp.g:2525:6: lv_formals_3_0= ruleActorFormal
                    {

                    						newCompositeNode(grammarAccess.getActorAccess().getFormalsActorFormalParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_18);
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

                    // InternalApp.g:2542:4: (otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==32) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalApp.g:2543:5: otherlv_4= ',' ( (lv_formals_5_0= ruleActorFormal ) )
                    	    {
                    	    otherlv_4=(Token)match(input,32,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getActorAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalApp.g:2547:5: ( (lv_formals_5_0= ruleActorFormal ) )
                    	    // InternalApp.g:2548:6: (lv_formals_5_0= ruleActorFormal )
                    	    {
                    	    // InternalApp.g:2548:6: (lv_formals_5_0= ruleActorFormal )
                    	    // InternalApp.g:2549:7: lv_formals_5_0= ruleActorFormal
                    	    {

                    	    							newCompositeNode(grammarAccess.getActorAccess().getFormalsActorFormalParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
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
                    	    break loop38;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,33,FOLLOW_8); 

                    				newLeafNode(otherlv_6, grammarAccess.getActorAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,16,FOLLOW_31); 

            			newLeafNode(otherlv_7, grammarAccess.getActorAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalApp.g:2576:3: (otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )? )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==58) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalApp.g:2577:4: otherlv_8= 'local' ( ( ruleFQN ) ) (otherlv_10= ',' ( ( ruleFQN ) ) )* (otherlv_12= ';' )?
                    {
                    otherlv_8=(Token)match(input,58,FOLLOW_3); 

                    				newLeafNode(otherlv_8, grammarAccess.getActorAccess().getLocalKeyword_4_0());
                    			
                    // InternalApp.g:2581:4: ( ( ruleFQN ) )
                    // InternalApp.g:2582:5: ( ruleFQN )
                    {
                    // InternalApp.g:2582:5: ( ruleFQN )
                    // InternalApp.g:2583:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActorRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getActorAccess().getLocalsMessageCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalApp.g:2597:4: (otherlv_10= ',' ( ( ruleFQN ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==32) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalApp.g:2598:5: otherlv_10= ',' ( ( ruleFQN ) )
                    	    {
                    	    otherlv_10=(Token)match(input,32,FOLLOW_3); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getActorAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalApp.g:2602:5: ( ( ruleFQN ) )
                    	    // InternalApp.g:2603:6: ( ruleFQN )
                    	    {
                    	    // InternalApp.g:2603:6: ( ruleFQN )
                    	    // InternalApp.g:2604:7: ruleFQN
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getActorRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getActorAccess().getLocalsMessageCrossReference_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_32);
                    	    ruleFQN();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    // InternalApp.g:2619:4: (otherlv_12= ';' )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==26) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // InternalApp.g:2620:5: otherlv_12= ';'
                            {
                            otherlv_12=(Token)match(input,26,FOLLOW_31); 

                            					newLeafNode(otherlv_12, grammarAccess.getActorAccess().getSemicolonKeyword_4_3());
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalApp.g:2626:3: (otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )? )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==59) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalApp.g:2627:4: otherlv_13= 'internal' ( ( ruleFQN ) ) (otherlv_15= ',' ( ( ruleFQN ) ) )* (otherlv_17= ';' )?
                    {
                    otherlv_13=(Token)match(input,59,FOLLOW_3); 

                    				newLeafNode(otherlv_13, grammarAccess.getActorAccess().getInternalKeyword_5_0());
                    			
                    // InternalApp.g:2631:4: ( ( ruleFQN ) )
                    // InternalApp.g:2632:5: ( ruleFQN )
                    {
                    // InternalApp.g:2632:5: ( ruleFQN )
                    // InternalApp.g:2633:6: ruleFQN
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActorRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getActorAccess().getInternalsMessageCrossReference_5_1_0());
                    					
                    pushFollow(FOLLOW_32);
                    ruleFQN();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalApp.g:2647:4: (otherlv_15= ',' ( ( ruleFQN ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==32) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalApp.g:2648:5: otherlv_15= ',' ( ( ruleFQN ) )
                    	    {
                    	    otherlv_15=(Token)match(input,32,FOLLOW_3); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getActorAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalApp.g:2652:5: ( ( ruleFQN ) )
                    	    // InternalApp.g:2653:6: ( ruleFQN )
                    	    {
                    	    // InternalApp.g:2653:6: ( ruleFQN )
                    	    // InternalApp.g:2654:7: ruleFQN
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getActorRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getActorAccess().getInternalsMessageCrossReference_5_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_32);
                    	    ruleFQN();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);

                    // InternalApp.g:2669:4: (otherlv_17= ';' )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==26) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalApp.g:2670:5: otherlv_17= ';'
                            {
                            otherlv_17=(Token)match(input,26,FOLLOW_31); 

                            					newLeafNode(otherlv_17, grammarAccess.getActorAccess().getSemicolonKeyword_5_3());
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalApp.g:2676:3: ( (lv_compsection_18_0= ruleInstanceSection ) )
            // InternalApp.g:2677:4: (lv_compsection_18_0= ruleInstanceSection )
            {
            // InternalApp.g:2677:4: (lv_compsection_18_0= ruleInstanceSection )
            // InternalApp.g:2678:5: lv_compsection_18_0= ruleInstanceSection
            {

            					newCompositeNode(grammarAccess.getActorAccess().getCompsectionInstanceSectionParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_33);
            lv_compsection_18_0=ruleInstanceSection();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActorRule());
            					}
            					set(
            						current,
            						"compsection",
            						lv_compsection_18_0,
            						"edu.vanderbilt.riaps.App.InstanceSection");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:2695:3: ( (lv_wires_19_0= ruleWire ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID||LA46_0==60) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalApp.g:2696:4: (lv_wires_19_0= ruleWire )
            	    {
            	    // InternalApp.g:2696:4: (lv_wires_19_0= ruleWire )
            	    // InternalApp.g:2697:5: lv_wires_19_0= ruleWire
            	    {

            	    					newCompositeNode(grammarAccess.getActorAccess().getWiresWireParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_33);
            	    lv_wires_19_0=ruleWire();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getActorRule());
            	    					}
            	    					add(
            	    						current,
            	    						"wires",
            	    						lv_wires_19_0,
            	    						"edu.vanderbilt.riaps.App.Wire");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_20=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_20, grammarAccess.getActorAccess().getRightCurlyBracketKeyword_8());
            		

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
    // InternalApp.g:2722:1: entryRuleInstanceSection returns [EObject current=null] : iv_ruleInstanceSection= ruleInstanceSection EOF ;
    public final EObject entryRuleInstanceSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceSection = null;


        try {
            // InternalApp.g:2722:56: (iv_ruleInstanceSection= ruleInstanceSection EOF )
            // InternalApp.g:2723:2: iv_ruleInstanceSection= ruleInstanceSection EOF
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
    // InternalApp.g:2729:1: ruleInstanceSection returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_instances_2_0= ruleInstance ) )+ otherlv_3= '}' ) ;
    public final EObject ruleInstanceSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_instances_2_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2735:2: ( ( () otherlv_1= '{' ( (lv_instances_2_0= ruleInstance ) )+ otherlv_3= '}' ) )
            // InternalApp.g:2736:2: ( () otherlv_1= '{' ( (lv_instances_2_0= ruleInstance ) )+ otherlv_3= '}' )
            {
            // InternalApp.g:2736:2: ( () otherlv_1= '{' ( (lv_instances_2_0= ruleInstance ) )+ otherlv_3= '}' )
            // InternalApp.g:2737:3: () otherlv_1= '{' ( (lv_instances_2_0= ruleInstance ) )+ otherlv_3= '}'
            {
            // InternalApp.g:2737:3: ()
            // InternalApp.g:2738:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInstanceSectionAccess().getInstanceSectionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getInstanceSectionAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalApp.g:2748:3: ( (lv_instances_2_0= ruleInstance ) )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_ID) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalApp.g:2749:4: (lv_instances_2_0= ruleInstance )
            	    {
            	    // InternalApp.g:2749:4: (lv_instances_2_0= ruleInstance )
            	    // InternalApp.g:2750:5: lv_instances_2_0= ruleInstance
            	    {

            	    					newCompositeNode(grammarAccess.getInstanceSectionAccess().getInstancesInstanceParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_34);
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
            	    if ( cnt47 >= 1 ) break loop47;
                        EarlyExitException eee =
                            new EarlyExitException(47, input);
                        throw eee;
                }
                cnt47++;
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
    // InternalApp.g:2775:1: entryRuleWire returns [EObject current=null] : iv_ruleWire= ruleWire EOF ;
    public final EObject entryRuleWire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWire = null;


        try {
            // InternalApp.g:2775:45: (iv_ruleWire= ruleWire EOF )
            // InternalApp.g:2776:2: iv_ruleWire= ruleWire EOF
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
    // InternalApp.g:2782:1: ruleWire returns [EObject current=null] : ( () ( ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) ) | ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) ) ) (otherlv_8= ';' )? ) ;
    public final EObject ruleWire() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_ami_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalApp.g:2788:2: ( ( () ( ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) ) | ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) ) ) (otherlv_8= ';' )? ) )
            // InternalApp.g:2789:2: ( () ( ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) ) | ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) ) ) (otherlv_8= ';' )? )
            {
            // InternalApp.g:2789:2: ( () ( ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) ) | ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) ) ) (otherlv_8= ';' )? )
            // InternalApp.g:2790:3: () ( ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) ) | ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) ) ) (otherlv_8= ';' )?
            {
            // InternalApp.g:2790:3: ()
            // InternalApp.g:2791:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getWireAccess().getWireAction_0(),
            					current);
            			

            }

            // InternalApp.g:2797:3: ( ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) ) | ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                alt48=1;
            }
            else if ( (LA48_0==60) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalApp.g:2798:4: ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) )
                    {
                    // InternalApp.g:2798:4: ( ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) ) )
                    // InternalApp.g:2799:5: ( ( ruleFQN ) ) otherlv_2= '=' ( ( ruleFQN ) )
                    {
                    // InternalApp.g:2799:5: ( ( ruleFQN ) )
                    // InternalApp.g:2800:6: ( ruleFQN )
                    {
                    // InternalApp.g:2800:6: ( ruleFQN )
                    // InternalApp.g:2801:7: ruleFQN
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getWireRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getWireAccess().getClntClntPortCrossReference_1_0_0_0());
                    						
                    pushFollow(FOLLOW_29);
                    ruleFQN();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,56,FOLLOW_3); 

                    					newLeafNode(otherlv_2, grammarAccess.getWireAccess().getEqualsSignKeyword_1_0_1());
                    				
                    // InternalApp.g:2819:5: ( ( ruleFQN ) )
                    // InternalApp.g:2820:6: ( ruleFQN )
                    {
                    // InternalApp.g:2820:6: ( ruleFQN )
                    // InternalApp.g:2821:7: ruleFQN
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getWireRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getWireAccess().getServerSrvPortCrossReference_1_0_2_0());
                    						
                    pushFollow(FOLLOW_15);
                    ruleFQN();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalApp.g:2837:4: ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) )
                    {
                    // InternalApp.g:2837:4: ( ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) ) )
                    // InternalApp.g:2838:5: ( (lv_ami_4_0= 'ami' ) ) ( ( ruleFQN ) ) otherlv_6= '=' ( ( ruleFQN ) )
                    {
                    // InternalApp.g:2838:5: ( (lv_ami_4_0= 'ami' ) )
                    // InternalApp.g:2839:6: (lv_ami_4_0= 'ami' )
                    {
                    // InternalApp.g:2839:6: (lv_ami_4_0= 'ami' )
                    // InternalApp.g:2840:7: lv_ami_4_0= 'ami'
                    {
                    lv_ami_4_0=(Token)match(input,60,FOLLOW_3); 

                    							newLeafNode(lv_ami_4_0, grammarAccess.getWireAccess().getAmiAmiKeyword_1_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getWireRule());
                    							}
                    							setWithLastConsumed(current, "ami", true, "ami");
                    						

                    }


                    }

                    // InternalApp.g:2852:5: ( ( ruleFQN ) )
                    // InternalApp.g:2853:6: ( ruleFQN )
                    {
                    // InternalApp.g:2853:6: ( ruleFQN )
                    // InternalApp.g:2854:7: ruleFQN
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getWireRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getWireAccess().getReqReqPortCrossReference_1_1_1_0());
                    						
                    pushFollow(FOLLOW_29);
                    ruleFQN();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_6=(Token)match(input,56,FOLLOW_3); 

                    					newLeafNode(otherlv_6, grammarAccess.getWireAccess().getEqualsSignKeyword_1_1_2());
                    				
                    // InternalApp.g:2872:5: ( ( ruleFQN ) )
                    // InternalApp.g:2873:6: ( ruleFQN )
                    {
                    // InternalApp.g:2873:6: ( ruleFQN )
                    // InternalApp.g:2874:7: ruleFQN
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getWireRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getWireAccess().getServerSrvPortCrossReference_1_1_3_0());
                    						
                    pushFollow(FOLLOW_15);
                    ruleFQN();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalApp.g:2890:3: (otherlv_8= ';' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==26) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalApp.g:2891:4: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,26,FOLLOW_2); 

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
    // InternalApp.g:2900:1: entryRuleActual returns [EObject current=null] : iv_ruleActual= ruleActual EOF ;
    public final EObject entryRuleActual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActual = null;


        try {
            // InternalApp.g:2900:47: (iv_ruleActual= ruleActual EOF )
            // InternalApp.g:2901:2: iv_ruleActual= ruleActual EOF
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
    // InternalApp.g:2907:1: ruleActual returns [EObject current=null] : ( ( ( ruleFQN ) ) otherlv_1= '=' ( (lv_argValue_2_0= ruleActualValue ) ) ) ;
    public final EObject ruleActual() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_argValue_2_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2913:2: ( ( ( ( ruleFQN ) ) otherlv_1= '=' ( (lv_argValue_2_0= ruleActualValue ) ) ) )
            // InternalApp.g:2914:2: ( ( ( ruleFQN ) ) otherlv_1= '=' ( (lv_argValue_2_0= ruleActualValue ) ) )
            {
            // InternalApp.g:2914:2: ( ( ( ruleFQN ) ) otherlv_1= '=' ( (lv_argValue_2_0= ruleActualValue ) ) )
            // InternalApp.g:2915:3: ( ( ruleFQN ) ) otherlv_1= '=' ( (lv_argValue_2_0= ruleActualValue ) )
            {
            // InternalApp.g:2915:3: ( ( ruleFQN ) )
            // InternalApp.g:2916:4: ( ruleFQN )
            {
            // InternalApp.g:2916:4: ( ruleFQN )
            // InternalApp.g:2917:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActualRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActualAccess().getArgNameComponentFormalCrossReference_0_0());
            				
            pushFollow(FOLLOW_29);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,56,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getActualAccess().getEqualsSignKeyword_1());
            		
            // InternalApp.g:2935:3: ( (lv_argValue_2_0= ruleActualValue ) )
            // InternalApp.g:2936:4: (lv_argValue_2_0= ruleActualValue )
            {
            // InternalApp.g:2936:4: (lv_argValue_2_0= ruleActualValue )
            // InternalApp.g:2937:5: lv_argValue_2_0= ruleActualValue
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
    // InternalApp.g:2958:1: entryRuleActualValue returns [EObject current=null] : iv_ruleActualValue= ruleActualValue EOF ;
    public final EObject entryRuleActualValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualValue = null;


        try {
            // InternalApp.g:2958:52: (iv_ruleActualValue= ruleActualValue EOF )
            // InternalApp.g:2959:2: iv_ruleActualValue= ruleActualValue EOF
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
    // InternalApp.g:2965:1: ruleActualValue returns [EObject current=null] : ( ( (lv_stringdefault_0_0= ruleStringDefault ) ) | ( (lv_numberdefault_1_0= ruleNumberDefault ) ) | ( (lv_boolDefault_2_0= ruleBoolDefault ) ) | ( ( ruleFQN ) ) ) ;
    public final EObject ruleActualValue() throws RecognitionException {
        EObject current = null;

        EObject lv_stringdefault_0_0 = null;

        EObject lv_numberdefault_1_0 = null;

        EObject lv_boolDefault_2_0 = null;



        	enterRule();

        try {
            // InternalApp.g:2971:2: ( ( ( (lv_stringdefault_0_0= ruleStringDefault ) ) | ( (lv_numberdefault_1_0= ruleNumberDefault ) ) | ( (lv_boolDefault_2_0= ruleBoolDefault ) ) | ( ( ruleFQN ) ) ) )
            // InternalApp.g:2972:2: ( ( (lv_stringdefault_0_0= ruleStringDefault ) ) | ( (lv_numberdefault_1_0= ruleNumberDefault ) ) | ( (lv_boolDefault_2_0= ruleBoolDefault ) ) | ( ( ruleFQN ) ) )
            {
            // InternalApp.g:2972:2: ( ( (lv_stringdefault_0_0= ruleStringDefault ) ) | ( (lv_numberdefault_1_0= ruleNumberDefault ) ) | ( (lv_boolDefault_2_0= ruleBoolDefault ) ) | ( ( ruleFQN ) ) )
            int alt50=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt50=1;
                }
                break;
            case RULE_INT:
            case RULE_DECIMAL:
                {
                alt50=2;
                }
                break;
            case RULE_BOOL:
                {
                alt50=3;
                }
                break;
            case RULE_ID:
                {
                alt50=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalApp.g:2973:3: ( (lv_stringdefault_0_0= ruleStringDefault ) )
                    {
                    // InternalApp.g:2973:3: ( (lv_stringdefault_0_0= ruleStringDefault ) )
                    // InternalApp.g:2974:4: (lv_stringdefault_0_0= ruleStringDefault )
                    {
                    // InternalApp.g:2974:4: (lv_stringdefault_0_0= ruleStringDefault )
                    // InternalApp.g:2975:5: lv_stringdefault_0_0= ruleStringDefault
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
                    // InternalApp.g:2993:3: ( (lv_numberdefault_1_0= ruleNumberDefault ) )
                    {
                    // InternalApp.g:2993:3: ( (lv_numberdefault_1_0= ruleNumberDefault ) )
                    // InternalApp.g:2994:4: (lv_numberdefault_1_0= ruleNumberDefault )
                    {
                    // InternalApp.g:2994:4: (lv_numberdefault_1_0= ruleNumberDefault )
                    // InternalApp.g:2995:5: lv_numberdefault_1_0= ruleNumberDefault
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
                    // InternalApp.g:3013:3: ( (lv_boolDefault_2_0= ruleBoolDefault ) )
                    {
                    // InternalApp.g:3013:3: ( (lv_boolDefault_2_0= ruleBoolDefault ) )
                    // InternalApp.g:3014:4: (lv_boolDefault_2_0= ruleBoolDefault )
                    {
                    // InternalApp.g:3014:4: (lv_boolDefault_2_0= ruleBoolDefault )
                    // InternalApp.g:3015:5: lv_boolDefault_2_0= ruleBoolDefault
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
                    // InternalApp.g:3033:3: ( ( ruleFQN ) )
                    {
                    // InternalApp.g:3033:3: ( ( ruleFQN ) )
                    // InternalApp.g:3034:4: ( ruleFQN )
                    {
                    // InternalApp.g:3034:4: ( ruleFQN )
                    // InternalApp.g:3035:5: ruleFQN
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
    // InternalApp.g:3053:1: entryRuleInstance returns [EObject current=null] : iv_ruleInstance= ruleInstance EOF ;
    public final EObject entryRuleInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstance = null;


        try {
            // InternalApp.g:3053:49: (iv_ruleInstance= ruleInstance EOF )
            // InternalApp.g:3054:2: iv_ruleInstance= ruleInstance EOF
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
    // InternalApp.g:3060:1: ruleInstance returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) (otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')' )? (otherlv_8= ';' )? ) ;
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
            // InternalApp.g:3066:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) (otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')' )? (otherlv_8= ';' )? ) )
            // InternalApp.g:3067:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) (otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')' )? (otherlv_8= ';' )? )
            {
            // InternalApp.g:3067:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) (otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')' )? (otherlv_8= ';' )? )
            // InternalApp.g:3068:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleFQN ) ) (otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')' )? (otherlv_8= ';' )?
            {
            // InternalApp.g:3068:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalApp.g:3069:4: (lv_name_0_0= RULE_ID )
            {
            // InternalApp.g:3069:4: (lv_name_0_0= RULE_ID )
            // InternalApp.g:3070:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_13); 

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

            otherlv_1=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getInstanceAccess().getColonKeyword_1());
            		
            // InternalApp.g:3090:3: ( ( ruleFQN ) )
            // InternalApp.g:3091:4: ( ruleFQN )
            {
            // InternalApp.g:3091:4: ( ruleFQN )
            // InternalApp.g:3092:5: ruleFQN
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInstanceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInstanceAccess().getTypeComponentCrossReference_2_0());
            				
            pushFollow(FOLLOW_36);
            ruleFQN();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalApp.g:3106:3: (otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==31) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalApp.g:3107:4: otherlv_3= '(' ( (lv_actuals_4_0= ruleActual ) ) (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )* otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,31,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getInstanceAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalApp.g:3111:4: ( (lv_actuals_4_0= ruleActual ) )
                    // InternalApp.g:3112:5: (lv_actuals_4_0= ruleActual )
                    {
                    // InternalApp.g:3112:5: (lv_actuals_4_0= ruleActual )
                    // InternalApp.g:3113:6: lv_actuals_4_0= ruleActual
                    {

                    						newCompositeNode(grammarAccess.getInstanceAccess().getActualsActualParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_18);
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

                    // InternalApp.g:3130:4: (otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==32) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalApp.g:3131:5: otherlv_5= ',' ( (lv_actuals_6_0= ruleActual ) )
                    	    {
                    	    otherlv_5=(Token)match(input,32,FOLLOW_3); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getInstanceAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalApp.g:3135:5: ( (lv_actuals_6_0= ruleActual ) )
                    	    // InternalApp.g:3136:6: (lv_actuals_6_0= ruleActual )
                    	    {
                    	    // InternalApp.g:3136:6: (lv_actuals_6_0= ruleActual )
                    	    // InternalApp.g:3137:7: lv_actuals_6_0= ruleActual
                    	    {

                    	    							newCompositeNode(grammarAccess.getInstanceAccess().getActualsActualParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
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
                    	    break loop51;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,33,FOLLOW_15); 

                    				newLeafNode(otherlv_7, grammarAccess.getInstanceAccess().getRightParenthesisKeyword_3_3());
                    			

                    }
                    break;

            }

            // InternalApp.g:3160:3: (otherlv_8= ';' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==26) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalApp.g:3161:4: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,26,FOLLOW_2); 

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
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000548002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000448002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000440020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0200000478820000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000080010000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00607C4000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00607C4000020000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000038040000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000003800000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x001F800000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0080000004000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0C00000000010000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0C00000104010000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x1000000000020100L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000020100L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000084000002L});

}