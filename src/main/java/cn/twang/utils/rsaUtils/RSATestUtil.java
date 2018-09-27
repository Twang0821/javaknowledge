package cn.twang.utils.rsaUtils;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;


public class RSATestUtil {

	private static String str = "test";
	private final static String CHARSET = "UTF-8";

	public static String encryptRSA(String s) {
		try {
			RSAPublicKey publicKey = getPublicKey();
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] result = cipher.doFinal(str.getBytes(CHARSET));
			return HexUtil.bytesToHexString(result);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}

	public static String decryptRSA(String s) {
		try {

			RSAPrivateKey privateKey = getPrivKey();
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] result = HexUtil.hexStringToBytes(s);
			result = cipher.doFinal(result);
			return new String(result, CHARSET);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}

	public static RSAPublicKey getPublicKey() {
		String modulus = "87445e375e71cd9f6c35053c2135d02f074f9b384062f1cd37dd949ce34808296c26be1c76ed70b539ec0488ef89378e543b53e034893032c191e6e88c53fb3b709e213144c4f87f25db850eae65efc913c32cea0685225ca892bdf168c9657c18a12b57c64ee01a74dfea2d2dade155f72fd68868b3c40bf81868596590987d";
		String pubExponent = "10001";
		RSAPublicKey pubKey = buildRSAPublicKey(modulus, pubExponent);
		return pubKey;

	}

	public static RSAPrivateKey getPrivKey() {
		String modulus = "87445e375e71cd9f6c35053c2135d02f074f9b384062f1cd37dd949ce34808296c26be1c76ed70b539ec0488ef89378e543b53e034893032c191e6e88c53fb3b709e213144c4f87f25db850eae65efc913c32cea0685225ca892bdf168c9657c18a12b57c64ee01a74dfea2d2dade155f72fd68868b3c40bf81868596590987d";
		String privExponent = "219ec3901d8049ac4337d66a4092e0809fdf9063e5d4f1e6a0e909040995a0b9b2f0da35b6f5831af81f8a6d02a467538fea0309e9e4e33eea4fba45b8833321115db0f4925430bd47d49e1befaca5ecc24075656932f685c6f6fb0920771669a86057727774cfb2d47781a0880330563b9687eceb7b36621b76fc043d723de1";
		RSAPrivateKey privKey = buildRSAPrivateKey(modulus, privExponent);
		return privKey;
	}

	public static RSAPrivateKey buildRSAPrivateKey(String modulus,
			String privateExponent) {
		return buildRSAPrivateKey(new BigInteger(modulus, 16), new BigInteger(
				privateExponent, 16));
	}

	public static RSAPrivateKey buildRSAPrivateKey(BigInteger modulus,
			BigInteger privateExponent) {
		try {
			KeyFactory kf = KeyFactory.getInstance("RSA");
			RSAPrivateKeySpec spec = new RSAPrivateKeySpec(modulus,
					privateExponent);
			return (RSAPrivateKey) kf.generatePrivate(spec);
		} catch (Exception e) {
			throw new IllegalStateException(
					"cannot build private key by modulus and exponent", e);
		}
	}

	public static RSAPublicKey buildRSAPublicKey(String modulus,
			String publicExponent) {
		return buildRSAPublicKey(new BigInteger(modulus, 16), new BigInteger(
				publicExponent, 16));
	}

	public static RSAPublicKey buildRSAPublicKey(BigInteger modulus,
			BigInteger publicExponent) {
		try {
			KeyFactory kf = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec spec = new RSAPublicKeySpec(modulus,
					publicExponent);
			return (RSAPublicKey) kf.generatePublic(spec);
		} catch (Exception e) {
			throw new IllegalStateException(
					"cannot build private key by modulus and exponent", e);
		}
	}

	public static void main(String[] args) {
		// RSAUtil.jskrsa();
		String s = RSATestUtil.encryptRSA(str);
		System.out.println(s);

		// String EncryptPin =
		// "808fc6c850a1063bed40b4f01f1c669142f63298db803ac97b0921f641b0af320884c8559b6b948c593e947df86aa9c194aa7922985b034287d43d2c37541da7853059fc451fc9209e4ab51dd319ad7ccbef2c61d7da3ba61da6ff9db154e1040a30420a72892548b790752a8b09f19befbf028d2001eade360301ce069ae6cf";
		System.out.println(RSATestUtil.decryptRSA(s));
	}

}
