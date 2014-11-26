package abs_editor.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

import abs_editor.source.model.BasicScript;
import abs_editor.source.model.IBasicScript;
import abs_editor.source.scanner.PartitionScanner;

/**
 * 
 */
public class DocumentProvider extends FileDocumentProvider {
    
    //-----------------------------------------------------------
    // FileDocumentProvider Implementation 

	protected IDocument createDocument(Object element) throws CoreException {
		IDocument document = super.createDocument(element);
		if (document != null) {
			IDocumentPartitioner partitioner =
				new FastPartitioner(
					new PartitionScanner(),
					new String[] {PartitionScanner.MULTI_LINE_COMMENT,
								  PartitionScanner.SINGLE_LINE_COMMENT,
								  PartitionScanner.STRING});
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
			
			IBasicScript basicScript = createBasicScript(document);
            if (basicScript instanceof IDocumentListener) 
                document.addDocumentListener((IDocumentListener) basicScript);

		}
		return document;
	}

    // Public Methods ----------------------------------------------------------

    /**
     * Creates the parsed document object corresponding to the specified 
     * document.
     * 
     * @param document the document to parse
     * @return the parsed document
     */
    public IBasicScript createBasicScript(IDocument document) {
        return new BasicScript(document);
    }

}
