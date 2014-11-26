package abs_editor.editor;

import org.eclipse.ui.editors.text.TextEditor;

import abs_editor.source.SourceViewer;
import abs_editor.editor.color_manager.ColorManager;

public class ABSEditor extends TextEditor {

	private ColorManager colorManager;

	public ABSEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new SourceViewer(colorManager));
		setDocumentProvider(new DocumentProvider());
	}
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
