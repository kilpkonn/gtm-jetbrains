package ee.taltech.gtm.actions;

import ee.taltech.gtm.TimeTrackerService;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/** Reset all time counters. */
public class ResetTimeAction extends AnAction {

	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		final Project project = e.getProject();
		if (project == null) {
			return;
		}

		final TimeTrackerService service = project.getService(TimeTrackerService.class);
		if (service == null) {
			return;
		}

		service.addOrResetTotalTimeMs(TimeTrackerService.RESET_TIME_TO_ZERO);
	}

	@Override
	public void update(@NotNull AnActionEvent e) {
		e.getPresentation().setEnabledAndVisible(e.getProject() != null);
	}

	@Override
	public boolean isDumbAware() {
		return true;
	}
}
