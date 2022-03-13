package com.xkcoding.email;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 * 数据库密码测试
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-08-27 16:15
 */
public class PasswordTest extends SpringBootDemoEmailApplicationTests {

//    @Autowired
//    private StringEncryptor stringEncryptor;

    /**
     * 生成加密密码
     */
    @Test
    public void testGeneratePassword() {
        // 你的邮箱密码
//        String password = "JetVoice123";
//        String password = "spring-boot-demo";
        // 加密后的密码(注意：配置上去的时候需要加 ENC(加密密码))
//        String encryptPassword = stringEncryptor.encrypt(password);
//        String decryptPassword = stringEncryptor.decrypt(encryptPassword);

        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //1.加密所需的salt(盐)，配置值jasypt.encryptor.password
//        textEncryptor.setPassword("eEvQCS8beYd6h4a5");
        textEncryptor.setPassword("JetVoice");
//        System.out.println("加密账号:" + textEncryptor.encrypt("root"));
//        System.out.println("加密密码:" + textEncryptor.encrypt("123456"));

//        String encryptPassword = textEncryptor.encrypt("eEvQCS8beYd6h4a5");
        String decryptPassword = textEncryptor.decrypt("Uq5K0JKtt4fTYi6+04FkK2MjiFNiM//KcmDZBjmAmyI=");

        System.out.println("salt = " + "JetVoice");
//        System.out.println("encryptPassword = " + encryptPassword);
        System.out.println("decryptPassword = " + decryptPassword);
    }

//    @Bean("jasyptStringEncryptor")
//    public StringEncryptor stringEncryptor() {
//        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//        config.setPassword("eEvQCS8beYd6h4a5");
//        config.setAlgorithm("PBEWithMD5AndDES");
//        config.setKeyObtentionIterations("1000");
//        config.setPoolSize("1");
//        config.setProviderName("SunJCE");
//        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//        config.setIvGeneratorClassName("org.jasypt.salt.NoOpIVGenerator");
//        config.setStringOutputType("base64");
//        // 5f/30f1h7GYNDBUV9UfSQgsueAVEDLUE0QnpKNmUTHE=
//        encryptor.setConfig(config);
//        return encryptor;
//    }

    @Test
    public void testEncrypt() throws Exception {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        config.setAlgorithm("PBEWithMD5AndDES");          // 加密的算法，这个算法是默认的
        config.setPassword("JetVoice");                        // 加密的密钥，随便自己填写，很重要千万不要告诉别人
        standardPBEStringEncryptor.setConfig(config);
        String plainText = "eEvQCS8beYd6h4a5";         //自己的密码
        String encryptedText = standardPBEStringEncryptor.encrypt(plainText);
        System.out.println(encryptedText);
    }

}
