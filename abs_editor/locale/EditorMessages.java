package abs_editor.locale;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Utility class that provides easy access to externalized strings.
 */
public final class EditorMessages {

    // Constants ---------------------------------------------------------------

    /**
     * Qualified name of the resource bundle containing the localized messages.
     */
    private static final String RESOURCE_BUNDLE =
        "abs_editor.locale.EditorMessages"; //$NON-NLS-1$

    // Class Variables ---------------------------------------------------------

    /**
     * The resource bundle.
     */
    private static ResourceBundle fgResourceBundle =
        ResourceBundle.getBundle(RESOURCE_BUNDLE);

    // Constructors ------------------------------------------------------------

    /**
     * Hidden constructor.
     */
    private EditorMessages() {
        // Hidden
    }

    // Public Methods ----------------------------------------------------------

    /**
     * Returns the resource bundle.
     * 
     * @return the resource bundle
     */
    public static ResourceBundle getResourceBundle() {
        return fgResourceBundle;
    }

    /**
     * Returns the message identified by the specified key.
     * 
     * @param key the message key
     * @return the localized message, or the key enclosed by exclamation marks
     *         if no message was found for the key
     */
    public static String getString(String key) {
        try {
            return fgResourceBundle.getString(key);
        } catch (MissingResourceException e) {
            return "!" + key + "!"; //$NON-NLS-2$ //$NON-NLS-1$
        }
    }

    /**
     * Returns the message identified by the specified key, replacing a single
     * parameter with the provided value.
     * 
     * @param key the message key
     * @param arg the parameter value
     * @return the formatted string, or the key enclosed by exclamation marks
     *         if no message was found for the key
     */
    public static String getString(String key, String arg) {
        return getString(key, new String[] { arg });
    }

    /**
     * Returns the message identified by the specified key, replacing all
     * parameters with the provided values.
     * 
     * @param key the message key
     * @param args the parameter values
     * @return the formatted string, or the key enclosed by exclamation marks
     *         if no message was found for the key
     */
    public static String getString(String key, Object[] args) {
        return MessageFormat.format(getString(key), args);  
    }

}
