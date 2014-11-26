package abs_editor.source;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import abs_editor.editor.DoubleClickStrategy;
import abs_editor.editor.NonRuleBasedDamagerRepairer;
import abs_editor.editor.color_manager.ColorManager;
import abs_editor.editor.color_manager.IColorConstants;
import abs_editor.source.scanner.PartitionScanner;
import abs_editor.source.scanner.Scanner;
import abs_editor.source.scanner.StringScanner;

public class SourceViewer extends SourceViewerConfiguration {
	private DoubleClickStrategy doubleClickStrategy;
	
	private Scanner scanner;
	private StringScanner stringScanner;
	
	private ColorManager colorManager;

	static class ScannerType {

		public final static String STRING = "string";
		public final static String MULTI_LINE_COMMENT = "multi_line_comment";
		public final static String SINGLE_LINE_COMMENT = "single_line_comment";
		
	}
	
	protected Scanner getScanner() {
		if (scanner == null) {
			scanner = new Scanner(colorManager);
			scanner.setDefaultReturnToken(
				new Token(
					new TextAttribute(
						colorManager.getColor(IColorConstants.DEFAULT))));
		}
		return scanner;
	}
	
	protected StringScanner getStringScanner() {
		if (stringScanner == null) {
			stringScanner = new StringScanner(colorManager);
			stringScanner.setDefaultReturnToken(
				new Token(
					new TextAttribute(
						colorManager.getColor(IColorConstants.STRING))));
		}
		return stringScanner;
	}
	

	public SourceViewer(ColorManager colorManager) {
		this.colorManager = colorManager;
	}
	
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] {
			IDocument.DEFAULT_CONTENT_TYPE,
			PartitionScanner.MULTI_LINE_COMMENT,
			PartitionScanner.SINGLE_LINE_COMMENT,
			
			PartitionScanner.STRING};
	}
	
	public ITextDoubleClickStrategy getDoubleClickStrategy(
		ISourceViewer sourceViewer,
		String contentType) {
		if (doubleClickStrategy == null)
			doubleClickStrategy = new DoubleClickStrategy();
		return doubleClickStrategy;
	}

	protected NonRuleBasedDamagerRepairer getScanner(String type) {
		TextAttribute textAttribute = new TextAttribute(colorManager.getColor(IColorConstants.DEFAULT));
		
		if (type.equals(ScannerType.STRING)) 
			textAttribute = new TextAttribute(colorManager.getColor(IColorConstants.STRING));

		if (type.equals(ScannerType.MULTI_LINE_COMMENT)) 
			textAttribute = new TextAttribute(colorManager.getColor(IColorConstants.MULTI_LINE_COMMENT));

		if (type.equals(ScannerType.SINGLE_LINE_COMMENT)) 
			textAttribute = new TextAttribute(colorManager.getColor(IColorConstants.SINGLE_LINE_COMMENT));
		
		return new NonRuleBasedDamagerRepairer(textAttribute);
	}
	
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		

		NonRuleBasedDamagerRepairer ndr_sl_comment = getScanner(ScannerType.SINGLE_LINE_COMMENT);
		reconciler.setDamager(ndr_sl_comment, PartitionScanner.SINGLE_LINE_COMMENT);
		reconciler.setRepairer(ndr_sl_comment, PartitionScanner.SINGLE_LINE_COMMENT);
		
		NonRuleBasedDamagerRepairer ndr_ml_comment = getScanner(ScannerType.MULTI_LINE_COMMENT);
		reconciler.setDamager(ndr_ml_comment, PartitionScanner.MULTI_LINE_COMMENT);
		reconciler.setRepairer(ndr_ml_comment, PartitionScanner.MULTI_LINE_COMMENT);
		

		NonRuleBasedDamagerRepairer ndr_string = getScanner(ScannerType.STRING);
		reconciler.setDamager(ndr_string, PartitionScanner.STRING);
		reconciler.setRepairer(ndr_string, PartitionScanner.STRING);

		
	return reconciler;
	}

}
