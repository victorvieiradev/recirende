package com.Recirende.Fidelidade.Exception;

public class ProdutoNaoEncontradoException extends Exception{
    public ProdutoNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProdutoNaoEncontradoException(String message) {
        super(message);
    }
}
