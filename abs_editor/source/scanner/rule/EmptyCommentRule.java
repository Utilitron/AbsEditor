package abs_editor.source.scanner.rule;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.WordRule;

/**
 * Word rule for Key Words.
 */
public class EmptyCommentRule extends WordRule implements IPredicateRule {

	private IToken fSuccessToken;

	/**
	 * Constructor for EmptyCommentRule.
	 * @param successToken
	 */
	public EmptyCommentRule(IToken successToken) {
		super(new EmptyCommentDetector());
		
		fSuccessToken= successToken;
		addWord("/**/", fSuccessToken); //$NON-NLS-1$
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
	* Detector for empty comments.
	*/
	static class EmptyCommentDetector implements IWordDetector {
	
		/*
		* @see IWordDetector#isWordStart
		*/
		public boolean isWordStart(char c) {
			return (c == '/');
		}
	
		/*
		 * @see IWordDetector#isWordPart
		 */
		public boolean isWordPart(char c) {
			return (c == '*' || c == '/');
		}
	}
	
}
