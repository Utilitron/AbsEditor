package abs_editor.source.parser;

import java.util.List;

import abs_editor.source.element.Dim;
import abs_editor.source.element.Function;
import abs_editor.source.element.Sub;
import abs_editor.source.model.BasicScript;


public class SourceParser implements ISourceParser {

	/**
	 * Get a list of the functions in the file.
	 */
	public List<Function> getFunctions(){
		
		return null;
	}

	/**
	 * Get a list of the subs in the file.
	 */
	public List<Sub> getSubs(){
		
		return null;
	}

	/**
	 * Get a list of the global variables in the file.
	 */
	public List<Dim> getGlobals(){
		
		return null;
	}

	/**
	 * Parse all of the functions in the file.
	 */
	public void parseFunctions(){
		
	}

	/**
	 * Parse all of the subs in the file.
	 */
	public void parseSubs(){
		
		
	}

	public SourceParser(BasicScript document) {
		super();
		// TODO Auto-generated constructor stub
	}

}
