package br.com.docodigoaocontrato.taskforge.exception;

import br.com.docodigoaocontrato.taskforge.dto.ErrorResposta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResposta> tratarValidacao(MethodArgumentNotValidException ex) {

        Map<String, String> campos = new LinkedHashMap<>();

        for (FieldError erro : ex.getFieldErrors()) {
            campos.put(erro.getField(), erro.getDefaultMessage());
        }

        ErrorResposta resposta = new ErrorResposta(400, "Dados Inválidos", campos);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResposta> tratarJsonInvalido(HttpMessageNotReadableException ex) {

        ErrorResposta resposta = new ErrorResposta(
                400,
                "JSON inválido: confira a estrutura, vírgulas, chaves, colchetes, aspas",
                Map.of()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErrorResposta> tratarNaoEncontrado(RecursoNaoEncontradoException ex) {

        ErrorResposta resposta = new ErrorResposta(404, ex.getMessage(), Map.of());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
    }

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<ErrorResposta> tratarEmailDuplicado(EmailJaCadastradoException ex) {

        ErrorResposta resposta = new ErrorResposta(409, ex.getMessage(), Map.of());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(resposta);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResposta> tratarErroGenerico(Exception ex) {

        ErrorResposta resposta = new ErrorResposta(500, "Erro interno no servidor", Map.of());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resposta);
    }
}