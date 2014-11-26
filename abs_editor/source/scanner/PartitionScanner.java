package abs_editor.source.scanner;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.*;

import abs_editor.source.scanner.rule.EmptyCommentRule;

public class PartitionScanner extends RuleBasedPartitionScanner {
	public final static String MULTI_LINE_COMMENT = "__multi_line_comment";
	public final static String SINGLE_LINE_COMMENT = "__single_line_comment";
	
	public final static String STRING = "__string";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PartitionScanner() {
		super();
		IToken multiLineComment= new Token(MULTI_LINE_COMMENT);
		IToken singleLineComment= new Token(SINGLE_LINE_COMMENT);

		IToken string= new Token(STRING);

		List rules= new ArrayList();

		// Add rules for multi-line comments.
		rules.add(new MultiLineRule("/*", "*/", multiLineComment)); //$NON-NLS-1$ //$NON-NLS-2$
		
		// Add rule for single line comments.
		rules.add(new EndOfLineRule("'", singleLineComment)); //$NON-NLS-1$

		// Add special case empty comment rule.
		EmptyCommentRule emptyCommentRule = new EmptyCommentRule(multiLineComment);
		rules.add(emptyCommentRule);

	
		// Add rule for strings.
		rules.add(new SingleLineRule("\"", "\"", string, '\\')); //$NON-NLS-2$ //$NON-NLS-1$

		
		IPredicateRule[] result = new IPredicateRule[rules.size()];
		rules.toArray(result);
		setPredicateRules(result);

	}
}

