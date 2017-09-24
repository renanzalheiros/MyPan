package zalho.com.br.mypan.model.viewmodel;

import android.content.DialogInterface;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import zalho.com.br.mypan.events.OrderSkuEvent;
import zalho.com.br.mypan.model.entities.OrderSku;
import zalho.com.br.mypan.model.entities.Product;
import zalho.com.br.mypan.util.Constantes;
import zalho.com.br.mypan.view.util.alert.DialogUtils;
import zalho.com.br.mypan.view.util.dialogs.MyPanDialog;

/**
 * Created by andrepereira on 04/06/17.
 */

public class ProductsListHolderViewModel extends BaseObservable {

    private Product product;

    public ObservableField<String> productName = new ObservableField<>();
    public ObservableField<String> productDescription = new ObservableField<>();
    public ObservableField<String> productPrice = new ObservableField<>();
    public ObservableField<String> productImagePath = new ObservableField<>();

    public ProductsListHolderViewModel(Product product) {
        this.product = product;
        this.productName.set(product.getName());
        this.productDescription.set(product.getDescription());
        this.productPrice.set("R$ " + product.getPrice().toString());
        this.productImagePath.set(product.getProductImagePath());
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct(){
        return this.product;
    }

    public void addToCart(final View view){
	    final MyPanDialog myPanDialog = DialogUtils.createDialog(view.getContext(), "Quantidade de itens", "Digite a quantidade de itens desejada")
			    .withSingleLineEdit()
			    .withNegativeAction("Cancelar", (dialog, which) -> dialog.dismiss());
			    myPanDialog.withPositiveAction("Confirmar", new DialogInterface.OnClickListener() {
				    @Override
				    public void onClick(DialogInterface dialog, int which) {
					    EventBus.getDefault().post(new OrderSkuEvent(new OrderSku(product, Integer.parseInt(myPanDialog.getTypedText()))));
					    Snackbar.make(view, "Adicionado no carrinho com sucess", Snackbar.LENGTH_SHORT).show();
				    }
			    });
	    myPanDialog.show();
    }

    public void onDetails(View view){
        //TODO implementar logica do onDetails
    }

    @BindingAdapter("productImage")
    public static void bindProductImage(final ImageView imageView, String imageName){
        Picasso.with(imageView.getContext()).load(Constantes.LOCALHOST_BASE_URL + Constantes.LOCALHOST_UPLOAD_DIR + imageName).into(imageView);
    }
}
