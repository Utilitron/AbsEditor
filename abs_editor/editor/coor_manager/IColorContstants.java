package abs_editor.editor.color_manager;

import org.eclipse.swt.graphics.RGB;

public interface IColorConstants {
	RGB DEFAULT = new RGB(0, 0, 0);
	
	RGB SINGLE_LINE_COMMENT = new RGB(0, 128, 0);
	RGB MULTI_LINE_COMMENT = new RGB(0, 128, 0);
	
	RGB SUB = new RGB(128, 0, 200);
	RGB FUNCTION = new RGB(146, 0, 200);
	
	RGB STRING = new RGB(128, 0, 0);

	RGB KEY_WORD = new RGB(128, 0, 128);
	RGB DATA_TYPE = new RGB(0, 0, 128);
}
