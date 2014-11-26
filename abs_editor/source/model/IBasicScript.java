package abs_editor.source.model;

import abs_editor.source.error.LexicalErrorException;
import abs_editor.source.error.SyntaxErrorException;

/**
 * 
 */
public interface IBasicScript extends ISourceReference {

    void reconcile()
        throws LexicalErrorException, SyntaxErrorException;

    void addListener(ISourceListener listener);

    void removeListener(ISourceListener listener);

}
