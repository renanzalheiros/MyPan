package zalho.com.br.mypan.model.viewmodel;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import zalho.com.br.mypan.events.OrderSkuEvent;
import zalho.com.br.mypan.model.entities.OrderSku;
import zalho.com.br.mypan.model.entities.Product;
import zalho.com.br.mypan.view.util.alert.DialogUtils;
import zalho.com.br.mypan.view.util.dialogs.MyPanDialog;

/**
 * Created by andrepereira on 22/07/17.
 */

public class CartListHolderViewModel {

	private OrderSku orderSku;

	public ObservableField<String> productName = new ObservableField<>();
	public ObservableField<String> productDescription = new ObservableField<>();
	public ObservableField<String> productPrice = new ObservableField<>();
	public ObservableField<String> productImagePath = new ObservableField<>();

	public ObservableField<String> quantidade = new ObservableField<>();
	public ObservableField<String> total = new ObservableField<>();

	public CartListHolderViewModel(OrderSku orderSku) {
		this.orderSku = orderSku;
		Product product = orderSku.getProduct();

		this.productName.set(product.getName());
		this.productDescription.set(product.getDescription());
		this.productPrice.set("R$ " + product.getPrice().toString());
		this.productImagePath.set(product.getProductImagePath());

		this.quantidade.set("Quantidade: " + orderSku.getQuantity());
		this.total.set("Total: R$" + orderSku.getOrderSkuPrice());
	}

	public OrderSku getOrderSku() {
		return orderSku;
	}

	public void setOrderSku(OrderSku orderSku) {
		this.orderSku = orderSku;
	}

	public String quantidade(View view){
		return "Quantidade: " + orderSku.getQuantity();
	}

	public void alteraQuantidade(View view){
		final MyPanDialog myPanDialog = DialogUtils.createDialog(view.getContext(), "Quantidade de itens", "Digite a quantidade de itens desejada")
				.withSingleLineEdit()
				.withNegativeAction("Cancelar", (dialog, which) -> dialog.dismiss());
		myPanDialog.withPositiveAction("Confirmar",
				(dialog, which) -> EventBus.getDefault().post(new OrderSkuEvent(new OrderSku(orderSku.getProduct(), Integer.parseInt(myPanDialog.getTypedText())))));
		myPanDialog.show();
	}

	public String total(View view){
		return "Total: R$ " + orderSku.getOrderSkuPrice();
	}

	@BindingAdapter("productImage")
	public static void bindProductImage(final ImageView imageView, ObservableField<String> imagePath){
		Picasso.with(imageView.getContext()).load("http://192.168.0.16:9090/mypan/img/products/" + imagePath.get()).into(imageView);
	}
}
