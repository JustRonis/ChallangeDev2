package com.example.Desafio2.model.repositories;
import com.example.Desafio2.model.entities.Cliente;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;

public class Encrypt {

    private Cliente cliente;

    private static final String SECRET_KEY = "my_super_secret_key";
    private static final String SALT = "ssshhhhhhhhhhh!!!!";

    public Encrypt(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void converterCliente(boolean criptografar) throws InvalidAlgorithmParameterException{
        
        if (cliente.getNome() != ""){   
            if (criptografar){          
                cliente.setNome(this.criptografarDado(cliente.getNome()));   
            } else{
                cliente.setNome(this.descriptografarDado(cliente.getNome()));   
            }
        }

        if (cliente.getTelefone() != ""){   
            if (criptografar){           
                cliente.setTelefone(this.criptografarDado(cliente.getTelefone()));      
            } else{
                cliente.setTelefone(this.descriptografarDado(cliente.getTelefone()));  
            }
        }

        if (cliente.getCpf() != ""){   
            if (criptografar){          
                cliente.setCpf(this.criptografarDado(cliente.getCpf()));    
            } else{
                cliente.setCpf(this.descriptografarDado(cliente.getCpf()));  
            }
        }

        if (cliente.getAgencia() != ""){   
            if (criptografar){         
                cliente.setAgencia(this.criptografarDado(cliente.getAgencia()));      
            } else{
                cliente.setAgencia(this.descriptografarDado(cliente.getAgencia())); 
            }
        }

        if (cliente.getBanco() != ""){   
            if (criptografar){         
                cliente.setBanco(this.criptografarDado(cliente.getBanco()));     
            } else{
                cliente.setBanco(this.descriptografarDado(cliente.getBanco()));
            }
        }

        if (cliente.getNumeroConta() != ""){   
            if (criptografar){          
                cliente.setNumeroConta(this.criptografarDado(cliente.getNumeroConta()));    
            } else{
                cliente.setNumeroConta(this.descriptografarDado(cliente.getNumeroConta()));
            }
        }

        if (cliente.getChavePix() != ""){   
            if (criptografar){         
                cliente.setChavePix(this.criptografarDado(cliente.getChavePix()));     
            } else{
                cliente.setChavePix(this.descriptografarDado(cliente.getChavePix())); 
            }
        }        

    } 

    public String criptografarDado(String texto)
    {

        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            return Base64.getEncoder()
                    .encodeToString(cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }

        return texto;
    }

    public String descriptografarDado(String texto) throws InvalidAlgorithmParameterException
    {

        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);
       
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            var tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
       
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(texto)));
          } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
          }

        return texto;
    }    
    
}