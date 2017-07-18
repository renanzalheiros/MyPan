package zalho.com.br.mypan.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by andrepereira on 16/07/17.
 */

public class CriptoUtil {

	public static String criptoStringMD5(String valor) {
		String texto = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");

			md5.reset();
			md5.update(valor.getBytes());

			byte[] digest = md5.digest();

			BigInteger bigInteger = new BigInteger(1, digest);

			texto = bigInteger.toString();

			while (texto.length() < 32) {
				texto = "0"+texto;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return texto;
	}

}
