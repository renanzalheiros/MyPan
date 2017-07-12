package zalho.com.br.mypan.model.binding;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by andrepereira on 04/06/17.
 */

public class ViewDataBindingUtil {

    @BindingAdapter("isGone")
    public static void setIsGone(View view, boolean hide){
        view.setVisibility(hide ? View.GONE : View.VISIBLE);
    }
}
