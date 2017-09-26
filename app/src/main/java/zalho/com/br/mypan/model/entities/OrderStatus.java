package zalho.com.br.mypan.model.entities;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static zalho.com.br.mypan.util.Constantes.AGUARDANDO_APROVACAO;
import static zalho.com.br.mypan.util.Constantes.PRODUZINDO;
import static zalho.com.br.mypan.util.Constantes.PRONTO;
import static zalho.com.br.mypan.util.Constantes.REJEITADO;

/**
 * Created by andrepereira on 24/09/17.
 */

@StringDef({AGUARDANDO_APROVACAO, PRODUZINDO, REJEITADO, PRONTO})
@Retention(RetentionPolicy.SOURCE)
public @interface OrderStatus {
}
