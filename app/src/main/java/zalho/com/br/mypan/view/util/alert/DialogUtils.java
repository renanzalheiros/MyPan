package zalho.com.br.mypan.view.util.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Objects;

import zalho.com.br.mypan.view.util.dialogs.MyPanDialog;

/**
 * Created by andrepereira on 22/07/17.
 */

public class DialogUtils {


	@NonNull
	public static MyPanDialog createDialog(
			@NonNull Context context,
			@Nullable String title,
			@NonNull String message) {

		return new MyPanDialog(context, title, message);
	}

	private static void configureClose(
			String rightButtonLabel,
			String labelCloseDialog,
			final MyPanDialog agileDialog) {

		if (Objects.equals(rightButtonLabel, labelCloseDialog)) {
			agileDialog.withNegativeAction(
					labelCloseDialog,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							agileDialog.dismiss();
						}
					});
		}
	}
}
