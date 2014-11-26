package abs_editor.source.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;

import abs_editor.source.element.Function;
import abs_editor.source.element.Dim;
import abs_editor.source.element.Sub;
import abs_editor.source.error.LexicalErrorException;
import abs_editor.source.error.SyntaxErrorException;
import abs_editor.source.event.AbsChangeEvent;
import abs_editor.source.model.IBasicScript;
import abs_editor.source.model.ISourceListener;
import abs_editor.source.parser.SourceParser;

/**
 * 
 */
public class BasicScript extends SourceReference
    implements IBasicScript, IDocumentListener {

    // Instance Variables ------------------------------------------------------

	/**
	 * A list of the functions in the file.
	 */
	private List<Function> functions;
	public void addFunction(Function function) { this.functions.add(function); }
	public void removeFunction(Function function) { this.functions.remove(function); }
	
	/**
	 * A list of the subs in the file.
	 */
	private List<Sub> subs;
	public void addSub(Sub sub) { this.subs.add(sub); }
	public void removeSub(Sub sub) { this.subs.remove(sub); }

	/**
	 * A list of the global variables in the file.
	 */
	private List<Dim> globals;
	public void addGlobal(Dim global) { this.globals.add(global); }
	public void removeGlobal(Dim global) { this.globals.remove(global); }
	
    /**
     * The list of change listeners.
     */
    private List<ISourceListener> listeners = new ArrayList<ISourceListener>();

    private Object dirtyLock = new Object();
    private boolean dirty = true;

    // Constructors ------------------------------------------------------------

    /**
     * Constructor.
     * 
     * @param document The document that contains the style sheet
     */
    public BasicScript(IDocument document) {
        super(document);
        
        SourceParser sourceParser = new SourceParser(this);
        functions = sourceParser.getFunctions();
        subs = sourceParser.getSubs();
        
        globals = sourceParser.getGlobals();
    }

    // IBasicScript Implementation ----------------------------------------------

    /*
     * @see IBasicScript#reconcile()
     */
    public void reconcile()
        throws LexicalErrorException, SyntaxErrorException {
        
        synchronized (dirtyLock) {
            if (!dirty) {
                return;
            }
            dirty = false;
        }
        System.out.println("reconcile");
        synchronized (this) {
            //IAbsParser parser = new DefaultParser();
           // parser.setProblemCollector(problemCollector);
            //parser.setSource(getDocument());
           // rules.addAll(Arrays.asList(parser.parseRules(this)));
            fireChangeEvent();
        }
    }

    /*
     * @see IBasicScript#addListener(IBasicScriptListener)
     */
    public void addListener(ISourceListener listener) {
        listeners.add(listener);
    }

    /*
     * @see IBasicScript#removeListener(IBasicScriptListener)
     */
    public void removeListener(ISourceListener listener) {
        listeners.remove(listener);
    }

    // IDocumentListener Implementation ----------------------------------------

    /*
     * @see IDocumentListener#documentAboutToBeChanged(DocumentEvent)
     */
    public void documentAboutToBeChanged(DocumentEvent event) {
        // do nothing yet
    }

    /*
     * @see IDocumentListener#documentChanged(DocumentEvent)
     */
    public void documentChanged(DocumentEvent event) {
        synchronized (dirtyLock) {
            dirty = true;
        }
        
        System.out.println("documentChanged");
    }

    private void fireChangeEvent() {
        AbsChangeEvent event = new AbsChangeEvent(this);
        for (Iterator<ISourceListener> i = listeners.iterator(); i.hasNext(); ) {
            ISourceListener listener = (ISourceListener) i.next();
            listener.absChanged(event);
        }
    }
}
