package com.example.Desafio2.model.repositories;
import com.example.Desafio2.model.entities.Cliente;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Encrypt {

    private Cliente cliente;

    public Encrypt(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void converterCliente(boolean criptografar){
        
        if (cliente.getNome() != ""){   
            if (criptografar){         
                cliente.setNome(this.criptografarDado(cliente.getNome().getBytes()).toString());      
            } else{
                cliente.setNome(this.descriptografarDado(cliente.getNome().getBytes()).toString());
            }
        }

        if (cliente.getNumeroConta() != ""){   
            if (criptografar){         
                cliente.setNumeroConta(this.criptografarDado(cliente.getNumeroConta().getBytes()).toString());      
            } else{
                cliente.setNumeroConta(this.descriptografarDado(cliente.getNumeroConta().getBytes()).toString());
            }
        }

        if (cliente.getCpf() != ""){   
            if (criptografar){         
                cliente.setCpf(this.criptografarDado(cliente.getCpf().getBytes()).toString());      
            } else{
                cliente.setCpf(this.descriptografarDado(cliente.getCpf().getBytes()).toString());
            }
        }

        if (cliente.getAgencia() != ""){   
            if (criptografar){         
                cliente.setAgencia(this.criptografarDado(cliente.getAgencia().getBytes()).toString());      
            } else{
                cliente.setAgencia(this.descriptografarDado(cliente.getAgencia().getBytes()).toString());
            }
        }

        if (cliente.getBanco() != ""){   
            if (criptografar){         
                cliente.setBanco(this.criptografarDado(cliente.getBanco().getBytes()).toString());      
            } else{
                cliente.setBanco(this.descriptografarDado(cliente.getBanco().getBytes()).toString());
            }
        }

        if (cliente.getNumeroConta() != ""){   
            if (criptografar){         
                cliente.setNumeroConta(this.criptografarDado(cliente.getNumeroConta().getBytes()).toString());      
            } else{
                cliente.setNumeroConta(this.descriptografarDado(cliente.getNumeroConta().getBytes()).toString());
            }
        }

        if (cliente.getChavePix() != ""){   
            if (criptografar){         
                cliente.setChavePix(this.criptografarDado(cliente.getChavePix().getBytes()).toString());      
            } else{
                cliente.setChavePix(this.descriptografarDado(cliente.getChavePix().getBytes()).toString());
            }
        }        

    } 

    public byte[] criptografarDado(byte[] texto)
    {
        byte[] textoEncriptado = null;

        try{

            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey chaveDES = keygenerator.generateKey();

            Cipher cifraDES;

            // Cria a cifra
            cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Inicializa a cifra para o processo de encriptação
            cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES);

            // Texto puro
            byte[] textoPuro = "Exemplo de texto puro".getBytes();
            //System.out.println("Texto [Formato de Byte] : " + textoPuro);
            //System.out.println("Texto Puro : " + new String(textoPuro));
            // Texto encriptado
            textoEncriptado = cifraDES.doFinal(texto);
            //System.out.println("Texto Encriptado : " + textoEncriptado);

        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }catch(NoSuchPaddingException e){
            e.printStackTrace();
        }catch(InvalidKeyException e){
            e.printStackTrace();
        }catch(IllegalBlockSizeException e){
            e.printStackTrace();
        }catch(BadPaddingException e){
            e.printStackTrace();
        }

        return textoEncriptado;
    }

    public byte[] descriptografarDado(byte[] texto)
    {
        byte[] textoDecriptografado = null;

        try{

            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey chaveDES = keygenerator.generateKey();

            Cipher cifraDES;
            // Cria a cifra
            cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
            // Inicializa a cifra também para o processo de decriptação
            cifraDES.init(Cipher.DECRYPT_MODE, chaveDES);
            // Decriptografa o texto
            textoDecriptografado = cifraDES.doFinal(texto);
            //System.out.println("Texto Decriptografado : " + new String(textoDecriptografado));

        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }catch(NoSuchPaddingException e){
            e.printStackTrace();
        }catch(InvalidKeyException e){
            e.printStackTrace();
        }catch(IllegalBlockSizeException e){
            e.printStackTrace();
        }catch(BadPaddingException e){
            e.printStackTrace();
        }

        return textoDecriptografado;
    }    
    
}