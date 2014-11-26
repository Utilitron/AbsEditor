package abs_editor.source.event;

import abs_editor.source.model.IBasicScript;

/**
 * 
 */
public class AbsChangeEvent {

    // Instance Variables ------------------------------------------------------

    /**
     * The abs associated with the change event.
     */
    private IBasicScript fBasicScript;

    // Constructors ------------------------------------------------------------

    /**
     * Constructor.
     * 
     * @param BasicScript The abs that has changed.
     */
    public AbsChangeEvent(IBasicScript BasicScript) {
        this.fBasicScript = BasicScript;
    }

    // Public Methods ----------------------------------------------------------

    /**
     * Returns the abs that has changed.
     * 
     * @return the abs
     */
    public IBasicScript getBasicScript() {
        return this.fBasicScript;
    }

}
