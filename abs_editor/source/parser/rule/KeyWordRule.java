package abs_editor.source.parser.rule;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.WordRule;


/**
 * Word rule for Key Words.
 */
public class KeyWordRule extends WordRule implements IPredicateRule {

	private IToken fSuccessToken;

	/**
	 * Constructor for EmptyCommentRule.
	 * 
	 * @param successToken
	 */
	public KeyWordRule(IToken successToken) {
		super(new KeyWordDetector());

		fSuccessToken = successToken;

		addWord("Declare", fSuccessToken); //$NON-NLS-1$
		//addWord("Sub", fSuccessToken); //$NON-NLS-1$
		//addWord("Function", fSuccessToken); //$NON-NLS-1$
		addWord("Const", fSuccessToken); //$NON-NLS-1$
		addWord("End", fSuccessToken); //$NON-NLS-1$
		addWord("Dim", fSuccessToken); //$NON-NLS-1$
		addWord("Select", fSuccessToken); //$NON-NLS-1$
		addWord("Case", fSuccessToken); //$NON-NLS-1$
		addWord("New", fSuccessToken); //$NON-NLS-1$
		addWord("MsgSetThermometer", fSuccessToken); //$NON-NLS-1$
		addWord("If", fSuccessToken); //$NON-NLS-1$
		addWord("End If", fSuccessToken); //$NON-NLS-1$
		addWord("Do", fSuccessToken); //$NON-NLS-1$
		addWord("While", fSuccessToken); //$NON-NLS-1$
		addWord("Wend", fSuccessToken); //$NON-NLS-1$
		addWord("Not", fSuccessToken); //$NON-NLS-1$
		addWord("DateDiff", fSuccessToken); //$NON-NLS-1$
		addWord("And", fSuccessToken); //$NON-NLS-1$
		addWord("Then", fSuccessToken); //$NON-NLS-1$
		addWord("Loop", fSuccessToken); //$NON-NLS-1$
		addWord("MsgClose", fSuccessToken); //$NON-NLS-1$
		addWord("As", fSuccessToken); //$NON-NLS-1$
		addWord("TRUE", fSuccessToken); //$NON-NLS-1$
		addWord("FALSE", fSuccessToken); //$NON-NLS-1$
		addWord("Next", fSuccessToken); //$NON-NLS-1$
		addWord("For", fSuccessToken); //$NON-NLS-1$
	}

	/*
	 * @see IPredicateRule#evaluate(ICharacterScanner, boolean)
	 */
	@Override
	public IToken evaluate(ICharacterScanner scanner, boolean resume) {
		return evaluate(scanner);
	}

	/*
	 * @see IPredicateRule#getSuccessToken()
	 */
	@Override
	public IToken getSuccessToken() {
		return fSuccessToken;
	}
	
	
	/**
	* Detector for key words.
	*/
	static class KeyWordDetector implements IWordDetector {
		public boolean isWordStart(char c) {
		 	return Character.isJavaIdentifierStart(c);
		}

		public boolean isWordPart(char c) {
			return c != ':' && c != '=' && !Character.isSpaceChar(c);
		}    
	}
	
}
