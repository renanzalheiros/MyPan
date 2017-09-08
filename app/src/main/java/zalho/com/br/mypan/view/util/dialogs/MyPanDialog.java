package zalho.com.br.mypan.view.util.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

import zalho.com.br.mypan.R;

/**
 * Created by andrepereira on 22/07/17.
 */

public class MyPanDialog {

	private final AlertDialog.Builder builder;

	private AlertDialog alertDialog;

	public MyPanDialog(Context context, String title, String message){
		this.builder = new AlertDialog.Builder(context)
				.setTitle(title)
				.setMessage(message);
	}

	public MyPanDialog withPositiveAction(
			String actionText,
			DialogInterface.OnClickListener listener) {

		builder.setPositiveButton(actionText, listener);

		return this;
	}

	public MyPanDialog withNegativeAction(
			String actionText,
			DialogInterface.OnClickListener listener) {

		builder.setNegativeButton(actionText, listener);

		return this;
	}

	public MyPanDialog withCancelListener(
			DialogInterface.OnCancelListener cancelListener) {

		builder.setOnCancelListener(cancelListener);
		return this;
	}

	public MyPanDialog withCancelEnabled(boolean cancelEnabled) {
		builder.setCancelable(cancelEnabled);
		return this;
	}

	public MyPanDialog withSingleLineEdit() {
		builder.setView(R.layout.dialog_single_line_edit);
		return this;
	}

	public MyPanDialog withMultiLineEdit() {
		builder.setView(R.layout.dialog_multiple_line_edit);
		return this;
	}

	public final MyPanDialog show() {
		alertDialog = builder.show();
		return this;
	}

	public void dismiss() {
		alertDialog.dismiss();
	}

	public void cancel() {
		alertDialog.cancel();
	}

	public boolean isShowing() {
		return alertDialog != null
				&& alertDialog.isShowing();
	}

	@NonNull
	public String getTypedText() {

		if (alertDialog == null) {
			throw new IllegalStateException("Must call show() before getting the text.");
		}

		EditText editText =
				(EditText) alertDialog.findViewById(R.id.dialog_edit);

		if (editText == null) {
			throw new IllegalStateException("Dialog has no edit.");
		}

		return editText.getText().toString();
	}
}
