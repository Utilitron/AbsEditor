package abs_editor.source.parser.rule;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.WordRule;

/**
 * Word rule for Data Types.
 */
public class DataTypeRule extends WordRule implements IPredicateRule {

	private IToken fSuccessToken;

	/**
	 * Constructor for EmptyCommentRule.
	 * 
	 * @param successToken
	 */
	public DataTypeRule(IToken successToken) {
		super(new DataTypeDetector());

		fSuccessToken = successToken;

		addWord("As String", fSuccessToken); //$NON-NLS-1$
		addWord("As Integer", fSuccessToken); //$NON-NLS-1$
		addWord("As Double", fSuccessToken); //$NON-NLS-1$
	}

	/*
	 * @see IPredicateRule#evaluate(ICharacterScanner, boolean)
	 */
	public IToken evaluate(ICharacterScanner scanner, boolean resume) {
		return evaluate(scanner);
	}

	/*
	 * @see IPredicateRule#getSuccessToken()
	 */
	public IToken getSuccessToken() {
		return fSuccessToken;
	}
	
	/**
	 * Detector for data types.
	 */
	static class DataTypeDetector implements IWordDetector {
		public boolean isWordStart(char c) {
			return Character.isJavaIdentifierStart(c);
		}

		public boolean isWordPart(char c) {
			return c != ':' && c != '=' && !Character.isSpaceChar(c);
		}
	}
}
