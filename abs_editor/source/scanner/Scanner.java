package abs_editor.source.scanner;

import org.eclipse.jface.text.rules.*;

import abs_editor.editor.WhitespaceDetector;
import abs_editor.editor.color_manager.ColorManager;

public class Scanner extends RuleBasedScanner {

	public Scanner(ColorManager manager) {

		IRule[] rules = new IRule[1];
		// Add generic whitespace rule.
		rules[0] = new WhitespaceRule(new WhitespaceDetector());

		setRules(rules);
	}
}
