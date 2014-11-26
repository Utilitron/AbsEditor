package abs_editor.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import abs_editor.Activator;


public class AbsPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

		
	public AbsPreferencePage() {
		super();
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	@Override
	protected Control createContents(Composite arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	// IWorkbenchPreferencePage
	@Override
	public void init(IWorkbench arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
