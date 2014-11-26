package abs_editor.source.parser.rule;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;

public class FunctionRule extends MultiLineRule{
   /**
    * Creates a new TagRule object.
    *
    * @param token 
    */
   public FunctionRule(IToken token)
   {
      super("Function ", ")", token);
   }

   /**
    *
    *
    * @param scanner 
    * @param sequence 
    * @param eofAllowed 
    *
    * @return 
    */
   protected boolean sequenceDetected(ICharacterScanner scanner, 
                                        char[] sequence, 
                                        boolean eofAllowed){
      return super.sequenceDetected(scanner, sequence, eofAllowed);
   }
   

}
