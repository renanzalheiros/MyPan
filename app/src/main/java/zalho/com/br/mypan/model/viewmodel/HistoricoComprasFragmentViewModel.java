package zalho.com.br.mypan.model.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;

import zalho.com.br.mypan.model.entities.BuyOrder;

/**
 * Created by andrepereira on 25/09/17.
 */

public class HistoricoComprasFragmentViewModel extends BaseObservable {

	public ObservableBoolean loadingListProgress = new ObservableBoolean(true);
	public ObservableArrayList<BuyOrder> orders = new ObservableArrayList<>();

	public HistoricoComprasFragmentViewModel() {

	}

	public void resume() {

	}
}
