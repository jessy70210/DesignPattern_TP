package fr.ensim.dp.cache.filter;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptFilterCache implements IFilterCache {

    private IFilterCache next;

    private static String passwd = "blablabla";

    @Override
    public byte[] doAdd(String key, byte[] buf) {
        try {
            byte[] bufEncrypt = AESFileCryptoUtil.cryptOrDecryptFile(Cipher.ENCRYPT_MODE, passwd, buf);
            return next != null ? next.doAdd(key, bufEncrypt) : bufEncrypt;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        try {
            return next != null ? AESFileCryptoUtil.cryptOrDecryptFile(Cipher.DECRYPT_MODE, passwd, next.doRetreive(key, buf)) : AESFileCryptoUtil.cryptOrDecryptFile(Cipher.DECRYPT_MODE, passwd, buf);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return buf;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        this.next = next;
        return this.next;
    }
}

final class AESFileCryptoUtil {

    /**
     * Permet de chiffrer ou déchiffrer un fichier
     *
     * @param mode     chiffrer (1) ou déchiffrer (2)
     * @param password Le mot de passe
     * @param input    Le fichier à chiffrer ou à déchiffrer
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IOException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws Exception
     */
    public static byte[] cryptOrDecryptFile(int mode, String password, byte[] input) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {

        SecretKey secret = generateSecretKeyWithPassword(password);

        /* Utilisation de l'algorithme AES */
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(mode, secret);

        /* Chiffre ou déchiffre le contenu du fichier */
        byte[] resultContent = aesCipher.doFinal(input);

        return resultContent;

    }

    /**
     * Génère une clé secrète avec le mot de passe
     *
     * @param password Le mot de passe à transformer en clé de chiffrement
     * @return La clé générée à partir du mot de passe
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static SecretKey generateSecretKeyWithPassword(String password)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {

        /* une clé de 256 bits pour l'algorithme AES-256 */
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        /*
         * On prend les bytes du fichier. Le charset UTF-8 est important en cas
         * d'accentuation des caractères dans le mot de passe
         */
        byte[] key = sha.digest(password.getBytes("UTF-8"));
        SecretKey secret = new SecretKeySpec(key, "AES");
        return secret;
    }

}
