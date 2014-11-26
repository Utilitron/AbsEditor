package abs_editor.source.model;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;

import abs_editor.source.model.ISourceReference;

/**
 * 
 */
public class SourceReference implements ISourceReference {

	//------------------------------------------------------
    // Instance Variables 

    /**
     * The associated document.
     */
    private IDocument document;

    /**
     * The region in the document that maps to the source reference.
     */
    private IRegion sourceRegion;

    //------------------------------------------------------
    // Constructors

    /**
     * Constructor.
     * 
     * @param document The document that contains the source reference
     */
    public SourceReference(IDocument document) {
        this.document = document;
    }

    //------------------------------------------------------
    // ISourceReference Implementation 

    /**
     * @see ISourceReference#getSource()
     */
    public String getSource() {
        try {
            return document.get(sourceRegion.getOffset(),
                sourceRegion.getLength());
        } catch (BadLocationException e) {
            throw new IllegalStateException(
                "Model not synchronized with document"); //$NON-NLS-1$
        }
    }

    /**
     * @see ISourceReference#getSourceRegion()
     */
    public IRegion getSourceRegion() {
        return sourceRegion;
    }

    //------------------------------------------------------
    // Public Methods

    public final void setSourceRegion(IRegion region) {
        sourceRegion = new Region(region.getOffset(), region.getLength());
    }

    //------------------------------------------------------
    // Protected Methods 

    protected final IDocument getDocument() {
        return document;
    }

}
