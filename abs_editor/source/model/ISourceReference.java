package abs_editor.source.model;

import org.eclipse.jface.text.IRegion;

/**
 * Common protocol for ABS elements that have associated source code.
 * This set consists of {@link IBasicScript}, {@link ISourceRule} and
 * {@link IDeclaration}.
 */
public interface ISourceReference {

    /**
     * Returns the source code associated with this element.
     * 
     * <p>
     *   This method extracts the substring from the source buffer containing
     *   this source element. This corresponds to the source regione that would
     *   be returned by {@link ISourceReference#getSourceRegion()}</code>.
     * </p>
     * 
     * @return The source code, or <code>null</code> if this element has no 
     *         associated source code
     */
    String getSource();

    /**
     * Returns the source range associated with this element.
     * 
     * @return The source region, or <code>null</code> if this element has no 
     *         associated source code
     */
    IRegion getSourceRegion();

}
